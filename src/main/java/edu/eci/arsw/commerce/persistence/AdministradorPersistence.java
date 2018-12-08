/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.persistence;

import edu.eci.arsw.commerce.model.administrador.Administrador;
import java.util.List;

/**
 *
 * @author camilo
 */
public interface AdministradorPersistence {

    /**
     *
     * @param admin
     */
    public void crearNuevoAdministrador(Administrador admin);

    /**
     *
     * @return
     */
    public List<Administrador> obtenerAdministradores();

    /**
     *
     * @param idAdmin
     * @return
     */
    public Administrador obtenerAdministradorPorId(String idAdmin);
}
