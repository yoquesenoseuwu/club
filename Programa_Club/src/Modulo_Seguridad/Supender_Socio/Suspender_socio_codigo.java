/*
arrar= Es un array/vector con la info de los socios,
 */
package Modulo_Seguridad.Supender_Socio;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import Modulo_Seguridad.Conexion_Bdd_Seguridad;
import javax.swing.*;

public class Suspender_socio_codigo {
    //Crea la conexion con la bdd
    Conexion_Bdd_Seguridad conexion= new Conexion_Bdd_Seguridad();

    public Suspender_socio_codigo(){
    
       
    }

    
    public DefaultListModel mostrar(DefaultListModel modelo){
        //Agrega los datos al modelo
        modelo.removeAllElements();
        ArrayList array=conexion.Select_socios();
        
        for (int i=0; i<array.size(); i++){
            modelo.addElement(array.get(i));
        }
        return modelo;
    }
    
    public void Pantalla_socio(int id){
        //Crea la pantalla de socio
        Pantalla_socio Ps;
        Ps = new Pantalla_socio();
        Ps.agregar_socio(id);
        Ps.setVisible(true);
    }
    
}
 
