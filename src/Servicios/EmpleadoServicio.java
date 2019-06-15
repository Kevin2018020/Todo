/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import entidades.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mario
 */
public class EmpleadoServicio {
      private final String tabla = "empleados";
   
    public void guardar(Connection conexion, Empleado empleado) throws SQLException{
      try{
         if(empleado != null){
           
            PreparedStatement consulta;

            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(Codigo,Nombre,Apellido,Genero,Telefono,Correo,Direccion,DPI,Activo,IdSede) VALUES(?, ?, ?,?,?,?, ?, ?,?,?)");
            consulta.setString(1, empleado.getCodigo());
            consulta.setString(2, empleado.getNombre());
            consulta.setString(3, empleado.getApellido());
            consulta.setInt(4, empleado.getGenero());
            consulta.setInt(5, empleado.getTelefono());
            consulta.setString(6, empleado.getCorreo());
            consulta.setString(7, empleado.getDireccion());
            consulta.setInt(8, empleado.getDPI());
            consulta.setInt(9, empleado.getActivo());
            consulta.setString(10, empleado.getIdSede());
            consulta.executeUpdate();

         }
        
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
    
    
    
    
    
    
    
    
    
    
    
    
}
}

