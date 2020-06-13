/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.estanteDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.conexion;

/**
 *
 * @author Familia Beltran
 */
public class estanteDAO extends conexion{
    
public ArrayList<estanteDTO> listaEstante() {
        conexion miConexion = new conexion();
        ArrayList<estanteDTO> miLista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM estante";
            ResultSet rs = miConexion.ConsultaSelect(sql);
            while (rs.next()) {
                estanteDTO estante = new estanteDTO();
                estante.setCodigoEstante(rs.getInt(1));
                estante.setNombre(rs.getString(2));
                miLista.add(estante);
            }
        } catch (SQLException ex) {
            System.out.println("Error lista listaEstante DAO " + ex);
        }
        return miLista;
    }
}
