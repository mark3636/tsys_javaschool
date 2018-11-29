function changeStatus(id, status) {
    console.log(id);
    $('#submit').click(function () {
        var data = {
            id: id,
            status: status,
            comment: $("#comment").val()
        };

        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: 'POST',
            url: '/medical-procedure/' + id + '/change',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function () {
                var tr = $('#tr-' + id);
                if (status === 'DONE') {
                    tr.find('td:last-child').prev().html('+');
                    tr.find('td:last-child').html('-');
                }
                if (status === 'NOT_DONE') {
                    tr.find('td:last-child').prev().html('-');
                    tr.find('td:last-child').html('+');
                }
                console.log("success");
            },
            error: function (error) {
                console.log("error");
            }
        })
    })
}