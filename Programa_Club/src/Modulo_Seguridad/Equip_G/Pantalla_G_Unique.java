/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Seguridad.Equip_G;

import java.util.ArrayList;

/**
 *
 * @author HP OMEN
 */
public class Pantalla_G_Unique extends javax.swing.JFrame {
    
    Pantalla_G_Unique_Codigo pGuC=new Pantalla_G_Unique_Codigo();
    ArrayList<String> array_usado;
    ArrayList<String> array_sin_usar;
    String Nombre;
    int Id;
    public Pantalla_G_Unique() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Volver1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Jnombre = new javax.swing.JLabel();
        Equipo3 = new javax.swing.JLabel();
        Equipo1 = new javax.swing.JLabel();
        Equipo2 = new javax.swing.JLabel();
        Combo3 = new javax.swing.JComboBox<>();
        Combo2 = new javax.swing.JComboBox<>();
        Eliminar1 = new javax.swing.JButton();
        Combo1 = new javax.swing.JComboBox<>();
        Eliminar2 = new javax.swing.JButton();
        Eliminar3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_Volver1.setText("<--");
        btn_Volver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Volver1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/humano.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        Jnombre.setText("jLabel2");

        Equipo3.setText("jLabel2");

        Equipo1.setText("jLabel2");

        Equipo2.setText("jLabel2");

