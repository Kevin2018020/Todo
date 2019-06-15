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
public class Productos {
    private String Idproducto;
    private String Nombre;
    private int Categoria;
    private int Activo;

    /**
     * @return the Idprodycto
     */
    public String getIdprodycto() {
        return Idproducto;
    }

    /**
     * @param Idprodycto the Idprodycto to set
     */
    public void setIdprodycto(String Idprodycto) {
        this.Idproducto = Idprodycto;
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
    
    
}
