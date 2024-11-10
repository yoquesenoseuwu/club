/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas;

/**
 *
 * @author thiag
 */
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.sql.*;

public class Ver_Pedido {
    private Date fecha;
    private double monto;
    private String motivo;
    private int Estado;
    private int IDPedido;
    private int codigo;

    // Getters y setters

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getIDPedido() {
        return IDPedido;
    }

    public void setIDPedido(int IDPedido) {
        this.IDPedido = IDPedido;
    }

    // Método para mostrar los reembolsos en la tabla
    public void MostrarReembolsos(JTable paramTablaTotalReembolso) {
        ConexionBDD objetoConexion = new ConexionBDD();
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
        paramTablaTotalReembolso.setRowSorter(OrdenarTabla);

        modelo.addColumn("IDReembolso");
        modelo.addColumn("IDPedido");
        modelo.addColumn("FechaReembolso");
        modelo.addColumn("Motivo");
        modelo.addColumn("Estado");

        paramTablaTotalReembolso.setModel(modelo);
        
        String sql = "SELECT * FROM Reembolso_Pedido;";
        String[] datos = new String[5];

        try {
            Statement st = objetoConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("IDReembolso");
                datos[1] = rs.getString("IDPedido");
                datos[2] = rs.getString("FechaReembolso");
                datos[3] = rs.getString("Motivo");
                
                // Convertir el estado en texto legible
                int estado = rs.getInt("Estado");
                datos[4] = (estado == 0) ? "No reembolsado" : "Reembolsado";

                modelo.addRow(datos);
            }
            paramTablaTotalReembolso.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar correctamente los registros, error:" + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

    // Método para seleccionar el reembolso y obtener su ID
    public void SeleccionarReembolso(JTable paramTablaReembolso, JTextField paramID) {
        try {
            int fila = paramTablaReembolso.getSelectedRow();
            if (fila >= 0) {
                paramID.setText(paramTablaReembolso.getValueAt(fila, 0).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no encontrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error:" + e.toString());
        }
    }

    // Método para alternar el estado de reembolso
    public void EliminarReembolso(JTextField paramID){
        //Declarar parametros
        setCodigo(Integer.parseInt(paramID.getText()));
        ConexionBDD objetoConexion= new ConexionBDD();
        //Consulta SQL
        String consulta="DELETE FROM Reembolso_Pedido WHERE IDReembolso=?;";
        try{
            //Conectar BDD
            CallableStatement cs= objetoConexion.Conectar().prepareCall(consulta);
            //Adquirir parametros
            cs.setInt(1, getCodigo());
            //Ejecutar
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se eliminó correctamente el reembolso");
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se eliminó correctamente el registro, error:"+ e.toString())  ;
        }finally{
            objetoConexion.cerrarConexion();
        }
    }
}