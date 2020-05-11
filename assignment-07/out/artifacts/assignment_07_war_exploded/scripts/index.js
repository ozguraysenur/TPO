function time() {

    $.get("/date", {}, function (response, status) {
        if(status === "success") {
            $("#date").html(response);
        } else {
            console.log(status);
        }
    });
    setTimeout(time, 1000);
}

time();