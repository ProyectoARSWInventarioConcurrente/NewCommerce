/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.services.producto;

import edu.eci.arsw.commerce.model.producto.Producto;
import edu.eci.arsw.commerce.model.variedadproducto.VariedadProducto;
import java.util.List;

/**
 * Cada uno de los servicios que ofrecen los productos y las variedades de los
 * productos
 *
 * @author camilolopez
 */
public interface ProductServices {

    /**
     * Crear un nuevo producto dado sus atributos
     *
     * @param pr
     * @throws edu.eci.arsw.commerce.services.producto.ProductServicesException
     */
    public void crearNuevoProducto(Producto pr) throws ProductServicesException;

    /**
     * Crear una nueva variedad de producto dado sus atributos que lo componen
     *
     * @param vpr
     * @throws edu.eci.arsw.commerce.services.producto.ProductServicesException
     */
    public void crearNuevaVariedadDeProducto(VariedadProducto vpr) throws ProductServicesException;

    /**
     * Obtener la variedad de producto dado un id
     *
     * @param idProducto Id de la variedad del producto
     * @return La variedad del producto
     * @throws edu.eci.arsw.commerce.services.producto.ProductServicesException
     */
    public VariedadProducto obtenerVariedadProductoPorId(String idProducto) throws ProductServicesException;

    /**
     * Obtiene todos los productos que han sido registrados
     *
     * @return Lista con todos los productos
     * @throws edu.eci.arsw.commerce.services.producto.ProductServicesException
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
     * Obtiene todas las variedades que han sido registradas
     *
     * @return Lista con todas las variedades
     */
    public List<VariedadProducto> obtenerTodasLasVariedades();

    /**
     * Obtiene las variedades de productos que han sido registradas en un
     * producto
     *
     * @param idProducto Id del producto al cual pertenecen las variedades
     * @return Lista con las variedades
     * @throws edu.eci.arsw.commerce.services.producto.ProductServicesException
     */
    public List<VariedadProducto> obtenerTodaLaVariedadDeProductosPorIdProducto(Integer idProducto) throws ProductServicesException;

    /**
     * Obtener la lista de variedades de productos los cuales pertenecen a un
     * usuario
     *
     * @param idUsuario El id del usuario
     * @return Lista con las variedades del usuario
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
    public void eliminarUnaVariedadDeProductoPorId(String idVProducto);
}
