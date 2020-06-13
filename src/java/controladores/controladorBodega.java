/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Dao.produccionDAO;
import Dto.productosDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Familia Beltran
 */
@WebServlet(name = "controladorBodega", urlPatterns = {"/controladorBodega"})
public class controladorBodega extends HttpServlet {

    produccionDAO produccion = new produccionDAO();
    ArrayList<productosDTO> lista = new ArrayList();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorBodega</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorBodega at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        RequestDispatcher rd = null;
        try {
            String accion = request.getParameter("accion");

            switch (accion) {
                //caso encargado de insertan la produccion desde la insertproduccion.jsp vistas bodeguero
                case "insertar":
                    int nombre = Integer.parseInt(request.getParameter("nombre"));
                    String fecha = request.getParameter("fecha");
                    double cantidad = Double.parseDouble(request.getParameter("cantidad"));
                    int p = produccion.insertProducccion(nombre, fecha, cantidad);
                    if (p == 1) {
                        rd = request.getRequestDispatcher("produccionHoyBodega.jsp");
                        rd.forward(request, response);
                    }
                    break;
                    
                //caso encargado de buscar por tipo de fecha la produccion viene de la vista inicio.jsp formulario
                case "fechaProduccion":
                    String fechaProduccion = request.getParameter("fechaProduccion");
                    request.setAttribute("lista", fechaProduccion);
                    rd = request.getRequestDispatcher("fechaProduccionBodega.jsp");
                    rd.forward(request, response);
                    break;
            }

        } catch (IOException | ClassNotFoundException | NumberFormatException | ServletException e) {
            System.out.println("controlado bodega switch" + e);
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
