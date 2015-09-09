function SideBarViewModel(){
    var self = this;
    self.menuItems = [
        {name:'dashboard',icon:'fa-home',dispalyName:'DashBoard'},
        {name:'checkin',icon:'fa-shopping-cart',dispalyName:'Check In'},

        {name:'employee',icon:'fa-eye',dispalyName:'Employee'},
        {name:'travelAgent',icon:'fa-user-plus',dispalyName:'Travel Agent Setup'},];

    self.chosenFolderId = ko.observable();
    self.chosenFolderData = ko.observable();

    // Behaviours
    self.goToFolder = self.goToFolder = function(menuItem) { location.hash = menuItem.name };

    // Client-side routes
    Sammy(function() {
        this.get('#:menuItem', function() {
            self.chosenFolderId(this.params.menuItem);

            var item = this.params.menuItem;

            $.get('templates/'+item+'.html', function(uidata) {
                $('#template_holder').html(uidata);
                var vm = ko.dataFor(document.getElementById('content'));
                if( vm ) {
                    ko.cleanNode(document.getElementById('content'));
                    ko.applyBindings(eval(item+'ViewModel'), document.getElementById('content'));
                }else{
                    ko.applyBindings(eval(item+'ViewModel'),document.getElementById('content'));
                }
            });
        });

        this.get('', function() { this.app.runRoute('get', '#dashboard') });
    }).run();
};
var sidebar = new SideBarViewModel
ko.applyBindings(sidebar,document.getElementById('admin-sidebar'));
ko.applyBindings(sidebar,document.getElementById('content-header'));



var checkinViewModel = {
    checkInToOut: ko.observable(),
    name: ko.observable(),
    address: ko.observable(),
    nic: ko.observable(),
    email: ko.observable(),
    telephone: ko.observable(),
    Rooms: ko.observableArray([]),

    TravelSources: ko.observableArray(['none','Lanka Tours','Sri Tours','Sl Tour Guide','Jhon Snow']),
    category: ko.observableArray(['dulux','supper','luxury']),
    ac: ko.observableArray(['none','Lanka Tours','Sri Tours','Sl Tour Guide','Jhon Snow']),
    meal: ko.observableArray(['none','Lanka Tours','Sri Tours','Sl Tour Guide','Jhon Snow']),
    occupancy: ko.observableArray(['none','Lanka Tours','Sri Tours','Sl Tour Guide','Jhon Snow']),

    initCheckIn:function(){
        $('#checkInToOut').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
    },

    goToSecondStep: function(){
        $('#checkinTabs a[href="#tab_2"]').tab('show')
    }
};

var dashboardViewModel = {
    seasons: ko.observableArray([
        { name: 'Spring', months: [ 'March', 'April', 'May' ] },
        { name: 'Summer', months: [ 'June', 'July', 'August' ] },
        { name: 'Autumn', months: [ 'September', 'October', 'November' ] },
        { name: 'Winter', months: [ 'December', 'January', 'February' ] }
    ]),
    initCheckIn:function(){
        $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
    }
};

var travelAgentViewModel= {

    travelAgents:ko.observableArray(),

    fullName:ko.observable(),
    address:ko.observable(),
    phoneNo:ko.observable(),
    email:ko.observable(),
    bankName:ko.observable(),
    accountNo:ko.observable(),
    accountName:ko.observable(),
    accountBranch:ko.observable(),
    rates:ko.observable(),

    editing:ko.observable(false),
    edit:function() { this.editing(true) },

    loadTravelAgents:function(){
    jQuery.ajax({
        url: "/redberry/services/travelAgent/gettravelagents",
        method: "GET",
        dataType: "JSON",
        success: function (data){
            this.travelAgents(data);
        }
     })
    },

    removeAgent:function(a) {

        var check = confirm("Do you realy want to remove this Agent?");
        if (check == true) {

            jQuery.ajax({
                url: "/redberry/services/travelAgent/deletetravelagent",
                method: "DELETE",
                dataType: "JSON",
                contentType: "application/json",
                data: JSON.stringify(this.travelAgents()[this.travelAgents.indexOf(this)]),
                success: function (data) {

                    alert(data);
                }
            });
            this.travelAgents.remove(a);
        }
    },

    initCheckIn:function(){
       new loadTravelAgents();
    }

};














