<%-- 
    Document   : editarInsumo
    Created on : 2/01/2020, 04:36:34 PM
    Author     : Familia Beltran
--%>

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
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                String nombre = request.getParameter("nombre");
                String unidadMedida = request.getParameter("unidadMedida");
                int precio =Integer.parseInt(request.getParameter("precio"));
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                String fecha = request.getParameter("fecha");
                HttpSession miSesion = request.getSession(true);
                miSesion.setAttribute("codigo", codigo);
            %>
            <div><p class="h4 text-center">Editar Insumo <br><%=nombre%></p></div>
            <div class="formularioCliente">
                <form action="controladorEditarInsumo" method="POST">
                    <label>Codigo Persona</label><input type="number" value="<%=codigo%>" name="codigo"><br>
                    <label>Nombre</label><input type="text" value="<%=nombre%>" name="nombre"><br>
                    <label>Descripcion</label><input type="text" value="<%=unidadMedida%>" name="unidadMedida"><br>
                    <label>Cantidad</label><input type="number" value="<%=cantidad%>" name="cantidad"><br>
                     <label>Precio</label><input type="number" value="<%=precio%>" name="precio"><br>
                     <label>Fecha</label><input type="date" value="<%=fecha%>" name="fecha"><br>
                    <input type="submit" value="continuar">
                    <a href="listInsumos.jsp">Atras</a>
                </form>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>
