package frm;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.chrono.JapaneseDate;

import javax.management.modelmbean.ModelMBean;
import javax.swing.Action;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
public class frm_quanLyNhanVien extends frm_default implements ActionListener, MouseListener{

	
	private JMenuBar menubar;
	private JMenu menuNV;
	private JPanel jpCen;
	private JMenu menuSP;
	private JMenu menuKH;
	private JMenu menuHD;
	private JMenu menuDM;
	private JMenu menuTK;
	private JMenu menuDNTK;
	private JPanel jpTitle;
	private JLabel jlTitle;
	private JTable table_nhanvien;
	private DefaultTableModel model_tableNV;
	private JTextField txtMa, txtTen, txtDiaChi, txtSdt,txtMaTim, txtNgaySinh, txtNgayVaoLam, txtLuong;
	private JRadioButton nam,nu;
	private ButtonGroup group;
	private JButton btnTim, btnXoa, btnXoarong, btnThem, btnLuu, btnSua;
	
	public frm_quanLyNhanVien() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Phần center
		jpCen = new JPanel();
		jpCen.add(Box.createHorizontalGlue());
		jpCen.setBackground(Color.gray);

//		Menu
		menubar = new JMenuBar();
		menubar.setBackground(new Color(163, 184, 204));
		menubar.setLayout(new BoxLayout(menubar, BoxLayout.X_AXIS));
		setJMenuBar(menubar);

		menuNV = new JMenu("Nhân Viên");
		menuNV.setForeground(Color.WHITE);
		menuNV.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		menuNV.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		menuNV.setIcon(new ImageIcon(getClass().getResource("/image/NV.png")));
		menubar.add(menuNV);
		
		menuKH = new JMenu("Khách Hàng");
		menuKH.setForeground(Color.WHITE);
		menuKH.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		menuKH.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		menuKH.setIcon(new ImageIcon(getClass().getResource("/image/KH.png")));
		menubar.add(menuKH);
		
		menuSP = new JMenu("Sản Phẩm");
		menuSP.setForeground(Color.WHITE);
		menuSP.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		menuSP.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		menuSP.setIcon(new ImageIcon(getClass().getResource("/image/SP.png")));
		menubar.add(menuSP);
		
		menuDM = new JMenu("Danh Mục");
		menuDM.setForeground(Color.WHITE);
		menuDM.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		menuDM.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		menuDM.setIcon(new ImageIcon(getClass().getResource("/image/DM.png")));
		menubar.add(menuDM);
		
		menuHD = new JMenu("Hóa Đơn");
		menuHD.setForeground(Color.WHITE);
		menuHD.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		menuHD.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		menuHD.setIcon(new ImageIcon(getClass().getResource("/image/HD.png")));
		menubar.add(menuHD);
		
		menuTK = new JMenu("Thống Kê");
		menuTK.setForeground(Color.WHITE);
		menuTK.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		menuTK.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		menuTK.setIcon(new ImageIcon(getClass().getResource("/image/TK.png")));
		menubar.add(menuTK);
		
		
		menubar.add(Box.createHorizontalStrut(680));
		
		menuDNTK = new JMenu("Đăng Nhập");
		menuDNTK.setForeground(Color.WHITE);
		menuDNTK.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		menuDNTK.setIcon(new ImageIcon(getClass().getResource("/image/ICONTK.png")));
		menubar.add(menuDNTK);

		
		jpTitle = new JPanel();
		jpTitle.setBackground(null);
//		jpTitle.setBorder(BorderFactory.createLineBorder(Color.white));
		jpTitle.setPreferredSize(new Dimension(1000, 60));
		jlTitle = new JLabel("Cửa Hàng Tiện lợi");
		Font fn = new Font("Times New Roman", Font.BOLD + Font.ITALIC, 50);
		jlTitle.setFont(fn);
		jlTitle.setForeground(Color.WHITE);
		jpTitle.add(jlTitle);
		jpCen.add(jpTitle);
				

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
		String[] cells = {"Mã nhân viên", "Tên nhân viên", "Phái", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Ngày vào làm", "Lương"};
		model_tableNV = new DefaultTableModel(cells,0);
		table_nhanvien = new JTable(model_tableNV);
		JScrollPane scroll = new JScrollPane(table_nhanvien);
		scroll.setPreferredSize(new Dimension(1000,500));
		jpCen.add(scroll);
		add(jpCen, BorderLayout.CENTER);
		

		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new frm_quanLyNhanVien();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
