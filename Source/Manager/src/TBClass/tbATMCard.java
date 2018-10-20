package TBClass;

import DBClass.ServerFunction;
import Mylib.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

public class tbATMCard {

    private int id, cardid, pin, khid, status;
    private Date thoigian, thoihan;
    String name;
    ServerFunction server = new ServerFunction();

    public tbATMCard() {
    }

    public tbATMCard(int id, int cardid, int pin, int khid, int status, Date thoigian, Date thoihan) {
        this.id = id;
        this.cardid = cardid;
        this.pin = pin;
        this.khid = khid;
        this.status = status;
        this.thoigian = thoigian;
        this.thoihan = thoihan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardid() {
        return cardid;
    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getKhid() {
        return khid;
    }

    public void setKhid(int khid) {
        this.khid = khid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public Date getThoihan() {
        return thoihan;
    }

    public void setThoihan(Date thoihan) {
        this.thoihan = thoihan;
    }

    public ServerFunction getServer() {
        return server;
    }

    public void setServer(ServerFunction server) {
        this.server = server;
    }

    public Vector toVector() {
        Vector a = new Vector();
        a.add(cardid);
        a.add(getName(khid));
        a.add(thoigian);
        a.add(thoihan);
        if (status == 1) {
            a.add(true);
        } else {
            a.add(false);
        }
        return a;
    }
    
    public Vector toCardVector() {
        Vector a = new Vector();
        a.add(cardid);
        a.add(thoigian);
        a.add(thoihan);
        if (status == 1) {
            a.add(true);
        } else {
            a.add(false);
        }
        return a;
    }

    public ArrayList<tbATMCard> getList() {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;

        ArrayList<tbATMCard> listCus = new ArrayList();
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT * FROM ATMCard");
            rsCus = pst.executeQuery();
            while (rsCus.next()) {
                tbATMCard record = new tbATMCard(rsCus.getInt(1), rsCus.getInt(2), rsCus.getInt(3), rsCus.getInt(4), rsCus.getInt(7), rsCus.getDate(5), rsCus.getDate(6));
                listCus.add(record);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rsCus != null) rsCus.close();
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listCus;
    }

    public ArrayList<tbATMCard> getListByKHID(int khid) {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;

        ArrayList<tbATMCard> listCus = new ArrayList();
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT * FROM ATMCard WHERE KHID = ?");
            pst.setInt(1, khid);
            rsCus = pst.executeQuery();
            while (rsCus.next()) {
                tbATMCard record = new tbATMCard(rsCus.getInt(1), rsCus.getInt(2), rsCus.getInt(3), rsCus.getInt(4), rsCus.getInt(7), rsCus.getDate(5), rsCus.getDate(6));
                listCus.add(record);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rsCus != null) rsCus.close();
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listCus;
    }
    
     public int getCardID(int cardid) {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        int name = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT ID FROM ATMCARD WHERE atmcardid = ?");
            pst.setInt(1, cardid);
            rsCus = pst.executeQuery();
            while (rsCus.next()) {
                name = rsCus.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rsCus != null) rsCus.close();
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return name;
    }
    
    public String getName(int khid) {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        String name = "";
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT HoTen FROM KhachHang WHERE id = ?");
            pst.setInt(1, khid);
            rsCus = pst.executeQuery();
            while (rsCus.next()) {
                name = rsCus.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rsCus != null) rsCus.close();
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return name;
    }

    public tbATMCard getInfo(int id) {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        tbATMCard record = null;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT * FROM ATMCard WHERE atmcardid = ?");
            pst.setInt(1, id);
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                record = new tbATMCard(rsCus.getInt(1), rsCus.getInt(2), rsCus.getInt(3), rsCus.getInt(4), rsCus.getInt(7), rsCus.getDate(5), rsCus.getDate(6));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rsCus != null) rsCus.close();
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return record;
    }

    public ArrayList getFullInfo(int id) {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ArrayList listInfo = new ArrayList();
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT a.*, b.* FrOM ATMCard a JOIN KhachHang b ON a.KHID = b.ID Where a.ID = ?");
            pst.setInt(1, id);
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                listInfo.add(rsCus.getInt(2));
                listInfo.add(rsCus.getInt(3));
                listInfo.add(rsCus.getDate(5));
                listInfo.add(rsCus.getDate(6));
                listInfo.add(rsCus.getInt(7));
                listInfo.add(rsCus.getString(9));
                listInfo.add(rsCus.getString(10));
                listInfo.add(rsCus.getString(11));
                listInfo.add(rsCus.getString(12));
                listInfo.add(rsCus.getString(13));
                listInfo.add(rsCus.getInt(14));
                listInfo.add(rsCus.getLong(16));
                listInfo.add(rsCus.getDate(17));
                listInfo.add(rsCus.getString(18));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rsCus != null) rsCus.close();
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listInfo;
    }

    public ArrayList getFullInfoKH(int atmcardid) {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ArrayList listInfo = new ArrayList();
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT a.*, b.* FrOM ATMCard a JOIN KhachHang b ON a.KHID = b.ID Where a.atmcardid = ?");
            pst.setInt(1, atmcardid);
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                listInfo.add(rsCus.getInt(2));
                listInfo.add(rsCus.getInt(3));
                listInfo.add(rsCus.getDate(5));
                listInfo.add(rsCus.getDate(6));
                listInfo.add(rsCus.getInt(7));
                listInfo.add(rsCus.getString(9));
                listInfo.add(rsCus.getString(10));
                listInfo.add(rsCus.getString(11));
                listInfo.add(rsCus.getString(12));
                listInfo.add(rsCus.getString(13));
                listInfo.add(rsCus.getInt(14));
                listInfo.add(rsCus.getLong(16));
                listInfo.add(rsCus.getDate(17));
                listInfo.add(rsCus.getString(18));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rsCus != null) rsCus.close();
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listInfo;
    }

