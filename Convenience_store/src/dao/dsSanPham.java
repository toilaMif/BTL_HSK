package dao;

import java.util.ArrayList;

import entity.SanPham;

public class dsSanPham {
	ArrayList<SanPham> dsSP;

	public dsSanPham() {
		dsSP = new ArrayList<SanPham>();
	}

	public boolean themSP(SanPham sp1) {
		if (dsSP.contains(sp1)) {
			return false;
		}
		dsSP.add(sp1);
		return true;

	}
	public boolean xoaSP(String maSP1) {
		SanPham sp1 = new SanPham(maSP1);
		if(dsSP.contains(sp1)) {
			dsSP.remove(sp1);
			return true;
		}
		return false;
		
	}
	

}
