/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import entidades.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mario
 */
public class VentaServicio {
     private final String tabla = "ventas";
   public void guardar(Connection conexion, Venta venta) throws SQLException{
      try{
         if(venta != null){
           
            PreparedStatement consulta;

            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(IdVenta, CodigoCliente, cod_vendedor ,Fecha, Hora, Total) VALUES(?, ?, ?,?,?,?)");
            consulta.setString(1, venta.getIdVenta());
            consulta.setString(2, venta.getCodigoCliente());
            consulta.setString(3, venta.getCod_vendedor());
            consulta.setString(4, venta.getFecha());
            consulta.setString(5, venta.getHora());
            consulta.setDouble(6, venta.getTotal());
            consulta.executeUpdate();

         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
}
