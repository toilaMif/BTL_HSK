package dao;

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

import javax.swing.JOptionPane;

import entity.*;
import controller.ConnectDB;

public class quanLiHD {
	ArrayList<HoaDon> dsHD;
	
	public quanLiHD() {
		dsHD = new ArrayList<HoaDon>();
	}
	
	public ArrayList<HoaDon> getDSHoaDon(){
		return dsHD;
	}
	
	public void setListHoaDon(ArrayList<HoaDon> dsHD) {
		this.dsHD = dsHD;
	}
	
	public ArrayList<HoaDon> getallHoaDon(){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		try {
//			Connection con = ConnectDB.getInstance().getConnection();
		       String sql = "SELECT HoaDon.maHoaDon, HoaDon.ngayLap, HoaDon.tongTien, HoaDon.hinhThucThanhToan, " +
	                     "KhachHang.maKH, KhachHang.tenKH, NhanVien.maNV, NhanVien.tenNV " +
	                     "FROM HoaDon " +
	                     "JOIN KhachHang ON HoaDon.maKH = KhachHang.maKH " +
	                     "JOIN NhanVien ON HoaDon.maNV = NhanVien.maNV";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				String maHD = rs.getString(1);
				LocalDate ngayLap = rs.getDate(2).toLocalDate();
				double tongTien = rs.getDouble(3);
				String htThanhToan = rs.getString(4);
				KhachHang kh = new KhachHang(rs.getString(5),rs.getString(6));
				NhanVien nv = new NhanVien(rs.getString(7),rs.getString(8));
				dsHD.add(new HoaDon(maHD, ngayLap, tongTien, htThanhToan, kh, nv));
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
		
	}
	
	public void sortByDateASC() {
		Collections.sort(dsHD, new Comparator<HoaDon>() {

			@Override
			public int compare(HoaDon o1, HoaDon o2) {
				// TODO Auto-generated method stub
				return o1.getNgayLap().compareTo(o2.getNgayLap());
			}
			
		});
	}
	
	
	public void sortByDateDESC() {
		Collections.sort(dsHD, new Comparator<HoaDon>() {

			@Override
			public int compare(HoaDon o1, HoaDon o2) {
				// TODO Auto-generated method stub
				return o2.getNgayLap().compareTo(o1.getNgayLap());
			}
			
		});
	}
	
	public void sortByIdBillASC() {
	    Collections.sort(dsHD, new Comparator<HoaDon>() {
	        @Override
	        public int compare(HoaDon o1, HoaDon o2) {
	            // Lấy phần số của mã hóa đơn, bỏ qua ký tự đầu tiên
	            String b1 = o1.getMaHoaDon().length() > 1 ? o1.getMaHoaDon().substring(2) : "0";
	            String b2 = o2.getMaHoaDon().length() > 1 ? o2.getMaHoaDon().substring(2) : "0";

	            try {
	                // Chuyển đổi phần sau ký tự đầu tiên thành số
	                int number1 = Integer.parseInt(b1);
	                int number2 = Integer.parseInt(b2);

	                // Sắp xếp tăng dần
	                return Integer.compare(number1, number2);
	            } catch (NumberFormatException e) {
	                // Xử lý khi không thể chuyển đổi thành số, ví dụ: mã hóa đơn không hợp lệ
	                return 0; // Nếu mã hóa đơn không hợp lệ, không thay đổi thứ tự
	            }
	        }
	    });
	}

//	public void sortByIdBillASC() {
//	    Collections.sort(dsHD, new Comparator<HoaDon>() {
//	        @Override
//	        public int compare(HoaDon o1, HoaDon o2) {
//	            // Kiểm tra độ dài để tránh lỗi
//	            String b1 = o1.getMaHoaDon().length() > 1 ? o1.getMaHoaDon().substring(1) : "0";
//	            String b2 = o2.getMaHoaDon().length() > 1 ? o2.getMaHoaDon().substring(1) : "0";
//
//	            // Sắp xếp tăng dần
//	            return Integer.compare(Integer.parseInt(b1), Integer.parseInt(b2));
//	        }
//	    });
//	}
//	
//	public void sortByIdBillASC() {
//		Collections.sort(dsHD, new Comparator<HoaDon>() {
//			@Override
//			public int compare(HoaDon o1, HoaDon o2) {
//				// TODO Auto-generated method stub
//				String b1=o1.getMaHoaDon().substring(1);
//				String b2=o2.getMaHoaDon().substring(1);
//				return Integer.parseInt(b1) - Integer.parseInt(b2);
//			}
//		});
//	}
	
	
	
//	public void sortByIdBillDESC() {
//		Collections.sort(dsHD, new Comparator<HoaDon>() {
//			@Override
//			public int compare(HoaDon o1, HoaDon o2) {
//				// TODO Auto-generated method stub
//				String b1=o1.getMaHoaDon().substring(1);
//				String b2=o2.getMaHoaDon().substring(1);
//				return Integer.parseInt(b2) - Integer.parseInt(b1);
//			}
//		});
//	}
//	public void sortByIdBillDESC() {
//	    Collections.sort(dsHD, new Comparator<HoaDon>() {
//	        @Override
//	        public int compare(HoaDon o1, HoaDon o2) {
//	            // Kiểm tra độ dài để tránh lỗi
//	            String b1 = o1.getMaHoaDon().length() > 1 ? o1.getMaHoaDon().substring(1) : "0";
//	            String b2 = o2.getMaHoaDon().length() > 1 ? o2.getMaHoaDon().substring(1) : "0";
//
//	            // Sắp xếp giảm dần
//	            return Integer.compare(Integer.parseInt(b2), Integer.parseInt(b1));
//	        }
//	    });
//	}
	
	public void sortByIdBillDESC() {
	    Collections.sort(dsHD, new Comparator<HoaDon>() {
	        @Override
	        public int compare(HoaDon o1, HoaDon o2) {
	            // Lấy phần số của mã hóa đơn, bỏ qua ký tự đầu tiên
	            String b1 = o1.getMaHoaDon().length() > 1 ? o1.getMaHoaDon().substring(2) : "0";
	            String b2 = o2.getMaHoaDon().length() > 1 ? o2.getMaHoaDon().substring(2) : "0";

	            try {
	                // Chuyển đổi phần sau ký tự đầu tiên thành số
	                int number1 = Integer.parseInt(b1);
	                int number2 = Integer.parseInt(b2);

	                // Sắp xếp giảm dần
	                return Integer.compare(number2, number1);
	            } catch (NumberFormatException e) {
	                // Xử lý khi không thể chuyển đổi thành số, ví dụ: mã hóa đơn không hợp lệ
	                return 0; // Nếu mã hóa đơn không hợp lệ, không thay đổi thứ tự
	            }
	        }
	    });
	}
	
	public void sortByTotalPriceASC() {
		Collections.sort(dsHD, new Comparator<HoaDon>() {
			@Override
			public int compare(HoaDon o1, HoaDon o2) {
				// TODO Auto-generated method stub
				return (int) (o1.getTongTien() - o2.getTongTien());
			}
		});
	}
	
	public void sortByTotalPriceDESC() {
		Collections.sort(dsHD, new Comparator<HoaDon>() {
			@Override
			public int compare(HoaDon o1, HoaDon o2) {
				// TODO Auto-generated method stub
				return (int) (o2.getTongTien() - o1.getTongTien());
			}
		});
	}
	
	public ArrayList<HoaDon> getAllHoaDonByMa(String ma){
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		try {
			PreparedStatement stmt = con.prepareStatement("select maHoaDon, ngayLap, tongTien, hinhThucThanhToan ,k.maKH, k.tenKH, n.maNV, n.tenNV "
                    + " from HoaDon h join KhachHang k on h.maKH = k.maKH join NhanVien n on h.maNV = n.maNV where maHoaDon like ?");
			stmt.setString(1, "%"+ma+"%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String maHD = rs.getString(1);
				LocalDate ngayLap = rs.getDate(2).toLocalDate();
				double tongTien = rs.getDouble(3);
				String htThanhToan = rs.getString(4);
				KhachHang kh = new KhachHang(rs.getString(5),rs.getString(6));
				NhanVien nv = new NhanVien(rs.getString(7),rs.getString(8));
				dsHD.add(new HoaDon(maHD, ngayLap, tongTien, htThanhToan, kh, nv));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	
	public ArrayList<HoaDon> getAllHoaDonByNV(String name) {
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		try {
			PreparedStatement stmt = con.prepareStatement("select maHoaDon, ngayLap, tongTien, hinhThucThanhToan, k.maKH, k.tenKH, n.maNV, n.tenNV "
					+ "from HoaDon h join KhachHang k on h.maKH = k.maKH join NhanVien n on h.maNV = n.maNV where n.tenNV like ?");
			stmt.setString(1, "%" + name + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				LocalDate ngayLap = rs.getDate(2).toLocalDate();
				double tongTien = rs.getDouble(3);
				String htThanhToan = rs.getString(4);
				KhachHang kh = new KhachHang(rs.getString(5),rs.getString(6));
				NhanVien nv = new NhanVien(rs.getString(7),rs.getString(8));
				dsHD.add(new HoaDon(maHoaDon, ngayLap, tongTien, htThanhToan, kh, nv));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	
	public ArrayList<HoaDon> getAllHoaDonByKH(String name) {
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		try {
			PreparedStatement stmt = con.prepareStatement("select maHoaDon, ngayLap, tongTien, hinhThucThanhToan, k.maKH, k.tenKH, n.maNV, n.tenNV "
					+ "from HoaDon h join KhachHang k on h.maKH = k.maKH join NhanVien n on h.maNV = n.maNV where k.tenKH like ?");
			stmt.setString(1, "%" + name + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				LocalDate ngayLap = rs.getDate(2).toLocalDate();
				double tongTien = rs.getDouble(3);
				String htThanhToan = rs.getString(4);
				KhachHang kh = new KhachHang(rs.getString(5),rs.getString(6));
				NhanVien nv = new NhanVien(rs.getString(7),rs.getString(8));
				dsHD.add(new HoaDon(maHoaDon, ngayLap, tongTien, htThanhToan, kh, nv));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	
	public ArrayList<HoaDon> getAllHoaDonByDate(String date) {
	    ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    
	    try {
	        // Kiểm tra kết nối
	        if (con == null || con.isClosed()) {
	            System.out.println("Kết nối đến cơ sở dữ liệu thất bại.");
	            return dsHD;
	        }

	        // Câu lệnh SQL với khoảng trắng trước "from"
	        String sql = "SELECT maHoaDon, ngayLap, tongTien, hinhThucThanhToan, k.maKH, k.tenKH, n.maNV, n.tenNV " +
	                     "FROM HoaDon h JOIN KhachHang k ON h.maKH = k.maKH JOIN NhanVien n ON h.maNV = n.maNV WHERE ngayLap = ?";
	        PreparedStatement stmt = con.prepareStatement(sql);

	        // Chuyển đổi và thiết lập ngày
	        System.out.println("Định dạng ngày truyền vào: " + date);  // In ra để kiểm tra định dạng ngày
	        stmt.setDate(1, Date.valueOf(date));

	        ResultSet rs = stmt.executeQuery();
	        
	        // Kiểm tra xem có dữ liệu trả về hay không
	        if (!rs.isBeforeFirst()) {
	            System.out.println("Không có hóa đơn nào khớp với ngày " + date);
	        }

	        while (rs.next()) {
	            String maHoaDon = rs.getString(1);
	            LocalDate ngayLap = rs.getDate(2).toLocalDate();
	            double tongTien = rs.getDouble(3);
	            String htThanhToan = rs.getString(4);
	            KhachHang kh = new KhachHang(rs.getString(5), rs.getString(6));
	            NhanVien nv = new NhanVien(rs.getString(7), rs.getString(8));
	            dsHD.add(new HoaDon(maHoaDon, ngayLap, tongTien, htThanhToan, kh, nv));
	        }
	    } catch (SQLException e) {
	        System.out.println("Lỗi SQL: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return dsHD;
	}
//	
//	public ArrayList<HoaDon> getAllHoaDonFromDateToDate(String from, String to) {
//		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement stmt = con.prepareStatement("select maHoaDon, ngayLap, tongTien, k.maKH, k.tenKH, n.maNV, n.tenNV"
//					+ "from HoaDon h join KhachHang k on h.maKH = k.maKH join NhanVien n on h.maNV = n.maNV where ngayLap between ? and ?");
//			stmt.setDate(1, Date.valueOf(from));
//			stmt.setDate(2, Date.valueOf(to));
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				String maHoaDon = rs.getString(1);
//				LocalDate ngayLap = rs.getDate(2).toLocalDate();
//				double tongTien = rs.getDouble(3);
//				String htThanhToan = rs.getString(4);
//				KhachHang kh = new KhachHang(rs.getString(5),rs.getString(6));
//				NhanVien nv = new NhanVien(rs.getString(7),rs.getString(8));
//				dsHD.add(new HoaDon(maHoaDon, ngayLap, tongTien, htThanhToan, kh, nv));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return dsHD;
//	}
	
	public ArrayList<HoaDon> getAllHoaDonFromDateToDate(String from, String to) {
	    ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    
	    try {
	        // Sử dụng PreparedStatement với ngày đã chuyển sang java.sql.Date
	        PreparedStatement stmt = con.prepareStatement("SELECT maHoaDon, ngayLap, tongTien, k.maKH, k.tenKH, n.maNV, n.tenNV " +
	                "FROM HoaDon h " +
	                "JOIN KhachHang k ON h.maKH = k.maKH " +
	                "JOIN NhanVien n ON h.maNV = n.maNV " +
	                "WHERE ngayLap BETWEEN ? AND ?");
	        
	        // Chuyển LocalDate thành java.sql.Date
	        stmt.setDate(1, java.sql.Date.valueOf(from)); 
	        stmt.setDate(2, java.sql.Date.valueOf(to));
	        
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            String maHoaDon = rs.getString(1);
	            LocalDate ngayLap = rs.getDate(2).toLocalDate();  // Chuyển từ java.sql.Date sang LocalDate
	            double tongTien = rs.getDouble(3);
	            String htThanhToan = rs.getString(4);
	            KhachHang kh = new KhachHang(rs.getString(5), rs.getString(6));
	            NhanVien nv = new NhanVien(rs.getString(7), rs.getString(8));
	            dsHD.add(new HoaDon(maHoaDon, ngayLap, tongTien, htThanhToan, kh, nv));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dsHD;
	}
	
	public boolean create(HoaDon HoaDon) {
		int n = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into HoaDon values (?, ?, ?, ?, ?, ?)");
			stmt.setString(1, HoaDon.getMaHoaDon());
			stmt.setDate(2, Date.valueOf (HoaDon.getNgayLap()));
			stmt.setDouble(3, HoaDon.getTongTien());
			stmt.setString(4,HoaDon.getHinhthucThanhToan());
			stmt.setString(5, HoaDon.getKhachhang().getMaKH());
			stmt.setString(6, HoaDon.getNhanvien().getMaNV());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n != 0;
	}
	
	public boolean delete(String ma) {
		int n = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("delete from HoaDon where maHoaDon = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n != 0;
	}
	
	public boolean update(HoaDon HoaDon) {
		int n = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("update HoaDon set date = ?, tongTien = ?, maNV = ?, maKH = ? where maHoaDon = ?");
			stmt.setDate(1, Date.valueOf (HoaDon.getNgayLap()));
			stmt.setDouble(2, HoaDon.getTongTien());
			stmt.setString(3,HoaDon.getHinhthucThanhToan());
			stmt.setString(4, HoaDon.getKhachhang().getMaKH());
			stmt.setString(5, HoaDon.getNhanvien().getMaNV());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n != 0;
	}
	
	public ArrayList<HoaDon> getAllHoaDonBymaKH(String ma) {
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		try {
			PreparedStatement stmt = con.prepareStatement("select maHoaDon, ngayLap, tongTien, n.maNV, n.tenNV, k.maKH, k.tenKH"
					+ "from HoaDon h join KhachHang k on h.maKH = k.maKH join NhanVien n on h.maNV = n.maNV where k.maKH like ?");
			stmt.setString(1, "%" + ma + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				LocalDate ngayLap = rs.getDate(2).toLocalDate();
				double tongTien = rs.getDouble(3);
				String htThanhToan = rs.getString(4);
				KhachHang kh = new KhachHang(rs.getString(5),rs.getString(6));
				NhanVien nv = new NhanVien(rs.getString(7),rs.getString(8));
				dsHD.add(new HoaDon(maHoaDon, ngayLap, tongTien, htThanhToan, kh, nv));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHD;
	}
	
	public ArrayList<HoaDon> getAllHoaDonBymaKHAndDateRange(String ma, LocalDate dateFrom, LocalDate dateTo) {
//	    ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    
	    try {
	        PreparedStatement stmt = con.prepareStatement("SELECT maHoaDon, ngayLap, tongTien, n.maNV, n.tenNV, k.maKH, k.tenKH"
	                + "FROM HoaDon h JOIN KhachHang k ON h.maKH = k.maKH "
	                + "JOIN NhanVien n ON h.maNV = n.maNV "
	                + "WHERE k.maKH = ? AND ngayLap BETWEEN ? AND ?");
	        stmt.setString(1, ma);
	        stmt.setDate(2, Date.valueOf(dateFrom));
	        stmt.setDate(3, Date.valueOf(dateTo));
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
				String maHoaDon = rs.getString(1);
				LocalDate ngayLap = rs.getDate(2).toLocalDate();
				double tongTien = rs.getDouble(3);
				String htThanhToan = rs.getString(4);
				KhachHang kh = new KhachHang(rs.getString(5),rs.getString(6));
				NhanVien nv = new NhanVien(rs.getString(7),rs.getString(8));
				dsHD.add(new HoaDon(maHoaDon, ngayLap, tongTien, htThanhToan, kh, nv));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dsHD;
	}

}