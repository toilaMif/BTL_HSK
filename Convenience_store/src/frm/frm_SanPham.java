package frm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.ScrollPane;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class frm_SanPham extends frm_default {

	private JPanel bBTN;
	private JPanel bDSSP;
	private JPanel bTT;
	private JPanel bCen;
	private JButton jbtnQL;
	private JButton jbtnThem;
	private JButton jbtnXoa;
	private JButton jbtnLuu;
	private JButton jbtnThoat;
	private JButton jbtnChiTiec;
	private JButton jbtnSua;
	private JPanel bBTNso;
	private JPanel bBTNcen;
	private JPanel bBTNno;
	private JPanel jpkimg;
	private JLabel jlkten;
	private Component jlkgia;
	private Component jlkTT;
	private JLabel jlkpl;
	private JLabel jlkXX;
	private JLabel jlkDG;
	private Component jlkSL;
	private JPanel a1;
	private JPanel a;
	private JPanel a4;
	private JPanel a3;
	private JPanel jbTT2;
	private JPanel jbTT1;
	private JLabel jlMaSP;
	private JTextField jtfMaSP;
	private JLabel jlTenSP;
	private JTextField jtfTenSP;
	private JLabel jlLoaiSP;
	private JLabel jlSoluong;
	private JTextField jtfLoaiSP;
	private JLabel jlXuatxu;
	private JTextField jtfSoluong;
	private JLabel jlThuonghieu;
	private JTextField jtfMota;
	private JLabel jlDongia;
	private JTextField jtfDongia;
	private JTextField jtfNhasx;
	private JLabel jlNhasx;
	private JLabel jlMota;
	private JTextField jtfThuonghieu;
	private JTextField jtXuatxu;
	private JButton jbtnXoarong;
	private DefaultTableModel model;
	private JTable table;
	private Box b1;
	private Box b3;
	private Box b2;
	

	public frm_SanPham() {
		super();
		jlTitle.setText("Quản Lý Sản Phẩm");
		jpCen.setLayout(new BorderLayout());
		jpCen.add(jlTitle,BorderLayout.NORTH);
		Font fnTitle = new Font("Times New Roman", Font.BOLD + Font.ITALIC + Font.CENTER_BASELINE, 15);
		
		bCen = new JPanel();
		
		
		bCen.setLayout(new BorderLayout());
		bTT = new JPanel();
		bTT.setLayout(new BorderLayout());
		bTT.setBackground(Color.gray);
		bTT.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white),
		"Thông Tin Sản Phẩm", 0, 0, fnTitle, Color.white));
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		jbTT1 = new JPanel();
		jbTT1.setBackground(Color.gray);
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		jbTT1.add(b1);
		jbTT1.add(Box.createVerticalGlue());
		jbTT1.add(b2);
		jbTT1.add(Box.createVerticalGlue());
		jbTT1.add(b3);
		
		
		Font f1 = new Font("Times New Roman", ABORT, 15);
		
		jlMaSP = new JLabel("Mã Sản Phẩm: ");
		jlMaSP.setFont(f1);
		jlMaSP.setPreferredSize(new Dimension(100, 20));
		jlMaSP.setForeground(Color.white);
		jtfMaSP = new JTextField();
		jtfMaSP.setPreferredSize(new Dimension(150, 20));
		
		
		
		jlTenSP = new JLabel("Tên Sản Phẩm: ");
		jlTenSP.setFont(f1);
		jlTenSP.setPreferredSize(new Dimension(100, 20));
		jlTenSP.setForeground(Color.white);
		jtfTenSP = new JTextField();
		jtfTenSP.setPreferredSize(new Dimension(150, 20));
		
		jlLoaiSP = new JLabel("Loại Sản Phẩm: ");
		jlLoaiSP.setFont(f1);
		jlLoaiSP.setPreferredSize(new Dimension(100, 20));
		jlLoaiSP.setForeground(Color.white);
		jtfLoaiSP = new JTextField();
		jtfLoaiSP.setPreferredSize(new Dimension(150, 20));
		
		jlSoluong = new JLabel("Số Lương: ");
		jlSoluong.setFont(f1);
		jlSoluong.setForeground(Color.white);
		jtfSoluong = new JTextField();
		
		jlXuatxu = new JLabel("Xuất Xứ: ");
		jlXuatxu.setFont(f1);
		jlXuatxu.setForeground(Color.white);
		jtXuatxu = new JTextField();
		
		jlThuonghieu = new JLabel("Thương Hiệu: ");
		jlThuonghieu.setFont(f1);
		jlThuonghieu.setForeground(Color.white);
		jtfThuonghieu = new JTextField();
		
		jlMota = new JLabel("Mô Tả: ");
		jlMota.setFont(f1);
		jlMota.setForeground(Color.white);
		jtfMota = new JTextField();
		
		jlNhasx = new JLabel("Nhà Sản Xuất: ");
		jlNhasx.setFont(f1);
		jlNhasx.setForeground(Color.white);
		jtfNhasx = new JTextField();
		
		jlDongia = new JLabel("Đơn giá: ");
		jlDongia.setFont(f1);
		jlDongia.setForeground(Color.white);
		jtfDongia = new JTextField();
		
		b1.add(jlMaSP);
		b1.add(jtfMaSP);
		b1.add(jlTenSP);
		b1.add(jtfTenSP);
		b1.add(jlLoaiSP);
		b1.add(jtfLoaiSP);
		
		b2.add(jlSoluong);
		b2.add(jtfSoluong);
		b2.add(jlXuatxu);
		b2.add(jtXuatxu);
		b2.add(jlThuonghieu);
		b2.add(jtfThuonghieu);
