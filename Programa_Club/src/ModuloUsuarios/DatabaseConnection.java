<<<<<<< HEAD
package ModuloUsuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    // Detalles de la conexión
    private static final String URL = "jdbc:mysql://bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb";
    private static final String USER = "uwwqerjcglxxweor"; 
    private static final String PASSWORD = "vWobxeLnCiH11WTJg6N"; 

    // Método para establecer la conexión
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida con éxito.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } 
        return connection;
    }

    // Método para verificar si un usuario ya existe en la base de datos
    public static boolean usuarioExiste(String nombreUsuario) {
        String sql = "SELECT * FROM Usuario WHERE Nombre_usuario = ?";
        try (Connection connection = getConnection(); 
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nombreUsuario);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();  // Retorna true si encuentra un registro
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar el usuario: " + e.getMessage());
        }
        return false;
    }

    // Método para registrar un usuario en la base de datos
    public static void registrarUsuario(String usuario, String contrasena, String direccion, String email) throws SQLException {
        String sql = "INSERT INTO Usuario (Nombre_usuario, Contraseña, Direccion, Email) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, usuario);
            statement.setString(2, contrasena);
            statement.setString(3, direccion);
            statement.setString(4, email);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Usuario registrado exitosamente.");
            } else {
                throw new SQLException("No se pudo registrar el usuario.");
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
            throw e;
        }
    }

    // Método para probar la conexión a la base de datos
    public static void testConnection() {
        try (Connection conn = getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("La conexión está activa.");
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.out.println("Error al probar la conexión: " + e.getMessage());
        }
    }
=======
package ModuloUsuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    // Detalles de la conexión
    private static final String URL = "jdbc:mysql://bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb";
    private static final String USER = "uwwqerjcglxxweor"; 
    private static final String PASSWORD = "vWobxeLnCiH11WTJg6N"; 

    // Método para establecer la conexión
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida con éxito.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } 
        return connection;
    }

    // Método para verificar si un usuario ya existe en la base de datos
    public static boolean usuarioExiste(String nombreUsuario) {
        String sql = "SELECT * FROM Usuario WHERE Nombre_usuario = ?";
        try (Connection connection = getConnection(); 
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nombreUsuario);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();  // Retorna true si encuentra un registro
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar el usuario: " + e.getMessage());
        }
        return false;
    }

    // Método para registrar un usuario en la base de datos
    public static void registrarUsuario(String usuario, String contrasena, String direccion, String email) throws SQLException {
        String sql = "INSERT INTO Usuario (Nombre_usuario, Contraseña, Direccion, Email) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, usuario);
            statement.setString(2, contrasena);
            statement.setString(3, direccion);
            statement.setString(4, email);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Usuario registrado exitosamente.");
            } else {
                throw new SQLException("No se pudo registrar el usuario.");
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
            throw e;
        }
    }

    // Método para probar la conexión a la base de datos
    public static void testConnection() {
        try (Connection conn = getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("La conexión está activa.");
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.out.println("Error al probar la conexión: " + e.getMessage());
        }
    }
>>>>>>> 5bf21324d750ed4f27a7c497add0c449f1960264
}