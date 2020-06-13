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
public class loginDTO {
    
    int codigoLogin;
    int codigoPersona;
    String usuario;
    String clave;
    String correo;
    int idCargo;
    String nombre;
    String apellido;

    public loginDTO() {
    }

    public loginDTO(int codigoLogin, int codigoPersona, String usuario, String clave, String correo, int idCargo, String nombre, String apellido) {
        this.codigoLogin = codigoLogin;
        this.codigoPersona = codigoPersona;
        this.usuario = usuario;
        this.clave = clave;
        this.correo = correo;
        this.idCargo = idCargo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCodigoLogin() {
        return codigoLogin;
    }

    public void setCodigoLogin(int codigoLogin) {
        this.codigoLogin = codigoLogin;
    }

    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
