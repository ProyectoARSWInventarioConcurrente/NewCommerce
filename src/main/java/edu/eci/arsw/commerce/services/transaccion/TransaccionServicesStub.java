/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.services.transaccion;

import edu.eci.arsw.commerce.model.transaccion.Transaccion;
import edu.eci.arsw.commerce.persistence.TransaccionPersistence;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author camilo
 */
public class TransaccionServicesStub implements TransaccionServices{

    @Autowired
    TransaccionPersistence tPersistence;
    
    @Override
    public void crearNuevaTransaccion(Transaccion transaccion) {
        tPersistence.crearNuevaTransaccion(transaccion);
    }

    @Override
    public List<Transaccion> obtenerTransacciones() {
        return tPersistence.obtenerTransacciones();
    }
    
}
