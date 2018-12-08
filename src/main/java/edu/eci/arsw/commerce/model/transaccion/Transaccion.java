/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.model.transaccion;

import java.util.Date;
import org.springframework.data.annotation.Id;

/**
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

    public Transaccion(String tipoTransaccion, Integer cedulaComprador, Integer cedulaVendedor) {
        this.tipoTransaccion = tipoTransaccion;
        this.cedulaComprador = cedulaComprador;
        this.cedulaVendedor = cedulaVendedor;
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
