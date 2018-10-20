package Panel;

import MyProject.Run;
import Mylib.LookAndFeelWindow;
import java.awt.Frame;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class pnMain extends javax.swing.JPanel {

    String tendangnhap, hoten;
    int id_manager;
    public Connection con;
    Frame parent;

    public pnMain() {
        initComponents();
        initData();
        pnHome home = new pnHome(this);
        pnRight.setLayout(new java.awt.CardLayout());
        pnRight.removeAll();
        pnRight.add(home);
        pnRight.revalidate();
    }

    public pnMain(java.awt.Frame parent, String tendangnhap, int id_manager, final Connection con) {
        LookAndFeelWindow.LookAndFeelWindow();
        parent.setTitle("ATM SYSTEM MANAGER");
        this.parent = parent;
        this.tendangnhap = tendangnhap;
        this.id_manager = id_manager;
        this.con = con;
        initComponents();
        initData();
        pnHome home = new pnHome(this);
        pnRight.setLayout(new java.awt.CardLayout());
        pnRight.removeAll();
        pnRight.add(home);
        pnRight.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnInfo = new javax.swing.JButton();
        btnChangePass = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btnCus = new javax.swing.JButton();
        btnDeposit = new javax.swing.JButton();
        btnAtm = new javax.swing.JButton();
        btnAtmCard = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        _lblwellcome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        _lblAccount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        _lblAccountName = new javax.swing.JLabel();
        _btnAccountDetail = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        _lblclock = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        _lblday = new javax.swing.JLabel();
        _lbldatenow = new javax.swing.JLabel();
        _lblMonthYear = new javax.swing.JLabel();
        pnRight = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        btnLogout = new javax.swing.JButton();
        jToolBar5 = new javax.swing.JToolBar();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        btnCal = new javax.swing.JButton();
        btnSetting = new javax.swing.JButton();

        setForeground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(955, 650));
        setRequestFocusEnabled(false);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/InfomationThumb3.png"))); // NOI18N
        btnInfo.setToolTipText("Admin Information");
        btnInfo.setFocusable(false);
        btnInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnInfo);

        btnChangePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/password40x40.png"))); // NOI18N
        btnChangePass.setToolTipText("Change Pass");
        btnChangePass.setFocusable(false);
        btnChangePass.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChangePass.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });
        jToolBar1.add(btnChangePass);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.add(jSeparator9);

        btnCus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kuser40x40.png"))); // NOI18N
        btnCus.setToolTipText("Customer");
        btnCus.setFocusable(false);
        btnCus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusActionPerformed(evt);
            }
        });
        jToolBar2.add(btnCus);

        btnDeposit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kazdodenni-bankovnictvi.png"))); // NOI18N
        btnDeposit.setToolTipText("Deposit");
        btnDeposit.setFocusable(false);
        btnDeposit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeposit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositActionPerformed(evt);
            }
        });
        jToolBar2.add(btnDeposit);

        btnAtm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_atm.png"))); // NOI18N
        btnAtm.setToolTipText("ATM");
        btnAtm.setFocusable(false);
        btnAtm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAtm.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAtm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtmActionPerformed(evt);
            }
        });
        jToolBar2.add(btnAtm);

        btnAtmCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon-atm-card.gif"))); // NOI18N
        btnAtmCard.setToolTipText("ATM Card");
        btnAtmCard.setFocusable(false);
        btnAtmCard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAtmCard.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAtmCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtmCardActionPerformed(evt);
            }
        });
        jToolBar2.add(btnAtmCard);

        btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon-history.png"))); // NOI18N
        btnHistory.setToolTipText("Report");
        btnHistory.setFocusable(false);
        btnHistory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHistory.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });
        jToolBar2.add(btnHistory);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        _lblwellcome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        _lblwellcome.setForeground(new java.awt.Color(0, 0, 255));
        _lblwellcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        _lblwellcome.setText("Wellcome");

        jLabel2.setText("   Account:");

        _lblAccount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        _lblAccount.setForeground(new java.awt.Color(255, 0, 0));
        _lblAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        _lblAccount.setText("_lblAccount");
        _lblAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setText("   Full Name:");

        _lblAccountName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        _lblAccountName.setForeground(new java.awt.Color(51, 51, 255));
        _lblAccountName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        _lblAccountName.setText("_lblAccountType");

        _btnAccountDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/InfomationThumb1.png"))); // NOI18N
        _btnAccountDetail.setText("Information");
        _btnAccountDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btnAccountDetailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(_btnAccountDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(_lblAccountName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(_lblAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(_lblwellcome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(_lblwellcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addComponent(_lblAccount)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(_lblAccountName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_btnAccountDetail))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        _lblclock.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        _lblclock.setForeground(new java.awt.Color(0, 51, 255));
        _lblclock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        _lblclock.setText("_lblclock");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(_lblclock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_lblclock)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        _lblday.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        _lblday.setForeground(new java.awt.Color(255, 153, 51));
        _lblday.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        _lblday.setText("_lblday");

        _lbldatenow.setFont(new java.awt.Font("Tahoma", 0, 72)); // NOI18N
        _lbldatenow.setForeground(new java.awt.Color(255, 0, 0));
        _lbldatenow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        _lbldatenow.setText("_lbldatenow");

        _lblMonthYear.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        _lblMonthYear.setForeground(new java.awt.Color(0, 51, 255));
        _lblMonthYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        _lblMonthYear.setText("_lblMonthYear");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(_lblMonthYear, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
            .addComponent(_lbldatenow, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(_lblday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_lblday)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_lbldatenow, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(_lblMonthYear))
        );

        pnRight.setBackground(new java.awt.Color(255, 255, 255));
        pnRight.setLayout(null);

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logout_1.png"))); // NOI18N
        btnLogout.setToolTipText("Logout");
        btnLogout.setFocusable(false);
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jToolBar3.add(btnLogout);

        jToolBar5.setFloatable(false);
        jToolBar5.setRollover(true);
        jToolBar5.add(jSeparator11);

        btnCal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/calculator1.png"))); // NOI18N
        btnCal.setToolTipText("calculator");
        btnCal.setFocusable(false);
        btnCal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalActionPerformed(evt);
            }
        });
        jToolBar5.add(btnCal);

        btnSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Settings-icon 40x40.png"))); // NOI18N
        btnSetting.setToolTipText("Setting");
        btnSetting.setFocusable(false);
        btnSetting.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSetting.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingActionPerformed(evt);
            }
        });
        jToolBar5.add(btnSetting);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addComponent(pnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalActionPerformed
        try {
            Runtime.getRuntime().exec("rundll32.exe url.dll,FileProtocolHandler calc.exe");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnCalActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        parent.dispose();
        new Run().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        pnInfo info = new pnInfo(con, id_manager);
        info.setVisible(true);
        info.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnInfoActionPerformed

    private void _btnAccountDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btnAccountDetailActionPerformed
        pnInfo info = new pnInfo(con, id_manager);
        info.setVisible(true);
        info.setLocationRelativeTo(this);
    }//GEN-LAST:event__btnAccountDetailActionPerformed

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        dlChangePass changepass = new dlChangePass(true);
        changepass.setLocationRelativeTo(this);
        changepass.setVisible(true);
    }//GEN-LAST:event_btnChangePassActionPerformed

    private void btnCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusActionPerformed
        pnCustomer cus = new pnCustomer(this);
        pnRight.setLayout(new java.awt.CardLayout());
        pnRight.removeAll();
        pnRight.add(cus);
        pnRight.revalidate();
    }//GEN-LAST:event_btnCusActionPerformed

    private void btnAtmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtmActionPerformed
        pnATM atm = new pnATM(this);
        pnRight.setLayout(new java.awt.CardLayout());
        pnRight.removeAll();
        pnRight.add(atm);
        pnRight.revalidate();
    }//GEN-LAST:event_btnAtmActionPerformed

    private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositActionPerformed
        pnDeposit deposit = new pnDeposit(this);
        pnRight.setLayout(new java.awt.CardLayout());
        pnRight.removeAll();
        pnRight.add(deposit);
        pnRight.revalidate();
    }//GEN-LAST:event_btnDepositActionPerformed

    private void btnAtmCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtmCardActionPerformed
        pnATMCard atmcard = new pnATMCard(this);
        pnRight.setLayout(new java.awt.CardLayout());
        pnRight.removeAll();
        pnRight.add(atmcard);
        pnRight.revalidate();
    }//GEN-LAST:event_btnAtmCardActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        pnTransaction atmcard = new pnTransaction(this);
        pnRight.setLayout(new java.awt.CardLayout());
        pnRight.removeAll();
        pnRight.add(atmcard);
        pnRight.revalidate();
    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingActionPerformed
        pnSetting atmcard = new pnSetting(this);
        pnRight.setLayout(new java.awt.CardLayout());
        pnRight.removeAll();
        pnRight.add(atmcard);
        pnRight.revalidate();
    }//GEN-LAST:event_btnSettingActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _btnAccountDetail;
    private javax.swing.JLabel _lblAccount;
    private javax.swing.JLabel _lblAccountName;
    private javax.swing.JLabel _lblMonthYear;
    private javax.swing.JLabel _lblclock;
    private javax.swing.JLabel _lbldatenow;
    private javax.swing.JLabel _lblday;
    private javax.swing.JLabel _lblwellcome;
    private javax.swing.JButton btnAtm;
    private javax.swing.JButton btnAtmCard;
    private javax.swing.JButton btnCal;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnCus;
    private javax.swing.JButton btnDeposit;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSetting;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar5;
    public javax.swing.JPanel pnRight;
    // End of variables declaration//GEN-END:variables
    private void initData() {
        try {
            Statement stManager = con.createStatement();
            ResultSet rsManager = stManager.executeQuery("select HoTen from Manager where ID = " + id_manager + "");
            if (rsManager.next()) {
                hoten = rsManager.getString(1);
            }
            _lblAccount.setText(tendangnhap);
            _lblAccountName.setText(hoten);
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat day = new SimpleDateFormat("EEEEE");
            SimpleDateFormat datenow = new SimpleDateFormat("dd");
            SimpleDateFormat month = new SimpleDateFormat("MMMMM " + "  " + " yyyy");
            
            String _day = day.format(cal.getTime());
            String _datenow = datenow.format(cal.getTime());
            String _MonthYear = month.format(cal.getTime());
            _lblday.setText(_day);
            _lbldatenow.setText(_datenow);
            _lblMonthYear.setText(_MonthYear);
            ClockThread _clock = new ClockThread();
            _clock.start();
            rsManager.close();
            stManager.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    class ClockThread extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    ClockThread.sleep(1000);
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss ");
                    _lblclock.setText(sdf.format(cal.getTime()));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
