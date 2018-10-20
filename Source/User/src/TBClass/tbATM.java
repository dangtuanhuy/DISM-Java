package TBClass;

import DBClass.ServerFunction;
import Mylib.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tbATM {
    private String name, localtion;
    private int status, id;

    ServerFunction server = new ServerFunction();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocaltion() {
        return localtion;
    }

    public void setLocaltion(String localtion) {
        this.localtion = localtion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public tbATM(String name, String localtion, int status, int id) {
        this.name = name;
        this.localtion = localtion;
        this.status = status;
        this.id = id;
    }

    public tbATM() {
    }
    
    public tbATM randATM(){
        ResultSet rsATM = null;
        Connection cn = null;
        PreparedStatement pst = null;
        tbATM record = null;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT TOP 1 * FROM ATM ORDER BY newid()");
            rsATM = pst.executeQuery();
            if (rsATM.next()) {
                record = new tbATM(rsATM.getString(2), rsATM.getString(3), rsATM.getInt(4), rsATM.getInt(1));
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
    
    public String getName(int id){
        ResultSet rsATM = null;
        Connection cn = null;
        PreparedStatement pst = null;
        String record = null;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT Ten FROM ATM WHERE ID = ?");
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
    
    
}
