package frm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import controller.ConnectDB;
import controller.readDataSP;
import controller.writeDataSP;
import dao.dsSanPham;
import entity.SanPham;

public class frm_SanPham extends frm_default implements ActionListener, MouseListener {
	private dsSanPham dsSp = new dsSanPham();
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
	private JLabel jlkgia;
	private JLabel jlkTT;
	private JLabel jlkpl;
	private JLabel jlkXX;
	private JLabel jlkDG;
	private JLabel jlkSL;
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
	private JLabel imgksp;
	private JPanel bkhungtt;
	private JButton jbtTim;
	private JTextField jtfTim;
	private JPanel b21;
	private JPanel b11;
	private JRadioButton jrbSLTang;
	private JRadioButton jrbSLGiam;
	private JComboBox<String> jcbLocXX;
	private JComboBox<String> jcbLocTH;
	private JPanel b211;
	private JPanel b212;
	private JPanel b213;
	private ButtonGroup groupSL;
	private ButtonGroup groupDG;
	private JComboBox<String> jcboxSapxep;
	private JRadioButton jrbBehon;
	private JRadioButton jrbLonhon;
	private JCheckBox jcbDG;
	private JCheckBox jcbSL;
	private JLabel jlNhapSo;
	private JTextField jtfNhapSo;
	private Box b2131;
	private Box b2132;
	private Box b2133;
	private static String maTK_login = login_page.getMaTK_login();

