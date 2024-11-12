package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private LocalDate ngaySinh;
	private boolean gioiTinh;
	private String loaiThanhVien;
	
	public KhachHang(String maKH, String tenKH, LocalDate ngaySinh, boolean gioiTinh, String loaiThanhVien) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.loaiThanhVien = loaiThanhVien;
	}
	
	public KhachHang(String maKH) {
		// TODO Auto-generated constructor stub
		super();
		this.maKH = maKH;
	}
	
	public KhachHang(String maKH, String tenKH) {
		// TODO Auto-generated constructor stub
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getLoaiThanhVien() {
		return loaiThanhVien;
	}

	public void setLoaiThanhVien(String loaiThanhVien) {
		this.loaiThanhVien = loaiThanhVien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tenKH);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(tenKH, other.tenKH);
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh
				+ ", loaiThanhVien=" + loaiThanhVien + "]";
	}
	
	
	

}
