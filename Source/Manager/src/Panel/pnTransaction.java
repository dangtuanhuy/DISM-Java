package Panel;

import TBClass.tbATMCard;
import TBClass.tbTransaction;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class pnTransaction extends javax.swing.JPanel {

    DefaultTableModel table;
    TableRowSorter<TableModel> sorter;
    tbTransaction cus = new tbTransaction();
    pnMain home;

    public pnTransaction(pnMain home) {
        initComponents();
        this.home = home;
        table = (DefaultTableModel) grTran.getModel();
        sorter = (TableRowSorter<TableModel>) grTran.getRowSorter();
        for (tbTransaction item : cus.getList()) {
            table.addRow(item.toVector());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grTran = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        cboTime = new javax.swing.JComboBox();
        cboAction = new javax.swing.JComboBox();
        cbSearch = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(750, 570));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 58));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Transaction History");

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
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        grTran.setAutoCreateRowSorter(true);
        grTran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer", "Recipient", "ATM", "CARD", "Action", "Amount", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grTran.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane1.setViewportView(grTran);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logout16x16.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        txtSearch.setText("Enter searching value ...");
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        cboTime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "On Day", "On Month", "On Year" }));
        cboTime.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTimeItemStateChanged(evt);
            }
        });

        cboAction.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Deposit", "Withdrawal", "Tranfer" }));
        cboAction.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboActionItemStateChanged(evt);
            }
        });

        cbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Customer", "Recipient", "ATM", "ATM Card" }));
        cbSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSearchItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addComponent(cboAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboTime, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addGap(199, 199, 199))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        pnHome pnhome = new pnHome(home);
        home.pnRight.setLayout(new java.awt.CardLayout());
        home.pnRight.removeAll();
        home.pnRight.add(pnhome);
        home.pnRight.revalidate();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().equalsIgnoreCase("")) {
            txtSearch.setText("Enter searching value ...");
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        ArrayList listSort = new ArrayList();
        int index = cbSearch.getSelectedIndex();
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
            listSort.add(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim(), index + 1));
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        } else {
            listSort.add(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim(), index + 1));
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cboTimeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTimeItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int count = table.getRowCount();
            for (int i = count - 1; i >= 0; i--) {
                table.removeRow(i);
            }

            for (tbTransaction item : cus.fillter(cboAction.getSelectedIndex(), cboTime.getSelectedIndex())) {
                table.addRow(item.toVector());
            }
        }
    }//GEN-LAST:event_cboTimeItemStateChanged

    private void cboActionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboActionItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int count = table.getRowCount();
            for (int i = count - 1; i >= 0; i--) {
                table.removeRow(i);
            }

            for (tbTransaction item : cus.fillter(cboAction.getSelectedIndex(), cboTime.getSelectedIndex())) {
                table.addRow(item.toVector());
            }

//            if (cboAction.getSelectedIndex() == 0) {
//                for (tbTransaction item : cus.getList()) {
//                    table.addRow(item.toVector());
//                }
//            }
//
//            if (cboAction.getSelectedIndex() == 1) {
//                for (tbTransaction item : cus.getDeposit()) {
//                    table.addRow(item.toVector());
//                }
//            }
//
//            if (cboAction.getSelectedIndex() == 2) {
//                for (tbTransaction item : cus.getWithdrawal()) {
//                    table.addRow(item.toVector());
//                }
//            }
//
//            if (cboAction.getSelectedIndex() == 3) {
//                for (tbTransaction item : cus.getTranfer()) {
//                    table.addRow(item.toVector());
//                }
//            }
        }
    }//GEN-LAST:event_cboActionItemStateChanged

    private void cbSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSearchItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int index = cbSearch.getSelectedIndex();
            ArrayList listSort = new ArrayList();
            listSort.add(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim(), index+1));
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        }
    }//GEN-LAST:event_cbSearchItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JComboBox cbSearch;
    private javax.swing.JComboBox cboAction;
    private javax.swing.JComboBox cboTime;
    private javax.swing.JTable grTran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
