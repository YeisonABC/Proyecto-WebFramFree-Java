<%-- 
    Document   : updateProveedor
    Created on : 18/04/2020, 11:16:12 AM
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
            int idProveedor = Integer.parseInt(request.getParameter("codigo"));
            miSesion.setAttribute("idProveedor", idProveedor);//dato enviado al servlet controladorproveedro para la consulta SQL
            String usuario = (String) miSesion.getAttribute("usuario");
            String razonSocial = request.getParameter("razonSocial");
            String nit = request.getParameter("nit");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
        %> 
        <div class="container formularioCliente">
            <div class="text-center">
                <h2>Datos de la Empresa</h2>
                <h4><%=razonSocial%></h4>
            </div>
            <hr>
            <div class="text-center h4">Actulizar Datos</div>
            <form action="ControladorProveedor" method="POST">
                Nombre <input type="text" name="nombre" value="<%=razonSocial%>"><br>
                Nit<input type="text" name="nit" value="<%=nit%>"><br>
                Direccion<input type="text" name="direccion" value="<%=direccion%>"><br>
                Telefono<input type="text" name="telefono" value="<%=telefono%>"><br>
                <%--Tipo Persona<input type="text" readonly="" name="tPersona" value="<%=tPersona%>"><br>--%>
                <input type="submit" value="Continuar">
                <a href="listProveedores.jsp">Atras</a>
            </form>
        </div>

    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
