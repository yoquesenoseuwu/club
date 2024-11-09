/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Seguridad;

import java.awt.Dimension;
import Modulo_Seguridad.Pantalla_Seguridad;
/**
 *
 * @author PC
 */
public class Abrir_Seguridad {//Abre la pantalla principal de seguridad
    public void Open_Security(){
        Pantalla_Seguridad vS= new Pantalla_Seguridad();
        vS.setVisible(true);
        vS.setSize(700,430);
        vS.setLocationRelativeTo(null);
    }
}
