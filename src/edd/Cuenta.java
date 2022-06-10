/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd;

import java.io.Serializable;

/**
 *
 * @author mxsrxm
 */
public class Cuenta implements Serializable
{
    private String nombreCuenta;
    private String correo;
    private String contrasenia;

    public Cuenta()
    {
    }

    public Cuenta(String nombreCuenta, String correo, String contrasenia)
    {
        this.nombreCuenta = nombreCuenta;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    /**
     * @return the nombreCuenta
     */
    public String getNombreCuenta()
    {
        return nombreCuenta;
    }

    /**
     * @param nombreCuenta the nombreCuenta to set
     */
    public void setNombreCuenta(String nombreCuenta)
    {
        this.nombreCuenta = nombreCuenta;
    }

    /**
     * @return the correo
     */
    public String getCorreo()
    {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia()
    {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia)
    {
        this.contrasenia = contrasenia;
    }
    
    
    
}
