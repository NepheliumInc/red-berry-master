
ko.observableArray.fn.subscribeArrayChanged = function(addCallback, deleteCallback) {
    var previousValue = undefined;
    this.subscribe(function(_previousValue) {
        previousValue = _previousValue.slice(0);
    }, undefined, 'beforeChange');
    this.subscribe(function(latestValue) {
        var editScript = ko.utils.compareArrays(previousValue, latestValue);
        for (var i = 0, j = editScript.length; i < j; i++) {
            switch (editScript[i].status) {
                case "retained":
                    break;
                case "deleted":
                    if (deleteCallback)
                        deleteCallback(editScript[i].value);
                    break;
                case "added":
                    if (addCallback)
                        addCallback(editScript[i].value);
                    break;
            }
        }
        previousValue = undefined;
    });
};


// Person object
var Person = function(data, dt) {
    this.id    = data.id;
    this.first = ko.observable(data.first);
    this.last  = ko.observable(data.last);
    this.age   = ko.observable(data.age);
    this.full  = ko.computed(function() {
        return this.first() + " " + this.last();
    }, this);

    // Subscribe a listener to the observable properties for the table
    // and invalidate the DataTables row when they change so it will redraw
    var that = this;
    $.each( [ 'first', 'last', 'age' ], function (i, prop) {
        that[ prop ].subscribe( function (val) {
            // Find the row in the DataTable and invalidate it, which will
            // cause DataTables to re-read the data
            var rowIdx = dt.column( 0 ).data().indexOf( that.id );
            dt.row( rowIdx ).invalidate();
        } );
    } );
};



// Initial data set
var data = [
    { id: 0, first: "Allan", last: "Jardine", age: 86 },
    { id: 1, first: "Bob", last: "ghj", age: 54 },
    { id: 2, first: "Bob", last: "kl", age: 54 },
    { id: 3, first: "er", last: "dfg", age: 54 },
    { id: 4, first: "dfg", last: "ghj", age: 54 },
    { id: 5, first: "sfsd", last: "rty", age: 54 },
    { id: 6, first: "Bob", last: "cv", age: 54 },
    { id: 7, first: "sdf", last: "fgh", age: 54 },
    { id: 8, first: "Bob", last: "bvb", age: 54 },
    { id: 9, first: "sdf", last: "nnmb", age: 54 },
    { id: 10, first: "er", last: "dfg", age: 54 },
    { id: 11, first: "dfg", last: "ghj", age: 54 },
    { id: 12, first: "sfsd", last: "rty", age: 54 },
    { id: 13, first: "Bob", last: "cv", age: 54 },
    { id: 14, first: "sdf", last: "fgh", age: 54 },
    { id: 15, first: "Bob", last: "bvb", age: 54 },
    { id: 16, first: "sdf", last: "nnmb", age: 54 },
    { id: 17, first: "Bob", last: "bnnn", age: 54 },
    { id: 18, first: "Bob", last: "hjj", age: 54 }
];



// CheckOuts object
var CheckOut = function(data, dt) {
    this.id    = data.id;
    this.CheckOutTime = ko.observable(data.CheckOutTime);
    this.CheckOutDate = ko.observable(data.CheckOutDate);
    this.CustomerName  = ko.observable(data.CustomerName);
    this.NumberOfRooms   = ko.observable(data.NumberOfRooms);
    this.Charge  = ko.observable(data.Charge);

    // Subscribe a listener to the observable properties for the table
    // and invalidate the DataTables row when they change so it will redraw
    var that = this;
    $.each( [ 'CheckOutTime','CheckOutDate', 'CustomerName', 'NumberOfRooms', 'Charge' ], function (i, prop) {
        that[ prop ].subscribe( function (val) {
            // Find the row in the DataTable and invalidate it, which will
            // cause DataTables to re-read the data
            var rowIdx = dt.column( 0 ).data().indexOf( that.id );
            dt.row( rowIdx ).invalidate();
        } );
    } );
};


