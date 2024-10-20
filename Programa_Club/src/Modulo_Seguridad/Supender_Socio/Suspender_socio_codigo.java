/*
arrar= Es un array/vector con la info de los socios,
 */
package Modulo_Seguridad.Supender_Socio;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import programa_club.Conexion_Bdd;
import javax.swing.*;

public class Suspender_socio_codigo {
    Conexion_Bdd conexion= new Conexion_Bdd();
    
    
    
    public Suspender_socio_codigo(){
    
       
    }

    
    public DefaultListModel mostrar(DefaultListModel modelo){
        modelo.removeAllElements();
        ArrayList array=conexion.Select_socios();
        
        for (int i=0; i<array.size(); i++){
            modelo.addElement(array.get(i));
        }
        return modelo;
    }
    
    public void Pantalla_socio(int id){
        Pantalla_socio Ps = new Pantalla_socio();
        Ps.agregar_socio(id);
        Ps.setVisible(true);
    }
    
}
 
