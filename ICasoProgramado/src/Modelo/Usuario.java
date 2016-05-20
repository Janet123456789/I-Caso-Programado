/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author jeannette
 */
public class Usuario {
    
    public String usuario;
    public String contrasena;
    
    public Usuario(String usuario, String contrasena)
    {
        this.usuario=usuario;
        this.contrasena=contrasena;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    public String getInformacion()
    {
        return "Usuario: "+usuario+ " Contraseña: "+contrasena;
    } 
}//end class
