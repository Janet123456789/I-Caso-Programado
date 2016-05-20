package Controlador;

import Vista.FRM_MenuPrincipal;
import Vista.FRM_VentanaCursos;
import Vista.FRM_VentanaEstudiante;
import Vista.FRM_VentanaMatricula;
import Vista.FRM_VentanaRegistroUsuario;
import Vista.FuenteDeInformacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jeannette
 */
public class FRM_ControladorMenuPrincipal implements ActionListener{

   
   
    
    public FRM_ControladorMenuPrincipal() {
     
    }//end constructor
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);   
        }
        
       /* if(e.getActionCommand().equals("Registrar Usuario"))
        {
            this.ventanaUsuario.setVisible(true);
        }
        
        if(e.getActionCommand().equals("Estudiante"))
        {
            this.ventanaEstudiante.setVisible(true);
        }
        
        if(e.getActionCommand().equals("Cursos"))
        {
            this.ventanaCurso.setVisible(true);
        }
        
        if(e.getActionCommand().equals("Matricula"))
        {
            this.ventanaCurso.setVisible(true);
        }*/
    }
            
    
    
    
    
    
}//end class