// Initial data set
var data2 = [
    { id: 0, CheckOutTime: "00630h", CheckOutDate: "13th November 2015", CustomerName: "Jardine", NumberOfRooms: 2 , Charge : "1200.00"},
    { id: 1, CheckOutTime: "00730h", CheckOutDate: "13th November 2015", CustomerName: "dfgdfg", NumberOfRooms: 2 , Charge : "1900.00"},
    { id: 2, CheckOutTime: "00830h", CheckOutDate: "13th November 2015", CustomerName: "kyjhkjk", NumberOfRooms: 3 , Charge : "12000.00"},
    { id: 3, CheckOutTime: "00930h", CheckOutDate: "13th November 2015", CustomerName: "ghjghj", NumberOfRooms: 1 , Charge : "7200.00"},
    { id: 4, CheckOutTime: "01030h", CheckOutDate: "13th November 2015", CustomerName: "nvbn", NumberOfRooms: 1 , Charge : "8200.00"}
];



$(document).ready(function() {
    var people = ko.mapping.fromJS( [] );
    var dt = $('#example').DataTable( {
        "scrollY":        "100px",
        "scrollCollapse": true,
        "dom": 'rt',
        "paging":         false,
        columns: [
            { data: 'id' },
            { data: 'first()' },
            { data: 'age()' }
        ]
    } );

    $('#myInputTextField').keyup(function(){
        dt.search($(this).val()).draw() ;
    });

    // Update the table when the `people` array has items added or removed
    people.subscribeArrayChanged(
        function ( addedItem ) {
            dt.row.add( addedItem ).draw();
        },
        function ( deletedItem ) {
            var rowIdx = dt.column( 0 ).data().indexOf( deletedItem.id );
            dt.row( rowIdx ).remove().draw();
        }
    );

    // Convert the data set into observable objects, and will also add the
    // initial data to the table
    ko.mapping.fromJS(
        data,
        {
            key: function(data) {
                return ko.utils.unwrapObservable(data.id);
            },
            create: function(options) {
                return new Person(options.data, dt);
            }
        },
        people
    );




   // CheckOuts




    var CheckOuts = ko.mapping.fromJS( [] );
    var CheckOutsdt = $('#CheckOuts').DataTable( {
        "scrollY":        "100px",
        "scrollCollapse": true,
        "dom": 'rt',
        "paging":         false,
        columns: [
            { data: 'CheckOutTime()' },
            { data: 'CheckOutDate()' },
            { data: 'CustomerName()' },
            { data: 'NumberOfRooms()' },
            { data: 'Charge()' }
        ],
        "columnDefs": [
            {
                "render": function ( data, type, row ) {
                    return '<span class="redberry-datetime"><p>' + data +'</p>'+ row.CheckOutDate() + '</span>';
                },
                "targets": 0
            },
            { "visible": false,  "targets": [ 1 ] }
        ]
    } );

    $('#CheckOutsSearch').keyup(function(){
        CheckOutsdt.search($(this).val()).draw() ;
    });

    // Update the table when the `people` array has items added or removed
    CheckOuts.subscribeArrayChanged(
        function ( addedItem ) {
            CheckOutsdt.row.add( addedItem ).draw();
        },
        function ( deletedItem ) {
            var rowIdx = CheckOutsdt.column( 0 ).data().indexOf( deletedItem.id );
            CheckOutsdt.row( rowIdx ).remove().draw();
        }
    );

    // Convert the data set into observable objects, and will also add the
    // initial data to the table
    ko.mapping.fromJS(
        data2,
        {
            key: function(data) {
                return ko.utils.unwrapObservable(data.id);
            },
            create: function(options) {
                return new CheckOut(options.data, CheckOutsdt);
            }
        },
        CheckOuts
    );


    /*
    // Examples:

    // Update a field
    people()[1].first( 'Allan3' );

    // Add an item
    people.push( new Person( {
        id: 19,
        first: "John",
        last: "Smith",
        age: 34
    }, dt ) );

    // Remove an item
    people.shift();*/

} );













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



