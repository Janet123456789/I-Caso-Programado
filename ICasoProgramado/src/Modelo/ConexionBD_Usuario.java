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
import javax.swing.JOptionPane;

/**
 *
 * @author jeannette
 */
public class ConexionBD_Usuario {

   Connection con = null;
   
   public String arregloDatos[]= new String[2];
   
    public ConexionBD_Usuario()
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
    public boolean registrarUsuario(String usuario, String contrasena)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO usuario(usuario, contrasena) VALUES ('"+usuario+"','"+contrasena+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    
   public boolean consultarUsuario(String usuario, String contrasena)
    {//, String contrasena
        ResultSet rs = null;
        Statement cmd = null;
        String datos[] = new String[1];
        boolean encontro=false;

        System.err.println(usuario+" 8888  "+contrasena);
        try {
            System.err.println(usuario+""+contrasena);
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT usuario, contrasena FROM usuario WHERE usuario='"+usuario+"' AND contrasena= '"+contrasena+"'");
                
                while (rs.next()) 
                {
                    System.err.println("encontro");
                    //arregloDatos[0] = rs.getString("usuario");
                    arregloDatos[0] = rs.getString("usuario");
                    arregloDatos[1] = rs.getString("contrasena");
                    
                    //int edad = rs.getInt(2);
                    //System.out.println("Información de la BD: Usuario: "+arregloDatos[0]+", Contraseña: "+ arregloDatos[1]); 
                    //System.out.println("Información de la BD: Usuario: "+arregloDatos[0] +" Contraseña: "+arregloDatos[1]); 

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
