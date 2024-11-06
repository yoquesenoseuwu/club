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
        
        for (int i=0; i<array.size(); i++){
            modelo.addElement(array.get(i));
        }
        return modelo;
        
    }
    public void Pantalla_Zona_Guardias(int id){
        
        
        ArrayList array=conexion.Select_unique_zona(id);
        int id_Zona=id;
        String Id=(String) array.get(0);
        String Nombre=(String) array.get(1);
        String Tamaño=(String) array.get(2);        
        String Descripcion=(String) array.get(3);
        Pantalla_Zona_Guardias Pz = new Pantalla_Zona_Guardias();
        Pz.ID_ZONA_GET(id);
        Pz.setVisible(true);
        Pz.mostrarZona(Id, Nombre, Tamaño, Descripcion, id_Zona);
    }
    
    public DefaultListModel mostrar_Guardias(DefaultListModel modelo){
        modelo.removeAllElements();
        ArrayList array=conexion.Select_Guardias_Disponibles();
        
        for (int i=0; i<array.size(); i++){
            modelo.addElement(array.get(i));
        }
        return modelo;
        
    }
    public DefaultListModel mostrar_Guardias_Zona(DefaultListModel modelo, int id){
        modelo.removeAllElements();
        ArrayList array=conexion.Select_Z_Guardias(id);
        
        for (int i=0; i<array.size(); i++){
            modelo.addElement(array.get(i));
        }
        return modelo;
        
    }
    
    public void Asignar_Guardia_C(int id){
        Asignar_Guardia aG=new Asignar_Guardia();
        aG.setVisible(true);
        aG.setLocationRelativeTo(null);
        aG.ID_ZONA_GET(id);
        aG.setSize(500,500);
    }
    
    public void Pantalla_Zona_Guardia_info(int id, int id_zona, String nombre){
        
        
        int id_Guardia=id;
        String Id= id_zona+"";
        Pantalla_Guardia pZg = new Pantalla_Guardia();
        pZg.setVisible(true);
        pZg.mostrarZona(Id, nombre, id_Guardia);
    }
    
}