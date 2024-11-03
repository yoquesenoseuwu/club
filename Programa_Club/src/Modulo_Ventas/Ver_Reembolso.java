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
    public void ModificarEstadoReembolso(JTextField paramID) {
        setCodigo(Integer.parseInt(paramID.getText()));
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "UPDATE Reembolso_Pedido SET Estado = ? WHERE IDReembolso = ?";

        // Obtener el estado actual para alternarlo
        int nuevoEstado = (obtenerEstadoActual(getCodigo()) == 0) ? 1 : 0;

        try {
            PreparedStatement ps = objetoConexion.Conectar().prepareStatement(consulta);
            ps.setInt(1, nuevoEstado); // Nuevo estado (0 o 1)
            ps.setInt(2, getCodigo()); // ID del reembolso a modificar
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Estado modificado exitosamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el estado: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }

    // Método auxiliar para obtener el estado actual del reembolso
    private int obtenerEstadoActual(int reembolsoID) {
        ConexionBDD objetoConexion = new ConexionBDD();
        String consulta = "SELECT Estado FROM Reembolso_Pedido WHERE IDReembolso = ?";
        int estadoActual = 0;

        try {
            PreparedStatement ps = objetoConexion.Conectar().prepareStatement(consulta);
            ps.setInt(1, reembolsoID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                estadoActual = rs.getInt("Estado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar el estado actual: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }

        return estadoActual;
    }
}
