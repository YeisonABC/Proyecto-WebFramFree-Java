<%-- 
    Document   : carrito
    Created on : 18/01/2020, 11:23:28 AM
    Author     : Familia Beltran
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dto.carritoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/bcb35d67fc.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="estilos/index.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<carritoDTO> micarrito = (List<carritoDTO>) request.getAttribute("contadorCarrito");
            HttpSession sesion = request.getSession(true);
            String usuario = (String) sesion.getAttribute("usuario");
        %>

        <div class="text-center">
            <a class="navbar-brand text-dark" href="index.jsp"><p class="display-3">FramFree</p></a>
            <img src="imagenes/logoFramFree.jpg" />
            <div class="d-inline-flex ml-5 mr-5 p-3">
                <% if (usuario == null) {%>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Iniciar sesion
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="inicioSesion.jsp">Iniciar Session</a>
                    </div>
                </div>
                <%} else {%>
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
        <div class="mr-5 ml-5">
            <hr>
            <div class="row">
                <div class="col-sm-8">
                    <table class=" table table-hover">
                        <thead>                    
                        <th class="text-muted">Producto</th>
                        <th class="text-muted">Precio</th>
                        <th class="text-muted">Cantidad</th>
                        <th class="text-muted">Subtotal</th>
                        <th class="text-muted">Eliminar</th>
                        </thead>
                        <tbody>
                            <tr><%for (carritoDTO i : micarrito) {%>
                                <td><div><img src="controladorIMG?id=<%=i.getIdProducto()%>" width="auto" height="50px">
                                        &nbsp;<p class="d-inline-flex font-weight-bold"><%out.print(i.getNombre());%></p></div></td>
                                <td><%out.print(i.getPrecioCompra());%></td>
                                <td>
                                    <input type="hidden" id="idpro" value="<%=i.getIdProducto()%>">
                                    <input type="number" class="form-control text-center" min="1" style="width: 70px;" id="cantidad" value="<%out.print(i.getCantidad());%>">
                                </td>
                                <td><%out.print(i.getSubtotal());%></td>
                                <td>
                                    <form action="agregaProductosCarrito?accion=borrar&&ids=<%=i.getItem()%>" method="Post">                                                                          
                                        <input type="submit" value="Borrar">
                                    </form>
                                </td>                                                                                   
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-head">
                            <h3>Generar Compra</h3>
                        </div>
                        <div class="card-body">
                            <label>Subtotal:</label>
                            <input type="text" readonly="" class="form-control" value="$ ${totalPagar}">
                            <label>Descuento</label>
                            <input type="text" readonly="" class="form-control" value="0.0">
                            <label>total A Pagar</label>
                            <input type="text" readonly="" class="form-control" value="$ ${totalPagar}">
                        </div>
                    </div>
                    <div class="card-footer">
                        <form action="agregaProductosCarrito?accion=segirComprando" method="Post">
                            <input class="btn btn-outline-success" type="submit" value="Seguir Comprando"> 
                        </form><br>
                        <form action="agregaProductosCarrito?accion=generarCompra" method="Post">
                            <input class="btn btn-outline-success" type="submit" value="Finalizar Compra"> 
                        </form>
                    </div>
                </div>
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
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="js/carrito.js" type="text/javascript"></script>
</html>
