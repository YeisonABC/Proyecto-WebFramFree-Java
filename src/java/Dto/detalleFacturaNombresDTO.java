/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.util.Date;

/**
 *
 * @author Equipo
 */
public class detalleFacturaNombresDTO {

    //propiedades de la tabla detalle factura
    int codigoDetalle;
    int codigoFactura;
    int codigoInsumo;
    int codigoProducto;
    int valorVenta;
    int cantidadRegistrada;
    int cantidadVenta;
    String unidadVenta;
    //propiedades de la tabla insumos         
    int cantidadInsumo;
    int precioInsumo;
    Date fechaInsumo;
    String nombreInsumo;
    String descripcionInsumo;
//    propiedades de la tabla productos
    int codigoEstante;
    String nombreProducto;
    String descripcionProducto;
    int cantidadExisteneProducto;
    int codigoTipoProducto;
    int precioUnidadProducto;
    int precioLibraProducto;
    int precioKiloProducto;
    int precioArrobaProducto;
    int precioBultoProducto;
       

    public detalleFacturaNombresDTO() {
    }

    public detalleFacturaNombresDTO(int codigoDetalle, int codigoFactura, int codigoInsumo, int codigoProducto, int valorVenta, int cantidadRegistrada, int cantidadVenta, String unidadVenta, int cantidadInsumo, int precioInsumo, Date fechaInsumo, String nombreInsumo, String descripcionInsumo, int codigoEstante, String nombreProducto, String descripcionProducto, int cantidadExisteneProducto, int codigoTipoProducto, int precioUnidadProducto, int precioLibraProducto, int precioKiloProducto, int precioArrobaProducto, int precioBultoProducto) {
        this.codigoDetalle = codigoDetalle;
        this.codigoFactura = codigoFactura;
        this.codigoInsumo = codigoInsumo;
        this.codigoProducto = codigoProducto;
        this.valorVenta = valorVenta;
        this.cantidadRegistrada = cantidadRegistrada;
        this.cantidadVenta = cantidadVenta;
        this.unidadVenta = unidadVenta;
        this.cantidadInsumo = cantidadInsumo;
        this.precioInsumo = precioInsumo;
        this.fechaInsumo = fechaInsumo;
        this.nombreInsumo = nombreInsumo;
        this.descripcionInsumo = descripcionInsumo;
        this.codigoEstante = codigoEstante;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.cantidadExisteneProducto = cantidadExisteneProducto;
        this.codigoTipoProducto = codigoTipoProducto;
        this.precioUnidadProducto = precioUnidadProducto;
        this.precioLibraProducto = precioLibraProducto;
        this.precioKiloProducto = precioKiloProducto;
        this.precioArrobaProducto = precioArrobaProducto;
        this.precioBultoProducto = precioBultoProducto;
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

    public int getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(int cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }

    public int getPrecioInsumo() {
        return precioInsumo;
    }

    public void setPrecioInsumo(int precioInsumo) {
        this.precioInsumo = precioInsumo;
    }

    public Date getFechaInsumo() {
        return fechaInsumo;
    }

    public void setFechaInsumo(Date fechaInsumo) {
        this.fechaInsumo = fechaInsumo;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public String getDescripcionInsumo() {
        return descripcionInsumo;
    }

    public void setDescripcionInsumo(String descripcionInsumo) {
        this.descripcionInsumo = descripcionInsumo;
    }

    public int getCodigoEstante() {
        return codigoEstante;
    }

    public void setCodigoEstante(int codigoEstante) {
        this.codigoEstante = codigoEstante;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getCantidadExisteneProducto() {
        return cantidadExisteneProducto;
    }

    public void setCantidadExisteneProducto(int cantidadExisteneProducto) {
        this.cantidadExisteneProducto = cantidadExisteneProducto;
    }

    public int getCodigoTipoProducto() {
        return codigoTipoProducto;
    }

    public void setCodigoTipoProducto(int codigoTipoProducto) {
        this.codigoTipoProducto = codigoTipoProducto;
    }

    public int getPrecioUnidadProducto() {
        return precioUnidadProducto;
    }

    public void setPrecioUnidadProducto(int precioUnidadProducto) {
        this.precioUnidadProducto = precioUnidadProducto;
    }

    public int getPrecioLibraProducto() {
        return precioLibraProducto;
    }

    public void setPrecioLibraProducto(int precioLibraProducto) {
        this.precioLibraProducto = precioLibraProducto;
    }

    public int getPrecioKiloProducto() {
        return precioKiloProducto;
    }

    public void setPrecioKiloProducto(int precioKiloProducto) {
        this.precioKiloProducto = precioKiloProducto;
    }

    public int getPrecioArrobaProducto() {
        return precioArrobaProducto;
    }

    public void setPrecioArrobaProducto(int precioArrobaProducto) {
        this.precioArrobaProducto = precioArrobaProducto;
    }

    public int getPrecioBultoProducto() {
        return precioBultoProducto;
    }

    public void setPrecioBultoProducto(int precioBultoProducto) {
        this.precioBultoProducto = precioBultoProducto;
    }

  
    
}
