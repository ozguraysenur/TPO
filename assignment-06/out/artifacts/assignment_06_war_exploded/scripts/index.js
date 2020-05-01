function callback(resp){
    $("#sum").text(resp);
}

function _get() {
    $.get("/add",{
        number1 : $("#number1").val(),
        number2 : $("#number2").val(),
    },
        callback,
        "json"
    );

}

function _post() {
    $.post("/add",{
            number1 : $("#number1").val(),
            number2 : $("#number2").val(),
        },
        callback,
        "json"
    );

}
$("#number1").focusout(_post);
$("#number2").focusout(_post);
