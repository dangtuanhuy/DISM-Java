package TBClass;

import DBClass.ServerFunction;
import Mylib.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tbSetting {

    private long sodumin, sotienminlan, sotienmaxlan, sotienmaxngay, phiruttien, phixemsodu;
    private int lanrutmax;
    ServerFunction server = new ServerFunction();

    public tbSetting() {
    }

    public tbSetting(long sodumin, long sotienminlan, long sotienmaxlan, long sotienmaxngay, long phiruttien, long phixemsodu, int lanrutmax) {
        this.sodumin = sodumin;
        this.sotienminlan = sotienminlan;
        this.sotienmaxlan = sotienmaxlan;
        this.sotienmaxngay = sotienmaxngay;
        this.phiruttien = phiruttien;
        this.phixemsodu = phixemsodu;
        this.lanrutmax = lanrutmax;
    }

    public long getSodumin() {
        return sodumin;
    }

    public void setSodumin(long sodumin) {
        this.sodumin = sodumin;
    }

    public long getSotienminlan() {
        return sotienminlan;
    }

    public void setSotienminlan(long sotienminlan) {
        this.sotienminlan = sotienminlan;
    }

    public long getSotienmaxlan() {
        return sotienmaxlan;
    }

    public void setSotienmaxlan(long sotienmaxlan) {
        this.sotienmaxlan = sotienmaxlan;
    }

    public long getSotienmaxngay() {
        return sotienmaxngay;
    }

    public void setSotienmaxngay(long sotienmaxngay) {
        this.sotienmaxngay = sotienmaxngay;
    }

    public long getPhiruttien() {
        return phiruttien;
    }

    public void setPhiruttien(long phiruttien) {
        this.phiruttien = phiruttien;
    }

    public long getPhixemsodu() {
        return phixemsodu;
    }

    public void setPhixemsodu(long phixemsodu) {
        this.phixemsodu = phixemsodu;
    }

    public int getLanrutmax() {
        return lanrutmax;
    }

    public void setLanrutmax(int lanrutmax) {
        this.lanrutmax = lanrutmax;
    }
    
    public tbSetting getInfo() {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        tbSetting record = null;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT * FROM CaiDat WHERE ID = 1");
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                record = new tbSetting(rsCus.getLong(2), rsCus.getLong(4), rsCus.getLong(5), rsCus.getLong(6), rsCus.getLong(7), rsCus.getLong(8), rsCus.getInt(3));
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
    
    public boolean update(tbSetting tbCus) {
        Connection cn = null;
        PreparedStatement pst = null;
        int result = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("UPDATE [dbo].[CaiDat] SET [SoDuMin] = ?,[LanRutMax] = ?,[SoTienMinLan] = ?,[SoTienMaxLan] = ?,[SoTienMaxNgay] = ?,[PhiRutTien] = ?,[PhiXemSoDu] = ? WHERE ID = 1");
            pst.setLong(1, tbCus.sodumin);
            pst.setInt(2, tbCus.lanrutmax);
            pst.setLong(3, tbCus.sotienminlan);
            pst.setLong(4, tbCus.sotienmaxlan);
            pst.setLong(5, tbCus.sotienmaxngay);
            pst.setLong(6, tbCus.phiruttien);
            pst.setLong(7, tbCus.phixemsodu);
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
