/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import Modulo_Ventas.ConexionBDD;
import javax.swing.JOptionPane;
import java.sql.*;

public class CrudCategoria {
    //Declaracion de variables a usar
    int codigo;
    String nombreCategoria;
    
    //GET y SET para los parametros
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    //Insertar
    //Declaracion de parametros
    public void InsertarCategoria(JTextField paramNombreCategoria){
        setNombreCategoria(paramNombreCategoria.getText());
        
        //Abrir Conexion
        ConexionBDD objetoConexion = new ConexionBDD();
        
        //Consulta SQL
        String consulta="insert into Categorias (NombreCategoria) values (?);";
        
        try{
            //Adquiere los parametros del JTextField
            CallableStatement cs= objetoConexion.Conectar().prepareCall(consulta);
            cs.setString(1, getNombreCategoria());
            //Executa la sentencia con los parametros
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se inserto correctamente la categoria");
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se inserto correctamente la categoria, error: "+e.toString());

        }
    }
    //Mostrar
    public void MostrarCategorias(JTable paramTablaTotalCategorias){
        ConexionBDD objetoConexion = new ConexionBDD();
        //Crear modelo de tabla para mostrar
        DefaultTableModel modelo=new DefaultTableModel();
        //Definir modelo de tabla para mostrar
        TableRowSorter<TableModel> OrdenarTabla= new TableRowSorter<TableModel>(modelo);
        paramTablaTotalCategorias.setRowSorter(OrdenarTabla);
        //Declaracion de parametros
        String sql="";
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        //Usar modelo con los parametros adquiridos
        paramTablaTotalCategorias.setModel(modelo);
        
        sql="select * from Categorias;";
        
        String[] datos = new String[3];
        Statement st;
        
        try{
            //Mostrar datos en la tabla
            st= objetoConexion.Conectar().createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                
                modelo.addRow(datos);
            }
            paramTablaTotalCategorias.setModel(modelo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo mostrar correctamente los registros, error:"+e.toString());
        }
    }
    //Seleccionar
    public void SeleccionarCategoria(JTable paramTablaCategorias, JTextField paramID, JTextField paramNombre){
        try{
            //Declarar parametros
            int fila= paramTablaCategorias.getSelectedRow();
            
            //Mostrar seleccion si existe una fila
            if(fila>=0){
                paramID.setText((paramTablaCategorias.getValueAt(fila, 0).toString()));
                paramNombre.setText((paramTablaCategorias.getValueAt(fila, 1).toString()));
            }
            else{
                JOptionPane.showMessageDialog(null, "Fila no encontrada");
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de seleccion, error:"+e.toString());
        }
    } 
    //Modificar
    public void ModificarCategoria(JTextField paramCodigo, JTextField paramNombre){
        //Declarar parametros
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setNombreCategoria(paramNombre.getText());
        ConexionBDD objetoConexion=new ConexionBDD();
        //Consulta SQL
        String consulta="UPDATE Categorias SET Categorias.NombreCategoria=? WHERE Categorias.CategoriaID=?";
        
        try{
            //Conectar BDD
            CallableStatement cs= objetoConexion.Conectar().prepareCall(consulta);
            //Ingresar parametros
            cs.setString(1, getNombreCategoria());
            cs.setInt(2, getCodigo());
            //Ejecutar
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Modificacion exitosa");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No se modificó"+ e.toString());

        }
    }
    
    //Eliminar
    public void EliminarCategoria(JTextField paramCodigo){
        //Declarar parametros
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        ConexionBDD objetoConexion= new ConexionBDD();
        //Consulta SQL
        String consulta="DELETE FROM Categorias WHERE Categorias.CategoriaID=?;";
        try{
            //Conectar BDD
            CallableStatement cs= objetoConexion.Conectar().prepareCall(consulta);
            //Adquirir parametros
            cs.setInt(1, getCodigo());
            //Ejecutar
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Se eliminó correctamente el registro");
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No se eliminó correctamente el registro, error:"+ e.toString())  ;
        }
    }
    public void LimpiarCampos(JTextField paramID, JTextField paramNombre) {
        paramID.setText("");
        paramNombre.setText("");
        
    }
}