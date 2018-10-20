package Panel;

import static DBClass.ConnectDB.ConnectDatabase;
import MyProject.Run;
import TBClass.tbTransaction;
import java.io.File;
import java.sql.Connection;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class pnView extends javax.swing.JPanel {

    Run run;
    int atm, card, khid;
    tbTransaction cus = new tbTransaction();
    boolean lang;
    ArrayList info;
    Locale locale = new Locale("vi", "VN");
    NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

    public pnView(Run run, boolean lang, int atm, int card) {
        initComponents();
        this.run = run;
        this.atm = atm;
        this.card = card;
        this.lang = lang;
        this.khid = cus.getKHID(card);
        
        info = cus.viewBalance(khid);
        initData();
        jLabel7.setText(info.get(0).toString());
        jLabel10.setText(fmt.format(info.get(1)).toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(931, 626));
        setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("XEM SỐ DƯ");
        add(jLabel2);
        jLabel2.setBounds(140, 180, 670, 60);

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("CHỦ TÀI KHOẢN : ");
        add(jLabel4);
        jLabel4.setBounds(120, 270, 170, 25);

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("NGUYỄN CẢNH KHÁNH TRÌNH");
        add(jLabel7);
        jLabel7.setBounds(320, 270, 330, 25);

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-trolai.png"))); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        add(btnHome);
        btnHome.setBounds(30, 490, 190, 60);

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-print.png"))); // NOI18N
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        add(btnPrint);
        btnPrint.setBounds(720, 490, 190, 67);

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("SỐ DƯ : ");
        add(jLabel9);
        jLabel9.setBounds(120, 330, 180, 25);

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("6.000.000 VND");
        add(jLabel10);
        jLabel10.setBounds(310, 330, 330, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/background.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 931, 626);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        run.pnMain.removeAll();
        run.pnMain.add(new pnMain(run, lang, atm, card));
        run.pnMain.revalidate();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
            try {
                Connection n = ConnectDatabase();
                Map<String, Object> params = new HashMap<>();
                params.put("balance", info.get(1));
                params.put("ID", cus.getCardID(card));
                JasperPrint jasperPrint = JasperFillManager.fillReport(new File("").getAbsolutePath() + "\\Report\\viewbalance.jasper", params, n);
                JasperViewer.viewReport(jasperPrint, false);
            } catch (JRException ex) {
                ex.printStackTrace();
            }
    }//GEN-LAST:event_btnPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables

    private void initData() {
        if (!lang) {
            btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-back.png")));
            jLabel2.setText("VIEW BALANCE");
            jLabel4.setText("FULL NAME : ");
            jLabel9.setText("BALANCE : ");
            
            
        }
        btnHome.setOpaque(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setBorderPainted(false);

        btnPrint.setOpaque(false);
        btnPrint.setContentAreaFilled(false);
        btnPrint.setBorderPainted(false);
    }
}
