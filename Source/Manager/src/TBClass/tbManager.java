package TBClass;

import DBClass.ServerFunction;
import Mylib.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tbManager {
    private int ID, VaiTro;
    private String TenDangNhap, MatKhau, Hoten, DiaChi, Email, SoDienThoai;
    ServerFunction server = new ServerFunction();

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

    public tbManager() {
    }
    
    public tbManager(int ID, String MatKhau){
        this.ID = ID;
        this.MatKhau = MatKhau;
    }
    
    public boolean checkPass(tbManager mana){
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        boolean check = false;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT * FROM Manager WHERE id = ? AND MatKhau = ?");
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
                if(rsCus != null) rsCus.close();
                if(pst != null) pst.close();
                if(cn != null) cn.close();
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
            pst = cn.prepareCall("UPDATE [dbo].[Manager] SET [MatKhau] = ? WHERE ID = ?");
            pst.setInt(2, tbCus.ID);
            pst.setString(1, tbCus.MatKhau);
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
}
