
package Mylib;
import DBClass.ServerFunction;
import java.sql.*;
import javax.swing.JOptionPane;

public class MyConnection {
    //Tra ve ket noi duoc thiet lap giua ung dung java va DB Server
    public static Connection getConnect(String host,String db,String user,String pass){
        ServerFunction server = new ServerFunction();
        server.setConnectParemeterFile();
        host = server.getServerName();
        db = server.getDatabaseName();
        user = server.getUserName();
        pass = server.getPassword();
        Connection cn = null;
        try {
            
            //1.Nap driver loai 4 ap dung cho SQLServer
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //2.Tao cau` noi' giua~ ung dung java va DB
            String url = "jdbc:sqlserver://"+server.getServerName()+";databasename="+server.getDatabaseName();
            
           
            cn = DriverManager.getConnection(url,server.getUserName(),server.getPassword());
            
        
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Loi sai nap driver :"+ex.getMessage());
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi sai tao ket noi :"+ex.getMessage());
            ex.printStackTrace();
        }
        return cn;
    }
    
    public static Connection Con() {
        // can add Library: sqljdbc.jar
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=ATM";
        String username = "sa";
        String password = "123";
        Connection conn = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = java.sql.DriverManager.getConnection(url,username,password);
         //   if(conn!=null) System.out.println("Connection Successful!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Can not connect to database !","Database Eror",JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }  
}
