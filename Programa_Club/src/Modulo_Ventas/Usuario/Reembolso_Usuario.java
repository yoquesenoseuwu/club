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
    public void InsertarMotivo(JTextField paramMotivo){
        setMotivo(paramMotivo.getText());
        
        //Abrir Conexion
        ConexionBDD objetoConexion = new ConexionBDD();
        
        //Consulta SQL
        String consulta="insert into Pedido (Motivo) values (?);";
        
        try{
            //Adquiere los parametros del JTextField
            CallableStatement cs= objetoConexion.Conectar().prepareCall(consulta);
            cs.setString(1, getMotivo());
            //Executa la sentencia con los parametros
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se confirmo el reembolso");
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se confirmo correctamente el reembolso, error: "+e.toString());
        }
        finally{
            objetoConexion.cerrarConexion();
        }
    }
    
    // Método para mostrar los reembolsos en la tabla
    public void MostrarProductos(JTable paramTablaProductos) {
        ConexionBDD objetoConexion = new ConexionBDD();
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<>(modelo);
        paramTablaProductos.setRowSorter(ordenarTabla);

        // Agregar las columnas
        modelo.addColumn("ProductoID"); // Esta columna se va a ocultar
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Categoria");

        paramTablaProductos.setModel(modelo);

        // Consulta SQL para obtener información de Producto
        String sql = "SELECT Productos.ProductoID, Productos.Nombre, Productos.Precio" +
             "Categorias.NombreCategoria FROM Productos " +
             "INNER JOIN Categorias ON Productos.CategoriaID = Categorias.CategoriaID " +
             "INNER JOIN Pedido ON Productos.CategoriaID = Categorias.CategoriaID " +// Añadir espacio aquí
             "WHERE Productos.Estado = 1";


        String[] datos = new String[5];

        try {
            Statement st = objetoConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("ProductoID");
                datos[1] = rs.getString("Nombre");
                datos[3] = rs.getString("Precio");
                datos[4] = rs.getString("NombreCategoria");

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

    public void SeleccionarProducto(JTable paramTablaProductos, JTextField paramID, JTextField paramNombreProducto, JTextField paramPrecioProducto, JTextField paramCategoria) {
    try {
        int fila = paramTablaProductos.getSelectedRow();

        // Verificar que haya una fila seleccionada
        if (fila >= 0) {
            // Almacenar el ProductoID en el JTextField (columna 0)
            paramID.setText(paramTablaProductos.getValueAt(fila, 0).toString()); // ProductoID
            
            // Almacenar otros datos en los JTextFields correspondientes
            paramNombreProducto.setText(paramTablaProductos.getValueAt(fila, 1).toString()); // Nombre
            paramPrecioProducto.setText(paramTablaProductos.getValueAt(fila, 2).toString()); // Precio
            paramCategoria.setText(paramTablaProductos.getValueAt(fila, 3).toString()); // NombreCategoria
            
            // Actualiza el productoID en una variable (por ejemplo, una variable de clase)
            productoID = paramTablaProductos.getValueAt(fila, 0).toString(); // Asegúrate de que esta línea esté presente
        } else {
            JOptionPane.showMessageDialog(null, "Fila no encontrada.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.getMessage());
    }
}
    
}
