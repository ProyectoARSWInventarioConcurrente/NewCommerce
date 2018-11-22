/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.persistence;

import edu.eci.arsw.commerce.model.Producto;
import edu.eci.arsw.commerce.model.VariedadProducto;
import edu.eci.arsw.commerce.services.ProductServicesException;
import java.util.List;

/**
 *
 * @author camilo
 */
public interface ProductPersistence {
    
    /**
     *
     * @param nombreProducto
     * @param idProducto
     * @param categoriaProducto
     * @throws ProductServicesException
     */
    public void crearNuevoProducto(String nombreProducto, Integer idProducto,
            String categoriaProducto) throws ProductServicesException;

    /**
     *
     * @param nombreProducto
     * @param idProducto
     * @param categoriaProducto
     * @param idVProducto
     * @param nombreVProducto
     * @param idUsuario
     * @throws ProductServicesException
     */
    public void crearNuevaVariedadDeProducto(String nombreProducto, Integer idProducto,
            String categoriaProducto, Integer idVProducto, String nombreVProducto,
            Integer idUsuario) throws ProductServicesException;

    /**
     *
     * @param idProducto
     * @return
     * @throws ProductServicesException
     */
    public VariedadProducto obtenerVariedadProductoPorId(Integer idProducto) throws ProductServicesException;
    
    /**
     *
     * @return
     * @throws ProductServicesException
     */
    public List<Producto> obtenerTodosLosProductos() throws ProductServicesException;
    
    /**
     *
     * @return
     */
    public List<VariedadProducto> obtenerTodasLasVariedades();
    
    /**
     *
     * @param idProducto
     * @return
     * @throws ProductServicesException
     */
    public List<VariedadProducto> obtenerTodaLaVariedadDeProductosPorIdProducto(Integer idProducto) throws ProductServicesException;
    
    /**
     *
     * @param idUsuario
     * @return
     */
    public List<VariedadProducto> obtenerVariedadDeProductosPorIdDeUsuario(Integer idUsuario);
    
}
