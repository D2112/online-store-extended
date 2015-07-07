function turnMessagesIntoHtml(response) {
    var responseMessages = "";
    response.messages.forEach(function (message) {
        responseMessages += message + "<br>";
    });
    return responseMessages;
}

function handleResponse(response, onSuccess, onFail) {
    outputSuccessMessages(response);
    if (response.status == "SUCCESS" && typeof onSuccess === 'function') {
        onSuccess();
    } else if (response.status == "FAIL" && typeof onFail === 'function') {
        onFail();
    }
}

function outputSuccessMessages(messages) {
    clearOutput();
    $("#successResponse").html(turnMessagesIntoHtml(messages));
}

function outputErrorMessages(messages) {
    clearOutput();
    $("#errorResponse").html(turnMessagesIntoHtml(messages));
}

function clearOutput() {
    $("#errorResponse").empty();
    $("#successResponse").empty();
}
