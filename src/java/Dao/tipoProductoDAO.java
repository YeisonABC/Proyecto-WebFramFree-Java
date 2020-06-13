/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.tipoProductoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.conexion;

/**
 *
 * @author Familia Beltran
 */
public class tipoProductoDAO {
    
    
        public ArrayList<tipoProductoDTO> listaProducto() {
        conexion miConexion = new conexion();
        ArrayList<tipoProductoDTO> miLista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tipo_producto";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                tipoProductoDTO productos = new tipoProductoDTO();
                productos.setCodigoTipoProducto(rs.getInt(1));
                productos.setNombre(rs.getString(2));
                productos.setTipoproducto(rs.getString(3));
                miLista.add(productos);
            }
        } catch (SQLException ex) {
            System.out.println("Error metodo lista producto dao" + ex);
        }
        return miLista;
    }
}
