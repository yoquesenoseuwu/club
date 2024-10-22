/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Seguridad.Ver_Equipar_Guardias;
import Modulo_Seguridad.Conexion_Bdd_Seguridad;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Ver_Guardias_Codigo {
        Conexion_Bdd_Seguridad conexion= new Conexion_Bdd_Seguridad();
    
    public Ver_Guardias_Codigo(){

    }

    
    public DefaultListModel mostrar(DefaultListModel modelo){
        modelo.removeAllElements();
        ArrayList array=conexion.Select_Guardias();
        for (int i=0; i<array.size(); i++){
            modelo.addElement(array.get(i));
        }
        return modelo;
        
    }
    public void Pantalla_Zona(int id){
        //Pantalla_Zona Pz = new Pantalla_Zona();
        //Pz.setVisible(true);
    }

}
