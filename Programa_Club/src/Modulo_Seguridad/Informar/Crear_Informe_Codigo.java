/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Seguridad.Informar;

import Modulo_Seguridad.Zonas_de_Seguridad.Pantalla_Zona;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import programa_club.Conexion_Bdd;

/**
 *
 * @author PC
 */
public class Crear_Informe_Codigo {
    Conexion_Bdd conexion= new Conexion_Bdd();
    
    public Crear_Informe_Codigo(){

    }

    
    public DefaultListModel mostrar(DefaultListModel modelo){
        modelo.removeAllElements();
        ArrayList array=conexion.Select_Zona_de_Seguridad();
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
