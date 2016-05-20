/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
    
    boolean encontro=false;
    

    public Controlador_Usuario(IniciarSecion inicioSecion) {
        this.inicioSecion = inicioSecion;
        metodosUsuario = new MetodosUsuario();

    }

    public Controlador_Usuario(FRM_VentanaRegistroUsuario registroUsuario) {
        this.registroUsuario = registroUsuario;
        metodosUsuario = new MetodosUsuario();

    }
    
   

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Iniciar")) {
            if (metodosUsuario.verificarDatos(inicioSecion.devolverInformacion())) {
                encontro = true;
                inicioSecion.usuarioRegistrado(encontro);
                //inicioSecion.mostrarInformacion(metodosUsuario.getArregloInformacion());

            }

        }//end if iniciar
        
        if (e.getActionCommand().equals("Registrar")) {
            metodosUsuario.agregarUsuario(registroUsuario.devolverInformacion());
            encontro=true;
            registroUsuario.usuarioRegistrado(encontro);
            //HACER METODO AQUI PARA AGREGAR ARCHIVOS
            System.out.println("listo");
        }//end if registrar
    }//end actionPerformed 

}//end class
