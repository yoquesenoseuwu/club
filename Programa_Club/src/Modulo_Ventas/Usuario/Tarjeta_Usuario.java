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
import java.time.LocalDate;
/**
 *
 * @author gabrielv170
 */
public class Tarjeta_Usuario {
    
    public boolean AnalizarEmpresa(JTextField numeroTarjeta) {
        String tarjeta = numeroTarjeta.getText();

        if (tarjeta.length() == 16) {
            if (AnalizarValidez(tarjeta)) {
                if (tarjeta.startsWith("4")) {
                    JOptionPane.showMessageDialog(null, "La tarjeta es válida y es de Visa.");
                    return true;
                }
                else if (tarjeta.startsWith("51") || tarjeta.startsWith("52") || tarjeta.startsWith("53") || 
                         tarjeta.startsWith("54") || tarjeta.startsWith("55") || 
                         (Integer.parseInt(tarjeta.substring(0, 4)) >= 2221 && Integer.parseInt(tarjeta.substring(0, 4)) <= 2720)) {
                    JOptionPane.showMessageDialog(null, "La tarjeta es válida y es de MasterCard.");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "La tarjeta es válida, pero no es ni Visa ni MasterCard.");
                    return true;
                }
            } else {
                JOptionPane.showMessageDialog(null, "La tarjeta no es válida.");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "La tarjeta debe tener entre 16 dígitos.");
            return false;
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

    public boolean VerificarVencimiento(JTextField mes, JTextField anio) {
        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();
        int anioActual = fechaActual.getYear() % 100;

        int mesUsuario = Integer.parseInt(mes.getText());
        int anioUsuario = Integer.parseInt(anio.getText());
        
        System.out.println("Fecha actual: " + mesActual + "/" + anioActual);
        System.out.println("Fecha Tarjeta: " + mesUsuario + "/" + anioUsuario);

        if (anioUsuario < anioActual) {
            JOptionPane.showMessageDialog(null, "La tarjeta ya venció.");
            return false;
        } else if (anioUsuario == anioActual) {
            if (mesUsuario < mesActual) {
                JOptionPane.showMessageDialog(null, "La tarjeta ya venció.");
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

}


