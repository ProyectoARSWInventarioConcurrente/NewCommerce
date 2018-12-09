/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.services.administrador;

import edu.eci.arsw.commerce.model.administrador.Administrador;
import edu.eci.arsw.commerce.persistence.AdministradorPersistence;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author camilo
 */
@Service
public class AdministradorServicesStub implements AdministradorServices {

    @Autowired
    AdministradorPersistence aPersistence;

    @Override
    public void crearNuevoAdministrador(Administrador admin) {
        aPersistence.crearNuevoAdministrador(admin);
    }

    @Override
    public List<Administrador> obtenerAdministradores() {
        return aPersistence.obtenerAdministradores();
    }

    @Override
    public Administrador obtenerAdministradorPorCedula(Integer cedulaAdmin) {
        return aPersistence.obtenerAdministradorPorCedula(cedulaAdmin);
    }

}
