function setUserBanValue(event, userID, banValue) {
    event.preventDefault();
    $.ajax({
        url: '/admin/users/ban',
        data: {
            'userID': userID,
            'banValue': banValue
        },
        type: 'POST',

        success: function (event) {
            //user's table row has the same id with user
            $('#' + userID).remove();
        }
    });
}

function deleteCategory(event, form, categorySelect) {
    event.preventDefault();
    var categoryNameToDelete = categorySelect.val();

    $.ajax({
        url: form.attr("action"),
        data: categoryNameToDelete,
        type: "DELETE",

        success: function (response) {
            handleResponse(response, function onSuccess() {
                categorySelect.find("option:selected").remove();
            });
        }
    });
}

function addCategory(event, form, categoryInput) {
    event.preventDefault();
    var categoryNameToAdd = categoryInput.val();

    $.ajax({
        url: form.attr("action"),
        data: categoryNameToAdd,
        type: "PUT",

        beforeSend: function (xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "text/plain");
        },

        success: function (response) {
            handleResponse(response, function onSuccess() {
                //add category to delete categories list
                $("#categoryToDeleteSelect")
                    .append($("<option></option>")
                        .attr("value", categoryNameToAdd)
                        .text(categoryNameToAdd));
            });
        }
    });
}

function createProduct(event, form) {
    event.preventDefault();
    var imageData = new FormData();
    var imageFile = document.getElementById('image').files[0];
    imageData.append("image", imageFile);
    imageData.append("categoryName", $('#categoryName').val());
    imageData.append("productName", $('#productName').val());
    imageData.append("price", $('#price').val());
    imageData.append("description", $('#description').val());

    $.ajax({
        url: form.attr("action"),
        data: imageData,
        type: 'POST',
        processData: false,
        contentType: false,

        success: function (response) {
            handleResponse(response);
        },

        error: function (response, err1, err2) {
            alert("ERROR: " + err1 + ", " + err2);
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
        type: 'DELETE',

        success: function (event) {
            //table rows have the same id with the products
            productsIdToDelete.forEach(function (productID) {
                $('#' + productID).remove();
            })
        }
    });
}