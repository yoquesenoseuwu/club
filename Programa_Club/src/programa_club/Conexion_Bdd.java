/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa_club;
import java.sql.*;
/**
 *
 * @author HP OMEN
 */
public class Conexion_Bdd {
    
   /*
    ------------------------ACLARACION----------------------------
    Por lo que vi, en cada funcion se debe conectarse a la bdd, tipo no se puede tener un metodo especifico para la conexion
    y usarlo en otros lugares.
    
    
     
    */
    
    
    public ResultSet Select(String Nombre_Tabla){
        try{
            //Crear conexion
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            PreparedStatement sele = miConexion.prepareStatement("SELECT * FROM ?");
            sele.setString(0, Nombre_Tabla);
            ResultSet resul=sele.executeQuery();
            
            miConexion.close();
        
    
            
            return resul;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;
        }
    }
    
    
            
            
            
            //Ejecutar sql
            
            
            
            //Leer el resultado
           

    
}
