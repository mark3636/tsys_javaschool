function deletePatient(id) {
    if (confirm('Are you sure you want to delete this patient?')) {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: 'DELETE',
            url: "/patient/" + id + "/delete",
            success: function () {
                $('#tr-' + id).remove();
                console.log("success");
            },
            error: function (error) {
                console.log(error)
            }
        });
        return true;
    }

    return false;
}

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
});