<%-- 
    Document   : insertPersona
    Created on : 24-feb-2020, 15:16:02
    Author     : Sala300
--%>

<%@page import="Dto.cargoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.cargoDAO"%>
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
            String caso1 = (String) sesion.getAttribute("caso1"); // esta tipo variable viene del controladorInsertPersona
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
        <div class="mt-5"><p class="h4 text-center">Nuevo Empleado</p></div>
        <div class=" formularioCliente"> 
            <form action="controladorInsertPersona"  method="POST" > 
                <select name="cargos" id="opcionCargo" class="form-control form-control-lg">
                    <option value="" selected="" disabled="">Seleccione un Cargo</option>
                    <%
                        cargoDAO miCargo = new cargoDAO();
                        ArrayList<cargoDTO> miArray = miCargo.listaCargos();
                        for (cargoDTO cargos : miArray) {
                    %>
                    <option value="<%=cargos.getCodioCargo()%>">
                        <%
                            out.print(cargos.getNombre());
                        %>  
                    </option>   
                    <%
                        }
                    %>
                </select>
                <p id="mensaje2" class="text-danger"></p>
                <input type="text" name="nombre" id="nombre" class="form-control form-control-lg " placeholder="Nombres">
                <p id="mensaje1" class="text-danger"></p>
                <input type="text" name="apellido" id="apellido" class="form-control form-control-lg " placeholder="Apellidos">
                <p id="mensaje3" class="text-danger"></p> 
                <select name="genero" id="genero" class="form-control form-control-lg ">
                    <option value="0" selected="" disabled="">Genero</option>
                    <option value="F">Femenino</option>
                    <option value="M">Masculino</option>
                </select>
                <p id="mensaje4" class="text-danger"></p>
                <input type="text" name="cedula" id="cedula" class="form-control form-control-lg " placeholder="Cedula">
                <p id="mensaje5" class="text-danger"></p>
                <input type="date" name="fecha" id="fecha"  class="form-control form-control-lg " placeholder="Fecha Vinculacion">
                <p id="mensaje8" class="text-danger"></p>
                <input type="text" name="telefono" id="telefono"  class="form-control form-control-lg " placeholder="Telefono">
                <p id="mensaje6" class="text-danger"></p>
                <input type="text" name="direccion" id="direccion"  class="form-control form-control-lg" placeholder="Direccion">
                <p id="mensaje7" class="text-danger"></p>
                <input type="email" name="correo" id="telefono"  class="form-control form-control-lg " placeholder="Correo">
                <p id="mensaje6" class="text-danger"></p>
                <input type="password" name="contrasena" id="direccion"  class="form-control form-control-lg" placeholder="Contraseña">
                <p id="mensaje7" class="text-danger"></p>
                <%--<label>Tipo Persona</label> 
                <select name="tPersona">
                    <option value="C">C</option>
                    <option value="E">E</option>
                    <option value="P">P</option>
                </select><br>--%>
                <input type="submit" value="REGISTRAR"  class="form-control col col-md-5" >
            </form>
            <a href="listEmpleados.jsp" class="">Atras</a>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>