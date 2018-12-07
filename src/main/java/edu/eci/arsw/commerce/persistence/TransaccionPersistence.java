/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.persistence;

import edu.eci.arsw.commerce.model.transaccion.Transaccion;
import java.util.List;

/**
 *
 * @author camilo
 */
public interface TransaccionPersistence {
    
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
    
}
