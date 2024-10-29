/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas;

/**
 *
 * @author gabrielv170
 */
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import Modulo_Ventas.ConexionBDD;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JComboBox;
import  com.toedter.calendar.JDateChooser;
import com.mysql.cj.jdbc.CallableStatement;
import java.util.Date;

        
public class CrudDescuento {
    private int codigoID;
    private int porcentaje;
    private Date fecha_inicialidad;
    private Date fecha_finalidad;

    public int getCodigoID() {
        return codigoID;
    }

    public void setCodigoID(int codigoID) {
        this.codigoID = codigoID;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Date getFecha_inicialidad() {
        return fecha_inicialidad;
    }

    public void setFecha_inicialidad(Date fecha_inicialidad) {
        this.fecha_inicialidad = fecha_inicialidad;
    }

    public Date getFecha_finalidad() {
        return fecha_finalidad;
    }

    public void setFecha_finalidad(Date fecha_finalidad) {
        this.fecha_finalidad = fecha_finalidad;
    }
    
    public void AgregarDescuento(JTextField paramPorcentaje, JDateChooser paramFechaInicio, JDateChooser paramFechaFinal){
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "INSERT INTO Descuento(CantidadDescuento,Fecha_Inicio,Fecha_Final) VALUES(?,?,?);";
        try{
            CallableStatement cs = (CallableStatement) objetoConexion.Conectar().prepareCall(consulta);
            cs.setInt(1, Integer.parseInt(paramPorcentaje.getText()));
            
            Date fechaSeleccionada = paramFechaInicio.getDate();
            java.sql.Date fechaSQL = new java.sql.Date(fechaSeleccionada.getTime());
            cs.setDate(2, fechaSQL);
                    
            Date fechaSeleccionada2 = paramFechaFinal.getDate();
            java.sql.Date fechaSQL2 = new java.sql.Date(fechaSeleccionada2.getTime());
            cs.setDate(3, fechaSQL2);
            
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se guardó el descuento correctamente");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error, error: " + e.toString());
        }finally{
            objetoConexion.cerrarConexion();
        }
        
    }
    public void MostrarDescuentos(JTable tablaTotalDescuentos){
        
    }    
}
