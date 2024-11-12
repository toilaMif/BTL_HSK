package entity;

import java.time.LocalDate;

public class DaySanPham {
	private LocalDate ngayNhap;
	private LocalDate ngaySanXuat;
	private LocalDate ngayHetHan;

	public LocalDate getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public DaySanPham() {
		super();
	}

	public DaySanPham(LocalDate ngayNhap, LocalDate ngaySanXuat, LocalDate ngayHetHan) {
		super();
		this.ngayNhap = ngayNhap;
		this.ngaySanXuat = ngaySanXuat;
		this.ngayHetHan = ngayHetHan;
	}

	public static void main(String[] args) {
		LocalDate ngayNhap = LocalDate.of(2024, 9, 12);
		LocalDate ngaySanXuat = LocalDate.of(2024, 9, 12);
		LocalDate ngayHetHan = LocalDate.of(2024, 9, 12);

		DaySanPham sp1 = new DaySanPham(ngayNhap, ngaySanXuat, ngayHetHan);
		System.out.println("Ngày nhập: " + sp1.getNgayNhap());
		System.out.println("Ngày sản xuất: " + sp1.getNgaySanXuat());
		System.out.println("Ngày hết hạn: " + sp1.getNgayHetHan());
	}
}
