$.validator.addMethod(
    "regex",
    function (value, element, regexp) {
        var re = new RegExp(regexp);
        return this.optional(element) || re.test(value);
    },
    "Please check your input."
);

$.validator.addMethod(
    "past",
    function (value, element) {
        var now = new Date();
        var date = Date.parse(value);
        return this.optional(element) || date < now;
    },
    "Please check your input."
);

$(document).ready(function () {
    $("#birthday").datepicker({
        dateFormat: "yy-mm-dd",
        minDate: "-120y",
        maxDate: "0",
        changeMonth: true,
        changeYear: true,
        yearRange: "-120:0"
    });

    $("#patient").validate({
        rules: {
            name: {
                required: true,
                regex: "^[a-zA-Z][a-zA-Z .,'-]*$",
                minlength: 2,
                maxlength: 15
            },
            surname: {
                required: true,
                regex: "^[a-zA-Z][a-zA-Z .,'-]*$",
                minlength: 2,
                maxlength: 20
            },
            birthday: {
                required: true,
                past: true
            },
            passportDetails: {
                required: true,
                regex: "^[a-zA-Z0-9 _.-]*$"
            },
            address: {
                required: true,
                regex: "^[a-zA-Z0-9 _.,'-]*$"
            },
            email: {
                required: true,
                email: true
            },
            phoneNumber: {
                required: true,
                regex: "^\\d{5,11}$"
            },
            socialSecurityNumber: {
                required: true,
                regex: "^\\d{9}$"
            }
        },
        messages: {
            name: {
                required: "Name cannot be empty",
                regex: "Name should contain only letters and such symbols as '.-",
                minlength: jQuery.validator.format("Minimum {0} characters required!"),
                maxlength: jQuery.validator.format("Maximum {0} characters allowed!")
            },
            surname: {
                required: "Surname cannot be empty",
                regex: "Surname should contain only letters and such symbols as '.-",
                minlength: jQuery.validator.format("Minimum {0} characters required!"),
                maxlength: jQuery.validator.format("Maximum {0} characters allowed!")
            },
            birthday: {
                required: "Birthday cannot be empty",
                past: "Birthday should be in past"
            },
            passportDetails: {
                required: "Passport details cannot be empty",
                regex: "Passport details should contain only letters, numbers and such symbols as _.-"
            },
            address: {
                required: "Address cannot be empty",
                regex: "Address should contain only letters, numbers and such symbols as _.-'"
            },
            phoneNumber: {
                required: "Phone number cannot be empty",
                regex: "Phone number should contain only numbers and its length should be from 5 to 11"
            },
            socialSecurityNumber: {
                required: "Social security number cannot be empty",
                regex: "Social security number should contain only [9] numbers"
            },
            email: {
                required: "Email cannot be empty",
                email: "Email address should be correct"
            }
        }
    })
})
;