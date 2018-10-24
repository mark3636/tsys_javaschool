function confirmDelete(delForm, delUrl) {
    if (confirm("Are you sure ?")) {
        delForm.action = delUrl;
        return true;
    }
    return false;
}