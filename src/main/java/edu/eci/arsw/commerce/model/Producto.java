/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Producto el cual es creado por un cliente, por ejemplo, papa, arroz, manzana
 *
 * @author camilolopez
 */
public class Producto {

    @Id
    private Integer idProducto;

    private String nombreProducto;
    private String categoriaProducto;

    /**
     * Creacion de un producto dado su nombre, id y categoria
     *
     * @param nombreProducto Nombre del producto
     * @param idProducto Id del producto
     * @param categoriaProducto Categoria a la cual pertenece el producto
     */
    public Producto(String nombreProducto, Integer idProducto,
            String categoriaProducto) {
        this.nombreProducto = nombreProducto;
        this.idProducto = idProducto;
        this.categoriaProducto = categoriaProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

}
