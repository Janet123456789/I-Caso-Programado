/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author jeannette
 */
public class Archivos_Estudiante {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    public Archivos_Estudiante()
    {
        if(cargarArchivos())
        {
             System.out.println("ADENTRO DEL CONSTRUCTOR");
            System.out.println("Se cargó el archivo de forma correcta");
        }
        
        else
        {
            crearArchivo();
        }
    }//end constructor
    
    
    public boolean cargarArchivos()
    {
        boolean existe=false;
         System.out.println("CARGAR ARCHIVO");
        try{
            archivoEntrada=new ObjectInputStream(new FileInputStream("archivos.dat"));
            existe=true;
            System.out.println("carga exitosa");
           }
        catch(Exception e)
        {
            System.out.println("Error al cargar el archivo"+ e);
        }
         System.out.println("CARGAR ARCHIVO: "+existe);
        return existe;
    }//end cargarArchivos
    
    public void crearArchivo()
    {
         System.out.println("CREAR ARCHIVO");
        try
        {
             System.out.println("CREAR ARCHIVO: adentro try");
            archivoSalida=new ObjectOutputStream(new FileOutputStream ("archivos.dat"));
        }
        catch(Exception e)
        {
            System.out.println("CREAR ARCHIVO: adentro catch");
           System.out.println("Error al crear archivos"); 
        }
    }
    
    public void escribirInformacionEnArchivo(Estudiante estudiante)
    {System.out.println("ESCRIBIR INFORMACION EN ARCHIVO");
        try
        {
            System.out.println("ESCRIBIR INFORMACION EN ARCHIVO: adentro try");
            archivoSalida.writeObject(estudiante);
        }
        catch(Exception e)
        {System.out.println("ESCRIBIR INFORMACION EN ARCHIVO: adentro catch");
          System.out.println("Error al escribir en el archivo de Estudiantes: "+e);
        }
    }
    
    public Estudiante[] devolverInformacionDelArchivoComoArreglo()
    {
        System.out.println("DEVOLVER INFORMACION DEL ARCHIVO COMO ARREGLO");
        int tamano=devolverTamanoDelArchivo();
        Estudiante arregloEstudiantes[]=new Estudiante [tamano];
        
        try
        {System.out.println("DEVOLVER INFORMACION DEL ARCHIVO COMO ARREGLO: adentro try");
            archivoEntrada=new ObjectInputStream (new FileInputStream("archivos.dat"));
            
            for(int contador=0;contador<tamano;contador++)
            {
                arregloEstudiantes[contador]=(Estudiante)archivoEntrada.readObject();
            }//end for
        }
        catch(Exception e)
        {System.out.println("DEVOLVER INFORMACION DEL ARCHIVO COMO ARREGLO: adentro catch");
          System.out.println("Error devolver información del archivo de Estudiantes como un arreglo: "+e);

        }
        
        return arregloEstudiantes;
    }
    
     public int devolverTamanoDelArchivo()
    {System.out.println("DEVOLVER TAMAÑO DEL ARCHIVO");
        int contador=0;
        Estudiante temporal;
        try
        {System.out.println("DEVOLVER TAMAÑO DEL ARCHIVO: adentro try");
            while(true)
            {System.out.println("DEVOLVER TAMAÑO DEL ARCHIVO : adentro CATCH");
              temporal=(Estudiante)archivoEntrada.readObject();
              contador++;
            }
        }
        catch(EOFException e)
        {
            System.out.println("DEVOLVER TAMAÑO DEL ARCHIVO EN E IF EOFEXCEPTION");
            System.out.println("Fin del archivo Estudiantes: "+e);
        }
        catch(Exception e)
        {System.out.println("DEVOLVER TAMAÑO DEL ARCHIVO EN ID EXCEPTION E");
            System.out.println("Error al devolver el tamaño del archivo de Estudiantes: "+e);
        }
        return contador;
    }
     
     

    
 
}//end class
