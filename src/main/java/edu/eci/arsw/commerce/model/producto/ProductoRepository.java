/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.model.producto;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author camilo
 */
public interface ProductoRepository extends MongoRepository<Producto, String> {

    /**
     *
     * @param idProducto
     * @return
     */
    public Producto findByidProducto(Integer idProducto);

}
