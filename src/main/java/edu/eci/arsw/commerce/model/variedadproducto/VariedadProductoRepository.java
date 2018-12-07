/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.model.variedadproducto;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author camilo
 */
public interface VariedadProductoRepository extends MongoRepository<VariedadProducto, String> {

    /**
     *
     * @param idVProducto
     * @return
     */
    public VariedadProducto findByidVProducto(Integer idVProducto);

    /**
     *
     * @param idUsuario
     * @return
     */
    public List<VariedadProducto> findByidUsuario(Integer idUsuario);

    /**
     *
     * @param idProducto
     * @return
     */
    public List<VariedadProducto> findByidProducto(Integer idProducto);

}
