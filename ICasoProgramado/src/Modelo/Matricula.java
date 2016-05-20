/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author jeannette
 */
public class Matricula {
    
   private String codigoMatricula;
    private String cedula;
    private String sigla;

    public Matricula(String codigoMatricula, String cedula, String sigla) {
        this.codigoMatricula = codigoMatricula;
        this.cedula = cedula;
        this.sigla = sigla;
    }

    /**
     * @return the codigo
     */
    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigoMatricula(String codigo) {
        this.codigoMatricula = codigoMatricula;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public String getInformacion()
    {
        return "Código de matrícula: "+getCodigoMatricula()+" Cédula: "+getCedula()+" Sigla: "+getSigla();
    } 
    
}//end class
