/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

/**
 *
 * @author SALA300
 */
public class tipoProductoDTO {
    
    int codigoTipoProducto;
    String tipoproducto;
    String nombre;

    public tipoProductoDTO() {
    }

    public tipoProductoDTO(int codigoTipoProducto, String tipoproducto, String nombre) {
        this.codigoTipoProducto = codigoTipoProducto;
        this.tipoproducto = tipoproducto;
        this.nombre = nombre;
    }

    public int getCodigoTipoProducto() {
        return codigoTipoProducto;
    }

    public void setCodigoTipoProducto(int codigoTipoProducto) {
        this.codigoTipoProducto = codigoTipoProducto;
    }

    public String getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(String tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
