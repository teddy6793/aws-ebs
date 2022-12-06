function addProductToCart(id){
    $.ajax({
        url: "/cart/add_product/" + id,
        type:"get",
        success: function(response){
            UIkit.notification({
                message: response,
                status: 'success',
                pos: 'top-center',
                timeout: 1500
            });
        },
        error: function (xhr){

        },
    });
}

function addProductToCartAndQuantity(id) {
    const quantity = document.getElementById('quantity').value;
    $.ajax({
        url: "/cart/add_product/" + id + "/" + quantity,
        type: "get",
        success: function (response) {
            UIkit.notification({
                message: response,
                status: 'success',
                pos: 'top-center',
                timeout: 1500
            });
        },
        error: function (xhr) {

        },
    });
}