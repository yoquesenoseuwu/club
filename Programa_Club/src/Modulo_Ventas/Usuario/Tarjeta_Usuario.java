/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas.Usuario;
import Modulo_Ventas.ConexionBDD;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author gabrielv170
 */
public class Tarjeta_Usuario {
    
    public void AnalizarEmpresa(JTextField numeroTarjeta) {
    String tarjeta = numeroTarjeta.getText();

    // Verifica si la tarjeta tiene entre 13 y 19 dígitos
    if (tarjeta.length() >= 13 && tarjeta.length() <= 19) {
        // Primero validamos si la tarjeta es válida usando el algoritmo de Luhn
        if (AnalizarValidez(tarjeta)) {
            // Después verificamos si es Visa o MasterCard

            // Verificación para Visa (comienza con 4)
            if (tarjeta.startsWith("4")) {
                JOptionPane.showMessageDialog(null, "La tarjeta es válida y es de Visa.");
            }
            // Verificación para MasterCard:
            // - Tradicional (51-55) o desde (2221-2720)
            else if (tarjeta.startsWith("51") || tarjeta.startsWith("52") || tarjeta.startsWith("53") || 
                     tarjeta.startsWith("54") || tarjeta.startsWith("55") || 
                     (Integer.parseInt(tarjeta.substring(0, 4)) >= 2221 && Integer.parseInt(tarjeta.substring(0, 4)) <= 2720)) {
                JOptionPane.showMessageDialog(null, "La tarjeta es válida y es de MasterCard.");
            } else {
                // Si no es ni Visa ni MasterCard
                JOptionPane.showMessageDialog(null, "La tarjeta es válida, pero no es ni Visa ni MasterCard.");
            }
        } else {
            // Si no es válida según el algoritmo de Luhn
            JOptionPane.showMessageDialog(null, "La tarjeta no es válida.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "La tarjeta debe tener entre 13 y 19 dígitos.");
    }
}

    public boolean AnalizarValidez(String tarjeta) {
    int suma = 0;
    boolean esSegundoDigito = false;

    // Recorre el número de la tarjeta de derecha a izquierda
    for (int i = tarjeta.length() - 1; i >= 0; i--) {
        int digito = Character.getNumericValue(tarjeta.charAt(i));

        if (esSegundoDigito) {
            digito *= 2;  // Multiplica por 2 en posiciones pares (contando desde 1 desde la derecha)
            if (digito > 9) {
                digito -= 9;  // Si el resultado es mayor que 9, resta 9
            }
        }

        suma += digito;
        esSegundoDigito = !esSegundoDigito;  // Cambia el estado para alternar entre los dígitos
    }

    // El número es válido si la suma es un múltiplo de 10
    return suma % 10 == 0;
    }
}


