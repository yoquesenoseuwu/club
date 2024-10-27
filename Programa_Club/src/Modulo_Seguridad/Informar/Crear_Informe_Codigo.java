/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Seguridad.Informar;

import Modulo_Seguridad.Informar.Crear_Informe;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import Modulo_Seguridad.Conexion_Bdd_Seguridad;

/**
 *
 * @author PC
 */
public class Crear_Informe_Codigo {
    Conexion_Bdd_Seguridad conexion= new Conexion_Bdd_Seguridad();
    
    public Crear_Informe_Codigo(){

    }

    
    public DefaultListModel mostrar(DefaultListModel modelo){
        modelo.removeAllElements();
        ArrayList array=conexion.Select_informes();
        for (int i=0; i<array.size(); i++){
            modelo.addElement(array.get(i));
        }
        return modelo;
        
    }
    public void Crear_Informe(int id){
        Crear_Informe Pz = new Crear_Informe();
        Pz.setVisible(true);
    }
    public void Mos_Informe(int id){
        Pantalla_Informe pI = new Pantalla_Informe();
        pI.Mostrar_Informe_Seleccionado(id);
        pI.setVisible(true);
        
    }
}
