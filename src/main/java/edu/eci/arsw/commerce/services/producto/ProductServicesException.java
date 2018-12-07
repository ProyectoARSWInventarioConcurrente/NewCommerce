/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.services.producto;

/**
 *
 * @author camilolopez
 */
public class ProductServicesException extends Exception {

    public ProductServicesException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductServicesException(String message) {
        super(message);
    }

}
