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



var checkinViewModel = {
    checkInToOut: ko.observable(),
    name: ko.observable(),
    address: ko.observable(),
    nic: ko.observable(),
    email: ko.observable(),
    telephone: ko.observable(),
    noOfRooms: ko.observable(),

    Rooms: ko.observableArray([
        { no: 1, category: ['dulux','supper','luxury'] , AC: ['NO','YES'], occupancy:'' ,mealConfig:['Vegetarian', 'non vege']},
        { no: 2, category: ['dulux','supper','luxury'] , AC: ['NO','YES'], occupancy:'' ,mealConfig:['Vegetarian', 'non vege']}
    ]),

    TravelSources: ko.observableArray(['none','Lanka Tours','Sri Tours','Sl Tour Guide','Jhon Snow']),


    initialiseUI:function(){
        $('#checkInToOut').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});

        $('body #interest_tabs').on('click', 'a[data-toggle="tab"]', function(e) {
            e.preventDefault();

            var $link = $(this);

            if (!$link.parent().hasClass('active')) {

                //remove active class from other tab-panes
                $('.tab-content:not(.' + $link.attr('href').replace('#','') + ') .tab-pane').removeClass('active');

                // click first submenu tab for active section
                $('a[href="' + $link.attr('href') + '_all"][data-toggle="tab"]').click();

                // activate tab-pane for active section
                $('.tab-content.' + $link.attr('href').replace('#','') + ' .tab-pane:first').addClass('active');
            }

        });
    },


    goToSecondStep: function(){
        this.Rooms.destroyAll();
        $('#checkinTabs a[href="#tab_2"]').tab('show');
        for(i=1;i<=this.noOfRooms();i++){
            this.Rooms.push({no: i, category: ['dulux','supper','luxury'] , AC: ['NO','YES'], occupancy:'' ,mealConfig:['Vegetarian', 'non vege']});
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
