/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_VentanaCursos;
import Controlador.Controlador_FRM_VentanaEstudiante;
import Controlador.Controlador_FRM_VentanaMatricula;

/**
 *
 * @author jeannette
 */
public class GUI_Botones extends javax.swing.JPanel {

    Controlador_FRM_VentanaEstudiante controladorEstudiante;
    Controlador_FRM_VentanaCursos controladorCursos;
    Controlador_FRM_VentanaMatricula controladorMatricula;
    
    public GUI_Botones() {
        initComponents();
    }

   public void agregarEventos(Controlador_FRM_VentanaEstudiante controladorEstudiante)
    {
        this.controladorEstudiante=controladorEstudiante;
        this.btn_Buscar.addActionListener(controladorEstudiante);
        this.btn_Agregar.addActionListener(controladorEstudiante);
        this.btn_Modificar.addActionListener(controladorEstudiante);
        this.btn_Eliminar.addActionListener(controladorEstudiante);
    }
   
   public void agregarEventos(Controlador_FRM_VentanaCursos controladorCursos)
    {
        this.controladorCursos=controladorCursos;
        this.btn_Buscar.addActionListener(controladorCursos);
        this.btn_Agregar.addActionListener(controladorCursos);
        this.btn_Modificar.addActionListener(controladorCursos);
        this.btn_Eliminar.addActionListener(controladorCursos);
    }
   
    public void agregarEventos(Controlador_FRM_VentanaMatricula controladorMatricula)
    {
        this.controladorMatricula=controladorMatricula;
        this.btn_Buscar.addActionListener(controladorMatricula);
        this.btn_Agregar.addActionListener(controladorMatricula);
        this.btn_Modificar.addActionListener(controladorMatricula);
        this.btn_Eliminar.addActionListener(controladorMatricula);
        
        this.btn_Buscar.setActionCommand("Buscar");
        this.btn_Agregar.setActionCommand("Agregar");
        this.btn_Modificar.setActionCommand("Modificar");
        this.btn_Eliminar.setActionCommand("Eliminar");
    }
   
    public void habilitarBotones()
    {
     this.btn_Buscar.setEnabled(false);
     this.btn_Agregar.setEnabled(false);
     this.btn_Modificar.setEnabled(true);
     this.btn_Eliminar.setEnabled(true);
    }
    
    public void habilitarAgregar()
    {
        this.btn_Buscar.setEnabled(false);
        this.btn_Agregar.setEnabled(true);
        this.btn_Modificar.setEnabled(false);
        this.btn_Eliminar.setEnabled(false);
    }
    
    public void volverEstadoInicial()
    {
        this.btn_Buscar.setEnabled(true);
        this.btn_Agregar.setEnabled(false);
        this.btn_Modificar.setEnabled(false);
        this.btn_Eliminar.setEnabled(false);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Buscar = new javax.swing.JButton();
        btn_Agregar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();

        btn_Buscar.setText("Buscar");

        btn_Agregar.setText("Agregar");

        btn_Modificar.setText("Modificar");

        btn_Eliminar.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Buscar)
                .addGap(18, 18, 18)
                .addComponent(btn_Agregar)
                .addGap(18, 18, 18)
                .addComponent(btn_Modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Eliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Buscar)
                    .addComponent(btn_Agregar)
                    .addComponent(btn_Modificar)
                    .addComponent(btn_Eliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Modificar;
    // End of variables declaration//GEN-END:variables
}
