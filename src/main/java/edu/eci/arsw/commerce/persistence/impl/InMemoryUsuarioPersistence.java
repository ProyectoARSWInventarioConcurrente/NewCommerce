/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.persistence.impl;

import edu.eci.arsw.commerce.model.usuario.Usuario;
import edu.eci.arsw.commerce.model.usuario.UsuarioRepository;
import edu.eci.arsw.commerce.persistence.UsuarioPersistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author camilo
 */
@Service
public class InMemoryUsuarioPersistence implements UsuarioPersistence {

    @Autowired
    UsuarioRepository uRepository;

    @Override
    public void crearUnNuevoUsuario(Usuario ur) {
        try {

            Boolean existeUsuario = false;
            List<Usuario> listaUsuario = new ArrayList<>();
            listaUsuario = obtenerTodosLosUsuarios();

            for (Usuario x : listaUsuario) {
                if (x.getCedulaUsuario().equals(ur.getCedulaUsuario())) {
                    existeUsuario = true;
                }
            }

            if (!existeUsuario) {
                uRepository.save(ur);
            } else {
                System.out.println("Este usuario ya existe");
            }
        } catch (Exception ex) {
            System.out.println("No se ha podido crear esta usuario");
        }
    }

    @Override
    public Usuario obtenerUsuarioPorCedula(Integer cedula) {
        Usuario usuarioNuevo = null;
        try {
            usuarioNuevo = uRepository.findByCedulaUsuario(cedula);
            return usuarioNuevo;
        } catch (Exception ex) {
            System.out.println("No se ha podido obtener el usuario");
            return usuarioNuevo;
        }
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> listaUsuarios = null;
        try {
            listaUsuarios = uRepository.findAll();
            return listaUsuarios;
        } catch (Exception ex) {
            System.out.println("No se han podido obtener los usuarios");
            return listaUsuarios;
        }
    }

    @Override
    public void eliminarUsuarioPorCedula(Integer cedulaUsuario) {
        try {
            Usuario usuarioAEliminar = uRepository.findByCedulaUsuario(cedulaUsuario);
            uRepository.delete(usuarioAEliminar);
        } catch (Exception ex) {
            System.out.println("Error al tratar de eliminar el usuario con cedula: " + cedulaUsuario);
        }
    }

}
