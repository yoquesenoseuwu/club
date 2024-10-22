/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas;

import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author thiag
 */
public class ConexionBDD {
    public Connection Conectar() {
        Connection miConexion = null; // Inicializa la conexión como nula
        try {
            // Asegúrate de que la URL esté correctamente formateada
            String url = "jdbc:mysql://bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb";
            String user = "uwwqerjcglxxweor"; // Nombre de usuario
            String password = "vWobxeLnCiH11WTJg6N"; // Contraseña

            // Intenta establecer la conexión
            miConexion = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Se conecto correctamente la BDD");        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se conecto correctamente la BDD"+e.toString());
        }
        return miConexion; // Retorna la conexión (puede ser nula si hubo un error)
    }
   
            

}
