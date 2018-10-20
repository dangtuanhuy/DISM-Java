package Panel;

import DBClass.ConnectDB;
import TBClass.tbATM;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class pnATM extends javax.swing.JPanel {

    DefaultTableModel table;
    pnMain home;
    TableRowSorter<TableModel> sorter;

    public pnATM(pnMain home) {
        initComponents();
        initData();
        this.home = home;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStatus = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbATM = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        cboSearch = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rdAct = new javax.swing.JRadioButton();
        rdLock = new javax.swing.JRadioButton();
        isName = new javax.swing.JLabel();
        isLocation = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(750, 570));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 570));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ATM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
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

        tbATM.setAutoCreateRowSorter(true);
        tbATM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Location", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbATM.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tbATM.getTableHeader().setReorderingAllowed(false);
        tbATM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbATMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbATM);

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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        cboSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Name", "Location" }));
        cboSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSearchItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Infomartion"));

        jLabel1.setText("Name : ");

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        jLabel5.setText("Location :");

        txtLocation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLocationKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLocationKeyReleased(evt);
            }
        });

        jLabel9.setText("Status : ");

        btnStatus.add(rdAct);
        rdAct.setSelected(true);
        rdAct.setText("Activate");
        rdAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdActActionPerformed(evt);
            }
        });

        btnStatus.add(rdLock);
        rdLock.setText("Lock");

        isName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete2.png"))); // NOI18N
        isName.setToolTipText("Name not valid");

        isLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete2.png"))); // NOI18N
        isLocation.setToolTipText("Location not valid");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isName)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(279, 279, 279))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(rdAct)
                        .addGap(18, 18, 18)
                        .addComponent(rdLock)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtLocation, txtName});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(isLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rdAct)
                    .addComponent(rdLock))
                .addGap(26, 26, 26))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset2.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/update2.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete2.png"))); // NOI18N
        btnDelete.setText("Delete");
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

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/list_add2.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(36, 36, 36)
                .addComponent(btnReset)
                .addGap(37, 37, 37)
                .addComponent(btnUpdate)
                .addGap(37, 37, 37)
                .addComponent(btnDelete)
                .addGap(37, 37, 37)
                .addComponent(btnPrint)
                .addGap(38, 38, 38)
                .addComponent(btnClose)
                .addGap(163, 163, 163))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnReset)
                .addComponent(btnUpdate)
                .addComponent(btnDelete)
                .addComponent(btnPrint)
                .addComponent(btnClose)
                .addComponent(btnAdd))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 730, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 730, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdActActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdActActionPerformed

    private void tbATMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbATMMouseClicked
        int row = tbATM.getSelectedRow();
        if (tbATM.getSelectedRowCount() == 1 && !btnAdd.getText().equalsIgnoreCase("Save")) {
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            txtName.setText(String.valueOf(table.getValueAt(row, 1)));
            txtLocation.setText(String.valueOf(table.getValueAt(row, 2)));
            if (String.valueOf(table.getValueAt(row, 3)).equalsIgnoreCase("true")) {
                rdAct.setSelected(true);
                rdLock.setSelected(false);
            } else {
                rdAct.setSelected(false);
                rdLock.setSelected(true);
            }
        } else {
            if (!btnAdd.getText().equalsIgnoreCase("Save")) {
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(true);
                txtLocation.setText(String.valueOf(tbATM.getSelectedRowCount()) + " rows selected");
                txtName.setText(String.valueOf(tbATM.getSelectedRowCount()) + " rows selected");
            }
        }

        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            int id = Integer.parseInt(String.valueOf(table.getValueAt(tbATM.getSelectedRow(), 0)));
            dlATM dlAtm = new dlATM(null, true, id);
            dlAtm.setLocationRelativeTo(home);
            dlAtm.setVisible(true);
        }
    }//GEN-LAST:event_tbATMMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtName.setText(null);
        txtLocation.setText(null);
        rdAct.setSelected(true);
        rdLock.setSelected(false);
        sorter.setRowFilter(null);
        txtSearch.setText("Enter searching value ...");
        isLocation.setVisible(false);
        isName.setVisible(false);

    }//GEN-LAST:event_btnResetActionPerformed

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        if (txtSearch.getText().equalsIgnoreCase("Enter searching value ...")) {
            txtSearch.setText(null);
        }
    }//GEN-LAST:event_txtSearchMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (btnAdd.getText().equalsIgnoreCase("Add")) {
            txtName.setEnabled(true);
            txtLocation.setEnabled(true);
            rdAct.setEnabled(true);
            rdLock.setEnabled(true);
            btnUpdate.setEnabled(false);
            btnPrint.setEnabled(false);
            btnDelete.setEnabled(false);
            btnAdd.setText("Save");
            btnClose.setText("Cancel");
            txtName.setText(null);
            txtLocation.setText(null);
            rdAct.setSelected(true);
            rdLock.setSelected(false);
        } else {
            int status;
            if (validLocation() && validName()) {
                isLocation.setVisible(false);
                isName.setVisible(false);
                if (rdAct.isSelected()) {
                    status = 1;
                } else {
                    status = 0;
                }
                if (a.insert(txtName.getText().trim(), txtLocation.getText().trim(), status)) {
                    table.addRow(a.getRecent().toVector());
                    JOptionPane.showMessageDialog(this, "Save successful");
                    btnCloseActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(this, "Save error");
                    btnCloseActionPerformed(evt);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter the valid value");
            }
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        if (btnClose.getText().equalsIgnoreCase("Cancel")) {
            frDefault();
            isLocation.setVisible(false);
            isName.setVisible(false);
        } else {
            pnHome pnhome = new pnHome(home);
            home.pnRight.setLayout(new java.awt.CardLayout());
            home.pnRight.removeAll();
            home.pnRight.add(pnhome);
            home.pnRight.revalidate();
        }
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (btnUpdate.getText().equalsIgnoreCase("Update")) {
            if (tbATM.getSelectedRow() >= 0 && tbATM.getSelectedRowCount() == 1) {
                txtName.setEnabled(true);
                txtLocation.setEnabled(true);
                rdAct.setEnabled(true);
                rdLock.setEnabled(true);
                btnAdd.setEnabled(false);
                btnPrint.setEnabled(false);
                btnDelete.setEnabled(false);
                btnUpdate.setText("Save");
                btnClose.setText("Cancel");
            }
        } else {
            int status;
            if (validLocation() && validName()) {
                isLocation.setVisible(false);
                isName.setVisible(false);
                if (rdAct.isSelected()) {
                    status = 1;
                } else {
                    status = 0;
                }
                int id;
                int row;
                row = tbATM.getSelectedRow();
                id = Integer.parseInt(String.valueOf(tbATM.getValueAt(row, 0)));
                if (a.update(new tbATM(id, txtName.getText().trim(), txtLocation.getText().trim(), status))) {
                    table.setValueAt(txtName.getText().trim(), row, 1);
                    table.setValueAt(txtLocation.getText().trim(), row, 2);

                    if (status == 1) {
                        table.setValueAt(true, row, 3);
                    } else {
                        table.setValueAt(false, row, 3);
                    }

                    JOptionPane.showMessageDialog(this, "Save successful");
                    btnCloseActionPerformed(evt);
                } else {
                    JOptionPane.showMessageDialog(this, "Save error");
                    btnCloseActionPerformed(evt);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter the valid value");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().equalsIgnoreCase("")) {
            txtSearch.setText("Enter searching value ...");
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        ConnectDB.runReport(new File("").getAbsolutePath() + "//Report//ATM.jasper");
    }//GEN-LAST:event_btnPrintActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtLocationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocationKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (btnAdd.getText().equalsIgnoreCase("Save")) {
                btnAddActionPerformed(null);
            } else {
                btnUpdateActionPerformed(null);
            }
        }
    }//GEN-LAST:event_txtLocationKeyPressed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure ?") == JOptionPane.YES_OPTION) {
            int count = 0;
            int total = tbATM.getSelectedRowCount();
            int del[] = new int[1000];
            int i = 0;
            if (total > 0) {
                for (int item : tbATM.getSelectedRows()) {
                    if (a.delete(Integer.parseInt(String.valueOf(tbATM.getValueAt(item, 0))))) {
                        count++;
                        del[i] = item;
                        i++;
                    }
                }
                if (i > 0) {
                    for (int list = i - 1; list >= 0; list--) {
                        table.removeRow(del[list]);
                    }
                }
            }
            JOptionPane.showMessageDialog(this, "deleted successfully " + count + " record in " + total + " records ");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        if (!validName()) {
            isName.setVisible(true);
        } else {
            isName.setVisible(false);
        }
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtLocationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocationKeyReleased
        if (!validLocation()) {
            isLocation.setVisible(true);
        } else {
            isLocation.setVisible(false);
        }
    }//GEN-LAST:event_txtLocationKeyReleased

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        ArrayList listSort = new ArrayList();
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
            listSort.add(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim(), cboSearch.getSelectedIndex()));
            RowFilter filter = RowFilter.andFilter(listSort);

            sorter.setRowFilter(filter);
        } else {
            listSort.add(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim(), cboSearch.getSelectedIndex()));
            RowFilter filter = RowFilter.andFilter(listSort);

            sorter.setRowFilter(filter);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cboSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSearchItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int index = cboSearch.getSelectedIndex();
            ArrayList listSort = new ArrayList();
            listSort.add(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim(), index));
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        }
    }//GEN-LAST:event_cboSearchItemStateChanged

    private void frDefault() {
        txtName.setEnabled(false);
        txtLocation.setEnabled(false);
        rdAct.setEnabled(false);
        rdLock.setEnabled(false);
        btnAdd.setText("Add");
        btnAdd.setEnabled(true);
        btnClose.setText("Close");
        btnClose.setEnabled(true);
        btnDelete.setEnabled(true);
        btnPrint.setEnabled(true);
        btnReset.setEnabled(true);
        btnUpdate.setText("Update");
        btnUpdate.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.ButtonGroup btnStatus;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cboSearch;
    private javax.swing.JLabel isLocation;
    private javax.swing.JLabel isName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdAct;
    private javax.swing.JRadioButton rdLock;
    private javax.swing.JTable tbATM;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    tbATM a;

    private void initData() {
        table = (DefaultTableModel) tbATM.getModel();
        sorter = (TableRowSorter<TableModel>) tbATM.getRowSorter();
        a = new tbATM();
        for (tbATM item : a.getList()) {
            table.addRow(item.toVector());
        }
        txtName.setEnabled(false);
        txtLocation.setEnabled(false);
        rdAct.setEnabled(false);
        rdLock.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        isLocation.setVisible(false);
        isName.setVisible(false);

    }

    private boolean validName() {
        return txtName.getText().trim().length() != 0;
    }

    private boolean validLocation() {
        return txtLocation.getText().trim().length() != 0;
    }
}
