/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.services;

import edu.eci.arsw.commerce.model.Producto;
import edu.eci.arsw.commerce.model.VariedadProducto;
import edu.eci.arsw.commerce.persistence.ProductPersistence;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementacion de cada uno de los servicios que ofrecen los productos y sus
 * variedades
 *
 * @author camilolopez
 */
@Service
public class ProductServicesStub implements ProductServices {

    @Autowired
    ProductPersistence pPersistence;
    
    /**
     * En este constructor se crean productos y variedades de productos para
     * pruebas futuras
     */
    public ProductServicesStub() {
        
    }

    @Override
    public Double calcularPrecioProductoPorId(Integer idProducto) throws ProductServicesException {
        return pPersistence.calcularPrecioProductoPorId(idProducto);
    }

    @Override
    public Producto obtenerVariedadProductoPorId(Integer idProducto) throws ProductServicesException {
        return pPersistence.obtenerVariedadProductoPorId(idProducto);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() throws ProductServicesException {
        return pPersistence.obtenerTodosLosProductos();
    }

    @Override
    public List<Producto> obtenerTodaLaVariedadDeProductosPorIdProducto(Integer idProducto) throws ProductServicesException {
        return pPersistence.obtenerTodaLaVariedadDeProductosPorIdProducto(idProducto);
    }

    @Override
    public void crearNuevoProducto(String nombreProducto, Integer idProducto, String categoriaProducto) throws ProductServicesException {
        pPersistence.crearNuevoProducto(nombreProducto, idProducto, categoriaProducto);
    }

    @Override
    public void crearNuevaVariedadDeProducto(String nombreProducto, Integer idProducto, String categoriaProducto,
            Integer idVProducto, String nombreVProducto, Integer idCliente) throws ProductServicesException {
        pPersistence.crearNuevaVariedadDeProducto(nombreProducto, idProducto, categoriaProducto, idVProducto,
                nombreVProducto, idCliente);
    }

    @Override
    public List<VariedadProducto> obtenerVariedadDeProductosPorIdDeUsuario(Integer idUsuario) {
        return pPersistence.obtenerVariedadDeProductosPorIdDeUsuario(idUsuario);
    }

    @Override
    public List<VariedadProducto> obtenerTodasLasVariedades() {
        return pPersistence.obtenerTodasLasVariedades();
    }

}
