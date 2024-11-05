/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu_RH;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Despidos extends javax.swing.JFrame {

    // Variables de conexión a la base de datos
    private final String DB_URL = "jdbc:mysql://bbbx7cdcbcl53xxmjyxb-mysql.services.clever-cloud.com:21748/bbbx7cdcbcl53xxmjyxb"; // Cambia esto por tu URL
    private final String USER = "uwwqerjcglxxweor"; // Cambia esto por tu usuario
    private final String PASS = "vWobxeLnCiH11WTJg6N"; // Cambia esto por tu contraseña
    

    public Despidos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ing_id_despidos = new javax.swing.JTextField();
        Listo_despidos = new javax.swing.JButton();
        Volver_despidos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 50, 69));

        jLabel1.setFont(new java.awt.Font("Waree", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 232, 236));
        jLabel1.setText("Despidos");

        jLabel2.setFont(new java.awt.Font("Waree", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 232, 236));
        jLabel2.setText("Ingrese ID a despedir:");

        ing_id_despidos.setFont(new java.awt.Font("Waree", 0, 15)); // NOI18N
        ing_id_despidos.addActionListener(this::ing_id_despidosActionPerformed);
        ing_id_despidos.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ing_id_despidosKeyTyped(evt);
            }
        });

        Listo_despidos.setFont(new java.awt.Font("Waree", 0, 15)); // NOI18N
        Listo_despidos.setText("Listo");
        Listo_despidos.addActionListener((java.awt.event.ActionEvent evt) -> {
            verificarID();
        });

        Volver_despidos.setText("<-");
        Volver_despidos.addActionListener(this::Volver_despidosActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Volver_despidos)
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(ing_id_despidos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(149, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Listo_despidos)
                .addGap(170, 170, 170))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Volver_despidos))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ing_id_despidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(Listo_despidos)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void ing_id_despidosActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO: Manejo del evento si es necesario
    }                                              

    private void Volver_despidosActionPerformed(java.awt.event.ActionEvent evt) {                                                
        Gtn_personal newframe = new Gtn_personal();
        newframe.setVisible(true);
        this.dispose();
    }                                              

    private void ing_id_despidosKeyTyped(java.awt.event.KeyEvent evt) {                                        
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') evt.consume();
    }                                        

    private void verificarID() {
        String id = ing_id_despidos.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID.");
            return;
        }
        DatabaseConnection.testConnection();
        // Conectar a la base de datos
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT COUNT(*) FROM empleados WHERE id = ?"; // Cambia "empleados" y "id" por tu tabla y columna
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();

                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(this, "El ID existe en la base de datos.");
                    // Aquí puedes agregar el código para proceder con el despido
                } else {
                    JOptionPane.showMessageDialog(this, "El ID no existe en la base de datos.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al verificar el ID: " + id);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Despidos().setVisible(true);
        });
    }

    // Variables declaration - do not modify                    
    private javax.swing.JButton Listo_despidos;
    private javax.swing.JButton Volver_despidos;
    private javax.swing.JTextField ing_id_despidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                  
}