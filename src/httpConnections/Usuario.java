/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpConnections;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Axel
 */
public class Usuario {
    @SerializedName("username")
    public String Username;
    
    @SerializedName("password")
    public String Password;
    
    @SerializedName("rol")
    public String Role;
    
     @SerializedName("Activo")
    public String activo;
     
     @SerializedName("idempleado")
    public String Idempleado;
    
    public Usuario(String username, String password, String role, String Activo, String idempleado) {
        Username = username;
        Password = password;
        Role = role;
        activo = Activo;
        Idempleado = idempleado;
        
    }
    
    public String getUsername() {
        return Username;
    }
    
    public String getPassword() {
        return Password;
    }
    
    public String getRole() {
        return Role;
    }
    public String getActivo() {
        return activo;
    }
    public String getIdempleado() {
        return Idempleado;
    }
    }

