function getBeginningTime(patientId) {
    var medicalStaff = $('#medicalStaff');
    var visitDate = $('#visitDate');
    var beginningTime = $('#beginningTime');
    var endingTime = $('#endingTime');

    var submitBtn = $('#submitBtn');

    if (beginningTime.val()) {
        beginningTime.val(undefined);
        beginningTime.timepicker('remove');
        submitBtn.attr('disabled', 'disabled');
    }

    if (endingTime.val()) {
        endingTime.val(undefined);
        endingTime.timepicker('remove');
    }

    if (medicalStaff.val() && visitDate.val()) {
        beginningTime.removeAttr('disabled');

        $.ajax({
            type: 'GET',
            url: "/patient-details/" + patientId + "/new-visit-beginning-time?medicalStaff="
                + medicalStaff.val() + "&visitDate=" + visitDate.val(),
            success: function (data) {
                var disabledTime = [];

                for (var i = 0; i < data.length; i += 2) {
                    disabledTime.push([data[i], data[i + 1]]);
                }

                beginningTime.timepicker({
                    'timeFormat': 'H:i',
                    'disableTextInput': true,
                    'minTime': '9:00',
                    'maxTime': '15:45',
                    'step': '15',
                    'disableTimeRanges': disabledTime
                });
            },
            error: function (error) {
                console.error(error.prototype.message);
            }
        })
    }
    else {
        beginningTime.attr('disabled', 'disabled');
        endingTime.attr('disabled', 'disabled');
    }
}

function getEndingTime(patientId) {
    var medicalStaff = $('#medicalStaff');
    var visitDate = $('#visitDate');
    var beginningTime = $('#beginningTime');
    var endingTime = $('#endingTime');

    var submitBtn = $('#submitBtn');

    endingTime.val(undefined);
    endingTime.timepicker('remove');
    submitBtn.attr('disabled', 'disabled');


    if (medicalStaff.val() && visitDate.val() && beginningTime.val() && $("#visit").valid()) {
        endingTime.removeAttr('disabled');

        $.ajax({
            type: 'GET',
            url: "/patient-details/" + patientId + "/new-visit-ending-time?medicalStaff="
                + medicalStaff.val() + "&visitDate="
                + visitDate.val() + "&beginningTime=" + beginningTime.val(),
            success: function (data) {
                endingTime.timepicker({
                    'timeFormat': 'H:i',
                    'disableTextInput': true,
                    'minTime': data[0],
                    'maxTime': data[1],
                    'step': '15'
                });
            },
            error: function (error) {
                console.error(error.prototype.message)
            }
        })
    }
    else {
        endingTime.attr('disabled', 'disabled');
    }
}

function readyForSubmit() {
    var medicalStaff = $('#medicalStaff').val();
    var visitDate = $('#visitDate').val();
    var beginningTime = $('#beginningTime').val();
    var endingTime = $('#endingTime').val();

    var submitBtn = $('#submitBtn');

    if (medicalStaff && visitDate && beginningTime && endingTime && $("#visit").valid()) {
        submitBtn.removeAttr('disabled');
    }
    else {
        submitBtn.attr('disabled', 'disabled');
    }
}

$.validator.addMethod(
    "validBeginningTime",
    function (value, element) {
        var now = new Date();
        var  dt = $("#visitDate").val();
        var date = Date.parse(dt);
        var dateWithTime = Date.parse(dt + " " + value);
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
    }).keyup(function (e) {
        if (e.keyCode === 8 || e.keyCode === 46) {
            $.datepicker._clearDate(this);
            this.blur()
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
});