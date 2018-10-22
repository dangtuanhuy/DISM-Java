package Panel;

import MyProject.Run;
import TBClass.tbAccount;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class pnTranfer extends javax.swing.JPanel {

    Run run;
    boolean lang;
    Locale loc;
    ResourceBundle rs;
    DefaultTableModel model;
    int atm, card;
    tbAccount cus = new tbAccount();

    public pnTranfer(Run run, boolean lang, int atm, int card) {
        initComponents();
        this.run = run;
        this.lang = lang;
        this.atm = atm;
        this.card = card;

        if (lang) {
            loc = new Locale("vi", "VN");
        } else {
            loc = new Locale("en", "EN");
        }
        rs = ResourceBundle.getBundle("Lang.td", loc);
        lbCard_1.setText(rs.getString("tranfer_1"));
        lbCard_2.setText(rs.getString("tranfer_2"));
        lbCard_title.setText(rs.getString("tranfer_title"));
    }

    public pnTranfer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbCard_title = new javax.swing.JLabel();
        lbCard_1 = new javax.swing.JLabel();
        lbCard_2 = new javax.swing.JLabel();
        txtSTK = new javax.swing.JFormattedTextField();
        btnHome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(955, 674));
        setLayout(null);

        lbCard_title.setBackground(new java.awt.Color(255, 255, 255));
        lbCard_title.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        lbCard_title.setForeground(new java.awt.Color(51, 0, 51));
        lbCard_title.setText("NHẬP MÃ CARD");
        add(lbCard_title);
        lbCard_title.setBounds(380, 140, 220, 60);

        lbCard_1.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbCard_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCard_1.setText("NHẬP SỐ TÀI KHOẢN NGƯỜI NHẬN");
        add(lbCard_1);
        lbCard_1.setBounds(20, 240, 420, 32);

        lbCard_2.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbCard_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCard_2.setText("VÀ NHẤN ENTER");
        add(lbCard_2);
        lbCard_2.setBounds(20, 280, 420, 32);

        txtSTK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        try {
            txtSTK.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtSTK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSTK.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        txtSTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSTKMouseClicked(evt);
            }
        });
        txtSTK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSTKKeyPressed(evt);
            }
        });
        add(txtSTK);
        txtSTK.setBounds(140, 350, 170, 50);

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-back.png"))); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        add(btnHome);
        btnHome.setBounds(20, 530, 190, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BannerTran.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 931, 626);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSTKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSTKKeyPressed
        Pattern p = Pattern.compile("^[0-9]{9}$");
        Matcher m = p.matcher(txtSTK.getText());
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!m.matches()) {
                JOptionPane.showMessageDialog(this, rs.getString("tranfer_pattern_err"));
            } else if (!cus.checkSTK(txtSTK.getText()) || txtSTK.getText().equalsIgnoreCase(cus.getSTKByKH(card))) {
                JOptionPane.showMessageDialog(this, rs.getString("tranfer_match_err"));
            } else {
                run.pnMain.removeAll();
                run.pnMain.add(new pnTranferMoney(run, lang, atm, card, txtSTK.getText()));
                run.pnMain.revalidate();
            }
        }
    }//GEN-LAST:event_txtSTKKeyPressed

    private void txtSTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSTKMouseClicked
        txtSTK.setText("");
    }//GEN-LAST:event_txtSTKMouseClicked

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        run.pnMain.removeAll();
        run.pnMain.add(new pnWithdrawal(run, lang, atm, card));
        run.pnMain.revalidate();
    }//GEN-LAST:event_btnHomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbCard_1;
    private javax.swing.JLabel lbCard_2;
    private javax.swing.JLabel lbCard_title;
    private javax.swing.JFormattedTextField txtSTK;
    // End of variables declaration//GEN-END:variables
}
