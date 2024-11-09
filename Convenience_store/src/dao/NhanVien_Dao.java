package dao;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.xml.crypto.Data;

import controller.DataBase;
import entity.Account;
import entity.NhanVien;


public class NhanVien_Dao implements Serializable{

	private ArrayList<NhanVien> list;
	
	public NhanVien_Dao() {	
		list = new ArrayList<NhanVien>();
	}

	
	public ArrayList<NhanVien> getListNV(){
		return list;
	}
	
	public ArrayList<NhanVien> getAllNV(){
		ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		
		try {
			String sql = "SELECT * FROM NhanVien";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				Boolean phai = rs.getBoolean(3);
				LocalDate birthDay = rs.getDate(4).toLocalDate();
				String address = rs.getString(5);
				String phone = rs.getString(6);
				LocalDate ngayVaolam = rs.getDate(7).toLocalDate();
				Double salary = rs.getDouble(8);
				String maTK = rs.getString(9);
				listNV.add(new NhanVien(id, name, birthDay, address, phai, 0, ngayVaolam, phone, maTK));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listNV;
	}
	
	public ArrayList<NhanVien> getNVByName(String name){
		ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM NhanVien WHERE NAME = ?");
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String nameNV = rs.getString(2);
				Boolean phai = rs.getBoolean(3);
				LocalDate birthDay = rs.getDate(4).toLocalDate();
				String address = rs.getString(5);
				String phone = rs.getString(6);
				LocalDate ngayVaolam = rs.getDate(7).toLocalDate();
				Double salary = rs.getDouble(8);
				String maTK = rs.getString(9);
				listNV.add(new NhanVien(id, nameNV, birthDay, address, phai, 0, ngayVaolam, phone, maTK));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listNV;
	}
	
	public boolean ismaNV(String maNV) {
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from NhanVien where maNV = ?");
			stmt.setString(1, maNV);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4), rs.getBoolean(5), rs.getDouble(6), rs.getDate(7).toLocalDate(), rs.getString(8), rs.getString(9)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean createNV(NhanVien nv) {
		int n = 0;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("INSERT INTO NhanVien VALUES (?,?,?,?,?,?,?,?,?,?");
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setBoolean(3, nv.isPhai());
			stmt.setDate(4, Date.valueOf(nv.getNgaySinh()));
			stmt.setString(5,nv.getDiaChi());
			stmt.setString(6, nv.getSdt());
			stmt.setDate(7, Date.valueOf(nv.getNgayVaoLam()));
			stmt.setDouble(8, nv.getLuong());
			stmt.setString(9, nv.getMaTK());
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return n != 0;
	}
	public boolean updateNV(NhanVien nv) {
		int n = 0;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("UPDATE NhanVien set tenNV = ?, ngaySinh = ?, diaChi = ?, gioiTinh = ?, luong = ?, ngayVaoLam = ?, sdt = ? , maTK = ? WHERE maNV = ?");
			stmt.setString(2, nv.getTenNV());
			stmt.setBoolean(3, nv.isPhai());
			stmt.setDate(4, Date.valueOf(nv.getNgaySinh()));
			stmt.setString(5,nv.getDiaChi());
			stmt.setString(6, nv.getSdt());
			stmt.setDate(7, Date.valueOf(nv.getNgayVaoLam()));
			stmt.setDouble(8, nv.getLuong());
			stmt.setString(9, nv.getMaTK());
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return n != 0;
	}
	public boolean delete(String ma) {
		int n = 0;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("DELETE NhanVien WHERE maNV = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n != 0;
	}
	
}
