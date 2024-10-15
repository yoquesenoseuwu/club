/*
arrar= Es un array/vector con la info de los socios,
 */
package Modulo_Seguridad;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class Suspender_socio_codigo {
    
    ArrayList<String> array = new ArrayList<String>();
    
    public Suspender_socio_codigo(){
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
