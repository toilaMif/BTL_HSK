package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.dsSanPham;
import entity.SanPham;

public class readDataKH {
	
	public readDataKH(dsSanPham dsSP) {
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSp = rs.getString(2);
				String loaiSP = rs.getString(3);
				int soLuong =    Integer.parseInt(rs.getString(4));
				String xuatXu = rs.getString(5);
				String thuongHieu = rs.getString(6);
				String moTa = rs.getString(7);
				String nhaSanXuat = rs.getString(8);
				double donGia =Double.parseDouble(rs.getString(9));
				
				SanPham s1 = new SanPham(maSP, tenSp, loaiSP, soLuong, xuatXu, thuongHieu, moTa, nhaSanXuat, donGia);
				dsSP.themSP(s1);
			}
			rs.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}