        Combo3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ponga un nuevo equipo" }));
        Combo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo3ActionPerformed(evt);
            }
        });

        Combo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ponga un nuevo equipo" }));
        Combo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo2ActionPerformed(evt);
            }
        });

        Eliminar1.setText("Eliminar equipamiento1");
        Eliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar1ActionPerformed(evt);
            }
        });

        Combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ponga un nuevo equipo" }));
        Combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo1ActionPerformed(evt);
            }
        });

        Eliminar2.setText("Eliminar equipamiento2");
        Eliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar2ActionPerformed(evt);
            }
        });

        Eliminar3.setText("Eliminar equipamiento3");
        Eliminar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar3ActionPerformed(evt);
            }
        });

        jButton1.setText("Quitar todo el Equipo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Volver1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Equipo3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Combo3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Eliminar3, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Equipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Combo2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Eliminar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Equipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Eliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(52, 128, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Volver1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(Jnombre)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Equipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Eliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Equipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(Eliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Equipo3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Combo3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Eliminar3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(Combo2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Volver1ActionPerformed
        Pantalla_Guardias pG=new Pantalla_Guardias();
        pG.setVisible(true);
        pG.setLocationRelativeTo(null);
        this.setVisible(false);
        pG.setSize(915,395);
    }//GEN-LAST:event_btn_Volver1ActionPerformed

    private void Combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo1ActionPerformed
        Object itemSeleccionado = Combo1.getSelectedItem();
        String[] Elemento = (itemSeleccionado.toString()).split(" // ");
        
        pGuC.Insertar_equipo(Integer.parseInt(Elemento[0]),Id);
        
        Equipo1.setText(Elemento[0]+"//"+Elemento[1]);
        
        Eliminar2.setEnabled(true);
        Eliminar3.setEnabled(true);
 
        
        
        
    }//GEN-LAST:event_Combo1ActionPerformed

    private void Eliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar1ActionPerformed
        Combo1.setEnabled(true);
        Combo2.setEnabled(false);
        Combo3.setEnabled(false);
        Eliminar2.setEnabled(false);
        Eliminar3.setEnabled(false);
        if (Equipo1.getText()=="Sin Equipo"){
            
        }
        else{
        Equipo1.setText("Sin Equipo");
        String[] stri = array_usado.toArray(new String[0]);
        
        String valor1=stri[0];
        String[] valor2 = valor1.split("//");
        
        pGuC.Eliminar_datos(Integer.parseInt(valor2[1]));
        }
        array_sin_usar=pGuC.mostrar_equipo();
        for (String equipo:array_sin_usar){
            Combo1.addItem(equipo);
        }
        
        
        
        
        
        
    }//GEN-LAST:event_Eliminar1ActionPerformed

    private void Eliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar2ActionPerformed
        Combo2.setEnabled(true);
        Combo1.setEnabled(false);
        Combo3.setEnabled(false);
        Eliminar1.setEnabled(false);
        Eliminar3.setEnabled(false);
        if (Equipo2.getText()=="Sin Equipo"){
            
        }
        else{
        Equipo2.setText("Sin Equipo");
        String[] stri = array_usado.toArray(new String[0]);
        
        String valor1=stri[1];
        String[] valor2 = valor1.split("//");
        
        pGuC.Eliminar_datos(Integer.parseInt(valor2[1]));
        }
                
        array_sin_usar=pGuC.mostrar_equipo();
        for (String equipo:array_sin_usar){
            Combo2.addItem(equipo);
        }
    }//GEN-LAST:event_Eliminar2ActionPerformed

    private void Eliminar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar3ActionPerformed
        Combo2.setEnabled(false);
        Combo1.setEnabled(false);
        Combo3.setEnabled(true);
        Eliminar1.setEnabled(false);
        Eliminar2.setEnabled(false);
        if (Equipo3.getText()=="Sin Equipo"){
            
        }
        else{
        Equipo3.setText("Sin Equipo");
        String[] stri = array_usado.toArray(new String[0]);
        
        String valor1=stri[2];
        String[] valor2 = valor1.split("//");
        
        pGuC.Eliminar_datos(Integer.parseInt(valor2[1]));
        }
               
        array_sin_usar=pGuC.mostrar_equipo();
        for (String equipo:array_sin_usar){
            Combo3.addItem(equipo);
        }
    }//GEN-LAST:event_Eliminar3ActionPerformed

    private void Combo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo2ActionPerformed
        Object itemSeleccionado = Combo2.getSelectedItem();
        String[] Elemento = (itemSeleccionado.toString()).split(" // ");
        
        pGuC.Insertar_equipo(Integer.parseInt(Elemento[0]),Id);
        
        Equipo2.setText(Elemento[0]+"//"+Elemento[1]);
        
        Eliminar1.setEnabled(true);
        Eliminar3.setEnabled(true);
    }//GEN-LAST:event_Combo2ActionPerformed

    private void Combo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo3ActionPerformed
        Object itemSeleccionado = Combo3.getSelectedItem();
        String[] Elemento = (itemSeleccionado.toString()).split(" // ");
        
        pGuC.Insertar_equipo(Integer.parseInt(Elemento[0]),Id);
        
        Equipo3.setText(Elemento[0]+"//"+Elemento[1]);
        
        Eliminar2.setEnabled(true);
        Eliminar1.setEnabled(true);
    }//GEN-LAST:event_Combo3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Equipo1.setText("Sin Equipo");
        Equipo2.setText("Sin Equipo");
        Equipo3.setText("Sin Equipo");
        Combo1.setEnabled(false);
        Combo2.setEnabled(false);
        Combo3.setEnabled(false);
        
        for (int i=0; i<2;i++){
            String[] stri = array_usado.toArray(new String[0]);

            String valor1=stri[i];
            String[] valor2 = valor1.split("//");

            pGuC.Eliminar_datos(Integer.parseInt(valor2[1]));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void Cargar_Datos(int Id,String nombre){
        array_usado =pGuC.cargar_datos(Id);
        this.Id=Id;
        Jnombre.setText(Nombre);
         
        System.out.println(array_usado.size());
        String[] stri = array_usado.toArray(new String[0]);
        
        try{
            Equipo1.setText(stri[0]);
        }catch(Exception e){
            Equipo1.setText("Sin Equipo");
        }
        
        try{
            Equipo2.setText(stri[1]);
        }catch(Exception e){
            Equipo2.setText("Sin Equipo");
        }
        
        try{
            Equipo3.setText(stri[2]);
        }catch(Exception e){
            Equipo3.setText("Sin Equipo");
        }
        
        Combo1.setEnabled(false);
        Combo2.setEnabled(false);
        Combo3.setEnabled(false);
    }
    
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
            java.util.logging.Logger.getLogger(Pantalla_G_Unique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla_G_Unique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla_G_Unique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla_G_Unique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla_G_Unique().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo1;
    private javax.swing.JComboBox<String> Combo2;
    private javax.swing.JComboBox<String> Combo3;
    private javax.swing.JButton Eliminar1;
    private javax.swing.JButton Eliminar2;
    private javax.swing.JButton Eliminar3;
    private javax.swing.JLabel Equipo1;
    private javax.swing.JLabel Equipo2;
    private javax.swing.JLabel Equipo3;
    private javax.swing.JLabel Jnombre;
    private javax.swing.JButton btn_Volver1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
