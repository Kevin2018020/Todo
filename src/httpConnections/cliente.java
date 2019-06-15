/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpConnections;

import com.google.gson.annotations.SerializedName;
/**
 *
 * @author Mario
 */
public class cliente {

        
    @SerializedName("nombre")
    public String Nombre;
    
    @SerializedName("apellido")
    public String Apellido;
    
    @SerializedName("telefono")
    public String Telefono;
    
     @SerializedName("direccion")
    public String Direccion;
     
      @SerializedName("nit")
    public String Nit;
    
      @SerializedName("codigo")
    public String Codigo;
      
      public cliente(String nombre, String apellido, String telefono, String direccion, String nit, String codigo) {
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
        Direccion = direccion;
        Nit = nit;
        Codigo = codigo;
        
      }
      
      public String getNombre() {
        return Nombre;
    }
      public String getApellido() {
        return Apellido;
    }
      public String getTelefono() {
        return Telefono;
    }
      public String getDireccion() {
        return Direccion;
    }
      public String getNit() {
        return Nit;
    }
      public String getCodigo() {
        return Codigo;
    }

    
}
