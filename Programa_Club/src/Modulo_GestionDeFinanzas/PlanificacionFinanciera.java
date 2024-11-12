/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_GestionDeFinanzas;
import programa_club.Main;
import Modulo_GestionDeFinanzas.ControlDeRiesgosFinancieros;
import Modulo_GestionDeFinanzas.GestionDeImpuestos;
import Modulo_GestionDeFinanzas.GestionDePagosYCambios;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;
/**
 *
 * @author tm_galli
 */
public class PlanificacionFinanciera extends javax.swing.JFrame {
    
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

    public PlanificacionFinanciera() {
        MostrarTabla mostrarTablasFunc = new MostrarTabla();
        initComponents();
        
        Object[] CobrosColums = new Object[]{"id_cobro", "monto", "fk_medio", "motivo"};
        mostrarTablasFunc.MostrarTabla(CobrosTable, CobrosColums, "SELECT * FROM Cobros;");
        
        Object[] PagosColums = new Object[]{"id_pago", "monto", "fk_medio", "motivo"};
        mostrarTablasFunc.MostrarTabla(PagosTable, PagosColums, "SELECT * FROM Pagos;");
        
        Object[] MovimientosColums = new Object[]{"id_movimiento", "fk_cuenta", "descripcion"};
        mostrarTablasFunc.MostrarTabla(MovimientoTable, MovimientosColums, "SELECT * FROM Movimientos;");
        
        Object[] MedioColums = new Object[]{"id_medio", "tipo"};
        mostrarTablasFunc.MostrarTabla(MedioTable, MedioColums, "SELECT * FROM Medio;");
        
        Object[] CuentaColums = new Object[]{"id_cuenta", "saldo", "cbu", "alias"};
        mostrarTablasFunc.MostrarTabla(CuentaTable, CuentaColums, "SELECT * FROM Cuenta;");
        
        Object[] ImpuestosColums = new Object[]{"id_impuesto", "nombre", "porcentaje"};
        mostrarTablasFunc.MostrarTabla(ImpuestosTable, ImpuestosColums, "SELECT * FROM Impuestos;");
        
        Object[] InversionesColums = new Object[]{"id_inversion", "monto", "descripcion", "estado"};
        mostrarTablasFunc.MostrarTabla(InversionesTable, InversionesColums, "SELECT * FROM Inversiones;");
        
        this.setTitle("Plnaficacion financiera");
        
        Object[][] CobrosTableArray = tableToArray(CobrosTable);
        Object[][] PagosTableArray = tableToArray(PagosTable);
        Object[][] MovimientoTableArray = tableToArray(MovimientoTable);
        Object[][] MedioTableArray = tableToArray(MedioTable);
        Object[][] CuentaTableArray = tableToArray(CuentaTable);
        Object[][] ImpuestosTableArray = tableToArray(ImpuestosTable);
        Object[][] InversionesTableArray = tableToArray(InversionesTable);
        
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        PagosTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        MovimientoTable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        CobrosTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        MedioTable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        InversionesTable = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        CuentaTable = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        ImpuestosTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ImpuestosButton = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        RiesgosButton = new javax.swing.JButton();
        PagosYCambiosButton = new javax.swing.JButton();
        ControlPresupuestoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(182, 192, 199));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(31, 50, 69));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setFont(new java.awt.Font("Waree", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(245, 246, 247));
        jLabel1.setText("PLANIFICACION FINANCIERA");
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

        jPanel3.setBackground(new java.awt.Color(99, 140, 181));

        jScrollPane1.setBackground(new java.awt.Color(182, 192, 199));

        jPanel1.setBackground(new java.awt.Color(229, 232, 236));

        PagosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Short((short) 1),  new Float(100.0),  new Short((short) 1), "---"},
                { new Short((short) 2),  new Float(60000.0),  new Short((short) 2), "---"}
            },
            new String [] {
                "IdPago", "monto", "Idmedio", "motivo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.Float.class, java.lang.Short.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(PagosTable);

        MovimientoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Short((short) 1),  new Short((short) 1), "---"},
                { new Short((short) 2),  new Short((short) 2), "---"}
            },
            new String [] {
                "IdMovimiento", "IdCuenta", "descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.Short.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(MovimientoTable);

        CobrosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Short((short) 1),  new Float(100.0), "1", null},
                { new Short((short) 2),  new Float(200.0), "2", null}
            },
            new String [] {
                "IdCobros", "monto", "IdMedio", "motivo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(CobrosTable);

        MedioTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Short((short) 1), "---"},
                { new Short((short) 2), "---"}
            },
            new String [] {
                "IdMedio", "tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(MedioTable);

        InversionesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Short((short) 1),  new Float(2000.0), "---", null},
                { new Short((short) 2),  new Float(300000.0), "---", "---"}
            },
            new String [] {
                "IdInversiones", "monto", "descripcion", "estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane7.setViewportView(InversionesTable);

        CuentaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Short((short) 1),  new Float(0.0), "---", "---"},
                { new Short((short) 2),  new Float(50000.0), "---", "---"}
            },
            new String [] {
                "IdCuenta", "saldo", "cbu", "alias"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane8.setViewportView(CuentaTable);

        ImpuestosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Short((short) 1), "---",  new Float(20.0)},
                { new Short((short) 2), "---",  new Float(50.0)}
            },
            new String [] {
                "IdImpuestos", "nombre", "porcentaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane9.setViewportView(ImpuestosTable);

        jLabel2.setFont(new java.awt.Font("Waree", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(31, 50, 31));
        jLabel2.setText("COBROS");

        jLabel3.setFont(new java.awt.Font("Waree", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(31, 50, 31));
        jLabel3.setText("PAGOS");

        jLabel4.setFont(new java.awt.Font("Waree", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(31, 50, 31));
        jLabel4.setText("IMPUESTOS");

        jLabel5.setFont(new java.awt.Font("Waree", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(31, 50, 31));
        jLabel5.setText("MOVIMIENTO");

        jLabel6.setFont(new java.awt.Font("Waree", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(31, 50, 31));
        jLabel6.setText("CUENTA");

        jLabel7.setFont(new java.awt.Font("Waree", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(31, 50, 31));
        jLabel7.setText("MEDIO");

        jLabel8.setFont(new java.awt.Font("Waree", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(69, 50, 31));
        jLabel8.setText("INVERSIONES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(131, 131, 131))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(100, 100, 100))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(130, 130, 130))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        ImpuestosButton.setText("Gestion de impuestos");
        ImpuestosButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ImpuestosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImpuestosButtonActionPerformed(evt);
            }
        });

        Salir.setText("Salir");
        Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        RiesgosButton.setText("Control de riesgos financieron");
        RiesgosButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        RiesgosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RiesgosButtonActionPerformed(evt);
            }
        });

        PagosYCambiosButton.setText("Gestion de pagos y cambios");
        PagosYCambiosButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PagosYCambiosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagosYCambiosButtonActionPerformed(evt);
            }
        });

        ControlPresupuestoButton.setText("Control de presupuesto");
        ControlPresupuestoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ControlPresupuestoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ControlPresupuestoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PagosYCambiosButton, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(RiesgosButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ImpuestosButton, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(ControlPresupuestoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImpuestosButton)
                    .addComponent(RiesgosButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PagosYCambiosButton)
                    .addComponent(ControlPresupuestoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Salir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PagosYCambiosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagosYCambiosButtonActionPerformed

        new GestionDePagosYCambios().setVisible(true);
        dispose();
    }//GEN-LAST:event_PagosYCambiosButtonActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        new programa_club.Main().setVisible(true);
        dispose();

    }//GEN-LAST:event_SalirActionPerformed

    private void ImpuestosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImpuestosButtonActionPerformed
        // TODO add your handling code here:
        new GestionDeImpuestos().setVisible(true);
        dispose();
    }//GEN-LAST:event_ImpuestosButtonActionPerformed

    private void RiesgosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RiesgosButtonActionPerformed
        // TODO add your handling code here:
        new ControlDeRiesgosFinancieros().setVisible(true);
        dispose();
    }//GEN-LAST:event_RiesgosButtonActionPerformed

    private void ControlPresupuestoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ControlPresupuestoButtonActionPerformed
        // TODO add your handling code here:
        new ControlDePresupuesto().setVisible(true);
        dispose();
    }//GEN-LAST:event_ControlPresupuestoButtonActionPerformed

    
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
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlanificacionFinanciera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlanificacionFinanciera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlanificacionFinanciera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlanificacionFinanciera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlanificacionFinanciera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable CobrosTable;
    private javax.swing.JButton ControlPresupuestoButton;
    public javax.swing.JTable CuentaTable;
    private javax.swing.JButton ImpuestosButton;
    public javax.swing.JTable ImpuestosTable;
    public javax.swing.JTable InversionesTable;
    public javax.swing.JTable MedioTable;
    public javax.swing.JTable MovimientoTable;
    public javax.swing.JTable PagosTable;
    private javax.swing.JButton PagosYCambiosButton;
    private javax.swing.JButton RiesgosButton;
    private javax.swing.JButton Salir;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}
