package TBClass;

import DBClass.ServerFunction;
import Mylib.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tbAccount {

    ServerFunction server = new ServerFunction();
    
    public boolean checkCard(int id) {
        ResultSet rsATM = null;
        Connection cn = null;
        PreparedStatement pst = null;
        boolean record = false;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT ATMCardID FROM ATMCard WHERE ATMCardID = ? AND ATMCard_Status = 1 AND (SELECT Cus_Status FROM KhachHang WHERE ID = (SELECT Customer_ID FROM ATMCARD WHERE ATMCARDID = ?)) = 1");
            pst.setInt(1, id);
            pst.setInt(2, id);
            rsATM = pst.executeQuery();
            if (rsATM.next()) {
                record = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rsATM != null) {
                    rsATM.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return record;
    }
    
    public boolean checkSTK(String id) {
        ResultSet rsATM = null;
        Connection cn = null;
        PreparedStatement pst = null;
        boolean record = false;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT ID FROM KhachHang WHERE Cus_Account = ?");
            pst.setString(1, id);
            rsATM = pst.executeQuery();
            if (rsATM.next()) {
                record = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rsATM != null) {
                    rsATM.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return record;
    }
    
    public String getSTKByKH(int kh) {
        ResultSet rsATM = null;
        Connection cn = null;
        PreparedStatement pst = null;
        String record = "";
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT Cus_Account FROM KhachHang WHERE ID = (SELECT Customer_ID FROM ATMCard WHERE ATMCARDID = ?)");
            pst.setInt(1, kh);
            rsATM = pst.executeQuery();
            if (rsATM.next()) {
                record = rsATM.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rsATM != null) {
                    rsATM.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return record;
    }
    
    public boolean checkPin(int id, int pin) {
        ResultSet rsATM = null;
        Connection cn = null;
        PreparedStatement pst = null;
        boolean record = false;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT ATMCardID FROM ATMCard WHERE Pin = ? AND ATMCARDID = ?");
            pst.setInt(2, id);
            pst.setInt(1, pin);
            rsATM = pst.executeQuery();
            if (rsATM.next()) {
                record = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rsATM != null) {
                    rsATM.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return record;
    }
    
    public String getName(int id){
        ResultSet rsATM = null;
        Connection cn = null;
        PreparedStatement pst = null;
        String record = null;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT Cus_Name FROM KhachHang WHERE ID = (SELECT Customer_ID FROM ATMCard WHERE ATMCardID = ?)");
            pst.setInt(1, id);
            rsATM = pst.executeQuery();
            if (rsATM.next()) {
                record = rsATM.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rsATM != null) rsATM.close();
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return record;
    }
    
    public int getKHID(int id){
        ResultSet rsATM = null;
        Connection cn = null;
        PreparedStatement pst = null;
        int record = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT Customer_ID FROM ATMCard WHERE ATMCardID = ?");
            pst.setInt(1, id);
            rsATM = pst.executeQuery();
            if (rsATM.next()) {
                record = rsATM.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rsATM != null) rsATM.close();
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return record;
    }
    
    public int getCardID(int id){
        ResultSet rsATM = null;
        Connection cn = null;
        PreparedStatement pst = null;
        int record = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT ID FROM ATMCard WHERE ATMCardID = ?");
            pst.setInt(1, id);
            rsATM = pst.executeQuery();
            if (rsATM.next()) {
                record = rsATM.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rsATM != null) rsATM.close();
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return record;
    }
    
    public boolean lockAcc(int id){
        ResultSet rsATM = null;
        Connection cn = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("UPDATE ATMCARD SET ATMCard_Status = 0 WHERE ATMCARDID = ?");
            pst.setInt(1, id);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rsATM != null) rsATM.close();
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return (result > 0);
    }
}
