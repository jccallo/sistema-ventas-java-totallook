/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.net.URI;
import javax.swing.JTextField;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jorge Ccallo M
 */
public class Store {

    public static int vendedorId;    
    public static String nombreVendedor;


    // enviar mensaje por whatsapp
    public static void sendWhatsappMessage(String codigoPais, String telefono) {
        String url = "https://api.whatsapp.com/send?phone=" + codigoPais + telefono;
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // validar dni
    public static boolean validarDNI(String dni) {
        return dni.matches("^\\d{8}$");
    }
    
    // validar dni
    public static boolean validarTelefono(String telefono) {
        return telefono.matches("^(1\\d{6,7}|9\\d{8})$");
    }
    
    // validar solo numeros
    public static void soloNumeros(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (!Character.isDigit(tecla)) evt.consume();
    }
    
    public static void soloNumerosDecimales(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (!Character.isDigit(tecla) && tecla != '.' || tecla == '.' && ((JTextField) evt.getSource()).getText().contains(".")) {
            evt.consume();
        }
    }
    
    // validar solo caracteres
    public static void soloCaracteres(KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (tecla >= '0' && tecla <= '9') evt.consume();
    }
    
    public  static double soloDosDecimales(double numero) {
        return Math.round(numero * 100.0) / 100.0;
        //return Double.parseDouble(String.format("%.2f", numero));
    }
    
    public static String generarNumeroSerie() {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString().replaceAll("-", "");

        // Obtener solo los dígitos numéricos
        String digitosNumericos = uuidString.replaceAll("[^0-9]", "");

        // Asegurarse de tener 11 dígitos
        int faltantes = 11 - digitosNumericos.length();
        if (faltantes > 0) {
            StringBuilder ceros = new StringBuilder();
            for (int i = 0; i < faltantes; i++) {
                ceros.append("0");
            }
            digitosNumericos = ceros.toString() + digitosNumericos;
        } else if (faltantes < 0) {
            digitosNumericos = digitosNumericos.substring(0, 11);
        }

        return digitosNumericos;
    }
    
    public static String obtenerFechaActualFormateada() {
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(fechaActual);
        return fechaFormateada;
    }
}
