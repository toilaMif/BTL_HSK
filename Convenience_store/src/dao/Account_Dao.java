package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.DataBase;
import entity.Account;

public class Account_Dao implements Serializable{
	public ArrayList<Account> listAccount;
	
	public Account_Dao() {
		listAccount = new ArrayList<Account>();
	}
	
	public ArrayList<Account> getListAccount() {
		return listAccount;
	}
	public void setListAccount(ArrayList<Account> listAccount) {
		this.listAccount = listAccount;
	}
	
	
	
	public ArrayList<Account> getAllAccount() {
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		ArrayList<Account> list=new ArrayList<Account>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from TaiKhoan");
			while(rs.next()) {
				list.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Account> getAccountByUserName(String userName) {
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from TaiKhoan where tenNguoiDung = ?");
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				listAccount.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAccount;
	}
	
	public boolean isUserNameExists(String tenNguoiDung) {
	    DataBase.getInstance();  // Khởi tạo đối tượng DataBase
	    Connection con = DataBase.getConnection();  // Lấy kết nối
	    try {
	        PreparedStatement stmt = con.prepareStatement("SELECT * FROM TaiKhoan WHERE tenNguoiDung = ?");
	        stmt.setString(1, tenNguoiDung);
	        ResultSet rs = stmt.executeQuery();
	        return rs.next(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false; 
	}
	public boolean createAccount(Account account) {
	    if (isUserNameExists(account.getTenNguoiDung())) {
	        System.out.println("Tên người dùng đã tồn tại. Không thể thêm tài khoản mới.");
	        return false; 
	    }
	    
	    int n = 0;
	    DataBase.getInstance();
	    Connection con = DataBase.getConnection();
	    try {
	        PreparedStatement stmt = con.prepareStatement("INSERT INTO TaiKhoan VALUES (?, ?, ?)");
	        stmt.setString(1, account.getMaTk());
	        stmt.setString(2, account.getTenNguoiDung());
	        stmt.setString(3, account.getMatKhau());
	        n = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return n != 0;
	}
	


	
	public boolean updateAccount(Account account) {
		int n = 0;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("update TaiKhoan set tenNguoiDung = ?, matKhau = ? where maTK = ?");
			stmt.setString(1, account.getTenNguoiDung());
			stmt.setString(2, account.getMatKhau());
			stmt.setString(3, account.getMaTk());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n != 0;
	}
	
	public boolean deleteAccount(Account account) {
		int n = 0;
		DataBase.getInstance();
		Connection con = DataBase.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("delete from TaiKhoan where maTK = ?");
			stmt.setString(1, account.getMaTk());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n != 0;
	}
	
}
