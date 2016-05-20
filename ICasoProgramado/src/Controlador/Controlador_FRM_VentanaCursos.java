/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBD_Cursos;
import Modelo.MetodosCurso;
import Modelo.MetodosXML_Cursos;
import Vista.FRM_VentanaCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jeannette
 */
public class Controlador_FRM_VentanaCursos implements ActionListener {
    
    FRM_VentanaCursos ventanaCursos;
    MetodosCurso metodosCurso;
    ConexionBD_Cursos conexionBDCursos;
    String tipoDato; 
    MetodosXML_Cursos metodosXML_Cursos;
    

    public Controlador_FRM_VentanaCursos( FRM_VentanaCursos ventanaCursos ) {
        
        this.ventanaCursos=ventanaCursos;
        this.tipoDato=this.ventanaCursos.getTipoDato();
        System.out.print("controlador tipo de dato "+this.tipoDato);
        
        metodosCurso=new MetodosCurso();
        conexionBDCursos=new ConexionBD_Cursos();
        conexionBDCursos.realizarConexion();
        metodosXML_Cursos=new MetodosXML_Cursos(ventanaCursos);


    }//end constructor
    
      public void escribirInformacionArchivo()
    {
        metodosCurso.escribirInformacionArchivo();
    }  
    
     public void actionPerformed(ActionEvent e)
    {
        System.out.println("dentro" +this.tipoDato);
        switch(this.tipoDato){
            case "ArchivosPlanos":
                
                if(e.getActionCommand().equals("Buscar"))
                { 
                    buscarConArchivosPlanos();
                }
                
                if(e.getActionCommand().equals("Agregar"))
                {
                    metodosCurso.agregarCurso(ventanaCursos.devolverInformacion());
                    ventanaCursos.limpiarTextField();
                    ventanaCursos.volverEstadoInicial();
                    ventanaCursos.mostrarMensaje("El estudiante fue agregado");
                }
                
                if(e.getActionCommand().equals("Modificar"))
                {
                    metodosCurso.modificarCurso(ventanaCursos.devolverInformacion());
                    ventanaCursos.limpiarTextField();
                    ventanaCursos.volverEstadoInicial();
                    ventanaCursos.mostrarMensaje("El estudiante fue modificado de forma correcta");
                }
                
                if(e.getActionCommand().equals("Eliminar"))
                {
                    metodosCurso.eliminarEstudiante(ventanaCursos.devolverInformacion());
                    ventanaCursos.limpiarTextField();
                    ventanaCursos.volverEstadoInicial();
                    ventanaCursos.mostrarMensaje("El estudiante fue eliminado");
                }
                 
                break;
                
            case "BaseDeDatos":
                
                if(e.getActionCommand().equals("Buscar"))
                {
                    buscarConBD();
                }
                else
                {
                    ventanaCursos.habilitarAgregar();
                }
                
                if(e.getActionCommand().equals("Agregar"))
                {
                    conexionBDCursos.registrarCurso(ventanaCursos.extraerSigla(), ventanaCursos.devolverNombreCurso(), ventanaCursos.devolverCreditos(), ventanaCursos.devolverHorario());
                    ventanaCursos.limpiarTextField();
                    ventanaCursos.volverEstadoInicial();
                    ventanaCursos.mostrarMensaje("El curso fue agregado");
                }
                
                if(e.getActionCommand().equals("Modificar"))
                {
                    conexionBDCursos.actualizarCurso(ventanaCursos.extraerSigla(), ventanaCursos.devolverNombreCurso(), ventanaCursos.devolverCreditos(), ventanaCursos.devolverHorario());
                    ventanaCursos.limpiarTextField();
                    ventanaCursos.volverEstadoInicial();
                    ventanaCursos.mostrarMensaje("El curso fue modificado");
                }
                
                if(e.getActionCommand().equals("Eliminar"))
                {
                    conexionBDCursos.eliminarCurso(ventanaCursos.extraerSigla());
                    ventanaCursos.limpiarTextField();
                    ventanaCursos.volverEstadoInicial();
                    ventanaCursos.mostrarMensaje("El curso fue eliminado");
                }
                
                break;
                
            case "XML":
                 if(e.getActionCommand().equals("Buscar") || e.getActionCommand().equals("ConsultaRapida"))
                {
                   buscarConXML();  
                }
                 
                  if(e.getActionCommand().equals("Agregar"))
                {
                    metodosXML_Cursos.guardarEnXML(ventanaCursos.devolverInformacion());
                    ventanaCursos.mostrarMensaje("Información agregada al archivo XML de forma correcta.");
                    ventanaCursos.limpiarTextField();
                    ventanaCursos.volverEstadoInicial();
                }
                  
                  if(e.getActionCommand().equals("Modificar"))
                {
                    metodosXML_Cursos.modificarInformacionDelXml(ventanaCursos.devolverInformacion());
                    ventanaCursos.mostrarMensaje("Información modificada en el archivo XML de forma correcta.");
                    ventanaCursos.limpiarTextField();
                    ventanaCursos.volverEstadoInicial();
                }
                  
                  if(e.getActionCommand().equals("Eliminar"))
                {
                    metodosXML_Cursos.eliminarInformacionDelXml(ventanaCursos.extraerSigla());
                    ventanaCursos.mostrarMensaje("Información eliminada del archivo XML de forma correcta.");
                    ventanaCursos.limpiarTextField();
                    ventanaCursos.volverEstadoInicial();
                }  
                break;
        }
       
      
          System.out.println("Sí sirveeeeeeeeee");
      
    }
   
    public void buscarConArchivosPlanos()
    {
       System.out.println("pppp "+ventanaCursos.extraerSigla()+"  i iiiiiiiiiiiiii");
          
         if(metodosCurso.buscarCurso(ventanaCursos.extraerSigla()))
         {
            System.out.println("iiiiiiiiiiiiiii");
           ventanaCursos.mostrarInformacion(metodosCurso.getArregloInformacion());
           ventanaCursos.deshabilitarSigla();
           ventanaCursos.habilitarBotones();
           //archivos.devolverInformacionDelArchivo();
         }
         else
         {
            
            ventanaCursos.habilitarAgregar();
            ventanaCursos.mostrarMensaje("El Curso no se encuentra registrado ");
            //archivos.crearArchivo();
         }  
    }
    
    public void buscarConBD()
        {
            if(conexionBDCursos.consultarCurso(ventanaCursos.extraerSigla()))
            {
                conexionBDCursos.consultarCurso(ventanaCursos.extraerSigla());
                ventanaCursos.mostrarInformacion(conexionBDCursos.devolverArreglo());
                ventanaCursos.deshabilitarSigla();
                ventanaCursos.habilitarBotones();
            }
            else
            {
                ventanaCursos.habilitarAgregar();
                ventanaCursos.mostrarMensaje("No se encuentra registrado el curso");
            }
        }//end buscarConBD
     
     
      public void buscarConXML()
    {
        if(metodosXML_Cursos.consultarInformacionDelXml(ventanaCursos.extraerSigla()))
        {
            ventanaCursos.mostrarInformacion(metodosXML_Cursos.getArregloInformacion());
            ventanaCursos.habilitarBotones();
            
            ventanaCursos.mostrarMensaje("Información encontrada con la cédula : "+ventanaCursos.extraerSigla());
        }
        else
        {
            ventanaCursos.mostrarMensaje("No se encontró información con la cédula: "+ventanaCursos.extraerSigla());
            ventanaCursos.habilitarAgregar();
        }   
        ventanaCursos.deshabilitarSigla();
    }//end buscarConXML
     
     
     
    
}//end class
