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
		super();
		ConnectDB.getInstance().connect();
		ds = new NhanVien_Dao();
		list = ds.getAllNV();
		jlTitle.setText("Quản lý nhân viên");
				

		JPanel pQuanly = new JPanel();
//		pQuanly.setLayout(new BorderLayout());
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
//		b2.add(Box.createHorizontalStrut(5));
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
		
//		lMaNV.setPreferredSize(lSdt.getPreferredSize());
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
		
		menuDNTK.setText(maLogin);
		hienTable();
		setVisible(true);
	}
	
	
	private void hienTable() {
	    NhanVien_Dao nhanVienDao = new NhanVien_Dao();
	    ArrayList<NhanVien> employees = nhanVienDao.getAllNV();

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    // Clear existing data
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
		// TODO Auto-generated method stub
		
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

	public void themAction() {
		
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
			nu.setSelected(true);
			nam.setSelected(true);
		}
	public void xoaAction() {
		try {
            String maNV = txtMa.getText();
            String tenNV = txtTen.getText();
            String ngaySinhStr = txtNgaySinh.getText();
            String diaChi = txtDiaChi.getText();
            Boolean phai = nu.isSelected();
            double luong = Double.parseDouble(txtLuong.getText());
            String ngayVaoLamStr = txtNgayVaoLam.getText();
            String sdt = txtSdt.getText();
            String maTK = ma_login;
            
            // Initialize DAO and check if the employee already exists
            NhanVien_Dao nhanVienDao = new NhanVien_Dao();
            if (nhanVienDao.ismaNV(maNV)) {
                JOptionPane.showMessageDialog(this, "Nhân viên với mã " + maNV + " đã tồn tại!");
                return;
            }
            
            // Parse dates with a formatter
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate ngaySinh = LocalDate.parse(ngaySinhStr, formatter);
            LocalDate ngayVaoLam = LocalDate.parse(ngayVaoLamStr, formatter);

            // Add new employee data to the table
            model_tableNV.addRow(new Object[] {
                maNV,          // Mã nhân viên
                tenNV,         // Tên nhân viên
                phai ? "Nữ" : "Nam", // Phái (display as "Nam" or "Nữ")
                ngaySinh,   // Ngày sinh
                diaChi,        // Địa chỉ
                sdt,           // Số điện thoại
                ngayVaoLam, // Ngày vào làm
                luong          // Lương
            });

            // Clear input fields after successful addition
            txtMa.setText("");
            txtTen.setText("");
            txtNgaySinh.setText("");
            txtDiaChi.setText("");
            txtLuong.setText("");
            txtNgayVaoLam.setText("");
            txtSdt.setText("");
            group.clearSelection();
            JOptionPane.showMessageDialog(btnThem, "Thêm nhân viên thành công");
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày tháng theo định dạng dd/MM/yyyy!", "Input Error", JOptionPane.WARNING_MESSAGE);
            ex.printStackTrace();
        }
	}
	public void suaAction() {
		
	}
	public void luuAction() {
		
	}
	public void timAction() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			themAction();
		}
		if(o.equals(btnThem)) {
			xoaRongAction();
		}
		if(o.equals(btnThem)) {
			xoaAction();
		}
		if(o.equals(btnThem)) {
			suaAction();
		}
		if(o.equals(btnThem)) {
			luuAction();
		}
		if(o.equals(btnThem)) {
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
	}

	
	
}
