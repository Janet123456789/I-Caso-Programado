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
public class ConexionBD_Cursos {
      Connection con = null;
   
   public String arregloDatos[]= new String[3];
   
    public ConexionBD_Cursos()
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
    public boolean registrarCurso(String sigla, String nombreCurso, String creditos, String horario)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
               
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO cursos(sigla, nombreCurso, creditos,horario) VALUES ('"+sigla+"','"+nombreCurso+"',"+creditos+",'"+horario+"')");
                return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    public boolean actualizarCurso(String sigla, String nombreCurso, String creditos, String horario)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE cursos SET nombreCurso='"+nombreCurso+ "',creditos="+ creditos+",horario='"+horario+"' WHERE sigla='"+sigla+"'" );
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    public boolean eliminarCurso(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM cursos WHERE sigla='"+sigla+"'" );
                
             
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    
    
    public boolean consultarCurso(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        String datos[] = new String[3];
        boolean existe=false;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT nombreCurso, creditos,horario FROM cursos WHERE sigla='"+sigla+"'");
                
                while (rs.next()) 
                {
                    arregloDatos[0] = rs.getString("nombreCurso");
                    arregloDatos[1] = rs.getString("creditos");
                    arregloDatos[2] = rs.getString("horario");
                    //int edad = rs.getInt(2);
                    System.out.println("Información de la BD:Nombre Curso: "+arregloDatos[0]+", Créditos: "+ arregloDatos[1]+",Horario: "+arregloDatos[2]); 
                    existe=true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return existe;
    }
    
  
    public String[] devolverArreglo() {
        System.out.println("créditos: "+ arregloDatos[1]);
        return arregloDatos;
        
    }
    
}//end class ConexionBDEstudiante
