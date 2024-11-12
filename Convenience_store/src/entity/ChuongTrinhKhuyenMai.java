package entity;

import java.util.Date;

public class ChuongTrinhKhuyenMai {
	private String maGiamGia;
	private Date han;
	private String loaiGiamGia;
	public String getMaGiamGia() {
		return maGiamGia;
	}
	public void setMaGiamGia(String maGiamGia) {
		this.maGiamGia = maGiamGia;
	}
	public Date getHan() {
		return han;
	}
	public void setHan(Date han) {
		this.han = han;
	}
	public String getLoaiGiamGia() {
		return loaiGiamGia;
	}
	public void setLoaiGiamGia(String loaiGiamGia) {
		this.loaiGiamGia = loaiGiamGia;
	}
	public ChuongTrinhKhuyenMai(String maGiamGia, Date han, String loaiGiamGia) {
		super();
		this.maGiamGia = maGiamGia;
		this.han = han;
		this.loaiGiamGia = loaiGiamGia;
	}
	public ChuongTrinhKhuyenMai() {
		super();
	}
	
}
