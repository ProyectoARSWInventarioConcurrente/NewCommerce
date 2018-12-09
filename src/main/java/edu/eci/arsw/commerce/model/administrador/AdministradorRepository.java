/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.model.administrador;

import java.io.Serializable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author camilo
 */
public interface AdministradorRepository extends MongoRepository<Administrador, String>{
    
    /**
     *
     * @param idAdministrador
     * @return
     */
    public Administrador findByidAdministrador(String idAdministrador);
    
}
