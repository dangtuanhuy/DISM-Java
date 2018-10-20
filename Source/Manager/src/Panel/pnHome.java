package Panel;

public class pnHome extends javax.swing.JPanel {

    public pnMain main;
    public pnHome(pnMain main) {
        initComponents();
        this.main = main;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCus = new javax.swing.JButton();
        btnATM = new javax.swing.JButton();
        btnTran = new javax.swing.JButton();
        btnCard = new javax.swing.JButton();
        btnDep = new javax.swing.JButton();
        btnSett = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(750, 570));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setPreferredSize(new java.awt.Dimension(750, 58));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HOME PANEL");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(null);

        btnCus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Customer Button.png"))); // NOI18N
        btnCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusActionPerformed(evt);
            }
        });
        jPanel2.add(btnCus);
        btnCus.setBounds(59, 70, 263, 81);

        btnATM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ATM Button.png"))); // NOI18N
        btnATM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnATMActionPerformed(evt);
            }
        });
        jPanel2.add(btnATM);
        btnATM.setBounds(59, 204, 263, 81);

        btnTran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Transaction Button.png"))); // NOI18N
        btnTran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTranActionPerformed(evt);
            }
        });
        jPanel2.add(btnTran);
        btnTran.setBounds(59, 344, 263, 81);

        btnCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ATM Card Button.png"))); // NOI18N
        btnCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCardActionPerformed(evt);
            }
        });
        jPanel2.add(btnCard);
        btnCard.setBounds(408, 203, 263, 81);

        btnDep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Deposit Button.png"))); // NOI18N
        btnDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepActionPerformed(evt);
            }
        });
        jPanel2.add(btnDep);
        btnDep.setBounds(408, 70, 263, 81);

        btnSett.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Setting Button.png"))); // NOI18N
        btnSett.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettActionPerformed(evt);
            }
        });
        jPanel2.add(btnSett);
        btnSett.setBounds(408, 344, 263, 81);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/money-addiction.jpg"))); // NOI18N
        jLabel2.setToolTipText("");
        jLabel2.setMaximumSize(new java.awt.Dimension(726, 489));
        jLabel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel2.setPreferredSize(new java.awt.Dimension(726, 489));
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 750, 520);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnATMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnATMActionPerformed
        pnATM atm = new pnATM(main);
        main.pnRight.setLayout(new java.awt.CardLayout());
        main.pnRight.removeAll();
        main.pnRight.add(atm);
        main.pnRight.revalidate();
    }//GEN-LAST:event_btnATMActionPerformed

    private void btnCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusActionPerformed
        pnCustomer cus = new pnCustomer(main);
        main.pnRight.setLayout(new java.awt.CardLayout());
        main.pnRight.removeAll();
        main.pnRight.add(cus);
        main.pnRight.revalidate();
    }//GEN-LAST:event_btnCusActionPerformed

    private void btnDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepActionPerformed
        pnDeposit dep = new pnDeposit(main);
        main.pnRight.setLayout(new java.awt.CardLayout());
        main.pnRight.removeAll();
        main.pnRight.add(dep);
        main.pnRight.revalidate();
    }//GEN-LAST:event_btnDepActionPerformed

    private void btnCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCardActionPerformed
        pnATMCard card = new pnATMCard(main);
        main.pnRight.setLayout(new java.awt.CardLayout());
        main.pnRight.removeAll();
        main.pnRight.add(card);
        main.pnRight.revalidate();
    }//GEN-LAST:event_btnCardActionPerformed

    private void btnTranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTranActionPerformed
        pnTransaction tra = new pnTransaction(main);
        main.pnRight.setLayout(new java.awt.CardLayout());
        main.pnRight.removeAll();
        main.pnRight.add(tra);
        main.pnRight.revalidate();
    }//GEN-LAST:event_btnTranActionPerformed

    private void btnSettActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettActionPerformed
        pnSetting set = new pnSetting(main);
        main.pnRight.setLayout(new java.awt.CardLayout());
        main.pnRight.removeAll();
        main.pnRight.add(set);
        main.pnRight.revalidate();
    }//GEN-LAST:event_btnSettActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnATM;
    private javax.swing.JButton btnCard;
    private javax.swing.JButton btnCus;
    private javax.swing.JButton btnDep;
    private javax.swing.JButton btnSett;
    private javax.swing.JButton btnTran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
