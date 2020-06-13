<%-- 
    Document   : inicioAdmin
    Created on : 1/12/2019, 09:20:01 PM
    Author     : Familia Beltran
--%>

<%@page import="Dto.loginDTO"%>
<%@page import="java.util.ArrayList"%>
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
            HttpSession sesion = request.getSession(true);
            String usuario = (String) sesion.getAttribute("usuario");
        %>

        <header>
            <div class="text-center">
                <a class="navbar-brand text-dark"><p class="display-3">FramFree</p></a>
                <img src="imagenes/logoFramFree.jpg" />
            </div>
            <hr />
            <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-dark border-bottom box-shadow">
                <div class="container">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="navbar-collapse collapse d-sm-inline-flex flex-sm-row-reverse">
                        <ul class="navbar-nav flex-grow-1">
                            <li class="nav-item ml-1 mr-1">
                                <a href="listEmpleados.jsp" class="nav-link text-white" >Empleados</a>
                            </li>
                            <li class="nav-item ml-1 mr-1">
                                <a href="listProveedores.jsp" class="nav-link text-white">Proveedores</a>
                            </li>
                            <li class="nav-item ml-1 mr-1">
                                <a href="listInsumos.jsp" class="nav-link text-white">Insumos</a>
                            </li>
                            <li class="nav-item ml-1 mr-1">
                                <a href="listProductos.jsp" class="nav-link text-white">Productos</a>
                            </li>
                            <li class="nav-item ml-1 mr-1">
                                <a href="listaProduccion.jsp" class="nav-link text-white">Produccion</a>
                            </li>
                        <div class="dropdown ml-5">
                            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <%=usuario%>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                <a class="dropdown-item" href="cambioContrasena.jsp">Cambiar Contraseña</a>
                                <a class="dropdown-item" href="inicioSesion.jsp">Salir</a>
                            </div>
                        </div>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>

    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
