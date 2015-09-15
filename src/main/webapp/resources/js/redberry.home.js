/**
 * Created by kokila on 7/21/15.
 */

jQuery(document).ready(function() {
// Class to represent a row in the seat reservations grid
    function TodayCheckin(time, date, sourceName, imagePath, customerName, noOfRooms) {
        var self = this;
        self.time = time;
        self.date = date;
        self.sourceName = sourceName;
        self.imagePath = imagePath;
        self.customerName = customerName;
        self.noOfRooms = noOfRooms;
    }

// Overall viewmodel for this screen, along with initial state
    function HomeViewModel() {
        var self = this;

        // Non-editable catalog data - would come from the server
        self.checkinsJson = [
            {
                time: "00630h",
                date: "13th November 2015",
                sourceName: "OTA",
                imagePath: "http://99designs.com/logo-design/store/10072/preview/4717686~3005bdc10f70eba299c402e4c42401112d046f9c-stocklarge",
                customerName: "Kokila",
                noOfRooms: 4
            },
            {
                time: "00640h",
                date: "14th November 2015",
                sourceName: "OTA",
                imagePath: "http://99designs.com/logo-design/store/10072/preview/4717686~3005bdc10f70eba299c402e4c42401112d046f9c-stocklarge",
                customerName: "Amila",
                noOfRooms: 2
            },
            {
                time: "00655h",
                date: "15th November 2015",
                sourceName: "OKLA",
                imagePath: "http://99designs.com/logo-design/store/10072/preview/4717686~3005bdc10f70eba299c402e4c42401112d046f9c-stocklarge",
                customerName: "Janath",
                noOfRooms: 8
            },
            {
                time: "00658h",
                date: "16th November 2015",
                sourceName: "OTA",
                imagePath: "http://99designs.com/logo-design/store/10072/preview/4717686~3005bdc10f70eba299c402e4c42401112d046f9c-stocklarge",
                customerName: "Anjula",
                noOfRooms: 2
            }
        ];

        // Editable data
        self.checkin = ko.observableArray();

        for(var i = 0; i < self.checkinsJson.length; i++){
            self.checkin.push(new TodayCheckin(self.checkinsJson[i]['time'], self.checkinsJson[i]['date'], self.checkinsJson[i]['sourceName'], self.checkinsJson[i]['imagePath'], self.checkinsJson[i]['customerName'], self.checkinsJson[i]['customerName']));
        }

    }



    ko.applyBindings(new HomeViewModel());

    jQuery('#checkins').dataTable( {
        "bScrollInfinite": true,
        "bScrollCollapse": true,
        "sScrollY": "300px",
        'sDom': '"top"'
    });
    jQuery('#spec_offers').dataTable( {
        "bScrollInfinite": true,
        "bScrollCollapse": true,
        "sScrollY": "200px",
        'sDom': '"top"'
    });
    jQuery('#checkouts').dataTable( {
        "bScrollInfinite": true,
        "bScrollCollapse": true,
        "sScrollY": "200px",
        'sDom': '"top"'
    });

});
