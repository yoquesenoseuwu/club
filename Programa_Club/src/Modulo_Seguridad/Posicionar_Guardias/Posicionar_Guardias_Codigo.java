/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Seguridad.Posicionar_Guardias;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import Modulo_Seguridad.Conexion_Bdd_Seguridad;
/**
 *
 * @author PC
 */
public class Posicionar_Guardias_Codigo {
    Conexion_Bdd_Seguridad conexion= new Conexion_Bdd_Seguridad();
    public Posicionar_Guardias_Codigo (){
        
    }
    
    public DefaultListModel mostrar(DefaultListModel modelo){
        modelo.removeAllElements();
        ArrayList array=conexion.Select_Zona_de_Seguridad();
        System.out.println(array);
        
        for (int i=0; i<array.size(); i++){
            modelo.addElement(array.get(i));
        }
        return modelo;
        
    }
    public void Pantalla_Zona_Guardias(int id){
        Pantalla_Zona_Guardias Pz = new Pantalla_Zona_Guardias();
        Pz.mostrarZona(id);
        Pz.setVisible(true);
    }
    
    public DefaultListModel mostrar_Guardias(DefaultListModel modelo){
        modelo.removeAllElements();
        ArrayList array=conexion.Select_Guardias();
        System.out.println(array);
        
        for (int i=0; i<array.size(); i++){
            modelo.addElement(array.get(i));
        }
        return modelo;
        
    }
}
