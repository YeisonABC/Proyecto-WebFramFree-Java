/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Dao.facturaDAO;
import Dao.productoDAO;
import Dto.carritoDTO;
import Dto.facturaDTO;
import Dto.personaFacturaDTO;
import Dto.productosDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.fecha;

/**
 *
 * @author Familia Beltran
 */
public class agregaProductosCarrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    productoDAO productoDao = new productoDAO();
    productosDTO productoDto = new productosDTO();
    ArrayList<carritoDTO> listacarrito = new ArrayList();
    RequestDispatcher rd = null;

    int item;
    int totalPagar;
    //int cantidad = 1;
    int posicion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            HttpSession sesion = request.getSession(true);
            String usuario = (String) sesion.getAttribute("usuario");
            String accion = request.getParameter("accion");
            switch (accion) {
                case "agregaCarrito":// este caso es para que almacene los productos en el icono carrito
                    // variable encargada de la posicion del producto en la lista del carrito                  
                    int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    int precio = Integer.parseInt(request.getParameter("precio"));
                    int id = Integer.parseInt(request.getParameter("id"));

                    productoDto = productoDao.listaId(id);
                    if (listacarrito.size() > 0) {
                        for (int i = 0; i < listacarrito.size(); i++) {
                            if (id == listacarrito.get(i).getIdProducto()) {//si el id del formulario es igual al id del producto del carrito
                                posicion = i;//se conoce la posicion del producto que contiene el id del formulario
                                System.out.println("se cumple la accion del id " + id);
                            } else {
                                System.out.println("No se cumple la accion del Id " + id);
                            }
                        }
                        if (id == listacarrito.get(posicion).getIdProducto()) {//verificar logica del codigo pues presenta problemas
                            cantidad = listacarrito.get(posicion).getCantidad() + cantidad;//se encarga de que en cada ciclo sume los productos cada vez que sean agregados.
                            int subtotal = listacarrito.get(posicion).getPrecioCompra() * cantidad;
                            listacarrito.get(posicion).setCantidad(cantidad);
                            listacarrito.get(posicion).setSubtotal(subtotal);
                            System.out.println("se cumple el segundo ciclo");
                        } else {// muestra todo lo seleccionado en la tienda online
                            item = item + 1;//encargada de hacer la sumatoria como id de la lista del carrito
                            carritoDTO carritoDto = new carritoDTO();//es para agregar al carrito los productos que el cliente seleccione
                            carritoDto.setItem(item);
                            carritoDto.setIdProducto(productoDto.getCodigoProducto());
                            carritoDto.setNombre(productoDto.getNombreProducto());
                            carritoDto.setDescripcion(productoDto.getDescripcionProducto());
                            carritoDto.setCantidad(cantidad);
                            carritoDto.setSubtotal(cantidad * productoDto.getPrecioProducto());
                            carritoDto.setPrecioCompra(precio);
                            listacarrito.add(carritoDto);
                            System.out.println("esta agregando");
                        }
                    } else {
                        item = item + 1;//encargada de hacer la sumatoria como id de la lista del carrito
                        carritoDTO carritoDto = new carritoDTO();//es para agregar al carrito los productos que el cliente seleccione
                        carritoDto.setItem(item);
                        carritoDto.setIdProducto(productoDto.getCodigoProducto());
                        carritoDto.setNombre(productoDto.getNombreProducto());
                        carritoDto.setDescripcion(productoDto.getDescripcionProducto());
                        carritoDto.setPrecioCompra(productoDto.getPrecioProducto());
                        carritoDto.setCantidad(cantidad);
                        carritoDto.setSubtotal(cantidad * productoDto.getPrecioProducto());
                        listacarrito.add(carritoDto);
                        System.out.println("se agrego al carrito " + item);
                    }
                    request.setAttribute("contadorCarrito", listacarrito.size());
                    rd = request.getRequestDispatcher("tiendaOnline.jsp");
                    rd.forward(request, response);
                    //request.getRequestDispatcher("agregaProductosCarrito?accion=home").forward(request, response);

                    //request.setAttribute("contador", carrito.size());este es para que muestre la cantidad de productos que hay
                    //request.getRequestDispatcher("controlador?accion=home").forward(request, response);
                    break;

                case "carrito":
                    request.setAttribute("contadorCarrito", listacarrito);
                    totalPagar = 0;
                    for (int i = 0; i < listacarrito.size(); i++) {
                        totalPagar = totalPagar + listacarrito.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.getRequestDispatcher("carrito.jsp").forward(request, response);
                    //request.setAttribute("carrito", listacarrito);
                    //request.getRequestDispatcher("tiendaOnline.jsp").forward(request, response);
                    break;

                case "segirComprando":
                    request.setAttribute("contadorCarrito", listacarrito.size());
                    rd = request.getRequestDispatcher("tiendaOnline.jsp");
                    rd.forward(request, response);
                    break;

                case "actualizarCantidad":
                    int idp = Integer.parseInt(request.getParameter("idp"));
                    int cant = Integer.parseInt(request.getParameter("cantidad"));
                    for (int i = 0; i < listacarrito.size(); i++) {
                        if (listacarrito.get(i).getIdProducto() == idp) {
                            listacarrito.get(i).setCantidad(cant);
                            int st = listacarrito.get(i).getPrecioCompra() * cant;
                            listacarrito.get(i).setSubtotal(st);
                        }
                    }
                    break;

                case "borrar":
                    Iterator<carritoDTO> iterator = listacarrito.iterator();
                    int ids = Integer.parseInt(request.getParameter("ids"));
                    int codigo = 0;                  
                    while (iterator.hasNext()) {
                        codigo = iterator.next().getItem();
                        if (ids == codigo) {
                            iterator.remove();
                        }
                    }
                     totalPagar = 0;
                    for (carritoDTO precioDes : listacarrito) {                       
                        totalPagar = totalPagar + precioDes.getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("contadorCarrito", listacarrito);
                    request.getRequestDispatcher("carrito.jsp").forward(request, response);
                    break;

                case "generarCompra":
                    int iva = 19,
                     preciosiniva = 0;
                    double porcentaje = (totalPagar * iva) / 100;
                    preciosiniva = (int) (totalPagar - porcentaje);

                    if (usuario == null) {
                        request.getRequestDispatcher("registroTiendaOnline.jsp").forward(request, response);
                        request.setAttribute("valorIva", porcentaje);
                        request.setAttribute("preciosiniva", preciosiniva);
                        request.setAttribute("totalPagar", totalPagar);
                    } else {
                        request.setAttribute("valorIva", porcentaje);
                        request.setAttribute("preciosiniva", preciosiniva);
                        request.setAttribute("totalPagar", totalPagar);
                        request.getRequestDispatcher("envioFacturacion.jsp").forward(request, response);
                    }
                    break;

                case "envioFacturacion":
                    personaFacturaDTO persona = new personaFacturaDTO();
                    persona.setCodigoPersona(1);
                    facturaDAO factura = new facturaDAO();
                    facturaDTO compra = new facturaDTO(persona, fecha.FechaBD(), 1, totalPagar, listacarrito);
                    if (totalPagar <= 0) {
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    } else {
                        int respuesta = factura.generarCompra(compra);
                        if (respuesta != 0 && totalPagar > 0) {
                            request.getRequestDispatcher("tiendaOnline.jsp").forward(request, response);
                        } else {
                            request.getRequestDispatcher("error.jsp").forward(request, response);
                        }
                    }
                    break;

                default:
                //request.setAttribute("producto", lista); se utliza para enviar la lista a las jstl
                //request.getRequestDispatcher("tiendaOnline.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el switch metodo post" + ex);
        } catch (SQLException ex) {
            Logger.getLogger(agregaProductosCarrito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
