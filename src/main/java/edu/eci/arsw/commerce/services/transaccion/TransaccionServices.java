/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.services.transaccion;

import edu.eci.arsw.commerce.model.transaccion.Transaccion;
import java.util.List;

/**
 * Esta clase pertenece a los servicios que ofrecen las transacciones, como
 * obtenerlas, crearlas o eliminarlas
 *
 * @author camilo
 */
public interface TransaccionServices {

    /**
     * Este metodo permite crear una nueva Transaccion en el sistema.
     *
     * @param transaccion El objeto transaccion que sera creado.
     */
    public void crearNuevaTransaccion(Transaccion transaccion);

    /**
     * Este metodo devuelve todas las transacciones que han sido creadas.
     *
     * @return Una lista con todas las transacciones.
     */
    public List<Transaccion> obtenerTransacciones();

    /**
     * Este metodo permite obtener una o muchas transacciones dada una cedula de
     * un vendedor.
     *
     * @param cedulaVendedor El numero de cedula del vendedor.
     * @return La lista con las transacciones que ha realizado el vendedor.
     */
    public List<Transaccion> obtenerTransaccionesPorCedulaVendedor(Integer cedulaVendedor);

    /**
     * Este metodo perminte obtener una o muchas transacciones dada una cedula
     * de un comprador.
     *
     * @param cedulaComprador El numero de cedula del comprador.
     * @return La lista con las transacciones que ha realizado el comprador.
     */
    public List<Transaccion> obtenerTransaccionesPorCedulaComprador(Integer cedulaComprador);

    /**
     * Este metodo permite eliminar una transaccion que ya se ha realizado.
     *
     * @param idTransaccion El id el cual pertenece a la transaccion.
     */
    public void eliminarTransaccion(String idTransaccion);

}
