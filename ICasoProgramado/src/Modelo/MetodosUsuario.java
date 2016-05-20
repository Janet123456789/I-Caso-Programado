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
public class MetodosUsuario {

    private ArrayList <Usuario> arrayUsuario; 
    String arregloDatos[];
    
    //archivos=new Archivos_Usuario();
    
    public MetodosUsuario() 
    {
         arrayUsuario=new ArrayList <Usuario>();
         arregloDatos=new String[2];
    }

    public void agregarEstudiante(String informacion[])
    {
        Usuario temporal=new Usuario(informacion[0],informacion[1]);
         
        arrayUsuario.add(temporal);
        //archivos.escribirInformacionEnArchivo(temporal);
       
    }
    
    public boolean verificarDatos(String informacion[])
    {
         boolean encontro=false;
     
        
        for(int contador=0; contador<arrayUsuario.size(); contador++)
        { 
            if(arrayUsuario.get(contador).getUsuario().equals(informacion[0])&& arrayUsuario.get(contador).getContrasena().equals(informacion[1]))
            {
                encontro=true;
                arregloDatos[0]=arrayUsuario.get(contador).getUsuario();
                arregloDatos[1]=arrayUsuario.get(contador).getContrasena();
                
            }
        }//end for
            System.out.println(encontro);
        return encontro;
    }
    
    public void agregarUsuario(String informacion[])
    {
        Usuario temporal=new Usuario(informacion[0],informacion[1]);
         
        arrayUsuario.add(temporal);
        //archivos.escribirInformacionEnArchivo(temporal);
    }
    
    public String[] getArregloInformacion()
    {
        return this.arregloDatos;
    }
    
    
    
    
    
    
}//end class
