/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author Usuario Dell
 */
public class stock {
    
    private String Nitproveedor;
    private String IdProducto;
    private int Cantidad;
    private String FechaVencimiento;
    private double Precio;

    /**
     * @return the Nitproveedor
     */
    public String getNitproveedor() {
        return Nitproveedor;
    }

    /**
     * @param Nitproveedor the Nitproveedor to set
     */
    public void setNitproveedor(String Nitproveedor) {
        this.Nitproveedor = Nitproveedor;
    }

    /**
     * @return the IdProducto
     */
    public String getIdProducto() {
        return IdProducto;
    }

    /**
     * @param IdProducto the IdProducto to set
     */
    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    /**
     * @return the Cantidad
     */
    public int getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    /**
     * @return the FechaVencimiento
     */
    public String getFechaVencimiento() {
        return FechaVencimiento;
    }

    /**
     * @param FechaVencimiento the FechaVencimiento to set
     */
    public void setFechaVencimiento(String FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    /**
     * @return the Precio
     */
    public double getPrecio() {
        return Precio;
    }

    /**
     * @param Precio the Precio to set
     */
    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void getFechaVencimiento(Date valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
