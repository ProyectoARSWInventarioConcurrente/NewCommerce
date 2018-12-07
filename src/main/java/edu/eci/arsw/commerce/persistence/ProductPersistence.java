/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.persistence;

import edu.eci.arsw.commerce.model.producto.Producto;
import edu.eci.arsw.commerce.model.variedadproducto.VariedadProducto;
import edu.eci.arsw.commerce.services.producto.ProductServicesException;
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
    public void crearNuevoProducto(String nombreProducto, String categoriaProducto)
            throws ProductServicesException;

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
    public void crearNuevaVariedadDeProducto(Integer idProducto, Integer idVProducto,
            String nombreVProducto, Integer idUsuario) throws ProductServicesException;

    /**
     *
     * @param idProducto
     * @return
     * @throws ProductServicesException
     */
    public VariedadProducto obtenerVariedadProductoPorId(Integer idProducto) throws ProductServicesException;

    /**
     *
     * @return @throws ProductServicesException
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

    /**
     * Esta funcion se encarga de eliminar un producto mediante su Id
     *
     * @param idPorducto El id del producto a ser eliminado
     */
    public void eliminarUnProductoPorId(Integer idPorducto);

    /**
     * Esta funcion se encarga de borrar una variedad de producto mediante su Id
     *
     * @param idVProducto El id de la variedad del producto
     */
    public void eliminarUnaVariedadDeProductoPorId(Integer idVProducto);

}
