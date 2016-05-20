/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_VentanaCursos;
import javax.swing.JOptionPane;



public class FRM_VentanaCursos extends javax.swing.JFrame {
    
public String fuente;

   Controlador_FRM_VentanaCursos controladorCurso;
   
    public FRM_VentanaCursos(String fuente) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Ventana Registro Curso");
         this.fuente=fuente; 
         System.out.println("ventana curso"+this.fuente);
        controladorCurso=new Controlador_FRM_VentanaCursos(this);
        gUI_Botones1.agregarEventos(controladorCurso);
        volverEstadoInicial();
    }

    public String getTipoDato()
    {
     return this.fuente;
    }
   
   public void tipoFuente(String fuente)
    {
        this.fuente=fuente;
        System.out.println("antes yyyyyy"+this.fuente);
    }
   
   public void volverEstadoInicial()
  {
      this.gUI_Botones1.volverEstadoInicial();
      this.gUI_InformacionCursos1.volverEstadoInicial();
  }
   
   public String extraerSigla()
  {
      return this.gUI_InformacionCursos1.extraerSigla();
  }
   
   public void mostrarInformacion(String arreglo[])
    {
         this.gUI_InformacionCursos1.mostrarInformacion(arreglo);
    }
   
    public void deshabilitarSigla()
  {
      this.gUI_InformacionCursos1.deshabilitarSigla();
  }
    
    public void habilitarBotones()
  {
      this.gUI_Botones1.habilitarBotones();
  }
    
    public void habilitarAgregar()
  {
      this.gUI_Botones1.habilitarAgregar();
      this.gUI_InformacionCursos1.habilitarAgregar();
  }
   
   public void mostrarMensaje(String mensaje)
  {
     JOptionPane.showMessageDialog(null, mensaje);
  }
   
   public String[] devolverInformacion()
  {
     return this.gUI_InformacionCursos1.devolverInformacion();
  }
   
   public void limpiarTextField()
  {
      this.gUI_InformacionCursos1.limpiarTextField();
  }
   
   public String devolverNombreCurso()
   {
       return this.gUI_InformacionCursos1.devolverNombreCurso();
   }
   
   public String devolverCreditos()
   {
       return this.gUI_InformacionCursos1.devolverCreditos();
   }
   
   public String devolverHorario()
   {
       return this.gUI_InformacionCursos1.devolverHorario();
   }
   
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gUI_InformacionCursos1 = new Vista.GUI_InformacionCursos();
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(gUI_InformacionCursos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(gUI_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gUI_InformacionCursos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gUI_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        controladorCurso.escribirInformacionArchivo();
        System.out.println("ADENTRO FORMCOMPONENTHIDDEN");
    }//GEN-LAST:event_formComponentHidden

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.GUI_Botones gUI_Botones1;
    private Vista.GUI_InformacionCursos gUI_InformacionCursos1;
    // End of variables declaration//GEN-END:variables
}
