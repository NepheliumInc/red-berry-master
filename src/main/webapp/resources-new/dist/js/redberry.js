/* #Employee */

/*function SideBarViewModel(){
    var self = this;
    self.menuItems = [
        {name:'home',icon:'fa-home',dispalyName:'Home'},
        {name:'checkin',icon:'fa-shopping-cart',dispalyName:'Check In'},
        {name:'employee',icon:'fa-eye',dispalyName:'Employee'},
        {name:'travelagent',icon:'fa-user-plus',dispalyName:'Travel Agent Setup'}
    ];

    self.chosenFolderId = ko.observable();
    self.chosenFolderData = ko.observable();

    // Behaviours
    self.goToFolder = function(menuItem) {
        jQuery.ajax({
            url: "/resources-new/"+menuItem.name +".html",
            method: "GET",
            dataType: "html",
            success: function (data) {
                $('#content').html(data);
            }
        });


        //location.hash = menuItem.name
    };

    // Client-side routes
    Sammy(function() {
        this.get('/#:menuHash', function() {

            var menuHash = this.params.menuHash;
            var checkMenu = $.grep(self.menuItems, function (n) { return n.name == menuHash });
            if(checkMenu.length){
            /!*$.get('templates/'+menuHash+'.html', function(uidata) {
                self.chosenFolderId(menuHash);
                $('#template_holder').html(uidata);
                var vm = ko.dataFor(document.getElementById('content'));
                if( vm ) {
                    ko.cleanNode(document.getElementById('content'));
                    ko.applyBindings(eval('new '+menuHash+'ViewModel'), document.getElementById('content'));
                }else{
                    ko.applyBindings(eval('new '+menuHash+'ViewModel'),document.getElementById('content'));
                }
            });*!/
            }
        });

        this.get('', function() { this.app.runRoute('get', '#dashboard') });
    }).run();
}

var sidebar = new SideBarViewModel;
ko.applyBindings(sidebar,document.getElementById('admin-sidebar'));
ko.applyBindings(sidebar,document.getElementById('content-header'));

/!*@Room Checking Script block  ################################################## Start *!/

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
/!*Room Checking Script block ################################################## End *!/





function homeViewModel(){
    var self = this;
    self.initialiseUI = function(){

    }
}




/!* #Employee Script block ################################################## Start *!/
var employeeViewModel = function () {
    var self = this;

    self.id = ko.observable();
    self.fullName = ko.observable();
    self.residentialAddress = ko.observable();
    self.permanentAddress = ko.observable();
    self.residentialPhone = ko.observable();
    self.permanentPhone = ko.observable();
    self.email = ko.observable();
    self.dob = ko.observable();
    self.joinedDate = ko.observable();
    self.prevExperience = ko.observable();
    self.commentsFromPrevWorkPlace = ko.observable();
    self.startingSalary = ko.observable();
    self.emergencyContact = ko.observable();
    self.imageURL = ko.observable();
    self.nic = ko.observable();

    //load employees from database

    self.employees = ko.observableArray();

    self.loadEmployees = function(){


    }



    //remove an employee

    self.removeEmp = function () {

        var r = confirm("Do you realy want to remove this employee?");
        if (r == true) {
            //alert(JSON.stringify(self.employees()[self.employees.indexOf(this)]));
            jQuery.ajax({
                url: "/redberry/services/employee/deleteemployee",
                method: "DELETE",
                dataType: "JSON",
                contentType: "application/json",
                data: JSON.stringify(self.employees()[self.employees.indexOf(this)]),
                success: function (data) {
                    //(data);
                }
            });
            self.employees.remove(this);
        }


    }




    //view an employee

    self.viewEmp = function () {
        self.id(this.id);
        self.fullName(this.fullName);
        self.residentialAddress(this.residentialAddress);
        self.permanentAddress(this.permanentAddress);
        self.residentialPhone(this.residentialPhone);
        self.permanentPhone(this.permanentPhone);
        self.email(this.email);
        self.dob(this.dob);
        self.joinedDate(this.joinedDate);
        self.prevExperience(this.prevExperience);
        self.commentsFromPrevWorkPlace(this.commentsFromPrevWorkPlace);
        self.startingSalary(this.startingSalary);
        self.emergencyContact(this.emergencyContact);
        self.imageURL(this.imageURL);
        self.nic(this.nic);

        $('#modal-1').modal('toggle');
    }
}

self.initialiseUI =function(){
    jQuery.ajax({
        url: "/redberry/services/employee/getemployees",
        method: "GET",
        dataType: "JSON",
        success: function (data) {
            self.employees();
        }
    });
}*/

/*Employee Script block ################################################## End */




/*
function addEmployeeViewModel() {
    this.fullName = ko.observable();
    this.email = ko.observable();
    this.nic = ko.observable();
    this.residentialPhone = ko.observable();
    this.permanentPhone = ko.observable();
    this.startingSalary = ko.observable();
    this.residentialAddress = ko.observable();
    this.permanentAddress = ko.observable();
    this.dob = ko.observable();
    this.joinedDate = ko.observable();
    this.prevExperience = ko.observable();
    this.commentsFromPrevWorkPlace = ko.observable();
    this.emergencyContact = ko.observable();
}

// Activates knockout.js
var employeeModel = new addEmployeeViewModel();
ko.applyBindings(employeeModel);

function makeEmployeeJSON() {
    return ko.toJSON(employeeModel);
}


function sendEmployeeRequest(){

    $.ajax({
        type: 'POST',
        url: '/redberry/services/employee/addemployee',
        contentType: 'application/json',
        dataType: 'JSON',
        data: makeEmployeeJSON(),


    });

    $('#modal-1').modal('hide');
    window.location.href='employee.html';

}
*/












/*Travel Agent Script block ################################################## Start */
/*function travelagentViewModel(){
    var self = this;
    self.travelAgents = ko.observableArray([
        { agentName: 'Bert', agentAdd: 'Matara',agentPhone: '0716508688',agentEmail: 'Bertington@gmail.com',agentRates: '70' },
        { agentName: 'Charles', agentAdd: 'Galle',agentPhone: '0711438622',agentEmail: 'Charles@gmail.com',agentRates: '80' },
        { agentName: 'Denise', agentAdd: 'Colombo',agentPhone: '0718210189',agentEmail: 'Denis@gmail.com',agentRates: '50'}
    ]);
    self.removeAgent = function(a) {
        travelAgents.remove(a)
    }
    self.addPerson = function() {
        self.travelAgents.push( { agentName: 'lakshan', agentAdd: 'Matara',agentPhone: '0716508688',agentEmail: 'Bertington@gmail.com',agentRates: '70' })
    }

    self.initialiseUI =function(){
        $("#travelAgentDetails").dataTable({
            "columnDefs": [ {
                "targets": 'no-sort',
                "orderable": false,
            } ]

        });
    }
}*/
/*Travel Agent Script block ################################################## End */



