package DBClass;
import Mylib.MyConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class ConnectDB {

    static ServerFunction server = new ServerFunction();
    static Connection cn;
    
    public static Connection ConnectDatabase() {
        String _drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        
        try {
            Class.forName(_drivername);
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }
    
    public static void runReport(String reportFile) {
      try{
         Connection n = ConnectDatabase();
         JasperPrint jasperPrint = JasperFillManager.fillReport(reportFile, null, n);
         JasperViewer.viewReport(jasperPrint,false);
      }catch(JRException ex) {
          JOptionPane.showMessageDialog(null, String.valueOf(ex.getMessage()));
      }
   }
}
