/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.produccionDTO;
import Dto.productosDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.conexion;

/**
 *
 * @author Familia Beltran
 */
public class produccionDAO extends conexion{
    
public ArrayList<productosDTO> listaProduccion() {
        conexion miConexion = new conexion();
        ArrayList<productosDTO> miLista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM productos tp, produccion pr WHERE tp.Id_Productos = pr.Id_Productos";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                productosDTO productos = new productosDTO();
                productos.setCodigoProducto(rs.getInt(1));
                 productos.setCodigoEstante(rs.getInt(2));
                productos.setNombreProducto(rs.getString(3));
                productos.setTipoProduccion(rs.getString(4));
                productos.setDescripcionProducto(rs.getString(5));
                productos.setFoto(rs.getBinaryStream(6));
                productos.setCantidadExisteneProducto(rs.getInt(7));    
                productos.setPrecioProducto(rs.getInt(8));
                productos.setUnidadMedidaProduccion(rs.getString(9));
                 productos.setCodigoProduccion(rs.getInt(10));               
                 productos.setFechaProduccion(rs.getDate(12));
                  productos.setCantidadEntranteProduccion(rs.getInt(13));
                miLista.add(productos);
            }
        } catch (SQLException ex) {
            System.out.println("Error lista produccionDAo" + ex);
        }
        return miLista;
    }

//metodo de propocionar la lista de la produccion del dia actual
public ArrayList<productosDTO> listaProduccionHoy(int dia) {
        conexion miConexion = new conexion();
        ArrayList<productosDTO> miLista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM productos tp, produccion pr WHERE tp.Id_Productos = pr.Id_Productos AND pr.Fecha = CURDATE()-'"+dia+"'";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                productosDTO productos = new productosDTO();
                productos.setCodigoProducto(rs.getInt(1));
                 productos.setCodigoEstante(rs.getInt(2));
                productos.setNombreProducto(rs.getString(3));
                productos.setTipoProduccion(rs.getString(4));
                productos.setDescripcionProducto(rs.getString(5));
                productos.setFoto(rs.getBinaryStream(6));
                productos.setCantidadExisteneProducto(rs.getInt(7));    
                productos.setPrecioProducto(rs.getInt(8));
                productos.setUnidadMedidaProduccion(rs.getString(9));
                 productos.setCodigoProduccion(rs.getInt(10));               
                 productos.setFechaProduccion(rs.getDate(12));
                  productos.setCantidadEntranteProduccion(rs.getInt(13));
                miLista.add(productos);
            }
        } catch (SQLException ex) {
            System.out.println("Error lista produccionDAo" + ex);
        }
        return miLista;
    }

//metodo encargado de propocionar la lista dependiendo de una fecha selecionada
public ArrayList<productosDTO> listaPorFecha(String fecha) {
        conexion miConexion = new conexion();
        ArrayList<productosDTO> miLista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM productos tp, produccion pr WHERE tp.Id_Productos = pr.Id_Productos AND pr.Fecha = '"+fecha+"'";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                productosDTO productos = new productosDTO();
                productos.setCodigoProducto(rs.getInt(1));
                 productos.setCodigoEstante(rs.getInt(2));
                productos.setNombreProducto(rs.getString(3));
                productos.setTipoProduccion(rs.getString(4));
                productos.setDescripcionProducto(rs.getString(5));
                productos.setFoto(rs.getBinaryStream(6));
                productos.setCantidadExisteneProducto(rs.getInt(7));    
                productos.setPrecioProducto(rs.getInt(8));
                productos.setUnidadMedidaProduccion(rs.getString(9));
                 productos.setCodigoProduccion(rs.getInt(10));               
                 productos.setFechaProduccion(rs.getDate(12));
                  productos.setCantidadEntranteProduccion(rs.getInt(13));
                miLista.add(productos);
            }
        } catch (SQLException ex) {
            System.out.println("Error lista produccionDAo" + ex);
        }
        return miLista;
    }
         
public int insertProducccion( int nombre, String fecha, double cantidad) throws ClassNotFoundException {
        int insert = 1;
        try {
            this.conectandoBBDD();
              if(insert==1){
                 PreparedStatement st = this.miConexion.prepareStatement("INSERT INTO produccion ( Id_Productos, Fecha, CantidadEntrante)"
                        + "VALUES (?,?,?)");
                st.setInt(1, nombre);
                st.setString(2, fecha);
                st.setDouble(3, cantidad);
                insert=st.executeUpdate();                
              }               
            }
         catch (SQLException e) {
            System.out.println("Error metodo insert produccion dao" + e);
        }
        return insert;
    }
              
public int  updateProducto(int codigoProduccion, String nombre, String fecha, String tipo, int cantidad) throws ClassNotFoundException {
         this.conectandoBBDD();
        int update=1;
        try {
           if(update ==1){
            PreparedStatement st = this.miConexion.prepareStatement("UPDATE produccion SET Nombre=?, Fecha=?, Tipo=?, Cantidad=? WHERE Id_Produccion = '" + codigoProduccion + "'");
            st.setString(1, nombre);
            st.setString(2, fecha);
            st.setString(3, tipo);
            st.setInt(4, cantidad);
            update =st.executeUpdate();
           }
        } catch (SQLException e) {
            System.out.println("Error inexperado" + e);
        }
        return update;
    }
    
public int  borrar(int codigoProduccion) throws ClassNotFoundException {
         this.conectandoBBDD();
        int update=1;
        try {
           if(update ==1){
            PreparedStatement st = this.miConexion.prepareStatement("DELETE FROM produccion  WHERE Id_Produccion = '" + codigoProduccion + "'");
            update =st.executeUpdate();
           }
        } catch (SQLException e) {
            System.out.println("Error inexperado" + e);
        }
        return update;
    }
}
