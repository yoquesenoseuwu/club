/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloUsuarios;

/**
 *
 * @author tm_galli
 */
public class Main {
    public static void main(String[] args){
        DatabaseConnection.testConnection();
        Inicio pantalla1 = new Inicio();
        pantalla1.setVisible(true);
        pantalla1.setLocationRelativeTo(null);
    }
}
