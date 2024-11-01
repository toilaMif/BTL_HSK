package entity;

import java.util.Objects;


public class Account {
	private String maTk;
	private String tenNguoiDung;
	private String matKhau;
	
	
	public Account(String maTk) {
		super();
		this.maTk = maTk;
		this.tenNguoiDung = "";
		this.matKhau = "";
	}

	public Account(String maTk, String tenNguoiDung, String matKhau) {
		super();
		this.maTk = maTk;
		this.tenNguoiDung = tenNguoiDung;
		this.matKhau = matKhau;
	}
	
	public String getMaTk() {
		return maTk;
	}
	public void setMaTk(String maTk) {
		this.maTk = maTk;
	}
	public String getTenNguoiDung() {
		return tenNguoiDung;
	}
	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTk);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(maTk, other.maTk);
	}
	
	
	
	
}
