/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.services.usuario;

import edu.eci.arsw.commerce.model.usuario.Usuario;
import edu.eci.arsw.commerce.persistence.UsuarioPersistence;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author camilo
 */
@Service
public class UsuarioServicesStub implements UsuarioServices {

    @Autowired
    UsuarioPersistence uPersistence;

    @Override
    public void crearUnNuevoUsuario(Usuario ur) {
        uPersistence.crearUnNuevoUsuario(ur);
    }

    @Override
    public Usuario obtenerUsuarioPorCedula(Integer cedula) {
        return uPersistence.obtenerUsuarioPorCedula(cedula);
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return uPersistence.obtenerTodosLosUsuarios();
    }

    @Override
    public void eliminarUsuarioPorCedula(Integer cedulaUsuario) {
        uPersistence.eliminarUsuarioPorCedula(cedulaUsuario);
    }

}
