/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.model;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author camilo
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    /**
     * Este metodo obtiene un usuario desde la base de datos mediante su cedula
     *
     * @param cedulaUsuario
     * @return
     */
    public Usuario findByCedulaUsuario(Integer cedulaUsuario);

}
