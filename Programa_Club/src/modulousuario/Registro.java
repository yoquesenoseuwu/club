package ModuloUsuarios;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Registro extends javax.swing.JFrame {

    public Registro() {
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        lbltitulo = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        lblcontrasena = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();  // Nueva etiqueta para Direccion
        lblEmail = new javax.swing.JLabel();      // Nueva etiqueta para Email
        
        txtusuario = new javax.swing.JTextField();
        passwordcontrasena = new javax.swing.JPasswordField();
        txtDireccion = new javax.swing.JTextField();  // Nuevo campo para Direccion
        txtEmail = new javax.swing.JTextField();      // Nuevo campo para Email

        btnregistrar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbltitulo.setFont(new java.awt.Font("Arial", 1, 24));
        lbltitulo.setText("Registro de Usuario");

        lblusuario.setText("Usuario:");
        lblcontrasena.setText("Contraseña:");
        lblDireccion.setText("Dirección:");  // Texto para el nuevo campo de Direccion
        lblEmail.setText("Email:");          // Texto para el nuevo campo de Email

        btnregistrar.setText("Registrar");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        // Configuración del layout
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setAutoCreateGaps(true); // Para manejar espacios automáticamente
        jPanel1Layout.setAutoCreateContainerGaps(true); // Para manejar márgenes automáticamente

        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbltitulo)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblusuario)
                .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblcontrasena)
                .addComponent(passwordcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblDireccion)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblEmail)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnregistrar)
                .addComponent(btncancelar))
        );

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createSequentialGroup()
            .addComponent(lbltitulo)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblusuario)
                .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblcontrasena)
                .addComponent(passwordcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblDireccion)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblEmail)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnregistrar)
                .addComponent(btncancelar))
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

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {
        String usuario = txtusuario.getText();
        String contrasena = new String(passwordcontrasena.getPassword());
        String direccion = txtDireccion.getText();  // Obtener el valor de la dirección
        String email = txtEmail.getText();          // Obtener el valor del email

        // Verificar si el usuario ya existe
        if (DatabaseConnection.usuarioExiste(usuario)) {
            JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe. Por favor, elige otro.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Registrar el nuevo usuario con los nuevos campos
            DatabaseConnection.registrarUsuario(usuario, contrasena, direccion, email);
            JOptionPane.showMessageDialog(this, "Registro exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            // Limpiar campos
            txtusuario.setText("");
            passwordcontrasena.setText("");
            txtDireccion.setText("");
            txtEmail.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.dispose();
    }

    // Variables declaration
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JLabel lblcontrasena;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JLabel lblDireccion;  // Nueva etiqueta
    private javax.swing.JLabel lblEmail;      // Nueva etiqueta
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordcontrasena;
    private javax.swing.JTextField txtusuario;
    private javax.swing.JTextField txtDireccion;  // Nuevo campo
    private javax.swing.JTextField txtEmail;      // Nuevo campo
}
