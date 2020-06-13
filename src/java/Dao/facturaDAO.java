/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.carritoDTO;
import Dto.facturaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.conexion;

/**
 *
 * @author Familia Beltran
 */
public class facturaDAO extends conexion {

    int r = 0;

    public int generarCompra(facturaDTO compra) throws SQLException {
        //conocer el id compras 
        int idCompras;
        String sql = "INSERT INTO factura (Id_Persona, Fecha, IdPago, Precio) values(?,?,?,?)";
        try {
            this.conectandoBBDD();

            this.ps = this.miConexion.prepareStatement(sql);
            ps.setInt(1, compra.getCliente().getCodigoPersona());
            ps.setString(2, compra.getFecha());
            ps.setInt(3, compra.getIdPago());
            ps.setDouble(4, compra.getPrecio());
            r = ps.executeUpdate();

            sql = "SELECT @@IDENTITY AS Id_Factura";//los detalles para identificar la ultima compra
            rs = ps.executeQuery(sql);
            rs.next();
            idCompras = rs.getInt("Id_Factura");
            rs.close();

            for (carritoDTO detalle : compra.getDetalleCompras()) {
                sql = "INSERT INTO detalle_factura (Id_Factura, Id_Productos, ValorVenta, CantidadVenta) VALUES (?,?,?,?)";
                this.ps = miConexion.prepareStatement(sql);
                ps.setInt(1, idCompras);
                ps.setInt(2, detalle.getIdProducto());
                ps.setDouble(3, detalle.getPrecioCompra());
                ps.setInt(4, detalle.getCantidad());
                r = ps.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            System.out.println(" Error en el metodo generar compra facturadao");
        }
        return r;
    }

    public ArrayList<facturaDTO> lilstaFacturas() {
        conexion miConexion = new conexion();
        ArrayList<facturaDTO> miLista = new ArrayList();
        try {
            String sql = "SELECT * FROM factura";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                facturaDTO miFactura = new facturaDTO();
                miFactura.setCodigoFactura(rs.getInt("Id_Factura"));
               // miFactura.setCodigoPersona(rs.getInt("Id_Persona"));
                miFactura.setPrecio(rs.getInt("precio"));
                miFactura.setFecha(rs.getString("Fecha"));
                miLista.add(miFactura);
            }
        } catch (SQLException e) {
            System.out.println("Algo salio mal verifica la sentencia " + e);
        }
        return miLista;
    }

    public int update(int codigoFac, int codigoPer, String tipoFactura, String formaPago, String fecha) throws ClassNotFoundException {
        int edita = 1;
        try {
            this.conectandoBBDD();
            if (edita == 1) {
                PreparedStatement ste = this.miConexion.prepareStatement("UPDATE factura SET Id_Persona =?, Tipo_Factura=?, Forma_Pago=?, Fecha=? WHERE Id_Factura ='" + codigoFac + "';");
                ste.setInt(1, codigoPer);
                ste.setString(2, tipoFactura);
                ste.setString(3, formaPago);
                ste.setString(4, fecha);
                edita = ste.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error inexperado" + e);
        }
        return edita;
    }

    public int insertar(int codigoFac, int codigoPer, String tipoFactura, String formaPago, String fecha) throws ClassNotFoundException {
        int edita = 1;
        this.conectandoBBDD();
        try {
            if (edita == 1) {
                PreparedStatement ste = this.miConexion.prepareStatement("INSERT INTO factura VALUES Id_Persona =?, Tipo_Factura=?, Forma_Pago=?, Fecha=? WHERE Id_Factura ='" + codigoFac + "'");
                ste.setInt(1, codigoPer);
                ste.setString(2, tipoFactura);
                ste.setString(3, formaPago);
                ste.setString(4, fecha);
                edita = ste.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error inexperado" + e);
        }
        return edita;
    }
}
