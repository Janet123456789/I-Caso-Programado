/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_VentanaEstudiante;
import javax.swing.JOptionPane;

/**
 *
 * @author jeannette
 */
public class FRM_VentanaEstudiante extends javax.swing.JFrame {

    Controlador_FRM_VentanaEstudiante controlador;
   
    public String fuente;
    
    public FRM_VentanaEstudiante(String fuente) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Ventana Registro Estudiante");
        
        this.fuente=fuente;
        System.out.println("ventana estudiante"+this.fuente);
        controlador=new Controlador_FRM_VentanaEstudiante(this);
        
        gUI_Botones1.agregarEventos(controlador);
        volverEstadoInicial();
         
       // tipoFuenteDeInformacion();
        
    }
    
    public String getTipoDato(){
    return this.fuente;
    }
    
  public void tipoFuente(String fuente)
    {
        this.fuente=fuente;
        System.out.println("antes tggggggggggg"+this.fuente);
      }
  
  
  public String extraerCedula()
  {
      return this.gUI_InformacionEstudiante1.extraerCedula();
  }
  
  public void mostrarInformacion(String arreglo[])
    {
        this.gUI_InformacionEstudiante1.mostrarInformacion(arreglo);
    }
  
  public void deshabilitarCedula()
  {
      this.gUI_InformacionEstudiante1.deshabilitarCedula();
  }

  public void habilitarBotones()
  {
      this.gUI_Botones1.habilitarBotones();
  }
  
  public void habilitarAgregar()
  {
      this.gUI_Botones1.habilitarAgregar();
      this.gUI_InformacionEstudiante1.habilitarAgregar();
  }
  
  public void mostrarMensaje(String mensaje)
  {
     JOptionPane.showMessageDialog(null, mensaje);
  }
  
  public String[] devolverInformacion()
  {
     return this.gUI_InformacionEstudiante1.devolverInformacion();
  }
  
  public void limpiarTextField()
  {
      this.gUI_InformacionEstudiante1.limpiarTextField();
  }
  
  public void volverEstadoInicial()
  {
      this.gUI_Botones1.volverEstadoInicial();
      this.gUI_InformacionEstudiante1.volverEstadoInicial();
  }
  
  public String devolverNombreCompleto()
  {
      return this.gUI_InformacionEstudiante1.devolverNombreCompleto();
  }
  
  public String devolverDireccion()
  {
      return this.gUI_InformacionEstudiante1.devolverDireccion();
  }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gUI_InformacionEstudiante1 = new Vista.GUI_InformacionEstudiante();
        gUI_Botones1 = new Vista.GUI_Botones();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gUI_InformacionEstudiante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gUI_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gUI_InformacionEstudiante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(gUI_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        controlador.escribirInformacionArchivo();
        System.out.println("ADENTRO FORMCOMPONENTHIDDEN");
    }//GEN-LAST:event_formComponentHidden

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.GUI_Botones gUI_Botones1;
    private Vista.GUI_InformacionEstudiante gUI_InformacionEstudiante1;
    // End of variables declaration//GEN-END:variables
}
