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
import com.toedter.calendar.JDateChooser;
import com.mysql.cj.jdbc.CallableStatement;
import java.text.SimpleDateFormat;
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
        ConexionBDD objetoConexion = new ConexionBDD();
        DefaultTableModel modelo = new DefaultTableModel();
        String sql="";
        modelo.addColumn("id");
        modelo.addColumn("Porcentaje");
        modelo.addColumn("Fecha Inicio");
        modelo.addColumn("Fecha Final");
        
        tablaTotalDescuentos.setModel(modelo);
        
        sql="SELECT * FROM Descuento";
        
        try {
            Statement st= objetoConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                 String id = rs.getString("DescuentoID");
                 String porcentaje=rs.getString("CantidadDescuento");
                 
                 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
                 java.sql.Date fechaSQL = rs.getDate("Fecha_Inicio");
                 String nuevaFechaInicio = sdf.format(fechaSQL);
                 
                 SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyy");
                 java.sql.Date fechaSQL2 = rs.getDate("Fecha_Final");
                 String nuevaFechaFinal = sdf2.format(fechaSQL2);
                 
                 modelo.addRow(new Object[]{id,porcentaje,nuevaFechaInicio,nuevaFechaFinal});
            }
            tablaTotalDescuentos.setModel(modelo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al mostrar usuarios, error: " + e.toString());
        }finally{
            objetoConexion.cerrarConexion();
        }
        
        
        
    }
    
    public void SeleccionarDescuentos(JTable totalDescuentos, JTextField id, JTextField descuento, JDateChooser fechaInicio, JDateChooser fechaFinal){
          int fila = totalDescuentos.getSelectedRow();
          if(fila>=0){
              id.setText(totalDescuentos.getValueAt(fila,0).toString());
              descuento.setText(totalDescuentos.getValueAt(fila,1).toString());
              
              String fechaString = totalDescuentos.getValueAt(fila,2).toString();
              String fechaString2 = totalDescuentos.getValueAt(fila,3).toString();
              try{
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaDate = sdf.parse(fechaString);
                
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaDate2 = sdf2.parse(fechaString2);
                
                fechaInicio.setDate(fechaDate);
                fechaFinal.setDate(fechaDate2);
                
              }catch(Exception e){
                  JOptionPane.showMessageDialog(null,"Error al seleccionar, error: " + e.toString());
              }
          }
    }

    public void ModificarDescuento(JTextField paramid,JTextField paramPorcentaje, JDateChooser paramFechaInicio, JDateChooser paramFechaFinal){
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "UPDATE Descuento SET CantidadDescuento=?,Fecha_Inicio=?,Fecha_Final=? WHERE DescuentoID=?;";
        try{
            CallableStatement cs = (CallableStatement) objetoConexion.Conectar().prepareCall(consulta);
            cs.setString(1,paramPorcentaje.getText());
            
            Date fechaSeleccionada = paramFechaInicio.getDate();
            java.sql.Date fechaSQL = new java.sql.Date(fechaSeleccionada.getTime());
            cs.setDate(2, fechaSQL);
                    
            Date fechaSeleccionada2 = paramFechaFinal.getDate();
            java.sql.Date fechaSQL2 = new java.sql.Date(fechaSeleccionada2.getTime());
            cs.setDate(3, fechaSQL2);
            
            cs.setInt(4,Integer.parseInt(paramid.getText()));
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se modifico correctamente");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error, error: " + e.toString());
        }finally{
            objetoConexion.cerrarConexion();
        }
    }

    public void EliminarDescuento(JTextField id){
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta="DELETE FROM Descuento WHERE DescuentoID=?;";
        try{
            CallableStatement cs = (CallableStatement) objetoConexion.Conectar().prepareCall(consulta);
            cs.setInt(1,Integer.parseInt(id.getText()));
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se Eliminó correctamente");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar, error: " + e.toString());
        }finally{
            objetoConexion.cerrarConexion();
        }
    }
}
