package TBClass;

import DBClass.ServerFunction;
import Mylib.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.swing.JOptionPane;

public class tbTransaction {

    ServerFunction server = new ServerFunction();

    public boolean deposit(int khid, int card, int atm, long amount) {
        Connection cn = null;
        PreparedStatement pst = null;
        int result = 0;

        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("INSERT INTO [dbo].[GiaoDich] ([KHID],[KHID_Sub],[ATMID],[ATMCardID],[ThaoTac],[SoTien],[ThoiGian],[TrangThai],[SoDu]) VALUES (?,?,?,?,?,?,default,?,?)");
            pst.setInt(1, khid);
            pst.setInt(2, 0);
            pst.setInt(3, atm);
            pst.setInt(4, card);
            pst.setInt(5, 0);
            pst.setLong(6, amount);
            pst.setInt(7, 0);
            pst.setInt(8, 0);
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

    public boolean checkWith(int khid, long amount, boolean lang, int card) {
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        ResultSet Caidat = null, SoLan = null;
        Connection cn = null;
        PreparedStatement pst = null;
        int lanrutmax = 0;
        long sodumin = 0, sotienminlan = 0, sotienmaxlan = 0, sotienmaxngay = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT * FROM CaiDat WHERE id = 1");
            Caidat = pst.executeQuery();
            if (Caidat.next()) {
                sodumin = Caidat.getLong(2);
                lanrutmax = Caidat.getInt(3);
                sotienminlan = Caidat.getLong(4);
                sotienmaxlan = Caidat.getLong(5);
                sotienmaxngay = Caidat.getLong(6);
            }
            pst = cn.prepareCall("SELECT COUNT(ID) FROM GiaoDich WHERE ThaoTac = 1 AND ATMCardID = ? AND ThoiGian > CONVERT(datetime, '" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + " 00:00:00') AND ThoiGian < CONVERT(datetime, '" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + " 23:59:59')");
            pst.setInt(1, card);
            SoLan = pst.executeQuery();
            if (SoLan.next()) {
                if (SoLan.getInt(1) >= lanrutmax) {
                    if (lang) {
                        JOptionPane.showMessageDialog(null, "Qúa số lần rút tiền trong ngày");
                    } else {
                        JOptionPane.showMessageDialog(null, "Withdrawals too many times in day");
                    }
                    return false;
                }
            }

            pst = cn.prepareCall("SELECT SUM(SoTien) FROM GiaoDich WHERE ThaoTac = 1 AND ATMCardID = ? AND ThoiGian > CONVERT(datetime, '" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + " 00:00:00') AND ThoiGian < CONVERT(datetime, '" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + " 23:59:59')");
            pst.setInt(1, card);
            SoLan = pst.executeQuery();
            if (SoLan.next()) {
                if ((SoLan.getLong(1) + amount) >= sotienmaxngay) {
                    if (lang) {
                        JOptionPane.showMessageDialog(null, "Quá số tiền rút tối đa trong ngày");
                    } else {
                        JOptionPane.showMessageDialog(null, "Exceed the maximum withdrawal amount during the day");
                    }
                    return false;
                }
            }

            pst = cn.prepareCall("SELECT SoDu FROM KhachHang WHERE ID = ?");
            pst.setInt(1, khid);
            SoLan = pst.executeQuery();
            if (SoLan.next()) {
                if (amount > (SoLan.getLong(1) - sodumin)) {
                    if (lang) {
                        JOptionPane.showMessageDialog(null, "Qúa số dư");
                    } else {
                        JOptionPane.showMessageDialog(null, "Too balance");
                    }
                    return false;
                }
            }

            if (amount < sotienminlan) {
                if (lang) {
                    JOptionPane.showMessageDialog(null, "Số tiền quá nhỏ");
                } else {
                    JOptionPane.showMessageDialog(null, "Amount too small");
                }
                return false;
            }

            if (amount > sotienmaxlan) {
                if (lang) {
                    JOptionPane.showMessageDialog(null, "Số tiền quá lớn");
                } else {
                    JOptionPane.showMessageDialog(null, "The money is too large");
                }
                return false;
            }

            if (amount % 10000 != 0) {
                if (lang) {
                    JOptionPane.showMessageDialog(null, "Số tiền không hợp lệ");
                } else {
                    JOptionPane.showMessageDialog(null, "The money not valid");
                }
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (null != Caidat) {
                    Caidat.close();
                } else {
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
        return true;
    }

    public int getKHID(int id) {
        ResultSet rsATM = null;
        Connection cn = null;
        PreparedStatement pst = null;
        int record = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT KHID FROM ATMCard WHERE ATMCardID = ?");
            pst.setInt(1, id);
            rsATM = pst.executeQuery();
            if (rsATM.next()) {
                record = rsATM.getInt(1);
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

    public boolean width(int khid, int card, int atm, long amount) {
        ResultSet rs;
        Connection cn = null;
        PreparedStatement pst = null, psd = null;
        int result = 0, success = 0, phiruttien = 0;

        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT phiruttien FROM CaiDat WHERE ID = 1");
            rs = pst.executeQuery();
            if (rs.next()) {
                phiruttien = rs.getInt(1);
            }
            
            pst = cn.prepareCall("INSERT INTO [dbo].[GiaoDich] ([KHID],[KHID_Sub],[ATMID],[ATMCardID],[ThaoTac],[SoTien],[ThoiGian],[TrangThai],[SoDu]) VALUES (?,?,?,?,?,?,default,?,?)");
            pst.setInt(1, khid);
            pst.setInt(2, 0);
            pst.setInt(3, atm);
            pst.setInt(4, card);
            pst.setInt(5, 1);
            pst.setLong(6, amount);
            pst.setInt(7, 0);
            pst.setInt(8, 0);
            result = pst.executeUpdate();
            if (result > 0) {
                cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
                psd = cn.prepareCall("UPDATE KhachHang SET SoDu  = SoDu - ? WHERE ID = ?");
                psd.setLong(1, amount + phiruttien);
                psd.setInt(2, khid);
                success = psd.executeUpdate();
            }
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
        return (success > 0);
    }

    public int getCardID(int id) {
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
    
    public int getRecent() {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        int record = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT TOP 1 PERCENT ID FROM GiaoDich ORDER BY id DESC");
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                record = rsCus.getInt(1);
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
    
    public ArrayList getInfo(int id) {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ArrayList record = new ArrayList();
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT * FROM GiaoDich WHERE id = ?");
            pst.setInt(1, id);
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                record.add(rsCus.getInt(1));
                record.add(rsCus.getInt(2));
                record.add(rsCus.getInt(3));
                record.add(rsCus.getInt(4));
                record.add(rsCus.getInt(5));
                record.add(rsCus.getInt(6));
                record.add(rsCus.getLong(7));
                record.add(rsCus.getDate(8));
                record.add(rsCus.getInt(9));
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
    
    public long getBalance(int id) {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        long record = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT SoDu FROM KhachHang WHERE id = ?");
            pst.setInt(1, id);
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                 record = rsCus.getLong(1);
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
    
    public long getFee() {
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        long record = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT PhiRutTien FROM CaiDat WHERE id = 1");
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                 record = rsCus.getLong(1);
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
    
    public ArrayList viewBalance(int khid){
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ArrayList record = new ArrayList();
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT HoTen, SoDu FROM KhachHang WHERE id = ?");
            pst.setInt(1, khid);
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                 record.add(rsCus.getString(1));
                 record.add(rsCus.getLong(2));
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
    
    public ArrayList viewKHInfo(String khid){
        ResultSet rsCus = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ArrayList record = new ArrayList();
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT HoTen, NgaySinh, DiaChi FROM KhachHang WHERE STK = ?");
            pst.setString(1, khid);
            rsCus = pst.executeQuery();
            if (rsCus.next()) {
                 record.add(rsCus.getString(1));
                 record.add(rsCus.getDate(2));
                 record.add(rsCus.getString(3));
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
    
    public boolean checkTranfer(String stk, long amount, boolean lang) {
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        ResultSet Caidat = null, SoLan = null;
        Connection cn = null;
        PreparedStatement pst = null;
        long sodumin = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            
            pst = cn.prepareCall("SELECT * FROM CaiDat WHERE id = 1");
            Caidat = pst.executeQuery();
            if (Caidat.next()) {
                sodumin = Caidat.getLong(2);
            }
            
            pst = cn.prepareCall("SELECT SoDu FROM KhachHang WHERE STK = ?");
            pst.setString(1, stk);
            SoLan = pst.executeQuery();
            if (SoLan.next()) {
                if (amount > (SoLan.getLong(1) - sodumin)) {
                    if (lang) {
                        JOptionPane.showMessageDialog(null, "Qúa số dư");
                    } else {
                        JOptionPane.showMessageDialog(null, "Too balance");
                    }
                    return false;
                }
            }
            
            if (amount < 0) {
                if (lang) {
                    JOptionPane.showMessageDialog(null, "Số tiền quá nhỏ");
                } else {
                    JOptionPane.showMessageDialog(null, "Amount too small");
                }
                return false;
            }
            if (amount % 10000 != 0) {
                if (lang) {
                    JOptionPane.showMessageDialog(null, "Số tiền không hợp lệ");
                } else {
                    JOptionPane.showMessageDialog(null, "The money not valid");
                }
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (null != Caidat) {
                    Caidat.close();
                } else {
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
        return true;
    }

    public boolean tranfer(int khid, int card, int atm, long amount, int kh_sub) {
        ResultSet rs;
        Connection cn = null;
        PreparedStatement pst = null, psd = null;
        int result = 0, success = 0, phiruttien = 0;

        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("INSERT INTO [dbo].[GiaoDich] ([KHID],[KHID_Sub],[ATMID],[ATMCardID],[ThaoTac],[SoTien],[ThoiGian],[TrangThai],[SoDu]) VALUES (?,?,?,?,?,?,default,?,?)");
            pst.setInt(1, khid);
            pst.setInt(2, kh_sub);
            pst.setInt(3, atm);
            pst.setInt(4, card);
            pst.setInt(5, 2);
            pst.setLong(6, amount);
            pst.setInt(7, 0);
            pst.setInt(8, 0);
            result = pst.executeUpdate();
            if (result > 0) {
                psd = cn.prepareCall("UPDATE KhachHang SET SoDu  = SoDu - ? WHERE ID = ?");
                psd.setLong(1, amount);
                psd.setInt(2, khid);
                success = psd.executeUpdate();
                
                psd = cn.prepareCall("UPDATE KhachHang SET SoDu  = SoDu + ? WHERE ID = ?");
                psd.setLong(1, amount);
                psd.setInt(2, kh_sub);
                success = psd.executeUpdate();
            }
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
        return (success > 0);
    }
    
    public int getKHIDBySTK(String stk) {
        ResultSet rsATM = null;
        Connection cn = null;
        PreparedStatement pst = null;
        int record = 0;
        try {
            cn = MyConnection.getConnect(server.getServerName(), server.getDatabaseName(), server.getUserName(), server.getPassword());
            pst = cn.prepareCall("SELECT ID FROM KhachHang WHERE STK = ?");
            pst.setString(1, stk);
            rsATM = pst.executeQuery();
            if (rsATM.next()) {
                record = rsATM.getInt(1);
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
    
}
