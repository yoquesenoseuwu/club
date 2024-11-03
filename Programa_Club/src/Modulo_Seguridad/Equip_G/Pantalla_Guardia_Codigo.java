/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modulo_Seguridad.Equip_G;

import Modulo_Seguridad.Conexion_Bdd_Seguridad;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author HP OMEN
 */
public class Pantalla_Guardia_Codigo {
    Conexion_Bdd_Seguridad conexion= new Conexion_Bdd_Seguridad();
    
    Pantalla_Guardia_Codigo(){
        
    }
    public DefaultListModel mostrar(DefaultListModel modelo){
        //Le da datos al modelo
        modelo.removeAllElements();
        ArrayList array=conexion.Select_Guardias_sin_estatal();
        for (int i=0; i<array.size(); i++){
                modelo.addElement(array.get(i));
        }
        return modelo;
        
    }
    public void Pantalla_Guardi(int id){
        Pantalla_G_Unique pGu=new Pantalla_G_Unique();
        pGu.setVisible(true);
        pGu.setLocationRelativeTo(null);
        pGu.setSize(700,700);
        pGu.Cargar_Datos(id);
        
    }
}
