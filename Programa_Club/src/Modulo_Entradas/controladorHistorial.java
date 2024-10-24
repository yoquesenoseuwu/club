/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Entradas;
import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Agustín Salinas
 */
public class controladorHistorial {
    public void verHistorial(JTable tablaCompras,JLabel totalCompras){
        BDD.DBConexion conexion = new BDD.DBConexion();
        
        /*DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("NroDeCompra");
        modelo.addColumn("Fecha");
        modelo.addColumn("Medio");
        modelo.addColumn("Evento");
        modelo.addColumn("Sector");
        modelo.addColumn("Fila");
        modelo.addColumn("Asiento");
        modelo.addColumn("Costo");*/
        DefaultTableModel modelo = (DefaultTableModel) tablaCompras.getModel();
        
        try{
            int compras = 0;
            String consulta = "SELECT C.CompraID,C.Fecha,T.Tipo,E.nombreEvento,S.NombreSector,C.filaAsiento,C.Asiento,C.Coste " +
                                "FROM Compra C INNER JOIN Tarjeta T ON C.TarjetaID=T.TarjetaID " +
                                "INNER JOIN Evento E ON C.IdEvento=E.idEvento " +
                                "INNER JOIN Sector S ON C.IdSector=S.idSector WHERE C.CompraID=?;";
            
            PreparedStatement ps = conexion.Conectar().prepareStatement(consulta);
            ps.setInt(0, 1);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int CompraID= rs.getInt("CompraID");
                Date Fecha= rs.getDate("Fecha");
                String Tipo= rs.getString("Tipo");
                String nombreEvento= rs.getString("nombreEvento");
                String NombreSector= rs.getString("NombreSector");
                int filaAsiento= rs.getInt("filaAsiento");
                int Asiento= rs.getInt("Asiento");
                double Coste= rs.getDouble("Coste");
                compras+=1;
                
                modelo.addRow(new Object[] {CompraID,Fecha,Tipo,nombreEvento,NombreSector,filaAsiento,Asiento,Coste});
            }
            totalCompras.setText(String.valueOf(compras));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conusltar compras: "+e.toString());
        }finally{
            conexion.Desconectar();
        }
    }
            
    public void comprasFecha(JDateChooser desde,JDateChooser hasta,JTable tablaCompras,JLabel totalCompras){
        BDD.DBConexion conexion = new BDD.DBConexion();
        
        /*DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("NroDeCompra");
        modelo.addColumn("Fecha");
        modelo.addColumn("Medio");
        modelo.addColumn("Evento");
        modelo.addColumn("Sector");
        modelo.addColumn("Fila");
        modelo.addColumn("Asiento");
        modelo.addColumn("Coste");*/
        DefaultTableModel modelo = (DefaultTableModel) tablaCompras.getModel();
        
        
        try{
            int compras = 0;
            String consulta = "SELECT C.CompraID,C.Fecha,T.Tipo,E.nombreEvento,S.NombreSector,C.filaAsiento,C.Asiento,C.Coste " +
                                "FROM Compra C INNER JOIN Tarjeta T ON C.TarjetaID=T.TarjetaID " +
                                "INNER JOIN Evento E ON C.IdEvento=E.idEvento " +
                                "INNER JOIN Sector S ON C.IdSector=S.idSector WHERE C.CompraID=? AND C.Fecha BETWEEN ? AND ?;";
            PreparedStatement ps = conexion.Conectar().prepareStatement(consulta);
            java.util.Date fechaDesde = desde.getDate();
            java.util.Date fechaHasta = hasta.getDate();
            java.sql.Date desdeSQL = new java.sql.Date(fechaDesde.getTime());
            java.sql.Date hastaSQL = new java.sql.Date(fechaHasta.getTime());
            
            ps.setInt(0, 1);
            ps.setDate(1,desdeSQL);
            ps.setDate(2,hastaSQL);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int CompraID= rs.getInt("CompraID");
                Date Fecha= rs.getDate("Fecha");
                String Tipo= rs.getString("Tipo");
                String nombreEvento= rs.getString("nombreEvento");
                String NombreSector= rs.getString("NombreSector");
                int filaAsiento= rs.getInt("filaAsiento");
                int Asiento= rs.getInt("Asiento");
                double Coste= rs.getDouble("Coste");
                compras+=1;
                
                modelo.addRow(new Object[] {CompraID,Fecha,Tipo,nombreEvento,NombreSector,filaAsiento,Asiento,Coste});
            }
            totalCompras.setText(String.valueOf(compras));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conusltar compras: "+e.toString());
        }finally{
            conexion.Desconectar();
        }
    }
}
