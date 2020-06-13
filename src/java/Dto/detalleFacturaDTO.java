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
public class detalleFacturaDTO{
    
    int codigoDetalle;
    int codigoFactura;
    int codigoInsumo;
    int codigoProducto;
    int valorVenta;
    int cantidadRegistrada;
    int cantidadVenta;
    String unidadVenta;

    public detalleFacturaDTO() {
    }

    public detalleFacturaDTO(int codigoDetalle, int codigoFactura, int codigoInsumo, int codigoProducto, int valorVenta, int cantidadRegistrada, int cantidadVenta, String unidadVenta) {
        this.codigoDetalle = codigoDetalle;
        this.codigoFactura = codigoFactura;
        this.codigoInsumo = codigoInsumo;
        this.codigoProducto = codigoProducto;
        this.valorVenta = valorVenta;
        this.cantidadRegistrada = cantidadRegistrada;
        this.cantidadVenta = cantidadVenta;
        this.unidadVenta = unidadVenta;
    }

    public int getCodigoDetalle() {
        return codigoDetalle;
    }

    public void setCodigoDetalle(int codigoDetalle) {
        this.codigoDetalle = codigoDetalle;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public int getCodigoInsumo() {
        return codigoInsumo;
    }

    public void setCodigoInsumo(int codigoInsumo) {
        this.codigoInsumo = codigoInsumo;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(int valorVenta) {
        this.valorVenta = valorVenta;
    }

    public int getCantidadRegistrada() {
        return cantidadRegistrada;
    }

    public void setCantidadRegistrada(int cantidadRegistrada) {
        this.cantidadRegistrada = cantidadRegistrada;
    }

    public int getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(int cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }

    public String getUnidadVenta() {
        return unidadVenta;
    }

    public void setUnidadVenta(String unidadVenta) {
        this.unidadVenta = unidadVenta;
    }
    
    

    
    
    
    
}
