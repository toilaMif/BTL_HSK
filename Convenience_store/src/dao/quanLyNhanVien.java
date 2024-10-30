package dao;

import java.io.Serializable;
import java.util.ArrayList;

import entity.thongTinNhanVien;

public class quanLyNhanVien implements Serializable{

	private ArrayList<thongTinNhanVien> list;
	
	public quanLyNhanVien() {	
		list = new ArrayList<thongTinNhanVien>();
	}
	
	public ArrayList<thongTinNhanVien> getListEmp(){
		return list;
	}
	
	
	
}
