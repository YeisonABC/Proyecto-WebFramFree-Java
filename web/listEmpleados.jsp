<%-- 
    Document   : listEmpleados
    Created on : 16/04/2020, 08:13:52 PM
    Author     : Familia Beltran
--%>

<%@page import="Dto.personaDTO"%>
<%@page import="Dto.personaCargoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.personaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>

    <header>
        <%
            HttpSession sesion = request.getSession(true);
            String usuario = (String) sesion.getAttribute("usuario");
        %>
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

    <body>
        <div class="container">
            <div><p class="h4 text-center">Empleados</p></div>
            <div class="m-2"><a href="insertEmpleado.jsp">Nuevo Empleado</a></div>
            <form action="">
                <input class="" type="text" name="buscar">
                <input class="" type="submit" value="Buscar">
            </form>

            <%
                personaDAO persona = new personaDAO();
                ArrayList<personaCargoDTO> lista = persona.listaPersonaCargo();
            %>
            <div class="">
                <table class="table table-hover">
                    <thead>
                        <%--<th>cod.<br> Persona</th>--%>
                    <th>Cargo</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Genero</th>
                    <th>Cedula</th>
                    <th>Fecha</th>
                    <th>Telefono</th>
                    <th>Direccion</th>
                    <th>Correo</th>
                    <th>Accion</th>
                    </thead>
                    <tbody>
                        <%
                            for (personaCargoDTO Persona : lista) {
                        %>
                        <tr>                  
                            <%-- <td><%
                                out.println(Persona.getCodigoPersona());
                                %>
                            </td>--%>
                            <td><%
                                Persona.getCodigoPersona();
                                out.println(Persona.getNombreCargo());
                                Persona.getCodigoCargo();
                                %>
                            </td>
                            <td><%out.println(Persona.getNombrePersona());%></td>
                            <td><%out.println(Persona.getApellido());%></td>
                            <td><%out.println(Persona.getGenero());%></td>
                            <td><% out.println(Persona.getCedula());%></td>
                            <td><%out.println(Persona.getFechaVinculacion());%></td>
                            <td><%out.println(Persona.getTelefono());%></td>
                            <td><%out.println(Persona.getDireccion());%></td>
                             <td><%out.println(Persona.getCorreo());%></td>
                            <td>
                                <a href="updateEmpleado.jsp?codigo=<%=Persona.getCodigoPersona()%>&&nombreCargo=<%=Persona.getNombreCargo()%>&&codigoCargo=<%=Persona.getCodigoCargo()%>&&nombre=<%=Persona.getNombrePersona()%>&&apellido=<%=Persona.getApellido()%>&&genero=<%=Persona.getGenero()%>&&cedula=<%=Persona.getCedula()%>&&fecha=<%=Persona.getFechaVinculacion()%>&&telefono=<%=Persona.getTelefono()%>&&direccion=<%=Persona.getDireccion()%>&&correo=<%=Persona.getCorreo()%>&&clave=<%=Persona.getContrasena()%>">Editar<i class="fas fa-pencil-alt"></i>
                                </a>
                                <%--<a href="deletePersona.jsp?codigo=<%=Persona.getCodigoPersona()%>">Borrar<i class="far fa-trash-alt" style="color:#DF2A2A;"></i></a>--%>
                                <%
                                    }
                                %>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="dataTable.js"></script>
    <script>

        $(document).ready(function () {
            $('#tableList').DataTable();
        });


    </script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
