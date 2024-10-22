package ModuloUsuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Historial extends JFrame {

    public Historial() {
        setTitle("Historial de Consultas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel y botones para diferentes consultas
        JPanel panel = new JPanel();
        JButton btnVerHistorial = new JButton("Ver Historial Completo");
        JButton btnVerMembresias = new JButton("Ver Membresías");
        JButton btnVerDisciplinas = new JButton("Ver Disciplinas");

        // Agregar acción a los botones
        btnVerHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarHistorialCompleto();
            }
        });

        btnVerMembresias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMembresias();
            }
        });

        btnVerDisciplinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDisciplinas();
            }
        });

        // Agregar botones al panel
        panel.add(btnVerHistorial);
        panel.add(btnVerMembresias);
        panel.add(btnVerDisciplinas);

        // Agregar panel al frame
        add(panel);
    }

    private void mostrarHistorialCompleto() {
    String query = "SELECT u.IDUsuario, u.Nombre_usuario, u.Direccion, u.Email, " +
                   "m.IDMembresia, m.Nombre AS Nombre_Membresia, m.Precio, m.Descuento, " +
                   "d.IDDisciplina, di.Nombre AS Nombre_Disciplina " + // Cambiado d.Nombre a di.Nombre
                   "FROM Usuario u " +
                   "LEFT JOIN Socio s ON u.IDUsuario = s.IDUsuario " +
                   "LEFT JOIN Membresia m ON s.IDMembresia = m.IDMembresia " +
                   "LEFT JOIN Deportista d ON u.IDUsuario = d.IDUsuario " + 
                   "LEFT JOIN Disciplina di ON d.IDDisciplina = di.IDDisciplina;"; // Agregado JOIN con Disciplina

    mostrarResultados(query, "Historial Completo");
}


    private void mostrarMembresias() {
        String query = "SELECT m.IDMembresia, m.Nombre, m.Precio, m.Descuento FROM Membresia m;";
        mostrarResultados(query, "Membresías");
    }

    private void mostrarDisciplinas() {
        String query = "SELECT d.IDDisciplina, d.Nombre FROM Disciplina d;";
        mostrarResultados(query, "Disciplinas");
    }

    private void mostrarResultados(String query, String titulo) {
    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

        // Crear un modelo de tabla para mostrar los datos
        DefaultTableModel model = new DefaultTableModel();
        
        // Definir las columnas según el título
        if (titulo.equals("Historial Completo")) {
            model.addColumn("ID Usuario");
            model.addColumn("Nombre Usuario");
            model.addColumn("Dirección");
            model.addColumn("Email");
            model.addColumn("ID Membresía");
            model.addColumn("Nombre Membresía");
            model.addColumn("Precio");
            model.addColumn("Descuento");
            model.addColumn("ID Disciplina");
            model.addColumn("Nombre Disciplina");
        } else if (titulo.equals("Membresías")) {
            model.addColumn("ID Membresía");
            model.addColumn("Nombre");
            model.addColumn("Precio");
            model.addColumn("Descuento");
        } else if (titulo.equals("Disciplinas")) {
            model.addColumn("ID Disciplina");
            model.addColumn("Nombre");
        }

        while (rs.next()) {
            if (titulo.equals("Historial Completo")) {
                model.addRow(new Object[]{
                    rs.getInt("IDUsuario"),
                    rs.getString("Nombre_usuario"),
                    rs.getString("Direccion"),
                    rs.getString("Email"),
                    rs.getInt("IDMembresia"),
                    rs.getString("Nombre_Membresia"),
                    rs.getDouble("Precio"),
                    rs.getDouble("Descuento"),
                    rs.getInt("IDDisciplina"),
                    rs.getString("Nombre_Disciplina")
                });
            } else if (titulo.equals("Membresías")) {
                model.addRow(new Object[]{
                    rs.getInt("IDMembresia"),
                    rs.getString("Nombre"),
                    rs.getDouble("Precio"),
                    rs.getDouble("Descuento")
                });
            } else if (titulo.equals("Disciplinas")) {
                model.addRow(new Object[]{
                    rs.getInt("IDDisciplina"),
                    rs.getString("Nombre")
                });
            }
        }

        // Crear una tabla y establecer su tamaño
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); // Permitir que las columnas se redimensionen
        table.setFillsViewportHeight(true); // Asegurarse de que la tabla llene el área visible
        JScrollPane scrollPane = new JScrollPane(table);
        JScrollPane scroll = new JScrollPane(scrollPane);
        scroll.setPreferredSize(new java.awt.Dimension(1000, 500)); // Ajustar tamaño del JScrollPane

        JOptionPane.showMessageDialog(null, scroll, titulo, JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Historial().setVisible(true);
        });
    }
}
