/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.eci.arsw.commerce.model.administrador.Administrador;
import edu.eci.arsw.commerce.model.producto.Producto;
import edu.eci.arsw.commerce.model.variedadproducto.VariedadProducto;
import edu.eci.arsw.commerce.services.administrador.AdministradorServices;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camilo
 */
@RestController
@RequestMapping(value = "/commerceAdmin")
public class AdministradorAPIController {

    @Autowired
    AdministradorServices aServices;

    /**
     *
     * @param admin
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, path = "registrarAdmin")
    public ResponseEntity<?> crearNuevoAdministrador(@RequestBody String admin) {
        try {

            //Pasar el String JSON a un Map
            Type listType = new TypeToken<Map<Integer, Administrador>>() {
            }.getType();
            Map<String, Administrador> result = new Gson().fromJson(admin, listType);

            //Obtener las llaves del Map
            Object[] nameKeys = result.keySet().toArray();

            Administrador adm = result.get(nameKeys[0]);

            aServices.crearNuevoAdministrador(adm);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido crear el administrador", HttpStatus.FORBIDDEN);
        }
    }

    /**
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "admins")
    public ResponseEntity<?> obtenerAdministradores() {
        try {
            Map<String, Administrador> administradores = new HashMap();

            List<Administrador> adminsArray = new ArrayList<>();
            adminsArray.addAll(aServices.obtenerAdministradores());

            for (Administrador x : adminsArray) {
                administradores.put(x.getIdAdministrador(), x);
            }

            String codeToJson = new Gson().toJson(administradores);

            return new ResponseEntity<>(codeToJson, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("No se han podido obtener los administradores", HttpStatus.NOT_FOUND);
        }
    }

    /**
     *
     * @param idAdmin
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "admins/{idAdmin}")
    public ResponseEntity<?> obtenerAdministradorPorId(@PathVariable("idAdmin") String idAdmin){
        try {
            Map<String, Administrador> administradores = new HashMap();

            administradores.put(idAdmin, aServices.obtenerAdministradorPorId(idAdmin));

            String codeToJson = new Gson().toJson(administradores);

            return new ResponseEntity<>(codeToJson, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("No se han podido obtener el administrador", HttpStatus.NOT_FOUND);
        }        
    }
    
}
