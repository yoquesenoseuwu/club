
package Modulo_Seguridad.Comprar_equip;

import Modulo_Seguridad.Conexion_Bdd_Seguridad;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author HP OMEN
 */
public class Com_equip_codigo {
    //Crea la conexion con la bdd
    Conexion_Bdd_Seguridad conexion = new Conexion_Bdd_Seguridad();
    
    public DefaultListModel Cargar_datos(DefaultListModel modelo){
        //Carga los datos al modelo
        modelo.removeAllElements();
        ArrayList array_carga= conexion.Select_tipo_Equipo();
        for (int i=0; i<array_carga.size(); i++){
            modelo.addElement(array_carga.get(i));
        }
        return modelo;
    }
    
    public void Pantalla_equipo(int Id){
        //Muestra la pantalla de equipo
        Pantalla_Equipo Ps;
        Ps = new Pantalla_Equipo();
        Ps.agregar_equipo(Id);
        Ps.setVisible(true);
    }

    
    
    
}
