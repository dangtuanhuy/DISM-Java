package TBClass;

import DBClass.ServerFunction;
import Mylib.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.*;

public class tbManager {

    private int ID, VaiTro;
    private String TenDangNhap, MatKhau, Hoten, DiaChi, Email, SoDienThoai;
    private ServerFunction server = new ServerFunction();

    public tbManager(int ID, int VaiTro, String TenDangNhap, String MatKhau, String Hoten, String DiaChi, String Email, String SoDienThoai) {
        this.ID = ID;
        this.VaiTro = VaiTro;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.Hoten = Hoten;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.SoDienThoai = SoDienThoai;
    }
    public Vector toVector() {
        Vector a = new Vector();
        a.add(ID);
        a.add(VaiTro);
        a.add(TenDangNhap);
        a.add(MatKhau);
        a.add(Hoten);
        a.add(DiaChi);
        a.add(Email);
        a.add(SoDienThoai);
        return a;
    }
    public tbManager() {
    }

    public tbManager(int ID, String MatKhau) {
        this.ID = ID;
        this.MatKhau = MatKhau;
    }

    public boolean checkPass(tbManager mana) {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        boolean check = false;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT * FROM Manager WHERE id = ? AND Password = ?");
            pst.setInt(1, mana.ID);
            pst.setString(2, mana.MatKhau);
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rsCus != null) {
                    rsCus.close();
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
        return check;
    }

    public boolean update(tbManager tbCus) {
        Connection cn = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("UPDATE [dbo].[Manager] SET [Password] = ? WHERE ID = ?");
            pst.setInt(2, tbCus.ID);
            pst.setString(1, tbCus.MatKhau);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
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
        return (result > 0);
    }

    public ArrayList<tbManager> getList() {
        ResultSet rsMan = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ArrayList<tbManager> listMan = new ArrayList();
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT * FROM Manager");
            rsMan = pst.executeQuery();
            while (rsMan.next()) {
                //tbManager record = new tbManager(ID, VaiTro, TenDangNhap, MatKhau, Hoten, DiaChi, Email, SoDienThoai);
                tbManager record = new tbManager(rsMan.getInt(1), rsMan.getInt(8), rsMan.getString(2), rsMan.getString(3), rsMan.getString(4), rsMan.getString(5), rsMan.getString(6), rsMan.getString(7));
                listMan.add(record);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rsMan != null) {
                    rsMan.close();
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
        return listMan;
    }
    public boolean insert(String username, String pass, String fullname, String address, String Email, String Phone, int Role) {
        Connection cn = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("INSERT [dbo].[Manager] ([Username],[Password],[FullName],[Address],[Email],[Phone],[Role]) VALUES (?,?,?,?,?,?,?)");
            pst.setString(1, username);
            pst.setString(2, pass);
            pst.setString(3, fullname);
            pst.setString(4, address);
            pst.setString(5, Email);
            pst.setString(6, Phone);
            pst.setInt(7, Role);
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
//public tbCustomer getInfo(int id) {
//        ResultSet rsMan = null;
//        Connection cn = null;
//        PreparedStatement pst = null;
//        tbCustomer record = null;
//        try {
//            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
//            pst = cn.prepareCall("SELECT * FROM Manager WHERE id = ?");
//            pst.setInt(1, id);
//            rsMan = pst.executeQuery();
//            if (rsMan.next()) {
//               //tbManager record = new tbManager(rsMan.getInt(1), rsMan.getInt(2),rsMan.getString(3), rsMan.getString(4),rsMan.getString(5), rsMan.getString(6), rsMan.getString(7), rsMan.getString(8));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                if(rsMan != null) rsMan.close();
//                if(pst != null) pst.close();
//                if(cn != null) cn.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return record;
//    }
    //Lấy dữ liệu cho bảng

//    public void LoadData(String sqlSelect, JTable grManager) {
//        ResultSet rsMan = null;
//        Connection cn = null;
//        PreparedStatement pst = null;
//        try {
//            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
//            pst = cn.prepareStatement(sqlSelect);
//            rsMan = pst.executeQuery();
//            grManager.setModel((DbUtils.resultSetToTableModel(rsMan)));
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e, "Box", 1);
//        }
//    }

//    public static ResultSet ShowManager(String sqlSelect) {
//
//        Connection cn = null;
//        PreparedStatement pst = null;
//        try {
//            pst = cn.prepareStatement(sqlSelect);
//            return pst.executeQuery();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e, "Box", 1);
//        }
//        return null;
//    }
//     public Vector toVector() {
//        Vector vtMan = new Vector();
//        vtMan.add(ID);
//        vtMan.add(Hoten);
//        vtMan.add(SoDienThoai);
//        vtMan.add(Email);
//     
//        vtMan.add(DiaChi);
//        vtMan.add(TenDangNhap);
//        vtMan.add(MatKhau);
//        vtMan.add(VaiTro);
//        
//        return vtMan;
//    }
    public tbManager getRecent() {
        ResultSet rsMan = null;
        Connection cn = null;
        PreparedStatement pst = null;
        tbManager record = null;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT * FROM Manager");
            rsMan = pst.executeQuery();
            if (rsMan.next()) {
                record = new tbManager(rsMan.getInt(1), rsMan.getInt(2), rsMan.getString(3), rsMan.getString(4), rsMan.getString(5), rsMan.getString(6), rsMan.getString(7), rsMan.getString(8));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rsMan != null) rsMan.close();
                if(pst != null) pst.close();
                if(cn != null) cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return record;
    }
    public ServerFunction getServer() {
        return server;
    }

    public int getID() {
        return ID;
    }

    public int getVaiTro() {
        return VaiTro;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public String getHoten() {
        return Hoten;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setVaiTro(int VaiTro) {
        this.VaiTro = VaiTro;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public void setServer(ServerFunction server) {
        this.server = server;
    }
}
