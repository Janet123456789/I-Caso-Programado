/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jeannette
 */
public class ConexionBD_Estudiante {
       Connection con = null;
   
       public String arregloDatos[]= new String[2];
   
    public ConexionBD_Estudiante()
    {
        
    }
    
   
    public void realizarConexion()
    {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3307/registroEstudiante";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    public boolean registrarEstudiante(String cedula, String nombreCompleto, String direccion)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO estudiante(cedula, nombreCompleto, direccion) VALUES ('"+cedula+"','"+nombreCompleto+"','"+direccion+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    public boolean actualizarEstudiante(String cedula, String nombreCompleto, String direccion)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE estudiante SET nombreCompleto='"+nombreCompleto+ "',direccion='"+ direccion+"' WHERE cedula='"+cedula+"'" );
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    public boolean eliminarEstudiante(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM estudiante WHERE cedula='"+cedula+"'" );
                
             
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    
    
    public boolean consultarEstudiante(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;
        String datos[] = new String[2];
        boolean encontro=false;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT nombreCompleto, direccion FROM estudiante WHERE cedula='"+cedula+"'");
                
                while (rs.next()) 
                {
                    arregloDatos[0] = rs.getString("nombreCompleto");
                    arregloDatos[1] = rs.getString("direccion");
                    
                    //int edad = rs.getInt(2);
                    System.out.println("Información de la BD:Nombre Completo: "+arregloDatos[0]+", Dirección: "+ arregloDatos[1]); 
                    encontro=true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return encontro;
    }
    
  
    public String[] devolverArreglo() {
        
        return arregloDatos;
        
    }
}//end class ConexionBD
