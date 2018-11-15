/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.controllers;

import edu.eci.arsw.commerce.model.VariedadProducto;
import edu.eci.arsw.commerce.services.ProductServices;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camilolopez
 */
@RestController
@RequestMapping(value = "/producto")
public class ProductAPIController {

    @Autowired
    ProductServices prServices;

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "variedades")
    public ResponseEntity<?> obtenerTodasLasVariedades() {
        try {
            String strToReturn = "";
            for (VariedadProducto x : prServices.obtenerTodasLasVariedades()) {
                strToReturn += x;
            }
            return new ResponseEntity<>(strToReturn, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("No se ha podido retornar las variedades", HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @param idUsuario
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = {"variedades/{idUsuario}"})
    public ResponseEntity<?> obtenerVariedadesPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario) {
        try {
            String strToReturn = "";
            List<VariedadProducto> listaVariedad = prServices.obtenerVariedadDeProductosPorIdDeUsuario(idUsuario);
            if (!listaVariedad.isEmpty()) {
                for (VariedadProducto x : listaVariedad) {
                    strToReturn += x;
                }
            } else {
                strToReturn = "No existen productos para este cliente";
            }
            return new ResponseEntity<>(strToReturn, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("No se ha podido retornar las variedades", HttpStatus.NOT_FOUND);
        }
    }

}
