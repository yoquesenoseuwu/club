/*
Indice=
vM=La pantalla del Main del paquete programa_club

 */
package Modulo_Seguridad;

import programa_club.Main;
import Modulo_Seguridad.Ver_Guardias;

public class Pantalla_Seguridad extends javax.swing.JFrame {

    public Pantalla_Seguridad() {
        initComponents();
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        btn_Volver = new javax.swing.JButton();
        btn_verGuardias = new javax.swing.JButton();
        btn_suspenderSocios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setText("Seccion de Seguridad");

        btn_Volver.setText("<--");
        btn_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VolverActionPerformed(evt);
            }
        });

        btn_verGuardias.setText("Ver Los Guardias");
        btn_verGuardias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verGuardiasActionPerformed(evt);
            }
        });

        btn_suspenderSocios.setText("Suspender Socio");
        btn_suspenderSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suspenderSociosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_verGuardias)
                        .addGap(18, 18, 18)
                        .addComponent(btn_suspenderSocios)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_Volver)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_verGuardias)
                    .addComponent(btn_suspenderSocios))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VolverActionPerformed
        Main vM = new Main();
        vM.setVisible(true);
        this.setVisible(false);
        vM.setSize(1530,900);
    }//GEN-LAST:event_btn_VolverActionPerformed
    
    private void btn_suspenderSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suspenderSociosActionPerformed
        Suspender_socio_interface vS= new Suspender_socio_interface();
        vS.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_suspenderSociosActionPerformed

    private void btn_verGuardiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verGuardiasActionPerformed
        Ver_Guardias VerGuardias=new Ver_Guardias();
        VerGuardias.setVisible(true);
        VerGuardias.setLocationRelativeTo(null);
        this.setVisible(false);
        VerGuardias.setSize(1530,900);
    }//GEN-LAST:event_btn_verGuardiasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Pantalla_Seguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Seguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Seguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Seguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla_Seguridad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Volver;
    private javax.swing.JButton btn_suspenderSocios;
    private javax.swing.JButton btn_verGuardias;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}                                          
  
