package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class NhanVien implements Serializable{
	private String maNV;
	private String tenNV;
	private boolean phai;
	private LocalDate ngaySinh;
	private String diaChi;
	private String sdt;
	private LocalDate ngayVaoLam;
	private double luong;
	

	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
		this.tenNV = "";
		this.phai = true;
		this.ngaySinh = LocalDate.now();
		this.diaChi = "";
		this.sdt = "";
		this.ngayVaoLam = LocalDate.now();
		this.luong = 0.0;
	}
	public NhanVien(String maNV, String tenNV, boolean phai, LocalDate ngaySinh, String diaChi, String sdt,
			LocalDate ngayVaoLam) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.phai = phai;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.ngayVaoLam = ngayVaoLam;
		this.luong = luong;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public boolean isPhai() {
		return phai;
	}
	public void setPhai(boolean phai) {
		this.phai = phai;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public LocalDate getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(LocalDate ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	
	
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV) || Objects.equals(tenNV, other.tenNV);
	}

}
