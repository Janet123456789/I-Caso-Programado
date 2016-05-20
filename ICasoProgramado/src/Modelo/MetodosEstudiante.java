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
public class MetodosEstudiante {
  private ArrayList <Estudiante> arrayEstudiante; 
  String arregloDatos[];
  Archivos_Estudiante  archivos;
 
    public MetodosEstudiante() {
        arrayEstudiante=new ArrayList <Estudiante>();
        arregloDatos=new String[3];
        archivos=new Archivos_Estudiante();
        
        cargarArchivoAlArray();
       
   
    }
    
   public void escribirInformacionArchivo()
   {
       System.out.println("ESCRIBE INFORMACION EN ARCHIVO");
       archivos.crearArchivo();
       
       for(int contador=0;contador<arrayEstudiante.size();contador++)
       {
           archivos.escribirInformacionEnArchivo(arrayEstudiante.get(contador));
       }
   }
   
    public String obtenerReporte()
    {
        String cadena="CEDULA           NOMBRE COMPLETO          DIRECCIÓN        \n";
       for(int contador=0;contador<arrayEstudiante.size();contador++)
       {
           cadena+=arrayEstudiante.get(contador).getCedula()+"        "+arrayEstudiante.get(contador).getNombreCompleto()+"       "+arrayEstudiante.get(contador).getDireccion()+"\n";
       }
       return cadena;
    }
   
   
    public void cargarArchivoAlArray()
    {
        System.out.println(" CARGAR ARCHIVO AL ARRAY ");
        Estudiante arregloEstudiantes[]=archivos.devolverInformacionDelArchivoComoArreglo();
        
        for(int contador=0;contador<arregloEstudiantes.length;contador++)
        {
            arrayEstudiante.add((Estudiante)arregloEstudiantes[contador]);
        }
    }
    
    
    
    public boolean buscarEstudiante(String cedula)
    {System.out.println("ADENTRO BUSCAR ESTUDIANTE");
        boolean encontro=false;
        System.out.println("afuera del forrrrrrrrrrrrrrrr");
        
        for(int contador=0; contador<arrayEstudiante.size(); contador++)
        {
          
          System.out.println("adentro del for DEL BUSCAR");
          System.out.println("valor:::: "+ arrayEstudiante.get(contador).getCedula());
            
            if(arrayEstudiante.get(contador).getCedula().equals(cedula))
            {System.out.println("ADENTRO DEL IF DE BUSCAR");
                encontro=true;
                arregloDatos[0]=arrayEstudiante.get(contador).getCedula();
                arregloDatos[1]=arrayEstudiante.get(contador).getNombreCompleto();
                arregloDatos[2]=arrayEstudiante.get(contador).getDireccion();
            }
        }//end for
            System.out.println(encontro);
        return encontro;
    }
  
    public void agregarEstudiante(String informacion[])
    {
        Estudiante temporal=new Estudiante(informacion[0],informacion[1],informacion[2]);
         
        arrayEstudiante.add(temporal);
        archivos.escribirInformacionEnArchivo(temporal);
       
    }
    
    public void modificarEstudiante(String informacion[])
    {
        String informacionEstudiante[]=new String[3];
        
        for(int i=0; i<arrayEstudiante.size();i++)
        {
            if(arrayEstudiante.get(i).getCedula().equals(informacion[0]))
            {
               
               arrayEstudiante.get(i).setCedula(informacion[0]);
               arrayEstudiante.get(i).setNombreCompleto(informacion[1]);
               arrayEstudiante.get(i).setDireccion(informacion[2]);
            }
        }
    }
    
    public void eliminarEstudiante(String informacion [])
    {
        for(int i=0; i<arrayEstudiante.size();i++)
        {
            if(arrayEstudiante.get(i).getCedula().equals(informacion[0]))
            {
                arrayEstudiante.remove(i);
            }
        }
    }
    
    public String[] getArregloInformacion()
    {
        return this.arregloDatos;
    }
}//end class
