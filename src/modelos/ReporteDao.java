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
public class ReporteDao {
    PreparedStatement ps;
    ResultSet rs;

    Conexion conexion = new Conexion();
    Connection acceso;
    
    public List getById(int id) {
        List<Reporte> lista = new ArrayList<>();
        String sql = "SELECT " +  
                    "numero_serie, " +
                    "(SELECT nombre FROM cliente WHERE id = v.cliente_id) AS nombre_cliente, " +
                    "fecha_venta, " +
                    "(SELECT count(cantidad) FROM detalle_venta WHERE venta_id = v.id) AS cantidad, " +
                    "monto_venta " +
                    "FROM venta AS v " +
                    "WHERE vendedor_id = ?";

        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Reporte reporte = new Reporte();
                reporte.setNumero_serie(rs.getString(1));
                reporte.setNombre_cliente(rs.getString(2));
                reporte.setFecha_venta(rs.getString(3));
                reporte.setCantidad(rs.getString(4));
                reporte.setMonto_venta(rs.getString(5));

                lista.add(reporte);
            }
            
            ps.close();
            acceso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
