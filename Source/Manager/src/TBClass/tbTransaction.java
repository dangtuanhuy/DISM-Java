package TBClass;

import DBClass.ServerFunction;
import Mylib.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Vector;

public class tbTransaction {

    ServerFunction server = new ServerFunction();
    private int id, khid_sub, thaotac, trangthai, cardid;
    private long balance;
    private Date thoigian;
    private String hoten, atmname;
    Locale locale = new Locale("vi", "VN");
    NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKhid_sub() {
        return khid_sub;
    }

    public void setKhid_sub(int khid_sub) {
        this.khid_sub = khid_sub;
    }

    public int getThaotac() {
        return thaotac;
    }

    public void setThaotac(int thaotac) {
        this.thaotac = thaotac;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public int getCardid() {
        return cardid;
    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getAtmname() {
        return atmname;
    }

    public void setAtmname(String atmname) {
        this.atmname = atmname;
    }

    public tbTransaction(int id, int khid_sub, int thaotac, int cardid, long balance, Date thoigian, String hoten, String atmname) {
        this.id = id;
        this.khid_sub = khid_sub;
        this.thaotac = thaotac;
        this.cardid = cardid;
        this.balance = balance;
        this.thoigian = thoigian;
        this.hoten = hoten;
        this.atmname = atmname;
    }

    public Vector toVector() {
        Vector a = new Vector();
        a.add(id);
        a.add(hoten);
        if (khid_sub != 0) {
            a.add(getName(khid_sub));
        } else {
            a.add("");
        }
        a.add(atmname);
        a.add(cardid);
        if (thaotac == 0) {
            a.add("Deposit");
        } else if (thaotac == 1) {
            a.add("Withdrawal");
        } else {
            a.add("Tranfer");
        }
        a.add(fmt.format(balance));
        a.add(thoigian);
        if (trangthai == 1) {
            a.add("Active");
        } else {
            a.add("Pendding");
        }

        return a;
    }

    public tbTransaction() {
    }

    public ArrayList<tbTransaction> getList() {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;

        ArrayList<tbTransaction> listCus = new ArrayList();
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT a.ID, b.HoTen, c.Ten, d.ATMCardID, a.ThaoTac, a.SoTien, a.ThoiGian, a.TrangThai, a.KHID_Sub FROM (((GiaoDich a JOIN KhachHang b ON a.KHID = b.ID) JOIN ATM c ON a.ATMID = c.ID) JOIN ATMCard d ON a.ATMCardID = d.ID)");
            rsCus = pst.executeQuery();
            while (rsCus.next()) {
                tbTransaction record = new tbTransaction(rsCus.getInt(1), rsCus.getInt(9), rsCus.getInt(5), rsCus.getInt(4), rsCus.getLong(6), rsCus.getTimestamp(7), rsCus.getString(2), rsCus.getString(3));
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

    public ArrayList<tbTransaction> fillter(int action, int date) {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        String query = "", act = "", d = "", and = "", sql ="";
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        if (action != 0 || date != 0) {
            query = " WHERE";
            switch (action) {
                case 0:
                    act = "";
                    break;
                case 1:
                    act = " a.ThaoTac = 0";
                    break;
                case 2:
                    act = " a.ThaoTac = 1";
                    break;
                case 3:
                    act = " a.ThaoTac = 2";
                    break;
                default:
                    act = "";
                    break;
            }

            switch (date) {
                case 0:
                    d = "";
                    break;
                case 1:
                    d = " a.ThoiGian > CONVERT(datetime, '" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + " 00:00:00') AND a.ThoiGian < CONVERT(datetime, '" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + " 23:59:59')";
                    break;
                case 2:
                    d = " a.ThoiGian > CONVERT(datetime, '" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-01 00:00:00') AND a.ThoiGian < CONVERT(datetime, '" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-30 23:59:59')";
                    break;
                case 3:
                    d = " a.ThoiGian > CONVERT(datetime, '" + calendar.get(Calendar.YEAR) + "-01-01 00:00:00') AND a.ThoiGian < CONVERT(datetime, '" + calendar.get(Calendar.YEAR) + "-12-31 23:59:59')";
                    break;
                default:
                    d = "";
                    break;
            }

            if (action != 0 && date != 0) {
                and = " AND ";
            }
        }

        ArrayList<tbTransaction> listCus = new ArrayList();
        try {
            sql = "SELECT a.ID, b.HoTen, c.Ten, d.ATMCardID, a.ThaoTac, a.SoTien, a.ThoiGian, a.TrangThai, a.KHID_Sub FROM (((GiaoDich a JOIN KhachHang b ON a.KHID = b.ID) JOIN ATM c ON a.ATMID = c.ID) JOIN ATMCard d ON a.ATMCardID = d.ID)" + query + act + and + d;
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall(sql);
            rsCus = pst.executeQuery();
            while (rsCus.next()) {
                tbTransaction record = new tbTransaction(rsCus.getInt(1), rsCus.getInt(9), rsCus.getInt(5), rsCus.getInt(4), rsCus.getLong(6), rsCus.getTimestamp(7), rsCus.getString(2), rsCus.getString(3));
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
    
    public ArrayList<tbTransaction> getTransactionByKHID(int khid) {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;

        ArrayList<tbTransaction> listCus = new ArrayList();
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT a.ID, b.HoTen, c.Ten, d.ATMCardID, a.ThaoTac, a.SoTien, a.ThoiGian, a.TrangThai, a.KHID_Sub FROM (((GiaoDich a JOIN KhachHang b ON a.KHID = b.ID) JOIN ATM c ON a.ATMID = c.ID) JOIN ATMCard d ON a.ATMCardID = d.ID) WHERE a.KHID = ?");
            pst.setInt(1, khid);
            rsCus = pst.executeQuery();
            while (rsCus.next()) {
                tbTransaction record = new tbTransaction(rsCus.getInt(1), rsCus.getInt(9), rsCus.getInt(5), rsCus.getInt(4), rsCus.getLong(6), rsCus.getTimestamp(7), rsCus.getString(2), rsCus.getString(3));
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
    
    public ArrayList<tbTransaction> getTransactionBYCardID(int cardid) {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;

        ArrayList<tbTransaction> listCus = new ArrayList();
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT a.ID, b.HoTen, c.Ten, d.ATMCardID, a.ThaoTac, a.SoTien, a.ThoiGian, a.TrangThai, a.KHID_Sub FROM (((GiaoDich a JOIN KhachHang b ON a.KHID = b.ID) JOIN ATM c ON a.ATMID = c.ID) JOIN ATMCard d ON a.ATMCardID = d.ID) WHERE a.ATMCARDID = ?");
            pst.setInt(1, cardid);
            rsCus = pst.executeQuery();
            while (rsCus.next()) {
                tbTransaction record = new tbTransaction(rsCus.getInt(1), rsCus.getInt(9), rsCus.getInt(5), rsCus.getInt(4), rsCus.getLong(6), rsCus.getTimestamp(7), rsCus.getString(2), rsCus.getString(3));
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

}
