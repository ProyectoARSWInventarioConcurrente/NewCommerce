/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.persistence;

import edu.eci.arsw.commerce.model.Usuario;
import java.util.List;

/**
 *
 * @author camilo
 */
public interface UsuarioPersistence {

    /**
     * Este metodo permite la creacion de un nuevo usuarios
     *
     * @param cedulaUsuario Cedula del usuario
     * @param nombreUsuario Nombre del usuario
     * @param apellidoUsuario Apellido del usuario
     * @param direccionUsuario Direccion del usuario
     * @param telefonoUsuario Telefono del usuario
     * @param fechaNacimiento Fecha de nacimiento del usuario
     */
    public void crearUnNuevoUsuario(Integer cedulaUsuario, String nombreUsuario,
            String apellidoUsuario, String direccionUsuario, Integer telefonoUsuario,
            String fechaNacimiento);

    /**
     * Este metodo permite obtener un usuario por su cedula
     *
     * @param cedula La cedula del usuario a obtener
     * @return El usuario que pertenece a esa cedula
     */
    public Usuario obtenerUsuarioPorCedula(Integer cedula);

    /**
     * Este metodo permite obtener todos los usuarios
     *
     * @return Una lista con todos los usuarios
     */
    public List<Usuario> obtenerTodosLosUsuarios();

    /**
     * Este metodo permite eliminar un usuario por su cedula
     *
     * @param cedulaUsuario
     */
    public void eliminarUsuarioPorCedula(Integer cedulaUsuario);

}