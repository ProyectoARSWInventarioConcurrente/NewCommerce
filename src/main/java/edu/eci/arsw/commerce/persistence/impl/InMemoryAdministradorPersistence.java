/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.persistence.impl;

import edu.eci.arsw.commerce.model.administrador.Administrador;
import edu.eci.arsw.commerce.model.administrador.AdministradorRepository;
import edu.eci.arsw.commerce.persistence.AdministradorPersistence;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author camilo
 */
public class InMemoryAdministradorPersistence implements AdministradorPersistence {

    @Autowired
    AdministradorRepository aRepository;
    
    @Override
    public void crearNuevoAdministrador(Administrador admin) {
        aRepository.save(admin);
    }

    @Override
    public List<Administrador> obtenerAdministradores() {
        return aRepository.findAll();
    }

    @Override
    public Administrador obtenerAdministradorPorId(String idAdmin) {
        return aRepository.findByidAdministrador(idAdmin);
    }

}
