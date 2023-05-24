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
public class ClienteDao {

    PreparedStatement ps;
    ResultSet rs;

    Conexion conexion = new Conexion();
    Connection acceso;

    public List listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente ORDER BY id DESC";

        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setDni(rs.getString(2));
                cliente.setNombre(rs.getString(3));
                cliente.setTelefono(rs.getString(4));
                cliente.setDireccion(rs.getString(5));
                cliente.setEstado(rs.getString(6));

                lista.add(cliente);
            }
            
            ps.close();
            acceso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean agregar(Cliente cliente) {
        boolean respuesta = false;
        String sql = "INSERT INTO cliente (dni, nombre, telefono, direccion, estado) VALUES (?, ?, ?, ?, ?)";

        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getEstado());
            respuesta = ps.executeUpdate() > 0;
            
            ps.close();
            acceso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respuesta;
    }

    public boolean actualizar(Cliente cliente) {
        boolean respuesta = false;
        String sql = "UPDATE cliente SET dni=?, nombre=?, telefono=?, direccion=?, estado=? WHERE id=?";

        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getEstado());
            ps.setInt(6, cliente.getId());
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
        String sql = "DELETE FROM cliente WHERE id=?";

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
    
    public Cliente getById(int id) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE id=?";
        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {  // usar if en lugar de while
                cliente = new Cliente(); // crear objeto solo si se encuentra algo en la base de datos
                cliente.setId(rs.getInt(1));
                cliente.setDni(rs.getString(2));
                cliente.setNombre(rs.getString(3));
                cliente.setTelefono(rs.getString(4));
                cliente.setDireccion(rs.getString(5));
                cliente.setEstado(rs.getString(6));
            }
            
            ps.close();
            acceso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }
    
    public Cliente getByDni(String dni) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE dni=?";
        try {
            acceso = conexion.mysql();
            ps = acceso.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {  // usar if en lugar de while
                cliente = new Cliente(); // crear objeto solo si se encuentra algo en la base de datos
                cliente.setId(rs.getInt(1));
                cliente.setDni(rs.getString(2));
                cliente.setNombre(rs.getString(3));
                cliente.setTelefono(rs.getString(4));
                cliente.setDireccion(rs.getString(5));
                cliente.setEstado(rs.getString(6));
            }
            
            ps.close();
            acceso.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }
}
