/*
Indice=
vS=Pantalla de seguridad del paquete Modulo_Seguridad
 */
package programa_club;

<<<<<<< HEAD
import programa_club.Conexion_Bdd;
import Modulo_Seguridad.Pantalla_Seguridad;
import Modulo_Seguridad.Abrir_Seguridad;
import Modulo_Ventas.Pantalla_Ventas;
import java.sql.ResultSet;
=======
import Modulo_Seguridad.Pantalla_Seguridad;
import Modulo_Seguridad.Abrir_Seguridad;
>>>>>>> 5bf21324d750ed4f27a7c497add0c449f1960264

        /**
 *
 * @author HP OMEN
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new java.awt.Button();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
<<<<<<< HEAD
        jButton3 = new javax.swing.JButton();
=======
>>>>>>> 5bf21324d750ed4f27a7c497add0c449f1960264

        button1.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Entrar a seguridad");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Conectar Bdd");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        jButton3.setText("Entrar a Ventas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

=======
>>>>>>> 5bf21324d750ed4f27a7c497add0c449f1960264
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(128, 128, 128)
                            .addComponent(jButton1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(141, 141, 141)
                            .addComponent(jButton2))))
=======
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jButton2)))
>>>>>>> 5bf21324d750ed4f27a7c497add0c449f1960264
                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButton1)
<<<<<<< HEAD
                .addGap(44, 44, 44)
                .addComponent(jButton3)
                .addGap(48, 48, 48)
                .addComponent(jButton2)
                .addContainerGap(91, Short.MAX_VALUE))
=======
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(188, Short.MAX_VALUE))
>>>>>>> 5bf21324d750ed4f27a7c497add0c449f1960264
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Abrir_Seguridad Seguridad = new Abrir_Seguridad();
        Seguridad.Open_Security();
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Conexion_Bdd bd = new Conexion_Bdd();
        bd.Conectar(); 
        
        
<<<<<<< HEAD
     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Pantalla_Ventas vV= new Pantalla_Ventas();
        vV.setVisible(true);
        this.setVisible(false);
        vV.setLocationRelativeTo(null);
        vV.setSize(1530,900);    
    }//GEN-LAST:event_jButton3ActionPerformed
                                                   
=======
        
    }//GEN-LAST:event_jButton2ActionPerformed

>>>>>>> 5bf21324d750ed4f27a7c497add0c449f1960264
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
<<<<<<< HEAD
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
=======
    // End of variables declaration//GEN-END:variables
}
>>>>>>> 5bf21324d750ed4f27a7c497add0c449f1960264
