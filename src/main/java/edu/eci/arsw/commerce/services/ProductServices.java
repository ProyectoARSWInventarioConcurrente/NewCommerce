/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.services;

import edu.eci.arsw.commerce.model.Producto;
import edu.eci.arsw.commerce.model.VariedadProducto;
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
     * @param nombreProducto Nombre que tendra el producto
     * @param idProducto Id que tendra el producto
     * @param categoriaProducto Categoria a la cual pertencera el producto
     * @throws com.arsw.project.commerce.services.ProductServicesException
     */
    public void crearNuevoProducto(String nombreProducto, Integer idProducto,
            String categoriaProducto) throws ProductServicesException;

    /**
     * Crear una nueva variedad de producto dado sus atributos que lo componen
     *
     * @param nombreProducto Nombre del producto al cual pertenece
     * @param idProducto Id del producto al cual pertenece
     * @param categoriaProducto Categoria del producto al cual pertenece
     * @param idVProducto Id que tendra la variedad del producto
     * @param nombreVProducto Nombre que tendra la variedad del producto
     * @param idUsuario Id del cliente al cual pertenece el producto
     * @throws com.arsw.project.commerce.services.ProductServicesException
     */
    public void crearNuevaVariedadDeProducto(Integer idProducto, Integer idVProducto,
            String nombreVProducto, Integer idUsuario) throws ProductServicesException;

    /**
     * Obtener la variedad de producto dado un id
     *
     * @param idProducto Id de la variedad del producto
     * @return La variedad del producto
     * @throws com.arsw.project.commerce.services.ProductServicesException
     */
    public VariedadProducto obtenerVariedadProductoPorId(Integer idProducto) throws ProductServicesException;

    /**
     * Obtiene todos los productos que han sido registrados
     *
     * @return Lista con todos los productos
     * @throws com.arsw.project.commerce.services.ProductServicesException
     */
    public List<Producto> obtenerTodosLosProductos() throws ProductServicesException;
    
    /**
     * Obtiene todas las variedades que han sido registradas
     * @return Lista con todas las variedades
     */
    public List<VariedadProducto> obtenerTodasLasVariedades();

    /**
     * Obtiene las variedades de productos que han sido registradas en un
     * producto
     *
     * @param idProducto Id del producto al cual pertenecen las variedades
     * @return Lista con las variedades
     * @throws com.arsw.project.commerce.services.ProductServicesException
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
}
