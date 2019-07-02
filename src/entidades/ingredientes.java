/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Usuario
 */
public class ingredientes {
    private String Idingrediente;
    private String Nombre;
    private int Categoria;
    private int Activo;
    private String Nitproveedor;
    private String IdProducto;
    private int Cantidad;
    private String FechaVencimiento;
    private double Precio;

    /**
     * @return the Idingrediente
     */
    public String getIdingrediente() {
        return Idingrediente;
    }

    /**
     * @param Idingrediente the Idingrediente to set
     */
    public void setIdingrediente(String Idingrediente) {
        this.Idingrediente = Idingrediente;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Categoria
     */
    public int getCategoria() {
        return Categoria;
    }

    /**
     * @param Categoria the Categoria to set
     */
    public void setCategoria(int Categoria) {
        this.Categoria = Categoria;
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
    
}
