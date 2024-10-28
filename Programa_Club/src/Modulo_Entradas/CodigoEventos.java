/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Entradas;

import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Agustín Salinas
 */
public class CodigoEventos {
    BDD.DBConexion conexion = new BDD.DBConexion();
    
    public void buscarEventos(JTable tablaEventos, JComboBox mes, String condicion){
        DefaultTableModel modelo = (DefaultTableModel) tablaEventos.getModel();
        
        try{
            String consulta = "SELECT E.idEvento,E.nombreEvento,E.tipoEvento,C.Fecha,C.Hora " +
                                "FROM Evento E INNER JOIN Calendario C ON C.idCalendario=E.idCalendario " +
                                "WHERE C.Fecha >= CURDATE() AND C.Fecha LIKE CONCAT('%/%',?,'/%') AND (E.tipoEvento = ?)";
            
            PreparedStatement ps = conexion.Conectar().prepareStatement(consulta);
            ps.setInt(1, mes.getSelectedIndex());
            ps.setString(2, condicion);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int idEvento= rs.getInt("idEvento");
                String nombreEvento= rs.getString("nombreEvento");
                String tipoEvento= rs.getString("tipoEvento");
                Date Fecha= rs.getDate("Fecha");
                Time Hora= rs.getTime("Hora");
                
                modelo.addRow(new Object[] {idEvento,nombreEvento,tipoEvento,Fecha,Hora});
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conusltar eventos: "+e.toString());
        }finally{
            conexion.Desconectar();
        }
        
        //desabilita jtable
        for (int col = 0; col<tablaEventos.getColumnCount();col++){
            Class <?> columna = tablaEventos.getColumnClass(col);
            tablaEventos.setDefaultEditor(columna,null);
        }
    }
    
    public void seleccionarEvento(JTable tablaEventos,JTextField evento,JTextArea descripcion){
        int index=tablaEventos.getSelectedRow();
        
        try{
            if(index>=0){
                
                String consulta = "SELECT nombreEvento,Descripcion FROM Evento WHERE idEvento=?";

                PreparedStatement ps = conexion.Conectar().prepareStatement(consulta);
                ps.setInt(1, (int)tablaEventos.getValueAt(index, 0));
                ResultSet rs = ps.executeQuery();
                evento.setText(rs.getString("nombreEvento"));
                descripcion.setText(rs.getString("Descripcion"));
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conusltar eventos: "+e.toString());
        }finally{
            conexion.Desconectar();
        }
    }
}
