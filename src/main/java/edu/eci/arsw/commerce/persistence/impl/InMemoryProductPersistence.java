/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.persistence.impl;

import edu.eci.arsw.commerce.model.producto.Producto;
import edu.eci.arsw.commerce.model.producto.ProductoRepository;
import edu.eci.arsw.commerce.model.variedadproducto.VariedadProducto;
import edu.eci.arsw.commerce.model.variedadproducto.VariedadProductoRepository;
import edu.eci.arsw.commerce.persistence.ProductPersistence;
import edu.eci.arsw.commerce.services.producto.ProductServicesException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author camilo
 */
@Service
public class InMemoryProductPersistence implements ProductPersistence {

    @Autowired
    ProductoRepository pRepository;

    @Autowired
    VariedadProductoRepository vpRepository;

    public InMemoryProductPersistence() {
    }

    @Override
    public void crearNuevoProducto(String nombreProducto, String categoriaProducto) throws ProductServicesException {
        try {
            Producto nuevoProducto = new Producto(nombreProducto, categoriaProducto);

            pRepository.save(nuevoProducto);
        } catch (Exception e) {
            System.out.println("No se ha podido crear el producto");
        }
    }

    @Override
    public void crearNuevaVariedadDeProducto(VariedadProducto vpr) throws ProductServicesException {
        try {
            vpRepository.save(vpr);
        } catch (Exception e) {
            System.out.println("No se ha podido crear la variedad del producto");
        }
    }

    @Override
    public VariedadProducto obtenerVariedadProductoPorId(Integer idVariedadProducto) throws ProductServicesException {
        VariedadProducto variedadProductoARetornar = null;
        List<VariedadProducto> listaVariedadProducto = vpRepository.findAll();
        for (VariedadProducto x : listaVariedadProducto) {
            if (x.getIdVProducto().equals(idVariedadProducto)) {
                variedadProductoARetornar = x;
            }
        }
        return variedadProductoARetornar;
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() throws ProductServicesException {
        List<Producto> listaProductos = new ArrayList<>();
        try {
            listaProductos = pRepository.findAll();
            return listaProductos;
        } catch (Exception e) {
            System.out.println("No se han podido obtener los productos");
            return listaProductos;
        }
    }

    @Override
    public List<VariedadProducto> obtenerTodasLasVariedades() {
        List<VariedadProducto> listaVariedadProductos = new ArrayList<>();
        try {
            listaVariedadProductos = vpRepository.findAll();
            return listaVariedadProductos;
        } catch (Exception e) {
            System.out.println("No se han podido retornar las variedades");
            return listaVariedadProductos;
        }
    }

    @Override
    public List<VariedadProducto> obtenerTodaLaVariedadDeProductosPorIdProducto(Integer idProducto) throws ProductServicesException {
        List<VariedadProducto> listaARetornar = vpRepository.findByidProducto(idProducto);
        try {
            return listaARetornar;
        } catch (Exception e) {
            System.out.println("No se han podido obtener las variedades del producto");
            return listaARetornar;
        }
    }

    @Override
    public List<VariedadProducto> obtenerVariedadDeProductosPorIdDeUsuario(Integer idUsuario) {
        List<VariedadProducto> listaVariedades = vpRepository.findByidProducto(idUsuario);
        try {
            return listaVariedades;
        } catch (Exception e) {
            System.out.println("No se han podido obtener las variedades");
            return listaVariedades;
        }
    }

    @Override
    public void eliminarUnProductoPorId(String idProducto) {
        try {
            pRepository.delete(idProducto);
        } catch (Exception ex) {
            System.out.println("Error al tratar de eliminar el producto con id: " + idProducto);
        }
    }

    @Override
    public void eliminarUnaVariedadDeProductoPorId(Integer idVProducto) {
        try {
            VariedadProducto vProductoAEliminar = vpRepository.findByidVProducto(idVProducto);
            vpRepository.delete(vProductoAEliminar);
        } catch (Exception ex) {
            System.out.println("Error al tratar de eliminar la variedad de producto con id: " + idVProducto);
        }
    }

}
