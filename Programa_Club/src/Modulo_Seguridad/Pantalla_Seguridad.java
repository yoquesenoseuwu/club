/*
Indice=
vM=La pantalla del Main del paquete programa_club

 */
package Modulo_Seguridad;

import Modulo_Seguridad.Zonas_de_Seguridad.Ver_Zonas;
import Modulo_Seguridad.Supender_Socio.Suspender_socio_interface;
import Modulo_Seguridad.Supender_Socio.Ver_Socios_Suspendidos;
import java.awt.Dimension;
import programa_club.Main;
import Modulo_Seguridad.Ver_Equipar_Guardias.Ver_Guardias;
import Modulo_Seguridad.Comprar_equip.Pantalla_eleccion;


public class Pantalla_Seguridad extends javax.swing.JFrame {

    public Pantalla_Seguridad() {
        initComponents();
        this.setResizable(false);
        btn_verGuardias.setMinimumSize(new Dimension(141,50));
        btn_verGuardias.setMaximumSize(new Dimension(141,50));
        btn_verZonas.setMinimumSize(new Dimension(141,50));
        btn_verZonas.setMaximumSize(new Dimension(141,50));
        btn_suspenderSocios.setMinimumSize(new Dimension(141,50));
        btn_suspenderSocios.setMaximumSize(new Dimension(141,50));
        btn_equiparGuardias.setMinimumSize(new Dimension(141,50));
        btn_equiparGuardias.setMaximumSize(new Dimension(141,50));
        btn_crearInforme.setMinimumSize(new Dimension(141,50));
        btn_crearInforme.setMaximumSize(new Dimension(141,50));
        btn_comprarEquipamiento.setMinimumSize(new Dimension(141,50));
        btn_comprarEquipamiento.setMaximumSize(new Dimension(141,50));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_verGuardias = new javax.swing.JButton();
        btn_suspenderSocios = new javax.swing.JButton();
        btn_Volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_verZonas = new javax.swing.JButton();
        btn_equiparGuardias = new javax.swing.JButton();
        btn_comprarEquipamiento = new javax.swing.JButton();
        btn_crearInforme = new javax.swing.JButton();
        btn_v_s_s = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        btn_Volver.setText("<--");
        btn_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VolverActionPerformed(evt);
            }
        });

        jLabel1.setText("Pantalla de seguridad");

        btn_verZonas.setText("Ver Zonas");
        btn_verZonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verZonasActionPerformed(evt);
            }
        });

        btn_equiparGuardias.setText("Equipar Guardias");

        btn_comprarEquipamiento.setText("Comprar equipamiento");
        btn_comprarEquipamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comprarEquipamientoActionPerformed(evt);
            }
        });

        btn_crearInforme.setText("Crear informe");

        btn_v_s_s.setText("Ver Socios Suspendidos");
        btn_v_s_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_v_s_sActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_crearInforme, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                .addGap(217, 217, 217)
                                .addComponent(btn_comprarEquipamiento, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_verGuardias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(217, 217, 217)
                                .addComponent(btn_suspenderSocios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_verZonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(217, 217, 217)
                                .addComponent(btn_equiparGuardias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_v_s_s)
                        .addGap(364, 364, 364)))
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Volver)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_verGuardias)
                            .addComponent(btn_suspenderSocios))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_verZonas)
                            .addComponent(btn_equiparGuardias))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_comprarEquipamiento)
                            .addComponent(btn_crearInforme))))
                .addGap(18, 18, 18)
                .addComponent(btn_v_s_s)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VolverActionPerformed
        Main vM = new Main();
        vM.setVisible(true);
        this.setVisible(false);
        vM.setSize(1530,900);
        vM.setLocationRelativeTo(null);
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
        VerGuardias.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_verGuardiasActionPerformed

    private void btn_verZonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verZonasActionPerformed
        Ver_Zonas VerZonas=new Ver_Zonas();
        VerZonas.setVisible(true);
        VerZonas.setLocationRelativeTo(null);
        this.setVisible(false);
        VerZonas.setSize(1530,900);
    }//GEN-LAST:event_btn_verZonasActionPerformed

    private void btn_v_s_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_v_s_sActionPerformed
        Ver_Socios_Suspendidos V_S_S=new Ver_Socios_Suspendidos();
        V_S_S.setVisible(true);
        V_S_S.setLocationRelativeTo(null);
        this.setVisible(false);
        V_S_S.setSize(1530,900);
    }//GEN-LAST:event_btn_v_s_sActionPerformed

    private void btn_comprarEquipamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_comprarEquipamientoActionPerformed
        Pantalla_eleccion cE=new Pantalla_eleccion();
        cE.setVisible(true);
        cE.setLocationRelativeTo(null);
        this.setVisible(false);
        cE.setSize(500,500);
    }//GEN-LAST:event_btn_comprarEquipamientoActionPerformed

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
    private javax.swing.JButton btn_comprarEquipamiento;
    private javax.swing.JButton btn_crearInforme;
    private javax.swing.JButton btn_equiparGuardias;
    private javax.swing.JButton btn_suspenderSocios;
    private javax.swing.JButton btn_v_s_s;
    private javax.swing.JButton btn_verGuardias;
    private javax.swing.JButton btn_verZonas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}                                          
  