    public boolean insert(tbATMCard tbCus) {
        Connection cn = null;
        PreparedStatement pst = null;
        int result = 0;
        int nextStk;
        ResultSet rsCus = null;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT IDENT_CURRENT('ATMCard') + IDENT_INCR('ATMCard') AS Number");
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                nextStk = rsCus.getInt(1) + 10000;
                cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
                pst = cn.prepareCall("INSERT INTO [dbo].[ATMCard] ([ATMCardID],[PIN],[KHID],[ThoiGian],[ThoiHan],[TrangThai]) VALUES (?,?,?,?,?,?)");
                pst.setInt(1, nextStk);
                pst.setInt(2, tbCus.pin);
                pst.setInt(3, tbCus.khid);
                pst.setDate(4, new java.sql.Date(tbCus.thoigian.getTime()));
                pst.setDate(5, new java.sql.Date(tbCus.thoihan.getTime()));
                pst.setInt(6, tbCus.status);
                result = pst.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null, "Qua trinh xu ly xay ra loi");
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
        return (result > 0);
    }

    public int nextID() {
        Connection cn = null;
        PreparedStatement pst = null;
        int nextStk = 0;
        ResultSet rsCus = null;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT IDENT_CURRENT('ATMCard') + IDENT_INCR('ATMCard') AS Number");
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                nextStk = rsCus.getInt(1) + 10000;
            } else {
                JOptionPane.showMessageDialog(null, "Qua trinh xu ly xay ra loi");
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
        return nextStk;
    }

    public tbATMCard getRecent() {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        tbATMCard record = null;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT TOP 1 PERCENT * FROM ATMCard ORDER BY id DESC");
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                record = new tbATMCard(rsCus.getInt(1), rsCus.getInt(2), rsCus.getInt(3), rsCus.getInt(4), rsCus.getInt(7), rsCus.getDate(5), rsCus.getDate(6));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rsCus != null) rsCus.close();
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return record;
    }

    public boolean update(tbATMCard tbCus) {
        Connection cn = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("UPDATE [dbo].[ATMCard] SET [PIN] = ?,[KHID] = ?,[ThoiGian] = ?,[ThoiHan] = ?,[TrangThai] = ? WHERE ATMCardID = ?");
            pst.setInt(1, tbCus.pin);
            pst.setInt(2, tbCus.khid);
            pst.setDate(3, new java.sql.Date(tbCus.thoigian.getTime()));
            pst.setDate(4, new java.sql.Date(tbCus.thoihan.getTime()));
            pst.setInt(5, tbCus.status);
            pst.setInt(6, tbCus.cardid);
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
        return (result > 0);
    }

    public boolean delete(int id) {
        Connection cn = null;
        ResultSet rsGiaoDich = null;
        PreparedStatement pst = null;
        PreparedStatement giaodich = null;
        int result = 0;
        boolean status = false;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            giaodich = cn.prepareCall("SELECT * FROM GiaoDich WHERE ATMCARDID = ?");
            giaodich.setInt(1, cardid);
            rsGiaoDich = giaodich.executeQuery();

            if (!rsGiaoDich.next()) {
                pst = cn.prepareCall("DELETE FROM ATMCard WHERE ATMCARDID = ?");
                pst.setInt(1, id);
                result = pst.executeUpdate();
                if (result == 1) {
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
