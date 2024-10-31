package dao;

import java.io.Serializable;
import java.util.ArrayList;

import entity.nhanVien;

public class quanLyNhanVien implements Serializable{

	private ArrayList<nhanVien> list;
	
	public quanLyNhanVien() {	
		list = new ArrayList<nhanVien>();
	}
	
	public ArrayList<nhanVien> getListEmp(){
		return list;
	}
	
	
	
}
