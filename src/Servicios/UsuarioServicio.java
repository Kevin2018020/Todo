
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;


import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mario
 */
public class UsuarioServicio {
    
    private final String tabla = "usuarios";
   
    public void guardar(Connection conexion, Usuario usuario) throws SQLException{
      try{
         if(usuario != null){
           
            PreparedStatement consulta;

            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(Username,Password,Rol,Activo,IdEmpleado) VALUES(?, ?, ?,?,?)");
            consulta.setString(1, usuario.getUsername());
            consulta.setString(2, usuario.getPassword());
            consulta.setInt(3, usuario.getRol());
            consulta.setInt(4, usuario.getActivo());
            consulta.setString(5, usuario.getIdEmpleado());
            consulta.executeUpdate();

         }/*else{
            consulta = conexion.prepareStatement("UPDATE " + this.tabla + "(Codigo,Nombre,Apellido,Telefono,Direccion,Nit) VALUES(?, ?, ?,?,?,?)");
            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET Nombre = ?, Apellido = ?, Telefono = ?, Direccion = ?, Nit = ? WHERE Codigo = ?");
            consulta.setString(1, cliente.getNombre());
            consulta.setString(2, cliente.getApellido());
            consulta.setString(3, cliente.getTelefono());
            consulta.setString(4, cliente.getDireccion());
            consulta.setString(5, cliente.getNit());
            consulta.setString(6, cliente.getCodigo());

         }*/
        
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
   

   public Usuario recuperarPorUsername(Connection conexion, String idUsuario) throws SQLException {
      Usuario usuario = null;
      try{
         PreparedStatement consulta = conexion.prepareStatement("SELECT Username, Password , Rol, Activo, IdEmpleado  FROM " + this.tabla + " WHERE Username = ?" );
         consulta.setString(1, idUsuario);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            usuario = new Usuario();
            usuario.setUsername(resultado.getString("Username"));
            usuario.setPassword(resultado.getString("Password"));
            usuario.setRol(resultado.getInt("Rol"));
            usuario.setActivo(resultado.getInt("Activo"));
            usuario.setIdEmpleado(resultado.getString("IdEmpleado"));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return usuario;
   }
}


