<%-- 
    Document   : registroTiendaOnline
    Created on : 1/06/2020, 05:57:15 PM
    Author     : Familia Beltran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/bcb35d67fc.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="estilos/index.css" rel="stylesheet" type="text/css"/>
        <title>Registro</title>
    </head>
    <body style="background-color: #F1F1F1;">
        <header>
            <%
                HttpSession sesion = request.getSession(true);
                String usuario = (String) sesion.getAttribute("usuario");
            %>
            <div class="text-center">
                <a class="navbar-brand text-dark" href="index.jsp"><p class="display-3">FramFree</p></a>
                <img src="imagenes/logoFramFree.jpg" />

                <div class="d-inline-flex ml-5 mr-5 p-3">
                    <%
                        if (usuario == null) {
                    %>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Iniciar sesion
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="inicioSesion.jsp">Iniciar Session</a>
                        </div>
                    </div>
                    <%
                    } else {
                    %>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Tu cuenta
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <p class="text-center"><%=usuario%></p>
                            <hr>
                            <a class="dropdown-item" href="#">Cambiar Clave</a>
                            <a class="dropdown-item" href="inicioSesion.jsp">Salir</a>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
            <hr />
        </header>
        <div class="container">
            <p class="muted mt-5">Registrate a Continuacion</p>
            <hr>
            <p class="text-danger mt-4 mb-5">*<small class="text-dark">Campos obligatorios:</small></p>
            <form action="controladorRegistroTienda?accion=registrar" method="Post">
                <div class="row">
                    <div class="col-md-6">
                        <label><p class="text-danger d-inline-flex m-0">*</p>Correo Electronico</label><input type="email" class="col col-md-6 form-control" name="correo">
                        <label><p class="text-danger d-inline-flex m-0">*</p>Contraseña:</label><input type="password" class="col col-md-6 form-control " name="contrasena">
                        <label><p class="text-danger d-inline-flex m-0">*</p>Verificar Contraseña:</label><input type="password" class="col col-md-6 form-control" name="confiContrasena">
                        <label><p class="text-danger d-inline-flex m-0">*</p>Genero:</label>
                        <select name="genero" class="form-control col col-md-5">
                            <option value="" disabled="" selected="">Seleccione una opcion</option>
                            <option value="F">Femenino</option>
                            <option value="M">Masculino</option>
                        </select>
                    </div>
                    <div class="col-md-6">
                        <label><p class="text-danger d-inline-flex m-0">*</p>Nombres</label><input type="text" class="col col-md-6 form-control" name="nombre">
                        <label><p class="text-danger d-inline-flex m-0">*</p>Apellidos</label><input type="text" class="col col-md-6 form-control" name="apellido">
                        <label><p class="text-danger d-inline-flex m-0">*</p>Numero de Telefono</label><input type="tel" class="col col-md-6 form-control" name="tel">
                        <label><p class="text-danger d-inline-flex m-0">*</p>Direccion:</label><input type="text" class="col col-md-6 form-control" name="direccion">
                        <label><p class="text-danger d-inline-flex m-0">*</p>Numero de Documento:</label><input type="text" class="col col-md-6 form-control" name="documento">
                    </div>
                </div>
                <input type="submit" value="Aceptar">
                <a href="tiendaOnline.jsp">Cancelar</a>
            </form>
        </div>
<footer>
            <div class="footer">
                <div class="cajaSocial">
                    <a href=""><div class="redSocial d-inline-flex"><i class="fab fa-facebook-f"></i></div></a>
                    <a href=""><div class="redSocial d-inline-flex"><i class="fab fa-twitter"></i></div></a>
                    <a href=""><div class="redSocial d-inline-flex"><i class="fab fa-instagram"></i></div></a>
                    <a href=""><div class="redSocial d-inline-flex"><i class="fab fa-linkedin-in"></i></div></a>
                </div>
                <div class="pie">
                    <p class="text-white">Copirigth | FarmFree 2020. Todos los derechos Reservados</p>
                </div>
            </div>
        </footer>
    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
