package ModuloUsuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Inicio extends javax.swing.JFrame {

    public Inicio() {
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        paneltitulo = new javax.swing.JPanel();
        lbltitulo = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        lblconstraseña = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        passwordconstraseña = new javax.swing.JPasswordField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btniniciosesion = new javax.swing.JButton();
        btnregistro = new javax.swing.JButton();
        lblregistro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paneltitulo.setBackground(new java.awt.Color(102, 204, 255));

        lbltitulo.setFont(new java.awt.Font("Arial", 1, 24));
        lbltitulo.setText("Sistema de Gestión de Socios");

        javax.swing.GroupLayout paneltituloLayout = new javax.swing.GroupLayout(paneltitulo);
        paneltitulo.setLayout(paneltituloLayout);
        paneltituloLayout.setHorizontalGroup(
            paneltituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltituloLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(lbltitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneltituloLayout.setVerticalGroup(
            paneltituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneltituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltitulo)
                .addGap(26, 26, 26))
        );

        lblusuario.setText("Usuario:");
        lblconstraseña.setText("Contraseña:");
        lblDireccion.setText("Dirección:");
        lblEmail.setText("Email:");

        btniniciosesion.setText("Iniciar Sesión");
        btniniciosesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniniciosesionActionPerformed(evt);
            }
        });

        btnregistro.setText("Registrar");
        btnregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistroActionPerformed(evt);
            }
        });

        lblregistro.setText("¿No tienes una cuenta? Regístrate aquí:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneltitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblusuario)
                            .addComponent(lblconstraseña)
                            .addComponent(lblDireccion)
                            .addComponent(lblEmail))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtusuario)
                            .addComponent(passwordconstraseña)
                            .addComponent(txtDireccion)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btniniciosesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnregistro, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(lblregistro)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(paneltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblusuario)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblconstraseña)
                    .addComponent(passwordconstraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btniniciosesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblregistro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnregistro)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void btniniciosesionActionPerformed(java.awt.event.ActionEvent evt) {
        String usuario = txtusuario.getText();
        String constrasena = new String(passwordconstraseña.getPassword());
        String direccion = txtDireccion.getText();
        String email = txtEmail.getText();

        if (usuario.isEmpty() || constrasena.isEmpty() || direccion.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Intentar iniciar sesión
        try {
            Connection con = DatabaseConnection.getConnection();
           
            // Verificar si el usuario está registrado
            String queryUsuario = "SELECT * FROM Usuario WHERE Nombre_usuario = ? AND Direccion = ? AND Email = ?";
            PreparedStatement pstUsuario = con.prepareStatement(queryUsuario);
            pstUsuario.setString(1, usuario);
            pstUsuario.setString(2, direccion);
            pstUsuario.setString(3, email);
            ResultSet rsUsuario = pstUsuario.executeQuery();
           
            if (!rsUsuario.next()) {
                // Si el usuario no está registrado
                JOptionPane.showMessageDialog(this, "Usuario, dirección o email incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Verificar la contraseña
                String queryContrasena = "SELECT * FROM Usuario WHERE Nombre_usuario = ? AND Contraseña = ?";
                PreparedStatement pstContrasena = con.prepareStatement(queryContrasena);
                pstContrasena.setString(1, usuario);
                pstContrasena.setString(2, constrasena);
                ResultSet rsContrasena = pstContrasena.executeQuery();

                if (rsContrasena.next()) {
                    // Inicio de sesión exitoso
                    JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso. Bienvenido!");
                    this.dispose(); // Cerrar la ventana actual
                    // Aquí puedes abrir la siguiente ventana si es necesario
                } else {
                    JOptionPane.showMessageDialog(this, "Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            // Cerrar conexiones
            rsUsuario.close();
            pstUsuario.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnregistroActionPerformed(java.awt.event.ActionEvent evt) {
        // Redirigir a la ventana de registro
        new Registro().setVisible(true);
        this.dispose(); // Cerrar la ventana actual
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton btniniciosesion;
    private javax.swing.JButton btnregistro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblconstraseña;
    private javax.swing.JLabel lblregistro;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JPasswordField passwordconstraseña;
    private javax.swing.JPanel paneltitulo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtusuario;
}