package dao;

import java.util.ArrayList;

import entity.KhachHang;

public class dsKH {
	ArrayList<KhachHang> dsKH;

	public dsKH() {
		dsKH = new ArrayList<KhachHang>();
	}

	public boolean themKH(KhachHang kh1) {
		if (dsKH.contains(kh1)) {
			return false;
		}
		dsKH.add(kh1);
		return true;

	}
	public boolean xoaKH(String maKH1) {
		KhachHang kh1 = new KhachHang(maKH1);
		if(dsKH.contains(kh1)) {
			dsKH.remove(kh1);
			return true;
		}
		return false;
		
	}
	
	
	
	public int soLuongKH() {
		return dsKH.size();
	}
	
	public KhachHang returnKH(int i) {
		return dsKH.get(i);
		
	}
	public KhachHang TimKH(String makh) {
		KhachHang kh1 = new KhachHang(makh);
		if(dsKH.contains(kh1))
			return dsKH.get(dsKH.indexOf(kh1));
		return null;
		
	}
}
