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
public class produccionDTO {
    int codigoProduccion;
    int codigoTipoProduccion;
    String fecha;
    int cantidadEntrante;
    String unidadMedida;
    String nombreTipoPro;
    String tipoProducto;

    public produccionDTO(int codigoProduccion, int codigoTipoProduccion, String fecha, int cantidadEntrante, String unidadMedida, String nombreTipoPro, String tipoProducto) {
        this.codigoProduccion = codigoProduccion;
        this.codigoTipoProduccion = codigoTipoProduccion;
        this.fecha = fecha;
        this.cantidadEntrante = cantidadEntrante;
        this.unidadMedida = unidadMedida;
        this.nombreTipoPro = nombreTipoPro;
        this.tipoProducto = tipoProducto;
    }
    
    public produccionDTO() {
    }

    public int getCodigoProduccion() {
        return codigoProduccion;
    }

    public void setCodigoProduccion(int codigoProduccion) {
        this.codigoProduccion = codigoProduccion;
    }

    public int getCodigoTipoProduccion() {
        return codigoTipoProduccion;
    }

    public void setCodigoTipoProduccion(int codigoTipoProduccion) {
        this.codigoTipoProduccion = codigoTipoProduccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidadEntrante() {
        return cantidadEntrante;
    }

    public void setCantidadEntrante(int cantidadEntrante) {
        this.cantidadEntrante = cantidadEntrante;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getNombreTipoPro() {
        return nombreTipoPro;
    }

    public void setNombreTipoPro(String nombreTipoPro) {
        this.nombreTipoPro = nombreTipoPro;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }


}
