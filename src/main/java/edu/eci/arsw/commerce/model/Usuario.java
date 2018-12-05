/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.commerce.model;

import java.util.Date;
import org.springframework.data.annotation.Id;

/**
 *
 * @author camilo
 */
public class Usuario {

    @Id
    public String idUsuario;

    private Integer cedulaUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String direccionUsuario;
    private Long telefonoUsuario;
    private Date fechaNacimiento;
    private String correoElectronico;
    private Integer calificacionUsuario;
    private Double saldoUsuario;
    private String contraseñaUsuario;

    public Usuario(Integer cedulaUsuario, String nombreUsuario, String apellidoUsuario, String direccionUsuario,
            Long telefonoUsuario, Date fechaNacimiento, String correoElectronico, String contraseñaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.direccionUsuario = direccionUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.contraseñaUsuario = contraseñaUsuario;

        calificacionUsuario = 1;
        saldoUsuario = 0.0;
    }

    public Integer getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(Integer cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public Long getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(Long telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Integer getCalificacionUsuario() {
        return calificacionUsuario;
    }

    public void setCalificacionUsuario(Integer calificacionUsuario) {
        this.calificacionUsuario = calificacionUsuario;
    }

    public Double getSaldoUsuario() {
        return saldoUsuario;
    }

    public void setSaldoUsuario(Double saldoUsuario) {
        this.saldoUsuario = saldoUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }

}
