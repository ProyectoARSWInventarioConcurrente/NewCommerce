/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.model.variedadproducto;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Tipo de producto el cual pertenece a un producto, por ejemplo, manzana verde,
 * cebolla cabezona, papa pastusa, etc.
 *
 * @author camilolopez
 */
public class VariedadProducto {

    @Id
    public String idVProducto;

    private Double precioProducto;
    private Date fechaCosecha;
    private String nombreVProducto;
    private String idProducto;
    private Integer idUsuario;
    private Double cantidadVProducto;

    /**
     * Creacion de la variedad del producto dado cada uno de sus atributos el
     * cual componen al producto
     *
     * @param idProducto Id del producto al que pertenece
     * @param precioProducto
     * @param cantidadVProducto
     * @param nombreVProducto Nombre de la variedad del producto
     * @param idUsuario Id del usuario al cual pertenece el producto
     */
    public VariedadProducto(String idProducto, String nombreVProducto,
            Integer idUsuario, Double precioProducto, Double cantidadVProducto,
            Date fechaCosecha) {
        this.idProducto = idProducto;
        this.nombreVProducto = nombreVProducto;
        this.idUsuario = idUsuario;
        this.precioProducto = precioProducto;
        this.cantidadVProducto = cantidadVProducto;
        this.fechaCosecha = fechaCosecha;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Date getFechaCosecha() {
        return fechaCosecha;
    }

    public void setFechaCosecha(Date fechaCosecha) {
        this.fechaCosecha = fechaCosecha;
    }

    public Double getCantidadVProducto() {
        return cantidadVProducto;
    }

    public void setCantidadVProducto(Double cantidadVProducto) {
        this.cantidadVProducto = cantidadVProducto;
    }

    public String getNombreVProducto() {
        return nombreVProducto;
    }

    public void setNombreVProducto(String nombreProducto) {
        this.nombreVProducto = nombreProducto;
    }

    public String getIdVProducto() {
        return idVProducto;
    }

    public void setIdVProducto(String idProducto) {
        this.idVProducto = idProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
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
