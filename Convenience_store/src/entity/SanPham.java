package entity;

import java.util.Objects;

public class SanPham {
	private String maSP;
	private String tenSp;
	private String loaiSP;
	private int soLuong;

	public SanPham(String maSP, String tenSp, String loaiSP, int soLuong) {
		super();
		this.maSP = maSP;
		this.tenSp = tenSp;
		this.loaiSP = loaiSP;
		this.soLuong = soLuong;
	}

	public SanPham() {
		super();
	}

	public SanPham(String maSP) {
		super();
		this.maSP = maSP;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSp() {
		return tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}

	public String getLoaiSP() {
		return loaiSP;
	}

	public void setLoaiSP(String loaiSP) {
		this.loaiSP = loaiSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSP);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSP, other.maSP);
	}

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSp=" + tenSp + ", loaiSP=" + loaiSP + ", soLuong=" + soLuong + "]";
	}

}
