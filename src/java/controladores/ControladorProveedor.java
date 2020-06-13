/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Dao.personaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Familia Beltran
 */
@WebServlet(name = "ControladorProveedor", urlPatterns = {"/ControladorProveedor"})
public class ControladorProveedor extends HttpServlet {

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
        String nombre = request.getParameter("razonSocial");
        String nit = request.getParameter("nit");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        personaDAO proveedor = new personaDAO();
        int update = proveedor.insertProveedor(nombre, nit, telefono, direccion);
        if(update==1){
            RequestDispatcher rd =request.getRequestDispatcher("listProveedores.jsp");
            rd.forward(request, response);
        }
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
            HttpSession miSesion = request.getSession(true);
            int idProveedor =(int) miSesion.getAttribute("idProveedor");
            String nombre = request.getParameter("nombre");
            String nit = request.getParameter("nit");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            
            personaDAO proveedor = new personaDAO();
            int update = proveedor.updateProveedor(idProveedor, nombre, nit, telefono, direccion);
            if(update==1){
                RequestDispatcher rd =request.getRequestDispatcher("listProveedores.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorProveedor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en el servlet ContoladorProveedor " + ex);
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
