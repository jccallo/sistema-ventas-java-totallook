/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;

/**
 *
 * @author Jorge Ccallo M
 */
public class Venta {
    int id;
    int clienteId;
    int vendedorId;
    String numeroSerie;
    String fechaVenta;
    double montoVenta;

    public Venta() {
    }

    public Venta(int id, int clienteId, int vendedorId, String numeroSerie, String fechaVenta, double montoVenta) {
        this.id = id;
        this.clienteId = clienteId;
        this.vendedorId = vendedorId;
        this.numeroSerie = numeroSerie;
        this.fechaVenta = fechaVenta;
        this.montoVenta = montoVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(int vendedorId) {
        this.vendedorId = vendedorId;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(double montoVenta) {
        this.montoVenta = montoVenta;
    }
}
