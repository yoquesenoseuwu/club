/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_GestionDeFinanzas;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Usuario
 */
public class MostrarTabla {
        public void MostrarTabla(JTable paramTabla, Object[] Columnas, String sql) {
        ConexionBDD objetoConexion = new ConexionBDD();
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
        paramTabla.setRowSorter(OrdenarTabla);

        for (Object columna : Columnas) {
            modelo.addColumn(columna.toString());
        }
        
        //String sql = "SELECT * FROM Reembolso_Pedido;";
        String[] datos = new String[Columnas.length];
        
        

        try {
            Statement st = objetoConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            int columnaslen = Columnas.length;
            
            while (rs.next()) {
                for (int i = 0; i < columnaslen; i++) {
                 System.out.print("pepe");
                 System.out.print(rs.getString(Columnas[i].toString()));
                 datos[i] = rs.getString(Columnas[i].toString());
                 
                 
                }

                modelo.addRow(datos);
            }
            paramTabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar correctamente los registros, error:" + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }
    
}
