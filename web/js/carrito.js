$ (document).ready(function () {
    //funcion encargada de actuliazar la cantidad en el carrito.jsp

    $ ("tr #cantidad").click(function () {
        var idp = $(this).parent().find("#idpro").val();
        var cantidad = $(this).parent().find("#cantidad").val();
        var url = "agregaProductosCarrito?accion=actualizarCantidad";
        $.ajax({
            type: 'Post',
            url: url,
            data: "idp=" + idp + "&cantidad=" + cantidad,
            success : function (data, textStatus, jqXHR) {
                location.href ="agregaProductosCarrito?accion=carrito";
            }
        });

    });
});