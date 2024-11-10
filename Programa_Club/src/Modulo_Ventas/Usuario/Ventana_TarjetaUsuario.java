/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas.Usuario;
import Modulo_Ventas.Usuario.Gestion_Compra_Usuario;
import javax.swing.JOptionPane;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;

/**
 *
 * @author gabiv
 */
public class Ventana_TarjetaUsuario extends javax.swing.JFrame {
    private String usuarioID; // Variable para almacenar el ID del usuario
    private String productoID;
    private String fecha; 
    private int cantidadSeleccionada;
    private String opcFormaEntrega;
    
    private String tipoTarjeta;
    private String nombreTitular;
    private String codigoSeguridad;
    private String numerinTarjeta;
    //estas variables verifican que la tarjeta sea valida y no este vencida para pasar a la siguiente ventana
    private boolean condicion1 = false;
    private boolean condicion2 = false;
    /**
     * Creates new form Ventana_TarjetaDebito
     */
    public Ventana_TarjetaUsuario(String usuarioID, String productoID, String fecha, int cantidadSeleccionada, String opcionFormaEntrega) {
        this.usuarioID = usuarioID;
        this.productoID = productoID;
        this.fecha = fecha;
        this.cantidadSeleccionada = cantidadSeleccionada;
        this.opcFormaEntrega = opcionFormaEntrega;

        
        initComponents();
        //Añáde los items al combobox del tipo de tarjeta
        Combo_TipoTarjeta.addItem("Debito");
        Combo_TipoTarjeta.addItem("Credito");
        Btn_Guardar.setEnabled(false);
        // Para JTextField_NumTarjeta (en caso de que uses la validación de la tarjeta aquí)
JTextField_NumTarjeta.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent e) {
        verificarCampos();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        verificarCampos();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        verificarCampos();
    }
});

// Para JTextField_NombreTitular
JTextField_NombreTitular.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent e) {
        verificarCampos();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        verificarCampos();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        verificarCampos();
    }
});

// Para JTextField_Mes
JTextField_Mes.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent e) {
        verificarCampos();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        verificarCampos();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        verificarCampos();
    }
});

// Para JTextField_Anio
JTextField_Anio.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent e) {
        verificarCampos();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        verificarCampos();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        verificarCampos();
    }
});

