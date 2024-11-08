/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabrielv170
 */
public class CrudVentaProductos {
        
        public void MostrarProductos(JTable paramTablaProductos) {
        ConexionBDD objetoConexion = new ConexionBDD();
        DefaultTableModel modelo = new DefaultTableModel();
   
        String sql="";
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Categoría");
        modelo.addColumn("Estado");
        paramTablaProductos.setModel(modelo);
       
        sql="SELECT Productos.ProductoID,Productos.Nombre,Productos.Stock,Productos.Precio,"
                + "Categorias.NombreCategoria, Productos.Estado FROM Productos "
                + "INNER JOIN Categorias ON Productos.CategoriaID = Categorias.CategoriaID WHERE Productos.Estado = 1";

        try {
            Statement st;
            st = objetoConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("ProductoID");
                String nombres = rs.getString("Nombre");
                String stocks = rs.getString("Stock");
                String precios = rs.getString("Precio");
                String categoria = rs.getString("NombreCategoria");
                String estado = rs.getString("Estado");
                String estadoFinal;
                
                if(estado == "1"){
                    estadoFinal = "En Venta";
                }else{
                    estadoFinal = "No en venta";
                }
                modelo.addRow(new Object[]{id,nombres,precios,stocks,categoria,estadoFinal});
            }
            paramTablaProductos.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar correctamente los registros, error: " + e.getMessage());
        }finally{
            objetoConexion.cerrarConexion();
        }
    }

    public void MostrarProductosNoDisponibles(JTable tablaProductos){
        ConexionBDD objetoConexion = new ConexionBDD();
        DefaultTableModel modelo = new DefaultTableModel();
   
        String sql="";
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Precio");
        tablaProductos.setModel(modelo);
       
        sql="SELECT Productos.ProductoID,Productos.Nombre,Productos.Precio FROM Productos INNER JOIN Categorias ON Productos.CategoriaID = Categorias.CategoriaID WHERE Productos.Estado = 0;";

        try {
            Statement st;
            st = objetoConexion.Conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("ProductoID");
                String nombres = rs.getString("Nombre");
                String precios = rs.getString("Precio");
                modelo.addRow(new Object[]{id,nombres,precios});
            }
            tablaProductos.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar correctamente los registros, error: " + e.getMessage());
        }finally{
            objetoConexion.cerrarConexion();
        }
        }
}
