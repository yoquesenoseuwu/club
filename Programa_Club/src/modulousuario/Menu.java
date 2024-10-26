package ModuloUsuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    
    public Menu() {
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        JButton btnHistorial = new JButton("Ver Historial");
        JButton btnMembresias = new JButton("Ver Membresías");
        JButton btnDisciplinas = new JButton("Ver Disciplinas");
        
        // Acción para el botón de historial
        btnHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre el historial completo al hacer click en el botón
                new Historial().setVisible(true);
            }
        });

        // Acción para el botón de membresías
        btnMembresias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre el historial de membresías al hacer click
                //new Membresias().setVisible(true);
            }
        });

        // Acción para el botón de disciplinas
        btnDisciplinas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre el historial de disciplinas al hacer click
                //new Disciplinas().setVisible(true);
            }
        });

        // Añadir botones al panel
        panel.add(btnHistorial);
        panel.add(btnMembresias);
        panel.add(btnDisciplinas);
        
        add(panel);
        
        setTitle("Menú Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }
}
