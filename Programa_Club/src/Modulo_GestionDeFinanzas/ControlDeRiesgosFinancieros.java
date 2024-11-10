/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_GestionDeFinanzas;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author tm_galli
 */
public class ControlDeRiesgosFinancieros extends javax.swing.JFrame {
    Object[][] datosRiesgos = ObtenerRiesgos();
    String[] columnNames = {"Tipo","Riesgo","Causa","Descripcion", "ID origen"};
    
    public ControlDeRiesgosFinancieros() {
        initComponents();
        ObtenerRiesgos();
        CargaAutomatica();
    }
    
    private Object[][] tableToArray(JTable table) {
        int rowCount = table.getRowCount();
        int columnCount = table.getColumnCount();

        // Crear un array bidimensional
        Object[][] dataArray = new Object[rowCount][columnCount];

        // Llenar el array con los valores de la tabla
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                dataArray[i][j] = table.getValueAt(i, j);
            }
        }

        return dataArray;
    }
    
    public void CargaAutomatica() {
        DefaultTableModel modelo = new DefaultTableModel(datosRiesgos, columnNames);
        
        this.jTable2.setModel(modelo);
    }
    
    public Object[][] ObtenerRiesgos() {
        PlanificacionFinanciera ventanamain = new PlanificacionFinanciera();

        Object[][] CobrosTableArray = tableToArray(ventanamain.CobrosTable);
        Object[][] PagosTableArray = tableToArray(ventanamain.PagosTable);
        Object[][] MovimientoTableArray = tableToArray(ventanamain.MovimientoTable);
        Object[][] CuentaTableArray = tableToArray(ventanamain.CuentaTable);
        Object[][] ImpuestosTableArray = tableToArray(ventanamain.ImpuestosTable);
        Object[][] InversionesTableArray = tableToArray(ventanamain.InversionesTable);

        List<Object[]> ErroresList = new ArrayList<>();

        for (Object[] columna : PagosTableArray) {
            if (columna[1] instanceof Number) {
                Number value = (Number) columna[1];
                String id = columna[0] instanceof String ? (String) columna[0] : columna[0].toString();
                if (value.floatValue() >= 10000 && value.floatValue() < 100000) {
                    ErroresList.add(new Object[]{"Posible robo o fraude", "Leve", "Mucho dinero pagado", "", id});
                } else if (value.floatValue() >= 100000 && value.floatValue() < 1000000) {
                    ErroresList.add(new Object[]{"Posible robo o fraude", "Grave", "Mucho dinero pagado", "", id});
                } else if (value.floatValue() >= 1000000) {
                    ErroresList.add(new Object[]{"Posible robo o fraude", "!Muy grave!", "Mucho dinero pagado", "", id});
                }
            }
        }

        for (Object[] columna : CobrosTableArray) {
            String id = columna[0] instanceof String ? (String) columna[0] : columna[0].toString();
            if (columna[3] == null || "".equals(columna[3])) {
                ErroresList.add(new Object[]{"Cobro sospechoso", "Leve", "No tiene motivo", "", id});
            }
        }

        for (Object[] columna : MovimientoTableArray) {
            String id = columna[0] instanceof String ? (String) columna[0] : columna[0].toString();
            if (columna[2] == null || "".equals(columna[2])) {
                ErroresList.add(new Object[]{"Movimiento sospechoso", "Leve", "No tiene motivo", "", id});
            }
        }
        
        for (Object[] columna : CuentaTableArray) {
            String id = columna[0] instanceof String ? (String) columna[0] : columna[0].toString();
            if (columna[2] == null || "".equals(columna[2])) {
                ErroresList.add(new Object[]{"Error en la cuenta", "Grave", "Cuanta sin CBU", "", id});
            }
            if (Double.parseDouble(columna[1].toString()) == 0.0) {
                ErroresList.add(new Object[]{"Problema en la cuenta", "Grave", "Cuenta sin dinero", "", id});
            }
        }
        for (Object[] columna : ImpuestosTableArray) {
            if (columna[1] instanceof Number) {
                Number value = (Number) columna[1];
                String id = columna[0] instanceof String ? (String) columna[0] : columna[0].toString();
                    if (value.floatValue() >= 100 && value.floatValue() < 200) {
                        ErroresList.add(new Object[]{"Posible robo o fraude", "Leve", "Impuesto exesivo", "", id});
                    } else if (value.floatValue() >= 200 && value.floatValue() < 300) {
                        ErroresList.add(new Object[]{"Posible robo o fraude", "Grave", "Impuesto exesivo", "", id});
                    } else if (value.floatValue() >= 300) {
                        ErroresList.add(new Object[]{"Posible robo o fraude", "!Muy grave!", "Impuesto exesivo", "", id});
                    }
            }
        }
        for (Object[] columna : InversionesTableArray) {
            if (columna[1] instanceof Number) {
                Number value = (Number) columna[1];
                String id = columna[0] instanceof String ? (String) columna[0] : columna[0].toString();
                    if (value.floatValue() >= 100000 && value.floatValue() < 200000) {
                        ErroresList.add(new Object[]{"Posible robo o fraude", "Leve", "Inversion exesiva", "", id});
                    } else if (value.floatValue() >= 200000 && value.floatValue() < 300000) {
                        ErroresList.add(new Object[]{"Posible robo o fraude", "Grave", "Inversion exesiva", "", id});
                    } else if (value.floatValue() >= 300000) {
                        ErroresList.add(new Object[]{"Posible robo o fraude", "!Muy grave!", "Inversion exesiva", "", id});
                    }
                if (columna[2] == null || "".equals(columna[2])) {
                    ErroresList.add(new Object[]{"Posible robo o fraude", "Grave", "Inversion sin descripción", "", id});
                }
            }
        }
        

        // Convertir la lista a un array bidimensional
        Object[][] Errores = new Object[ErroresList.size()][];
        Errores = ErroresList.toArray(Errores);

        return Errores;
    }

    /**
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        TipoOrden = new javax.swing.JComboBox<>();
        SalirButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(31, 50, 69));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setFont(new java.awt.Font("Waree", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(245, 246, 247));
        jLabel1.setText("CONTROL DE RIESGOS FINANCIEROS");
        jLabel1.setPreferredSize(new java.awt.Dimension(180, 17));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Waree", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(31, 50, 31));
        jLabel3.setText("RIESGOS POSIBLES");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Tipo", "Riesgo", "Causa", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jLabel4.setFont(new java.awt.Font("Waree", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(31, 50, 31));
        jLabel4.setText("Ordenar por:");

        TipoOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo", "Cant riesgo", "Causa" }));
        TipoOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoOrdenActionPerformed(evt);
            }
        });

        SalirButton.setText("Salir");
        SalirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SalirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(TipoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TipoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(SalirButton)
                .addGap(26, 26, 26))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TipoOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoOrdenActionPerformed
    
        String selectedOption = (String) TipoOrden.getSelectedItem();  

        int filas = datosRiesgos.length;
        int columnas = datosRiesgos[0].length;

        switch (selectedOption) {
            case "Tipo":
                // Acción para la Opción 1
                System.out.println("Seleccionaste Opción 1");
                for (int i = 0; i < filas - 1; i++) {
                    for (int j = i + 1; j < filas; j++) {
                        // Comparamos el valor de la columna 2 (índice 1)
                        String valor1 = (String) datosRiesgos[i][0]; // Valor en la fila i y columna 2
                        String valor2 = (String) datosRiesgos[j][0]; // Valor en la fila j y columna 2

                        // Si el valor en la fila i es mayor que el valor en la fila j, intercambiamos las filas
                        if (valor1.compareTo(valor2) > 0) {
                            // Intercambiar las filas
                            Object[] temp = datosRiesgos[i];
                            datosRiesgos[i] = datosRiesgos[j];
                            datosRiesgos[j] = temp;
                        }
                    }
                }

                break;
            case "Cant riesgo":
                // Acción para la Opción 2
                System.out.println("Seleccionaste Opción 2");

                for (int i = 0; i < filas - 1; i++) {
                    for (int j = i + 1; j < filas; j++) {
                        // Comparamos el valor de la columna 2 (índice 1)
                        String valor1 = (String) datosRiesgos[i][1]; // Valor en la fila i y columna 2
                        String valor2 = (String) datosRiesgos[j][1]; // Valor en la fila j y columna 2

                        // Si el valor en la fila i es mayor que el valor en la fila j, intercambiamos las filas
                        if (valor1.compareTo(valor2) > 0) {
                            // Intercambiar las filas
                            Object[] temp = datosRiesgos[i];
                            datosRiesgos[i] = datosRiesgos[j];
                            datosRiesgos[j] = temp;
                        }
                    }
                }
                break;
            case "Causa":
                // Acción para la Opción 3
                System.out.println("Seleccionaste Opción 3");
                for (int i = 0; i < filas - 1; i++) {
                    for (int j = i + 1; j < filas; j++) {
                        // Comparamos el valor de la columna 2 (índice 1)
                        String valor1 = (String) datosRiesgos[i][2]; // Valor en la fila i y columna 2
                        String valor2 = (String) datosRiesgos[j][2]; // Valor en la fila j y columna 2

                        // Si el valor en la fila i es mayor que el valor en la fila j, intercambiamos las filas
                        if (valor1.compareTo(valor2) > 0) {
                            // Intercambiar las filas
                            Object[] temp = datosRiesgos[i];
                            datosRiesgos[i] = datosRiesgos[j];
                            datosRiesgos[j] = temp;
                        }
                    }
                }
                break;
            default:
                // Acción por defecto
                System.out.println("Opción no reconocida");
                break;
        }
        CargaAutomatica();
    }//GEN-LAST:event_TipoOrdenActionPerformed

    private void SalirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirButtonActionPerformed
        // TODO add your handling code here:
        PlanificacionFinanciera GesFin= new PlanificacionFinanciera();
        GesFin.setVisible(true);
        this.setVisible(false);
        GesFin.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_SalirButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ControlDeRiesgosFinancieros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlDeRiesgosFinancieros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlDeRiesgosFinancieros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlDeRiesgosFinancieros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlDeRiesgosFinancieros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SalirButton;
    private javax.swing.JComboBox<String> TipoOrden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
