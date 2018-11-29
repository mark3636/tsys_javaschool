function changeMedicalCaseStatus(id, status) {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'POST',
        url: "/medical-case/" + id + "/change",
        data: status,
        success: function (data) {
            console.log(data);
            var tr = $('#tr-' + id);
            tr.find('td:nth-child(4)').html(status);
            tr.find('td:nth-child(3)').html(new Date(data).toISOString().slice(0, 10));
            if (status === 'COMPLETED') {
                tr.find('td:last-child').prev().html('+');
                tr.find('td:last-child').html('-');
            }
            if (status === 'CANCELLED') {
                tr.find('td:last-child').prev().html('-');
                tr.find('td:last-child').html('+');
            }
            console.log("success");
        },
        error: function (error) {
            console.log(error)
        }
    })
}