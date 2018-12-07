/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.persistence.impl;

import edu.eci.arsw.commerce.model.transaccion.Transaccion;
import edu.eci.arsw.commerce.model.transaccion.TransaccionRepository;
import edu.eci.arsw.commerce.persistence.TransaccionPersistence;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author camilo
 */
public class InMemoryTransaccionPersistence implements TransaccionPersistence {

    @Autowired
    TransaccionRepository tRepository;

    @Override
    public void crearNuevaTransaccion(Transaccion transaccion) {
        tRepository.save(transaccion);
    }

    @Override
    public List<Transaccion> obtenerTransacciones() {
        return tRepository.findAll();
    }

}
