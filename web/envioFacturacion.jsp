<%-- 
    Document   : envioFacturacion
    Created on : 2/06/2020, 07:21:37 PM
    Author     : Familia Beltran
--%>

<%@page import="java.util.List"%>
<%@page import="Dto.carritoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/bcb35d67fc.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="estilos/index.css" rel="stylesheet" type="text/css"/>
        <title>Envio y Facturacion</title>
    </head>

    <body>
        <header>
            <%
                HttpSession sesion = request.getSession(true);
                String usuario = (String) sesion.getAttribute("usuario");
                String apelldio = (String) sesion.getAttribute("apellido");
                String telefono = (String) sesion.getAttribute("telefono");
                String cedula = (String) sesion.getAttribute("cedula");
                String direccion = (String) sesion.getAttribute("direccion");
                String email = (String) sesion.getAttribute("email");
                
                
                
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
            <div class="col col-md-6 p-3">
                <h5 class="text-primary">1. Resumen de Compra</h5>
                <hr class="border border-primary">
                <dl class="row ">
                    <dt class = "col-sm-6">Subtotal</dt>
                    <dd class = "col-sm-6">$: ${preciosiniva}</dd>
                    <dt class = "col-sm-6 ">Iva</dt>
                    <dd class = "col-sm-6">$: ${valorIva}</dd>
                    <dt class = "col-sm-6 ">Total del Pedido</dt>
                    <dd class = "col-sm-6">$: ${totalPagar}</dd>
                </dl>
            </div>
            <div class="col col-md-6 mt-2 mb-2 p-5" style="background: #F3F3F3;">
                <h5 class="text-primary">2. Informacion de Envio</h5>
                <hr class="border border-primary">
                <input type="text" disabled="" value="<%=email%>" class="form-control col-md-8">
                <p class=" mt-2 m-0"><%=usuario%>&nbsp;<%=apelldio%>-&nbsp;<%=telefono%></p>
                <p class="m-0"><%=cedula%></p>
                <p class="m-0"><%=direccion%></p>
            </div>
            <div class="col-md-6 p-3">
                <h5 class="text-primary">3. Metodo de Pago</h5>
                <hr class="border border-primary">
                <form action="agregaProductosCarrito?accion=envioFacturacion" method="Post">
                    <label>Numero de Targeta</label><input type="text" placeholder="Numero de Targeta " class="form-control">
                    <label>Nombre en la Targeta</label><input type="text" placeholder="Nombre de Targeta " class="form-control">
                    <label>Fecha Expedicon</label><input type="date" class="form-control">
                    <label>CVC</label><input type="text" placeholder="CVC" class="form-control">
                    <input class="btn btn-primary m-2" type="submit" value="Finalizar Compra">
                </form>
            </div>
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
