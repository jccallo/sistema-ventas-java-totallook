/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jorge Ccallo M
 */
public class ProductoDao {
    PreparedStatement ps;
    ResultSet rs;

    Conexion conexion = new Conexion();
    Connection acceso;
    
    public Producto getById(int id) {
        Producto producto = null;
        String sql = "SELECT * FROM producto WHERE id=?";
        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {  // usar if en lugar de while
                producto = new Producto(); // crear objeto solo si se encuentra algo en la base de datos
                producto.setId(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setStock(rs.getInt(4));
                producto.setEstado(rs.getString(5));
            }
            
            ps.close();
            acceso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return producto;
    }
}
