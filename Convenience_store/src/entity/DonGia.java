package entity;

public class DonGia {
	private double donGiaNhap;
	private double donGiaBan;
	private double donGiaKhuyenMai;

	public DonGia(double donGiaNhap, double donGiaBan, double donGiaKhuyenMai) {
		super();
		this.donGiaNhap = donGiaNhap;
		this.donGiaBan = donGiaBan;
		this.donGiaKhuyenMai = donGiaKhuyenMai;
	}

	public DonGia() {
		super();
	}

	public double getDonGiaNhap() {
		return donGiaNhap;
	}

	public void setDonGiaNhap(double donGiaNhap) {
		this.donGiaNhap = donGiaNhap;
	}

	public double getDonGiaBan() {
		return donGiaBan;
	}

	public void setDonGiaBan(double donGiaBan) {
		this.donGiaBan = donGiaBan;
	}

	public double getDonGiaKhuyenMai() {
		return donGiaKhuyenMai;
	}

	public void setDonGiaKhuyenMai(double donGiaKhuyenMai) {
		this.donGiaKhuyenMai = donGiaKhuyenMai;
	}

}
