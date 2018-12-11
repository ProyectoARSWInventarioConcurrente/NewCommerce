/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.model.transaccion;

import java.util.Date;
import org.springframework.data.annotation.Id;

/**
 * Esta clase es la de Transaccion, una transaccion es la accion que se realiza
 * entre un comprador y un vendedor, en este caso sera la venta, la compra o el
 * intercambion de un producto determinado.
 *
 * @author camilo
 */
public class Transaccion {

    @Id
    public String idTransaccion;

    private String tipoTransaccion;
    private Integer cedulaComprador;
    private Integer cedulaVendedor;
    private Date fechaTransaccion;
    private String idVProducto;
    private Boolean completada;

    public Transaccion(String tipoTransaccion, Integer cedulaComprador, Integer cedulaVendedor, String idVProducto) {
        this.tipoTransaccion = tipoTransaccion;
        this.cedulaComprador = cedulaComprador;
        this.cedulaVendedor = cedulaVendedor;
        this.fechaTransaccion = new Date();
        this.idVProducto = idVProducto;
        this.completada = false;
    }

    public Boolean getCompletada() {
        return completada;
    }

    public void setCompletada(Boolean completada) {
        this.completada = completada;
    }
    
    

    public String getIdVProducto() {
        return idVProducto;
    }

    public void setIdVProducto(String idVProducto) {
        this.idVProducto = idVProducto;
    }
    
    

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Integer getCedulaComprador() {
        return cedulaComprador;
    }

    public void setCedulaComprador(Integer cedulaComprador) {
        this.cedulaComprador = cedulaComprador;
    }

    public Integer getCedulaVendedor() {
        return cedulaVendedor;
    }

    public void setCedulaVendedor(Integer cedulaVendedor) {
        this.cedulaVendedor = cedulaVendedor;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

}
