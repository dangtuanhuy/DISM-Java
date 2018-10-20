package Panel;

import TBClass.tbATMCard;
import TBClass.tbCustomer;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class dlAddClient extends javax.swing.JDialog {

    DefaultTableModel table;
    TableRowSorter<TableModel> sorter;
    private final tbCustomer cus;
    pnATMCard home;
    
    public dlAddClient(java.awt.Frame parent, boolean modal, pnATMCard home) {
        super(parent, modal);
        initComponents();
        table = (DefaultTableModel) grCus.getModel();
        sorter = (TableRowSorter<TableModel>) grCus.getRowSorter();
        cus = new tbCustomer();
        for (tbCustomer item : cus.getList()) {
            table.addRow(item.selectVector());
        }
        this.home = home;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sfd = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grCus = new javax.swing.JTable();
        txtAddress = new javax.swing.JTextField();
        cboGender = new javax.swing.JComboBox();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(185, 58));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SELECT CLIENT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        sfd.setBackground(new java.awt.Color(255, 255, 255));
        sfd.setBorder(javax.swing.BorderFactory.createTitledBorder("List Customer"));

        grCus.setAutoCreateRowSorter(true);
        grCus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Account Number", "Full Name", "Address", "Phone Number : ", "Gender", "DOB", "Identity Number", "Balance", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grCus.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane1.setViewportView(grCus);

        txtAddress.setText("Enter address ....");
        txtAddress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAddressMouseClicked(evt);
            }
        });
        txtAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAddressFocusLost(evt);
            }
        });
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddressKeyReleased(evt);
            }
        });

        cboGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        cboGender.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboGenderItemStateChanged(evt);
            }
        });

        txtName.setText("Enter name ....");
        txtName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNameMouseClicked(evt);
            }
        });
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        jLabel2.setText("Fillter : ");

        javax.swing.GroupLayout sfdLayout = new javax.swing.GroupLayout(sfd);
        sfd.setLayout(sfdLayout);
        sfdLayout.setHorizontalGroup(
            sfdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sfdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sfdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(sfdLayout.createSequentialGroup()
                        .addGap(0, 56, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        sfdLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboGender, txtAddress, txtName});

        sfdLayout.setVerticalGroup(
            sfdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sfdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sfdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sfd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sfd, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        ArrayList listSort = new ArrayList();
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
            if (txtName.getText().trim().equalsIgnoreCase("Enter name ....") == false) {
                listSort.add(RowFilter.regexFilter("(?i)" + txtName.getText().trim(), 2));
            }
            if (txtAddress.getText().trim().equalsIgnoreCase("Enter address ....") == false) {
                listSort.add(RowFilter.regexFilter("(?i)" + txtAddress.getText().trim(), 3));
            }
            if (cboGender.getSelectedIndex() == 0) {
                listSort.add(RowFilter.regexFilter("Male", 5));
            } else {
                listSort.add(RowFilter.regexFilter("Female", 5));
            }
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        } else {
            if (txtName.getText().trim().equalsIgnoreCase("Enter name ....") == false) {
                listSort.add(RowFilter.regexFilter("(?i)" + txtName.getText().trim(), 2));
            }
            if (txtAddress.getText().trim().equalsIgnoreCase("Enter address ....") == false) {
                listSort.add(RowFilter.regexFilter("(?i)" + txtAddress.getText().trim(), 3));
            }
            if (cboGender.getSelectedIndex() == 0) {
                listSort.add(RowFilter.regexFilter("Male", 5));
            } else {
                listSort.add(RowFilter.regexFilter("Female", 5));
            }
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        }
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyReleased
        ArrayList listSort = new ArrayList();
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
            if (txtName.getText().trim().equalsIgnoreCase("Enter name ....") == false) {
                listSort.add(RowFilter.regexFilter("(?i)" + txtName.getText().trim(), 2));
            }
            if (txtAddress.getText().trim().equalsIgnoreCase("Enter address ....") == false) {
                listSort.add(RowFilter.regexFilter("(?i)" + txtAddress.getText().trim(), 3));
            }
            if (cboGender.getSelectedIndex() == 0) {
                listSort.add(RowFilter.regexFilter("Male", 5));
            } else {
                listSort.add(RowFilter.regexFilter("Female", 5));
            }
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        } else {
            if (txtName.getText().trim().equalsIgnoreCase("Enter name ....") == false) {
                listSort.add(RowFilter.regexFilter("(?i)" + txtName.getText().trim(), 2));
            }
            if (txtAddress.getText().trim().equalsIgnoreCase("Enter address ....") == false) {
                listSort.add(RowFilter.regexFilter("(?i)" + txtAddress.getText().trim(), 3));
            }
            if (cboGender.getSelectedIndex() == 0) {
                listSort.add(RowFilter.regexFilter("Male", 5));
            } else {
                listSort.add(RowFilter.regexFilter("Female", 5));
            }
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        }
    }//GEN-LAST:event_txtAddressKeyReleased

    private void cboGenderItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboGenderItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ArrayList listSort = new ArrayList();
            if (txtName.getText().trim().equalsIgnoreCase("Enter name ....") == false) {
                listSort.add(RowFilter.regexFilter("(?i)" + txtName.getText().trim(), 2));
            }
            if (txtAddress.getText().trim().equalsIgnoreCase("Enter address ....") == false) {
                listSort.add(RowFilter.regexFilter("(?i)" + txtAddress.getText().trim(), 3));
            }
            if (cboGender.getSelectedIndex() == 0) {
                listSort.add(RowFilter.regexFilter("Male", 5));
            } else {
                listSort.add(RowFilter.regexFilter("Female", 5));
            }
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        }
    }//GEN-LAST:event_cboGenderItemStateChanged

    private void txtNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameMouseClicked
        txtName.setText("");
    }//GEN-LAST:event_txtNameMouseClicked

    private void txtAddressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAddressMouseClicked
        txtAddress.setText("");
    }//GEN-LAST:event_txtAddressMouseClicked

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        if (txtName.getText().equalsIgnoreCase("")) {
            txtName.setText("Enter name ....");
        }
    }//GEN-LAST:event_txtNameFocusLost

    private void txtAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusLost
        if (txtAddress.getText().equalsIgnoreCase("")) {
            txtAddress.setText("Enter address ....");
        }
    }//GEN-LAST:event_txtAddressFocusLost

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int row = grCus.getSelectedRow();
        if(grCus.getSelectedRowCount() > 1 || grCus.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(this, "Please select one row");
        } else {
            home.khid = Integer.parseInt(String.valueOf(grCus.getValueAt(row, 0)));
            home.khname = String.valueOf(grCus.getValueAt(row, 2));
            home.addCus();
            this.dispose();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JComboBox cboGender;
    private javax.swing.JTable grCus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel sfd;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
