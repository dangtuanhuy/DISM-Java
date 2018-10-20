package Panel;

import MyProject.Run;
import TBClass.tbAccount;

public class pnMain extends javax.swing.JPanel {

    Run run;
    int atm, card;
    boolean lang;
    tbAccount cus = new tbAccount();
    public pnMain(Run run, boolean lang, int atm, int card) {
        initComponents();
        this.run = run;
        this.atm = atm;
        this.card = card;
        this.lang = lang;
        initData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnXem = new javax.swing.JButton();
        btnNap = new javax.swing.JButton();
        btnRut = new javax.swing.JButton();
        btnChuyen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(931, 626));
        setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PLEASE SELECT YOUR LANGUAGE !");
        add(jLabel2);
        jLabel2.setBounds(190, 110, 550, 60);

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Vui lòng chọn giao dịch");
        add(jLabel3);
        jLabel3.setBounds(610, 200, 310, 25);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-thoat.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        add(btnExit);
        btnExit.setBounds(370, 540, 190, 70);

        btnXem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-xemsodu.png"))); // NOI18N
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });
        add(btnXem);
        btnXem.setBounds(0, 410, 345, 100);

        btnNap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-naptien.png"))); // NOI18N
        btnNap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNapActionPerformed(evt);
            }
        });
        add(btnNap);
        btnNap.setBounds(0, 260, 345, 100);

        btnRut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-ruttien.png"))); // NOI18N
        btnRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRutActionPerformed(evt);
            }
        });
        add(btnRut);
        btnRut.setBounds(580, 260, 345, 100);

        btnChuyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-chuyenkhoan.png"))); // NOI18N
        btnChuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenActionPerformed(evt);
            }
        });
        add(btnChuyen);
        btnChuyen.setBounds(580, 410, 345, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 931, 626);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed
        pnView nap = new pnView(run, lang, atm, card);
        run.pnMain.removeAll();
        run.pnMain.add(nap);
        run.pnMain.revalidate();
    }//GEN-LAST:event_btnXemActionPerformed

    private void btnNapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNapActionPerformed
        pnDeposit nap = new pnDeposit(run, lang, atm, card);
        run.pnMain.removeAll();
        run.pnMain.add(nap);
        run.pnMain.revalidate();
    }//GEN-LAST:event_btnNapActionPerformed

    private void btnRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutActionPerformed
        pnWithdrawal rut = new pnWithdrawal(run, lang, atm, card);
        run.pnMain.removeAll();
        run.pnMain.add(rut);
        run.pnMain.revalidate();
    }//GEN-LAST:event_btnRutActionPerformed

    private void btnChuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenActionPerformed
        pnTranfer rut = new pnTranfer(run, lang, atm, card);
        run.pnMain.removeAll();
        run.pnMain.add(rut);
        run.pnMain.revalidate();
    }//GEN-LAST:event_btnChuyenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyen;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNap;
    private javax.swing.JButton btnRut;
    private javax.swing.JButton btnXem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    private void initData() {
        btnNap.setOpaque(false);
        btnNap.setContentAreaFilled(false);
        btnNap.setBorderPainted(false);
        btnExit.setOpaque(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setBorderPainted(false);
        btnRut.setOpaque(false);
        btnRut.setContentAreaFilled(false);
        btnRut.setBorderPainted(false);
        btnXem.setOpaque(false);
        btnXem.setContentAreaFilled(false);
        btnXem.setBorderPainted(false);
        btnChuyen.setOpaque(false);
        btnChuyen.setContentAreaFilled(false);
        btnChuyen.setBorderPainted(false);
        
        jLabel2.setText(cus.getName(card));
        
        if(!lang){
            btnRut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-withdrawal.png")));
            btnNap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-deposit.png")));
            btnXem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-viewbalance.png")));
            btnChuyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-tranfer.png")));
            jLabel3.setText("Plase select a transaction");
            btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-exit.png")));
        }
        
    }
}
