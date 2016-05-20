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
public class GUI_InformacionCursos extends javax.swing.JPanel {

    /**
     * Creates new form GUI_InformacionCursos
     */
    public GUI_InformacionCursos() {
        initComponents();
    }

    public void volverEstadoInicial()
    {
        this.jt_Sigla.setEnabled(true);
        this.jt_NombreCurso.setEnabled(false);
        this.jcb_Creditos.setEnabled(false);
        this.jt_Horario.setEnabled(false);
    }
    
     public String extraerSigla()
    {
        return this.jt_Sigla.getText();
    }
     
     public void mostrarInformacion(String arreglo[])
   {
       this.jt_NombreCurso.setText(arreglo[0]);
       if(arreglo[1]!=null)
       {
           System.out.println("ENTROOOOOOOOOOOOOOO");
           
            this.jcb_Creditos.setSelectedIndex(Integer.parseInt(arreglo[1])); 
         
       }
       
       this.jt_Horario.setText(arreglo[2]);
       
     
   }
     
     
    public String[] devolverInformacion()
   {
       String arreglo[];
       arreglo=new String[4];
       
       arreglo[0]=this.jt_Sigla.getText();
       arreglo[1]=this.jt_NombreCurso.getText();
       arreglo[2]=""+this.jcb_Creditos.getSelectedIndex();
       arreglo[3]=this.jt_Horario.getText();
       
       return arreglo;
   }
    
    public void limpiarTextField()
   {
       this.jt_Sigla.setText("");
       this.jt_NombreCurso.setText("");
       this.jcb_Creditos.setSelectedIndex(0);
       this.jt_Horario.setText("");
   }
    
    public void deshabilitarSigla()
    {
        this.jt_Sigla.setEnabled(false);
        this.jt_NombreCurso.setEnabled(true);
        this.jcb_Creditos.setEnabled(true);
        this.jt_Horario.setEnabled(true);
    }
    
    public void habilitarAgregar()
   {
       this.jt_Sigla.setEnabled(false);
       this.jt_NombreCurso.setEnabled(true);
       this.jcb_Creditos.setEnabled(true);
       this.jt_Horario.setEnabled(true);
   }
    
    public String devolverNombreCurso()
    {
        return this.jt_NombreCurso.getText();
    }
    
    public String devolverCreditos()
    {
        return this.jcb_Creditos.getSelectedItem().toString();
    }
    
    public String devolverHorario()
    {
        return this.jt_Horario.getText();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Sigla = new javax.swing.JLabel();
        jl_NombreCurso = new javax.swing.JLabel();
        jl_Creditos = new javax.swing.JLabel();
        jl_Horario = new javax.swing.JLabel();
        jt_Sigla = new javax.swing.JTextField();
        jt_NombreCurso = new javax.swing.JTextField();
        jt_Horario = new javax.swing.JTextField();
        jcb_Creditos = new javax.swing.JComboBox<>();

        jl_Sigla.setText("Sigla");

        jl_NombreCurso.setText("Nombre del Curso");

        jl_Creditos.setText("Créditos");

        jl_Horario.setText("Horario");

        jcb_Creditos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_NombreCurso)
                            .addComponent(jl_Sigla)
                            .addComponent(jl_Creditos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcb_Creditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jt_NombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_Horario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jt_Horario, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Sigla)
                    .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_NombreCurso)
                    .addComponent(jt_NombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_Creditos)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jcb_Creditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jl_Horario)
                    .addComponent(jt_Horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jcb_Creditos;
    private javax.swing.JLabel jl_Creditos;
    private javax.swing.JLabel jl_Horario;
    private javax.swing.JLabel jl_NombreCurso;
    private javax.swing.JLabel jl_Sigla;
    private javax.swing.JTextField jt_Horario;
    private javax.swing.JTextField jt_NombreCurso;
    private javax.swing.JTextField jt_Sigla;
    // End of variables declaration//GEN-END:variables
}
