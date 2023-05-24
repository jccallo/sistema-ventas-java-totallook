/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge Ccallo M
 */
public class DetalleVentaDao {
    PreparedStatement ps;
    ResultSet rs;

    Conexion conexion = new Conexion();
    Connection acceso;
    
    public boolean insert(List<DetalleVenta> detalleVentas) {
        boolean respuesta = false;
        String sql = "INSERT INTO detalle_venta (venta_id, producto_id, cantidad, precio_venta) VALUES (?, ?, ?, ?)";

        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            
            for (DetalleVenta detalleVenta : detalleVentas) {
                ps.setInt(1, detalleVenta.getVentaId());
                ps.setInt(2, detalleVenta.getProductoId());
                ps.setInt(3, detalleVenta.getCantidad());
                ps.setDouble(4, detalleVenta.getPrecioVenta());
                
                ps.addBatch(); // Agregar la inserción al lote
            }
            
            int[] resultados = ps.executeBatch(); // Ejecutar el lote de inserciones
            
            respuesta = resultados.length == detalleVentas.size();
            
            ps.close();
            acceso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return respuesta;
    }
}
