/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.services.transaccion;

import edu.eci.arsw.commerce.model.transaccion.Transaccion;
import java.util.List;

/**
 *
 * @author camilo
 */
public interface TransaccionServices {

    /**
     *
     * @param transaccion
     */
    public void crearNuevaTransaccion(Transaccion transaccion);

    /**
     *
     * @return
     */
    public List<Transaccion> obtenerTransacciones();

    /**
     *
     * @param cedulaVendedor
     * @return
     */
    public List<Transaccion> obtenerTransaccionesPorCedulaVendedor(Integer cedulaVendedor);

    /**
     *
     * @param cedulaComprador
     * @return
     */
    public List<Transaccion> obtenerTransaccionesPorCedulaComprador(Integer cedulaComprador);

    /**
     *
     * @param idTransaccion
     */
    public void eliminarTransaccion(String idTransaccion);    
    
}
