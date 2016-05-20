/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.FRM_ControladorMenuPrincipal;

/**
 *
 * @author jeannette
 */
public class FRM_MenuPrincipal extends javax.swing.JFrame {

    String tipo="";
    FRM_ControladorMenuPrincipal controlador;
    
    public FRM_MenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Ventana Principal");
        controlador = new FRM_ControladorMenuPrincipal();
        agregarEventos();
    }

   public void agregarEventos()
    {
        this.jm_Salir.addActionListener(controlador);
    }
   
   public String tipo()
   {
       return tipo;
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_RegistrarEstudiante = new javax.swing.JButton();
        btn_RegistrarCursos = new javax.swing.JButton();
        btn_RegistrarMatricula = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_Archivos = new javax.swing.JMenu();
        jm_Salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_RegistrarEstudiante.setText("Registrar Estudiante");
        btn_RegistrarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarEstudianteActionPerformed(evt);
            }
        });

        btn_RegistrarCursos.setText("Registrar Cursos");
        btn_RegistrarCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarCursosActionPerformed(evt);
            }
        });

        btn_RegistrarMatricula.setText("Registrar Matricula");
        btn_RegistrarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarMatriculaActionPerformed(evt);
            }
        });

        jm_Archivos.setText("Archivos");

        jm_Salir.setText("Salir");
        jm_Archivos.add(jm_Salir);

        jMenuBar1.add(jm_Archivos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_RegistrarEstudiante)
                    .addComponent(btn_RegistrarCursos, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_RegistrarMatricula, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btn_RegistrarEstudiante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_RegistrarCursos)
                .addGap(18, 18, 18)
                .addComponent(btn_RegistrarMatricula)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RegistrarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarEstudianteActionPerformed

        FuenteDeInformacion fuente=new FuenteDeInformacion();
        fuente.tipomenuPricipal(this);
        
        fuente.setVisible(true);
        tipo="Estudiante";
        
        //dispose();
        System.out.println(tipo);
    }//GEN-LAST:event_btn_RegistrarEstudianteActionPerformed

    private void btn_RegistrarCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarCursosActionPerformed
        FuenteDeInformacion fuente=new FuenteDeInformacion();
        fuente.tipomenuPricipal(this);
        fuente.setVisible(true);
        //dispose();
        tipo="Cursos";
    }//GEN-LAST:event_btn_RegistrarCursosActionPerformed

    private void btn_RegistrarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarMatriculaActionPerformed
        FuenteDeInformacion fuente=new FuenteDeInformacion();
        fuente.tipomenuPricipal(this);
        fuente.setVisible(true);
       // dispose();
        tipo="Matricula";
    }//GEN-LAST:event_btn_RegistrarMatriculaActionPerformed

    /**
     * @param args the command line arguments
     */
    /*aquii public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRM_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       /*aquii  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_MenuPrincipal().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_RegistrarCursos;
    private javax.swing.JButton btn_RegistrarEstudiante;
    private javax.swing.JButton btn_RegistrarMatricula;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jm_Archivos;
    private javax.swing.JMenuItem jm_Salir;
    // End of variables declaration//GEN-END:variables
}
