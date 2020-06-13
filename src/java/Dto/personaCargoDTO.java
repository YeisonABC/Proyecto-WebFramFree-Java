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
public class personaCargoDTO {
       
    int codigoPersona;
    int codigoCargo;
    String nombrePersona;
    String nombreCargo;
    String apellido;
    String genero;
    String cedula;
    Date fechaVinculacion;
    String telefono;
    String tipoPersona;
    String direccion;
    String correo;
    String contrasena;

    public personaCargoDTO() {
    }

    public personaCargoDTO(int codigoPersona, int codigoCargo, String nombrePersona, String nombreCargo, String apellido, String genero, String cedula, Date fechaVinculacion, String telefono, String tipoPersona, String direccion, String correo, String contrasena) {
        this.codigoPersona = codigoPersona;
        this.codigoCargo = codigoCargo;
        this.nombrePersona = nombrePersona;
        this.nombreCargo = nombreCargo;
        this.apellido = apellido;
        this.genero = genero;
        this.cedula = cedula;
        this.fechaVinculacion = fechaVinculacion;
        this.telefono = telefono;
        this.tipoPersona = tipoPersona;
        this.direccion = direccion;
        this.correo = correo;
        this.contrasena = contrasena;
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

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    
}
