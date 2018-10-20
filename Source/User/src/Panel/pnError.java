package Panel;

import MyProject.Run;

public class pnError extends javax.swing.JPanel {
    Run run;
    String name;
    public pnError(Run run, String name) {
        initComponents();
        this.run = run;
        this.name = name;
        initData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        lbName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(931, 626));
        setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setText("The system has occurred. Please try again later");
        add(jLabel2);
        jLabel2.setBounds(200, 260, 600, 60);

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("(Hệ thống đang xảy ra lỗi. Vui lòng thử lại sau)");
        add(jLabel3);
        jLabel3.setBounds(260, 330, 430, 25);

        btnExit.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit-icon.png"))); // NOI18N
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        add(btnExit);
        btnExit.setBounds(400, 390, 147, 57);

        lbName.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lbName.setForeground(new java.awt.Color(255, 0, 0));
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbName.setText("Khanh Trinh");
        add(lbName);
        lbName.setBounds(200, 210, 560, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 931, 626);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        run.dispose();
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables

    private void initData() {
        btnExit.setOpaque(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setBorderPainted(false);
        lbName.setText(name);
    }
}
