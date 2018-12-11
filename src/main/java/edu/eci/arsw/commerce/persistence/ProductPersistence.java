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
     * @param pr
     * @throws ProductServicesException
     */
    public void crearNuevoProducto(Producto pr) throws ProductServicesException;

    /**
     *
     * @param vpr
     * @throws ProductServicesException
     */
    public void crearNuevaVariedadDeProducto(VariedadProducto vpr) throws ProductServicesException;

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
     * Este metodo nos permite obtener un producto mediante su Id.
     *
     * @param id El id del pruoducto
     * @return El producto que se estaba buscando con su Id.
     * @throws edu.eci.arsw.commerce.services.producto.ProductServicesException
     */
    public Producto obtenerProductoPorId(String id) throws ProductServicesException;

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
    public void eliminarUnProductoPorId(String idPorducto);

    /**
     * Esta funcion se encarga de borrar una variedad de producto mediante su Id
     *
     * @param idVProducto El id de la variedad del producto
     */
    public void eliminarUnaVariedadDeProductoPorId(Integer idVProducto);

}
