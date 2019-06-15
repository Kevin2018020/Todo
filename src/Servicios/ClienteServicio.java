/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidades.Cliente;


public class ClienteServicio {
   private final String tabla = "clientes";
   public void guardar(Connection conexion, Cliente cliente) throws SQLException{
      try{
         if(cliente.getCodigo() != null){
           
            PreparedStatement consulta;

            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(Codigo,Nombre,Apellido,Telefono,Direccion,Nit) VALUES(?, ?, ?,?,?,?)");
            consulta.setString(1, cliente.getCodigo());
            consulta.setString(2, cliente.getNombre());
            consulta.setString(3, cliente.getApellido());
            consulta.setString(4, cliente.getTelefono());
            consulta.setString(5, cliente.getDireccion());
            consulta.setString(6, cliente.getNit());
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
   

   public Cliente recuperarPorId(Connection conexion, String nit) throws SQLException {
      Cliente cliente = null;
      try{
         PreparedStatement consulta = conexion.prepareStatement("SELECT Nombre, Apellido , Telefono, Direccion, Nit  FROM " + this.tabla + " WHERE Nit = ?" );
         consulta.setString(1, nit);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            cliente = new Cliente();
            cliente.setNombre(resultado.getString("Nombre"));
            cliente.setApellido(resultado.getString("Apellido"));
            cliente.setTelefono(resultado.getString("Telefono"));
            cliente.setDireccion(resultado.getString("Direccion"));
            cliente.setNit(resultado.getString("Nit"));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return cliente;
   }
   /*
   public void eliminar(Connection conexion, Tarea tarea) throws SQLException{
      try{
         PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE id_tarea = ?");
         consulta.setInt(1, tarea.getId_tarea());
         consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
   public List<Tarea> recuperarTodas(Connection conexion) throws SQLException{
      List<Tarea> tareas = new ArrayList<>();
      try{
         PreparedStatement consulta = conexion.prepareStatement("SELECT id_tarea, titulo, descripcion, nivel_de_prioridad FROM " + this.tabla + " ORDER BY nivel_de_prioridad");
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            tareas.add(new Tarea(resultado.getInt("id_tarea"), resultado.getString("titulo"), resultado.getString("descripcion"), resultado.getInt("nivel_de_prioridad")));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return tareas;
   }*/
}