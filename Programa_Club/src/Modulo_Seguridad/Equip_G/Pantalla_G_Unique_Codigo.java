/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Seguridad.Equip_G;

import Modulo_Seguridad.Conexion_Bdd_Seguridad;
import java.util.ArrayList;

/**
 *
 * @author HP OMEN
 */
public class Pantalla_G_Unique_Codigo {
    Conexion_Bdd_Seguridad conexion= new Conexion_Bdd_Seguridad();
    ArrayList Array;
    
    public ArrayList cargar_datos (int Id){
        
        Array=conexion.Select_equipo_de_guardia_x(Id);
         
        return Array;
    } 
    
    public void Eliminar_datos(int Id){
        conexion.Eliminar_equipo_de_x(Id);
    }
    
    public ArrayList mostrar_equipo(){
        Array=conexion.Mostrar_Equipo_sin_Usar();
        
        return Array;
    }
    
    public void Insertar_equipo(int id_equipo, int id_guardia){
        conexion.Insert_equipo(id_equipo, id_guardia);
    }
}
