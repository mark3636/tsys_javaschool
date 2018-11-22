$.validator.addMethod(
    "validBeginningTime",
    function (value, element) {
        var now = new Date();
        var date = Date.parse($("#visitDate").val());
        var dateWithTime = Date.parse($("#visitDate").val() + " " + value);
        console.log("now: " + now);
        console.log("date: "+ date);
        console.log("date with time: " + dateWithTime);
        return this.optional(element) || date > now || dateWithTime > now
    },
    "Please check your input."
);

$(document).ready(function () {
    $("#visitDate").datepicker({
        dateFormat: "yy-mm-dd",
        minDate: "0",
        changeMonth: true,
        changeYear: true,
        onClose: function () {
            $(this).valid();
        }
    });

    $("#visit").validate({
        rules: {
            beginningTime: {
                validBeginningTime: true
            }
        },
        messages: {
            beginningTime: {
                validBeginningTime: "Visit beginning time should be equal or later then current time"
            }
        }
    })
})
;