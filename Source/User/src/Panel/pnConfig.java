package Panel;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import javax.swing.JOptionPane;
import MyProject.Run;

public class pnConfig extends javax.swing.JDialog {

    public boolean validated;
    private String serverName, databaseName, username, password, port;

    public String getDatabaseName() {
        return databaseName;
    }

    public String getPassword() {
        return password;
    }

    public String getPort() {
        return port;
    }

    public String getServerName() {
        return serverName;
    }

    public String getUsername() {
        return username;
    }

    public pnConfig(MyProject.Run parent) {
        super(parent, "Database Configuration", true);
        initComponents();
        txtServerName.requestFocusInWindow();
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        setTitle("DATABASE CONFIGURATION");
    }

    public pnConfig() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtServerName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDatabaseName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtLoginName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txtPortNumber = new javax.swing.JTextField();
        chkPortDefault = new javax.swing.JCheckBox();
        btSave = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setText("Login ID:");

        setMinimumSize(new java.awt.Dimension(680, 370));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 51));
        jLabel2.setText("ATM Database Configuration");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(200, 30, 320, 26);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Server:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 80, 56, 19);

        txtServerName.setText("localhost");
        jPanel1.add(txtServerName);
        txtServerName.setBounds(220, 72, 380, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Database Name:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 120, 126, 19);

        txtDatabaseName.setText("ATM");
        jPanel1.add(txtDatabaseName);
        txtDatabaseName.setBounds(220, 112, 380, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Login ID:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 160, 70, 19);

        txtLoginName.setText("sa");
        jPanel1.add(txtLoginName);
        txtLoginName.setBounds(220, 152, 380, 30);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Password:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(60, 200, 83, 19);

        txtPassword.setText("123");
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassword);
        txtPassword.setBounds(220, 192, 380, 30);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Port:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(60, 240, 38, 19);

        txtPortNumber.setEditable(false);
        txtPortNumber.setText("1433");
        jPanel1.add(txtPortNumber);
        txtPortNumber.setBounds(220, 232, 170, 30);

        chkPortDefault.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        chkPortDefault.setSelected(true);
        chkPortDefault.setText("Use default port");
        chkPortDefault.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkPortDefaultStateChanged(evt);
            }
        });
        jPanel1.add(chkPortDefault);
        chkPortDefault.setBounds(430, 237, 170, 30);

        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/_active__yes.png"))); // NOI18N
        btSave.setText("Save");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btSave);
        btSave.setBounds(250, 281, 97, 30);

        btExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete.png"))); // NOI18N
        btExit.setText("Exit");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });
        jPanel1.add(btExit);
        btExit.setBounds(370, 281, 89, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/config_background.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 680, 330);

        getContentPane().add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void chkPortDefaultStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkPortDefaultStateChanged
        if (chkPortDefault.isSelected()) {
            txtPortNumber.setText("1433");
            txtPortNumber.setEditable(false);
        } else {
            txtPortNumber.setEditable(true);
        }
    }//GEN-LAST:event_chkPortDefaultStateChanged

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        String server = txtServerName.getText().trim();
        String dataName = txtDatabaseName.getText().trim();
        String portSQL = txtPortNumber.getText().trim();
        String user = txtLoginName.getText().trim();
        String pass = txtPassword.getText().trim();
        if (server.equals("")) {
            JOptionPane.showMessageDialog(null, "Server name cannot be blank !");
            txtServerName.requestFocusInWindow();
            return;
        }
        if (dataName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Database name cannot be blank !");
            txtDatabaseName.requestFocusInWindow();
            return;
        }
        if (portSQL.isEmpty() && !chkPortDefault.isSelected()) {
            JOptionPane.showMessageDialog(null, "Port cannot be blank !");
            txtPortNumber.requestFocusInWindow();
            return;
        }
        if (user.isEmpty()) {
            JOptionPane.showMessageDialog(null, "User name cannot be blank !");
            txtLoginName.requestFocusInWindow();
            return;
        }
        if (pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password cannot be blank !");
            txtPassword.requestFocusInWindow();
            return;
        }
        this.serverName = server;
        this.databaseName = dataName;
        this.username = user;
        this.password = pass;
        this.port = chkPortDefault.isSelected() ? "1433" : portSQL;
        validated = true;
        dispose();

    }//GEN-LAST:event_btSaveActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        validated = false;
        dispose();
    }//GEN-LAST:event_btExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExit;
    private javax.swing.JButton btSave;
    private javax.swing.JCheckBox chkPortDefault;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDatabaseName;
    private javax.swing.JTextField txtLoginName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPortNumber;
    private javax.swing.JTextField txtServerName;
    // End of variables declaration//GEN-END:variables
}
