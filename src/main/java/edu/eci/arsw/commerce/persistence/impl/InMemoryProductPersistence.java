/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.persistence.impl;

import edu.eci.arsw.commerce.model.Producto;
import edu.eci.arsw.commerce.model.VariedadProducto;
import edu.eci.arsw.commerce.persistence.ProductPersistence;
import edu.eci.arsw.commerce.services.ProductServicesException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camilo
 */
public class InMemoryProductPersistence implements ProductPersistence {

    private List<Producto> listaProductos = new ArrayList<>();
    private List<VariedadProducto> listaVariedadProductos = new ArrayList<>();

    public InMemoryProductPersistence() {
        Producto pr1 = new Producto("Manzana", 100500, "Fruta") {
        };
        Producto pr2 = new Producto("Papa", 100501, "Lugubre") {
        };
        VariedadProducto vpr1 = new VariedadProducto("Manzana", 100500,
                "Fruta", 200500, "Manzana verde", 20500);
        VariedadProducto vpr2 = new VariedadProducto("Papa", 100501,
                "Lugubre", 200501, "Papa pastusa", 20500);
        listaProductos.add(pr1);
        listaProductos.add(pr2);
        listaVariedadProductos.add(vpr1);
        listaVariedadProductos.add(vpr2);
    }

    @Override
    public Double calcularPrecioProductoPorId(Integer idProducto) throws ProductServicesException {
        Double precioARetornar = 0.0;
        try {
            for (VariedadProducto x : listaVariedadProductos) {
                if (x.getIdVProducto().equals(idProducto)) {
                    precioARetornar = x.getPrecioProducto()
                            - x.getPrecioProducto() * x.getDescuentoPrecioProducto();
                }
            }
            return precioARetornar;
        } catch (Exception e) {
            System.out.println("No se ha podido calcular el precio");
            return precioARetornar;
        }
    }

    @Override
    public void crearNuevoProducto(String nombreProducto, Integer idProducto, String categoriaProducto) throws ProductServicesException {
        try {
            Producto nuevoProducto = new Producto(nombreProducto, idProducto, categoriaProducto) {
            };
            listaProductos.add(nuevoProducto);
        } catch (Exception e) {
            System.out.println("No se ha podido crear el producto");
        }
    }

    @Override
    public void crearNuevaVariedadDeProducto(String nombreProducto, Integer idProducto, String categoriaProducto, Integer idVProducto,
            String nombreVProducto, Integer idUsuario) throws ProductServicesException {
        for (Producto x : listaProductos) {
            if (!x.getNombreProducto().equals(nombreProducto)) {
                crearNuevoProducto(nombreProducto, idProducto, categoriaProducto);
            }
        }
        try {
            VariedadProducto nuevaVariedadProducto
                    = new VariedadProducto(nombreProducto, idProducto, categoriaProducto, idVProducto,
                            nombreVProducto, idUsuario);
            listaVariedadProductos.add(nuevaVariedadProducto);
        } catch (Exception e) {
            System.out.println("No se ha podido crear la variedad del producto");
        }
    }

    @Override
    public Producto obtenerVariedadProductoPorId(Integer idProducto) throws ProductServicesException {
        Producto productoARetornar = null;
        for (VariedadProducto x : listaVariedadProductos) {
            if (x.getIdVProducto().equals(idProducto)) {
                productoARetornar = x;
            }
        }
        return productoARetornar;
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() throws ProductServicesException {
        try {
            return listaProductos;
        } catch (Exception e) {
            System.out.println("No se han podido obtener los productos");
            return listaProductos;
        }
    }

    @Override
    public List<VariedadProducto> obtenerTodasLasVariedades() {
        try {
            return listaVariedadProductos;
        } catch (Exception e) {
            System.out.println("No se han podido retornar las variedades");
            return listaVariedadProductos;
        }
    }

    @Override
    public List<Producto> obtenerTodaLaVariedadDeProductosPorIdProducto(Integer idProducto) throws ProductServicesException {
        List<Producto> listaARetornar = new ArrayList<>();
        try {
            for (VariedadProducto vProducto : listaVariedadProductos) {
                if (vProducto.getIdProducto().equals(idProducto)) {
                    listaARetornar.add(vProducto);
                }
            }
            return listaARetornar;
        } catch (Exception e) {
            System.out.println("No se han podido obtener las variedades del producto");
            return listaARetornar;
        }
    }

    @Override
    public List<VariedadProducto> obtenerVariedadDeProductosPorIdDeUsuario(Integer idUsuario) {
        List<VariedadProducto> listaVariedades = new ArrayList<>();
        try {
            for (VariedadProducto x : listaVariedadProductos) {
                if (x.getIdUsuario().equals(idUsuario)) {
                    listaVariedades.add(x);
                }
            }
            return listaVariedades;
        } catch (Exception e) {
            System.out.println("No se han podido obtener las variedades");
            return listaVariedades;
        }
    }

}
