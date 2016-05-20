/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_VentanaMatricula;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeannette
 */
public class FRM_VentanaMatricula extends javax.swing.JFrame {

    DefaultTableModel modelo;
    Controlador_FRM_VentanaMatricula controlador;
    
    public String fuente;
   
    
    public FRM_VentanaMatricula(FRM_VentanaEstudiante ventanaEstudiante, FRM_VentanaCursos ventanaCursos,String fuente) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Ventana Registro Matricula");
        this.fuente=fuente;
        System.out.println("ventana estudiante"+this.fuente);
        controlador=new Controlador_FRM_VentanaMatricula(ventanaEstudiante,ventanaCursos,this);
        modelo=new DefaultTableModel();
        this.jtb_Tabla.setModel(modelo);
        colocarTitulosTabla();
        agregarEventos();
        gUI_Botones1.volverEstadoInicial();
    }
    
    public String getTipoDato(){
       return this.fuente;
       }

     public void tipoFuente(String fuente)
       {
           this.fuente=fuente;
           System.out.println("antes tggggggggggg"+this.fuente);
         }
    
    
   public void habilitarAgregar()
    {
        this.gUI_Botones1.habilitarAgregar();
    }
    public void estadoInicial()
    {
        this.gUI_Botones1.volverEstadoInicial();
    }
    public void limpiarCurso()
    {
        this.jt_Sigla.setText("");
        this.jt_NombreDelCursoEnMatricula.setText("");
    }
    public void cargarTabla()
    {
        String arreglo[]=new String[4];
       
        arreglo[0]=this.jt_Cedula.getText();
        arreglo[1]=this.jt_NombreEstudianteEnMatricula.getText();
        arreglo[2]=this.jt_Sigla.getText();
        arreglo[3]=this.jt_NombreDelCursoEnMatricula.getText();
        
        modelo.addRow(arreglo);
    }
    public String devolverCedula()
    {
        return this.jt_Cedula.getText();
    }
    public String devolverSigla()
    {
        return this.jt_Sigla.getText();
    }
    
    public String devolverCodigo()
    {
        return this.jt_CodigoMatricula.getText();
    }
    
    public void mostrarNombreEstudiante(String nombre)
    {
        this.jt_NombreEstudianteEnMatricula.setText(nombre);
    }
    public void mostrarNombreCurso(String nombre)
    {
        this.jt_NombreDelCursoEnMatricula.setText(nombre);
    }
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public void agregarEventos()
    {
        this.btn_BuscadorRapidoEstudiante.addActionListener(controlador);
        this.btn_BuscadorRapidoEstudiante.setActionCommand("BuscarRapidoEstudiante");
        this.btn_BuscadorRapidoCurso.addActionListener(controlador);
        this.btn_BuscadorRapidoCurso.setActionCommand("BuscarRapidoCurso");
        this.btn_FinalizaMatricula.addActionListener(controlador);
        this.gUI_Botones1.agregarEventos(controlador);
    }
    public int getCantidadDeCursosMatriculados()
    {
        return modelo.getRowCount();
    }
    public void colocarTitulosTabla()
    {
        modelo.addColumn("Cedula");
        modelo.addColumn("Nombre Estudiante");
        modelo.addColumn("Sigla");
        modelo.addColumn("Nombre Curso");
    }
    public String[] getInformacionTabla(int contador)
    {
        String arreglo[]=new String[3];
        
        arreglo[0]=this.jt_CodigoMatricula.getText();
        arreglo[1]=""+this.modelo.getValueAt(contador, 0);//no se qué es
        arreglo[2]=""+this.modelo.getValueAt(contador, 2);
        
        return arreglo;
    }
    public void resetearInterfaz()
    {
        //colocarCodigo();
        this.jt_Cedula.setText("");
        this.jt_NombreEstudianteEnMatricula.setText("");
        this.jt_Sigla.setText("");
        this.jt_NombreDelCursoEnMatricula.setText("");
        
        int tamanio=modelo.getRowCount();
        
        for(int contador=0;contador<tamanio;contador++)
        {
            modelo.removeRow(0);
        }   
    }
   /* public void colocarCodigo()
    {
        this.jt_CodigoMatricula.setText(controlador.colocarCodigo());
    }*/
    
    public void mostrarInformacion(String arreglo[])
    {
        this.jt_Cedula.setText(arreglo[0]);
        this.jt_Sigla.setText(arreglo[1]);
        
    }
    
    public void deshabilitarSigla()
    {
        this.jt_Sigla.setEnabled(false);
        this.jt_NombreDelCursoEnMatricula.setEnabled(true);
    }
    
    public void habilitarOpciones()
    {
        this.gUI_Botones1.habilitarBotones();
        this.btn_FinalizaMatricula.setEnabled(true);
        this.btn_BuscadorRapidoEstudiante.setEnabled(true);
        this.btn_BuscadorRapidoCurso.setEnabled(true);
    }
    
   public void mostrarSms(String sms)
   {
       JOptionPane.showMessageDialog(null,sms);
   }
   
   public void bloquearJTFieldEnMatriculaEstudiante()
   {
       this.jt_Cedula.setEnabled(false);
       this.jt_NombreEstudianteEnMatricula.setEnabled(false);
   }
   
   public void bloquearJTFieldEnMatriculaCurso()
   {
       this.jt_Sigla.setEnabled(false);
       this.jt_NombreDelCursoEnMatricula.setEnabled(false);
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_CodigoDeMatricula = new javax.swing.JLabel();
        jl_CedulaMatricula = new javax.swing.JLabel();
        jl_NombreEstudianteEnMatricula = new javax.swing.JLabel();
        jt_CodigoMatricula = new javax.swing.JTextField();
        jt_NombreEstudianteEnMatricula = new javax.swing.JTextField();
        jt_Cedula = new javax.swing.JTextField();
        jt_Sigla = new javax.swing.JTextField();
        jt_NombreDelCursoEnMatricula = new javax.swing.JTextField();
        jl_SiglaEnMatricula = new javax.swing.JLabel();
        jl_NombreDelCursoEnMatricula = new javax.swing.JLabel();
        btn_BuscadorRapidoEstudiante = new javax.swing.JButton();
        btn_BuscadorRapidoCurso = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_Tabla = new javax.swing.JTable();
        gUI_Botones1 = new Vista.GUI_Botones();
        btn_FinalizaMatricula = new javax.swing.JButton();

        jl_CodigoDeMatricula.setText("Código de Matrícula");

        jl_CedulaMatricula.setText("Cédula");

        jl_NombreEstudianteEnMatricula.setText("Nombre Estudiante");

        jl_SiglaEnMatricula.setText("Sigla");

        jl_NombreDelCursoEnMatricula.setText("Nombre Curso");

        btn_BuscadorRapidoEstudiante.setText("Buscar");
        btn_BuscadorRapidoEstudiante.setActionCommand("BuscarRapidoEstudiante");

        btn_BuscadorRapidoCurso.setText("Buscar");
        btn_BuscadorRapidoCurso.setActionCommand("BuscarRapidoCurso");

        jtb_Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtb_Tabla);

        btn_FinalizaMatricula.setText("Finalizar Matricula");
        btn_FinalizaMatricula.setActionCommand("FinalizarMatricula");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gUI_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_FinalizaMatricula)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_CodigoDeMatricula)
                            .addComponent(jl_CedulaMatricula)
                            .addComponent(jl_NombreEstudianteEnMatricula))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jt_NombreEstudianteEnMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(jt_Cedula)
                            .addComponent(jt_CodigoMatricula))
                        .addGap(16, 16, 16)
                        .addComponent(btn_BuscadorRapidoEstudiante)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_NombreDelCursoEnMatricula)
                            .addComponent(jl_SiglaEnMatricula))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_BuscadorRapidoCurso))
                            .addComponent(jt_NombreDelCursoEnMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_CodigoDeMatricula)
                    .addComponent(jt_CodigoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_CedulaMatricula)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_BuscadorRapidoEstudiante)
                                .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_NombreEstudianteEnMatricula)
                            .addComponent(jt_NombreEstudianteEnMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_SiglaEnMatricula)
                            .addComponent(btn_BuscadorRapidoCurso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jt_NombreDelCursoEnMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_NombreDelCursoEnMatricula))))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gUI_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_FinalizaMatricula)
                        .addGap(24, 24, 24))))
        );

        jl_CodigoDeMatricula.getAccessibleContext().setAccessibleName("Código de Matrícula");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_BuscadorRapidoCurso;
    private javax.swing.JButton btn_BuscadorRapidoEstudiante;
    private javax.swing.JButton btn_FinalizaMatricula;
    private Vista.GUI_Botones gUI_Botones1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_CedulaMatricula;
    private javax.swing.JLabel jl_CodigoDeMatricula;
    private javax.swing.JLabel jl_NombreDelCursoEnMatricula;
    private javax.swing.JLabel jl_NombreEstudianteEnMatricula;
    private javax.swing.JLabel jl_SiglaEnMatricula;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_CodigoMatricula;
    private javax.swing.JTextField jt_NombreDelCursoEnMatricula;
    private javax.swing.JTextField jt_NombreEstudianteEnMatricula;
    private javax.swing.JTextField jt_Sigla;
    private javax.swing.JTable jtb_Tabla;
    // End of variables declaration//GEN-END:variables
}
