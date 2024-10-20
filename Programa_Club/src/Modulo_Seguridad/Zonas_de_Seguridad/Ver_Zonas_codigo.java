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
        private String Nom;
    
    public Ver_Zonas_codigo(){

    }

    
    public DefaultListModel mostrar(DefaultListModel modelo){
        modelo.removeAllElements();
        ArrayList array=conexion.Select_Zona_de_Seguridad_nombre();
        System.out.println(array);
        
        for (int i=0; i<array.size(); i++){
            modelo.addElement(array.get(i));
        }
        return modelo;
        
    }
    public void Pantalla_Zona(int id){
        Pantalla_Zona Pz = new Pantalla_Zona();
        Pz.setVisible(true);
    }
}
