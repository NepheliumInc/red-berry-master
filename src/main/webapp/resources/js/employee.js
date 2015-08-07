jQuery(document).ready(function(){

    jQuery("#dob").datepicker();
    jQuery("#joinedDate").datepicker();
    jQuery('.image-editor').cropit();

/*
* validation methods are here
* http://jqueryvalidation.org/category/methods/
* */


    jQuery("#addEmployee").validate({
        rules: {
            name: {
                required: true,
                minlength: 5,
                maxlength: 150,
            },
            email: {
                required: true,
                email: true,
            },

            e_telephone:{
                required: true,
                minlength: 10,
                maxlength: 10
            }
        },
        messages: {
            firstname: "Please enter your first name",
            email: "Please enter a valid email address",
            e_telephone: "This is not a valid phone number"
        },
        highlight: function(label) {
            jQuery(label).closest('.control-group').addClass('error');
        },
       /* success: function(input) {
            input
                .text('Ok!').addClass('valid')
                .closest('.control-group').addClass('success');
        }*/
    });

    function addEmployeeViewModel() {
        this.fullName = ko.observable("");
        this.email = ko.observable("");
        this.residentialPhone = ko.observable("");
        this.permanentPhone = ko.observable("");
        this.nic = ko.observable("");
        this.dob = ko.observable("");
        this.joinedDate = ko.observable("");
        this.startingSalary = ko.observable("");
        this.residentialAddress = ko.observable("");
        this.permanentAddress = ko.observable("");
        this.prevExperience = ko.observable("");
        this.commentsFromPrevWorkPlace = ko.observable("");
        this.emergencyContact = ko.observable("");


    }

    ko.applyBindings(new addEmployeeViewModel());


});
