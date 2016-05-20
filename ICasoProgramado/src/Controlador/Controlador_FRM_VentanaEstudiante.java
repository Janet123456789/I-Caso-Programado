/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Archivos_Estudiante;
import Modelo.ConexionBD_Estudiante;
import Modelo.Estudiante;
import Modelo.MetodosEstudiante;
import Modelo.MetodosXML_Estudiante;
import Vista.FRM_MenuPrincipal;
import Vista.FRM_VentanaEstudiante;
import Vista.FuenteDeInformacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jeannette
 */
public class Controlador_FRM_VentanaEstudiante implements ActionListener {

    FRM_VentanaEstudiante ventanaEstudiante;
    FuenteDeInformacion fuenteDeInformacion;
    String tipoDato;    
    Estudiante estudiante;
    
    MetodosEstudiante metodos;
    ConexionBD_Estudiante conexion;
    MetodosXML_Estudiante metodosXML;
    
    
    public Controlador_FRM_VentanaEstudiante(FRM_VentanaEstudiante ventanaEstudiante) {
        this.ventanaEstudiante=ventanaEstudiante;
        this.tipoDato=this.ventanaEstudiante.getTipoDato();
        
        System.out.print("controlador tipo de dato "+this.tipoDato);
        
        metodos=new MetodosEstudiante();
        conexion= new ConexionBD_Estudiante();
        conexion.realizarConexion();
        metodosXML=new MetodosXML_Estudiante(ventanaEstudiante);
     
    }//enc constructor
    
