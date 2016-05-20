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
public class ConexionBD_Matricula {
   
    Connection con = null;
   
    public String arregloDatos[]= new String[2];
   
    public ConexionBD_Matricula() 
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
    public boolean registrarMatricula(String codigoMatricula, String cedula, String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO matricula(codigoMatricula, cedula, sigla) VALUES ('"+codigoMatricula+"','"+cedula+"','"+sigla+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    public boolean actualizarMatricula(String codigoMatricula, String cedula, String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE matricula SET codigoMatricula='"+codigoMatricula+ "',cedula='"+ cedula+"' WHERE sigla='"+sigla+"'" );
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    public boolean eliminarMatricula(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM estudiante WHERE sigla='"+sigla+"'" );
                
             
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    
    
    public boolean consultarMatricula(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        String datos[] = new String[2];
        boolean encontro=false;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT codigoMatricula, cedula FROM matricula WHERE sigla='"+sigla+"'");
                
                while (rs.next()) 
                {
                    arregloDatos[0] = rs.getString("codigoMatricula");
                    arregloDatos[1] = rs.getString("cedula");
                    
                    //int edad = rs.getInt(2);
                    System.out.println("Información de la BD:codigoMatricula: "+arregloDatos[0]+", cedula: "+ arregloDatos[1]); 
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
}//end class
