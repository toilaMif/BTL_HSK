package dao;

import java.awt.image.SampleModel;
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
	public Boolean sua(String maSP1 , SanPham spNew) {
		SanPham sp1 = new SanPham(maSP1);
		
		if(dsSP.contains(sp1)) {
			dsSP.get(dsSP.indexOf(sp1)).setMaSP(spNew.getMaSP());
			dsSP.get(dsSP.indexOf(sp1)).setTenSp(spNew.getTenSp());
			dsSP.get(dsSP.indexOf(sp1)).setLoaiSP(spNew.getLoaiSP());
			dsSP.get(dsSP.indexOf(sp1)).setSoLuong(spNew.getSoLuong());
			dsSP.get(dsSP.indexOf(sp1)).setXuatXu(spNew.getXuatXu());
			dsSP.get(dsSP.indexOf(sp1)).setThuongHieu(spNew.getThuongHieu());
			dsSP.get(dsSP.indexOf(sp1)).setMoTa(spNew.getMoTa());
			dsSP.get(dsSP.indexOf(sp1)).setNhaSanXuat(spNew.getNhaSanXuat());
			dsSP.get(dsSP.indexOf(sp1)).setDonGia(spNew.getDonGia());
			return true;
		}
		
		return false;
	}
	
	
	public int soLuongSP() {
		return dsSP.size();
	}
	
	public SanPham returnSP(int i) {
		return dsSP.get(i);
		
	}

}
