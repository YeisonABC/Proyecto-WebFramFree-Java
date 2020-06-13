<%-- 
    Document   : updateEmpleado
    Created on : 17/04/2020, 07:43:19 PM
    Author     : Familia Beltran
--%>

<%@page import="Dto.cargoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.cargoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            HttpSession miSesion = request.getSession(true);
            String usuario = (String) miSesion.getAttribute("usuario");
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            miSesion.setAttribute("codigo", codigo);
            int cCargo = Integer.parseInt(request.getParameter("codigoCargo"));
            String nombreCargo = request.getParameter("nombreCargo");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String genero = request.getParameter("genero");
            String cedula = request.getParameter("cedula");
            String direccion = request.getParameter("direccion");
            String fecha = request.getParameter("fecha");
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("correo");
            String clave = request.getParameter("clave");
        %> 
        <div class="container formularioCliente">
            <div class="text-center">
                <h2>Datos de la Persona:</h2>
                <h4><%=nombre%> <%=apellido%></h4>
            </div>
            <hr>
            <div class="text-center h4">Actulizar Datos</div>
            <form action="controladorInsertPersona">
                <label>Cargo</label>
                <select name="cargos" id="opcionCargo">
                    <option value="<%=cCargo%>"><%=nombreCargo%></option>
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
                </select><br>
                Nombres<input type="text" name="nombre" value="<%=nombre%>"><br>
                Apellidos<input type="text" name="apellido" value="<%=apellido%>"><br>
                Genero<select name="genero">
                    <option><%=genero%></option>
                    <optgroup>
                        <option value="F">F</option>
                        <option value="M">M</option>
                    </optgroup>
                </select><br>
                Fecha <input type="date" name="fecha" value="<%=fecha%>"><br>
                Cedula<input type="text" name="cedula" value="<%=cedula%>"><br>
                Direccion<input type="text" name="direccion" value="<%=direccion%>"><br>
                Telefono<input type="text" name="telefono" value="<%=telefono%>"><br>
                Correo<input type="text" name="correo" value="<%=correo%>"><br>
                Contraseña<input type="text" name="clave" value="<%=clave%>"><br>
                <%--Tipo Persona<input type="text" readonly="" name="tPersona" value="<%=tPersona%>"><br>--%>
                <input type="submit" value="Continuar">
                <a href="listEmpleados.jsp">Atras</a>
            </form>
        </div>

    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
