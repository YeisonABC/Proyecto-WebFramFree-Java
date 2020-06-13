<%-- 
    Document   : editarProducto
    Created on : 3/01/2020, 03:11:27 PM
    Author     : Familia Beltran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estiloInicioAdmin.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    </head>
    <body>
        <%
            HttpSession miSesion = request.getSession(true);
            String usuario = (String) miSesion.getAttribute("usuario");
        %>
        <div class="dropdown">
            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Tu Cuenta
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <p class="text-center"><%=usuario%></p>
                <hr>
                <a class="dropdown-item" href="#">Cambiar Clave</a>
                <a class="dropdown-item" href="inicioSesion.jsp">Salir</a>
            </div>
        </div> 
        <%
            int codigoProducto = Integer.parseInt(request.getParameter("codigo"));
            String nombre = request.getParameter("nombre");
            String medida = request.getParameter("medida");
            String descripcion = request.getParameter("descripcion");
            int precio = Integer.parseInt(request.getParameter("precio"));
            String tipo = request.getParameter("tipo");
            miSesion.setAttribute("codigo", codigoProducto);
        %>
        <div class="formularioCliente">
            <form action="controladorEditaProducto" method="Post">
                <%--<label>Codigo Produccion</label><input type="number" value="<%=codigoProduccion%>" name="codigoProduccion"><br>--%>
                <label>Nombre</label><input type="text" value="<%=nombre%>" name="nombre"><br>
                <label>Tipo</label><input type="text" value="<%=tipo%>" name="tipo"><br>
                 <label>Medida</label><input type="text" value="<%=medida%>" name="unidadMedida"><br>
                <label>Precio</label><input type="number" value="<%=precio%>" name="precio"><br>
                <label>Descripcion</label><textarea cols="50" rows="5" name="descripcion" ><%=descripcion%></textarea><br>
                <input type="submit" value="Continuar">
            </form>
            <a href="listProductos.jsp">Atras</a>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>