// Para JTextField_CodigoSeguridad
JTextField_CodigoSeguridad.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent e) {
        verificarCampos();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        verificarCampos();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        verificarCampos();
    }
});

        JTextField_CodigoSeguridad.setDocument(new PlainDocument() {
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        // Solo permitimos dígitos
        if (str.matches("[0-9]*")) {
            // Limitar a 3 caracteres
            if (getLength() + str.length() <= 3) {
                super.insertString(offs, str, a);
            }
        }
    }
});

        JTextField_Mes.setDocument(new PlainDocument() {
    private static final int MAX_LENGTH = 2;

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }

        // Validar que solo se acepten números y que no se supere la longitud máxima
        if ((getLength() + str.length()) <= MAX_LENGTH && str.matches("[0-9]*")) {
            super.insertString(offs, str, a);

            // Validar que el número esté en el rango de 01 a 12
            String inputText = JTextField_Mes.getText();
            if (!inputText.isEmpty()) {
                int month = Integer.parseInt(inputText);
                if (month < 1 || month > 12) {
                    // Si el número no está en el rango, revertir el cambio
                    JTextField_Mes.setText(inputText.substring(0, inputText.length() - 1));
                }
            }
        }
    }
});
JTextField_Anio.addKeyListener(new java.awt.event.KeyAdapter() {
    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        String inputText = JTextField_Anio.getText();

        // Limitar la longitud a 2 caracteres
        if (inputText.length() > 2) {
            JTextField_Anio.setText(inputText.substring(0, 2)); // Limitar a 2 caracteres
            return;
        }

        // Verificar si el texto tiene exactamente 2 caracteres
        if (inputText.length() == 2) {
            try {
                int year = Integer.parseInt(inputText); // Convertir a número

                // Validar que el año sea mayor a 23
                if (year <= 23) {
                    JOptionPane.showMessageDialog(null, "El año debe ser mayor a 23.");
                    JTextField_Anio.setText(""); // Limpiar el campo si es menor o igual a 23
                }
            } catch (NumberFormatException ex) {
                // Si el texto no es un número válido, ignoramos la entrada
                // No hacer nada
            }
        }
    }
});



        JTextField_NombreTitular.setDocument(new PlainDocument() {
    private static final int MAX_LENGTH = 40;

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }

        // Validar que solo se acepten letras y que no se supere la longitud máxima
        if ((getLength() + str.length()) <= MAX_LENGTH && str.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]*")) {
            super.insertString(offs, str, a);
        }
    }
});

        JTextField_NumTarjeta.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                // Solo permitimos dígitos
                if (str.matches("[0-9]*")) {
                    super.insertString(offs, str, a);
                }
            }
        });
        JTextField_NumTarjeta.setDocument(new PlainDocument() {
    private static final int MAX_LENGTH = 16;

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }

        // Validar que solo se acepten dígitos y que no se supere la longitud máxima
        if ((getLength() + str.length()) <= MAX_LENGTH && str.matches("[0-9]*")) {
            super.insertString(offs, str, a);
        }
    }
});






        /*esto sirve para llamar a la funcion de validacion cuando el usuario termino de escribir el numero
        de tarjeta*/
        JTextField_NumTarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent e) {
                String inputText = JTextField_NumTarjeta.getText();
                
                if (inputText.length() == 16) {
                    Tarjeta_Usuario tarjetitaUsuario = new Tarjeta_Usuario();
                    if(tarjetitaUsuario.AnalizarEmpresa(JTextField_NumTarjeta)){
                        condicion1 = true;
                    }
                }
            }
        });
        //=============
        //lo siguiente hace lo mismo que lo anterior pero con la fecha de vencimiento
        JTextField_Anio.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyReleased(java.awt.event.KeyEvent e) {
                            String mes = JTextField_Mes.getText();
                            String anio = JTextField_Anio.getText();
                            // Verificamos si ambos campos están completos: mes tiene 2 caracteres y año 4
                            if (mes.length() == 2 && anio.length() == 2) {
                                        Tarjeta_Usuario tarjetitaUsuario = new Tarjeta_Usuario();       
                                        if(tarjetitaUsuario.VerificarVencimiento(JTextField_Mes, JTextField_Anio)){
                                            condicion2 = true;
                                        }
                            }
                }
        });
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
        Volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JTextField_NumTarjeta = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JTextField_NombreTitular = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        JTextField_Mes = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JTextField_Anio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        JTextField_CodigoSeguridad = new javax.swing.JTextField();
        Btn_Guardar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Combo_TipoTarjeta = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Volver.setText("<-----");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        jLabel1.setText("INGRESE DATOS DE TARJETA ");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("NUMERO DE TARJETA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JTextField_NumTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(JTextField_NumTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setText("APELLIDO Y NOMBRE DEL TITULAR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTextField_NombreTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTextField_NombreTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setText("FECHA DE VENCIMIENTO");

        jLabel6.setText("/");

        jLabel7.setText("MES / AÑO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(JTextField_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextField_Anio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel7)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextField_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextField_Anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setText("CODIGO DE SEGURIDAD");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(JTextField_CodigoSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTextField_CodigoSeguridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        Btn_Guardar.setText("CONTINUAR");
        Btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_GuardarActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel8.setText("TIPO DE TARJETA");

        Combo_TipoTarjeta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Combo_TipoTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addComponent(Combo_TipoTarjeta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Volver)
                        .addGap(79, 79, 79)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(Btn_Guardar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Volver)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Btn_Guardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //=======================================================================================
private void verificarCampos() {
    // Verifica si todos los campos están correctamente validados
    boolean isValid = true;

    // Verificar tarjeta
    String tarjeta = JTextField_NumTarjeta.getText().replaceAll(" ", ""); // Eliminar los espacios
    if (tarjeta.length() != 16 || !tarjeta.matches("[0-9]{16}")) {
        isValid = false;
    }

    // Verificar nombre titular
    String nombreTitular = JTextField_NombreTitular.getText();
    if (nombreTitular.isEmpty() || nombreTitular.length() > 40) {
        isValid = false;
    }

    // Verificar mes
    String mes = JTextField_Mes.getText();
    if (mes.length() != 2 || Integer.parseInt(mes) < 1 || Integer.parseInt(mes) > 12) {
        isValid = false;
    }

    // Verificar año (debe ser un número de dos dígitos mayor a 23)
    String anio = JTextField_Anio.getText();
    if (anio.length() != 2 || Integer.parseInt(anio) < 24) {
        isValid = false;
    }

    // Verificar código de seguridad
    String codigoSeguridad = JTextField_CodigoSeguridad.getText();
    if (codigoSeguridad.length() != 3 || !codigoSeguridad.matches("[0-9]{3}")) {
        isValid = false;
    }

    // Activar o desactivar el botón
    Btn_Guardar.setEnabled(isValid);
}



    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        Ventana_FormaEntrega ventanaFormaEntrega = new Ventana_FormaEntrega(usuarioID, productoID, fecha, cantidadSeleccionada);
        this.setVisible(false);
        ventanaFormaEntrega.setSize(500, 600);
        ventanaFormaEntrega.setLocationRelativeTo(null);
        ventanaFormaEntrega.setVisible(true);
    }//GEN-LAST:event_VolverActionPerformed

    private void Btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GuardarActionPerformed
        //System.out.println("condicion1 : "+condicion1 + "--" + "condicion2 :" + condicion2);
        //Esto sirve para que si la tarjeta es valida y no está vencida pueda continuar
        /*if(condicion1 == true && condicion2 == true){
                  tipoTarjeta = (String)cmbox_TipoTarjeta.getSelectedItem();
                  numerinTarjeta = textField_NumTarjeta.getText();
                  nombreTitular = textField_NombreTitular.getText();
                  codigoSeguridad = textField_CodigoSeguridad.getText();
            
                  Ventana_FinalizarCompra ventanaFinCompra = new Ventana_FinalizarCompra(usuarioID, productoID, fecha, cantidadSeleccionada, opcFormaEntrega,tipoTarjeta, numerinTarjeta, nombreTitular, codigoSeguridad);
                  this.setVisible(false);
                  ventanaFinCompra.setSize(550, 650);
                  ventanaFinCompra.setLocationRelativeTo(null);
                  ventanaFinCompra.setVisible(true); 
            condicion1 = false;
            condicion2 = false;
        }else{
            JOptionPane.showMessageDialog(null,"Ups, verifica que los datos de la tarjeta sean correctos para continuar");
        }*/
    }//GEN-LAST:event_Btn_GuardarActionPerformed
    //========================================================================================
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
            java.util.logging.Logger.getLogger(Ventana_TarjetaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_TarjetaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_TarjetaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_TarjetaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fol
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Guardar;
    private javax.swing.JComboBox<String> Combo_TipoTarjeta;
    private javax.swing.JTextField JTextField_Anio;
    private javax.swing.JTextField JTextField_CodigoSeguridad;
    private javax.swing.JTextField JTextField_Mes;
    private javax.swing.JTextField JTextField_NombreTitular;
    private javax.swing.JTextField JTextField_NumTarjeta;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
