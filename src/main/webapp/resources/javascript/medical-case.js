$.validator.addMethod(
    "regex",
    function (value, element, regexp) {
        var re = new RegExp(regexp);
        return this.optional(element) || re.test(value);
    },
    "Please check your input."
);

$(document).ready(function () {
    $("#medicalCase").validate({
        rules: {
            number: {
                required: true,
                regex: "^[a-zA-Z0-9_-]*$",
                rangelength: [10, 10]
            }
        },
        messages: {
            number: {
                required: "Medical case number cannot be empty",
                regex: "Medical case number should contain only letters, numbers and such symbols as _-",
                rangelength: jQuery.validator.format("Only {0} characters allowed!")
            }
        }
    })
});