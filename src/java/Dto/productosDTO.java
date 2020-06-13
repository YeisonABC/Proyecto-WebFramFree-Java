    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;
import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author Familia Beltran
 */
public class productosDTO {

    //bodega
    int codigoBodega;
    String nombreBodega;
    //estante
    int codigoEstante;
    String nombreEstante;
    //Produccion
    int codigoProduccion;
    Date fechaProduccion;
    String tipoProduccion;
    double cantidadEntranteProduccion;
    String unidadMedidaProduccion;
    //tipoproducto
    int codigoTipoProducto;

    //productos
    int codigoProducto;
    String descripcionProducto;
    double cantidadExisteneProducto;
    int precioProducto;
   String nombreProducto;
   InputStream foto;
   
   
    public productosDTO(InputStream foto) {
        this.foto = foto;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public productosDTO() {
    }

    public productosDTO(int codigoBodega, String nombreBodega, int codigoEstante, String nombreEstante, int codigoProduccion, Date fechaProduccion, String tipoProduccion, double cantidadEntranteProduccion, String unidadMedidaProduccion, int codigoTipoProducto, int codigoProducto, String descripcionProducto, double cantidadExisteneProducto, int precioProducto, String nombreProducto) {
        this.codigoBodega = codigoBodega;
        this.nombreBodega = nombreBodega;
        this.codigoEstante = codigoEstante;
        this.nombreEstante = nombreEstante;
        this.codigoProduccion = codigoProduccion;
        this.fechaProduccion = fechaProduccion;
        this.tipoProduccion = tipoProduccion;
        this.cantidadEntranteProduccion = cantidadEntranteProduccion;
        this.unidadMedidaProduccion = unidadMedidaProduccion;
        this.codigoTipoProducto = codigoTipoProducto;
        this.codigoProducto = codigoProducto;
        this.descripcionProducto = descripcionProducto;
        this.cantidadExisteneProducto = cantidadExisteneProducto;
        this.precioProducto = precioProducto;
        this.nombreProducto = nombreProducto;
    }

    public int getCodigoBodega() {
        return codigoBodega;
    }

    public void setCodigoBodega(int codigoBodega) {
        this.codigoBodega = codigoBodega;
    }

    public String getNombreBodega() {
        return nombreBodega;
    }

    public void setNombreBodega(String nombreBodega) {
        this.nombreBodega = nombreBodega;
    }

    public int getCodigoEstante() {
        return codigoEstante;
    }

    public void setCodigoEstante(int codigoEstante) {
        this.codigoEstante = codigoEstante;
    }

    public String getNombreEstante() {
        return nombreEstante;
    }

    public void setNombreEstante(String nombreEstante) {
        this.nombreEstante = nombreEstante;
    }

    public int getCodigoProduccion() {
        return codigoProduccion;
    }

    public void setCodigoProduccion(int codigoProduccion) {
        this.codigoProduccion = codigoProduccion;
    }

    public Date getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(Date fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public String getTipoProduccion() {
        return tipoProduccion;
    }

    public void setTipoProduccion(String tipoProduccion) {
        this.tipoProduccion = tipoProduccion;
    }

    public double getCantidadEntranteProduccion() {
        return cantidadEntranteProduccion;
    }

    public void setCantidadEntranteProduccion(double cantidadEntranteProduccion) {
        this.cantidadEntranteProduccion = cantidadEntranteProduccion;
    }

    public String getUnidadMedidaProduccion() {
        return unidadMedidaProduccion;
    }

    public void setUnidadMedidaProduccion(String unidadMedidaProduccion) {
        this.unidadMedidaProduccion = unidadMedidaProduccion;
    }

    public int getCodigoTipoProducto() {
        return codigoTipoProducto;
    }

    public void setCodigoTipoProducto(int codigoTipoProducto) {
        this.codigoTipoProducto = codigoTipoProducto;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getCantidadExisteneProducto() {
        return cantidadExisteneProducto;
    }

    public void setCantidadExisteneProducto(double cantidadExisteneProducto) {
        this.cantidadExisteneProducto = cantidadExisteneProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

   
}
