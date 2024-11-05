/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectojava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author tm_galli
 */

public class ConexionBD {
    private Connection connect() {
    Connection conn = null;
    try {
        // URL de la base de datos, usuario y contraseña
        String url = "jdbc:mysql://bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb";
        String user = "uwwqerjcglxxweor";
        String password = "vWobxeLnCiH11WTJg6N";

        conn = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
    }
    return conn;
}

    
    
    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {
    Alta1 miVentana = new Alta1();
    // Obtener los valores del formulario
    String nombre = txtNom.getText();
    String apellido = txtApe.getText();
    String club = jTextField2.getText();
    int edad = Integer.parseInt((String) jComboBox1.getSelectedItem());
    String estado = (String) jComboBox2.getSelectedItem();
    String contacto = jTextField5.getText();
    String dni = jTextField6.getText();
    String gmail = txtGmail.getText();

    // Conectar a la base de datos e insertar los datos
    String sql = "INSERT INTO deportistas (nombre, apellido, club, edad, estado, contacto, dni, gmail) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, nombre);
        pstmt.setString(2, apellido);
        pstmt.setString(3, club);
        pstmt.setInt(4, edad);
        pstmt.setString(5, estado);
        pstmt.setString(6, contacto);
        pstmt.setString(7, dni);
        pstmt.setString(8, gmail);

        pstmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Deportista registrado exitosamente!");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al registrar el deportista: " + e.getMessage());
    }

    // Limpiar los campos después de enviar los datos
    txtNom.setText("");
    txtApe.setText("");
    jTextField2.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    txtGmail.setText("");
}

}
