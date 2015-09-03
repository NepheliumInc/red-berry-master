function SideBarViewModel(){
    var self = this;
    self.menuItems = [
        {name:'dashboard',icon:'fa-home',dispalyName:'DashBoard'},
        {name:'checkin',icon:'fa-shopping-cart',dispalyName:'Check In'},
        {name:'employee',icon:'fa-eye',dispalyName:'Employee'}];

    self.chosenFolderId = ko.observable();
    self.chosenFolderData = ko.observable();

    // Behaviours
    self.goToFolder = self.goToFolder = function(menuItem) {
        location.hash = menuItem.name
    };

    // Client-side routes
    Sammy(function() {
        this.get('/#:menuHash', function() {

            var menuHash = this.params.menuHash;
            var checkMenu = $.grep(self.menuItems, function (n) { return n.name == menuHash });
            if(checkMenu.length){
            $.get('templates/'+menuHash+'.html', function(uidata) {
                self.chosenFolderId(menuHash);
                $('#template_holder').html(uidata);
                var vm = ko.dataFor(document.getElementById('content'));
                if( vm ) {
                    ko.cleanNode(document.getElementById('content'));
                    ko.applyBindings(eval(menuHash+'ViewModel'), document.getElementById('content'));
                }else{
                    ko.applyBindings(eval(menuHash+'ViewModel'),document.getElementById('content'));
                }
            });
            }
        });

        this.get('', function() { this.app.runRoute('get', '#dashboard') });
    }).run();
};
var sidebar = new SideBarViewModel
ko.applyBindings(sidebar,document.getElementById('admin-sidebar'));
ko.applyBindings(sidebar,document.getElementById('content-header'));


var Room = function(no, show) {
    var self = this;
    self.no = ko.observable(no);
    self.category = ko.observableArray(['dulux','supper','luxury']);
    self.AC = ko.observableArray(['NO','YES']);
    self.occupancy = ko.observableArray(['yes','no']);
    self.mealConfig = ko.observableArray(['Vegetarian', 'non vege']);
    self.show = ko.observable(show);
};



var checkinViewModel = {
    checkInToOut: ko.observable(),
    name: ko.observable(),
    address: ko.observable(),
    nic: ko.observable(),
    email: ko.observable(),
    telephone: ko.observable(),
    noOfRooms: ko.observable(1),


    Rooms: ko.observableArray([
        new Room(1,true)
    ]),

    TravelSources: ko.observableArray(['none','Lanka Tours','Sri Tours','Sl Tour Guide','Jhon Snow']),


    initialiseUI:function(){
        $('#checkInToOut').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});

    },


    roomSelect: function(room){
        var r = ko.utils.arrayFirst(this.Rooms, function(r) {
            return r.no == room.no;
        });

        if (r.show) {
            alert(r.show);
            r.show(false);
        }else{
            r.show(true);
        }
    },

    goToSecondStep: function(){
        this.Rooms([new Room(1,true)]);
        $('#checkinTabs a[href="#tab_2"]').tab('show');
        for(i=2;i<=this.noOfRooms();i++){
            //this.Rooms.push({no: i, category: ['dulux','supper','luxury'] , AC: ['NO','YES'], occupancy:['yes','no'] ,mealConfig:['Vegetarian', 'non vege'],show:false});
            this.Rooms.push(new Room(i,false));
        }
    }
};

var dashboardViewModel = {
    seasons: ko.observableArray([
        { name: 'Spring', months: [ 'March', 'April', 'May' ] },
        { name: 'Summer', months: [ 'June', 'July', 'August' ] },
        { name: 'Autumn', months: [ 'September', 'October', 'November' ] },
        { name: 'Winter', months: [ 'December', 'January', 'February' ] }
    ]),
    initialiseUI:function(){

    }
};


var employeeViewModel= function (){
    var self = this;
self.current = ko.observableArray([]);
self.employees = ko.observableArray();
self.removeEmp = function () {

    var r = confirm("Do you realy want to remove this employee?");
    if (r == true) {
        alert(JSON.stringify(self.employees()[self.employees.indexOf(this)]));
        jQuery.ajax({
            url: "/redberry/services/employee/deleteemployee",
            method: "DELETE",
            dataType: "JSON",
            contentType: "application/json",
            data: JSON.stringify(self.employees()[self.employees.indexOf(this)]),
            success: function (data) {

                alert(data);
            }
        });
        self.employees.remove(this);
    }


}
self.viewEmp = function () {
    self.current = ko.mapping.fromJSON(self.employees()[self.employees.indexOf(this)]);

    //alert(self.current.fullName);
    $('#modal-1').modal('toggle');
}

    self.initCheckIn = function(){

    }
}
