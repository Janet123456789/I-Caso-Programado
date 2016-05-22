/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author jeannette
 */
public class FRM_VentanaRegistroUsuario extends javax.swing.JFrame {

    Controlador_Usuario controladorUsuario;
    
    boolean usuarioRegistrado=false;
    
    public FRM_VentanaRegistroUsuario() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Ventana Registro Usuario");
        agregarEventos(controladorUsuario);
        controladorUsuario=new Controlador_Usuario(this);
    }

    public void agregarEventos(Controlador_Usuario controladorUsuario)
   {
       this.controladorUsuario= controladorUsuario;
       this.btn_Registrar.addActionListener(this.controladorUsuario);
       this.btn_Registrar.setActionCommand("Registrar");
   }
     
     public String[] devolverInformacion()
   {
       String arreglo[];
       arreglo=new String [2];
       
       arreglo[0]=this.jt_NombreUsuario.getText();
       arreglo[1]=this.jpf_Contrasena.getText();
       
       return arreglo;
   }
     
     
      public void usuarioRegistrado(boolean usuarioRegistrado)
    {
        this.usuarioRegistrado=usuarioRegistrado;
    }
      
    public String extraerUsuario()
    {
        System.out.println("Nombre Usuario: "+this.jt_NombreUsuario.getText());
        return this.jt_NombreUsuario.getText();
        
    }
    
    public String extraerContrasena()
    {
        return this.jpf_Contrasena.getText();
    }
      

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_NombreUsuario = new javax.swing.JLabel();
        jl_Contrasena = new javax.swing.JLabel();
        jt_NombreUsuario = new javax.swing.JTextField();
        jpf_Contrasena = new javax.swing.JPasswordField();
        btn_Registrar = new javax.swing.JButton();
        btn_CancelarRegistroUsuario = new javax.swing.JButton();

        jl_NombreUsuario.setText("Usuario");

        jl_Contrasena.setText("Contraseña");

        btn_Registrar.setText("Registrar");
        btn_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarActionPerformed(evt);
            }
        });

        btn_CancelarRegistroUsuario.setText("Cancelar");
        btn_CancelarRegistroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarRegistroUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btn_Registrar)
                        .addGap(76, 76, 76)
                        .addComponent(btn_CancelarRegistroUsuario))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_NombreUsuario)
                            .addComponent(jl_Contrasena))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jt_NombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jpf_Contrasena)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_NombreUsuario)
                    .addComponent(jt_NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Contrasena)
                    .addComponent(jpf_Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Registrar)
                    .addComponent(btn_CancelarRegistroUsuario))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarActionPerformed
        if(usuarioRegistrado==true)
        {
          FRM_MenuPrincipal menuPrincipal=new FRM_MenuPrincipal();        
          menuPrincipal.setVisible(true);
        }
        else
        {        
            JOptionPane.showMessageDialog(null,"Error al registrar Usuario"); 
        }
    }//GEN-LAST:event_btn_RegistrarActionPerformed

    private void btn_CancelarRegistroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarRegistroUsuarioActionPerformed
       VentanaDePreguntaSobreCuentaUsuario primerVentana=new VentanaDePreguntaSobreCuentaUsuario();
       primerVentana.setVisible(true);
    }//GEN-LAST:event_btn_CancelarRegistroUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CancelarRegistroUsuario;
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JLabel jl_Contrasena;
    private javax.swing.JLabel jl_NombreUsuario;
    private javax.swing.JPasswordField jpf_Contrasena;
    private javax.swing.JTextField jt_NombreUsuario;
    // End of variables declaration//GEN-END:variables
}
