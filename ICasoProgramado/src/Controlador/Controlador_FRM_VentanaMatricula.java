/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBD_Cursos;
import Modelo.ConexionBD_Estudiante;
import Modelo.ConexionBD_Matricula;
import Modelo.MetodosXML_Cursos;
import Modelo.MetodosXML_Estudiante;
import Modelo.MetodosXML_Matricula;
import Vista.FRM_VentanaCursos;
import Vista.FRM_VentanaEstudiante;
import Vista.FRM_VentanaMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author jeannette
 */
public class Controlador_FRM_VentanaMatricula implements ActionListener {

    FRM_VentanaMatricula ventanaMatricula;
    FRM_VentanaEstudiante ventanaEstudiante;
    FRM_VentanaCursos ventanaCursos;

    ConexionBD_Matricula conexion;
    ConexionBD_Cursos conexionCurso;
    ConexionBD_Estudiante conexionBD;

    MetodosXML_Estudiante metodosXML_Estudiante;
    MetodosXML_Cursos metodosXML_Cursos;
    MetodosXML_Matricula metodosXML_Matricula;

    String tipoDato;

    boolean encontroEstudiante = false;
    boolean encontroCurso = false;

    public Controlador_FRM_VentanaMatricula(FRM_VentanaEstudiante ventanaEstudiante, FRM_VentanaCursos ventanaCursos, FRM_VentanaMatricula ventanaMatricula) {
        this.ventanaMatricula = ventanaMatricula;
        this.tipoDato = this.ventanaMatricula.getTipoDato();

        conexion = new ConexionBD_Matricula();
        conexionCurso = new ConexionBD_Cursos();
        conexionBD = new ConexionBD_Estudiante();

        conexion.realizarConexion();
        conexionBD.realizarConexion();
        conexionCurso.realizarConexion();

//        metodosXML_Estudiante = new MetodosXML_Estudiante(ventanaEstudiante);
        //  metodosXML_Cursos = new MetodosXML_Cursos(ventanaCursos);
        //  metodosXML_Matricula = new MetodosXML_Matricula(ventanaMatricula);
    }//end constructor

