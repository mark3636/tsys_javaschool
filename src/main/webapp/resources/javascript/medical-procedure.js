$.validator.addMethod(
    "regex",
    function (value, element, regexp) {
        var re = new RegExp(regexp);
        return this.optional(element) || re.test(value);
    },
    "Please check your input."
);

$(document).ready(function () {
    $("#medical-procedure").validate({
        rules: {
            name: {
                required: true,
                regex: "^[a-zA-Z0-9 _.,'-]*$",
                maxlength: 100
            }
        },
        messages: {
            name : {
                required : "Medical procedure name cannot be empty",
                regex: "Medical procedure name should contain only letters, spaces, numbers and such symbols as _.,-'",
                maxlength: jQuery.validator.format("Maximum {0} characters allowed!")
            }
        }
    })
});