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
public class bodegaDTO {
    
    int codigoBodega;
    int codigoEstante;
    String nombre;

    public bodegaDTO() {
    }

    public bodegaDTO(int codigoBodega, int codigoEstante, String nombre) {
        this.codigoBodega = codigoBodega;
        this.codigoEstante = codigoEstante;
        this.nombre = nombre;
    }

    public int getCodigoBodega() {
        return codigoBodega;
    }

    public void setCodigoBodega(int codigoBodega) {
        this.codigoBodega = codigoBodega;
    }

    public int getCodigoEstante() {
        return codigoEstante;
    }

    public void setCodigoEstante(int codigoEstante) {
        this.codigoEstante = codigoEstante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
