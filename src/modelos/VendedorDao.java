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
public class VendedorDao {

    PreparedStatement ps;
    ResultSet rs;

    Conexion conexion = new Conexion();
    Connection acceso;
    
    public List getAll() {
        List<Vendedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM vendedor ORDER BY id DESC";

        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setId(rs.getInt(1));
                vendedor.setDni(rs.getString(2));
                vendedor.setNombre(rs.getString(3));
                vendedor.setTelefono(rs.getString(4));
                vendedor.setUsuario(rs.getString(5));
                vendedor.setEstado(rs.getString(6));
                lista.add(vendedor);
            }
            
            ps.close();
            acceso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public boolean insert(Vendedor vendedor) {
        boolean respuesta = false;
        String sql = "INSERT INTO vendedor (dni, nombre, telefono, usuario, estado) VALUES (?, ?, ?, ?, ?)";

        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, vendedor.getDni());
            ps.setString(2, vendedor.getNombre());
            ps.setString(3, vendedor.getTelefono());
            ps.setString(4, vendedor.getUsuario());
            ps.setString(5, vendedor.getEstado());
            respuesta = ps.executeUpdate() > 0;
            
            ps.close();
            acceso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respuesta;
    }
    
    public boolean update(Vendedor vendedor) {
        boolean respuesta = false;
        String sql = "UPDATE vendedor SET dni=?, nombre=?, telefono=?, usuario=?, estado=? WHERE id=?";

        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, vendedor.getDni());
            ps.setString(2, vendedor.getNombre());
            ps.setString(3, vendedor.getTelefono());
            ps.setString(4, vendedor.getUsuario());
            ps.setString(5, vendedor.getEstado());
            ps.setInt(6, vendedor.getId());
            respuesta = ps.executeUpdate() > 0;
            
            ps.close();
            acceso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respuesta;
    }
    
    public boolean eliminar(int id) {
        boolean respuesta = false;
        String sql = "DELETE FROM vendedor WHERE id=?";

        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            ps.setInt(1, id);
            respuesta = ps.executeUpdate() > 0;
            
            ps.close();
            acceso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respuesta;
    }
    
    public Vendedor getById(int id) {
        Vendedor vendedor = null;
        String sql = "SELECT * FROM vendedor WHERE id=?";
        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {  // usar if en lugar de while
                vendedor = new Vendedor(); // crear objeto solo si se encuentra algo en la base de datos
                vendedor.setId(rs.getInt(1));
                vendedor.setDni(rs.getString(2));
                vendedor.setNombre(rs.getString(3));
                vendedor.setTelefono(rs.getString(4));
                vendedor.setUsuario(rs.getString(5));
                vendedor.setEstado(rs.getString(6));
            }
            
            ps.close();
            acceso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendedor;
    }
    
    public Vendedor getByDni(String dni) {
        Vendedor vendedor = null;
        String sql = "SELECT * FROM vendedor WHERE dni=?";
        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {  // usar if en lugar de while
                vendedor = new Vendedor(); // crear objeto solo si se encuentra algo en la base de datos
                vendedor.setId(rs.getInt(1));
                vendedor.setDni(rs.getString(2));
                vendedor.setNombre(rs.getString(3));
                vendedor.setTelefono(rs.getString(4));
                vendedor.setUsuario(rs.getString(5));
                vendedor.setEstado(rs.getString(6));
            }
            
            ps.close();
            acceso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendedor;
    }

    // validamos al vendedor usando el dni como contraseña y el usuario
    public Vendedor validar(String dni, String usuario) {
        Vendedor vendedor = null; // inicializar como null
        String sql = "SELECT * FROM vendedor WHERE dni=? AND usuario=?";
        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, usuario);
            rs = ps.executeQuery();
            if (rs.next()) {  // usar if en lugar de while
                vendedor = new Vendedor(); // crear objeto solo si se encuentra algo en la base de datos
                vendedor.setId(rs.getInt(1));
                vendedor.setDni(rs.getString(2));
                vendedor.setNombre(rs.getString(3));
                vendedor.setTelefono(rs.getString(4));
                vendedor.setEstado(rs.getString(5));
                vendedor.setUsuario(rs.getString(6));
            }
            
            ps.close();
            acceso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendedor;
    }
}
