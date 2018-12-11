/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.controllers;

import com.google.gson.Gson;
import edu.eci.arsw.commerce.model.variedadproducto.VariedadProducto;
import edu.eci.arsw.commerce.services.producto.ProductServices;
import com.google.gson.reflect.TypeToken;
import edu.eci.arsw.commerce.model.producto.Producto;
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
 * @author camilolopez
 */
@RestController
@RequestMapping(value = "/commerceProducto")
public class ProductAPIController {

    @Autowired
    ProductServices prServices;

    /**
     * Metodos de consulta *
     */
    /**
     * Este metodo retorna cada una de las variedades que estan creadas en la
     * base de datos de productos
     *
     * @return El estado de la peticion HTTP
     */
    @RequestMapping(method = RequestMethod.GET, path = "variedades")
    public ResponseEntity<?> obtenerTodasLasVariedades() {
        try {
            Map<String, VariedadProducto> variedades = new HashMap();

            List<VariedadProducto> variedadesArray = new ArrayList<>();
            variedadesArray.addAll(prServices.obtenerTodasLasVariedades());

            for (VariedadProducto x : variedadesArray) {
                variedades.put(x.getNombreVProducto(), x);
            }

            String codeToJson = new Gson().toJson(variedades);

            return new ResponseEntity<>(codeToJson, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("No se ha podido retornar las variedades", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Este metodo retorna cada una de las variedades de producto que tiene un
     * usuario en particulas
     *
     * @param idUsuario El id del usuario del cual se quieren conocer sus
     * variedades
     * @return El estado de la peticion HTTP
     */
    @RequestMapping(method = RequestMethod.GET, path = {"variedades/{idUsuario}"})
    public ResponseEntity<?> obtenerVariedadesPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario) {
        try {
            Map<String, VariedadProducto> variedades = new HashMap();

            List<VariedadProducto> variedadesArray = new ArrayList<>();
            variedadesArray.addAll(prServices.obtenerVariedadDeProductosPorIdDeUsuario(idUsuario));

            for (VariedadProducto x : variedadesArray) {
                variedades.put(x.getNombreVProducto(), x);
            }

            String codeToJson = new Gson().toJson(variedades);

            return new ResponseEntity<>(codeToJson, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("No se ha podido retornar las variedades", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Esta funcion se encarga de retornar cada uno de los productos registrados
     *
     * @return El estado de la peticion HTTP
     */
    @RequestMapping(method = RequestMethod.GET, path = {"productos"})
    public ResponseEntity<?> obtenerTodosLosProductos() {
        try {
            Map<String, Producto> productos = new HashMap();

            List<Producto> productosArray = new ArrayList<>();
            productosArray.addAll(prServices.obtenerTodosLosProductos());

            for (Producto x : productosArray) {
                productos.put(x.getNombreProducto(), x);
            }

            String codeToJson = new Gson().toJson(productosArray);

            return new ResponseEntity<>(codeToJson, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("No se ha podido retornar los productos", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Este metodo nos permite obtener mediante una peticion GET un producto que
     * este registrado en la aplicacion.
     *
     * @param idProducto El id del producto que se quiere obtener.
     * @return El producto que se encuentra con el Id proporcionado.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/producto/{idProducto}")
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable("idProducto") String idProducto) {
        try {
            Map<String, Producto> producto = new HashMap();

            producto.put(idProducto, prServices.obtenerProductoPorId(idProducto));

            String codeToJson = new Gson().toJson(producto);

            return new ResponseEntity<>(codeToJson, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("No se ha podido retornar el producto", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Esta funcion permite obtener todas las variedades que tiene un producto
     * mediante su Id
     *
     * @param idProducto El id del producto del cual se obtendran las variedades
     * @return El estado de la peticion HTTP
     */
    @RequestMapping(method = RequestMethod.GET, path = {"variedades/{idProducto}"})
    public ResponseEntity<?> obtenerVariedadesPorIdProducto(@PathVariable("idProducto") Integer idProducto) {
        try {
            Map<String, VariedadProducto> variedades = new HashMap();

            List<VariedadProducto> variedadesArray = new ArrayList<>();
            variedadesArray.addAll(prServices.obtenerTodaLaVariedadDeProductosPorIdProducto(idProducto));

            for (VariedadProducto x : variedadesArray) {
                variedades.put(x.getNombreVProducto(), x);
            }

            String codeToJson = new Gson().toJson(variedades);

            return new ResponseEntity<>(codeToJson, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("No se ha podido retornar las variedades", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Esta funcion permite retornar una variedad de proudcto mediante su Id
     *
     * @param idVariedad El id de la variedad que se quiere retornar.
     * @return El estado de la peticion HTTP
     */
    @RequestMapping(method = RequestMethod.GET, path = {"variedades/{idVariedad}"})
    public ResponseEntity<?> obtenerVariedadPorId(@PathVariable("idVariedad") Integer idVariedad) {
        try {
            Map<String, VariedadProducto> variedades = new HashMap();

            VariedadProducto vrProducto = prServices.obtenerVariedadProductoPorId(idVariedad);

            variedades.put(vrProducto.getNombreVProducto(), vrProducto);

            String codeToJson = new Gson().toJson(variedades);

            return new ResponseEntity<>(codeToJson, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("No se ha podido retornar las variedades", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodos de registro *
     */
    /**
     * Este metodo permite la creacion de un Producto dentro de la aplicacion
     *
     * @param producto El Json del producto el cual sera creado
     * @return El estado de la peticion HTTP
     */
    @RequestMapping(method = RequestMethod.POST, path = "registrarproducto")
    public ResponseEntity<?> registrarNuevoProducto(@RequestBody String producto) {
        //Ejemplo JSON {"1":{"nombreProducto":"Papa","idProducto":"100500","categoriaProducto":"Legumbre"}}
        try {

            //Pasar el String JSON a un Map
            Type listType = new TypeToken<Map<Integer, Producto>>() {
            }.getType();
            Map<String, Producto> result = new Gson().fromJson(producto, listType);

            //Obtener las llaves del Map
            Object[] nameKeys = result.keySet().toArray();

            Producto pr = result.get(nameKeys[0]);

            prServices.crearNuevoProducto(pr);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido añadir el producto", HttpStatus.FORBIDDEN);
        }
    }

    /**
     * Esta funcion permite registrar una nueva variedad de producto en el
     * sistema
     *
     * @param variedadProducto El codigo Json de la variedad del producto
     * @return El estado de la peticion HTTP
     */
    @RequestMapping(method = RequestMethod.POST, path = "registrarvproducto")
    public ResponseEntity<?> registrarNuevaVariedadDeProducto(@RequestBody String variedadProducto) {
        //Ejemplo Json {"1":{"idProducto":"100500","idVProducto":"200500","nombreVProducto":"Papa pastusa", "idUsuario":"300001"}}
        try {

            //Pasar el String JSON a un Map
            Type listType = new TypeToken<Map<Integer, VariedadProducto>>() {
            }.getType();
            Map<String, VariedadProducto> result = new Gson().fromJson(variedadProducto, listType);

            //Obtener las llaves del Map
            Object[] nameKeys = result.keySet().toArray();

            VariedadProducto vpr = result.get(nameKeys[0]);

            prServices.crearNuevaVariedadDeProducto(vpr);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido añadir la variedad de producto", HttpStatus.FORBIDDEN);
        }
    }

    /**
     * Este metodo se encarga de eliminar un producto mediante su id
     *
     * @param idProducto El id del producto el cual sera eliminado
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, path = {"eliminarProducto/{idProducto}"})
    public ResponseEntity<?> eliminarProductoPorId(@PathVariable("idProducto") String idProducto) {
        try {
            prServices.eliminarUnProductoPorId(idProducto);

            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido eliminar el producto con el id " + idProducto, HttpStatus.FORBIDDEN);
        }
    }

    /**
     * Este metodo se encarga de eliminar una variedad de producto por su id
     *
     * @param idVProducto El id de la variedad de producto
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, path = {"eliminarVProducto/{idVProducto}"})
    public ResponseEntity<?> eliminarVariedadProductoPorId(@PathVariable("idVProducto") Integer idVProducto) {
        try {
            prServices.eliminarUnaVariedadDeProductoPorId(idVProducto);

            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido eliminar la variedad de producto con el id " + idVProducto, HttpStatus.FORBIDDEN);
        }
    }
}
