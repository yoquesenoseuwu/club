/*
arrar= Es un array/vector con la info de los socios,
 */
package Modulo_Seguridad;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import programa_club.Conexion_Bdd;

public class Suspender_socio_codigo {
    Conexion_Bdd conexion= new Conexion_Bdd();

    
    ArrayList<String> array = new ArrayList<String>();
    
    public Suspender_socio_codigo(){
    try{
    ResultSet result=conexion.Select("Socio");
    result.last();  // Mover el cursor al final
    int tamano = result.getRow();  // Obtener el número de filas
    result.beforeFirst();

        
        for (int i=0; i<tamano; i++){
            array.add(result.getInt(1));
        }
    }catch(Exception e){
        
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
 
