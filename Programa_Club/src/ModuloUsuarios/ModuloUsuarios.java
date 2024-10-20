package ModuloUsuarios;

public class ModuloUsuarios {

    public static void main(String[] args) {
        // Crear una nueva instancia de la clase de interfaz gráfica (por ejemplo, Inicio)
        Inicio ventana = new Inicio();
        ventana.setVisible(true); // Hacer visible la ventana
        
        // Probar la conexión después de que la ventana sea visible
        DatabaseConnection.testConnection(); // Asegúrate de que el método testConnection() es estático
    }
}
