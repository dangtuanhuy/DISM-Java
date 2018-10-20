package Panel;

import MyProject.Run;
import TBClass.tbATM;

public class pnLanguage extends javax.swing.JPanel {

    Run run;
    int atm;
    tbATM cus = new tbATM();
    public pnLanguage(Run run, int atm) {
        initComponents();
        this.run = run;
        this.atm = atm;
        initData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnEn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(931, 626));
        setLayout(null);

        btnVi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-tiengviet.png"))); // NOI18N
        btnVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViActionPerformed(evt);
            }
        });
        add(btnVi);
        btnVi.setBounds(320, 320, 305, 80);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setText("PLEASE SELECT YOUR LANGUAGE !");
        add(jLabel2);
        jLabel2.setBounds(260, 170, 440, 60);

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("(VUI LÒNG CHỌN NGÔN NGỮ CỦA BẠN)");
        add(jLabel3);
        jLabel3.setBounds(290, 230, 370, 25);

        btnEn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-english.png"))); // NOI18N
        btnEn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnActionPerformed(evt);
            }
        });
        add(btnEn);
        btnEn.setBounds(320, 400, 305, 85);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 931, 626);
    }// </editor-fold>//GEN-END:initComponents

    private void btnViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViActionPerformed
        run.pnMain.removeAll();
        run.pnMain.add(new pnAccount(run, true, atm));
        run.pnMain.revalidate();
    }//GEN-LAST:event_btnViActionPerformed

    private void btnEnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnActionPerformed
        run.pnMain.removeAll();
        run.pnMain.add(new pnAccount(run, false, atm));
        run.pnMain.revalidate();
    }//GEN-LAST:event_btnEnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEn;
    private javax.swing.JButton btnVi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    private void initData() {
        btnVi.setOpaque(false);
        btnVi.setContentAreaFilled(false);
        btnVi.setBorderPainted(false);
        btnEn.setOpaque(false);
        btnEn.setContentAreaFilled(false);
        btnEn.setBorderPainted(false);
    }
}
