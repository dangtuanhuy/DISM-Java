package TBClass;

import DBClass.ServerFunction;
import Mylib.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TreeMap;
import java.util.Vector;

public class tbDeposit {

    private int id, atmcard, khid;
    private String khname, atmname;
    private long balance;
    Date date;
    ServerFunction server = new ServerFunction();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Locale locale = new Locale("vi", "VN");
    NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKhname() {
        return khname;
    }

    public void setKhname(String khname) {
        this.khname = khname;
    }

    public String getAtmname() {
        return atmname;
    }

    public void setAtmname(String atmname) {
        this.atmname = atmname;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAtmcard() {
        return atmcard;
    }

    public void setAtmcard(int atmcard) {
        this.atmcard = atmcard;
    }

    public int getKhid() {
        return khid;
    }

    public void setKhid(int khid) {
        this.khid = khid;
    }

    public tbDeposit(int id, int atmcard, String khname, String atmname, long balance, Date date, int khid) {
        this.id = id;
        this.atmcard = atmcard;
        this.khname = khname;
        this.atmname = atmname;
        this.balance = balance;
        this.date = date;
        this.khid = khid;
    }

    public Vector toVector() {
        Vector a = new Vector();
        a.add(id);
        a.add(khname);
        a.add(fmt.format(balance));
        a.add(atmname);
        a.add(atmcard);
        a.add(dateFormat.format(date));
        return a;
    }

    public tbDeposit() {
    }

    public ArrayList<tbDeposit> getList() {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;

        ArrayList<tbDeposit> listCus = new ArrayList();
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT a.ID, d.HoTen, a.SoTien, b.Ten, c.ATMCardID, a.ThoiGian, d.id FROM ((GiaoDich a INNER JOIN ATM b ON a.ATMID = b.ID) INNER JOIN ATMCard c ON a.ATMCardID = c.ID) INNER JOIN KhachHang d ON a.KHID = d.ID WHERE a.thaotac = 0 AND a.TrangThai = 0");
            rsCus = pst.executeQuery();
            while (rsCus.next()) {
                tbDeposit record = new tbDeposit(rsCus.getInt(1), rsCus.getInt(5), rsCus.getString(2), rsCus.getString(4), rsCus.getLong(3), rsCus.getTimestamp(6), rsCus.getInt(7));
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

    public tbDeposit getInfo(int id) {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        tbDeposit record = null;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT a.ID, d.HoTen, a.SoTien, b.Ten, c.ATMCardID, a.ThoiGian, d.id FROM ((GiaoDich a INNER JOIN ATM b ON a.ATMID = b.ID) INNER JOIN ATMCard c ON a.ATMCardID = c.ID) INNER JOIN KhachHang d ON a.KHID = d.ID WHERE a.thaotac = 0 AND a.id = ? AND a.TrangThai = 0");
            pst.setInt(1, id);
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                record = new tbDeposit(rsCus.getInt(1), rsCus.getInt(5), rsCus.getString(2), rsCus.getString(4), rsCus.getLong(3), rsCus.getTimestamp(6), rsCus.getInt(7));
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

    public boolean accept(long money, int khid, int tranid) {
        Connection cn = null;
        PreparedStatement pst = null, psd = null;
        int result = 0, success = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("UPDATE [dbo].[KhachHang] SET [SoDu] = SoDu + ? WHERE ID = ?");
            pst.setLong(1, money);
            pst.setInt(2, khid);
            result = pst.executeUpdate();
            if (result > 0) {
                psd = cn.prepareCall("UPDATE [dbo].[GiaoDich] SET [TrangThai] = 1 WHERE ID = ?");
                psd.setInt(1, tranid);
                success = psd.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(pst != null) pst.close();
                if(psd != null) psd.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return (success > 0);
    }

    public boolean delete(int id) {
        Connection cn = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("DELETE FROM GiaoDich WHERE ID = ?");
            pst.setInt(1, id);
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
    
    public TreeMap<String, String> getFullInfo(int id) {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        TreeMap<String, String> record = new TreeMap<>();
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT d.HoTen, d.STK, d.DiaChi, d.SoDu, b.Ten, b.DiaDiem, c.ATMCardID, a.SoTien, a.ThoiGian, a.TrangThai, a.ID, b.ID, c.ID, d.ID FROM ((GiaoDich a INNER JOIN ATM b ON a.ATMID = b.ID) INNER JOIN ATMCard c ON a.ATMCardID = c.ID) INNER JOIN KhachHang d ON a.KHID = d.ID WHERE a.thaotac = 0 AND a.id = ? AND a.TrangThai = 0");
            pst.setInt(1, id);
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                record.put("hoten", rsCus.getString(1));
                record.put("stk", rsCus.getString(2));
                record.put("diachi", rsCus.getString(3));
                record.put("sodu", String.valueOf(rsCus.getLong(4)));
                record.put("atmten", rsCus.getString(5));
                record.put("atmdiadiem", rsCus.getString(6));
                record.put("atmcardid", String.valueOf(rsCus.getInt(7)));
                record.put("sotien", String.valueOf(rsCus.getLong(8)));
                record.put("thoigian", String.valueOf(rsCus.getTimestamp(9)));
                record.put("trangthai", String.valueOf(rsCus.getInt(10)));
                record.put("giaodichid", String.valueOf(rsCus.getInt(11)));
                record.put("atmid", String.valueOf(rsCus.getInt(12)));
                record.put("cardid", String.valueOf(rsCus.getInt(13)));
                record.put("khid", String.valueOf(rsCus.getInt(14)));
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
}
