package frm;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.management.modelmbean.ModelMBean;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import controller.ConnectDB;
import dao.dsSanPham;
import dao.NhanVien_Dao;
import entity.NhanVien;
public class frm_quanLyNhanVien extends frm_default implements ActionListener, MouseListener{

	private JPanel jpTitle;
	private JTable table_nhanvien;
	private DefaultTableModel model_tableNV;
	private JTextField txtMa, txtTen, txtDiaChi, txtSdt,txtMaTim, txtNgaySinh, txtNgayVaoLam, txtLuong;
	private JRadioButton nam,nu;
	private ButtonGroup group;
		
	private JButton btnTim, btnXoa, btnXoarong, btnThem, btnLuu, btnSua;
	private NhanVien_Dao dao;
	private NhanVien_Dao ds;
	private ArrayList<NhanVien> list;
	private String ma_login;
	frm_quanLyNhanVien(String maLogin) {
		super(maLogin);
		setTitle("Cửa hàng tiện lợi");
		ConnectDB.getInstance().connect();
		ds = new NhanVien_Dao();
		list = ds.getAllNV();
		jlTitle.setText("Quản lý nhân viên");
				

		JPanel pQuanly = new JPanel();
		Font fnTitle = new Font("Times New Roman", Font.BOLD + Font.ITALIC, 15);
		pQuanly.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white),
				"Quản lý nhân viên", 0, 0, fnTitle, Color.gray));
		pQuanly.setPreferredSize(new Dimension(1500,200));
		Box bLeft, bRight;
		
		bLeft = new Box(BoxLayout.Y_AXIS);
		bLeft.setPreferredSize(new Dimension(700,170));
		bLeft.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Thông tin nhân viên"));
		
		Box brong,b1,b2,b3;
		
		
		JLabel lMaNV, lTen, lPhai, lNgaySinh, lDiaChi, lSdt, lNgayVaoLam, lLuong;
		b1 = new Box(BoxLayout.X_AXIS);
		lMaNV = new JLabel("Mã nhân viên: ");
		txtMa = new JTextField(3);
		lTen = new JLabel("Tên nhân viên: ");
		txtTen = new JTextField(3);
		lPhai = new JLabel("Phái: ");
		nam = new JRadioButton("Nam");
		nu = new JRadioButton("Nữ");
		group = new ButtonGroup();
		group.add(nam);
		group.add(nu);
		b1.add(lMaNV);
		b1.add(txtMa);
		b1.add(Box.createHorizontalStrut(5));
		b1.add(lTen);
		b1.add(Box.createHorizontalStrut(5));
		b1.add(txtTen);
		b1.add(Box.createHorizontalStrut(5));
		b1.add(lPhai);
		b1.add(Box.createHorizontalStrut(5));
		b1.add(nam);
		b1.add(nu);
		
		b2 = new Box(BoxLayout.X_AXIS);
		lNgaySinh = new JLabel("Ngày sinh: ");
		txtNgaySinh = new JTextField(3);
		lDiaChi = new JLabel("Địa chỉ: ");
		txtDiaChi = new JTextField(3);
		b2.add(lNgaySinh);
		b2.add(txtNgaySinh);
		b2.add(Box.createHorizontalStrut(5));
		b2.add(lDiaChi);
		b2.add(Box.createHorizontalStrut(5));
		b2.add(txtDiaChi);
		
		
		b3 = new Box(BoxLayout.X_AXIS);
		lSdt = new JLabel("Số điện thoại: ");
		txtSdt = new JTextField(3);
		lNgayVaoLam = new JLabel("Ngày vào làm: ");
		txtNgayVaoLam = new JTextField(3);
		lLuong = new JLabel("Lương: ");
		txtLuong = new JTextField(3);
		
		b3.add(lSdt);
		b3.add(txtSdt);
		b3.add(Box.createHorizontalStrut(5));
		b3.add(lNgayVaoLam);
		b3.add(Box.createHorizontalStrut(5));
		b3.add(txtNgayVaoLam);
		b3.add(Box.createHorizontalStrut(5));
		b3.add(lLuong);
		b3.add(Box.createHorizontalStrut(5));
		b3.add(txtLuong);
		
		lNgaySinh.setPreferredSize(lSdt.getPreferredSize());
		brong = new Box(BoxLayout.Y_AXIS);;
		brong.setPreferredSize(new Dimension(170,15));
		
		bLeft.add(brong);
		bLeft.add(b1);
		bLeft.add(Box.createVerticalStrut(40));
		bLeft.add(b2);
		bLeft.add(Box.createVerticalStrut(40));
		bLeft.add(b3);
			
		bRight = new Box(BoxLayout.Y_AXIS);
		bRight.setPreferredSize(new Dimension(400,170));
		bRight.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Tác vụ"));
		
		JLabel lTimMa = new JLabel();
		lTimMa =  new JLabel("Nhập mã số nhân viên cần tìm: ");
		txtMaTim  = new JTextField(3);
		btnTim = new JButton("Tìm");
		Box b4,b5,b6;
		b4 = new Box(BoxLayout.X_AXIS);
		b4.add(lTimMa);
		b4.add(txtMaTim);
		b4.add(btnTim);
		
		
		b5 = new Box(BoxLayout.X_AXIS);
		btnThem = new JButton("Thêm nhân viên");
		btnXoa = new JButton("Xoá");
		btnXoarong = new JButton("Xóa rỗng");
		btnLuu = new JButton("Lưu");
		btnSua = new JButton("Sửa");
		
		b5.add(btnThem);
		b5.add(Box.createHorizontalStrut(10));
		b5.add(btnXoarong);
		b5.add(Box.createHorizontalStrut(10));
		b5.add(btnXoa);
		
		b6 = new Box(BoxLayout.X_AXIS);
		
		b6.add(btnSua);
		b6.add(Box.createHorizontalStrut(10));
		b6.add(btnLuu);
		
		bRight.add(brong);
		bRight.add(Box.createVerticalStrut(20));
		bRight.add(b4);
		bRight.add(Box.createVerticalStrut(20));
		bRight.add(b5);
		bRight.add(Box.createVerticalStrut(20));
		bRight.add(b6);
		bRight.add(brong);
		
		pQuanly.add(bLeft);
		pQuanly.add(Box.createHorizontalStrut(70));
		pQuanly.add(bRight);		
		jpCen.add(pQuanly);
		String[] cells = {"Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Địa chỉ", "Giới tính", "Lương", "Ngày vào làm", "Số điện thoại"};
		model_tableNV = new DefaultTableModel(cells,0);
		table_nhanvien = new JTable(model_tableNV);
		JScrollPane scroll = new JScrollPane(table_nhanvien);
		scroll.setPreferredSize(new Dimension(1000,500));
		jpCen.add(scroll);
		
		btnLuu.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoarong.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTim.addActionListener(this);
		add(jpCen, BorderLayout.CENTER);
		
		table_nhanvien.addMouseListener(this);
		menuDNTK.setText(maLogin);
		hienTable();
		setVisible(true);
	}
	
	
	private void hienTable() {
	    NhanVien_Dao nhanVienDao = new NhanVien_Dao();
	    ArrayList<NhanVien> employees = nhanVienDao.getAllNV();

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	    model_tableNV.setRowCount(0);

	    for (NhanVien nv : employees) {
	        model_tableNV.addRow(new Object[] {
	            nv.getMaNV(),
	            nv.getTenNV(),
	            nv.getNgaySinh().format(formatter),
	            nv.getDiaChi(),
	            nv.isPhai() ? "Nữ" : "Nam",
	            nv.getLuong(),
	            nv.getNgayVaoLam().format(formatter),
	            nv.getSdt()
	        });
	    }
	}

	public static void main(String[] args) {
		NhanVien_Dao dao = new NhanVien_Dao();
		new frm_quanLyNhanVien("1");
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int selectedRow = table_nhanvien.getSelectedRow();
	    if (selectedRow != -1) { 
	        txtMa.setText(table_nhanvien.getValueAt(selectedRow, 0).toString());
	        txtTen.setText(table_nhanvien.getValueAt(selectedRow, 1).toString());
	        txtNgaySinh.setText(table_nhanvien.getValueAt(selectedRow, 2).toString());
	        txtDiaChi.setText(table_nhanvien.getValueAt(selectedRow, 3).toString());

	        String gender = table_nhanvien.getValueAt(selectedRow, 4).toString();
	        if (gender.equals("Nam")) {
	            nam.setSelected(true);
	        } else {
	            nu.setSelected(true);
	        }

	        txtLuong.setText(table_nhanvien.getValueAt(selectedRow, 5).toString());
	        txtNgayVaoLam.setText(table_nhanvien.getValueAt(selectedRow, 6).toString());
	        txtSdt.setText(table_nhanvien.getValueAt(selectedRow, 7).toString());
	    }
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void xoaAction() {
		int selectedRow = table_nhanvien.getSelectedRow();
	    
	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    
	    String maNV = (String) model_tableNV.getValueAt(selectedRow, 0);
	    
	    int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên " + maNV + "?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
	    
	    if (confirm == JOptionPane.YES_OPTION) {
	        if (ds.delete(maNV)) {
	            model_tableNV.removeRow(selectedRow);
	            JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công!");
	        } else {
	            JOptionPane.showMessageDialog(this, "Xóa nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}
	public void xoaRongAction() {
			txtMa.setText("");
			txtTen.setText("");
			txtDiaChi.setText("");
			txtLuong.setText("");
			txtMaTim.setText("");
			txtNgaySinh.setText("");
			txtSdt.setText("");
			txtNgayVaoLam.setText("");
			group.clearSelection();
		}
	public void themAction() {
	    try {
	        String maNV = txtMa.getText();
	        String tenNV = txtTen.getText();
	        String ngaySinhStr = txtNgaySinh.getText();
	        String diaChi = txtDiaChi.getText();
	        boolean phai = nu.isSelected();
	        double luong = Double.parseDouble(txtLuong.getText());
	        String ngayVaoLamStr = txtNgayVaoLam.getText();
	        String sdt = txtSdt.getText();
	        
	        if (!maNV.matches("^NV\\d{3}$")) {
	            JOptionPane.showMessageDialog(this, "Mã nhân viên phải gồm 2 ký tự đầu là số và ký tự cuối là chữ!");
	            return;
	        }
	        
	        if (ds.ismaNV(maNV)) {
	            JOptionPane.showMessageDialog(this, "Nhân viên với mã " + maNV + " đã tồn tại!");
	            return;
	        }
	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate ngaySinh = null;
	        LocalDate ngayVaoLam = null;
	        
	        try {
	            ngaySinh = LocalDate.parse(ngaySinhStr, formatter);
	            ngayVaoLam = LocalDate.parse(ngayVaoLamStr, formatter);
	        } catch (DateTimeParseException e) {
	            JOptionPane.showMessageDialog(this, "Ngày tháng không hợp lệ!", "Input Error", JOptionPane.WARNING_MESSAGE);
	            return;
	        }
	        
	        LocalDate today = LocalDate.now();

	        if (ngaySinh.isAfter(today.minusYears(18))) {
	            JOptionPane.showMessageDialog(this, "Nhân viên phải lớn hơn 18 tuổi!");
	            return;
	        }

	        if (ngayVaoLam.isAfter(today.minusMonths(1))) {
	            JOptionPane.showMessageDialog(this, "Ngày vào làm phải trước thời gian thực ít nhất 1 tháng!");
	            return;
	        }

	        if (!sdt.matches("0\\d{9}")) {
	            JOptionPane.showMessageDialog(this, "Số điện thoại phải gồm 10 số và bắt đầu bằng số 0!");
	            return;
	        }
	        if (luong <= 0) {
	            JOptionPane.showMessageDialog(this, "Lương phải là số dương hợp lệ!");
	            return;
	        }
	        NhanVien nhanVien = new NhanVien(maNV, tenNV, ngaySinh, diaChi, phai, luong, ngayVaoLam, sdt);
	        
	        if (ds.createNV(nhanVien)) {
	            model_tableNV.addRow(new Object[]{
	                maNV, tenNV, ngaySinh.format(formatter), diaChi, phai ? "Nữ" : "Nam", luong, ngayVaoLam.format(formatter), sdt
	            });
	            xoaRongAction();
	            JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công!");
	        } else {
	            JOptionPane.showMessageDialog(this, "Lỗi khi thêm nhân viên!", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Lương phải là số hợp lệ!", "Input Error", JOptionPane.WARNING_MESSAGE);
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi thêm nhân viên!", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	public void suaAction() {
		int selectedRow = table_nhanvien.getSelectedRow();
	    
	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần sửa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    
	    try {
	        String maNV = txtMa.getText();
	        String tenNV = txtTen.getText();
	        String diaChi = txtDiaChi.getText();
	        String sdt = txtSdt.getText();
	        boolean phai = nu.isSelected();
	        double luong = Double.parseDouble(txtLuong.getText());
	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	        LocalDate ngaySinh = LocalDate.parse(txtNgaySinh.getText(), formatter);
	        LocalDate ngayVaoLam = LocalDate.parse(txtNgayVaoLam.getText(), formatter);

	        NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, diaChi, phai, luong, ngayVaoLam, sdt);
	        
	        if (ds.updateNV(nv)) {
	            model_tableNV.setValueAt(tenNV, selectedRow, 1);
	            model_tableNV.setValueAt(ngaySinh.format(formatter), selectedRow, 2);
	            model_tableNV.setValueAt(diaChi, selectedRow, 3);
	            model_tableNV.setValueAt(phai ? "Nữ" : "Nam", selectedRow, 4);
	            model_tableNV.setValueAt(luong, selectedRow, 5);
	            model_tableNV.setValueAt(ngayVaoLam.format(formatter), selectedRow, 6);
	            model_tableNV.setValueAt(sdt, selectedRow, 7);
	            
	            JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thành công!");
	        } else {
	            JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (DateTimeParseException e) {
	        JOptionPane.showMessageDialog(this, "Ngày không hợp lệ!", "Lỗi nhập liệu", JOptionPane.WARNING_MESSAGE);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Lương phải là số hợp lệ!", "Lỗi nhập liệu", JOptionPane.WARNING_MESSAGE);
	    }
	}
	public void luuAction() {
		
	}
	public void timAction() {
	    String maNV = txtMaTim.getText().trim();
	    
	    if (maNV.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên cần tìm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    ArrayList<NhanVien> foundEmployees = ds.getNVByID(maNV);
	    
	    if (foundEmployees.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên với mã " + maNV, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        model_tableNV.setRowCount(0);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	        
	        for (NhanVien nv : foundEmployees) {
	            model_tableNV.addRow(new Object[]{
	                nv.getMaNV(),
	                nv.getTenNV(),
	                nv.getNgaySinh() != null ? nv.getNgaySinh().format(formatter) : "",
	                nv.getDiaChi(),
	                nv.isPhai() ? "Nữ" : "Nam",
	                nv.getLuong(),
	                nv.getNgayVaoLam() != null ? nv.getNgayVaoLam().format(formatter) : "",
	                nv.getSdt()
	            });
	        }
	    }
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.actionPerformed(e);
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			themAction();
		}
		else if(o.equals(btnXoarong)) {
			xoaRongAction();
		}
		else if(o.equals(btnXoa)) {
			xoaAction();
		}
		else if(o.equals(btnSua)) {
			suaAction();
		}
		else if(o.equals(btnLuu)) {
			luuAction();
		}
		else if(o.equals(btnTim)) {
			timAction();
		}
		else if (o.equals(menuSP)) {
	        new frm_SanPham();  
	        this.dispose();     
	    }else if (o.equals(mnuItemDNTK)) {
	    	new login_page();
	    	this.dispose(); 
	    }else if (o.equals(mnuItemDKTK)) {
	    	new login_page();
	    	this.dispose(); 
	    }else if (o.equals(mnuItemQLSP)) {
	    	new frm_SanPham();
	    	this.dispose(); 
	    }
	    else if(o.equals(mnuItemQLNV))
	    {
	    	ma_login = menuDNTK.getText();
	    	new frm_dsNhanVien(ma_login).setVisible(true);
	    	this.dispose();
	    }
		
	}

	
	
}
