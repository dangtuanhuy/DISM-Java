package MyProject;

import DBClass.ServerFunction;
import Mylib.LookAndFeelWindow;
import Panel.pnConfig;
import Panel.pnError;
import Panel.pnLanguage;
import TBClass.tbATM;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Run extends javax.swing.JFrame {

    tbATM cus = new tbATM();
    Connection cn;
    ServerFunction serverConnect = new ServerFunction();

    public Run() {
        int stateFromFile = serverConnect.openConnectionFromFile();
        if (stateFromFile == 0) {
            cn = serverConnect.getConnection();
        }
        else if (stateFromFile == -1) {
            pnConfig configDialog = new pnConfig(this);
            configDialog.setLocationRelativeTo(this);
            configDialog.setVisible(true);
            String dbServerName = "", dbName = "", dbUsername = "", dbPassword = "", dbPort = "";
            if (configDialog.validated == true) {
                dbServerName = configDialog.getServerName();
                dbName = configDialog.getDatabaseName();
                dbUsername = configDialog.getUsername();
                dbPassword = configDialog.getPassword();
                dbPort = configDialog.getPort();

                serverConnect = new ServerFunction(dbServerName, dbName, dbUsername,
                        dbPassword, dbPort);
                int state = serverConnect.openConnection();
                if (state == -1) {
                    JOptionPane.showMessageDialog(this, "Error while establishing connection."
                            + " Please try running the configuration again.");
                    System.exit(0);
                } else if (state == 0) {
                    serverConnect.saveConnectionParametersToFile(dbServerName, dbName,
                            dbUsername, dbPassword, dbPort);
                    cn = serverConnect.getConnection();
                }
            } else {
                System.exit(0);
            }
        }
        initComponents();
        initData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(938, 660));
        getContentPane().setLayout(null);

        pnMain.setMinimumSize(new java.awt.Dimension(920, 615));
        pnMain.setPreferredSize(new java.awt.Dimension(920, 615));
        pnMain.setLayout(new java.awt.CardLayout());
        getContentPane().add(pnMain);
        pnMain.setBounds(0, 0, 931, 626);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Run.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Run.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Run.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Run.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Run().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel pnMain;
    // End of variables declaration//GEN-END:variables

    private void initData() {
        LookAndFeelWindow.LookAndFeelWindow();
        tbATM info = cus.randATM();
        if (info.getStatus() == 1) {
            pnMain.add(new pnLanguage(this, info.getId()));
        } else {
            pnMain.add(new pnError(this, info.getName()));
        }
        setLocationRelativeTo(this);
        setResizable(false);
    }
}
