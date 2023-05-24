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
public class Reporte {
    String numero_serie;
    String nombre_cliente;
    String fecha_venta;
    String cantidad;
    String monto_venta;

    public Reporte() {
    }

    public Reporte(String numero_serie, String nombre_cliente, String fecha_venta, String cantidad, String monto_venta) {
        this.numero_serie = numero_serie;
        this.nombre_cliente = nombre_cliente;
        this.fecha_venta = fecha_venta;
        this.cantidad = cantidad;
        this.monto_venta = monto_venta;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getMonto_venta() {
        return monto_venta;
    }

    public void setMonto_venta(String monto_venta) {
        this.monto_venta = monto_venta;
    }
}
