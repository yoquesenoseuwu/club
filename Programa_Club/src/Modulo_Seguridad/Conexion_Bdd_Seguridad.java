/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Seguridad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import programa_club.Conexion_Bdd;
/**
 *
 * @author PC
 */
public class Conexion_Bdd_Seguridad {
    private String Nom_z;
    private int id_z;
    private String[] vector;
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
            //vector=new [2];
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            String query="SELECT ID,Nombre,Tamaño,Descripcion FROM Zona_de_Seguridad;";
            Statement  sele = miConexion.createStatement();
            ResultSet result=sele.executeQuery(query);
            while(result.next()){
                String Item=result.getInt("ID") + "-" + result.getString("Nombre")+ "-" + result.getString("Tamaño")+ "-" + result.getString("Descripcion");
                array.add(Item);
                //vector[0]=getString(result.getInt("ID"));

            }
            
            miConexion.close();
            return array;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return null;    
        }
        
    }
    public int Select_Zona_de_Seguridad_id(){
        try{
            
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            String query="SELECT ID FROM Zona_de_Seguridad;";
            Statement  sele = miConexion.createStatement();
            ResultSet result=sele.executeQuery(query);
            while(result.next()){
                id_z=result.getInt("ID");
                
            }
            
            miConexion.close();
            return id_z;
        }catch(Exception e){
            System.out.println("No funca");
            
            e.printStackTrace();
            
            return 0;    
        }
        
    }
    
    public ArrayList Select_Zona_de_Seguridad_nombre(){
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            String query="SELECT Nombre FROM Zona_de_Seguridad;";
            Statement  sele = miConexion.createStatement();
            ResultSet result=sele.executeQuery(query);
            while(result.next()){
                String Item=result.getString("Nombre");
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
    
    public Boolean Insert_Zona_Seguridad(String Nombre, String Tamaño, String Descripcion){
        try{
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            PreparedStatement sele= miConexion.prepareStatement("INSERT INTO Zona_de_Seguridad (Nombre, Tamaño, Descripcion) VALUES (?,?,?)");

            
            sele.setString(1,Nombre);
            sele.setString(2,Tamaño);
            sele.setString(3,Descripcion);
            

            sele.executeUpdate();

            miConexion.close();
            return(true);

        }catch(Exception e){
            System.out.println("No funca");

            e.printStackTrace();
            return(false);

        }
    }
    
    public ArrayList Select_Guardias(){
        try{
            ArrayList<String> array = new ArrayList<String>();
            Connection miConexion=DriverManager.getConnection("jdbc:mysql://uwwqerjcglxxweor:vWobxeLnCiH11WTJg6N@bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb","uwwqerjcglxxweor","vWobxeLnCiH11WTJg6N");
            String query="SELECT e.idempleado, e.nombre, c.cargos FROM Empleado e, Cargo c WHERE e.idcargo=c.idcargo;";//necesito mas datos en la base de datos
            Statement  sele = miConexion.createStatement();
            ResultSet result=sele.executeQuery(query);
            while(result.next()){
                String Item=result.getInt("idempleado") + "-" + result.getString("nombre")+ "-" + result.getString("cargos");
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
