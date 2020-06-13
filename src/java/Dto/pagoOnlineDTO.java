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
public class pagoOnlineDTO {
    
    int codigoPagoOnline;
    int precioPago;

    public pagoOnlineDTO() {
    }

    
    public pagoOnlineDTO(int codigoPagoOnline, int precioPago) {
        this.codigoPagoOnline = codigoPagoOnline;
        this.precioPago = precioPago;
    }

    public int getCodigoPagoOnline() {
        return codigoPagoOnline;
    }

    public void setCodigoPagoOnline(int codigoPagoOnline) {
        this.codigoPagoOnline = codigoPagoOnline;
    }

    public int getPrecioPago() {
        return precioPago;
    }

    public void setPrecioPago(int precioPago) {
        this.precioPago = precioPago;
    }
    
    
}
