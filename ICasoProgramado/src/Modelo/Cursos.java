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
public class Cursos {
  
   public String sigla;
   public String nombreCurso;
   public int creditos;
   public String horario;

    public Cursos(String sigla, String nombreCurso, int creditos, String horario) {
        this.sigla = sigla;
        this.nombreCurso = nombreCurso;
        this.creditos = creditos;
        this.horario = horario;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public int getCreditos() {
        return creditos;
    }

    public String getHorario() {
        return horario;
    }
   
   public String getInformacion()
   {
       return "Sigla: "+ sigla + " NombreCurso: "+ nombreCurso+ " Créditos: "+ creditos+ " Horario: "+ horario;
   }
    
    
    
    
}//end class
