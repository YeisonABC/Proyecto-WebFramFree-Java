
package Dto;


public class cargoDTO {
    int codioCargo;
    String nombre;

    public cargoDTO() {
    }

    public cargoDTO(int codioCargo, String nombre) {
        this.codioCargo = codioCargo;
        this.nombre = nombre;
    }

    public int getCodioCargo() {
        return codioCargo;
    }

    public void setCodioCargo(int codioCargo) {
        this.codioCargo = codioCargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
