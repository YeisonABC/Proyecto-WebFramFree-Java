/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.util.Date;

/**
 *
 * @author Familia Beltran
 */
public class registroSalidaDTO {
    int codigoSalida;
    int codigoPersona;
    int codigoInsumo;
    int cantidad;
    Date fecha;

    public registroSalidaDTO() {
    }

    public registroSalidaDTO(int codigoSalida, int codigoPersona, int codigoInsumo, int cantidad, Date fecha) {
        this.codigoSalida = codigoSalida;
        this.codigoPersona = codigoPersona;
        this.codigoInsumo = codigoInsumo;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getCodigoSalida() {
        return codigoSalida;
    }

    public void setCodigoSalida(int codigoSalida) {
        this.codigoSalida = codigoSalida;
    }

    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public int getCodigoInsumo() {
        return codigoInsumo;
    }

    public void setCodigoInsumo(int codigoInsumo) {
        this.codigoInsumo = codigoInsumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
