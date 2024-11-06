/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas.Usuario;

import Modulo_Ventas.ConexionBDD;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;

/**
 *
 * @author tm_galli
 */
public class Reembolso_Usuario {

    private Date fecha;
    private String Nombre_Producto;
    private String Motivo;
    private double Precio;
    private int CategoriaID;
    private int IDPedido;
    private int codigo;
    private String productoID;
    private int IDPedidoSeleccionado;

    public int getIDPedidoSeleccionado() {
        return IDPedidoSeleccionado;
    }

    public void setIDPedidoSeleccionado(int IDPedidoSeleccionado) {
        this.IDPedidoSeleccionado = IDPedidoSeleccionado;
    }
    
    
    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }
    
    public String getNombre_Producto() {
        return Nombre_Producto;
    }

    public void setNombre_Producto(String Nombre_Producto) {
        this.Nombre_Producto = Nombre_Producto;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getCategoriaID() {
        return CategoriaID;
    }

    public void setCategoriaID(int CategoriaID) {
        this.CategoriaID = CategoriaID;
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

    public int getIDPedido() {
        return IDPedido;
    }

    public void setIDPedido(int IDPedido) {
        this.IDPedido = IDPedido;
    }
    public void InsertarMotivo(JTextField paramMotivo, JDateChooser paramFecha) {
    setMotivo(paramMotivo.getText());
    java.util.Date fecha = paramFecha.getDate();
    
    if (fecha == null) {
        JOptionPane.showMessageDialog(null, "Por favor, seleccione una fecha.");
        return;
    }
    
    ConexionBDD objetoConexion = new ConexionBDD();
    
    String consulta = "INSERT INTO Reembolso (IDPedido, Motivo, Fecha, Estado) values (?, ?, ?, 0);";
    
    try {
        CallableStatement cs = objetoConexion.Conectar().prepareCall(consulta);
        cs.setInt(1, getIDPedidoSeleccionado());
        cs.setString(2, getMotivo());
        
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        cs.setDate(3, fechaSQL);
        
        cs.execute();
        JOptionPane.showMessageDialog(null, "Se confirmó el reembolso");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "No se confirmó correctamente el reembolso, error: " + e.toString());
    } finally {
        objetoConexion.cerrarConexion();
    }
}


    
    // Método para mostrar los reembolsos en la tabla
public void MostrarProductos(JTable paramTablaProductos, String usuarioID) {
    ConexionBDD objetoConexion = new ConexionBDD();
    DefaultTableModel modelo = new DefaultTableModel();
    TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<>(modelo);
    paramTablaProductos.setRowSorter(ordenarTabla);

    // Agregar las columnas
    modelo.addColumn("ProductoID"); // Esta columna se va a ocultar
    modelo.addColumn("Nombre");
    modelo.addColumn("Precio");
    modelo.addColumn("Categoria");
    modelo.addColumn("Cantidad"); // Agregar columna de cantidad

    paramTablaProductos.setModel(modelo);

    // Consulta SQL para obtener información de Producto y Pedido
    String sql = "SELECT Productos.ProductoID, Productos.Nombre, Productos.Precio, " +
                 "Categorias.NombreCategoria, DetallePedido.Cantidad " +
                 "FROM Pedido " +
                 "INNER JOIN DetallePedido ON Pedido.PedidoID = DetallePedido.PedidoID " +
                 "INNER JOIN Productos ON DetallePedido.ProductoID = Productos.ProductoID " +
                 "INNER JOIN Categorias ON Productos.CategoriaID = Categorias.CategoriaID " +
                 "WHERE Pedido.IDUsuario = ?;";

    try (PreparedStatement ps = objetoConexion.Conectar().prepareStatement(sql)) {
        ps.setString(1, usuarioID); // Asigna el usuarioID al marcador "?"
        ResultSet rs = ps.executeQuery();

        // Recorrer resultados y agregar a la tabla
        while (rs.next()) {
            String[] datos = new String[5];
            datos[0] = rs.getString("ProductoID");
            datos[1] = rs.getString("Nombre");
            datos[2] = rs.getString("Precio");
            datos[3] = rs.getString("NombreCategoria");
            datos[4] = rs.getString("Cantidad");
            modelo.addRow(datos);
        }

        // Ocultar la columna ProductoID
        paramTablaProductos.getColumnModel().getColumn(0).setMinWidth(0);
        paramTablaProductos.getColumnModel().getColumn(0).setMaxWidth(0);
        paramTablaProductos.getColumnModel().getColumn(0).setWidth(0);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "No se pudo mostrar correctamente los registros, error: " + e.toString());
    } finally {
        objetoConexion.cerrarConexion();
    }
}


    public void SeleccionarProducto(JTable paramTablaProductos, JTextField paramID, JTextField paramNombreProducto, JTextField paramPrecioProducto, JTextField paramCategoria, JTextField paramCantidad) {
    try {
        int fila = paramTablaProductos.getSelectedRow();

        // Verificar que haya una fila seleccionada
        if (fila >= 0) {
            setIDPedidoSeleccionado(Integer.parseInt(paramTablaProductos.getValueAt(fila, 0).toString()));
            paramID.setText(paramTablaProductos.getValueAt(fila, 0).toString());
            paramNombreProducto.setText(paramTablaProductos.getValueAt(fila, 1).toString());
            paramPrecioProducto.setText(paramTablaProductos.getValueAt(fila, 2).toString());
            paramCategoria.setText(paramTablaProductos.getValueAt(fila, 3).toString());
            paramCantidad.setText(paramTablaProductos.getValueAt(fila, 4).toString());
            productoID = paramTablaProductos.getValueAt(fila, 0).toString();
        } else {
            JOptionPane.showMessageDialog(null, "Fila no encontrada.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.getMessage());
    }
}
    
}
