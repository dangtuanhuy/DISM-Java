package Panel;

import DBClass.ConnectDB;
import TBClass.tbATMCard;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class pnATMCard extends javax.swing.JPanel {

    pnMain home;
    DefaultTableModel table;
    TableRowSorter<TableModel> sorter;
    tbATMCard cus;
    Pattern p;
    Matcher m;
    public int khid;
    public String khname;

    public pnATMCard(pnMain home) {
        initComponents();
        initData();
        this.home = home;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtClient = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rdActive = new javax.swing.JRadioButton();
        rdLock = new javax.swing.JRadioButton();
        txtDate = new com.toedter.calendar.JDateChooser();
        txtExDate = new com.toedter.calendar.JDateChooser();
        btnSelect = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPin = new javax.swing.JTextField();
        btnSelect1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grCard = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        cbSearch = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(750, 570));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 570));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Infomartion"));

        jLabel1.setText("Client : ");

        txtClient.setEnabled(false);

        jLabel5.setText("ID : ");

        txtID.setEnabled(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel2.setText("Date : ");

        jLabel3.setText("Expiry Date : ");

        jLabel6.setText("Status : ");

        buttonGroup1.add(rdActive);
        rdActive.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdActive.setSelected(true);
        rdActive.setText("Activity");
        rdActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdActiveActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdLock);
        rdLock.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rdLock.setText("Lock");

        txtDate.setEnabled(false);

        txtExDate.setEnabled(false);

        btnSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/list_add2.png"))); // NOI18N
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        jLabel4.setText("Pin : ");

        txtPin.setEnabled(false);

        btnSelect1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/list_add2.png"))); // NOI18N
        btnSelect1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelect1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPin)
                    .addComponent(txtClient, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(txtDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSelect1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(rdActive)
                        .addGap(18, 18, 18)
                        .addComponent(rdLock)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtExDate, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdLock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdActive, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(btnSelect1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("List"));

        grCard.setAutoCreateRowSorter(true);
        grCard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Client", "Date", "Expiry date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grCard.setSelectionBackground(new java.awt.Color(0, 153, 153));
        grCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grCardMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grCard);

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

        cbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Client" }));
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ATM CARD");

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

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/list_add2.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logout16x16.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(37, 37, 37)
                .addComponent(btnReset)
                .addGap(37, 37, 37)
                .addComponent(btnUpdate)
                .addGap(38, 38, 38)
                .addComponent(btnDelete)
                .addGap(38, 38, 38)
                .addComponent(btnPrint)
                .addGap(36, 36, 36)
                .addComponent(btnClose)
                .addGap(170, 170, 170))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnReset)
                .addComponent(btnUpdate)
                .addComponent(btnDelete)
                .addComponent(btnPrint)
                .addComponent(btnAdd)
                .addComponent(btnClose))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void rdActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdActiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdActiveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure ?") == JOptionPane.YES_OPTION) {
            int count = 0, i = 0;
            int total = grCard.getSelectedRowCount();
            int del[] = new int[1000];
            if (total > 0) {
                for (int item : grCard.getSelectedRows()) {
                    if (cus.delete(Integer.parseInt(String.valueOf(grCard.getValueAt(item, 0))))) {
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

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        if (txtSearch.getText().equalsIgnoreCase("Enter searching value ...")) {
            txtSearch.setText(null);
        }
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().equalsIgnoreCase("")) {
            txtSearch.setText("Enter searching value ...");
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        ArrayList listSort = new ArrayList();
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
            listSort.add(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim(), cbSearch.getSelectedIndex()));
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        } else {
            listSort.add(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim(), cbSearch.getSelectedIndex()));
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void grCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grCardMouseClicked
        int row = grCard.getSelectedRow();
        if (grCard.getSelectedRowCount() == 1 && !btnAdd.getText().equalsIgnoreCase("Save")) {

            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            tbATMCard rowInfo = cus.getInfo(Integer.parseInt(String.valueOf(grCard.getValueAt(row, 0))));
            txtClient.setText(rowInfo.getName(rowInfo.getKhid()));
            txtID.setText(String.valueOf(rowInfo.getCardid()));
            txtDate.setDate(rowInfo.getThoigian());
            txtExDate.setDate(rowInfo.getThoihan());
            txtPin.setText(String.valueOf(rowInfo.getPin()));
            khid = rowInfo.getKhid();
            khname = cus.getName(khid);
            if (rowInfo.getStatus() == 1) {
                rdActive.setSelected(true);
                rdLock.setSelected(false);
            } else {
                rdActive.setSelected(false);
                rdLock.setSelected(true);
            }
        } else {
            if (!btnAdd.getText().equalsIgnoreCase("Save")) {
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(true);
                txtID.setText(String.valueOf(grCard.getSelectedRowCount()) + " rows selected");
                txtClient.setText(String.valueOf(grCard.getSelectedRowCount()) + " rows selected");
                txtPin.setText(String.valueOf(grCard.getSelectedRowCount()) + " rows selected");

            }
        }

        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            int id = Integer.parseInt(String.valueOf(table.getValueAt(grCard.getSelectedRow(), 0)));
            dlCardView dlCus = new dlCardView(null, true, id, true);
            dlCus.setLocationRelativeTo(home);
            dlCus.setVisible(true);
        }
    }//GEN-LAST:event_grCardMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (btnAdd.getText().equalsIgnoreCase("Add")) {
            try {
                btnUpdate.setEnabled(false);
                btnPrint.setEnabled(false);
                btnDelete.setEnabled(false);
                btnAdd.setText("Save");
                btnClose.setText("Cancel");
                btnSelect1.setVisible(true);

                btnSelect.setVisible(true);
                rdLock.setEnabled(true);
                rdActive.setEnabled(true);
                txtPin.setEnabled(true);
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
                Date d1 = dateFormat.parse(calendar.get(Calendar.DAY_OF_MONTH) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + (calendar.get(Calendar.YEAR)));
                Date d2 = dateFormat.parse(calendar.get(Calendar.DAY_OF_MONTH) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + (calendar.get(Calendar.YEAR) + 3));
                txtDate.setDate(d1);
                txtExDate.setDate(d2);
                txtID.setText(String.valueOf(cus.nextID()));
                txtClient.setText("");
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        } else {
            int status;
            p = Pattern.compile("^[0-9]{4}$");
            m = p.matcher(txtPin.getText().trim());
            if (txtClient.getText().trim().length() != 0 && m.matches()) {
                status = (rdActive.isSelected()) ? 1 : 0;
                if (cus.insert(new tbATMCard(1, Integer.parseInt(txtID.getText().trim()), Integer.parseInt(txtPin.getText().trim()), khid, status, txtDate.getDate(), txtExDate.getDate()))) {
                    table.addRow(cus.getRecent().toVector());
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

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        dlAddClient select = new dlAddClient(null, true, this);
        select.setLocationRelativeTo(this);
        select.setVisible(true);
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnSelect1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelect1ActionPerformed
        txtPin.setText(String.valueOf((int) (8999 * Math.random()) + 1000));
    }//GEN-LAST:event_btnSelect1ActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        if (btnClose.getText().equalsIgnoreCase("Cancel")) {
            frDefault();
        } else {
            pnHome pnhome = new pnHome(home);
            home.pnRight.setLayout(new java.awt.CardLayout());
            home.pnRight.removeAll();
            home.pnRight.add(pnhome);
            home.pnRight.revalidate();
        }
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtClient.setText("");
        txtPin.setText("");
        sorter.setRowFilter(null);
        txtSearch.setText("Enter searching value ...");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (btnUpdate.getText().equalsIgnoreCase("Update")) {
            if (grCard.getSelectedRow() >= 0 && grCard.getSelectedRowCount() == 1) {
                btnAdd.setEnabled(false);
                btnPrint.setEnabled(false);
                btnDelete.setEnabled(false);
                btnUpdate.setText("Save");
                btnClose.setText("Cancel");

                btnSelect.setVisible(true);
                rdLock.setEnabled(true);
                rdActive.setEnabled(true);
                txtExDate.setEnabled(true);
                txtPin.setEnabled(true);
                txtExDate.setMinSelectableDate(txtDate.getDate());
            }
        } else {
            int row = grCard.getSelectedRow();
            int status;
            p = Pattern.compile("^[0-9]{4}$");
            m = p.matcher(txtPin.getText().trim());
            if (!txtClient.getText().trim().equalsIgnoreCase(null) && m.matches()) {
                status = (rdActive.isSelected()) ? 1 : 0;

                if (cus.update(new tbATMCard(1, Integer.parseInt(txtID.getText().trim()), Integer.parseInt(txtPin.getText().trim()), khid, status, txtDate.getDate(), txtExDate.getDate()))) {
                    grCard.setValueAt(khname, row, 1);
                    grCard.setValueAt(String.valueOf(new java.sql.Date(txtExDate.getDate().getTime())), row, 3);
                    grCard.setValueAt(rdActive.isSelected(), row, 4);
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

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        ConnectDB.runReport(new File("").getAbsolutePath() + "//Report//ATMCard.jasper");
    }//GEN-LAST:event_btnPrintActionPerformed

    private void cbSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSearchItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ArrayList listSort = new ArrayList();
            listSort.add(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim(), cbSearch.getSelectedIndex()));
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        }
    }//GEN-LAST:event_cbSearchItemStateChanged

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btnSelect1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbSearch;
    private javax.swing.JTable grCard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdActive;
    private javax.swing.JRadioButton rdLock;
    private javax.swing.JTextField txtClient;
    private com.toedter.calendar.JDateChooser txtDate;
    private com.toedter.calendar.JDateChooser txtExDate;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPin;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void initData() {
        table = (DefaultTableModel) grCard.getModel();
        sorter = (TableRowSorter<TableModel>) grCard.getRowSorter();
        cus = new tbATMCard();
        for (tbATMCard item : cus.getList()) {
            table.addRow(item.toVector());
        }
        frDefault();
    }

    private void frDefault() {
        btnSelect.setVisible(false);
        btnSelect1.setVisible(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnAdd.setText("Add");
        btnAdd.setEnabled(true);
        btnUpdate.setText("Update");
        btnClose.setText("Close");
        btnPrint.setEnabled(true);

        txtID.setEnabled(false);
        txtClient.setEnabled(false);
        txtDate.setEnabled(false);
        txtExDate.setEnabled(false);
        rdActive.setEnabled(false);
        rdLock.setEnabled(false);
        txtPin.setEnabled(false);

        sorter.setRowFilter(null);
        txtSearch.setText("Enter searching value ...");
    }

    public void addCus() {
        txtClient.setText(khname);
    }
}
