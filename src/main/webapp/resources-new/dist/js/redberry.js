function SideBarViewModel() {
    var self = this;
    self.menuItems = [
        {name: 'dashboard', icon: 'fa-home', dispalyName: 'DashBoard'},
        {name: 'checkin', icon: 'fa-shopping-cart', dispalyName: 'Check In'},
        {name: 'checkin', icon: 'fa-shopping-cart', dispalyName: 'Check In'},
        {name: 'employee', icon: 'fa-eye', dispalyName: 'Employee'}];

    self.chosenFolderId = ko.observable();
    self.chosenFolderData = ko.observable();

    // Behaviours
    self.goToFolder = self.goToFolder = function (menuItem) {
        location.hash = menuItem.name
    };

    // Client-side routes
    Sammy(function () {
        this.get('#:menuItem', function () {
            self.chosenFolderId(this.params.menuItem);

            var item = this.params.menuItem;

            $.get('templates/' + item + '.html', function (uidata) {
                $('#template_holder').html(uidata);
                var vm = ko.dataFor(document.getElementById('content'));
                if (vm) {
                    ko.cleanNode(document.getElementById('content'));
                    ko.applyBindings(eval(item + 'ViewModel'), document.getElementById('content'));
                } else {
                    ko.applyBindings(eval(item + 'ViewModel'), document.getElementById('content'));
                }
            });
        });

        this.get('', function () {
            this.app.runRoute('get', '#dashboard')
        });
    }).run();
};
var sidebar = new SideBarViewModel
ko.applyBindings(sidebar, document.getElementById('admin-sidebar'));
ko.applyBindings(sidebar, document.getElementById('content-header'));


var checkinViewModel = {
    checkInToOut: ko.observable(),
    name: ko.observable(),
    address: ko.observable(),
    nic: ko.observable(),
    email: ko.observable(),
    telephone: ko.observable(),
    Rooms: ko.observableArray([]),

    TravelSources: ko.observableArray(['none', 'Lanka Tours', 'Sri Tours', 'Sl Tour Guide', 'Jhon Snow']),
    category: ko.observableArray(['dulux', 'supper', 'luxury']),
    ac: ko.observableArray(['none', 'Lanka Tours', 'Sri Tours', 'Sl Tour Guide', 'Jhon Snow']),
    meal: ko.observableArray(['none', 'Lanka Tours', 'Sri Tours', 'Sl Tour Guide', 'Jhon Snow']),
    occupancy: ko.observableArray(['none', 'Lanka Tours', 'Sri Tours', 'Sl Tour Guide', 'Jhon Snow']),

    initCheckIn: function () {
        $('#checkInToOut').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
    },

    goToSecondStep: function () {
        $('#checkinTabs a[href="#tab_2"]').tab('show')
    }
};

var dashboardViewModel = {
    seasons: ko.observableArray([
        {name: 'Spring', months: ['March', 'April', 'May']},
        {name: 'Summer', months: ['June', 'July', 'August']},
        {name: 'Autumn', months: ['September', 'October', 'November']},
        {name: 'Winter', months: ['December', 'January', 'February']}
    ]),
    initCheckIn: function () {
        $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
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
