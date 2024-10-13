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
public class Abrir_Seguridad {
    public void Open_Security(){
        Pantalla_Seguridad vS= new Pantalla_Seguridad();
        vS.setVisible(true);
        vS.setSize(1530,900);
        vS.setLocationRelativeTo(null);
    }
}
