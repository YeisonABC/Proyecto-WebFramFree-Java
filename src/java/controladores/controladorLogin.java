/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Dao.loginDAO;
import Dto.loginDTO;
import Dto.personaDTO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "controladorLogin", urlPatterns = {"/controladorLogin"})
public class controladorLogin extends HttpServlet {

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
        HttpSession sesion = request.getSession(true);
        RequestDispatcher rd;
        sesion.invalidate();
        rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
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

        HttpSession sesion = request.getSession(true);
        loginDAO login = new loginDAO();
        ArrayList errores = new ArrayList();
        personaDTO persona = new personaDTO();
        RequestDispatcher rd;

        String correo = request.getParameter("usuario");
        String clave = request.getParameter("contrasena");
        try {
            ResultSet rs = login.logeoEmpleado(correo, clave);
            if (rs.absolute(1)) {//si hay reusltado que carge el switch
                persona.setNombre(rs.getString("Nombres"));
                persona.setApellido(rs.getString("Apellidos"));
                persona.setTelefono(rs.getString("Telefono"));
                persona.setDireccion(rs.getString("Direccion"));
                persona.setCedula(rs.getString("Tipo_Identificacion"));
                persona.setCorreo(rs.getString("correo"));
                String usuario = persona.getNombre();
                String apellido = persona.getApellido();
                String telefono = persona.getTelefono();
                String direccion = persona.getDireccion();
                String cedula = persona.getCedula();
                String email = persona.getCorreo();
                sesion.setAttribute("usuario", usuario);
                sesion.setAttribute("apellido", apellido);
                sesion.setAttribute("telefono", telefono);
                sesion.setAttribute("direccion", direccion);
                sesion.setAttribute("cedula", cedula);
                sesion.setAttribute("email", email);

                sesion.setAttribute("errores", errores);
                persona.setIdCargo(rs.getInt("Id_Cargo"));
                int codigoLogin = persona.getIdCargo();
                switch (codigoLogin) {
                    case 1://cargo bodega
                        persona.setIdPersona(rs.getInt("Id_Persona"));//encargado de proporcionar el codigo del usuario logeado
                        int p = persona.getIdCargo();//se almacena en una variable para debolverlo
                        sesion.setAttribute("idLogin", p);//se envia como parametro el idLogin del usuario logeado
                        request.getRequestDispatcher("inicioBodega.jsp").forward(request, response);
                        break;
                    case 21://cargo cliente
                        persona.setIdPersona(rs.getInt("Id_Persona"));//encargado de proporcionar el codigo del usuario logeado
                        int p1 = persona.getIdCargo();//se almacena en una variable para debolverlo
                        sesion.setAttribute("idLogin", p1);//se envia como parametro el idLogin del usuario logeado
                        rd = request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                        break;

                    case 20://cargo cliente
                        persona.setIdPersona(rs.getInt("Id_Persona"));//encargado de proporcionar el codigo del usuario logeado
                        int p2 = persona.getIdCargo();//se almacena en una variable para debolverlo
                        sesion.setAttribute("idLogin", p2);//se envia como parametro el idLogin del usuario logeado
                        rd = request.getRequestDispatcher("inicioBodega.jsp");
                        rd.forward(request, response);
                        break;

                    default:
                }
            } else {
                rd = request.getRequestDispatcher("inicioSesion.jsp");
                rd.forward(request, response);
                errores.add("contraseña o usuario incorrectos");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error controladorLogin " + ex);
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