//		
//		jbTT1.add(jlMota);
//		jbTT1.add(jtfMota);
//		jbTT1.add(jlNhasx);
//		jbTT1.add(jtfNhasx);
//		jbTT1.add(jlDongia);
//		jbTT1.add(jtfDongia);
		
		
		jbTT2 = new JPanel();
		jbTT2.setBackground(Color.gray);
		
		
		split.add(jbTT1);
		split.add(jbTT2);
		
		bTT.add(split,BorderLayout.CENTER);
		
		bBTN = new JPanel();
		bBTN.setLayout(new BorderLayout());
		bBTN.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white),
				"Các tùy chọn", 0, 0, fnTitle, Color.white));
		bBTN.setBackground(Color.gray);
		
		bBTNno = new JPanel();
		bBTNno.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white),
				"Hiện Thị Sản Phẩm", 0, 0, fnTitle, Color.white));
		bBTNno.setBackground(Color.gray);
		bBTNno.setLayout(new BoxLayout(bBTNno, BoxLayout.Y_AXIS));
		jpkimg = new JPanel();
		jpkimg.setPreferredSize(new Dimension(150,150));
		
		jlkten = new JLabel("Tên: ");
		jlkten.setPreferredSize(new Dimension(50,20));
		
		jlkgia = new JLabel("Giá: ");
		jlkgia.setPreferredSize(new Dimension(50,20));
		
		jlkTT = new JLabel("Thương Hiệu: ");
		jlkTT.setPreferredSize(new Dimension(50,20));
		
		jlkXX = new JLabel("Xuất Xứ: ");
		jlkXX.setPreferredSize(new Dimension(50,20));
		
		jlkpl = new JLabel("phân Loại: ");
		jlkpl.setPreferredSize(new Dimension(50,20));
		
		jlkDG = new JLabel("Đơn Giá: ");
		jlkDG.setPreferredSize(new Dimension(50,20));
		
		jlkSL = new JLabel("Số Lượng: ");
		jlkSL.setPreferredSize(new Dimension(50,20));
		
		bBTNno.add(jpkimg);
		bBTNno.add(jlkten);
		bBTNno.add(jlkgia);
		bBTNno.add(jlkTT);
		bBTNno.add(jlkXX);
		bBTNno.add(jlkpl);
		bBTNno.add(jlkDG);
		bBTNno.add(jlkSL);
		
		bBTNno.add(jlkTT);
		bBTN.add(bBTNno,BorderLayout.NORTH);
		
		
		bBTNcen = new JPanel();
		bBTNcen.setLayout(new GridLayout(4,2,5,5));
		bBTNcen.setBackground(Color.GRAY);
		
		bBTNso = new JPanel();
		bBTNso.setLayout(new GridLayout(2,1,0,5));
		bBTNso.setBackground(Color.GRAY);
		
