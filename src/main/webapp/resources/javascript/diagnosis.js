$.validator.addMethod(
    "regex",
    function (value, element, regexp) {
        var re = new RegExp(regexp);
        return this.optional(element) || re.test(value);
    },
    "Please check your input."
);

$(document).ready(function () {
    $("#diagnosis").validate({
        rules: {
            name: {
                required: true,
                regex: "^[a-zA-Z0-9 _.,'-]*$",
                maxlength: 100
            }
        },
        messages: {
            name : {
                required : "Diagnosis name cannot be empty",
                regex: "Diagnosis name should contain only letters, numbers and such symbols as _.-'",
                maxlength: jQuery.validator.format("Maximum {0} characters allowed!")
            }
        }
    })
});