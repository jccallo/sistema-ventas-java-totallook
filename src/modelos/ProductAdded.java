/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Jorge Ccallo M
 */
public class ProductAdded {
    int id;
    String nombre;
    double cantidaD;
    double precio;
    double totalParcial;

    public ProductAdded() {
    }

    public ProductAdded(int id, String nombre, double cantidaD, double precio, double totalParcial) {
        this.id = id;
        this.nombre = nombre;
        this.cantidaD = cantidaD;
        this.precio = precio;
        this.totalParcial = totalParcial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidaD() {
        return cantidaD;
    }

    public void setCantidaD(double cantidaD) {
        this.cantidaD = cantidaD;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotalParcial() {
        return totalParcial;
    }

    public void setTotalParcial(double totalParcial) {
        this.totalParcial = totalParcial;
    }
}
