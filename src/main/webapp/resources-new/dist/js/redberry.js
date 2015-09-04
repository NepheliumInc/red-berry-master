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
                    ko.applyBindings(eval('new '+menuHash+'ViewModel'), document.getElementById('content'));
                }else{
                    ko.applyBindings(eval('new '+menuHash+'ViewModel'),document.getElementById('content'));
                }
            });
            }
        });

        this.get('', function() { this.app.runRoute('get', '#dashboard') });
    }).run();
}

var sidebar = new SideBarViewModel;
ko.applyBindings(sidebar,document.getElementById('admin-sidebar'));
ko.applyBindings(sidebar,document.getElementById('content-header'));


/*Room Checking Script block  ################################################## Start */

var Room = function(no, show) {
    var Rself = this;
    Rself.no = ko.observable(no);
    Rself.category = ko.observableArray(['Duplex','Cabana','luxury']);
    Rself.AC = ko.observableArray(['NO','YES']);
    Rself.occupancy = ko.observableArray(['Available','Occupied','Cleaning']);
    Rself.mealConfig = ko.observableArray(['Full-Board','Half-Board', 'All Inclusive']);
    Rself.show = ko.observable(show);
};



function checkinViewModel(){
    var self = this;
    self.checkInToOut = ko.observable();
    self.name = ko.observable();
    self.address = ko.observable();
    self.nic = ko.observable();
    self.email = ko.observable();
    self.telephone = ko.observable();
    self.noOfRooms = ko.observable(1);


    self.Rooms = ko.observableArray([
        new Room(1,true)
    ]);

    self.TravelSources = ko.observableArray(['none','Lanka Tours','Sri Tours','Sl Tour Guide','Jhon Snow']);

    self.initialiseUI =function(){
        $('#checkInToOut').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});

        $('#roomcheckin').formValidation({
            framework: 'bootstrap',
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                checkInToOut: {
                    row: '.col-md-8',
                    validators: {
                        notEmpty: {
                            message: 'The Checking Checkout Date Range is required'
                        }
                    }
                },
                email: {
                    row: '.col-md-3',
                    validators: {
                        notEmpty: {
                            message: 'The email address is required'
                        },
                        emailAddress: {
                            message: 'The input is not a valid email address'
                        }
                    }
                }
            }
        });
    };

    self.roomSelect = function(room){
        ko.utils.arrayFirst(self.Rooms(), function(r) {
            r.show(false);
            if(r.no() == room.no()){
                r.show(true);
            }
        });

    };

    self.goToSecondStep = function(){
        this.Rooms([new Room(1,true)]);
        $('#checkinTabs a[href="#tab_2"]').tab('show');
        for(var i=2;i<=self.noOfRooms();i++){

            self.Rooms.push(new Room(i,false));
        }
    };
    }



/*Room Checking Script block ################################################## End */


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
