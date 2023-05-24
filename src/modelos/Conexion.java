/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jorge Ccallo M
 */
public class Conexion {
    Connection conexion;
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/sistema_ventas_java?useSSL=false&allowPublicKeyRetrieval=true";
    String usuario = "root";
    String clave = "";

    public Connection mysql() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, clave);
            System.out.println("conectao");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
        return conexion;
    }
}
