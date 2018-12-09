/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.model.administrador;

import org.springframework.data.annotation.Id;

/**
 *
 * @author camilo
 */
public class Administrador {
    
    @Id
    public String idAdministrador;
    
    private final Integer cedulaAdministrador;
    private String nombreAdministrador;
    private final String contraseñaAdministrador;

    public Administrador(Integer cedulaAdministrador, String nombreAdministrador, String contraseñaAdministrador) {
        this.cedulaAdministrador = cedulaAdministrador;
        this.nombreAdministrador = nombreAdministrador;
        this.contraseñaAdministrador = contraseñaAdministrador;
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Integer getCedulaAdministrador() {
        return cedulaAdministrador;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    public String getContraseñaAdministrador() {
        return contraseñaAdministrador;
    }    
}
