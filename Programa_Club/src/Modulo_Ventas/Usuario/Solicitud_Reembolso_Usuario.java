/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas.Usuario;
import Modulo_Ventas.Usuario.Reembolso_Usuario;
import Modulo_Ventas.Pantalla_Ventas;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AttributeSet;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;


/**
 *
 * @author tm_galli
 */
public class Solicitud_Reembolso_Usuario extends javax.swing.JFrame {
    private Reembolso_Usuario objetoReembolso = new Reembolso_Usuario();
    private String usuarioID; // Variable para almacenar el ID del usuario
    private String IDPedidoSeleccionado;
    private Reembolso_Usuario reembolsoUsuario;
    private boolean updating = false;

    /**
     * Creates new form Gestion_Reembolso_Usuario
     */
    public Solicitud_Reembolso_Usuario(String usuarioID) {
        initComponents();
        this.usuarioID = usuarioID;
        reembolsoUsuario = new Reembolso_Usuario();
        reembolsoUsuario.MostrarProductos(TablaPedidos, usuarioID);
        datechooser_Fecha.setDate(new java.util.Date()); 
        datechooser_Fecha.setVisible(false);
        JTextField_ID.setVisible(false); 
        JTextField_Nombre.setEnabled(false);
        JTextField_Categoria.setEnabled(false);
        JTextField_Precio.setEnabled(false);
        JTextField_Cantidad.setEnabled(false); 
        // Al inicializar, aseguramos que el botón esté deshabilitado
        habilitarBotonConfirmar();

       ((AbstractDocument) JTextField_Motivo.getDocument()).setDocumentFilter(new LetrasSoloLimitFilter(16));
       // Asumiendo que TablaPedidos es tu JTable
        TablaPedidos.getSelectionModel().addListSelectionListener(e -> habilitarBotonConfirmar());
        JTextField_Motivo.getDocument().addDocumentListener(new DocumentListener() {
    public void insertUpdate(DocumentEvent e) {
        habilitarBotonConfirmar();
    }

    public void removeUpdate(DocumentEvent e) {
        habilitarBotonConfirmar();
    }

    public void changedUpdate(DocumentEvent e) {
        habilitarBotonConfirmar();
    }
});
    // Se agrega un DocumentListener para validar el campo de Motivo en tiempo real
    JTextField_Motivo.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            validarMotivo(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            validarMotivo(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            validarMotivo(e);
        }
    });
}

