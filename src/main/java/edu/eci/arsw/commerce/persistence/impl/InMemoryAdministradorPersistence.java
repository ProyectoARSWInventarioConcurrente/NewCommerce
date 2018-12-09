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
import org.springframework.stereotype.Service;

/**
 *
 * @author camilo
 */
@Service
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
    public Administrador obtenerAdministradorPorCedula(Integer cedulaAdmin) {
        try {
            return aRepository.findBycedulaAdministrador(cedulaAdmin);
        } catch (Exception ex) {
            return null;
        }
    }

}
