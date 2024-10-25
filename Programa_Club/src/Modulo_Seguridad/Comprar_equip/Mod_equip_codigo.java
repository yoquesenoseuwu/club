/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Seguridad.Comprar_equip;
import Modulo_Seguridad.Conexion_Bdd_Seguridad;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

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
    
}
