/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Tipo de producto el cual pertenece a un producto, por ejemplo, manzana verde,
 * cebolla cabezona, papa pastusa, etc.
 *
 * @author camilolopez
 */
public class VariedadProducto{

    @Id
    private Integer idVProducto;

    private Integer precioProducto;
    private Date fabricacionProducto;
    private Date caducidadProducto;
    private String nombreVProducto;
    private Integer idProducto;
    private Double descuentoPrecioProducto;
    private Integer idUsuario;

    /**
     * Creacion de la variedad del producto dado cada uno de sus atributos el
     * cual componen al producto
     *
     * @param nombreProducto Nombre del producto al que pertenece
     * @param idProducto Id del producto al que pertenece
     * @param categoriaProducto Categoria del producto al cual pertenece
     * @param idVProducto Id de la variedad del producto
     * @param nombreVProducto Nombre de la variedad del producto
     * @param idUsuario Id del usuario al cual pertenece el producto
     */
    public VariedadProducto(String nombreProducto, Integer idProducto,
            String categoriaProducto, Integer idVProducto, String nombreVProducto,
            Integer idUsuario) {
        this.idVProducto = idVProducto;
        this.nombreVProducto = nombreVProducto;
        this.idProducto = idProducto;
        this.idUsuario = idUsuario;
    }

    public Integer getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Integer precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Date getFabricacionProducto() {
        return fabricacionProducto;
    }

    public void setFabricacionProducto(Date fabricacionProducto) {
        this.fabricacionProducto = fabricacionProducto;
    }

    public Date getCaducidadProducto() {
        return caducidadProducto;
    }

    public void setCaducidadProducto(Date caducidadProducto) {
        this.caducidadProducto = caducidadProducto;
    }

    public String getNombreVProducto() {
        return nombreVProducto;
    }

    public void setNombreVProducto(String nombreProducto) {
        this.nombreVProducto = nombreProducto;
    }

    public Integer getIdVProducto() {
        return idVProducto;
    }

    public void setIdVProducto(Integer idProducto) {
        this.idVProducto = idProducto;
    }

    public Double getDescuentoPrecioProducto() {
        return descuentoPrecioProducto;
    }

    public void setDescuentoPrecioProducto(Double descuentoPrecioProducto) {
        this.descuentoPrecioProducto = descuentoPrecioProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        String sb = "Nombre: " + nombreVProducto + " - "
                + " Id: " + idVProducto + " - "
                + " Precio: " + precioProducto + "<br>";
        return sb;

    }

}
