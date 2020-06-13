/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.util.List;

/**
 *
 * @author Familia Beltran
 */
public class facturaDTO {

    int codigoFactura;
    personaFacturaDTO cliente;
    String fecha;
    int idPago;
    int precio;
    List<carritoDTO> detalleCompras;

    public facturaDTO() {
    }

    public facturaDTO(personaFacturaDTO cliente, String fecha, int idPago, int precio, List<carritoDTO> detalleCompras) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.idPago = idPago;
        this.precio = precio;
        this.detalleCompras = detalleCompras;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public personaFacturaDTO getCliente() {
        return cliente;
    }

    public void setCliente(personaFacturaDTO cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public List<carritoDTO> getDetalleCompras() {
        return detalleCompras;
    }

    public void setDetalleCompras(List<carritoDTO> detalleCompras) {
        this.detalleCompras = detalleCompras;
    }

}
