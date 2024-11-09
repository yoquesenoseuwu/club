package Modulo_Seguridad.Comprar_equip;

import Modulo_Seguridad.Conexion_Bdd_Seguridad;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Base64;
import javax.swing.ImageIcon;

/**
 *
 * @author HP OMEN
 */
public class Pantalla_Equipo extends javax.swing.JFrame {
    //Crea una conexion con el codigo, con la bdd y crea las variables de bandera
    Com_equip_codigo CeC = new Com_equip_codigo();
    Conexion_Bdd_Seguridad conexion = new Conexion_Bdd_Seguridad();
    boolean bandera=true;
    int ID_Guardar;
    int Precio;
    String[] nombre_vec;

    public Pantalla_Equipo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Imagen = new javax.swing.JLabel();
        btn_Volver1 = new javax.swing.JButton();
        Nom = new javax.swing.JLabel();
        Descri = new javax.swing.JLabel();
        Lin = new javax.swing.JLabel();
        Preci = new javax.swing.JLabel();
        cant = new javax.swing.JTextField();
        btn_comprar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/No_image.png"))); // NOI18N

        btn_Volver1.setText("<--");
        btn_Volver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Volver1ActionPerformed(evt);
            }
        });

        Nom.setText("Nombre");

        Descri.setText("Descripcion");

        Lin.setText("Link");

        Preci.setText("Precio");

        cant.setText("Cant. a comprar");
        cant.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cantFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cantFocusLost(evt);
            }
        });
        cant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantActionPerformed(evt);
            }
        });

        btn_comprar.setText("Comprar");
        btn_comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Descri, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Preci, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lin, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_Volver1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_comprar)
                            .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Volver1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(Descri)
                        .addGap(43, 43, 43)
                        .addComponent(Preci)
                        .addGap(49, 49, 49)
                        .addComponent(Lin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(95, 95, 95))
                    .addComponent(Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btn_comprar)
                .addGap(101, 101, 101))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Volver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Volver1ActionPerformed
        //Botón para volver atras
        Com_equip cE = new Com_equip();
        cE.setVisible(true);
        this.setVisible(false);
        cE.setSize(1530,900);
        cE.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_Volver1ActionPerformed

    private void cantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantActionPerformed
        
    }//GEN-LAST:event_cantActionPerformed

    private void cantFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantFocusGained
        //Si el usuario pone para escribir, se quita el texto de ejemplo y se activa la bandera
        if (bandera) {
                    cant.setText("");
                    bandera = false;
                }     
    }//GEN-LAST:event_cantFocusGained

    private void cantFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cantFocusLost
        //Si el usuario deja de escribir, se vuelve a poner el texto de ejemplo y se desactiva la bandera
        if(cant.getText().isEmpty()){
            cant.setText("Cant. a comprar");
            bandera = true;
        }
    }//GEN-LAST:event_cantFocusLost

    private void btn_comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_comprarActionPerformed
        //Se selecciona para comprar
        int canti = Integer.parseInt(cant.getText());
        conexion.Insert_pedido_equipamiento(nombre_vec[1],canti,ID_Guardar,Precio);
        btn_Volver1ActionPerformed(evt);
    }//GEN-LAST:event_btn_comprarActionPerformed

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
            java.util.logging.Logger.getLogger(Pantalla_Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla_Equipo().setVisible(true);
            }
        });
    }
    
    public void agregar_equipo(int Id){
        ID_Guardar=Id;
        ArrayList<String> array=conexion.Select_Equipo_con_Imagen(Id);
        
        
        String[] str=array.toArray(new String[0]);
        if (str[5] != null){
        
        byte[] ByteImage=Base64.getDecoder().decode(str[5]);
        
         
            // Crear un ImageIcon desde los bytes de la imagen
            ImageIcon imageIcon = new ImageIcon(ByteImage);

            // Escalar la imagen para que se ajuste al JLabel (opcional)
            Image scaledImage = imageIcon.getImage().getScaledInstance(Imagen.getWidth(), Imagen.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            // Crear JLabel y colocar la imagen
            Imagen.setIcon(scaledIcon);
        } else {
            
        }
       
        
        String Nombre=array.get(1);
        Nom.setText(Nombre);
        
        nombre_vec=Nombre.split("=");
        
        String Descripcion=array.get(2);
        Descri.setText(Descripcion);
        
        String precio=(String) array.get(3);
        Preci.setText(precio);
        
        Precio=Integer.parseInt(precio);
        
        String Link=array.get(4);
        Lin.setText(Link);
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Descri;
    private javax.swing.JLabel Imagen;
    private javax.swing.JLabel Lin;
    private javax.swing.JLabel Nom;
    private javax.swing.JLabel Preci;
    private javax.swing.JButton btn_Volver1;
    private javax.swing.JButton btn_comprar;
    private javax.swing.JTextField cant;
    // End of variables declaration//GEN-END:variables
}
