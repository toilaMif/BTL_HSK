package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import controller.DataBase;
import entity.NhanVien;

public class NhanVien_Dao implements Serializable {

    private ArrayList<NhanVien> list;

    public NhanVien_Dao() {
        list = new ArrayList<NhanVien>();
    }

    public ArrayList<NhanVien> getListNV() {
        return list;
    }

    public ArrayList<NhanVien> getNVByID(String maNV) {
        ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
        DataBase.getInstance();
        Connection con = DataBase.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM NhanVien WHERE maNV = ?");
            stmt.setString(1, maNV);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                LocalDate birthDay = rs.getDate(3) != null ? rs.getDate(3).toLocalDate() : null;
                String address = rs.getString(4);
                Boolean phai = rs.getString(5) != null && rs.getString(5).equalsIgnoreCase("M");
                Double salary = rs.getDouble(6);
                LocalDate ngayVaolam = rs.getDate(7) != null ? rs.getDate(7).toLocalDate() : null;
                String phone = rs.getString(8);
                String maTK = rs.getString(9);

                listNV.add(new NhanVien(id, name, birthDay, address, phai, salary, ngayVaolam, phone, maTK));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNV;
    }

    public ArrayList<NhanVien> getAllNV() {
        ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
        DataBase.getInstance();
        Connection con = DataBase.getConnection();

        try {
            String sql = "SELECT * FROM NhanVien";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String birthDateString = rs.getString(3);
                LocalDate birthDay = null;
                if (birthDateString != null) {
                	birthDay = LocalDate.parse(birthDateString);                
                }

                String address = rs.getString(4);
                Boolean phai = rs.getString(5) != null && rs.getString(5).equalsIgnoreCase("M");

                Double salary = rs.getDouble(6);
                String hireDateString = rs.getString(7);
                LocalDate ngayVaolam = null;
                if (hireDateString != null) {
                    try {
                        ngayVaolam = LocalDate.parse(hireDateString);
                    } catch (Exception e) {
                        System.out.println("Định dạng ngày vào làm không hợp lệ cho ID: " + id);
                    }
                }

                String phone = rs.getString(8);
                String maTK = rs.getString(9);

                listNV.add(new NhanVien(id, name, birthDay, address, phai, salary, ngayVaolam, phone, maTK));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }


    public ArrayList<NhanVien> getNVByName(String name) {
    	ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
        DataBase.getInstance();
        Connection con = DataBase.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM NhanVien WHERE tenNV = ?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                String id = rs.getString(1);
                String name1 = rs.getString(2);
                LocalDate birthDay = rs.getDate(3) != null ? rs.getDate(3).toLocalDate() : null;
                String address = rs.getString(4);
                Boolean phai = rs.getString(5) != null && rs.getString(5).equalsIgnoreCase("M");
                Double salary = rs.getDouble(6);
                LocalDate ngayVaolam = rs.getDate(7) != null ? rs.getDate(7).toLocalDate() : null;
                String phone = rs.getString(8);
                String maTK = rs.getString(9);

                listNV.add(new NhanVien(id, name1, birthDay, address, phai, salary, ngayVaolam, phone, maTK));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNV;
    }

    public boolean ismaNV(String maNV) {
        DataBase.getInstance();
        Connection con = DataBase.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM NhanVien WHERE maNV = ?");
            stmt.setString(1, maNV);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean createNV(NhanVien nv) {
        int n = 0;
        DataBase.getInstance();
        Connection con = DataBase.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO NhanVien VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, nv.getMaNV());
            stmt.setString(2, nv.getTenNV());
            stmt.setDate(3, Date.valueOf(nv.getNgaySinh()));
            stmt.setString(4, nv.getDiaChi());
            stmt.setBoolean(5, nv.isPhai());
            stmt.setDouble(6, nv.getLuong());
            stmt.setDate(7, Date.valueOf(nv.getNgayVaoLam()));
            stmt.setString(8, nv.getSdt());
            stmt.setString(9, nv.getMaTK());
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n != 0;
    }

    public boolean updateNV(NhanVien nv) {
        int n = 0;
        String sql = "UPDATE NhanVien SET tenNV = ?, gioiTinh = ?, ngaySinh = ?, diaChi = ?, sdt = ?, ngayVaoLam = ?, luong = ?, maTK = ? WHERE maNV = ?";
        try (Connection con = DataBase.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, nv.getTenNV());
            stmt.setBoolean(2, nv.isPhai());
            stmt.setDate(3, Date.valueOf(nv.getNgaySinh()));
            stmt.setString(4, nv.getDiaChi());
            stmt.setString(5, nv.getSdt());
            stmt.setDate(6, Date.valueOf(nv.getNgayVaoLam()));
            stmt.setDouble(7, nv.getLuong());
            stmt.setString(8, nv.getMaTK());
            stmt.setString(9, nv.getMaNV());
            
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n != 0;
    }

    public boolean delete(String ma) {
        int n = 0;
        DataBase.getInstance();
        Connection con = DataBase.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM NhanVien WHERE maNV = ?");
            stmt.setString(1, ma);
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n != 0;
    }
    public ArrayList<NhanVien> getAllNVSorted(String sortBy, boolean ascending) {
    	DataBase.getInstance();
        Connection con = DataBase.getConnection();
        ArrayList<NhanVien> sortedList = getAllNV(); // Get all employees

        Comparator<NhanVien> comparator = null;
        if(sortBy.equals("tenNV")) {
        	comparator = Comparator.comparing(NhanVien::getTenNV);  // Sort by Name
        	
        }else if(sortBy.equals("maNV")) {
        	comparator = Comparator.comparing(NhanVien::getMaNV);  // Sort by ID
        
        }

        // Reverse order if not ascending
        if (!ascending) {
            comparator = comparator.reversed();
        }

        sortedList.sort(comparator);
        return sortedList;
    }


    public void sortByIDASC() {
    	Collections.sort(list, new Comparator<NhanVien>() {

			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				// TODO Auto-generated method stub
				String b1 = o1.getMaNV().length() > 1 ? o1.getMaNV().substring(2) : "0";
				String b2 = o2.getMaNV().length() > 1 ? o2.getMaNV().substring(2) : "0";
				try {
					int nb1 = Integer.parseInt(b1);
					int nb2 = Integer.parseInt(b2);
					return Integer.compare(nb1, nb2);
				}catch(NumberFormatException e) {
					return 0;
				}	
			
			}
    		
    	});
    }

    public void sortByIDDESC() {
    	Collections.sort(list, new Comparator<NhanVien>() {

			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				// TODO Auto-generated method stub
				String b1 = o1.getMaNV().length() > 1 ? o1.getMaNV().substring(2) : "0";
				String b2 = o2.getMaNV().length() > 1 ? o2.getMaNV().substring(2) : "0";
				try {
					int nb1 = Integer.parseInt(b1);
					int nb2 = Integer.parseInt(b2);
					return Integer.compare(nb2, nb1);
				}catch(NumberFormatException e) {
					return 0;
				}
			
			}
    		
    	});
    }
}
