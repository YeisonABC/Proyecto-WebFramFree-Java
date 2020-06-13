<%-- 
    Document   : index
    Created on : 7/05/2020, 05:25:26 PM
    Author     : Familia Beltran
--%>

<%@page import="Dto.productosDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.productoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FramFree</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/bcb35d67fc.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="estilos/index.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
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
                            <a class="dropdown-item" href="registroTiendaOnline.jsp">Registrarce</a>
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
                            <a class="dropdown-item" href="controladorLogin">Salir</a>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </header>
        <div class="d-flex justify-content-around p-1">
            <div class="botonmenu font-weight-bold p-3"><a href="index.jsp">INICIO&nbsp;<i class="fas fa-home"></i></a></div>
            <div class="botonmenu font-weight-bold p-3"><a href="tiendaOnline.jsp"><i class="fas fa-store"></i>&nbsp;TIENDA</a></div>
            <div class="p-3 botonmenu font-weight-bold p-3">
                <form action="agregaProductosCarrito?accion=carrito" method="Post">                
                    (<label> ${contadorCarrito}<i class="fas fa-shopping-cart"></i></label>)
                    <input type="submit" value="CARRITO" class="font-weight-bold">
                </form>
            </div>
        </div>
        <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="imagenes/papas.jpg" class="d-block w-100" alt="..." style="opacity: 0.85;">
                    <div class="carousel-caption d-none d-md-block">
                        <p class="display-4 text-dark">Diversoso Producto de nuesta Granja.</p>
                        <div class="botonindex">
                            <a class="font-weight-bold text-dark h4" href="">Leer Mas</a>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="imagenes/lechecarusel.jpg" class="d-block w-100" alt="..."style="opacity: 0.85;">
                    <div class="carousel-caption d-none d-md-block">
                        <p class="display-4 text-dark">Diversosos Productos lacteos .</p>
                        <div class="botonindex">
                            <a class="font-weight-bold text-dark h4 " href="">Leer Mas</a>
                        </div>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <%-- <div class="bg-light mt-5 mb-lg-5 pt-3 pb-5">
             <div class=" text-center display-4 mb-5 mt-5">NUESTROS PRODUCTOS</div>
             <div class="ml-5 mr-5">
                 <div class="jumbotron" style="background-image: url('imagenes/huevos-aa.jpg'); background-size: 100% 100%; height:500px;">
                     <h1 class="display-4 font-weight-bold text-white">PRODUCTOS DE CALIDAD</h1>
                     <div class="col col-md-4">
                         <h2 class="text-white font-weight-light">Nuestra granja ofrece los mejores productos frescos para los residentes locales, mercados y tiendas.</h2>
                         <div class="botonindex text-center mt-5">
                             <a href="tiendaOnline.jsp" class=" h4 bg-warning text-white pl-5 pr-5 pt-3 pb-3 rounded"> Nuesta Tienda</a>
                         </div>
                     </div>                                    
                 </div>
             </div>
         </div>--%>

        <div class="mr-5 ml-5 mb-5">
            <div class="text-center mt-5 mb-5 display-4 font-weight-bold">BIENVENIDOS A NUESTRA GRANJA</div>
            <div class="row">
                <div class="col col-md-4">
                    <div class="bg-light p-3">
                        <div class="imagenindex border p-2">
                            <img src="imagenes/leche.jpg" class=" d-block w-100" />
                        </div>
                        <p class="font-weight-bold h4 text-center mt-2 mb-2">NUESTROS PRODUCTOS</p>
                        <div class="pr-3 pl-3">
                            <p class="text-center">
                                Brindamos a nuestros clientes
                                una amplia variedad de productos lácteos,
                                desde leche orgánica hasta mantequilla y queso
                            </p>
                            <div class="botonindex text-center">
                                <a href="" class="">Leer Mas</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col col-md-4">
                    <div class="bg-light p-3">
                        <div class="imagenindex border p-2">
                            <img src="imagenes/produc.jpg" class="d-block w-100" />
                        </div>
                        <p class="font-weight-bold h4 text-center mt-2 mb-2">NUESTROS ORGANIZACION</p>
                        <div class="pr-3 pl-3">
                            <p class="text-center">
                                Creemos que es la mejor manera de inspirar a nuestra comunidad a probar productos
                                útiles y naturales, que esperamos les guste
                            </p>
                            <div class="botonindex text-center">
                                <a href="" class="">Leer Mas</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col col-md-4">
                    <div class="bg-light p-3">
                        <div class="imagenindex border p-2">
                            <img src="imagenes/vaca2.jpg" class="d-block w-100" />
                        </div>
                        <p class="font-weight-bold h4 text-center mt-2 mb-2">COMO TRABAJAMOS</p>
                        <div class="pr-3 pl-3">
                            <p class="text-center">
                                Nuestro proceso de trabajo incluye algunos elementos basados
                                en enfoques tanto tradicionales como innovadores de producción lechera.
                            </p>
                            <div class="botonindex text-center">
                                <a href="" class="">Leer Mas</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%--<div>
            <div class="display-4 text-center font-weight-bold mt-5 pb-5 mt-5 mb-lg-5">POR QUÉ ELEJIRNOS</div>
            <div class="container">
                <div class="row clearfix">
                    @*izquierda*@
                    <div class="col col-md-4">
                        <div class="framModerna pl-4 pr-4">
                            <div class="framModernapanelIzq pl-3 pr-3">
                                <div class="d-flex justify-content-center p-2">
                                    <p class=""><i class="fas fa-laptop-house fa-4x "></i></p>
                                </div>
                                <a href="" class="h4 mb-1 d-flex justify-content-center">GRANJA MODERNA</a>
                                <p class="p-3">
                                    Fram Free es una granja totalmente innovadora, que combina métodos modernos
                                    de producción de lácteos con tradiciones.
                                </p>
                            </div>
                        </div><hr />
                        <div class="framModerna pl-4 pr-4">
                            <div class="framModernapanelIzq pl-3 pr-3">
                                <div class="d-flex justify-content-center p-2">
                                    <p class=""><i class="fas fa-sun fa-4x"></i></p>
                                </div>
                                <a href="" class="h4 mb-1 d-flex justify-content-center">ALIMENTACION NATURAL</a>
                                <p class="p-3">
                                    Utilizamos alimento natural para nuestras vacas para que puedan producir leche
                                    orgánica de alta calidad para usted.
                                </p>
                            </div>
                        </div>
                    </div>
                    @*centro*@
                    <div class="col col-md-4">
                        <div class="imagenCentro">
                            <img src="imagenes/papas.jpg" class="" />
                        </div>
                    </div>

                    @*derecha*@
                    <div class="col col-md-4">
                        <div class="framModerna pl-4 pr-4">
                            <div class="framModernapanelIzq pl-3 pr-3">
                                <div class="d-flex justify-content-center p-2">
                                    <p class=""><i class="fas fa-spa fa-4x"></i></p>
                                </div>
                                <a href="" class="h4 mb-1 d-flex justify-content-center">100% ORGANICO</a>
                                <p class="p-3">
                                    Preservamos las tradiciones de producción orgánica en todos los productos lácteos
                                    que producimos y ofrecemos.
                                </p>
                            </div>
                        </div><hr />
                        <div class="framModerna pl-4 pr-4">
                            <div class="framModernapanelIzq pl-3 pr-3">
                                <div class="d-flex justify-content-center p-2">
                                    <p class=""><i class="fab fa-pagelines fa-4x"></i></p>
                                </div>
                                <a href="" class="h4 mb-1 d-flex justify-content-center">NO PESTICIDAS</a>
                                <p class="p-3">
                                    Nuestros agricultores evitan los pesticidas en nuestros productos lácteos,
                                    lo que hace que nuestros productos sean más nutritivos
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        jumbotron
        <div class="jumbotron" style="background-image: url('/imagenes/papasSalada.jpg'); background-size: 100% 100%; height:600px; ">
            <div class="col col-md-4 p-5 ml-5">
                <h1 class="display-4 font-weight-bold">VENTA DE VERANO</h1>
                <h3 class="text-primary font-weight-bold">-50% <br /> En todos los productos</h3>
                <p class="h5">Compre los mejores productos lácteos orgánicos para su familia en nuestra tienda en línea y ahorre más dinero que en cualquier otro lugar.</p>
                <a class="btn btn-info pr-5 pl-5 pt-3 pb-3" href="#" role="button">Leer Mas</a>
            </div>
        </div>--%>



        <div class="container">
            <div class="display-4 text-center font-weight-bold mt-5 pb-5 mt-5 mb-lg-5">SOBRE NOSOTROS</div>
            <div class="row">
                <div class="col col-md-7">
                    <div class="cajaAbuot">
                        <img src="imagenes/nosotros.jpg" class="d-block w-100" />
                    </div>
                </div>
                <div class="col col-md-5 border p-3">
                    <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">NOSOTROS</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false">CALIDAD CONTROL</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-contact" role="tab" aria-controls="pills-contact" aria-selected="false">NUESTRA META</a>
                        </li>
                    </ul>
                    <div class="tab-content p-3" id="pills-tabContent">
                        <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                            <div>
                                <p class="text-muted h4 m-2">
                                    INTEGRANDO INNOVACIONES EN LAS TRADICIONES LÁCTEAS
                                </p>
                                <p class="text-center">
                                    Nuestra misión es crear una granja lechera sostenible, ambiental y tecnológicamente avanzada.
                                    Nos adherimos a las tradiciones de criar vacas combinadas naturalmente con innovaciones.
                                </p>
                            </div>
                            <div class="botonindex text-center">
                                <a href="" class="">Leer Mas</a>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                            <div>
                                <p class="text-muted h4 m-2">
                                    ASEGURANDO LA MAYOR CALIDAD DE NUESTROS PRODUCTOS
                                </p>
                                <p class="text-center">
                                    En la producción lechera, el aseguramiento de la calidad es una parte integral de la estrategia de calidad.
                                    A medida que nos preocupamos por nuestros clientes, controlamos la calidad de nuestros productos en todas
                                    las etapas de su producción.
                                </p>
                            </div>
                            <div class="botonindex text-center">
                                <a href="" class="">Leer Mas</a>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">
                            <div>
                                <p class="text-muted h4 m-2">
                                    NUESTRA POSICIÓN ESTÁ PRINCIPAL PARA ALIMENTARTE CON PRODUCTOS SABROSOS
                                </p>
                                <p class="text-center">
                                    Nuestro objetivo es ofrecer los mejores productos lácteos a los ciudadanos locales y a los huéspedes de la ciudad.
                                    El control de calidad y el cumplimiento de los estándares de la industria son nuestros objetivos principales.
                                </p>
                            </div>
                            <div class="botonindex text-center">
                                <a href="" class="">Leer Mas</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="bg-light">
            <div class="container">
                <div class="display-4 text-center font-weight-bold mt-5 pb-5 mt-5 mb-lg-5">Ultimas Noticias</div>
                <div class="row">
                    <div class="col col-md-6">
                        <div class="jumbotron" style="background-image: url('imagenes/vaca2.jpg'); background-size: 100% 100%; height:400px; ">                        
                            <a class="h5 font-weight-bold text-white mt-5" href="#" role="button">
                                Cómo se produce la leche hoy en día: <br />entrevista con nuestro fundador
                            </a>
                        </div>
                    </div>
                    <div class="col col-md-6">
                        <div class="row p-2">
                            <div class="col col-md-6">
                                <img src="imagenes/noticia.jpg" class="d-block w-100"/>
                            </div>
                            <div class="col col-md-6">
                                <div>
                                    <a href="" class="h4 p-3">
                                        ¿Pueden las innovaciones mejorar la producción de lácteos?
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="row p-2">
                            <div class="col col-md-6">
                                <img src="imagenes/noticia2.jpg" class="d-block w-100"/>
                            </div>
                            <div class="col col-md-6">
                                <div>
                                    <a href="" class="h4 p-3">
                                        ¿Por qué debería evitar los pesticidas en su leche?
                                    </a>
                                </div>
                            </div>
                        </div>
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
</html>
