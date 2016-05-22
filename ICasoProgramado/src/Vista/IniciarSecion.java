/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_Usuario;
import Modelo.MetodosUsuario;
import javax.swing.JOptionPane;

/**
 *
 * @author jeannette
 */
public class IniciarSecion extends javax.swing.JFrame {
    
    Controlador_Usuario controladorSecion;
    MetodosUsuario metodosUsuario;
    
    boolean usuarioRegistrado=false;
   
    
   
    
    public IniciarSecion() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Ventana de Inicio De Seción");
      // 
        agregarEventos(controladorSecion);
        metodosUsuario=new MetodosUsuario();
       
    }

    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
   /* public void mostrarInformacion(String arreglo[])
   {
       this.jt_VerificarUsuario.setText(arreglo[0]);
       this.jp_VerificarContrasena.setText(arreglo[1]);
   }*/
    
    public void usuarioRegistrado(boolean usuarioRegistrado)
    {
        this.usuarioRegistrado=usuarioRegistrado;
    }
    
   public void agregarEventos(Controlador_Usuario controladorSecion)
   {
       this.controladorSecion=controladorSecion;
       this.btn_IniciarSecion.addActionListener(controladorSecion);
       this.btn_IniciarSecion.setActionCommand("Iniciar");
   }
   
   public String[] devolverInformacion()
   {
       String arreglo[];
       arreglo=new String [2];
       
       arreglo[0]=this.jt_VerificarUsuario.getText();
       arreglo[1]=this.jp_VerificarContrasena.getText();
       
       return arreglo;
   }
   
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Usuario = new javax.swing.JLabel();
        jl_Contrasena = new javax.swing.JLabel();
        jt_VerificarUsuario = new javax.swing.JTextField();
        jp_VerificarContrasena = new javax.swing.JPasswordField();
        btn_IniciarSecion = new javax.swing.JButton();
        btn_CancelarInicioDeSecion = new javax.swing.JButton();

        jl_Usuario.setText("Usuario");

        jl_Contrasena.setText("Contraseña");

        btn_IniciarSecion.setText("Iniciar");
        btn_IniciarSecion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_IniciarSecionMouseClicked(evt);
            }
        });

        btn_CancelarInicioDeSecion.setText("Cancelar");
        btn_CancelarInicioDeSecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarInicioDeSecionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Usuario)
                            .addComponent(jl_Contrasena))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jt_VerificarUsuario)
                            .addComponent(jp_VerificarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btn_IniciarSecion)
                        .addGap(81, 81, 81)
                        .addComponent(btn_CancelarInicioDeSecion)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Usuario)
                    .addComponent(jt_VerificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Contrasena)
                    .addComponent(jp_VerificarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_IniciarSecion)
                    .addComponent(btn_CancelarInicioDeSecion))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_IniciarSecionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_IniciarSecionMouseClicked
       
        String usuario=this.jt_VerificarUsuario.getText().toString();
        String contrasena=""+this.jp_VerificarContrasena.getText().toString();
        System.err.println("aquiii "+contrasena);
         controladorSecion=new Controlador_Usuario(usuario,contrasena);
         
        if(controladorSecion.validar())
        {
          FRM_MenuPrincipal menuPrincipal=new FRM_MenuPrincipal();        
          menuPrincipal.setVisible(true);
        }
        else
        {        
           
            JOptionPane.showMessageDialog(null,"El Usuario no se encuentra registrado, se procederá a la Ventana Registro Usuario");

         
            FRM_VentanaRegistroUsuario ventanaRegistro=new FRM_VentanaRegistroUsuario();
            controladorSecion=new Controlador_Usuario(ventanaRegistro);
            ventanaRegistro.agregarEventos(controladorSecion);
            ventanaRegistro.setVisible(true);
        }
        
        
    }//GEN-LAST:event_btn_IniciarSecionMouseClicked

    private void btn_CancelarInicioDeSecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarInicioDeSecionActionPerformed
       VentanaDePreguntaSobreCuentaUsuario primerVentana=new VentanaDePreguntaSobreCuentaUsuario();
       primerVentana.setVisible(true);
    }//GEN-LAST:event_btn_CancelarInicioDeSecionActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CancelarInicioDeSecion;
    private javax.swing.JButton btn_IniciarSecion;
    private javax.swing.JLabel jl_Contrasena;
    private javax.swing.JLabel jl_Usuario;
    private javax.swing.JPasswordField jp_VerificarContrasena;
    private javax.swing.JTextField jt_VerificarUsuario;
    // End of variables declaration//GEN-END:variables
}
