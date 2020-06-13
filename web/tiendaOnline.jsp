<%-- 
    Document   : tiendaOnline
    Created on : 2/05/2020, 08:25:33 PM
    Author     : Familia Beltran
--%>

<%@page import="Dto.productosDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.productoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://kit.fontawesome.com/bcb35d67fc.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="estilos/index.css" rel="stylesheet" type="text/css"/>
        <title>Tienda framFree</title>
    </head>
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
    <body>
        <div class="d-flex justify-content-around p-1">
            <div class="botonmenu font-weight-bold p-3"><a href="index.jsp">INICIO&nbsp;<i class="fas fa-home"></i></a></div>
            <div class="botonmenu font-weight-bold p-3"><a href="tiendaOnline.jsp"><i class="fas fa-store"></i>&nbsp;TIENDA</a></div>
            <div class="p-3 botonmenu font-weight-bold p-3">
                <form action="agregaProductosCarrito?accion=carrito" method="Post">                
                    (<label>${contadorCarrito}<i class="fas fa-shopping-cart"></i></label>)
                    <input type="submit" value="Carrito">
                </form>
            </div>
        </div>
        <%
            productoDAO miProducto = new productoDAO();
            ArrayList<productosDTO> miLista = miProducto.listaProducto();
        %>

        <div class="cajaindexProductos">
            <div class="cajaProductos" >
                <div class="row" id="product-cards ">
                    <%for (productosDTO lista : miLista) {%> 
                    <div class="primerProducto mb-5 ml-4 border">
                        <div class="imagenProducto"><img src="controladorIMG?id=<%=lista.getCodigoProducto()%>" width="70%" height="90%"></div>
                        <form class="pr-5 pl-5 pb-5 text-center" action="agregaProductosCarrito?accion=agregaCarrito&&id=<%=lista.getCodigoProducto()%>" method="Post">
                            <input name="precio" value="<%=lista.getPrecioProducto()%>" hidden=""> 
                            <label class="font-weight-bold h4"><%out.println(lista.getNombreProducto());%></label> 
                            <p class="text-succsse h5">$<%=lista.getPrecioProducto()%></p>
                            <div class="d-flex align-items-center justify-content-center">
                                <input type="number" name="cantidad" value="1" style="width: 70px;" min="1" class="text-center form-control d-inline-flex">                      
                                <input type="submit" value="Comprar" class="btn btn-outline-success ml-2"> 
                            </div>                           
                        </form>
                    </div>
                    <%
                        }
                    %>
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
</html>