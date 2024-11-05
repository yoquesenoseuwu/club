package menu_RH;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class TablaNominas extends javax.swing.JFrame {

    private TableRowSorter<DefaultTableModel> sorter;
    private JTextField Ingreso_busqueda_nominas;
    private JComboBox<String> filtrosNominas_combo;
    private JButton Busca_Text_filtro_nomin;
    private JButton Volver_noms; // Nuevo botón para volver al menú
    private JTable tablaNominas;

    public TablaNominas() {
        initComponents();
    }

    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        tablaNominas = new JTable();
        JSeparator jSeparator2 = new JSeparator();
        JLabel jLabel2 = new JLabel();
        Ingreso_busqueda_nominas = new JTextField();
        JLabel jLabel3 = new JLabel();
        Busca_Text_filtro_nomin = new JButton();
        filtrosNominas_combo = new JComboBox<>();
        Volver_noms = new JButton("<-"); // Texto del botón para volver al menú

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 50, 69));

        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Nóminas");

        // Configuración del modelo de tabla
        DefaultTableModel model = new DefaultTableModel(
            new Object[][] {
                {1, 350000.0, "10% por nuevo", 50},
                {2, 200111.0, "5% por horas extra", 12},
                {3, 100000.0, "5% por horas extra", 32},
                {4, 300000.0, "10% por nuevo", 44},
                {5, 1000000.0, "Mayores Prestamos", 91},
                {6, 2500000.0, "Mayores Prestamos", 87},
                {7, 1000000.0, "Mayores Prestamos", 77},
                {8, 900000.0, "Beneficios por antigüedad", 3},
                {9, 360000.0, "Beneficios por antigüedad", 4},
                {null, null, null, null},
            },
            new String[] {
                "ID", "Sueldo", "Beneficios", "ID empleado"
            }
        ) {
            Class[] types = new Class[] {
                Integer.class, Double.class, String.class, Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        tablaNominas.setModel(model);
        sorter = new TableRowSorter<>(model);
        tablaNominas.setRowSorter(sorter);
        jScrollPane1.setViewportView(tablaNominas);

        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Filtros:");

        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Búsqueda:");

        // Botón de búsqueda
        Busca_Text_filtro_nomin.setText("Buscar");
        Busca_Text_filtro_nomin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aplicarFiltroBusqueda();
            }
        });

        // ComboBox de filtros
        filtrosNominas_combo.setModel(new DefaultComboBoxModel<>(new String[] {
            "Seleccionar filtro", "Mayor a Menor", "Menor a Mayor"
        }));
        filtrosNominas_combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aplicarFiltroOrden();
            }
        });

        // Botón para volver al menú principal
        Volver_noms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Volver_nomsActionPerformed(evt);
            }
        });

        // Restringir búsqueda a números únicamente
        Ingreso_busqueda_nominas.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    evt.consume();
                }
            }
        });

        // Diseño del panel principal
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Volver_noms) // Botón de volver
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Ingreso_busqueda_nominas, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Busca_Text_filtro_nomin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(filtrosNominas_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Volver_noms)) // Botón de volver
                .addGap(1, 1, 1)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(filtrosNominas_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ingreso_busqueda_nominas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(Busca_Text_filtro_nomin))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel1);
        pack();
    }

    private void aplicarFiltroBusqueda() {
        String filtro = Ingreso_busqueda_nominas.getText();
        if (filtro.isEmpty()) {
            sorter.setRowFilter(null); // Si el campo de búsqueda está vacío, mostrar todas las filas
        } else {
            try {
                int id = Integer.parseInt(filtro);
                sorter.setRowFilter(RowFilter.numberFilter(RowFilter.ComparisonType.EQUAL, id, 0)); // Filtra por la columna ID
            } catch (NumberFormatException e) {
                sorter.setRowFilter(null);
            }
        }
    }

    private void aplicarFiltroOrden() {
        int index = filtrosNominas_combo.getSelectedIndex();
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        
        if (index == 1) { // Mayor a Menor
            sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING)); // Columna "Sueldo"
        } else if (index == 2) { // Menor a Mayor
            sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING)); // Columna "Sueldo"
        }
        
        sorter.setSortKeys(sortKeys);
    }

    private void Volver_nomsActionPerformed(java.awt.event.ActionEvent evt) {
        Menu newframe = new Menu();
        newframe.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TablaNominas().setVisible(true));
    }
}
