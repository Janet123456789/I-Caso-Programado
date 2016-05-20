/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author jeannette
 */
public class GUI_InformacionEstudiante extends javax.swing.JPanel {

    /**
     * Creates new form GUI_InformacionEstudiante
     */
    public GUI_InformacionEstudiante() {
        initComponents();
    }

    public String extraerCedula()
    {
        return this.jt_Cedula.getText();
    }
    
    public void mostrarInformacion(String arreglo[])
   {
       this.jt_NombreCompleto.setText(arreglo[0]);
       this.jt_Direccion.setText(arreglo[1]);
   }
    
    public void deshabilitarCedula()
    {
        this.jt_Cedula.setEnabled(false);
        this.jt_NombreCompleto.setEnabled(true);
        this.jt_Direccion.setEnabled(true);
    }
    
   public void habilitarAgregar()
   {
       this.jt_Cedula.setEnabled(false);
       this.jt_NombreCompleto.setEnabled(true);
       this.jt_Direccion.setEnabled(true);
   }
   
   public String[] devolverInformacion()
   {
       String arreglo[];
       arreglo=new String[3];
       
       arreglo[0]=this.jt_Cedula.getText();
       arreglo[1]=this.jt_NombreCompleto.getText();
       arreglo[2]=this.jt_Direccion.getText();
       
       return arreglo;
   }
   
   public void limpiarTextField()
   {
       this.jt_Cedula.setText("");
       this.jt_NombreCompleto.setText("");
       this.jt_Direccion.setText("");
   }
   
   public void volverEstadoInicial()
   {
       this.jt_Cedula.setEnabled(true);
       this.jt_NombreCompleto.setEnabled(false);
       this.jt_Direccion.setEnabled(false);
   }
   
   public String devolverNombreCompleto()
   {
       return this.jt_NombreCompleto.getText();
   }
   
   public String devolverDireccion()
   {
       return this.jt_Direccion.getText();
   }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Cedula = new javax.swing.JLabel();
        jl_NombreCompleto = new javax.swing.JLabel();
        jl_Direccion = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        jt_NombreCompleto = new javax.swing.JTextField();
        jt_Direccion = new javax.swing.JTextField();

        jl_Cedula.setText("Cedula");

        jl_NombreCompleto.setText("Nombre Completo");

        jl_Direccion.setText("Direccion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jl_NombreCompleto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jt_NombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jl_Direccion)
                                .addGap(75, 75, 75)
                                .addComponent(jt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_Cedula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Cedula)
                    .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_NombreCompleto)
                    .addComponent(jt_NombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Direccion)
                    .addComponent(jt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jl_Cedula;
    private javax.swing.JLabel jl_Direccion;
    private javax.swing.JLabel jl_NombreCompleto;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_Direccion;
    private javax.swing.JTextField jt_NombreCompleto;
    // End of variables declaration//GEN-END:variables
}
