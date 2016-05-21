/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_VentanaCursos;
import Controlador.Controlador_FRM_VentanaEstudiante;
import Controlador.Controlador_FRM_VentanaMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.FRM_VentanaEstudiante;
import javax.swing.JOptionPane;

/**
 *
 * @author jeannette
 */
public class FuenteDeInformacion extends javax.swing.JFrame {

   FRM_MenuPrincipal menuPrincipal;
   
   Controlador_FRM_VentanaEstudiante controladorEstudiante;
   FRM_VentanaEstudiante ventanaEstudiante;
   
   FRM_VentanaCursos ventanaCursos;
   Controlador_FRM_VentanaCursos controladorCursos;
   
   Controlador_FRM_VentanaMatricula controladorMatricula;
   FRM_VentanaMatricula ventanaMatricula;
   
   
   String tipoDeFuente="";
   
   
    public FuenteDeInformacion() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Fuente De Informacion");
        
        agregarEventos();
        System.out.println("antes metos");
        System.out.println(tipoDeFuente);
        System.out.println("despues metos");
        
    }
    
   public void agregarEventos()
   {
       this.jrb_ArchivosPlanos.addActionListener(controladorEstudiante);
       
   }

    public void tipomenuPricipal(FRM_MenuPrincipal menuPrincipal){
    this.menuPrincipal=menuPrincipal;
    }
    
    
    public String tipoFuente()
    {
        System.out.println("Entró tipoFuente");
        return tipoDeFuente;
     
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jrb_ArchivosPlanos = new javax.swing.JRadioButton();
        jrb_BaseDeDatos = new javax.swing.JRadioButton();
        jrb_XML = new javax.swing.JRadioButton();
        btn_Aceptar = new javax.swing.JButton();

        buttonGroup1.add(jrb_ArchivosPlanos);
        jrb_ArchivosPlanos.setText("Archivos Planos");

        buttonGroup1.add(jrb_BaseDeDatos);
        jrb_BaseDeDatos.setText("Base de Datos");

        buttonGroup1.add(jrb_XML);
        jrb_XML.setText("XML");

        btn_Aceptar.setText("Aceptar");
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrb_ArchivosPlanos)
                    .addComponent(jrb_BaseDeDatos)
                    .addComponent(jrb_XML))
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Aceptar)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jrb_ArchivosPlanos)
                .addGap(18, 18, 18)
                .addComponent(jrb_BaseDeDatos)
                .addGap(18, 18, 18)
                .addComponent(jrb_XML)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Aceptar)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        
        if(jrb_ArchivosPlanos.isSelected())
        {
            System.out.println("isSelected");
            tipoDeFuente="ArchivosPlanos";
            System.out.println("isSelected fuente" + tipoDeFuente);
        }
        
        if(jrb_BaseDeDatos.isSelected())
        {
            System.out.println("isSelected");
            tipoDeFuente="BaseDeDatos";
            System.out.println("isSelected fuente" + tipoDeFuente);
        }
        
         if(jrb_XML.isSelected())
        {
            System.out.println("isSelected");
            tipoDeFuente="XML";
            System.out.println("isSelected fuente" + tipoDeFuente);
        }
               
        
            if(menuPrincipal.tipo().equals("Estudiante"))
            {
                
                this.ventanaEstudiante=new FRM_VentanaEstudiante(tipoDeFuente);
                System.out.println(" enviando datos de tipo de fuente" + tipoDeFuente);
                
                this.setVisible(false);
                this.ventanaEstudiante.setVisible(true);
            }//end if
            
            if(menuPrincipal.tipo().equals("Cursos"))
            {
                this.ventanaCursos=new FRM_VentanaCursos(tipoDeFuente);
                System.out.println(" enviando datos de tipo de fuente" + tipoDeFuente);
                
                this.setVisible(false);
                this.ventanaCursos.setVisible(true);
            }//end if
            
            if(menuPrincipal.tipo().equals("Matricula"))
            {
                 
                this.ventanaMatricula=new FRM_VentanaMatricula(ventanaEstudiante,ventanaCursos, tipoDeFuente);
                System.out.println(" enviando datos de tipo de fuente" + tipoDeFuente);

                
                this.setVisible(false);

                this.ventanaMatricula.setVisible(true);
            }//end if
            
            
    }//GEN-LAST:event_btn_AceptarActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JRadioButton jrb_ArchivosPlanos;
    public javax.swing.JRadioButton jrb_BaseDeDatos;
    public javax.swing.JRadioButton jrb_XML;
    // End of variables declaration//GEN-END:variables

   
    
}
