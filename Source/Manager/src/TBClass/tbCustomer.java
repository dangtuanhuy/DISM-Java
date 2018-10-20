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

public class tbCustomer {

    private String name, stk, diachi, email, mobile, cmnd, gend;
    private int id, gender, status;
    private Date dob;
    private long balance;
    ServerFunction server = new ServerFunction();

    public tbCustomer() {
    }

    public tbCustomer(String name, String stk, String diachi, String email, String mobile, String cmnd, int id, int gender, int status, Date dob, long balance) {
        this.name = name;
        this.stk = stk;
        this.diachi = diachi;
        this.email = email;
        this.mobile = mobile;
        this.cmnd = cmnd;
        this.id = id;
        this.gender = gender;
        this.status = status;
        this.dob = dob;
        this.balance = balance;
        this.gend = (gender == 1) ? "Male" : "Female";
    }

    public Vector toVector() {
        Vector vtCus = new Vector();
        vtCus.add(id);
        vtCus.add(stk);
        vtCus.add(name);
        vtCus.add(gend);
        vtCus.add(balance);
        vtCus.add((status == 1));
        return vtCus;
    }
    
    public Vector selectVector() {
        Vector vtCus = new Vector();
        vtCus.add(id);
        vtCus.add(stk);
        vtCus.add(name);
        vtCus.add(diachi);
        vtCus.add(mobile);
        vtCus.add(gend);
        vtCus.add(dob);
        vtCus.add(cmnd);
        vtCus.add(balance);
        vtCus.add((status == 1));
        return vtCus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getGend() {
        return gend;
    }

    public void setGend(String gend) {
        this.gend = gend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public ServerFunction getServer() {
        return server;
    }

    public void setServer(ServerFunction server) {
        this.server = server;
    }

    public ArrayList<tbCustomer> getList() {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;

        ArrayList<tbCustomer> listCus = new ArrayList();
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT * FROM KhachHang");
            rsCus = pst.executeQuery();
            while (rsCus.next()) {
                tbCustomer record = new tbCustomer(rsCus.getString(3), rsCus.getString(2), rsCus.getString(4), rsCus.getString(5), rsCus.getString(6), rsCus.getString(11), rsCus.getInt(1), rsCus.getInt(7), rsCus.getInt(8), rsCus.getDate(10), rsCus.getLong(9));
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

    public tbCustomer getInfo(int id) {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        tbCustomer record = null;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT * FROM KhachHang WHERE id = ?");
            pst.setInt(1, id);
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                record = new tbCustomer(rsCus.getString(3), rsCus.getString(2), rsCus.getString(4), rsCus.getString(5), rsCus.getString(6), rsCus.getString(11), rsCus.getInt(1), rsCus.getInt(7), rsCus.getInt(8), rsCus.getDate(10), rsCus.getLong(9));
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

    public boolean insert(tbCustomer tbCus) {
        Connection cn = null;
        PreparedStatement pst = null;
        int result = 0;
        int nextStk;
        ResultSet rsCus = null;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT IDENT_CURRENT('KhachHang') + IDENT_INCR('KhachHang') AS Number");
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                nextStk = rsCus.getInt(1) + 100000000;
                cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
                pst = cn.prepareCall("INSERT INTO [dbo].[KhachHang] ([STK],[HoTen],[DiaChi],[Email],[SoDienThoai],[GioiTinh],[TrangThai],[SoDu],[NgaySinh],[SoCMND]) VALUES (?,?,?,?,?,?,?,?,?,?)");
                pst.setInt(1, nextStk);
                pst.setString(2, tbCus.name);
                pst.setString(3, tbCus.diachi);
                pst.setString(4, tbCus.email);
                pst.setString(5, tbCus.mobile);
                pst.setInt(6, tbCus.gender);
                pst.setInt(7, tbCus.status);
                pst.setLong(8, tbCus.balance);
                pst.setDate(9, new java.sql.Date(tbCus.dob.getTime()));
                pst.setString(10, tbCus.cmnd);
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

    public tbCustomer getRecent() {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        tbCustomer record = null;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT TOP 1 PERCENT * FROM KhachHang ORDER BY id DESC");
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                record = new tbCustomer(rsCus.getString(3), rsCus.getString(2), rsCus.getString(4), rsCus.getString(5), rsCus.getString(6), rsCus.getString(11), rsCus.getInt(1), rsCus.getInt(7), rsCus.getInt(8), rsCus.getDate(10), rsCus.getLong(9));
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

    public boolean update(tbCustomer tbCus) {
        Connection cn = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("UPDATE [dbo].[KhachHang] SET [HoTen] = ?,[DiaChi] = ?,[Email] = ?,[SoDienThoai] = ?,[GioiTinh] = ?,[TrangThai] = ?,[NgaySinh] = ?,[SoCMND] = ? WHERE ID = ?");
            pst.setString(1, tbCus.name);
            pst.setString(2, tbCus.diachi);
            pst.setString(3, tbCus.email);
            pst.setString(4, tbCus.mobile);
            pst.setInt(5, tbCus.gender);
            pst.setInt(6, tbCus.status);
            pst.setDate(7, new java.sql.Date(tbCus.dob.getTime()));
            pst.setString(8, tbCus.cmnd);
            pst.setInt(9, tbCus.id);
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
        ResultSet rsATMCard = null;
        PreparedStatement pst = null;
        PreparedStatement giaodich = null;
        PreparedStatement atmcard = null;
        int result = 0;
        boolean status = false;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            giaodich = cn.prepareCall("SELECT * FROM GiaoDich WHERE KHID = ?");
            giaodich.setInt(1, id);
            rsGiaoDich = giaodich.executeQuery();

            atmcard = cn.prepareCall("SELECT * FROM ATMCard WHERE KHID = ?");
            atmcard.setInt(1, id);
            rsATMCard = atmcard.executeQuery();

            if (!rsGiaoDich.next()) {
                if (!rsATMCard.next()) {
                    pst = cn.prepareCall("DELETE FROM KhachHang WHERE ID = ?");
                    pst.setInt(1, id);
                    result = pst.executeUpdate();
                    if (result == 1) {
                        status = true;
                    }
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
