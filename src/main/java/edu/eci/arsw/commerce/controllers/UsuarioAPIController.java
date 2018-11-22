/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.controllers;

import edu.eci.arsw.commerce.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camilo
 */
@RestController
@RequestMapping(value = "/commerceUsuario")
public class UsuarioAPIController {
    
    @Autowired
    UsuarioServices uServices;
    
}