    /*  public void escribirInformacionArchivo()
    {
        metodos.escribirInformacionArchivo();
    }*/
    public void actionPerformed(ActionEvent e) {
        System.out.println("action command. " + e.getActionCommand());
        System.out.println("adentro " + this.tipoDato);

        switch (this.tipoDato) {

            case "ArchivosPlanos":
                JOptionPane.showMessageDialog(null,"Sistema no habilitado... Se encuentra en reparación...");
                ventanaMatricula.mostrarMensaje("Sistema no habilitado... Se encuentra en reparación...");

                break;

            case "BaseDeDatos":

                if (e.getActionCommand().equals("BuscarRapidoCurso")) {
                    System.out.println("adentro primer if");

                    if (conexionCurso.consultarCurso(ventanaMatricula.devolverSigla())) {
                        String arreglo[] = conexionCurso.devolverArreglo();
                        ventanaMatricula.mostrarNombreCurso(arreglo[0]);
                        encontroCurso = true;
                        ventanaMatricula.bloquearJTFieldEnMatriculaCurso();
                    } else {
                        ventanaMatricula.mostrarMensaje("El curso consultado no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
                    }
                }

                if (e.getActionCommand().equals("BuscarRapidoEstudiante")) {
                    if (conexionBD.consultarEstudiante(ventanaMatricula.devolverCedula())) {
                        String arregloE[] = conexionBD.devolverArreglo();
                        ventanaMatricula.mostrarNombreEstudiante(arregloE[0]);
                        encontroEstudiante = true;
                        ventanaMatricula.bloquearJTFieldEnMatriculaEstudiante();
                    } else {
                        ventanaMatricula.mostrarMensaje("El estudiante consultado no se encuentra, favor diriguirse al módulo de Mantenimiento Estudiante");
                    }//end else
                }

                if (e.getActionCommand().equals("Buscar")) {
                    consultar();
                }

                if (e.getActionCommand().equals("Agregar")) {
                    ventanaMatricula.cargarTabla();
                    encontroCurso = false;
                    ventanaMatricula.estadoInicial();
                    //ventanaMatricula.limpiarCurso(); 
                }
                if (e.getActionCommand().equals("FinalizarMatricula")) {
                    for (int contador = 0; contador < ventanaMatricula.getCantidadDeCursosMatriculados(); contador++) {
                        conexion.registrarMatricula(ventanaMatricula.devolverCodigo(), ventanaMatricula.devolverCedula(), ventanaMatricula.getInformacionTabla(contador)[2]);
                    }
                    ventanaMatricula.resetearInterfaz();

                    conexion.devolverArreglo();
                }
                if (encontroEstudiante && encontroCurso) {
                    ventanaMatricula.habilitarAgregar();
                }

                if (e.getActionCommand().equals("Eliminar")) {
                    conexion.eliminarMatricula(ventanaMatricula.devolverSigla());

                    ventanaMatricula.estadoInicial();
                    ventanaMatricula.mostrarMensaje("Estudiante eliminado");
                }

                break;

            case "XML":
                ventanaMatricula.mostrarMensaje("Sistema no habilitado... Se encuentra en reparación...");
                /*  if(e.getActionCommand().equals("Buscar") || e.getActionCommand().equals("ConsultaRapida"))
                {
                   buscarConXML_Matricula();  
                }
                 
                  if(e.getActionCommand().equals("Agregar"))
                {
                    metodosXML_Matricula.guardarEnXML(ventanaEstudiante.devolverInformacion());
                    ventanaEstudiante.mostrarMensaje("Información agregada al archivo XML de forma correcta.");
                    ventanaEstudiante.limpiarTextField();
                    ventanaEstudiante.volverEstadoInicial();
                }
                  
                  if(e.getActionCommand().equals("Modificar"))
                {
                    metodosXML_Matricula.modificarInformacionDelXml(ventanaEstudiante.devolverInformacion());
                    ventanaEstudiante.mostrarMensaje("Información modificada en el archivo XML de forma correcta.");
                    ventanaEstudiante.limpiarTextField();
                    ventanaEstudiante.volverEstadoInicial();
                }
                  
                  if(e.getActionCommand().equals("Eliminar"))
                {
                    metodosXML_Matricula.eliminarInformacionDelXmlDeEstudiante(ventanaEstudiante.extraerCedula());
                    ventanaEstudiante.mostrarMensaje("Información eliminada del archivo XML de forma correcta.");
                    ventanaEstudiante.limpiarTextField();
                    ventanaEstudiante.volverEstadoInicial();
                }  */
                break;

        }//end switch
        System.out.println("finaaaal");
    }//end actionCommand

    /*public String colocarCodigo()
    {
        return conexion.devolverCodigo();
    }*/
    public void consultar() {
        if (conexion.consultarMatricula(ventanaMatricula.devolverCodigo())) {
            conexion.consultarMatricula(ventanaMatricula.devolverCodigo());
            ventanaMatricula.mostrarInformacion(conexion.devolverArreglo());
            ventanaMatricula.deshabilitarSigla();
            ventanaMatricula.habilitarOpciones();
        } else {
            ventanaMatricula.habilitarAgregar();
            ventanaMatricula.mostrarSms("No se encuentra registrado el estudiante");
        }
    }

    public void buscarConXML_Matricula() {
        if (metodosXML_Matricula.consultarInformacionDelXml(ventanaEstudiante.extraerCedula())) {
            ventanaEstudiante.mostrarInformacion(metodosXML_Matricula.getArregloInformacion());
            ventanaEstudiante.habilitarBotones();

            ventanaEstudiante.mostrarMensaje("Información encontrada con la cédula : " + ventanaEstudiante.extraerCedula());
        } else {
            ventanaEstudiante.mostrarMensaje("No se encontró información con la cédula: " + ventanaEstudiante.extraerCedula());
            ventanaEstudiante.habilitarAgregar();
        }
        ventanaEstudiante.deshabilitarCedula();
    }

}//end class
