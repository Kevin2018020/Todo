/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Mario
 */
public class Usuario {
    private String Username;
    private String Password; 
    private int Rol; 
    private int Activo;
    private String IdEmpleado;
    private int Numero_Avatar;

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Rol
     */
    public int getRol() {
        return Rol;
    }

    /**
     * @param Rol the Rol to set
     */
    public void setRol(int Rol) {
        this.Rol = Rol;
    }

    /**
     * @return the Activo
     */
    public int getActivo() {
        return Activo;
    }

    /**
     * @param Activo the Activo to set
     */
    public void setActivo(int Activo) {
        this.Activo = Activo;
    }

    /**
     * @return the IdEmpleado
     */
    public String getIdEmpleado() {
        return IdEmpleado;
    }

    /**
     * @param IdEmpleado the IdEmpleado to set
     */
    public void setIdEmpleado(String IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    /**
     * @return the Numero_Avatar
     */
    public int getNumero_Avatar() {
        return Numero_Avatar;
    }

    /**
     * @param Numero_Avatar the Numero_Avatar to set
     */
    public void setNumero_Avatar(int Numero_Avatar) {
        this.Numero_Avatar = Numero_Avatar;
    }

    
}
