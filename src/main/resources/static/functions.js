function deletePerson(id) {
    console.log(id);
    swal({
        title: "Are you sure to Delete?",
        text: "Once deleted it cannot be restored!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url: "/persons/delete/" + id,
                    success: function (res) {
                        console.log(res);
                    },
                });
                swal("Poof! Record deleted!", {
                    icon: "success",
                }).then((ok) => {
                    if (ok) {
                        location.href = "/persons";
                    }
                });
            }
        });
}
