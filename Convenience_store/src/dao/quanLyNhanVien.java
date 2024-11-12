package dao;

import java.io.Serializable;
import java.util.ArrayList;

import entity.NhanVien;

public class quanLyNhanVien implements Serializable{

	private ArrayList<NhanVien> list;
	
	public quanLyNhanVien() {	
		list = new ArrayList<NhanVien>();
	}
	
	public ArrayList<NhanVien> getListEmp(){
		return list;
	}
	
	
	
}
