package Panel;

public class pnAbout extends javax.swing.JDialog {

    public pnAbout(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About Us");

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Lucida Calligraphy", 0, 18)); // NOI18N
        jLabel2.setText("ATM SYSTEM PROJECT");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(170, 80, 250, 16);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("DEVELOPMENT TEAM : ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 120, 150, 16);

        jLabel4.setText("HUY ĐẶNG TUẤN A17007 (LEADER)");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(250, 120, 230, 14);

        jLabel5.setText("PHONG TRUNG TRẦN");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(250, 150, 120, 14);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("CONTACT US :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(130, 190, 110, 16);

        jLabel9.setText("+84963505927");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(250, 190, 120, 14);

        jLabel10.setText("dthuya17007@cusc.ctu.edu.vn");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(250, 220, 130, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/main-background (Copy).jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 576, 360);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
