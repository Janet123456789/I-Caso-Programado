/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBD_Usuario;
import Modelo.MetodosUsuario;
import Vista.FRM_VentanaRegistroUsuario;
import Vista.IniciarSecion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jeannette
 */
public class Controlador_Usuario implements ActionListener {

    IniciarSecion inicioSecion;
    MetodosUsuario metodosUsuario;
    FRM_VentanaRegistroUsuario registroUsuario;
    ConexionBD_Usuario conexionBD_Usuario;

    boolean encontro = false;
    String usuario;
    String contrasena;
    public Controlador_Usuario(String usuario,String contrasena) {
       this.usuario=usuario;
       this.contrasena=contrasena;
       
        conexionBD_Usuario = new ConexionBD_Usuario();
        conexionBD_Usuario.realizarConexion();
       
    }
    
    public boolean validar(){
        
        if(conexionBD_Usuario.consultarUsuario(this.usuario,this.contrasena)){
        return true;
        }
    return false;
    }
    
    public Controlador_Usuario(IniciarSecion inicioSecion) {
        this.inicioSecion = inicioSecion;
        metodosUsuario = new MetodosUsuario();
        conexionBD_Usuario = new ConexionBD_Usuario();
        conexionBD_Usuario.realizarConexion();
        System.out.println("1");
    }

    public Controlador_Usuario(FRM_VentanaRegistroUsuario registroUsuario) {
        this.registroUsuario = registroUsuario;
        metodosUsuario = new MetodosUsuario();
        conexionBD_Usuario = new ConexionBD_Usuario();
        conexionBD_Usuario.realizarConexion();
System.out.println("2");
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Iniciar")) {
            System.out.println("usuario:");
            if (conexionBD_Usuario.consultarUsuario(registroUsuario.extraerUsuario(),registroUsuario.extraerContrasena()))
               
                  System.out.println("entroo al consultar");
                    // {metodosUsuario.verificarDatos(inicioSecion.devolverInformacion())
                 //
                 encontro = true;
                 inicioSecion.usuarioRegistrado(encontro);
            //inicioSecion.mostrarInformacion(metodosUsuario.getArregloInformacion());

        

            }//end if iniciar

    if (e.getActionCommand ().equals("Registrar")) 
    {
            System.out.println("Adentroooo");
        metodosUsuario.agregarUsuario(registroUsuario.devolverInformacion());
        encontro = true;
        registroUsuario.usuarioRegistrado(encontro);
        //HACER METODO AQUI PARA AGREGAR ARCHIVOS
        conexionBD_Usuario.registrarUsuario(registroUsuario.extraerUsuario(), registroUsuario.extraerContrasena());

        System.out.println("listo");
    }//end if registrar
}//end actionPerformed 


}//end class
