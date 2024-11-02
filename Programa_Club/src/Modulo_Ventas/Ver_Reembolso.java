package Modulo_Ventas;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.sql.*;

public class Ver_Reembolso {
    private Date fecha;
    private double monto;
    private String motivo;
    private int Estado;

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
    private int IDPedido;
    private int codigo;

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
    String[] datos = new String[5]; // Ajustar el tamaño

    try {
        Statement st = objetoConexion.Conectar().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            datos[0] = rs.getString("IDReembolso"); // Cambia el nombre de columna según tu base de datos
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
    }finally{
            objetoConexion.cerrarConexion();
        }
}


    // Seleccionar
    public void SeleccionarReembolso(JTable paramTablaReembolso, JTextField paramID) {
        try {
            int fila = paramTablaReembolso.getSelectedRow();
            if (fila >= 0) {
                paramID.setText(paramTablaReembolso.getValueAt(fila, 0).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no encontrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de seleccion, error:" + e.toString());
        }
    }
}
