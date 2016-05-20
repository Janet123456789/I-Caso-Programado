/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author jeannette
 */
public class MetodosCurso {
    
  private ArrayList <Cursos> arrayCurso; 
  String arregloDatos[];
  Archivos_Curso  archivos;
    
    
   public MetodosCurso() {
        arrayCurso=new ArrayList <Cursos>();
        arregloDatos=new String[4];
        archivos=new Archivos_Curso();
        
        cargarArchivoAlArray();
      
    }//end constructor
    
     public void escribirInformacionArchivo()
    {
       System.out.println("ESCRIBE INFORMACION EN ARCHIVO");
       archivos.crearArchivo();
       
       for(int contador=0;contador<arrayCurso.size();contador++)
       {
           archivos.escribirInformacionEnArchivo(arrayCurso.get(contador));
       }
    }
     
     public String obtenerReporte()
    {
        String cadena="SIGLA           NOMBRE CURSO          CREDITOS           HORARIO        \n";
       for(int contador=0;contador<arrayCurso.size();contador++)
       {
           cadena+=arrayCurso.get(contador).getSigla()+"        "+arrayCurso.get(contador).getNombreCurso()+"       "+arrayCurso.get(contador).getCreditos()+"       "+arrayCurso.get(contador).getHorario()+"\n";
       }
       return cadena;
    }
     
      public void cargarArchivoAlArray()
    {
        System.out.println(" CARGAR ARCHIVO AL ARRAY ");
        Cursos arregloCursos[]=archivos.devolverInformacionDelArchivoComoArreglo();
        
        for(int contador=0;contador<arregloCursos.length;contador++)
        {
            arrayCurso.add((Cursos)arregloCursos[contador]);
        }
    }
      
      
      
    public boolean buscarCurso(String sigla)
    {System.out.println("ADENTRO BUSCAR CURSO");
        boolean encontro=false;
        System.out.println("afuera del forrrrrrrrrrrrrrrr");
        
        for(int contador=0; contador<arrayCurso.size(); contador++)
        {
          
          System.out.println("adentro del for DEL BUSCAR");
          System.out.println("valor:::: "+ arrayCurso.get(contador).getSigla());
            
            if(arrayCurso.get(contador).getSigla().equals(sigla))
            {System.out.println("ADENTRO DEL IF DE BUSCAR");
                encontro=true;
                arregloDatos[0]=arrayCurso.get(contador).getSigla();
                arregloDatos[1]=arrayCurso.get(contador).getNombreCurso();
                arregloDatos[2]=""+arrayCurso.get(contador).getCreditos();
                arregloDatos[3]=arrayCurso.get(contador).getHorario();
            }
        }//end for
            System.out.println(encontro);
        return encontro;
    }
    
    
     public void agregarCurso(String informacion[])
    {
        Cursos temporal=new Cursos(informacion[0],informacion[1],Integer.parseInt(informacion[2]), informacion[3]);
         
        arrayCurso.add(temporal);
        archivos.escribirInformacionEnArchivo(temporal);
       
    }
    
     public void modificarCurso(String informacion[])
    {
        String informacionCurso[]=new String[4];
        
        for(int i=0; i<arrayCurso.size();i++)
        {
            if(arrayCurso.get(i).getSigla().equals(informacion[0]))
            {
               
               arrayCurso.get(i).setSigla(informacion[0]);
               arrayCurso.get(i).setNombreCurso(informacion[1]);
               arrayCurso.get(i).setCreditos(Integer.parseInt(informacion[2]));
               arrayCurso.get(i).setHorario(informacion[3]);
            }
        }
    }
     
     
    
    public void eliminarEstudiante(String informacion [])
    {
        for(int i=0; i<arrayCurso.size();i++)
        {
            if(arrayCurso.get(i).getSigla().equals(informacion[0]))
            {
                arrayCurso.remove(i);
            }
        }
    }
    
    
    public String[] getArregloInformacion()
    {
        return this.arregloDatos;
    }
    
}//end class
