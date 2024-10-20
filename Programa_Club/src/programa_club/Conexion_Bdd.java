/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa_club;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
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
    public Connection Conectar() {
        Connection miConexion = null; // Inicializa la conexión como nula
        try {
            // Asegúrate de que la URL esté correctamente formateada
            String url = "jdbc:mysql://bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb";
            String user = "uwwqerjcglxxweor"; // Nombre de usuario
            String password = "vWobxeLnCiH11WTJg6N"; // Contraseña

            // Intenta establecer la conexión
            miConexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
        return miConexion; // Retorna la conexión (puede ser nula si hubo un error)
    }

    
    //Este es un metodo que podemos usar para cualquier tabla
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
 //Metodo usado por los de seguridad
    public ArrayList Select_socios(){
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            String query="SELECT s.IDUsuario, u.Nombre_usuario FROM Usuario u,Socio s WHERE u.IDUsuario=s.IDUsuario;";
            Statement  sele = miConexion.createStatement();
            ResultSet result=sele.executeQuery(query);
            while(result.next()){
                String Item=result.getInt("IDUsuario") + "-" + result.getString("Nombre_usuario");
                array.add(Item);
            }
            
            miConexion.close();
            return array;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;    
        }
        
    }
    //Metodo usado por los de seguridad
    public ArrayList Select_unique_socio(int id){
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            String str="SELECT * FROM Usuario u WHERE u.IDUsuario=?";
            PreparedStatement  query=miConexion.prepareStatement(str);
            query.setInt(1,id);
            ResultSet result = query.executeQuery();
            
            while(result.next()){
                String Id="ID DE USUARIO/SOCIO=" + result.getInt("IDUsuario");
                array.add(Id);
                String Nombre="NOMBRE DE SOCIO=" + result.getString("Nombre_usuario");
                array.add(Nombre);
                String Contra="CONTRASEÑA=" + result.getString("Contraseña");
                array.add(Contra);
                String Direccion="DIRECCION=" + result.getString("Direccion");
                array.add(Direccion);
                String Email="EMAIL=" + result.getString("Email");
                array.add(Email);
            }
            
            miConexion.close();
            return array;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;
        }
        
       
   }
    public ArrayList Select_Zona_de_Seguridad(){
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            String query="SELECT ID,Nombre,Tamaño,Descripcion FROM Zona_de_Seguridad;";
            Statement  sele = miConexion.createStatement();
            ResultSet result=sele.executeQuery(query);
            while(result.next()){
                String Item=result.getInt("ID") + "-" + result.getString("Nombre")+ "-" + result.getString("Tamaño")+ "-" + result.getString("Descripcion");
                array.add(Item);
            }
            
            miConexion.close();
            return array;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;    
        }
        
    }
    
}
