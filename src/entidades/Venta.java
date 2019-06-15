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
public class Venta {
    					
    private String IdVenta;
    private String CodigoCliente;
    private String cod_vendedor;
    private String Fecha;
    private String Hora;
    private double Total;

    /**
     * @return the IdVenta
     */
    public String getIdVenta() {
        return IdVenta;
    }

    /**
     * @param IdVenta the IdVenta to set
     */
    public void setIdVenta(String IdVenta) {
        this.IdVenta = IdVenta;
    }

    /**
     * @return the CodigoCliente
     */
    public String getCodigoCliente() {
        return CodigoCliente;
    }

    /**
     * @param CodigoCliente the CodigoCliente to set
     */
    public void setCodigoCliente(String CodigoCliente) {
        this.CodigoCliente = CodigoCliente;
    }

    /**
     * @return the cod_vendedor
     */
    public String getCod_vendedor() {
        return cod_vendedor;
    }

    /**
     * @param cod_vendedor the cod_vendedor to set
     */
    public void setCod_vendedor(String cod_vendedor) {
        this.cod_vendedor = cod_vendedor;
    }

    /**
     * @return the Fecha
     */
    public String getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @return the Hora
     */
    public String getHora() {
        return Hora;
    }

    /**
     * @param Hora the Hora to set
     */
    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    /**
     * @return the Total
     */
    public double getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(double Total) {
        this.Total = Total;
    }
    
    
           
    
    
    
    
    
    
}
