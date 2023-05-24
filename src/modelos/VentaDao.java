/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge Ccallo M
 */
public class VentaDao {
    PreparedStatement ps;
    ResultSet rs;

    Conexion conexion = new Conexion();
    Connection acceso;
    
    public boolean insert(Venta venta) {
        boolean respuesta = false;
        String sql = "INSERT INTO venta (cliente_id, vendedor_id, numero_serie, fecha_venta, monto_venta) VALUES (?, ?, ?, ?, ?)";

        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            ps.setInt(1, venta.getClienteId());
            ps.setInt(2, venta.getVendedorId());
            ps.setString(3, venta.getNumeroSerie());
            ps.setString(4, venta.getFechaVenta());            
            ps.setDouble(5, venta.getMontoVenta());
            respuesta = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respuesta;
    }
    
    public int insertGetId(Venta venta) {
        int idInsertado = 0;
        String sql = "INSERT INTO venta (cliente_id, vendedor_id, numero_serie, fecha_venta, monto_venta) VALUES (?, ?, ?, ?, ?)";

        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venta.getClienteId());
            ps.setInt(2, venta.getVendedorId());
            ps.setString(3, venta.getNumeroSerie());
            ps.setString(4, venta.getFechaVenta());            
            ps.setDouble(5, venta.getMontoVenta());
            ps.executeUpdate();
            
            // Obtener el ID insertado
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idInsertado = rs.getInt(1);
                System.out.println("ID insertado: " + idInsertado);
            }
            
            rs.close();
            ps.close();
            acceso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idInsertado;
    }
}
