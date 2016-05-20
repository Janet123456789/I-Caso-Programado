/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author jeannette
 */
public class Estudiante implements Serializable {
    
    public String cedula;
    public String nombreCompleto;
    public String direccion;
    
    public Estudiante(String cedula, String nombreCompleto, String direccion)
    {
        this.cedula=cedula;
        this.nombreCompleto=nombreCompleto;
        this.direccion=direccion;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public String getInformacion()
    {
        return "Cédula: "+ cedula + " Nombre Completo: "+ nombreCompleto + " Dirección: "+ direccion;
    }
    
}//end class
