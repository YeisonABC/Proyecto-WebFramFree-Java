/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

/**
 *
 * @author Familia Beltran
 */
public class estanteDTO {
    
    int codigoEstante;
    int existencia;
    String nombre;

    public estanteDTO() {
    }

    public estanteDTO(int codigoEstante, int existencia, String nombre) {
        this.codigoEstante = codigoEstante;
        this.existencia = existencia;
        this.nombre = nombre;
    }

    public int getCodigoEstante() {
        return codigoEstante;
    }

    public void setCodigoEstante(int codigoEstante) {
        this.codigoEstante = codigoEstante;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
