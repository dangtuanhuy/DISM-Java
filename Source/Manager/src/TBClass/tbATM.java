package TBClass;

import DBClass.ServerFunction;
import Mylib.MyConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class tbATM {

    private String name, localtion;
    private int status, id;
    private boolean isActivate;

    ServerFunction server = new ServerFunction();

    public tbATM() {
    }

    public tbATM(int id, String name, String localtion, int status) {
        this.id = id;
        this.name = name;
        this.localtion = localtion;
        this.status = status;

    }

    public Vector toVector() {
        Vector vtAtm = new Vector();
        vtAtm.add(id);
        vtAtm.add(name);
        vtAtm.add(localtion);
        isActivate = status == 1;
        vtAtm.add(isActivate);
        return vtAtm;
    }

    public String getName() {
        return name;
    }

    public String getLocaltion() {
        return localtion;
    }

    public int getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public ArrayList<tbATM> getList() {
        ResultSet rsATM = null;
        Connection cn = null;
        PreparedStatement pst = null;

        ArrayList<tbATM> listATM = new ArrayList();
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT * FROM ATM");
            rsATM = pst.executeQuery();
            while (rsATM.next()) {
                tbATM record = new tbATM(rsATM.getInt(1), rsATM.getString(2), rsATM.getString(3), rsATM.getInt(4));
                listATM.add(record);
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
        return listATM;
    }

    public tbATM getInfo(int id) {
        ResultSet rsATM = null;
        Connection cn = null;
        PreparedStatement pst = null;
        tbATM record = null;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT * FROM ATM WHERE id = ?");
            pst.setInt(1, id);
            rsATM = pst.executeQuery();
            if (rsATM.next()) {
                record = new tbATM(rsATM.getInt(1), rsATM.getString(2), rsATM.getString(3), rsATM.getInt(4));
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

    public boolean insert(String name, String localtion, int status) {
        Connection cn = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("INSERT INTO [dbo].[ATM] ([Ten],[DiaDiem],[TrangThai]) VALUES (?,?,?)");
            pst.setString(1, name);
            pst.setString(2, localtion);
            pst.setInt(3, status);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return (result > 0 ? true : false);
    }

    public tbATM getRecent() {
        ResultSet rsATM = null;
        Connection cn = null;
        PreparedStatement pst = null;
        tbATM record = null;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT TOP 1 PERCENT * FROM ATM ORDER BY id DESC");
            rsATM = pst.executeQuery();
            if (rsATM.next()) {
                record = new tbATM(rsATM.getInt(1), rsATM.getString(2), rsATM.getString(3), rsATM.getInt(4));
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

    public boolean update(tbATM tbUpdate) {
        Connection cn = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("UPDATE [dbo].[ATM] SET [Ten] = ?,[DiaDiem] = ?,[TrangThai] = ? WHERE ID = ?");
            pst.setString(1, tbUpdate.name);
            pst.setString(2, tbUpdate.localtion);
            pst.setInt(3, tbUpdate.status);
            pst.setInt(4, tbUpdate.id);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return (result > 0 ? true : false);
    }

    public boolean delete(int id) {
        Connection cn = null;
        ResultSet rsRecord = null;
        PreparedStatement pst = null;
        PreparedStatement record = null;
        int result = 0;
        boolean status = false;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            record = cn.prepareCall("SELECT * FROM GiaoDich WHERE ATMID = ?");
            record.setInt(1, id);
            rsRecord = record.executeQuery();
            if (!rsRecord.next()) {
                pst = cn.prepareCall("DELETE FROM ATM WHERE ID = ?");
                pst.setInt(1, id);
                result = pst.executeUpdate();
                if(result == 1){
                    status = true;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return status;
    }
}
