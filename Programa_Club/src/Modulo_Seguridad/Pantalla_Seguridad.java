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
import Modulo_Seguridad.Ver_Guardia.Ver_Guardias;
import Modulo_Seguridad.Comprar_equip.Pantalla_eleccion;
import Modulo_Seguridad.Informar.Mostrar_Informe;
import Modulo_Seguridad.Posicionar_Guardias.Ver_Zonas_Guardia;
import Modulo_Seguridad.Equip_G.Pantalla_Guardias;

public class Pantalla_Seguridad extends javax.swing.JFrame {
    //En serio tengo que comentarizar aca? aaaaaaaaaaaaaaaaa
    //Simple, crea botones y les dice a que clase se conectan

    public Pantalla_Seguridad() {
        initComponents();
        this.setResizable(false);
        

        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_posicionar = new javax.swing.JButton();
        btn_verGuardias = new javax.swing.JButton();
        btn_suspenderSocios = new javax.swing.JButton();
        btn_verZonas = new javax.swing.JButton();
        btn_equiparGuardias = new javax.swing.JButton();
        btn_comprarEquipamiento = new javax.swing.JButton();
        btn_mostrarInforme = new javax.swing.JButton();
        btn_v_s_s = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_Volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(47, 94, 141));

        btn_posicionar.setText("Posicionar Guardias");
        btn_posicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_posicionarActionPerformed(evt);
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

        btn_verZonas.setText("Ver Zonas");
        btn_verZonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verZonasActionPerformed(evt);
            }
        });

        btn_equiparGuardias.setText("Equipar Guardias");
        btn_equiparGuardias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_equiparGuardiasActionPerformed(evt);
            }
        });

        btn_comprarEquipamiento.setText("Comprar equipamiento");
        btn_comprarEquipamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comprarEquipamientoActionPerformed(evt);
            }
        });

        btn_mostrarInforme.setText("Mostrar informes");
        btn_mostrarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarInformeActionPerformed(evt);
            }
        });

        btn_v_s_s.setText("Ver Socios Suspendidos");
        btn_v_s_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_v_s_sActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(31, 50, 69));
        jPanel2.setForeground(new java.awt.Color(31, 50, 69));

        btn_Volver.setBackground(new java.awt.Color(47, 94, 141));
        btn_Volver.setText("<--");
        btn_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VolverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 232, 236));
        jLabel1.setText("Pantalla de seguridad");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Volver)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_verZonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_suspenderSocios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_verGuardias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(btn_mostrarInforme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_equiparGuardias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_comprarEquipamiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_v_s_s, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(btn_posicionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(118, 118, 118))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_verGuardias, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_posicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_suspenderSocios, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btn_v_s_s, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_verZonas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_equiparGuardias, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_mostrarInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_comprarEquipamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VolverActionPerformed
        Main vM = new Main();
        vM.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btn_VolverActionPerformed
    
    private void btn_suspenderSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suspenderSociosActionPerformed
        Suspender_socio_interface vS= new Suspender_socio_interface();
        vS.setVisible(true);
        this.setVisible(false);
        vS.setSize(700,430);
        vS.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btn_suspenderSociosActionPerformed

    private void btn_verGuardiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verGuardiasActionPerformed
        Ver_Guardias VerGuardias=new Ver_Guardias();
        VerGuardias.setVisible(true);
        this.setVisible(false);
        VerGuardias.setSize(700,430);
        VerGuardias.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_verGuardiasActionPerformed

    private void btn_verZonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verZonasActionPerformed
        
        Ver_Zonas VerZonas=new Ver_Zonas();
        VerZonas.setVisible(true);
        this.setVisible(false);
        VerZonas.setSize(700,430);
        VerZonas.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_verZonasActionPerformed

    private void btn_v_s_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_v_s_sActionPerformed
        Ver_Socios_Suspendidos V_S_S=new Ver_Socios_Suspendidos();
        V_S_S.setVisible(true);
        this.setVisible(false);
        V_S_S.setSize(700,430);
        V_S_S.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_v_s_sActionPerformed

    private void btn_comprarEquipamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_comprarEquipamientoActionPerformed
        Pantalla_eleccion cE=new Pantalla_eleccion();
        cE.setVisible(true);
        this.setVisible(false);
        cE.setSize(700,430);
        cE.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_comprarEquipamientoActionPerformed

    private void btn_mostrarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarInformeActionPerformed
        Mostrar_Informe mI=new Mostrar_Informe();
        mI.setVisible(true);
        this.setVisible(false);
        mI.setSize(700,430);
        mI.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_mostrarInformeActionPerformed

    private void btn_equiparGuardiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_equiparGuardiasActionPerformed
        Pantalla_Guardias pG=new Pantalla_Guardias();
        pG.setVisible(true);
        this.setVisible(false);
        pG.setSize(700,430);
        pG.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_equiparGuardiasActionPerformed

    private void btn_posicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_posicionarActionPerformed
        Ver_Zonas_Guardia vZg=new Ver_Zonas_Guardia();
        vZg.setVisible(true);
        this.setVisible(false);
        vZg.setSize(700,430);
        vZg.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_posicionarActionPerformed

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
    private javax.swing.JButton btn_equiparGuardias;
    private javax.swing.JButton btn_mostrarInforme;
    private javax.swing.JButton btn_posicionar;
    private javax.swing.JButton btn_suspenderSocios;
    private javax.swing.JButton btn_v_s_s;
    private javax.swing.JButton btn_verGuardias;
    private javax.swing.JButton btn_verZonas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}                                          
  
