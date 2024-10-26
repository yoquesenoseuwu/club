/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Seguridad.Comprar_equip;
import Modulo_Seguridad.Conexion_Bdd_Seguridad;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author HP OMEN
 */
public class Mod_equip_codigo {
    
    Conexion_Bdd_Seguridad conexion = new Conexion_Bdd_Seguridad();
    
    public DefaultListModel Cargar_datos(DefaultListModel modelo){
        modelo.removeAllElements();
        ArrayList array_carga= conexion.Select_Equipo();
        for (int i=0; i<array_carga.size(); i++){
            modelo.addElement(array_carga.get(i));
        }
        return modelo;
    }
    
    public void Insert(String Nombre, int Precio, String Descripcion,String link){
        conexion.Insert_Tipo_equipamiento(Nombre, 0, Descripcion,link);
    }
    
    public void Delete(String itemSeleccionado){
        String[] separado=itemSeleccionado.split(" / ");
        JOptionPane.showMessageDialog(null, "Seleccionaste: " + separado);
        int id=Integer.parseInt(separado[0]);
        conexion.Delete_tipo_equipo(id);
        
    }
}
