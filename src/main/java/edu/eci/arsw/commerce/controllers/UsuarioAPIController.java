/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import edu.eci.arsw.commerce.model.usuario.Usuario;
import edu.eci.arsw.commerce.services.usuario.UsuarioServices;
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
@RequestMapping(value = "/commerceUsuario")
public class UsuarioAPIController {
    
    private Integer usuarioActual;

    @Autowired
    UsuarioServices uServices;

    /**
     * Metodos de retorno
     */
    /**
     * Este metodo permite obtener todos los usuarios registrados
     *
     * @return El estado de la peticion HTTP
     */
    @RequestMapping(method = RequestMethod.GET, path = "usuarios")
    public ResponseEntity<?> obtenerTodosLosUsuarios() {
        try {
            Map<String, Usuario> usuarios = new HashMap();

            List<Usuario> usuariosArray = new ArrayList<>();
            usuariosArray.addAll(uServices.obtenerTodosLosUsuarios());

            for (Usuario x : usuariosArray) {
                usuarios.put(x.getNombreUsuario(), x);
            }

            String codeToJson = new Gson().toJson(usuarios);

            return new ResponseEntity<>(codeToJson, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido retornar los usuarios", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Este metodo nos permite obtener un usuario mediante el numero de su
     * cedula
     *
     * @param cedulaUsuario La cedula del usuario a retornar
     * @return El estado de la peticion HTTP
     */
    @RequestMapping(method = RequestMethod.GET, path = {"usuarios/{cedulaUsuario}"})
    public ResponseEntity<?> obtenerUsuarioPorCedula(@PathVariable("cedulaUsuario") Integer cedulaUsuario) {
        try {
            Map<String, Usuario> usuario = new HashMap<>();

            Usuario nuevoUsuario = uServices.obtenerUsuarioPorCedula(cedulaUsuario);

            usuario.put(nuevoUsuario.getNombreUsuario(), nuevoUsuario);

            String codeToJson = new Gson().toJson(nuevoUsuario);

            return new ResponseEntity<>(codeToJson, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido retornar el usuario con cedula: " + cedulaUsuario, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodos de creacion
     */
    /**
     * Este metodo permmite crear un nuevo usuario
     *
     * @param usuario Los datos del usuario
     * @return El estado de la peticion HTTP
     */
    @RequestMapping(method = RequestMethod.POST, path = "registrarUsuario")
    public ResponseEntity<?> crearNuevoUsuario(@RequestBody String usuario) {
        try {
            System.out.println(usuario);
            //Pasar el String JSON a un Map
            Type listType = new TypeToken<Map<Integer, Usuario>>() {
            }.getType();
            Map<String, Usuario> result = new Gson().fromJson(usuario, listType);

            //Obtener las llaves del Map
            Object[] nameKeys = result.keySet().toArray();

            Usuario ur = result.get(nameKeys[0]);

            uServices.crearUnNuevoUsuario(ur.getCedulaUsuario(), ur.getNombreUsuario(),
                    ur.getApellidoUsuario(), ur.getDireccionUsuario(), ur.getTelefonoUsuario(),
                    ur.getFechaNacimiento(), ur.getCorreoElectronico(), ur.getContraseñaUsuario());

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido registrar el usuario", HttpStatus.FORBIDDEN);
        }
    }

    /**
     * Metodos de eliminacion
     */
    /**
     * Este metodo permite eliminar un usuario registrado mediante su cedula
     *
     * @param cedulaUsuario La cedila del usuario a eliminar
     * @return El estado de la peticion HTTP
     */
    @RequestMapping(method = RequestMethod.DELETE, path = {"eliminarUsuario/{cedulaUsuario}"})
    public ResponseEntity<?> eliminarUsuarioPorCedula(@PathVariable("cedulaUsuario") Integer cedulaUsuario) {
        try {
            uServices.eliminarUsuarioPorCedula(cedulaUsuario);

            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido eliminar el usuario con cedula: " + cedulaUsuario,
                    HttpStatus.FORBIDDEN);
        }
    }
    
    /**
     * Metodos de guardar Usuario Actual
     */
    /**
     * Este metodo permite mantenr elusuario actual mediante su cedula
     *
     * @param cedulaUsuario La cedula del usuario a mantener
     * @return El estado de la peticion HTTP
     */
    @RequestMapping(method = RequestMethod.POST, path = {"mantenerUsuario/{cedulaUsuario}"})
    public ResponseEntity<?> mantenerUsuarioActualPorCedula(@PathVariable("cedulaUsuario") Integer cedulaUsuario) {
        try {
            usuarioActual = cedulaUsuario;
            System.out.println("cedula actual: " + usuarioActual);

            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se pudo mantener sesion de usuario con cedula: " + cedulaUsuario,
                    HttpStatus.FORBIDDEN);
        }
    }
    
    
    /**
     * Este metodo nos permite obtener el usuario Actual mediante el numero de su
     * cedula Actual
     *
     * @return El estado de la peticion HTTP
     */
    @RequestMapping(method = RequestMethod.GET, path = {"usuarioActual/"})
    public ResponseEntity<?> obtenerUsuarioActualPorCedula() {
        try {
            Map<String, Usuario> usuario = new HashMap<>();

            Usuario nuevoUsuario = uServices.obtenerUsuarioPorCedula(usuarioActual);

            usuario.put(nuevoUsuario.getNombreUsuario(), nuevoUsuario);

            String codeToJson = new Gson().toJson(nuevoUsuario);

            return new ResponseEntity<>(codeToJson, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido retornar el usuario con cedula: " + usuarioActual, HttpStatus.NOT_FOUND);
        }
    }
    
    /**
     * Este metodo se encarga de cerrar sesion del usuario actual mediante su cedula
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, path = {"cerrarSesion/"})
    public ResponseEntity<?> cerrarSesionUsuarioActual() {
        try {
            usuarioActual = null;
            System.out.println("cedula actual: " + usuarioActual);

            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido cerrar sesion ", HttpStatus.FORBIDDEN);
        }
    }
    
    
    /**
     * Este metodo nos permite pedir la cedula del usuario Actual
     *
     * @return El estado de la peticion HTTP
     */
    @RequestMapping(method = RequestMethod.GET, path = {"pedirActual/"})
    public ResponseEntity<?> pedirCedulaUsuarioActual() {
        try {
            

            String codeToJson = new Gson().toJson(usuarioActual);

            return new ResponseEntity<>(codeToJson, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ProductAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido retornar la cedula: " + usuarioActual, HttpStatus.NOT_FOUND);
        }
    }
    

}
