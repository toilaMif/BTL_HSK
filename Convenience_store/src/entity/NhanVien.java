package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class NhanVien implements Serializable{
	private String maNV;
	private String tenNV;
	private LocalDate ngaySinh;
	private String diaChi;
	private boolean phai;
	private double luong;
	private LocalDate ngayVaoLam;
	private String sdt;
	private String maTK;

	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
		this.tenNV = "";
		this.ngaySinh = LocalDate.now();
		this.diaChi = "";
		this.phai = true;
		this.luong = 0.0;
		this.ngayVaoLam = LocalDate.now();
		this.sdt = "";
		this.maTK = " ";
	}
	
	
	
	public NhanVien(String maNV, String tenNV, LocalDate ngaySinh, String diaChi, boolean phai, double luong,
			LocalDate ngayVaoLam, String sdt, String maTK) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.phai = phai;
		this.luong = luong;
		this.ngayVaoLam = ngayVaoLam;
		this.sdt = sdt;
		this.maTK = maTK;
	}

	public NhanVien(String maNV, String tenNV, LocalDate ngaySinh, String diaChi, boolean phai, double luong,
			LocalDate ngayVaoLam, String sdt) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;	
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.phai = phai;
		this.luong = luong;
		this.ngayVaoLam = ngayVaoLam;
		this.sdt = sdt;
	}


	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	
	public String getMaTK() {
		return maTK;
	}
	public void setMaTK(String maTK) {
		this.maTK = maTK;
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
