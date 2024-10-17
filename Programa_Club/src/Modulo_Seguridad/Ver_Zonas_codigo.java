/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Seguridad;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author PC
 */
public class Ver_Zonas_codigo {
        ArrayList<String> array = new ArrayList<String>();
    
    public Ver_Zonas_codigo(){
        for (int i=0; i<10; i++){
            array.add(""+i);
        }
    }

    
    public DefaultListModel mostrar(DefaultListModel modelo){
        modelo.removeAllElements();
        for (int i=0; i<array.size(); i++){
            modelo.addElement(array.get(i));
        }
        return modelo;
        
    }
}
