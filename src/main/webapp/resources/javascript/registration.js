$.validator.addMethod(
    "regex",
    function(value, element, regexp) {
        var re = new RegExp(regexp);
        return this.optional(element) || re.test(value);
    },
    "Please check your input."
);

$(document).ready(function () {
    $("#registration").validate({
        rules: {
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 4
            },
            password_confirmation: {
                required: true,
                minlength: 4,
                equalTo: "#password"
            },
            name: {
                required: true,
                minlength: 4,
                maxlength: 20,
                regex: "^[a-zA-Z][a-zA-Z .,'-]*$"
            },
            surname: {
                required: true,
                minlength: 4,
                maxlength: 20,
                regex: "^[a-zA-Z][a-zA-Z .,'-]*$"
            },
            birthday: "required"
        },
        messages: {
            email : {
                required : "Email couldn't be empty",
                email: "Email address should be correct"
            },
            password : {
                required : "Password couldn't be empty",
                minlength : "Minimum 4 characters required!"
            },
            password_confirmation : {
                required : "Password confirmation couldn't be empty",
                minlength : "Minimum 4 characters required!",
                equalTo: "Password confirmation should be equal to password"
            },
            name : {
                required : "Name couldn't be empty",
                minlength : "Minimum 4 characters required!",
                maxlength : "Maximum 20 characters allowed!",
                regex: "Name should contain only letters and such symbols as '.-"
            },
            surname : {
                required : "Surname couldn't be empty",
                minlength : jQuery.validator.format("Minimum {0} characters required!"),
                maxlength : "Maximum 20 characters allowed!",
                regex: "Name should contain only letters and such symbols as '.-"
            },
            birthday : {
                required : "Birthday couldn't be empty"
            }
        }
    })
});