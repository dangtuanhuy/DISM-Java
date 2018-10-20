package Panel;

import MyProject.Run;
import TBClass.tbTransaction;
import javax.swing.JOptionPane;

public class pnWithdrawal extends javax.swing.JPanel {

    Run run;
    int atm, card, khid;
    boolean lang;
    tbTransaction cus = new tbTransaction();
    
    public pnWithdrawal(Run run, boolean lang, int atm, int card) {
        initComponents();
        this.run = run;
        this.atm = atm;
        this.khid = cus.getKHID(card);
        this.card = card;
        this.lang = lang;
        
        btn50K.setOpaque(false);
        btn50K.setContentAreaFilled(false);
        btn50K.setBorderPainted(false);
        
        btn100K.setOpaque(false);
        btn100K.setContentAreaFilled(false);
        btn100K.setBorderPainted(false);
        
        btn500k.setOpaque(false);
        btn500k.setContentAreaFilled(false);
        btn500k.setBorderPainted(false);
        
        btn1m.setOpaque(false);
        btn1m.setContentAreaFilled(false);
        btn1m.setBorderPainted(false);
        
        btn2M.setOpaque(false);
        btn2M.setContentAreaFilled(false);
        btn2M.setBorderPainted(false);
        
        btnOther.setOpaque(false);
        btnOther.setContentAreaFilled(false);
        btnOther.setBorderPainted(false);
        
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        
        if(!lang){
            btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-back.png")));
            btnOther.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-other.png")));
            jLabel2.setText("PLEASE CHOOSE AMOUNT TO WITHDRAW");
            jLabel3.setText("Please select transactions");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn100K = new javax.swing.JButton();
        btn500k = new javax.swing.JButton();
        btn2M = new javax.swing.JButton();
        btn50K = new javax.swing.JButton();
        btnOther = new javax.swing.JButton();
        btn1m = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setPreferredSize(new java.awt.Dimension(931, 626));
        jPanel1.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("XIN VUI LÒNG CHỌN SỐ TIỀN MUỐN RÚT");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(190, 110, 550, 60);

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Vui lòng chọn giao dịch");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(610, 170, 310, 25);

        btn100K.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-100000.png"))); // NOI18N
        btn100K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn100KActionPerformed(evt);
            }
        });
        jPanel1.add(btn100K);
        btn100K.setBounds(20, 330, 310, 90);

        btn500k.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-500000.png"))); // NOI18N
        btn500k.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn500kActionPerformed(evt);
            }
        });
        jPanel1.add(btn500k);
        btn500k.setBounds(20, 440, 310, 90);

        btn2M.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-2M.png"))); // NOI18N
        btn2M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2MActionPerformed(evt);
            }
        });
        jPanel1.add(btn2M);
        btn2M.setBounds(620, 330, 310, 90);

        btn50K.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-50000.png"))); // NOI18N
        btn50K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn50KActionPerformed(evt);
            }
        });
        jPanel1.add(btn50K);
        btn50K.setBounds(20, 210, 310, 90);

        btnOther.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-sokhac.png"))); // NOI18N
        btnOther.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtherActionPerformed(evt);
            }
        });
        jPanel1.add(btnOther);
        btnOther.setBounds(620, 440, 310, 90);

        btn1m.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-1M_1.png"))); // NOI18N
        btn1m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1mActionPerformed(evt);
            }
        });
        jPanel1.add(btn1m);
        btn1m.setBounds(620, 210, 310, 90);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-trolai.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);
        btnBack.setBounds(370, 540, 180, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 931, 626);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 931, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn100KActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn100KActionPerformed
        if(cus.checkWith(khid, 100000, lang, cus.getCardID(card))){
            cus.width(khid, cus.getCardID(card), atm, 100000);
            run.pnMain.removeAll();
            run.pnMain.add(new pnPrint(run, lang, atm, card, cus.getRecent()));
            run.pnMain.revalidate();
        }
    }//GEN-LAST:event_btn100KActionPerformed

    private void btn500kActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn500kActionPerformed
        if(cus.checkWith(khid, 500000, lang, cus.getCardID(card))){
            cus.width(khid, cus.getCardID(card), atm, 500000);
            run.pnMain.removeAll();
            run.pnMain.add(new pnPrint(run, lang, atm, card, cus.getRecent()));
            run.pnMain.revalidate();
        }
    }//GEN-LAST:event_btn500kActionPerformed

    private void btn2MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2MActionPerformed
        if(cus.checkWith(khid, 2000000, lang, cus.getCardID(card))){
            cus.width(khid, cus.getCardID(card), atm, 2000000);
            run.pnMain.removeAll();
            run.pnMain.add(new pnPrint(run, lang, atm, card, cus.getRecent()));
            run.pnMain.revalidate();
        }
    }//GEN-LAST:event_btn2MActionPerformed

    private void btn50KActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn50KActionPerformed
        if(cus.checkWith(khid, 50000, lang, cus.getCardID(card))){
            cus.width(khid, cus.getCardID(card), atm, 50000);
            run.pnMain.removeAll();
            run.pnMain.add(new pnPrint(run, lang, atm, card, cus.getRecent()));
            run.pnMain.revalidate();
        }
    }//GEN-LAST:event_btn50KActionPerformed

    private void btnOtherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtherActionPerformed
        run.pnMain.removeAll();
        run.pnMain.add(new pnOther(run, lang, atm, card));
        run.pnMain.revalidate();
    }//GEN-LAST:event_btnOtherActionPerformed

    private void btn1mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1mActionPerformed
        if(cus.checkWith(khid, 1000000, lang, cus.getCardID(card))){
            cus.width(khid, cus.getCardID(card), atm, 1000000);
            run.pnMain.removeAll();
            run.pnMain.add(new pnPrint(run, lang, atm, card, cus.getRecent()));
            run.pnMain.revalidate();
        }
    }//GEN-LAST:event_btn1mActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        run.pnMain.removeAll();
        run.pnMain.add(new pnMain(run, lang, atm, card));
        run.pnMain.revalidate();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn100K;
    private javax.swing.JButton btn1m;
    private javax.swing.JButton btn2M;
    private javax.swing.JButton btn500k;
    private javax.swing.JButton btn50K;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnOther;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
