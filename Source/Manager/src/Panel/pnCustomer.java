package Panel;

import DBClass.ConnectDB;
import TBClass.tbCustomer;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class pnCustomer extends javax.swing.JPanel {

    pnMain home;
    DefaultTableModel table;
    TableRowSorter<TableModel> sorter;
    tbCustomer cus;
    Pattern p;
    Matcher m;
    Locale locale = new Locale("vi", "VN");
    NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

    public pnCustomer(pnMain home) {
        initComponents();
        initData();
        this.home = home;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grgender = new javax.swing.ButtonGroup();
        grStatus = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grCus = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        cboIndex = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rdMale = new javax.swing.JRadioButton();
        rdFemale = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        rdActivate = new javax.swing.JRadioButton();
        rdLock = new javax.swing.JRadioButton();
        DOB = new com.toedter.calendar.JDateChooser();
        txtBalance = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        isName = new javax.swing.JLabel();
        isAddress = new javax.swing.JLabel();
        isDob = new javax.swing.JLabel();
        isEmail = new javax.swing.JLabel();
        isPhone = new javax.swing.JLabel();
        isIdentity = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setPreferredSize(new java.awt.Dimension(750, 570));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 570));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Customer");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("List"));

        grCus.setAutoCreateRowSorter(true);
        grCus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "STK", "Name", "Gender", "Balance", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grCus.setSelectionBackground(new java.awt.Color(0, 153, 153));
        grCus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grCusMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                grCusMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(grCus);

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

        cboIndex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "STK", "Name", "Gender" }));
        cboIndex.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboIndexItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addGap(34, 34, 34)
                .addComponent(btnReset)
                .addGap(29, 29, 29)
                .addComponent(btnUpdate)
                .addGap(32, 32, 32)
                .addComponent(btnDelete)
                .addGap(32, 32, 32)
                .addComponent(btnPrint)
                .addGap(29, 29, 29)
                .addComponent(btnClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnReset)
                .addComponent(btnUpdate)
                .addComponent(btnDelete)
                .addComponent(btnPrint)
                .addComponent(btnClose)
                .addComponent(btnAdd))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Infomartion"));
        jPanel5.setPreferredSize(new java.awt.Dimension(826, 230));

        jLabel2.setText("Full Name : ");

        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddressKeyReleased(evt);
            }
        });

        jLabel3.setText("Address : ");

        jLabel4.setText("Email : ");

        jLabel5.setText("Phone Number :");

        jLabel7.setText("Identity card : ");

        jLabel8.setText("Gender : ");

        grgender.add(rdMale);
        rdMale.setText("Male");

        grgender.add(rdFemale);
        rdFemale.setText("Female");

        jLabel9.setText("DOB : ");

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        jLabel12.setText("Status : ");

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneKeyReleased(evt);
            }
        });

        grStatus.add(rdActivate);
        rdActivate.setText("Activate");
        rdActivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdActivateActionPerformed(evt);
            }
        });

        grStatus.add(rdLock);
        rdLock.setText("Lock");

        DOB.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                DOBPropertyChange(evt);
            }
        });

        txtBalance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtBalance.setForeground(new java.awt.Color(255, 51, 51));
        txtBalance.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtCMND.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCMNDKeyReleased(evt);
            }
        });

        isName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete2.png"))); // NOI18N
        isName.setToolTipText("Full Name not valid");

        isAddress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete2.png"))); // NOI18N
        isAddress.setToolTipText("Address not valid");

        isDob.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete2.png"))); // NOI18N
        isDob.setToolTipText("DOB not valid");

        isEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete2.png"))); // NOI18N
        isEmail.setToolTipText("Email not valid");

        isPhone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete2.png"))); // NOI18N
        isPhone.setToolTipText("Phone Number not valid");

        isIdentity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete2.png"))); // NOI18N
        isIdentity.setToolTipText("Identity Card not valid");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(rdMale)
                                .addGap(18, 18, 18)
                                .addComponent(rdFemale))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isAddress)
                    .addComponent(isName)
                    .addComponent(isDob))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12)
                    .addComponent(jLabel7))
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(rdActivate)
                        .addGap(18, 18, 18)
                        .addComponent(rdLock)
                        .addGap(28, 28, 28))
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(txtPhone)
                    .addComponent(txtCMND))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isEmail)
                    .addComponent(isPhone)
                    .addComponent(isIdentity))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAddress, txtEmail, txtName});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(isName)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(isEmail))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel5)
                                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(isAddress))))
                            .addComponent(isPhone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addComponent(isDob)))
                    .addComponent(isIdentity))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdActivate)
                        .addComponent(rdLock))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(rdMale)
                        .addComponent(rdFemale)
                        .addComponent(jLabel12)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (btnUpdate.getText().equalsIgnoreCase("Update")) {
            if (grCus.getSelectedRow() >= 0 && grCus.getSelectedRowCount() == 1) {
                btnAdd.setEnabled(false);
                btnPrint.setEnabled(false);
                btnDelete.setEnabled(false);
                btnUpdate.setText("Save");
                btnClose.setText("Cancel");

                txtAddress.setEnabled(true);
                txtBalance.setEnabled(false);
                txtCMND.setEnabled(true);
                txtEmail.setEnabled(true);
                txtName.setEnabled(true);
                txtPhone.setEnabled(true);
                DOB.setEnabled(true);
                rdActivate.setEnabled(true);
                rdFemale.setEnabled(true);
                rdLock.setEnabled(true);
                rdMale.setEnabled(true);
            }
        } else {
            int status;
            int gender;
            int row = grCus.getSelectedRow();
            if (validAddress() && validCMND() && validDob() && validName() && validEmail() && validPhone()) {
                isAddress.setVisible(false);
                isDob.setVisible(false);
                isEmail.setVisible(false);
                isIdentity.setVisible(false);
                isName.setVisible(false);
                isPhone.setVisible(false);
                gender = (rdMale.isSelected()) ? 1 : 0;
                status = (rdActivate.isSelected()) ? 1 : 0;

                if (cus.update(new tbCustomer(txtName.getText().trim(), "123456789", txtAddress.getText().trim(), txtEmail.getText().trim(), txtPhone.getText().trim(), txtCMND.getText().trim(), Integer.parseInt(txtID.getText().trim()), gender, status, DOB.getDate(), 50000))) {
                    grCus.setValueAt(txtName.getText().trim(), row, 2);
                    grCus.setValueAt((rdMale.isSelected()) ? "Male" : "Female", row, 3);
                    grCus.setValueAt(rdActivate.isSelected(), row, 5);
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

    private void rdActivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdActivateActionPerformed

    }//GEN-LAST:event_rdActivateActionPerformed

    private void grCusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grCusMouseClicked
        int row = grCus.getSelectedRow();
        if (grCus.getSelectedRowCount() == 1 && !btnAdd.getText().equalsIgnoreCase("Save")) {

            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
            tbCustomer rowInfo = cus.getInfo(Integer.parseInt(String.valueOf(grCus.getValueAt(row, 0))));
            txtAddress.setText(rowInfo.getDiachi());
            txtBalance.setText(String.valueOf(fmt.format(rowInfo.getBalance())));
            txtCMND.setText(rowInfo.getCmnd());
            txtEmail.setText(rowInfo.getEmail());
            txtName.setText(rowInfo.getName());
            txtPhone.setText(rowInfo.getMobile());
            txtID.setText(String.valueOf(rowInfo.getId()));
            DOB.setDate(rowInfo.getDob());

            if (rowInfo.getStatus() == 1) {
                rdActivate.setSelected(true);
                rdLock.setSelected(false);
            } else {
                rdActivate.setSelected(false);
                rdLock.setSelected(true);
            }

            if (rowInfo.getGender() == 1) {
                rdMale.setSelected(true);
                rdFemale.setSelected(false);
            } else {
                rdMale.setSelected(false);
                rdFemale.setSelected(true);
            }
        } else {
            if (!btnAdd.getText().equalsIgnoreCase("Save")) {
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(true);
                txtAddress.setText(String.valueOf(grCus.getSelectedRowCount()) + " rows selected");
                txtBalance.setText(String.valueOf(grCus.getSelectedRowCount()) + " rows selected");
                txtCMND.setText(String.valueOf(grCus.getSelectedRowCount()) + " rows selected");
                txtEmail.setText(String.valueOf(grCus.getSelectedRowCount()) + " rows selected");
                txtName.setText(String.valueOf(grCus.getSelectedRowCount()) + " rows selected");
                txtPhone.setText(String.valueOf(grCus.getSelectedRowCount()) + " rows selected");
            }
        }

        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            int id = Integer.parseInt(String.valueOf(table.getValueAt(grCus.getSelectedRow(), 0)));
            dlCustomer dlCus = new dlCustomer(null, true, id);
            dlCus.setLocationRelativeTo(home);
            dlCus.setVisible(true);

        }
    }//GEN-LAST:event_grCusMouseClicked

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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (btnAdd.getText().equalsIgnoreCase("Add")) {
            btnUpdate.setEnabled(false);
            btnPrint.setEnabled(false);
            btnDelete.setEnabled(false);
            btnAdd.setText("Save");
            btnClose.setText("Cancel");

            txtAddress.setEnabled(true);
            txtBalance.setEnabled(false);
            txtCMND.setEnabled(true);
            txtEmail.setEnabled(true);
            txtName.setEnabled(true);
            txtPhone.setEnabled(true);
            DOB.setEnabled(true);
            rdActivate.setEnabled(true);
            rdFemale.setEnabled(true);
            rdLock.setEnabled(true);
            rdMale.setEnabled(true);

            txtBalance.setText(String.valueOf(fmt.format(50000)));
            txtAddress.setText(null);
            txtCMND.setText(null);
            txtEmail.setText(null);
            txtName.setText(null);
            txtPhone.setText(null);
            DOB.setDate(null);
            rdActivate.setSelected(true);
            rdMale.setSelected(true);
        } else {
            int status;
            int gender;

            if (validAddress() && validCMND() && validDob() && validName() && validEmail() && validPhone()) {
                isAddress.setVisible(false);
                isDob.setVisible(false);
                isEmail.setVisible(false);
                isIdentity.setVisible(false);
                isName.setVisible(false);
                isPhone.setVisible(false);
                gender = (rdMale.isSelected()) ? 1 : 0;
                status = (rdActivate.isSelected()) ? 1 : 0;
                if (cus.insert(new tbCustomer(txtName.getText().trim(), "123456789", txtAddress.getText().trim(), txtEmail.getText().trim(), txtPhone.getText().trim(), txtCMND.getText().trim(), 0, gender, status, DOB.getDate(), 50000))) {
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

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        sorter.setRowFilter(null);
        txtSearch.setText("Enter character to search ...");

        DOB.setDate(null);
        txtAddress.setText(null);
        txtCMND.setText(null);
        txtEmail.setText(null);
        txtName.setText(null);
        txtPhone.setText(null);
        rdActivate.setSelected(true);
        rdFemale.setSelected(false);
        rdLock.setSelected(false);
        rdMale.setSelected(true);
    }//GEN-LAST:event_btnResetActionPerformed

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

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        if (!validName()) {
            isName.setVisible(true);
        } else {
            isName.setVisible(false);
        }
    }//GEN-LAST:event_txtNameKeyReleased

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        int index;
        index = cboIndex.getSelectedIndex();
        ArrayList listSort = new ArrayList();
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
            listSort.add(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim(), index));
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        } else {
            listSort.add(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim(), index));
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyReleased
        if (!validAddress()) {
            isAddress.setVisible(true);
        } else {
            isAddress.setVisible(false);
        }
    }//GEN-LAST:event_txtAddressKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        if (!validEmail()) {
            isEmail.setVisible(true);
        } else {
            isEmail.setVisible(false);
        }
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyReleased
        if (!validPhone()) {
            isPhone.setVisible(true);
        } else {
            isPhone.setVisible(false);
        }
    }//GEN-LAST:event_txtPhoneKeyReleased

    private void txtCMNDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCMNDKeyReleased
        if (!validCMND()) {
            isIdentity.setVisible(true);
        } else {
            isIdentity.setVisible(false);
        }
    }//GEN-LAST:event_txtCMNDKeyReleased

    private void DOBPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_DOBPropertyChange
        if (!validDob()) {
            isDob.setVisible(true);
        } else {
            isDob.setVisible(false);
        }
    }//GEN-LAST:event_DOBPropertyChange

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        ConnectDB.runReport("Report//Customer.jasper");
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure ?") == JOptionPane.YES_OPTION) {
            int count = 0, i = 0;
            int total = grCus.getSelectedRowCount();
            int del[] = new int[1000];
            if (total > 0) {
                for (int item : grCus.getSelectedRows()) {
                    if (cus.delete(Integer.parseInt(String.valueOf(grCus.getValueAt(item, 0))))) {
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

    private void grCusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grCusMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_grCusMouseEntered

    private void cboIndexItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboIndexItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int index;
            index = cboIndex.getSelectedIndex();
            ArrayList listSort = new ArrayList();
            listSort.add(RowFilter.regexFilter("(?i)" + txtSearch.getText().trim(), index));
            RowFilter filter = RowFilter.andFilter(listSort);
            sorter.setRowFilter(filter);
        }
    }//GEN-LAST:event_cboIndexItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DOB;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cboIndex;
    private javax.swing.JTable grCus;
    private javax.swing.ButtonGroup grStatus;
    private javax.swing.ButtonGroup grgender;
    private javax.swing.JLabel isAddress;
    private javax.swing.JLabel isDob;
    private javax.swing.JLabel isEmail;
    private javax.swing.JLabel isIdentity;
    private javax.swing.JLabel isName;
    private javax.swing.JLabel isPhone;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdActivate;
    private javax.swing.JRadioButton rdFemale;
    private javax.swing.JRadioButton rdLock;
    private javax.swing.JRadioButton rdMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void initData() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
            Date d1 = dateFormat.parse(calendar.get(Calendar.DAY_OF_MONTH) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + (calendar.get(Calendar.YEAR) - 18));
            DOB.setMaxSelectableDate(d1);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        table = (DefaultTableModel) grCus.getModel();
        sorter = (TableRowSorter<TableModel>) grCus.getRowSorter();
        cus = new tbCustomer();
        for (tbCustomer item : cus.getList()) {
            table.addRow(item.toVector());
        }
        frDefault();
        txtID.setVisible(false);
    }

    private boolean validName() {
        p = Pattern.compile("^[\\w ]{1,}$", Pattern.UNICODE_CHARACTER_CLASS);
        m = p.matcher(txtName.getText().trim());
        if (txtName.getText().trim().length() == 0) {
            return false;
        } else {
            return m.matches();
        }
    }

    private boolean validAddress() {
        return txtAddress.getText().trim().length() != 0;
    }

    private boolean validDob() {
        return DOB.getDate() != null;
    }

    private boolean validEmail() {
        p = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        m = p.matcher(txtEmail.getText().trim());
        if (txtEmail.getText().trim().length() == 0) {
            return false;
        } else {
            return m.matches();
        }
    }

    private boolean validPhone() {
        p = Pattern.compile("^[0-9]{9,11}$");
        m = p.matcher(txtPhone.getText().trim());
        if (txtPhone.getText().trim().length() == 0) {
            return false;
        } else {
            return m.matches();
        }
    }

    private boolean validCMND() {
        p = Pattern.compile("^[0-9]{9}$");
        m = p.matcher(txtCMND.getText().trim());
        if (txtCMND.getText().trim().length() == 0) {
            return false;
        } else {
            return m.matches();
        }
    }

    private void frDefault() {
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnAdd.setText("Add");
        btnAdd.setEnabled(true);
        btnUpdate.setText("Update");
        btnClose.setText("Close");
        btnPrint.setEnabled(true);

        txtAddress.setEnabled(false);
        txtBalance.setEnabled(false);
        txtCMND.setEnabled(false);
        txtEmail.setEnabled(false);
        txtName.setEnabled(false);
        txtPhone.setEnabled(false);
        DOB.setEnabled(false);
        rdActivate.setEnabled(false);
        rdFemale.setEnabled(false);
        rdLock.setEnabled(false);
        rdMale.setEnabled(false);

        sorter.setRowFilter(null);
        txtSearch.setText("Enter character to search ...");

//        DOB.setDate(null);
//        txtAddress.setText(null);
//        txtBalance.setText(null);
//        txtCMND.setText(null);
//        txtEmail.setText(null);
//        txtName.setText(null);
//        txtPhone.setText(null);
//        rdActivate.setSelected(true);
//        rdFemale.setSelected(false);
//        rdLock.setSelected(false);
//        rdMale.setSelected(true);
        isAddress.setVisible(false);
        isDob.setVisible(false);
        isEmail.setVisible(false);
        isIdentity.setVisible(false);
        isName.setVisible(false);
        isPhone.setVisible(false);
    }

}
