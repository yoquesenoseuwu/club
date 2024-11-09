/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Seguridad.Zonas_de_Seguridad;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import Modulo_Seguridad.Conexion_Bdd_Seguridad;

/**
 *
 * @author PC
 */
public class Ver_Zonas_codigo {
    Conexion_Bdd_Seguridad conexion= new Conexion_Bdd_Seguridad();
    
    public Ver_Zonas_codigo(){

    }

    
    public DefaultListModel mostrar(DefaultListModel modelo){//Mete todas las zonas de seguridad en una lista para mostrarla en otra pantalla
        modelo.removeAllElements();
        ArrayList array=conexion.Select_Zona_de_Seguridad();
        
        for (int i=0; i<array.size(); i++){
            modelo.addElement(array.get(i));
        }
        return modelo;
        
    }
    public void Pantalla_Zona(int id){//abre una pantalla en particular
        Pantalla_Zona Pz = new Pantalla_Zona();
        Pz.mostrarZona(id);
        Pz.setVisible(true);
        Pz.setSize(700,430);
        Pz.setLocationRelativeTo(null);
    }
    public void Modificar_Zona(int id){//abre la pantalla de modificar zona
        Modificar_Zona mZ = new Modificar_Zona();
        mZ.mostrarId(id);
        mZ.setVisible(true);
        mZ.setSize(600, 430);
        mZ.setLocationRelativeTo(null);
    }
}