      public void escribirInformacionArchivo()
    {
        metodos.escribirInformacionArchivo();
    }  
   
    
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("adentro" +this.tipoDato);
        switch(this.tipoDato){
            case "ArchivosPlanos":
                
                if(e.getActionCommand().equals("Buscar"))
                {
                    
                    buscarConArchivosPlanos();
                   
                }
                
                if(e.getActionCommand().equals("Agregar"))
                {
                    metodos.agregarEstudiante(ventanaEstudiante.devolverInformacion());
                    ventanaEstudiante.limpiarTextField();
                    ventanaEstudiante.volverEstadoInicial();
                    ventanaEstudiante.mostrarMensaje("El estudiante fue agregado");
                }
                
                if(e.getActionCommand().equals("Modificar"))
                {
                    metodos.modificarEstudiante(ventanaEstudiante.devolverInformacion());
                    ventanaEstudiante.limpiarTextField();
                    ventanaEstudiante.volverEstadoInicial();
                    ventanaEstudiante.mostrarMensaje("El estudiante fue modificado de forma correcta");
                }
                
                if(e.getActionCommand().equals("Eliminar"))
                {
                    metodos.eliminarEstudiante(ventanaEstudiante.devolverInformacion());
                    ventanaEstudiante.limpiarTextField();
                    ventanaEstudiante.volverEstadoInicial();
                    ventanaEstudiante.mostrarMensaje("El estudiante fue eliminado");
                }
                 System.out.println("Síiiiii sirve");
                
                break;
                
            case "BaseDeDatos":
                
                if(e.getActionCommand().equals("Buscar"))
                {
                    buscarConBD();
                }
                else
                {
                    ventanaEstudiante.habilitarAgregar();
                   // ventanaEstudiante.mostrarMensaje("El estudiante no se encuentra registrado");
                }
                
                if(e.getActionCommand().equals("Agregar"))
                {
                    conexion.registrarEstudiante(ventanaEstudiante.extraerCedula(), ventanaEstudiante.devolverNombreCompleto(), ventanaEstudiante.devolverDireccion());
                    ventanaEstudiante.limpiarTextField();
                    ventanaEstudiante.volverEstadoInicial();
                    ventanaEstudiante.mostrarMensaje("El estudiante fue agregado");
                }
                
                if(e.getActionCommand().equals("Modificar"))
                {
                    conexion.actualizarEstudiante(ventanaEstudiante.extraerCedula(), ventanaEstudiante.devolverNombreCompleto(), ventanaEstudiante.devolverDireccion());
                    ventanaEstudiante.limpiarTextField();
                    ventanaEstudiante.volverEstadoInicial();
                    ventanaEstudiante.mostrarMensaje("El estudiante fue modificado");
                }
                
                if(e.getActionCommand().equals("Eliminar"))
                {
                    conexion.eliminarEstudiante(ventanaEstudiante.extraerCedula());
                    ventanaEstudiante.limpiarTextField();
                    ventanaEstudiante.volverEstadoInicial();
                    ventanaEstudiante.mostrarMensaje("El estudiante fue eliminado");
                }
                
                break;
                
            case "XML":
                
                 if(e.getActionCommand().equals("Buscar") || e.getActionCommand().equals("ConsultaRapida"))
                {
                   buscarConXML();  
                }
                 
                  if(e.getActionCommand().equals("Agregar"))
                {
                    metodosXML.guardarEnXML(ventanaEstudiante.devolverInformacion());
                    ventanaEstudiante.mostrarMensaje("Información agregada al archivo XML de forma correcta.");
                    ventanaEstudiante.limpiarTextField();
                    ventanaEstudiante.volverEstadoInicial();
                }
                  
                  if(e.getActionCommand().equals("Modificar"))
                {
                    metodosXML.modificarInformacionDelXml(ventanaEstudiante.devolverInformacion());
                    ventanaEstudiante.mostrarMensaje("Información modificada en el archivo XML de forma correcta.");
                    ventanaEstudiante.limpiarTextField();
                    ventanaEstudiante.volverEstadoInicial();
                }
                  
                  if(e.getActionCommand().equals("Eliminar"))
                {
                    metodosXML.eliminarInformacionDelXml(ventanaEstudiante.extraerCedula());
                    ventanaEstudiante.mostrarMensaje("Información eliminada del archivo XML de forma correcta.");
                    ventanaEstudiante.limpiarTextField();
                    ventanaEstudiante.volverEstadoInicial();
                }  
                
                break;
        }//end switch
         
    }//end actionPerformed
    
     public void buscarConArchivosPlanos()
     {
         System.out.println("pppp "+ventanaEstudiante.extraerCedula()+"  i iiiiiiiiiiiiii");
          
         if(metodos.buscarEstudiante(ventanaEstudiante.extraerCedula()))
         {
            System.out.println("iiiiiiiiiiiiiii");
           ventanaEstudiante.mostrarInformacion(metodos.getArregloInformacion());
           ventanaEstudiante.deshabilitarCedula();
           ventanaEstudiante.habilitarBotones();
           //archivos.devolverInformacionDelArchivo();
         }
         else
         {
            
            ventanaEstudiante.habilitarAgregar();
            ventanaEstudiante.mostrarMensaje("El estudiante no se encuentra registrado ");
            //archivos.crearArchivo();
         }
         
         }//end buscarConArchivosPlanos
    
     public void buscarConBD()
        {
            if(conexion.consultarEstudiante(ventanaEstudiante.extraerCedula()))
            {
                conexion.consultarEstudiante(ventanaEstudiante.extraerCedula());
                ventanaEstudiante.mostrarInformacion(conexion.devolverArreglo());
                ventanaEstudiante.deshabilitarCedula();
                ventanaEstudiante.habilitarBotones();
            }
            else
            {
                ventanaEstudiante.habilitarAgregar();
                ventanaEstudiante.mostrarMensaje("No se encuentra registrado el estudiante");
            }
        }//end buscarConBD
     
      public void buscarConXML()
    {
        if(metodosXML.consultarInformacionDelXml(ventanaEstudiante.extraerCedula()))
        {
            ventanaEstudiante.mostrarInformacion(metodosXML.getArregloInformacion());
            ventanaEstudiante.habilitarBotones();
            
            ventanaEstudiante.mostrarMensaje("Información encontrada con la cédula : "+ventanaEstudiante.extraerCedula());
        }
        else
        {
            ventanaEstudiante.mostrarMensaje("No se encontró información con la cédula: "+ventanaEstudiante.extraerCedula());
            ventanaEstudiante.habilitarAgregar();
        }   
        ventanaEstudiante.deshabilitarCedula();
    }//end buscarConXML 
     
   
}//end class
