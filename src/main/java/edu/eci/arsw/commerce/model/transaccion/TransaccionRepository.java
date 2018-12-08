/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.model.transaccion;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author camilo
 */
public interface TransaccionRepository extends MongoRepository<Transaccion, String>{
    
    /**
     *
     * @param cedulaVendedor
     * @return
     */
    public List<Transaccion> findBycedulaVendedor(Integer cedulaVendedor);
    
    /**
     *
     * @param cedulaComprador
     * @return
     */
    public List<Transaccion> findBycedulaComprador(Integer cedulaComprador);
}
