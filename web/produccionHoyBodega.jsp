<%-- 
    Document   : produccionHoy
    Created on : 9/05/2020, 04:32:23 PM
    Author     : Familia Beltran
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Dao.produccionDAO"%>
<%@page import="Dto.productosDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="estiloInicioAdmin.css" rel="stylesheet" type="text/css"/>
    </head>
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
                <div class="navbar-collapse collapse d-sm-inline-flex flex-sm-row-reverse ">
                    <ul class="navbar-nav flex-grow-1">
                        <li class="nav-item ml-1 mr-1">
                            <a href="../listInsumos.jsp" class="nav-link text-white">Insumos</a>
                        </li>
                        <li class="nav-item ml-1 mr-1">
                            <a href="listProductos.jsp" class="nav-link text-white">Productos</a>
                        </li> 
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Tu Cuenta
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <p class="text-center"><%=usuario%></p>
                                <hr>
                                <a class="dropdown-item" href="cambioContrasena.jsp">Cambiar Clave</a>
                                <a class="dropdown-item" href="inicioSesion.jsp">Salir</a>
                            </div>
                        </div> 
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <body>
        <div class="container">
            <p class="h2 text-center mt-5">Produccion <small>FramFree</small></p>
            <div class="mt-5 mb-5">
                <a href="inicioBodega.jsp">Atras</a>
                <table class="table table-hover">
                    <thead>
                    <th>Nombre</th>
                    <th>Tipo</th>
                    <th>Fecha</th>
                    <th>Cantidad</th>
                    <th>Medida</th>
                    <th>Precio</th>
                    </thead>
                    <tbody>
                        <%
                            produccionDAO lproduc = new produccionDAO();
                            int dia = 0;
                            ArrayList<productosDTO> miLista = lproduc.listaProduccionHoy(dia);
                            for (productosDTO Lista : miLista) {%>
                        <tr>
                            <td><%
                                out.print(Lista.getNombreProducto());
                                Lista.getCodigoProduccion();
                                %></td>
                            <td><%out.print(Lista.getTipoProduccion());%></td>
                            <td><%out.print(Lista.getFechaProduccion());%></td>
                            <td><%out.print(Lista.getCantidadEntranteProduccion());%></td>
                            <td><%out.print(Lista.getUnidadMedidaProduccion());%></td>
                            <td><%out.print(Lista.getPrecioProducto());%></td>
                            <%--<td>
                                <a href="borrarProduccion.jsp?codigo=<%=Lista.getCodigoProduccion()%>"><button>Borrar</button></a>
                            </td>--%>
                            <%
                                }
                            %>
                        </tr>
                    </tbody>
                </table>


            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>