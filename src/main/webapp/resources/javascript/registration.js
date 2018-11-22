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
        minDate: "-80y",
        maxDate: "-18y",
        changeMonth: true,
        changeYear: true,
        yearRange: "-80:-18",
        onClose: function() {
            $(this).valid();
        }
    });

    $("#registration").validate({
        rules: {
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 4,
                maxlength: 15
            },
            password_confirmation: {
                required: true,
                minlength: 4,
                maxlength: 15,
                equalTo: "#password"
            },
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
            }
        },
        messages: {
                email: {
                    required: "Email cannot be empty",
                    email: "Email address should be correct"
                } ,
                password: {
                    required: "Password cannot be empty",
                    minlength: jQuery.validator.format("Minimum {0} characters required!"),
                    maxlength: jQuery.validator.format("Maximum {0} characters allowed!")
                } ,
                password_confirmation: {
                    required: "Password confirmation cannot be empty",
                    minlength: jQuery.validator.format("Minimum {0} characters required!"),
                    maxlength: jQuery.validator.format("Maximum {0} characters allowed!"),
                    equalTo: "Password confirmation should be equal to password"
                } ,
                name: {
                    required: "Name cannot be empty",
                    regex: "Name should contain only letters and such symbols as '.-",
                    minlength: jQuery.validator.format("Minimum {0} characters required!"),
                    maxlength: jQuery.validator.format("Maximum {0} characters allowed!")
                } ,
                surname: {
                    required: "Surname cannot be empty",
                    regex: "Surname should contain only letters and such symbols as '.-",
                    minlength: jQuery.validator.format("Minimum {0} characters required!"),
                    maxlength: jQuery.validator.format("Maximum {0} characters allowed!")
                } ,
                birthday: {
                    required: "Birthday cannot be empty",
                    past: "Birthday should be in past"
                }
            }
    })
})
;