package Panel;

import DBClass.ConnectDB;
import TBClass.tbDeposit;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class pnDeposit extends javax.swing.JPanel {

    pnMain home;
    DefaultTableModel table;
    TableRowSorter<TableModel> sorter;
    tbDeposit cus;
    Locale locale = new Locale("vi", "VN");
    NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public pnDeposit(pnMain home) {
        initComponents();
        this.home = home;
        table = (DefaultTableModel) grDeposit.getModel();
        sorter = (TableRowSorter<TableModel>) grDeposit.getRowSorter();
        cus = new tbDeposit();
        for (tbDeposit item : cus.getList()) {
            table.addRow(item.toVector());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grDeposit = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        cbSearch = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnAccept = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtClient = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAtm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCard = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(750, 570));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Deposit");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("List"));

        grDeposit.setAutoCreateRowSorter(true);
        grDeposit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Client", "Amount", "ATM", "ATM Card", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grDeposit.setSelectionBackground(new java.awt.Color(0, 153, 153));
        grDeposit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grDepositMouseClicked(evt);
            }
        });
        grDeposit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                grDepositKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(grDeposit);

        txtSearch.setText("Enter character to search ...");
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

        cbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Client", "ATM", "ATM Card ID" }));
        cbSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSearchItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset2.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete2.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/printer2.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logout16x16.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/list_add2.png"))); // NOI18N
        btnAccept.setText("Accept");
        btnAccept.setEnabled(false);
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnAccept)
                .addGap(61, 61, 61)
                .addComponent(btnReset)
                .addGap(54, 54, 54)
                .addComponent(btnDelete)
                .addGap(52, 52, 52)
                .addComponent(btnPrint)
                .addGap(55, 55, 55)
                .addComponent(btnClose)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnReset)
                .addComponent(btnDelete)
                .addComponent(btnPrint)
                .addComponent(btnClose)
                .addComponent(btnAccept))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Infomartion"));

        jLabel1.setText("Client : ");

        txtClient.setEnabled(false);

        jLabel5.setText("Amount : ");

        txtBalance.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtBalance.setEnabled(false);

        jLabel2.setText("ATM : ");

        txtAtm.setEnabled(false);

        jLabel3.setText("ATM Card : ");

        txtCard.setEnabled(false);

        jLabel4.setText("Date : ");

        txtDate.setEnabled(false);
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtClient, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAtm, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCard, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(30, 30, 30)
                .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAtm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        ConnectDB.runReport(new File("").getAbsolutePath() + "//Report//Deposit.jasper");
    }//GEN-LAST:event_btnPrintActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void grDepositKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_grDepositKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_grDepositKeyPressed

    private void grDepositMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grDepositMouseClicked
        int row = grDeposit.getSelectedRow();

        if (grDeposit.getSelectedRowCount() == 1) {
            btnDelete.setEnabled(true);
            btnAccept.setEnabled(true);
            tbDeposit rowInfo = cus.getInfo(Integer.parseInt(String.valueOf(grDeposit.getValueAt(row, 0))));
            txtAtm.setText(rowInfo.getAtmname());
            txtBalance.setText(String.valueOf(fmt.format(rowInfo.getBalance())));
            txtCard.setText(String.valueOf(rowInfo.getAtmcard()));
            txtClient.setText(rowInfo.getKhname());
            txtDate.setText(dateFormat.format(rowInfo.getDate()).toString());
        } else {
            btnAccept.setEnabled(true);
            btnDelete.setEnabled(true);
            txtAtm.setText(String.valueOf(grDeposit.getSelectedRowCount()) + " rows selected");
            txtBalance.setText(String.valueOf(grDeposit.getSelectedRowCount()) + " rows selected");
            txtCard.setText(String.valueOf(grDeposit.getSelectedRowCount()) + " rows selected");
            txtClient.setText(String.valueOf(grDeposit.getSelectedRowCount()) + " rows selected");
            txtDate.setText(String.valueOf(grDeposit.getSelectedRowCount()) + " rows selected");
        }

        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            int id = Integer.parseInt(String.valueOf(table.getValueAt(grDeposit.getSelectedRow(), 0)));
            dlDeposit dlCus = new dlDeposit(null, true, id);
            dlCus.setLocationRelativeTo(home);
            dlCus.setVisible(true);
        }
    }//GEN-LAST:event_grDepositMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        ArrayList listSort = new ArrayList();
        int search;
        if (cbSearch.getSelectedIndex() >= 2) {
            search = cbSearch.getSelectedIndex() + 1;
        } else {
            search = cbSearch.getSelectedIndex();
        }

        if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
            listSort.add(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim(), search));
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        } else {
            listSort.add(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim(), search));
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        if (txtSearch.getText().equalsIgnoreCase("Enter character to search ...")) {
            txtSearch.setText(null);
        }
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().equalsIgnoreCase("")) {
            txtSearch.setText("Enter character to search ...");
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        int del[] = new int[1000];
        int count = 0, index = 0;
        int total = grDeposit.getSelectedRowCount();
        if (total > 0) {
            for (int i : grDeposit.getSelectedRows()) {
                tbDeposit rowInfo = cus.getInfo(Integer.parseInt(String.valueOf(grDeposit.getValueAt(i, 0))));
                if (cus.accept(rowInfo.getBalance(), rowInfo.getKhid(), rowInfo.getId())) {
                    count++;
                    del[index] = i;
                    index++;
                }
            }
            if (index > 0) {
                for (int list = index - 1; list >= 0; list--) {
                    table.removeRow(del[list]);
                }
            }
            JOptionPane.showMessageDialog(this, "Accept successfully " + count + " record in " + total + " records ");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row !");
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure ?") == JOptionPane.YES_OPTION) {
            int del[] = new int[1000];
            int count = 0, index = 0;
            int total = grDeposit.getSelectedRowCount();
            if (total > 0) {
                for (int i : grDeposit.getSelectedRows()) {
                    if (cus.delete(Integer.parseInt(String.valueOf(grDeposit.getValueAt(i, 0))))) {
                        count++;
                        del[index] = i;
                        index++;
                    }
                }
                if (index > 0) {
                    for (int list = index - 1; list >= 0; list--) {
                        table.removeRow(del[list]);
                    }
                }
                JOptionPane.showMessageDialog(this, "Delete successfully " + count + " record in " + total + " records ");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row !");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtAtm.setText(null);
        txtBalance.setText(null);
        txtCard.setText(null);
        txtClient.setText(null);
        txtDate.setText(null);
        txtSearch.setText("Enter character to search ...");
        sorter.setRowFilter(null);
        btnAccept.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        if (btnClose.getText().equalsIgnoreCase("Cancel")) {
            txtAtm.setText(null);
            txtBalance.setText(null);
            txtCard.setText(null);
            txtClient.setText(null);
            txtDate.setText(null);
            txtSearch.setText("Enter character to search ...");
            sorter.setRowFilter(null);
            btnAccept.setEnabled(false);
            btnDelete.setEnabled(false);
        } else {
            pnHome pnhome = new pnHome(home);
            home.pnRight.setLayout(new java.awt.CardLayout());
            home.pnRight.removeAll();
            home.pnRight.add(pnhome);
            home.pnRight.revalidate();
        }
    }//GEN-LAST:event_btnCloseActionPerformed

    private void cbSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSearchItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ArrayList listSort = new ArrayList();
            int search;
            if (cbSearch.getSelectedIndex() >= 2) {
                search = cbSearch.getSelectedIndex() + 1;
            } else {
                search = cbSearch.getSelectedIndex();
            }
            listSort.add(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim(), search));
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        }
    }//GEN-LAST:event_cbSearchItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox cbSearch;
    private javax.swing.JTable grDeposit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAtm;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtCard;
    private javax.swing.JTextField txtClient;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