// Método de validación para el campo Motivo
public void validarMotivo(DocumentEvent e) {
    if (updating) return;  // Evitar recursividad si estamos actualizando el campo

    try {
        updating = true; // Iniciar la actualización
        String text = JTextField_Motivo.getText(); // Obtener el texto del campo

        // Validar si el texto contiene números
        if (text.matches(".*\\d.*")) { // Si contiene números
            // Si contiene números, limpiamos el campo o ponemos un mensaje de advertencia
            JTextField_Motivo.setText(""); // Ejemplo: Limpiar el texto
            JOptionPane.showMessageDialog(this, "El motivo no puede contener números.", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        // También puedes agregar más validaciones si es necesario (por ejemplo, para textos vacíos).
    } finally {
        updating = false; // Restablecer el flag
    }
}

// Clase para permitir solo letras y limitar la longitud a un máximo de caracteres
private class LetrasSoloLimitFilter extends DocumentFilter {
    private final int maxLength;

    public LetrasSoloLimitFilter(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (fb.getDocument().getLength() + string.length() <= maxLength && string.matches("[a-zA-ZáéíóúÁÉÍÓÚ]+")) {
            super.insertString(fb, offset, string, attr);
        } else {
            Toolkit.getDefaultToolkit().beep(); // Da una señal si se intenta ingresar caracteres no válidos
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (fb.getDocument().getLength() - length + text.length() <= maxLength && text.matches("[a-zA-ZáéíóúÁÉÍÓÚ]+")) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            Toolkit.getDefaultToolkit().beep(); // Da una señal si se intenta ingresar caracteres no válidos
        }
    }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JTextField_ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JTextField_Nombre = new javax.swing.JTextField();
        JTextField_Precio = new javax.swing.JTextField();
        JTextField_Motivo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        datechooser_Fecha = new com.toedter.calendar.JDateChooser();
        Btn_Confirmar = new javax.swing.JButton();
        JTextField_Categoria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JTextField_Cantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPedidos = new javax.swing.JTable();
        VolverPantalla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Solicitud de Reembolso"));

        jLabel2.setText("Nombre");

        jLabel3.setText("Precio");

        jLabel4.setText("Motivo");

        Btn_Confirmar.setText("Reembolsar");
        Btn_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ConfirmarActionPerformed(evt);
            }
        });

        jLabel5.setText("Categoria");

        jLabel6.setText("Cantidad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(datechooser_Fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(JTextField_ID))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(JTextField_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(jLabel2))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(JTextField_Motivo))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(JTextField_Categoria, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(JTextField_Precio, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(JTextField_Cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Btn_Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(JTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextField_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextField_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextField_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextField_Motivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datechooser_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_Confirmar)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        TablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaPedidos);

        VolverPantalla.setText("<--");
        VolverPantalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverPantallaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(470, 470, 470))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(VolverPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(VolverPantalla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void habilitarBotonConfirmar() {
    boolean pedidoSeleccionado = TablaPedidos.getSelectedRow() != -1; // Verifica si hay una fila seleccionada
    boolean motivoEscrito = !JTextField_Motivo.getText().trim().isEmpty(); // Verifica si el campo de texto no está vacío

    // Habilitar o deshabilitar el botón según las condiciones
    Btn_Confirmar.setEnabled(pedidoSeleccionado && motivoEscrito);
}
    private void Btn_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ConfirmarActionPerformed
        objetoReembolso.InsertarMotivo(JTextField_Motivo, datechooser_Fecha);
        JTextField_Nombre.setText(""); // Limpia el campo de texto
        JTextField_Precio.setText("");
        JTextField_Categoria.setText("");
        JTextField_Cantidad.setText("");  
        JTextField_Motivo.setText("");

    // También puedes deshabilitar el botón "Confirmar" nuevamente
        Btn_Confirmar.setEnabled(false);

    // Opcionalmente, también puedes deseleccionar cualquier fila en la tabla de pedidos
        TablaPedidos.clearSelection();
        reembolsoUsuario.MostrarProductos(TablaPedidos, usuarioID);

    }//GEN-LAST:event_Btn_ConfirmarActionPerformed

    private void VolverPantallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverPantallaActionPerformed
        Menu_Usuario mU= new Menu_Usuario(usuarioID);
        this.setVisible(false);
        mU.setSize(500,500);
        mU.setLocationRelativeTo(null);
        mU.setVisible(true);
    }//GEN-LAST:event_VolverPantallaActionPerformed

    private void TablaPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPedidosMouseClicked
        int filaSeleccionada = TablaPedidos.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idPedido = Integer.parseInt(TablaPedidos.getValueAt(filaSeleccionada, 0).toString());
            System.out.println("IDPedido seleccionado: " + idPedido);

            objetoReembolso.setIDPedidoSeleccionado(idPedido);
            objetoReembolso.SeleccionarProducto(TablaPedidos, JTextField_ID, JTextField_Nombre, JTextField_Precio, JTextField_Categoria, JTextField_Cantidad);
    }
    }//GEN-LAST:event_TablaPedidosMouseClicked

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
            java.util.logging.Logger.getLogger(Solicitud_Reembolso_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Solicitud_Reembolso_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Solicitud_Reembolso_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Solicitud_Reembolso_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Confirmar;
    private javax.swing.JTextField JTextField_Cantidad;
    private javax.swing.JTextField JTextField_Categoria;
    private javax.swing.JTextField JTextField_ID;
    private javax.swing.JTextField JTextField_Motivo;
    private javax.swing.JTextField JTextField_Nombre;
    private javax.swing.JTextField JTextField_Precio;
    private javax.swing.JTable TablaPedidos;
    private javax.swing.JButton VolverPantalla;
    private com.toedter.calendar.JDateChooser datechooser_Fecha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
