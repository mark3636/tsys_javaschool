function checkFile() {
    var file = $('#file');
    if(file[0].files[0].size > 16 * 1024 * 1024){
        alert("Attachment size cannot be more then 16MB");
        file.val('');
    }
}