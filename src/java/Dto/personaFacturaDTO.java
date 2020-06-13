/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.util.Date;

/**
 *
 * @author Sala300
 */
public class personaFacturaDTO {
    
    int codigoPersona;
    int codigoCargo;
    String nombrePersona;
    String apellido;
    String genero;
    String cedula;
    Date fechaVinculacion;
    String telefono;
    String tipoPersona;
    int codigoFactura;
    String tipoFactura;
    String formaPago;
    Date fecha;

    public personaFacturaDTO() {
    }

    public personaFacturaDTO(int codigoPersona, int codigoCargo, String nombrePersona, String apellido, String genero, String cedula, Date fechaVinculacion, String telefono, String tipoPersona, int codigoFactura, String tipoFactura, String formaPago, Date fecha) {
        this.codigoPersona = codigoPersona;
        this.codigoCargo = codigoCargo;
        this.nombrePersona = nombrePersona;
        this.apellido = apellido;
        this.genero = genero;
        this.cedula = cedula;
        this.fechaVinculacion = fechaVinculacion;
        this.telefono = telefono;
        this.tipoPersona = tipoPersona;
        this.codigoFactura = codigoFactura;
        this.tipoFactura = tipoFactura;
        this.formaPago = formaPago;
        this.fecha = fecha;
    }

    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public int getCodigoCargo() {
        return codigoCargo;
    }

    public void setCodigoCargo(int codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(Date fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public String getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
