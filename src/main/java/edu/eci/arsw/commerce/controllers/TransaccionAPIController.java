/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.eci.arsw.commerce.model.transaccion.Transaccion;
import edu.eci.arsw.commerce.model.usuario.Usuario;
import edu.eci.arsw.commerce.services.transaccion.TransaccionServices;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camilo
 */
@RestController
@RequestMapping(value = "/commerceTransaccion")
public class TransaccionAPIController {

    @Autowired
    TransaccionServices tServices;

    /**
     * Esta funcion retorna cada una de las transacciones que han sido creadas o
     * realizadas dentro de la aplicacion.
     *
     * @return La lista con todas las transacciones realizadas.
     */
    @RequestMapping(method = RequestMethod.GET, path = "transacciones")
    public ResponseEntity<?> obtenerTodasLasTransacciones() {
        try {
            Map<String, Transaccion> transacciones = new HashMap();

            List<Transaccion> transaccionesArray = new ArrayList<>();
            transaccionesArray.addAll(tServices.obtenerTransacciones());

            for (Transaccion x : transaccionesArray) {
                transacciones.put(x.getIdentificador(), x);
            }

            String codeToJson = new Gson().toJson(transacciones);

            return new ResponseEntity<>(codeToJson, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido retornar las transacciones", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Este metodo crea una transaccion nueva dada.
     * @param transaccion La transaccion que sera creada.
     * @return El esta de la peticion HTTP en caso de ser creada o denegada.
     */
    @RequestMapping(method = RequestMethod.POST, path = "crearTransaccion")
    public ResponseEntity<?> crearNuevaTransaccion(@RequestBody String transaccion) {
        try {
            //Pasar el String JSON a un Map
            Type listType = new TypeToken<Map<Integer, Transaccion>>() {
            }.getType();
            Map<String, Transaccion> result = new Gson().fromJson(transaccion, listType);

            //Obtener las llaves del Map
            Object[] nameKeys = result.keySet().toArray();

            Transaccion tr = result.get(nameKeys[0]);

            tServices.crearNuevaTransaccion(tr);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido crear la transaccion", HttpStatus.FORBIDDEN);
        }
    }

}
