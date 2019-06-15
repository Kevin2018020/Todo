/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Usuario Dell
 */
public class Proveedores {
    private String Nitproveedor;
    private String NombreProveedor;
    private int telefono;
    private String Direcion;
    private int activo;

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
     * @return the NombreProveedor
     */
    public String getNombreProveedor() {
        return NombreProveedor;
    }

    /**
     * @param NombreProveedor the NombreProveedor to set
     */
    public void setNombreProveedor(String NombreProveedor) {
        this.NombreProveedor = NombreProveedor;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the Direcion
     */
    public String getDirecion() {
        return Direcion;
    }

    /**
     * @param Direcion the Direcion to set
     */
    public void setDirecion(String Direcion) {
        this.Direcion = Direcion;
    }

    /**
     * @return the activo
     */
    public int getActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(int activo) {
        this.activo = activo;
    }
}