	public frm_SanPham() {
		super(maTK_login);
		jlTitle.setText("Quản Lý Sản Phẩm");
		jpCen.setLayout(new BorderLayout());
		jpCen.add(jlTitle, BorderLayout.NORTH);
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
		jbTT1.setLayout(new GridLayout(3, 1, 0, 5));
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		jbTT1.add(b1);

		jbTT1.add(b2);

		jbTT1.add(b3);

		Font f1 = new Font("Times New Roman", ABORT, 15);

		jlMaSP = new JLabel("Mã Sản Phẩm: ");
		jlMaSP.setFont(f1);
		jlMaSP.setPreferredSize(new Dimension(100, 20));
		jlMaSP.setForeground(Color.white);
		jtfMaSP = new JTextField();
		jtfMaSP.setPreferredSize(new Dimension(120, 20));

		jlTenSP = new JLabel("Tên Sản Phẩm: ");
		jlTenSP.setFont(f1);
		jlTenSP.setPreferredSize(new Dimension(100, 20));
		jlTenSP.setForeground(Color.white);
		jtfTenSP = new JTextField();
		jtfTenSP.setPreferredSize(new Dimension(190, 20));

		jlLoaiSP = new JLabel("Loại Sản Phẩm: ");
		jlLoaiSP.setFont(f1);
		jlLoaiSP.setPreferredSize(new Dimension(100, 20));
		jlLoaiSP.setForeground(Color.white);
		jtfLoaiSP = new JTextField();
		jtfLoaiSP.setPreferredSize(new Dimension(190, 20));

		jlSoluong = new JLabel("Số Lương: ");
		jlSoluong.setFont(f1);
		jlSoluong.setPreferredSize(new Dimension(100, 20));
		jlSoluong.setForeground(Color.white);
		jtfSoluong = new JTextField();
		jtfSoluong.setPreferredSize(new Dimension(120, 20));

		jlXuatxu = new JLabel("Xuất Xứ: ");
		jlXuatxu.setFont(f1);
		jlXuatxu.setPreferredSize(new Dimension(100, 20));
		jlXuatxu.setForeground(Color.white);
		jtXuatxu = new JTextField();
		jtXuatxu.setPreferredSize(new Dimension(120, 20));

		jlThuonghieu = new JLabel("Thương Hiệu: ");
		jlThuonghieu.setFont(f1);
		jlThuonghieu.setPreferredSize(new Dimension(100, 20));
		jlThuonghieu.setForeground(Color.white);
		jtfThuonghieu = new JTextField();
		jtfThuonghieu.setPreferredSize(new Dimension(190, 20));

		jlMota = new JLabel("Mô Tả: ");
		jlMota.setFont(f1);
		jlMota.setPreferredSize(new Dimension(100, 20));
		jlMota.setForeground(Color.white);
		jtfMota = new JTextField();
		jtfMota.setPreferredSize(new Dimension(190, 20));

		jlNhasx = new JLabel("Nhà Sản Xuất: ");
		jlNhasx.setFont(f1);
		jlNhasx.setPreferredSize(new Dimension(100, 20));
		jlNhasx.setForeground(Color.white);
		jtfNhasx = new JTextField();
		jtfNhasx.setPreferredSize(new Dimension(190, 20));

		jlDongia = new JLabel("Đơn giá: ");
		jlDongia.setFont(f1);
		jlDongia.setPreferredSize(new Dimension(100, 20));
		jlDongia.setForeground(Color.white);
		jtfDongia = new JTextField();
		jtfDongia.setPreferredSize(new Dimension(120, 20));

		b1.add(jlMaSP);
		b1.add(jtfMaSP);
		b1.add(Box.createHorizontalStrut(70));
		b1.add(jlTenSP);
		b1.add(jtfTenSP);
		b1.add(jlLoaiSP);
		b1.add(jtfLoaiSP);

		b2.add(jlSoluong);
		b2.add(jtfSoluong);
		b2.add(Box.createHorizontalStrut(70));
		b2.add(jlXuatxu);
		b2.add(jtXuatxu);
		b2.add(Box.createHorizontalStrut(70));
		b2.add(jlThuonghieu);
		b2.add(jtfThuonghieu);

		b3.add(jlMota);
		b3.add(jtfMota);
		b3.add(jlNhasx);
		b3.add(jtfNhasx);
		b3.add(jlDongia);
		b3.add(jtfDongia);
		b3.add(Box.createHorizontalStrut(70));

		jbTT2 = new JPanel();
		jbTT2.setBackground(Color.gray);
		jbTT2.setLayout(new BorderLayout());

		b11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		b11.setBackground(Color.gray);

		b21 = new JPanel(new GridLayout(1, 3, 5, 5));
		b21.setBackground(Color.gray);
		b211 = new JPanel(new BorderLayout());
		b211.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Sắp Xếp", 0, 0,
				fnTitle, Color.white));
		b212 = new JPanel(new GridLayout(2, 1, 5, 5));
		b212.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white),
				"Lọc Thương Hiệu - Xuất Xứ", 0, 0, fnTitle, Color.white));
		b213 = new JPanel(new BorderLayout());
		b213.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white),
				"Lọc Số Lượng - Đơn Giá", 0, 0, fnTitle, Color.white));

		b211.setBackground(Color.gray);
		b212.setBackground(Color.gray);
		b213.setBackground(Color.gray);

		b2131 = Box.createHorizontalBox();
		b2132 = Box.createHorizontalBox();
		b2133 = Box.createHorizontalBox();

		jbtTim = new JButton("Tìm Kiếm Theo Mã");
		jbtTim.setPreferredSize(new Dimension(150, 25));
		jtfTim = new JTextField();
		jtfTim.setPreferredSize(new Dimension(400, 25));

		b11.add(jbtTim);
		b11.add(jtfTim);

		String[] jcbSapxep = { "", "Số Lượng", "Đơn Giá", };
		jcboxSapxep = new JComboBox<String>(jcbSapxep);
		jcboxSapxep.setPreferredSize(new Dimension(100, 25));

		jrbSLTang = new JRadioButton("Tăng");
		jrbSLTang.setForeground(Color.white);
		jrbSLTang.setBackground(Color.gray);
		jrbSLGiam = new JRadioButton("Giảm");
		jrbSLGiam.setBackground(Color.gray);
		jrbSLGiam.setForeground(Color.white);
		groupSL = new ButtonGroup();
		groupSL.add(jrbSLTang);
		groupSL.add(jrbSLGiam);

		String[] jcbXuatxu = { "Xuất xứ", "Việt Nam", };
		jcbLocXX = new JComboBox<String>(jcbXuatxu);
		layDataJCBox(jcbLocXX, "SanPham", "xuatXu");

		String[] jcbThuonghieu = { "Thương Hiệu", };
		jcbLocTH = new JComboBox<String>(jcbThuonghieu);
		layDataJCBox(jcbLocTH, "SanPham", "thuongHieu");

		jcbSL = new JCheckBox("Số Lượng");
		jcbSL.setBackground(Color.gray);
		jcbSL.setForeground(Color.white);
		jcbDG = new JCheckBox("Đơn Giá");
		jcbDG.setBackground(Color.gray);
		jcbDG.setForeground(Color.white);

		jlNhapSo = new JLabel("Nhập Số:      ");
		jlNhapSo.setForeground(Color.white);
		jtfNhapSo = new JTextField();

		jrbLonhon = new JRadioButton("Lớn Hơn");
		jrbLonhon.setBackground(Color.gray);
		jrbLonhon.setForeground(Color.white);
		jrbBehon = new JRadioButton("Bé Hơn");
		jrbBehon.setForeground(Color.white);
		jrbBehon.setBackground(Color.gray);
		groupDG = new ButtonGroup();
		groupDG.add(jrbLonhon);
		groupDG.add(jrbBehon);

		b211.add(jcboxSapxep, BorderLayout.NORTH);
		b211.add(jrbSLTang, BorderLayout.CENTER);
		b211.add(jrbSLGiam, BorderLayout.EAST);

		b212.add(jcbLocXX);
		b212.add(jcbLocTH);

		b2131.add(jcbSL);
		b2131.add(jcbDG);

		b2132.add(jlNhapSo);
		b2132.add(jtfNhapSo);

		b2133.add(jrbLonhon);
		b2133.add(jrbBehon);

		b213.add(b2131, BorderLayout.NORTH);
		b213.add(b2132, BorderLayout.CENTER);
		b213.add(b2133, BorderLayout.SOUTH);

		b21.add(b211);
		b21.add(b212);
		b21.add(b213);

		jbTT2.add(b11, BorderLayout.NORTH);
		jbTT2.add(b21, BorderLayout.CENTER);

		split.add(jbTT1);
		split.add(jbTT2);

		bTT.add(split, BorderLayout.CENTER);

		bBTN = new JPanel();
		bBTN.setLayout(new BorderLayout());
		bBTN.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Các tùy chọn", 0,
				0, fnTitle, Color.white));
		bBTN.setBackground(Color.gray);

		bBTNno = new JPanel();
		bBTNno.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white),
				"Hiện Thị Sản Phẩm", 0, 0, fnTitle, Color.white));
		bBTNno.setBackground(Color.gray);
		bBTNno.setLayout(new BorderLayout());

		jpkimg = new JPanel();
		jpkimg.setLayout(new BorderLayout());
		jpkimg.setPreferredSize(new Dimension(150, 150));

		imgksp = new JLabel("");
		jpkimg.add(imgksp, BorderLayout.CENTER);

		bkhungtt = new JPanel();
		bkhungtt.setLayout(new GridLayout(6, 3));
		jlkten = new JLabel("Tên: ");
		jlkten.setPreferredSize(new Dimension(50, 20));
		jlkten.setFont(f1);
		jlkten.setForeground(Color.white);

		jlkgia = new JLabel("Giá: ");
		jlkgia.setPreferredSize(new Dimension(50, 20));
		jlkgia.setFont(f1);
		jlkgia.setForeground(Color.white);

		jlkTT = new JLabel("Thương Hiệu: ");
		jlkTT.setPreferredSize(new Dimension(50, 20));
		jlkTT.setFont(f1);
		jlkTT.setForeground(Color.white);

		jlkXX = new JLabel("Xuất Xứ: ");
		jlkXX.setPreferredSize(new Dimension(50, 20));
		jlkXX.setFont(f1);
		jlkXX.setForeground(Color.white);

		jlkpl = new JLabel("phân Loại: ");
		jlkpl.setPreferredSize(new Dimension(50, 20));
		jlkpl.setFont(f1);
		jlkpl.setForeground(Color.white);

		jlkSL = new JLabel("Số Lượng: ");
		jlkSL.setPreferredSize(new Dimension(50, 20));
		jlkSL.setFont(f1);
		jlkSL.setForeground(Color.white);

		bkhungtt.setBackground(Color.gray);
		bkhungtt.add(jlkten);
		bkhungtt.add(jlkgia);
		bkhungtt.add(jlkTT);
		bkhungtt.add(jlkXX);
		bkhungtt.add(jlkpl);
		bkhungtt.add(jlkSL);
		bBTNno.add(jpkimg, BorderLayout.NORTH);
		bBTNno.add(bkhungtt, BorderLayout.CENTER);

		bBTN.add(bBTNno, BorderLayout.NORTH);

		bBTNcen = new JPanel();
		bBTNcen.setLayout(new GridLayout(4, 2, 5, 5));
		bBTNcen.setBackground(Color.GRAY);

		bBTNso = new JPanel();
		bBTNso.setLayout(new GridLayout(2, 1, 0, 5));
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
		jbtnQL = new JButton("Bán Hàng");
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

		bBTN.add(bBTNso, BorderLayout.SOUTH);
		bBTN.add(bBTNcen, BorderLayout.CENTER);

		bDSSP = new JPanel();
		bDSSP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white),
				"Danh sách sản phẩm", 0, 0, fnTitle, Color.white));
		bDSSP.setBackground(Color.gray);

		String[] colNames = { "MÃ Sản Phẩm", "Tên Sản Phẩm", "Loại Sản Phẩm", "Số Lượng", "Xuất xứ", "Thương Hiệu",
				"Mô Tả", "Nhà Sản Xuất", "Đơn Giá" };
		model = new DefaultTableModel(colNames, 0);

		table = new JTable(model);

		hienTable(dsSp);
		table.addMouseListener(this);
		JScrollPane jscroll = new JScrollPane(table);

		bDSSP.setLayout(new BorderLayout());
		bDSSP.add(jscroll);

		bCen.add(bTT, BorderLayout.NORTH);
		bCen.add(bBTN, BorderLayout.EAST);
		bCen.add(bDSSP, BorderLayout.CENTER);
		jpCen.add(bCen, BorderLayout.CENTER);

		jbtnQL.addActionListener(this);
		jbtnThem.addActionListener(this);
		jbtnSua.addActionListener(this);
		jbtnXoa.addActionListener(this);
		jbtnXoarong.addActionListener(this);
		jbtnChiTiec.addActionListener(this);
		jbtnThoat.addActionListener(this);
		jbtnLuu.addActionListener(this);
		jbtTim.addActionListener(this);
		jcboxSapxep.addActionListener(this);
		jrbSLTang.addActionListener(this);
		jrbSLGiam.addActionListener(this);
		jcbLocXX.addActionListener(this);
		jcbLocTH.addActionListener(this);
		jcbSL.addActionListener(this);
		jcbDG.addActionListener(this);
		jrbLonhon.addActionListener(this);
		jrbBehon.addActionListener(this);

		setVisible(true);
	}

	public static void main(String[] args) {
		frm_SanPham frmsp = new frm_SanPham();
	}

	void hienTable(dsSanPham dsSP) {
		readDataSP rdbsp = new readDataSP(dsSP);
		for (int i = 0; i <= dsSP.soLuongSP() - 1; i++) {
			String maSp = dsSP.returnSP(i).getMaSP().toString();
			String tenSp = dsSP.returnSP(i).getTenSp().toString();
			String loaiSP = dsSP.returnSP(i).getLoaiSP().toString();
			int soLuong = dsSP.returnSP(i).getSoLuong();
			String xuatXu = dsSP.returnSP(i).getXuatXu().toString();
			String thuongHieu = dsSP.returnSP(i).getThuongHieu().toString();
			String moTa = dsSP.returnSP(i).getMoTa().toString();
			String nhaSanXuat = dsSP.returnSP(i).getNhaSanXuat().toString();
			double donGia = dsSP.returnSP(i).getDonGia();

			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

			String[] row = { maSp, tenSp, loaiSP, soLuong + "", xuatXu, thuongHieu, moTa, nhaSanXuat,
					currencyFormatter.format(donGia) };
			model.addRow(row);
		}
	}

	void luu(dsSanPham dsSP) {
		for (int i = 0; i < dsSP.soLuongSP(); i++) {
			SanPham sanPham = dsSP.returnSP(i);

			boolean isInserted = writeDataSP.writeSP(sanPham);

		}
		JOptionPane.showMessageDialog(null, " Hoàn tất lưu danh sách sản phẩm");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    super.actionPerformed(e);
	    Object o = e.getSource();

	    String selected = (String) jcboxSapxep.getSelectedItem();
	    String selectedXuatXu = jcbLocXX.getSelectedItem().toString();
	    String selectedThuonghieu = jcbLocTH.getSelectedItem().toString();

	    // Thoát ứng dụng
	    if (o.equals(jbtnThoat)) {
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setVisible(false);
	        this.dispose();
	    } else if (o.equals(jbtnLuu)) {
	        luu(dsSp);
	    } else if (o.equals(jbtnThem)) {
	        them();
	    } else if (o.equals(jbtnQL)) {
	        new frm_BanHang();
	        this.dispose();
	    } else if (o.equals(jbtnChiTiec)) {
	        int row = table.getSelectedRow();
	        if (row != -1) {
	            String maSP = (table.getValueAt(row, 0) + "");
	            new frm_CTSP(maSP);
	        } else {
	            JOptionPane.showMessageDialog(null, "Chưa chọn Sản Phẩm");
	        }
	    } else if (o.equals(jbtnSua)) {
	        sua();
	    } else if (o.equals(jbtnXoa)) {
	        xoa();
	    } else if (o.equals(jbtnXoarong)) {
	        xoarong();
	    } else if (o.equals(jbtTim)) {
	        String masp = jtfTim.getText();
	        TimSPTheoMa(masp);
	    } else {
	        // Lọc theo Số Lượng
	        if ("Số Lượng".equals(selected)) {
	            if (jrbSLTang.isSelected()) {
	                sapxep("{CALL GetSanPhamSorted(?)}", "ASC");
	            } else if (jrbSLGiam.isSelected()) {
	                sapxep("{CALL GetSanPhamSorted(?)}", "DESC");
	            }
	        }

	        // Lọc theo Đơn Giá
	        if ("Đơn Giá".equals(selected)) {
	            if (jrbSLTang.isSelected()) {
	                sapxep("{CALL SapxepDonGia(?)}", "ASC");
	            } else if (jrbSLGiam.isSelected()) {
	                sapxep("{CALL SapxepDonGia(?)}", "DESC");
	            }
	        }

	        // Lọc theo Xuất Xứ và Thương Hiệu
	        if (!selectedXuatXu.equals("xuatXu")) {
	            locXuatxu("{CALL sp_LocSanPhamTheoXuatXu(?)}", selectedXuatXu);
	            if (!selectedThuonghieu.equals("thuongHieu")) {
	                locXuatxu("{CALL sp_LocSanPhamTheoThuonghieu(?)}", selectedThuonghieu);
	            }
	        }

	        // Lọc theo Số Lượng
	        if (jcbSL.isSelected()) {
	            String input = jtfNhapSo.getText().trim();
	            if (!input.isEmpty()) {
	                try {
	                    int soluong = Integer.parseInt(input);
	                    if (jrbLonhon.isSelected()) {
	                        locSoLuong("{CALL sp_LocSanPhamTheoSoLuong(?, ?)}", soluong, 1);
	                    } else if (jrbBehon.isSelected()) {
	                        locSoLuong("{CALL sp_LocSanPhamTheoSoLuong(?, ?)}", soluong, 2);
	                    }
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Vui lòng nhập một số hợp lệ cho số lượng.");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng.");
	            }
	        }
	        if (jcbDG.isSelected()) {
	            String input = jtfNhapSo.getText().trim();
	            if (!input.isEmpty()) {
	                try {
	                    int soluong = Integer.parseInt(input);
	                    if (jrbLonhon.isSelected()) {
	                        locSoLuong("{CALL sp_LocSanPhamTheoDonGia(?, ?)}", soluong, 1);
	                    } else if (jrbBehon.isSelected()) {
	                        locSoLuong("{CALL sp_LocSanPhamTheoDonGia(?, ?)}", soluong, 2);
	                    }
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Vui lòng nhập một số hợp lệ cho số lượng.");
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng.");
	            }
	        }

	        // Hiển thị tất cả nếu không có bộ lọc nào
	        if (selectedXuatXu.equals("xuatXu") && selectedThuonghieu.equals("thuongHieu") && "".equals(selected)&&!jcbDG.isSelected()&&!jcbSL.isSelected()) {
	            model.setRowCount(0);
	            hienTable(dsSp);
	        }
	    }
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();

		jtfMaSP.setText(table.getValueAt(row, 0).toString());
		jtfTenSP.setText(table.getValueAt(row, 1).toString());
		jtfLoaiSP.setText(table.getValueAt(row, 2).toString());
		jtfSoluong.setText(table.getValueAt(row, 3).toString());
		jtXuatxu.setText(table.getValueAt(row, 4).toString());
		jtfThuonghieu.setText(table.getValueAt(row, 5).toString());
		jtfMota.setText(table.getValueAt(row, 6).toString());
		jtfNhasx.setText(table.getValueAt(row, 7).toString());

		String giaStr = table.getValueAt(row, 8).toString();
		giaStr = giaStr.replaceAll("[^\\d]", "");
		jtfDongia.setText(giaStr);

		jlkten.setText("Tên: " + table.getValueAt(row, 1) + "");
		jlkgia.setText("Giá: " + table.getValueAt(row, 8) + "");
		jlkTT.setText("Thương Hiệu: " + table.getValueAt(row, 5) + "");
		jlkXX.setText("Xuất Xứ: " + table.getValueAt(row, 4) + "");
		jlkpl.setText("phân Loại: " + table.getValueAt(row, 2) + "");
		jlkSL.setText("Số Lượng: " + table.getValueAt(row, 3) + "");

		;

		try {
			ImageIcon imageIcon = new ImageIcon(
					getClass().getResource("/image/imgSP/" + table.getValueAt(row, 0) + "" + ".png"));
			Image img = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_REPLICATE);

			imgksp.setIcon(new ImageIcon(img));
		} catch (Exception e5) {
			imgksp.setBorder(BorderFactory.createLineBorder(Color.green));
			jpkimg.revalidate();
			jpkimg.repaint();
			imgksp.setText("Không tìm thấy ảnh");
			imgksp.setHorizontalAlignment(JLabel.CENTER);
		}

	}

	void xoarong() {
		jtfMaSP.setText("");
		jtfTenSP.setText("");
		jtfLoaiSP.setText("");
		jtfSoluong.setText("");
		jtXuatxu.setText("");
		jtfThuonghieu.setText("");
		jtfMota.setText("");
		jtfNhasx.setText("");
		jtfDongia.setText("");

		jtfTim.setText("");
		jcboxSapxep.setSelectedIndex(0);
		jcbLocTH.setSelectedIndex(0);
		jcbLocXX.setSelectedIndex(0);

		groupDG.clearSelection();
		groupSL.clearSelection();

		jcbDG.setSelected(false);
		jcbSL.setSelected(false);
		table.clearSelection();
	}

	void them() {
		String maSP = jtfMaSP.getText();

		if (!maSP.matches("SP\\d{4}")) {
			JOptionPane.showMessageDialog(null, "Mã Sản Phẩm phải có định dạng 'SP' và theo sau là 4 chữ số!");
			return;
		}

		String tenSp = jtfTenSP.getText();
		String loaiSP = jtfLoaiSP.getText();
		int soLuong = Integer.parseInt(jtfSoluong.getText().toString());
		String xuatXu = jtXuatxu.getText();
		String thuongHieu = jtfThuonghieu.getText();
		String moTa = jtfMota.getText();
		String nhaSanXuat = jtfNhasx.getText();
		double donGia = Double.parseDouble(jtfDongia.getText().toString());

		SanPham s1 = new SanPham(maSP, tenSp, loaiSP, soLuong, xuatXu, thuongHieu, moTa, nhaSanXuat, donGia);
		if (dsSp.themSP(s1)) {
			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
			String[] row = { maSP, tenSp, loaiSP, soLuong + "", xuatXu, thuongHieu, moTa, nhaSanXuat,
					currencyFormatter.format(donGia) };
			model.addRow(row);
			table.show(true);
		} else {
			JOptionPane.showMessageDialog(null, "Mã Sản Phẩm Đã Tồn Tại");
		}
	}

	void xoa() {
		int row = table.getSelectedRow();
		String maSP = (table.getValueAt(row, 0) + "");

		if (table.getSelectedRow() != -1) {

//			int hoinhac = JOptionPane.showConfirmDialog(this, JOptionPane.YES_NO_OPTION,)

			if (dsSp.xoaSP(maSP)) {
				xoaSQL("{CALL sp_XoaSanPhamTheoMa(?)}", maSP);
				model.removeRow(row);
				table.show();

				// xóa dữ liệu hiển thị
				jtfMaSP.setText("");
				jtfTenSP.setText("");
				jtfLoaiSP.setText("");
				jtfSoluong.setText("");
				jtXuatxu.setText("");
				jtfThuonghieu.setText("");
				jtfMota.setText("");
				jtfNhasx.setText("");
				jtfDongia.setText("");

				table.clearSelection();
				jlkten.setText("Tên: " + "");
				jlkgia.setText("Giá: " + "");
				jlkTT.setText("Thương Hiệu: " + "");
				jlkXX.setText("Xuất Xứ: " + "");
				jlkpl.setText("phân Loại: " + "");
				jlkSL.setText("Số Lượng: " + "");

				imgksp.setIcon(new ImageIcon());
				imgksp.setBorder(BorderFactory.createLineBorder(Color.red));
				jpkimg.revalidate();
				jpkimg.repaint();
			} else {
				JOptionPane.showMessageDialog(null, "KHÔNG TÌM THẤY SẢN PHẢM CẦN XÓA");
			}
		} else {
			JOptionPane.showMessageDialog(null, "BẠN CHƯA CHỌN SẢN PHẨM ĐỂ XÓA");
		}

	}

	void sua() {

		int row = table.getSelectedRow();

		if (row != -1) {
			String maSP = jtfMaSP.getText();
			String tenSp = jtfTenSP.getText();
			String loaiSP = jtfLoaiSP.getText();
			int soLuong = Integer.parseInt(jtfSoluong.getText().toString());
			String xuatXu = jtXuatxu.getText();
			String thuongHieu = jtfThuonghieu.getText();
			String moTa = jtfMota.getText();
			String nhaSanXuat = jtfNhasx.getText();
			double donGia = Double.parseDouble(jtfDongia.getText().toString());
			SanPham spNew = new SanPham(maSP, tenSp, loaiSP, soLuong, xuatXu, thuongHieu, moTa, nhaSanXuat, donGia);
			if (dsSp.sua(maSP, spNew)) {
				model.setValueAt(maSP, row, 0);
				model.setValueAt(tenSp, row, 1);
				model.setValueAt(loaiSP, row, 2);
				model.setValueAt(soLuong, row, 3);
				model.setValueAt(xuatXu, row, 4);
				model.setValueAt(thuongHieu, row, 5);
				model.setValueAt(moTa, row, 6);
				model.setValueAt(nhaSanXuat, row, 7);
				model.setValueAt(donGia, row, 8);
			} else {
				JOptionPane.showMessageDialog(null, "KHÔNG TÌM THẤY MÃ SẢN PHẨM SỬA");
			}

		}

	}

	void TimSPTheoMa(String maSP) {
		SanPham sp = dsSp.TimSP(maSP);

		if (sp != null) {

			String maSP1 = sp.getMaSP();
			String tenSp = sp.getTenSp();
			String loaiSP = sp.getLoaiSP();
			int soLuong = sp.getSoLuong();
			String xuatXu = sp.getXuatXu();
			String thuongHieu = sp.getThuongHieu();
			String moTa = sp.getMoTa();
			String nhaSanXuat = sp.getNhaSanXuat();
			double donGia = sp.getDonGia();
			model.setRowCount(0);
			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
			String[] row = { maSP1, tenSp, loaiSP, String.valueOf(soLuong), xuatXu, thuongHieu, moTa, nhaSanXuat,
					currencyFormatter.format(donGia) };
			model.addRow(row);

		} else {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã: " + maSP);
		}
	}

	void sapxep(String callStore, String tangGiam) {
//		String storedProcedureCall = "{CALL GetSanPhamSorted(?)}";
		String storedProcedureCall = callStore;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			CallableStatement callableStatement = con.prepareCall(storedProcedureCall);

			callableStatement.setString(1, tangGiam);

			ResultSet rs = callableStatement.executeQuery();
			model.setRowCount(0);
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSp = rs.getString(2);
				String loaiSP = rs.getString(3);
				int soLuong = Integer.parseInt(rs.getString(4));
				String xuatXu = rs.getString(5);
				String thuongHieu = rs.getString(6);
				String moTa = rs.getString(7);
				String nhaSanXuat = rs.getString(8);
				double donGia = Double.parseDouble(rs.getString(9));

				NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

				String[] row = { maSP, tenSp, loaiSP, soLuong + "", xuatXu, thuongHieu, moTa, nhaSanXuat,
						currencyFormatter.format(donGia) };
				model.addRow(row);
			}

			rs.close();
			callableStatement.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	void xoaSQL(String callStore, String maxoa) {
		String storedProcedureCall = callStore;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			CallableStatement callableStatement = con.prepareCall(storedProcedureCall);

			callableStatement.setString(1, maxoa);

			ResultSet rs = callableStatement.executeQuery();

			rs.close();
			callableStatement.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	void locXuatxu(String callStore, String xuatxu) {
		String storedProcedureCall = callStore;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			CallableStatement callableStatement = con.prepareCall(storedProcedureCall);

			callableStatement.setString(1, xuatxu);

			ResultSet rs = callableStatement.executeQuery();
			model.setRowCount(0);
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSp = rs.getString(2);
				String loaiSP = rs.getString(3);
				int soLuong = Integer.parseInt(rs.getString(4));
				String xuatXu = rs.getString(5);
				String thuongHieu = rs.getString(6);
				String moTa = rs.getString(7);
				String nhaSanXuat = rs.getString(8);
				double donGia = Double.parseDouble(rs.getString(9));

				NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

				String[] row = { maSP, tenSp, loaiSP, soLuong + "", xuatXu, thuongHieu, moTa, nhaSanXuat,
						currencyFormatter.format(donGia) };
				model.addRow(row);
			}

			rs.close();
			callableStatement.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	void locSoLuong(String callStore, int soLuong, int i) {
		String storedProcedureCall = callStore;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			CallableStatement callableStatement = con.prepareCall(storedProcedureCall);

			callableStatement.setInt(1, soLuong);
			callableStatement.setInt(2, i);

			ResultSet rs = callableStatement.executeQuery();
			model.setRowCount(0);
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSp = rs.getString(2);
				String loaiSP = rs.getString(3);
				int soLuong1 = Integer.parseInt(rs.getString(4));
				String xuatXu = rs.getString(5);
				String thuongHieu = rs.getString(6);
				String moTa = rs.getString(7);
				String nhaSanXuat = rs.getString(8);
				double donGia = Double.parseDouble(rs.getString(9));

				NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

				String[] row = { maSP, tenSp, loaiSP, soLuong1 + "", xuatXu, thuongHieu, moTa, nhaSanXuat,
						currencyFormatter.format(donGia) };
				model.addRow(row);
			}

			rs.close();
			callableStatement.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void layDataJCBox(JComboBox<String> jcbBox, String namebang, String namecol) {
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT DISTINCT [" + namecol + "]" + "[" + namecol + "]" + "FROM [QLStore].[dbo].[" + namebang
					+ "]";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			jcbBox.removeAllItems();
			jcbBox.addItem(namecol);
			while (rs.next()) {
				String add = rs.getString(namecol);
				jcbBox.addItem(add);
			}

			rs.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
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

}
