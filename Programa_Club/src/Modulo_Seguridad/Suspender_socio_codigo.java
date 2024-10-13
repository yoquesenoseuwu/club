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
 * @author HP OMEN
 */
public class Suspender_socio_codigo {
    
    ArrayList<Integer> array = new ArrayList<Integer>();
    
    public Suspender_socio_codigo(){
        for (int i=0; i<10; i++){
            array.add(i);
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
