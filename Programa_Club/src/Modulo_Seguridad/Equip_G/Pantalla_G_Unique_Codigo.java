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
    ArrayList<String> Array;
    
    public ArrayList<String> cargar_datos (int Id){
        
        Array.add("hola");
         
        return Array;
    } 
    
}
