/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.personaCargoDTO;
import Dto.personaDTO;
import Dto.personaFacturaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.conexion;

/**
 *
 * @author Familia Beltran
 */
public class personaDAO extends conexion {

    public ArrayList<personaDTO> listaPersona(String per) {
        conexion miConexion = new conexion();
        ArrayList<personaDTO> miLista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM persona WHERE Tipo_Persona = '" + per + "'";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                personaDTO persona = new personaDTO();
                persona.setIdPersona(rs.getInt(1));
                persona.setIdCargo(rs.getInt(2));
                persona.setNombre(rs.getString(3));
                persona.setApellido(rs.getString(4));
                persona.setRazonSocial(rs.getString(5));
                persona.setGenero(rs.getString(6));
                persona.setCedula(rs.getString(7));
                persona.setFechaVinculacion(rs.getDate(8));
                persona.setTelefono(rs.getString(9));
                persona.setTipoPersona(rs.getString(10));
                persona.setDireccion(rs.getString(11));
                persona.setCorreo(rs.getString(12));
                persona.setClave(rs.getString(13));
                miLista.add(persona);
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo lista persona DAO " + ex);
        }
        return miLista;
    }

    public int insertProveedor(String nombre, String nit, String telefono, String direccion) {
        int insert = 1;
        String tPersona = "P";
        try {
            this.conectandoBBDD();
            if (insert == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("INSERT INTO persona ( RazonSocial, Tipo_Identificacion, Telefono, tipo_Persona, Direccion)"
                        + "VALUES (?,?,?,?,?)");
                st.setString(1, nombre);
                st.setString(2, nit);
                st.setString(3, telefono);
                st.setString(4, tPersona);
                st.setString(5, direccion);
                insert = st.executeUpdate();
            } else {

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en el metodo insertProveedor DAO" + e);
        }
        return insert;
    }

    public int insertEmpleado(int codigo, String nombre, String apellido, String genero, String cedula, String fecha, String telefono, String direccion, String correo, String clave) {
        int insert = 1;
        String tPersona = "E";
        try {
            this.conectandoBBDD();
            if (insert == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("INSERT INTO persona (Id_Cargo, Nombres, Apellidos, Genero, Tipo_Identificacion, Fecha_Vinculacion, Telefono, tipo_Persona, Direccion, correo, contrasena)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                st.setInt(1, codigo);
                st.setString(2, nombre);
                st.setString(3, apellido);
                st.setString(4, genero);
                st.setString(5, cedula);
                st.setString(6, fecha);
                st.setString(7, telefono);
                st.setString(8, tPersona);
                st.setString(9, direccion);
                st.setString(10, correo);
                st.setString(11, clave);
                insert = st.executeUpdate();
            } else {

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en el metodo insertEmpleado DAO" + e);
        }
        return insert;
    }

    //metodo utilizado en el formulario de registrotiendaonline.jsp
    public int insertCliente(String correo, String clave, String nombre, String apellido, String genero, String cedula, String telefono, String direccion) {
        int insert = 1;
        String tPersona = "C";
        int idCargo = 21; // varieble que establece el idCargo 21 el cual es CLIENTES en la tabla CARGOS
        try {
            this.conectandoBBDD();
            if (insert == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("INSERT INTO persona (Id_Cargo, Nombres, Apellidos, Genero, Tipo_Identificacion, Telefono, Tipo_Persona, Direccion, correo, contrasena)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?)");
                st.setInt(1, idCargo);
                st.setString(2, nombre);
                st.setString(3, apellido);
                st.setString(4, genero);
                st.setString(5, cedula);
                st.setString(6, telefono);
                st.setString(7, tPersona);
                st.setString(8, direccion);
                st.setString(9, correo);
                st.setString(10, clave);
                insert = st.executeUpdate();
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error en el metodo insertCliente DAO " + e);
        }
        return insert;
    }

    public int updateEmpleado(int codigoPer, int codigoCargo, String nombre, String apellido, String genero, String cedula, String fecha, String telefono, String direccion, String correo, String clave) throws ClassNotFoundException {
        this.conectandoBBDD();
        int update = 1;
        try {
            if (update == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("UPDATE persona SET Id_Cargo =?, Nombres=?, Apellidos=?, Genero=?, Tipo_Identificacion=?, Fecha_Vinculacion=?, Telefono =?, Direccion =?, correo=?, contrasena=? WHERE Id_Persona = '" + codigoPer + "'");
                st.setInt(1, codigoCargo);
                st.setString(2, nombre);
                st.setString(3, apellido);
                st.setString(4, genero);
                st.setString(5, cedula);
                st.setString(6, fecha);
                st.setString(7, telefono);
                st.setString(8, direccion);
                st.setString(9, correo);
                st.setString(10, clave);
                update = st.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error en el metodo updateEmpleado DAO" + e);
        }
        return update;
    }

    public int updateCliente(int codigoPer, String nombre, String apellido, String genero, String cedula, String telefono, String direccion) throws ClassNotFoundException {
        this.conectandoBBDD();
        int update = 1;
        try {
            if (update == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("UPDATE persona SET Nombres=?, Apellidos=?, Genero=?, Tipo_Identificacion=?, Telefono =?, Direccion =? WHERE Id_Persona = '" + codigoPer + "'");
                st.setString(1, nombre);
                st.setString(2, apellido);
                st.setString(3, genero);
                st.setString(4, cedula);
                st.setString(5, telefono);
                st.setString(6, direccion);
                update = st.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error updateCliente DAO" + e);
        }
        return update;
    }

    public int updateProveedor(int codigoPer, String razonSocial, String nit, String telefono, String direccion) throws ClassNotFoundException {
        this.conectandoBBDD();
        int update = 1;
        try {
            if (update == 1) {
                PreparedStatement st = this.miConexion.prepareStatement("UPDATE persona SET  RazonSocial=?, Tipo_Identificacion=?, Telefono =?, Direccion =? WHERE Id_Persona = '" + codigoPer + "'");
                st.setString(1, razonSocial);
                st.setString(2, nit);
                st.setString(3, telefono);
                st.setString(4, direccion);
                update = st.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error updateProveedor DAO" + e);
        }
        return update;
    }

    public ArrayList<personaCargoDTO> listaPersonaCargo() {
        conexion miConexion = new conexion();
        ArrayList<personaCargoDTO> miLista = new ArrayList<>();
        try {

            String sql = "SELECT * FROM cargo c, persona p WHERE p.Id_Cargo = c.Id_Cargo ORDER BY p.Id_Persona ASC";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                personaCargoDTO persona = new personaCargoDTO();
                persona.setCodigoCargo(rs.getInt(1));
                persona.setNombreCargo(rs.getString(2));
                persona.setCodigoPersona(rs.getInt(3));
                persona.setNombrePersona(rs.getString(5));
                persona.setApellido(rs.getString(6));
                persona.setGenero(rs.getString(8));
                persona.setCedula(rs.getString(9));
                persona.setFechaVinculacion(rs.getDate(10));
                persona.setTelefono(rs.getString(11));
                persona.setTipoPersona(rs.getString(12));
                persona.setDireccion(rs.getString(13));
                persona.setCorreo(rs.getString(14));
                persona.setContrasena(rs.getString(15));
                miLista.add(persona);
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo listaPersonaCargo DAO " + ex);
        }
        return miLista;
    }

    public ArrayList<personaFacturaDTO> listaPersonaFactura() {
        conexion miConexion = new conexion();
        ArrayList<personaFacturaDTO> miLista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM factura f, persona p WHERE f.Id_Persona = p.Id_Persona ORDER BY f.Id_Factura ASC";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                personaFacturaDTO persona = new personaFacturaDTO();
                persona.setCodigoFactura(rs.getInt(1));
                persona.setCodigoPersona(rs.getInt(2));
                persona.setTipoFactura(rs.getString(3));
                persona.setFormaPago(rs.getString(4));
                persona.setFecha(rs.getDate(5));
                persona.setCodigoCargo(rs.getInt(7));
                persona.setNombrePersona(rs.getString(8));
                persona.setApellido(rs.getString(9));
                persona.setGenero(rs.getString(10));
                persona.setCedula(rs.getString(11));
                persona.setFechaVinculacion(rs.getDate(12));
                persona.setTelefono(rs.getString(13));
                persona.setTipoPersona(rs.getString(14));
                miLista.add(persona);
            }
        } catch (SQLException ex) {
            System.out.println("Error en el metodo listaPersonaFactura" + ex);
        }
        return miLista;
    }

}
