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
     * Este metodo nos permite obtener un producto desde la base de datos
     * MongoDB.
     *
     * @param idProducto El id del producto que se quiere obtener.
     * @return El producto que se esta buscando.
     */
    public Producto findByidProducto(String idProducto);

}
