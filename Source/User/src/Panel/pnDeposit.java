package Panel;

import MyProject.Run;
import TBClass.tbAccount;
import TBClass.tbTransaction;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class pnDeposit extends javax.swing.JPanel {

    Run run;
    boolean lang;
    Locale loc;
    ResourceBundle rs;
    DefaultTableModel model;
    int atm, card, count = 0, khid;
    tbAccount cus = new tbAccount();
    tbTransaction tran = new tbTransaction();

    public pnDeposit(Run run, boolean lang, int atm, int card) {
        initComponents();
        this.run = run;
        this.lang = lang;
        this.atm = atm;
        this.card = card;
        this.khid = cus.getKHID(card);
        if (lang) {
            loc = new Locale("vi", "VN");
        } else {
            loc = new Locale("en", "EN");
        }
        rs = ResourceBundle.getBundle("Lang.td", loc);
        lbCard_1.setText(rs.getString("deposit_1"));
        lbCard_2.setText(rs.getString("deposit_2"));
        lbCard_title.setText(rs.getString("deposit_title"));
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        if(!lang){
            btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-back.png")));
        }
    }

    public pnDeposit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbCard_title = new javax.swing.JLabel();
        lbCard_1 = new javax.swing.JLabel();
        lbCard_2 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JFormattedTextField();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(955, 674));
        setLayout(null);

        lbCard_title.setBackground(new java.awt.Color(255, 255, 255));
        lbCard_title.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        lbCard_title.setForeground(new java.awt.Color(51, 0, 51));
        lbCard_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCard_title.setText("NẠP TIỀN");
        add(lbCard_title);
        lbCard_title.setBounds(280, 140, 400, 60);

        lbCard_1.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbCard_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCard_1.setText("VUI LÒNG NHẬP SỐ TIỀN");
        add(lbCard_1);
        lbCard_1.setBounds(20, 240, 420, 32);

        lbCard_2.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbCard_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCard_2.setText("VÀ NHẤN ENTER");
        add(lbCard_2);
        lbCard_2.setBounds(20, 280, 420, 32);

        txtAmount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51), 2));
        txtAmount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0 VND"))));
        txtAmount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAmount.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        txtAmount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAmountMouseClicked(evt);
            }
        });
        txtAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAmountKeyPressed(evt);
            }
        });
        add(txtAmount);
        txtAmount.setBounds(120, 340, 230, 50);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-trolai.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(10, 500, 200, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background-stk.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 931, 626);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountKeyPressed
        String pin = txtAmount.getText();
        Pattern p = Pattern.compile("^[0-9]{1,15}$");
        Matcher m = p.matcher(pin);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!m.matches()) {
                JOptionPane.showMessageDialog(this, rs.getString("deposit_pattern_err"));
            } else if (!tran.deposit(khid, cus.getCardID(card), atm, Integer.parseInt(txtAmount.getText()))) {
                JOptionPane.showMessageDialog(this, rs.getString("deposit_match_err"));
                count++;
            } else {
                JOptionPane.showMessageDialog(this, rs.getString("deposit_success"));
                run.pnMain.removeAll();
                run.pnMain.add(new pnMain(run, lang, atm, card));
                run.pnMain.revalidate();
            }
        }
    }//GEN-LAST:event_txtAmountKeyPressed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        run.pnMain.removeAll();
        run.pnMain.add(new pnMain(run, lang, atm, card));
        run.pnMain.revalidate();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtAmountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAmountMouseClicked
        txtAmount.setText("");
    }//GEN-LAST:event_txtAmountMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbCard_1;
    private javax.swing.JLabel lbCard_2;
    private javax.swing.JLabel lbCard_title;
    private javax.swing.JFormattedTextField txtAmount;
    // End of variables declaration//GEN-END:variables
}
