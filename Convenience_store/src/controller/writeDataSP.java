package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.dsSanPham;
import entity.SanPham;

public class writeDataSP {

    public static boolean writeSP(SanPham sanPham) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            ConnectDB.getInstance().connect();
            con = ConnectDB.getConnection();
            
            String sql = "INSERT INTO SanPham (maSP, tenSp, loaiSP, soLuong, xuatXu, thuongHieu, moTa, nhaSanXuat, donGia) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                         
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, sanPham.getMaSP());
            pstmt.setString(2, sanPham.getTenSp());
            pstmt.setString(3, sanPham.getLoaiSP());
            pstmt.setInt(4, sanPham.getSoLuong());
            pstmt.setString(5, sanPham.getXuatXu());
            pstmt.setString(6, sanPham.getThuongHieu());
            pstmt.setString(7, sanPham.getMoTa());
            pstmt.setString(8, sanPham.getNhaSanXuat());
            pstmt.setDouble(9, sanPham.getDonGia());
            
            int rowsInserted = pstmt.executeUpdate();
            
            return rowsInserted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
            
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