//		a =  new JPanel();
//		a1 =  new JPanel();
//		a3 =  new JPanel();
//		a4 =  new JPanel();
//		a.setBackground(Color.gray);
//		a1.setBackground(Color.gray);
//		a3.setBackground(Color.gray);
//		a4.setBackground(Color.gray);
//		bBTNcen.add(a);
//		bBTNcen.add(a1);
//		bBTNcen.add(a3);
//		bBTNcen.add(a4);
		jbtnQL = new JButton("Quản lý");
		jbtnQL.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		jbtnQL.setBackground(new Color(163, 184, 204));
		jbtnQL.setForeground(Color.white);
		
		bBTNcen.add(jbtnQL);
		
		jbtnChiTiec = new JButton("Chi Tiết");
		jbtnChiTiec.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		jbtnChiTiec.setBackground(new Color(163, 184, 204));
		jbtnChiTiec.setForeground(Color.white);
		
		bBTNcen.add(jbtnChiTiec);
		
		
		
		jbtnThem = new JButton("Thêm");
		jbtnThem.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		jbtnThem.setBackground(new Color(163, 184, 204));
		jbtnThem.setForeground(Color.white);
		bBTNcen.add(jbtnThem);
		
		jbtnSua = new JButton("Sửa");
		jbtnSua.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		jbtnSua.setBackground(new Color(163, 184, 204));
		jbtnSua.setForeground(Color.white);
		bBTNcen.add(jbtnSua);
		 
		jbtnXoa = new JButton("Xóa");
		jbtnXoa.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		jbtnXoa.setBackground(new Color(163, 184, 204));
		jbtnXoa.setForeground(Color.white);
		bBTNcen.add(jbtnXoa);
		
		jbtnXoarong = new JButton("Xóa Rỗng");
		jbtnXoarong.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		jbtnXoarong.setBackground(new Color(163, 184, 204));
		jbtnXoarong.setForeground(Color.white);
		bBTNcen.add(jbtnXoarong);
		
		
		jbtnLuu = new JButton("Lưu");
		jbtnLuu.setBackground(Color.green);
		jbtnLuu.setIcon(new ImageIcon(getClass().getResource("/image/luu.png")));
		bBTNso.add(jbtnLuu);
		
		jbtnThoat = new JButton("Thoát");
		jbtnThoat.setIcon(new ImageIcon(getClass().getResource("/image/thoat.png")));
		jbtnThoat.setBackground(Color.RED);
		bBTNso.add(jbtnThoat);
		
		bBTN.add(bBTNso,BorderLayout.SOUTH);
		bBTN.add(bBTNcen,BorderLayout.CENTER);
		
		bDSSP = new JPanel();
		bDSSP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white),
				"Danh sách sản phẩm", 0, 0, fnTitle, Color.white));
		bDSSP.setBackground(Color.gray);
		
		String[] colNames = { "MÃ Sản Phẩm", "Tên Sản Phẩm", "Loại Sản Phẩm", "Xuất xứ", "Thương Hiệu", "Mô Tả", "Nhà Sản Xuất", "Đơn Giá" };
		model = new DefaultTableModel(colNames, 0);
		
		
	
		table = new JTable(model);
		
		
		JScrollPane jscroll = new JScrollPane(table);
		
		model.addRow(colNames);
		
		
		
		bDSSP.setLayout(new BorderLayout());
		bDSSP.add(jscroll);
		
		bCen.add(bTT,BorderLayout.NORTH);
		bCen.add(bBTN,BorderLayout.EAST);
		bCen.add(bDSSP,BorderLayout.CENTER);
		jpCen.add(bCen, BorderLayout.CENTER);
		setVisible(true);
	}

	public static void main(String[] args) {
		frm_SanPham frmsp = new frm_SanPham();
	}

}
