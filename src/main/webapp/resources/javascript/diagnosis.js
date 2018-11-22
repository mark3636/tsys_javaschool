$(document).ready(function () {
    $("#diagnosis").validate({
        rules: {
            name: {
                required: true,
                maxLenght: 100
            }
        },
        messages: {
            name : {
                required : "Diagnosis name couldn't be empty",
                maxLength: "Maximum 100 characters allowed!"
            }
        }
    })
});