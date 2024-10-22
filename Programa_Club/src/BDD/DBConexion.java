/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Agustín Salinas
 */
public class DBConexion {
    Connection conexion = null; // Inicializa la conexión como nula
    
    public Connection Conectar() {
        try {
            // Asegúrate de que la URL esté correctamente formateada
            String url = "jdbc:mysql://bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb";
            String user = "uwwqerjcglxxweor"; // Nombre de usuario
            String password = "vWobxeLnCiH11WTJg6N"; // Contraseña

            // Intenta establecer la conexión
            conexion = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Se conecto correctamente la BDD");   
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se conecto correctamente la BDD: "+e.toString());
        }
        return conexion; // Retorna la conexión (puede ser nula si hubo un error)
    }
    
    public void Desconectar(){
        try{
            if(conexion != null && !conexion.isClosed()){
                conexion.close();
                JOptionPane.showMessageDialog(null, "Se desconecto correctamente la BDD");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
}
