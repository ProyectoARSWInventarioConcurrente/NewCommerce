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
    public VariedadProducto obtenerVariedadProductoPorId(Integer idProducto) throws ProductServicesException {
        return pPersistence.obtenerVariedadProductoPorId(idProducto);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() throws ProductServicesException {
        return pPersistence.obtenerTodosLosProductos();
    }

    @Override
    public List<VariedadProducto> obtenerTodaLaVariedadDeProductosPorIdProducto(Integer idProducto) throws ProductServicesException {
        return pPersistence.obtenerTodaLaVariedadDeProductosPorIdProducto(idProducto);
    }

    @Override
    public void crearNuevoProducto(String nombreProducto, String categoriaProducto) throws ProductServicesException {
        pPersistence.crearNuevoProducto(nombreProducto, categoriaProducto);
    }

    @Override
    public void crearNuevaVariedadDeProducto(Integer idProducto, Integer idVProducto, String nombreVProducto,
            Integer idCliente) throws ProductServicesException {
        pPersistence.crearNuevaVariedadDeProducto(idProducto, idVProducto, nombreVProducto, idCliente);
    }

    @Override
    public List<VariedadProducto> obtenerVariedadDeProductosPorIdDeUsuario(Integer idUsuario) {
        return pPersistence.obtenerVariedadDeProductosPorIdDeUsuario(idUsuario);
    }

    @Override
    public List<VariedadProducto> obtenerTodasLasVariedades() {
        return pPersistence.obtenerTodasLasVariedades();
    }

    @Override
    public void eliminarUnProductoPorId(Integer idPorducto) {
        pPersistence.eliminarUnProductoPorId(idPorducto);
    }

    @Override
    public void eliminarUnaVariedadDeProductoPorId(Integer idVProducto) {
        pPersistence.eliminarUnaVariedadDeProductoPorId(idVProducto);
    }

}
