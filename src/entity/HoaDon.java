package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class HoaDon implements Serializable{
	private String maHoaDon;
	private LocalDate ngayLap;
	private double tongTien;
	private String hinhthucThanhToan;
	private KhachHang khachhang;
	private SanPham sanpham;
	private NhanVien nhanvien;
	public HoaDon(String maHoaDon, LocalDate ngayLap, double tongTien, String hinhthucThanhToan, KhachHang khachhang, SanPham sanpham, NhanVien nhanvien) {
		// TODO Auto-generated constructor stub
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
		this.hinhthucThanhToan = hinhthucThanhToan;
		this.khachhang = khachhang;
		this.sanpham = sanpham;
		this.nhanvien = nhanvien;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public LocalDate getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public String getHinhthucThanhToan() {
		return hinhthucThanhToan;
	}
	public void setHinhthucThanhToan(String hinhthucThanhToan) {
		this.hinhthucThanhToan = hinhthucThanhToan;
	}
	public KhachHang getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public NhanVien getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}
	
	
}
