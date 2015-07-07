function submitRegistration(event) {
    event.preventDefault();

    var registrationForm =
    {
        "name": $('#name').val(),
        "email": $('#email').val(),
        "password": $('#password').val(),
        "passwordConfirm": $('#passwordConfirm').val()
    };

    $.ajax({
        url: $("#registrationForm").attr("action"),
        data: JSON.stringify(registrationForm),
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",

        success: function (response) {
            handleResponse(response, function onSuccess() {
                var redirectUrl =
                    location.protocol + "//" + window.location.hostname + ":" +
                    window.location.port + "/register-success";

                window.location.replace(redirectUrl);
            });
        }
    });
}

function addToCart(event) {
    event.preventDefault();

    $.ajax({
        url: $("#addToCartForm").attr("action"),
        type: "POST",

        success: function () {
            refreshCartInfo();
        }
    });
}

function deleteProducts(event) {
    event.preventDefault();
    var productsIdToDelete = $("input:checkbox:checked").map(function () {
        return $(this).val();
    }).get();

    $.ajax({
        url: $('#deleteProductsForm').attr("action"),
        data: JSON.stringify(productsIdToDelete),
        contentType: "application/json",
        type: 'POST',

        success: function (response) {
            refreshCartProductsTable();
            refreshCartInfo();
        },

        error: function (response, err1, err2) {
            alert("ERROR: " + err1 + ", " + err2);
        }
    });
}

function confirmOrder(event) {
    event.preventDefault();

    $.ajax({
        url: '/user/confirmOrder',
        type: 'POST',
        dataType: "json",

        success: function (response) {
            handleResponse(response);
            refreshCartProductsTable();
            refreshCartInfo();
        }
    });
}

var refreshCartInfo = function () {
    $.ajax({
        url: '/getCartInfo',
        type: 'GET',

        success: function (response) {
            var cartInfo = $('#cart-preview-info');
            cartInfo.empty();
            cartInfo.html(response);
        }
    });
};

var refreshCartProductsTable = function () {
    $.ajax({
        url: '/getCartProductsTable',
        type: 'GET',

        success: function (response) {
            var cartTableInfo = $('#cart-table-content');
            cartTableInfo.empty();
            cartTableInfo.html(response);
        }
    });
};