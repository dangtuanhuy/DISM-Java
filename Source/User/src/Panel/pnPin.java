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

public class pnPin extends javax.swing.JPanel {

    Run run;
    boolean lang;
    Locale loc;
    ResourceBundle rs;
    DefaultTableModel model;
    int atm, card, count = 0;
    tbAccount cus = new tbAccount();

    public pnPin(Run run, boolean lang, int atm, int card) {
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
        lbCard_1.setText(rs.getString("pin_1"));
        lbCard_2.setText(rs.getString("pin_2"));
        lbCard_title.setText(rs.getString("pin_title"));
    }

    public pnPin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbCard_title = new javax.swing.JLabel();
        lbCard_1 = new javax.swing.JLabel();
        lbCard_2 = new javax.swing.JLabel();
        txtPin = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(955, 674));
        setLayout(null);

        lbCard_title.setBackground(new java.awt.Color(255, 255, 255));
        lbCard_title.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        lbCard_title.setForeground(new java.awt.Color(51, 0, 51));
        lbCard_title.setText("NHẬP MÃ PIN");
        add(lbCard_title);
        lbCard_title.setBounds(380, 140, 220, 60);

        lbCard_1.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbCard_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCard_1.setText("VUI LÒNG NHẬP MÃ PIN");
        add(lbCard_1);
        lbCard_1.setBounds(20, 240, 420, 32);

        lbCard_2.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        lbCard_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCard_2.setText("VÀ NHẤN ENTER");
        add(lbCard_2);
        lbCard_2.setBounds(20, 280, 420, 32);

        txtPin.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        txtPin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPin.setText("1234");
        txtPin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        txtPin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPinMouseClicked(evt);
            }
        });
        txtPin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPinKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPinKeyReleased(evt);
            }
        });
        add(txtPin);
        txtPin.setBounds(150, 350, 170, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background-stk.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 931, 626);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPinMouseClicked
        txtPin.setText("");
    }//GEN-LAST:event_txtPinMouseClicked

    private void txtPinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPinKeyPressed
        String pin = new String(txtPin.getPassword());
        Pattern p = Pattern.compile("^[0-9]{4}$");
        Matcher m = p.matcher(pin);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(!m.matches()){
                JOptionPane.showMessageDialog(this, rs.getString("pin_pattern_err"));
            } else if(!cus.checkPin(card, Integer.parseInt(pin))){
                JOptionPane.showMessageDialog(this, rs.getString("pin_match_err"));
                count++;
            } else {
                run.pnMain.removeAll();
                run.pnMain.add(new pnMain(run, lang, atm, card));
                run.pnMain.revalidate();
            }
            if(count == 5){
                if(cus.lockAcc(card)){
                    JOptionPane.showMessageDialog(null, rs.getString("pin_lock"));
                    System.exit(0);
                }
            }
        }
    }//GEN-LAST:event_txtPinKeyPressed

    private void txtPinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPinKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPinKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbCard_1;
    private javax.swing.JLabel lbCard_2;
    private javax.swing.JLabel lbCard_title;
    private javax.swing.JPasswordField txtPin;
    // End of variables declaration//GEN-END:variables
}
