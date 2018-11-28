$.validator.addMethod(
    "regex",
    function (value, element, regexp) {
        var re = new RegExp(regexp);
        return this.optional(element) || re.test(value);
    },
    "Please check your input."
);

$(document).ready(function () {
        $("#birthday").datepicker({
            dateFormat: "yy-mm-dd",
            minDate: "-120y",
            maxDate: 0,
            changeMonth: true,
            changeYear: true,
            yearRange: "-120:+0"
        }).keyup(function (e) {
            if (e.keyCode === 8 || e.keyCode === 46) {
                $.datepicker._clearDate(this);
                this.blur()
            }
        });

        $("#patient").validate({
            rules: {
                socialSecurityNumber: {
                    required: true,
                    regex: "^\\d{9}$"
                }
            },
            messages: {
                socialSecurityNumber: {
                    required: "Social security number cannot be empty",
                    regex: "Social security number should contain only [9] numbers"
                }
            }
        })
    }
);