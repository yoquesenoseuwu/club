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
    
    
    public static void main(String [] args){
        try{
            //Crear conexion
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            
            //Crear un obj statement
            
            Statement miStatement=miConexion.createStatement();
            
            //Ejecutar sql
            
            ResultSet miResultset=miStatement.executeQuery("SELECT * FROM USERS");
            
            //Leer el resultado
            
            while(miResultset.next()){
                System.out.println(miResultset.getString("id") + "" + miResultset.getString("username") + "" + miResultset.getString("email") + "" + miResultset.getString("password") + "" + miResultset.getString("created_at"));
            }
            
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
        }
    }
    
}
