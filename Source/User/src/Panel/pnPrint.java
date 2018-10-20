package Panel;

import static DBClass.ConnectDB.ConnectDatabase;
import MyProject.Run;
import TBClass.tbATM;
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

public class pnPrint extends javax.swing.JPanel {

    Run run;
    int atm, card, giaodich;
    tbTransaction cus = new tbTransaction();
    boolean lang;
    ArrayList info;
    Locale locale = new Locale("vi", "VN");
    NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

    public pnPrint(Run run, boolean lang, int atm, int card, int giaodich) {
        initComponents();
        this.run = run;
        this.atm = atm;
        this.card = card;
        this.giaodich = giaodich;
        this.lang = lang;
        info = cus.getInfo(giaodich);
        initData();
        jLabel7.setText(fmt.format(cus.getBalance(cus.getKHID(card))));
        jLabel6.setText(fmt.format(info.get(6)));
        jLabel3.setText(fmt.format(cus.getFee()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(931, 626));
        setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GIAO DỊCH THÀNH CÔNG");
        add(jLabel2);
        jLabel2.setBounds(130, 170, 670, 60);

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("3.000 VND");
        add(jLabel3);
        jLabel3.setBounds(290, 310, 140, 25);

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("SỐ DƯ : ");
        add(jLabel4);
        jLabel4.setBounds(110, 360, 160, 25);

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("SỐ TIỀN : ");
        add(jLabel5);
        jLabel5.setBounds(110, 260, 120, 25);

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("3.000.000 VND");
        add(jLabel6);
        jLabel6.setBounds(290, 260, 140, 25);

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("6.000.000 VND");
        add(jLabel7);
        jLabel7.setBounds(290, 360, 160, 25);

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("PHÍ DỊCH VỤ : ");
        add(jLabel8);
        jLabel8.setBounds(110, 310, 160, 25);

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

        if (!lang) {
            try {
                Connection n = ConnectDatabase();
                Map<String, Object> params = new HashMap<>();
                params.put("GiaoDichID", cus.getRecent());
                JasperPrint jasperPrint = JasperFillManager.fillReport(new File("").getAbsolutePath() + "\\Report//Width-En.jasper", params, n);
                JasperViewer.viewReport(jasperPrint, false);
            } catch (JRException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                Connection n = ConnectDatabase();
                Map<String, Object> params = new HashMap<>();
                params.put("GiaoDichID", cus.getRecent());
                JasperPrint jasperPrint = JasperFillManager.fillReport(new File("").getAbsolutePath() + "\\Report\\Width-Vi.jasper", params, n);
                JasperViewer.viewReport(jasperPrint, false);
            } catch (JRException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

    private void initData() {
        if (!lang) {
            btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-back.png")));
            jLabel2.setText("SUCCESSFUL TRANSACTIONS");
            jLabel5.setText("AMOUNT : ");
            jLabel8.setText("SERVICE FEES: ");
            jLabel4.setText("BALANCE : ");
        }
        btnHome.setOpaque(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setBorderPainted(false);

        btnPrint.setOpaque(false);
        btnPrint.setContentAreaFilled(false);
        btnPrint.setBorderPainted(false);
    }
}
