package frm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import java.awt.*;

import javax.swing.table.DefaultTableModel;

import controller.ConnectDB;
import controller.readDataSP;
import dao.dsSanPham;
import entity.SanPham;

public class frm_BanHang extends frm_default implements ActionListener, MouseListener {
	private static String maTK_login = login_page.getMaTK_login();
	String maHd;
	private JPanel bTT;

	private JPanel jbTT1;
	private JPanel jbTT2;
	private JPanel bCen;
	private JPanel bBHD;
	private JPanel bDSSP;
	private JPanel jpHoaDon;
	private JLabel jlTitleHD;
	private JLabel jlNgayGio;
	private JLabel jlTNgayGio;
	private JLabel jlTmaHD;
	private DefaultTableModel modelHD;
	private JTable tableHD;
	private JLabel jlTongTienHD;
	private JLabel jlHTTTHD;
	private JComboBox<String> jcbHTTTHD;
	private JLabel jlThuNganHD;
	private JLabel jlCamonHD;
	private JLabel jlTenKHHD;
	private JButton jbtLuuHD;
	private JPanel boxHD1;
	private JPanel boxHD3;
	private JPanel boxHD2;
	private JPanel boxHD21;
	private JPanel boxbtn;
	private JButton jbtXoaRongHD;
	private JLabel jlThuNganHD1;
	private JPanel jpSP;
	private JButton jbtTimTen;
	private JTextField jtfTimTen;
	private JButton jbtTimMa;
	private JTextField jtfTimMa;
	private JRadioButton jrbGG50;
	private JRadioButton jrbGG75;
	private JRadioButton jrbGG25;
	private JLabel jlGiamGia;
	private ButtonGroup groupGG;
	private JPanel jpGG;
	private JLabel jlTenKH;
	private JTextField jtfTenKH;
	private JLabel jldateKH;
	private JRadioButton jrbKHNU;
	private JRadioButton jrbKHVip;
	private JRadioButton jrbKHThuong;
	private ButtonGroup jbGRKH;
	private JLabel jlMaSP;
	private JLabel jlTenSP;
	private JButton jbKHTIM;
	private JButton jbKHThem;
	private JPanel boxHD211;

	private dsSanPham dsSP = new dsSanPham();

	private JLabel imgksp;

	private JPanel boxHD2111;

	private JLabel imgQR;

	private JPanel panelContainer;
	private JSpinner dateSpinner;
	private JComboBox<String> jcboxDM;
	private double tongthanhtien = 0;

	public frm_BanHang() {
		super(maTK_login);
		jlTitle.setText("Bán Hàng");
		jpCen.setLayout(new BorderLayout());
		jpCen.add(jlTitle, BorderLayout.NORTH);

		Font fnTitle = new Font("Times New Roman", Font.BOLD + Font.ITALIC + Font.CENTER_BASELINE, 15);
		setVisible(true);

		bCen = new JPanel();

		bCen.setLayout(new BorderLayout());

		// NUT XU LY
		bTT = new JPanel();
		bTT.setLayout(new BorderLayout());
		bTT.setBackground(Color.gray);
		bTT.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Thông Tin", 0, 0,
				fnTitle, Color.white));

		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		// San Phap
		jbTT1 = new JPanel(new GridLayout(3, 1, 15, 15));
		jbTT1.setBackground(Color.gray);

		Box bTKSPTen = Box.createHorizontalBox();
		jbtTimTen = new JButton("Tìm Theo Tên");
		jtfTimTen = new JTextField(30);

		bTKSPTen.add(jbtTimTen);
		bTKSPTen.add(jtfTimTen);

		Box bTKSPMa = Box.createHorizontalBox();
		jbtTimMa = new JButton("Tìm Theo Mã ");
		jtfTimMa = new JTextField();

		bTKSPMa.add(jbtTimMa);
		bTKSPMa.add(jtfTimMa);

		Box bTKSPGG = Box.createHorizontalBox();

		String[] jcbSapxep = { "loaiSP", };
		jcboxDM = new JComboBox<String>(jcbSapxep);
		jcboxDM.setPreferredSize(new Dimension(100, 25));
		layDataJCBox(jcboxDM, "SanPham", "loaiSP");

		bTKSPGG.add(jcboxDM);

		jbTT1.add(bTKSPTen);
		jbTT1.add(bTKSPMa);
		jbTT1.add(bTKSPGG);

		// Khach Hang
		Box bKHTen = Box.createHorizontalBox();
		Box bKHDate = Box.createHorizontalBox();
		Box bKHLoai = Box.createHorizontalBox();
		jbTT2 = new JPanel(new GridLayout(3, 1, 5, 5));
		jbTT2.setBackground(Color.gray);

		jlTenKH = new JLabel("Tên KH: ");
		jlTenKH.setForeground(Color.white);
		jtfTenKH = new JTextField();

		bKHTen.add(jlTenKH);
		bKHTen.add(Box.createHorizontalStrut(50));
		bKHTen.add(jtfTenKH);

		jbTT2.add(bKHTen);

		jldateKH = new JLabel("Ngày sinh: ");
		jldateKH.setForeground(Color.white);

		// ngày sinh khách hàng
		SpinnerDateModel dateModel = new SpinnerDateModel();
		dateSpinner = new JSpinner(dateModel);
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
		dateSpinner.setEditor(dateEditor);

		Date selectedDate = (Date) dateSpinner.getValue();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        System.out.println(formatter.format(selectedDate));

		jrbKHNU = new JRadioButton("Nữ");
		jrbKHNU.setBackground(Color.gray);
		jrbKHNU.setForeground(Color.white);

		bKHDate.add(jldateKH);
		bKHDate.add(Box.createHorizontalStrut(37));
		bKHDate.add(dateSpinner);
		bKHDate.add(Box.createHorizontalStrut(10));
		bKHDate.add(jrbKHNU);
		jbTT2.add(bKHDate);

		jbGRKH = new ButtonGroup();

		jrbKHThuong = new JRadioButton("Thường");
		jrbKHThuong.setBackground(Color.gray);
		jrbKHThuong.setForeground(Color.white);

		jrbKHVip = new JRadioButton("VIP");
		jrbKHVip.setBackground(Color.gray);
		jrbKHVip.setForeground(Color.white);

		jbKHTIM = new JButton("Tìm");
		jbKHThem = new JButton("Thêm");

		jbGRKH.add(jrbKHThuong);
		jbGRKH.add(jrbKHVip);

		bKHLoai.add(Box.createHorizontalStrut(95));
		bKHLoai.add(jrbKHThuong);
		bKHLoai.add(jrbKHVip);
		bKHLoai.add(Box.createHorizontalStrut(25));
		bKHLoai.add(jbKHTIM);
		bKHLoai.add(Box.createHorizontalStrut(25));
		bKHLoai.add(jbKHThem);

		jbTT2.add(bKHLoai);

		split.add(jbTT1);
		split.add(jbTT2);

		bTT.add(split);

		// Hoa Don
		boxHD1 = new JPanel(new GridLayout(3, 1));
		boxHD2 = new JPanel(new BorderLayout());
		boxHD3 = new JPanel(new GridLayout(3, 1, 5, 5));

		boxHD21 = new JPanel(new BorderLayout());
		boxHD211 = new JPanel(new BorderLayout());

		bBHD = new JPanel();
		bBHD.setLayout(new BorderLayout());
		bBHD.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Hóa Đơn", 0, 0,
				fnTitle, Color.white));
		bBHD.setBackground(Color.gray);

		jpHoaDon = new JPanel();
		jpHoaDon.setLayout(new BorderLayout());
		jpHoaDon.setPreferredSize(new Dimension(300, 100));
		Font fnHD = new Font("Times New Roman", Font.BOLD + Font.CENTER_BASELINE, 25);

		JLabel jlTitleHD = new JLabel("Hóa Đơn Bán Hàng", SwingConstants.CENTER);
		jlTitleHD.setFont(fnHD);

		JLabel jlTNgayGio = new JLabel("Ngày Giờ", SwingConstants.CENTER);
		jlTNgayGio.setFont(new Font("Times New Roman", Font.BOLD + Font.CENTER_BASELINE, 16));

		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Timer timer = new Timer(1000, e -> {
			Date now = new Date();
			jlTNgayGio.setText(formatter1.format(now));
		});
		timer.start();

		jlTmaHD = new JLabel("Mã HĐ: ");
		maHd = "HD" + String.format("%03d", soHD() + 1);
		jlTmaHD.setText("Mã HD: " + maHd);
		boxHD1.add(jlTitleHD);
		boxHD1.add(jlTNgayGio);
		boxHD1.add(jlTmaHD);

		String[] Row = { "Tên Hàng", "SL", "Đơn Giá", "Thành Tiền" };

		modelHD = new DefaultTableModel(Row, 0);
		tableHD = new JTable(modelHD);
		tableHD.setShowGrid(false);

		JScrollPane jsc = new JScrollPane(tableHD);
		tableHD.addMouseListener(this);

		boxHD2.add(jsc, BorderLayout.CENTER);

		jlTongTienHD = new JLabel("Tổng Tiền: ");
		jlHTTTHD = new JLabel("HTTT: ");

		String[] HTTTHD = { "Tiền Mặt", "Ngân Hàng", "MOMO" };

		jcbHTTTHD = new JComboBox<String>(HTTTHD);
		jcbHTTTHD.addActionListener(this);
		jcbHTTTHD.setPreferredSize(new Dimension(150, 20));

		jlThuNganHD1 = new JLabel("Thu Ngân: " + menuDNTK.getText());

		jlCamonHD = new JLabel("Xin Cảm Ơn Quý Khách", SwingConstants.CENTER);
		jlCamonHD.setFont(new Font("Times New Roman", Font.BOLD + Font.CENTER_BASELINE, 16));
		jlTenKHHD = new JLabel("Tên KH", SwingConstants.CENTER);
		jlTenKHHD.setFont(new Font("ARIA", Font.BOLD + Font.CENTER_BASELINE, 10));

		boxHD2111 = new JPanel(new BorderLayout());
		imgQR = new JLabel();
		boxHD2111.add(jlTenKHHD, BorderLayout.CENTER);
		boxHD2111.add(imgQR, BorderLayout.SOUTH);

		boxHD211.add(jlThuNganHD1, BorderLayout.NORTH);
		boxHD211.add(jlCamonHD, BorderLayout.CENTER);
		boxHD211.add(boxHD2111, BorderLayout.SOUTH);

		boxbtn = new JPanel(new GridLayout(1, 2, 5, 5));
		jbtLuuHD = new JButton("Lưu");
		jbtXoaRongHD = new JButton("Xóa Rỗng");

		boxbtn.add(jbtLuuHD);
		boxbtn.add(jbtXoaRongHD);

		boxHD21.add(jlTongTienHD, BorderLayout.NORTH);
		boxHD21.add(jlHTTTHD, BorderLayout.CENTER);
		boxHD21.add(jcbHTTTHD, BorderLayout.EAST);
		boxHD21.add(boxHD211, BorderLayout.SOUTH);

		boxHD2.add(boxHD21, BorderLayout.SOUTH);

		jpHoaDon.add(boxHD1, BorderLayout.NORTH);
		jpHoaDon.add(boxHD2, BorderLayout.CENTER);
		jpHoaDon.add(boxHD3, BorderLayout.SOUTH);
		bBHD.add(jpHoaDon, BorderLayout.CENTER);
		bBHD.add(boxbtn, BorderLayout.SOUTH);

		bDSSP = new JPanel();
		bDSSP.setLayout(new BorderLayout());
		bDSSP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white),
				"Danh sách sản phẩm", 0, 0, fnTitle, Color.white));
		bDSSP.setBackground(Color.gray);

		// Thêm SP vào DS BÁN
		readDataSP rdbsp = new readDataSP(dsSP);
		JScrollPane jscSP = new JScrollPane();
		panelContainer = new JPanel();
		panelContainer.setBackground(Color.GRAY);
		panelContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
		panelContainer.setPreferredSize(new Dimension(150, 200 * dsSP.soLuongSP() / 5));

		HienThiSPBAN(dsSP, Color.RED);

		jscSP.setViewportView(panelContainer);
		jscSP.getVerticalScrollBar().setUnitIncrement(20);

		bDSSP.add(jscSP, BorderLayout.CENTER);

		bCen.add(bTT, BorderLayout.NORTH);
		jpCen.add(bBHD, BorderLayout.EAST);
		bCen.add(bDSSP, BorderLayout.CENTER);

		jpCen.add(bCen, BorderLayout.CENTER);

		jbKHTIM.addActionListener(this);
		jbKHThem.addActionListener(this);
		jbtLuuHD.addActionListener(this);
		jbtTimMa.addActionListener(this);
		jbtTimTen.addActionListener(this);
		jbtXoaRongHD.addActionListener(this);
		jcboxDM.addActionListener(this);
	}

	public static void main(String[] args) {
		new frm_BanHang();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JPanel clickedPanel = (JPanel) e.getSource();
		String maSp = clickedPanel.getName();
		ThemVaoHD(maSp);

	}

	void ThemVaoHD(String masp) {
		SanPham sp = dsSP.TimSP(masp);

		if (sp != null) {

			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

			String tenSp = sp.getTenSp();
			int soLuong = 1;
			double donGia = sp.getDonGia();
			double thanhTien = donGia * soLuong;

			tongthanhtien += thanhTien;
			String[] row = { tenSp, String.valueOf(soLuong), currencyFormatter.format(donGia),
					currencyFormatter.format(thanhTien) };

			modelHD.addRow(row);
			jlTongTienHD.setText("Tổng Tiền: " + currencyFormatter.format(tongthanhtien) + "");

			tableHD.revalidate();
			tableHD.repaint();
		}
	}

	void HienThiSPBAN(dsSanPham dsSP, Color c) {
		panelContainer.removeAll();
		panelContainer.revalidate();
		panelContainer.repaint();
		for (int i = 0; i <= dsSP.soLuongSP() - 1; i++) {
			String maSp = dsSP.returnSP(i).getMaSP().toString();
			String tenSp = dsSP.returnSP(i).getTenSp().toString();
			JPanel x = new JPanel();
			x.setPreferredSize(new Dimension(150, 200));
			x.setLayout(new BorderLayout());
			// mã
			jlMaSP = new JLabel(maSp, SwingConstants.CENTER);
			x.add(jlMaSP, BorderLayout.NORTH);

			// ảnh
			ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/imgSP/" + maSp + "" + ".png"));
			Image img = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_REPLICATE);

			imgksp = new JLabel();
			imgksp.setIcon(new ImageIcon(img));
			x.add(imgksp, BorderLayout.CENTER);

			// tên
			jlTenSP = new JLabel(tenSp);
			x.add(jlTenSP, BorderLayout.SOUTH);

			x.setName(maSp);
			x.setBorder(BorderFactory.createLineBorder(c));
			x.addMouseListener(this);
			panelContainer.add(x);

		}

	}

	void TimSPTheoMa(String maSP) {

		if (dsSP.TimSP(maSP) != null) {
			panelContainer.removeAll();
			panelContainer.revalidate();
			panelContainer.repaint();

			String maSp = dsSP.TimSP(maSP).getMaSP().toString();
			String tenSp = dsSP.TimSP(maSP).getTenSp().toString();
			JPanel x = new JPanel();
			x.setPreferredSize(new Dimension(150, 200));
			x.setLayout(new BorderLayout());
			// mã
			jlMaSP = new JLabel(maSp, SwingConstants.CENTER);
			x.add(jlMaSP, BorderLayout.NORTH);

			// ảnh
			ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/imgSP/" + maSp + "" + ".png"));
			Image img = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_REPLICATE);

			imgksp = new JLabel();
			imgksp.setIcon(new ImageIcon(img));
			x.add(imgksp, BorderLayout.CENTER);

			// tên
			jlTenSP = new JLabel(tenSp);
			x.add(jlTenSP, BorderLayout.SOUTH);

			x.setName(maSp);
			x.setBorder(BorderFactory.createLineBorder(Color.green));
			x.addMouseListener(this);
			panelContainer.add(x);

		} else {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã: " + maSP);

			HienThiSPBAN(dsSP, Color.RED);
		}
	}

	void TimSPTheoTen(String tenSP) {
		dsSanPham dsTKTen = new dsSanPham();
		Pattern pattern = Pattern.compile(tenSP, Pattern.CASE_INSENSITIVE);
		Matcher matcher;
		for (int i = 0; i < dsSP.soLuongSP(); i++) {
			matcher = pattern.matcher(dsSP.returnSP(i).getTenSp());
			if (matcher.find()) {
				dsTKTen.themSP(dsSP.returnSP(i));
			}
		}

		if (dsTKTen.soLuongSP() != 0) {

			HienThiSPBAN(dsTKTen, Color.green);

		} else {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có tên: " + tenSP);
			HienThiSPBAN(dsSP, Color.RED);
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

	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);

		String selectedDM = jcboxDM.getSelectedItem().toString();
		// THông tin SP
		if (e.getSource().equals(jbtTimMa)) {
			TimSPTheoMa(jtfTimMa.getText());

		} else if (e.getSource().equals(jbtTimTen)) {
			TimSPTheoTen(jtfTimTen.getText());
		} else if (!selectedDM.equals("xuatXu")) {
			locDM("{CALL sp_LocSanPhamTheoLoai(?)}", selectedDM);

		}

		// Hình Thức Thanh Toán
		if (e.getSource().equals(jcbHTTTHD)) {
			String selectedMethod = (String) jcbHTTTHD.getSelectedItem();
			ImageIcon imageIcon = null;
			if (selectedMethod.equals("Ngân Hàng")) {
				imageIcon = new ImageIcon(getClass().getResource("/image/NganHang.jpg"));
			} else if (selectedMethod.equals("MOMO")) {
				imageIcon = new ImageIcon(getClass().getResource("/image/MOMO.jpg"));
			} else {
				imgQR.setIcon(null);
			}
			if (imageIcon != null) {
				Image img = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
				imgQR.setIcon(new ImageIcon(img));
				imgQR.setHorizontalAlignment(SwingConstants.CENTER);
				imgQR.setVerticalAlignment(SwingConstants.CENTER);
			}
			boxHD2111.revalidate();
			boxHD2111.repaint();
		}
		if (e.getSource().equals(jbtLuuHD)) {
			String maHd = "HD" + String.format("%03d", soHD() + 1);
			jlTmaHD.setText("Mã HD: " + maHd);
			
			double tongtien = tongthanhtien;
			
			String HTTT = (String) jcbHTTTHD.getSelectedItem();
			String tenkh = jtfTenKH.getText();
			String TenNV = menuDNTK.getText();
//			luusql("{CALL ThemHoaDon(?, ?, ?, ?, ?, ?)}", maHd, null, tongtien, HTTT, tenkh, TenNV);
			JOptionPane.showMessageDialog(this, "Lưu thành công");
			
		} else if (e.getSource().equals(jbtXoaRongHD)) {
			xoaRong();
		} else if (e.getSource().equals(jbKHTIM)) {

			String tenKH = jtfTenKH.getText().toString();

			Date selectedDate = (Date) dateSpinner.getValue();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String ngaySinh = formatter.format(selectedDate);

			String gioiTinh = "";
			if (jrbKHNU.isSelected()) {
				gioiTinh = "F";
			} else {
				gioiTinh = "M";
			}

			String loaiThanhVien = "";
			if (jrbKHThuong.isSelected()) {
				loaiThanhVien = "Thường";
			} else if (jrbKHVip.isSelected()) {
				loaiThanhVien = "VIP";
			}
			timKH(tenKH, ngaySinh, gioiTinh, loaiThanhVien);
			jtfTenKH.getText();
			jlTenKHHD.setText(jtfTenKH.getText());

		} else if (e.getSource().equals(jbKHThem)) {
			String tenKH = jtfTenKH.getText().toString();

			Date selectedDate = (Date) dateSpinner.getValue();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String ngaySinh = formatter.format(selectedDate);

			String gioiTinh = "";
			if (jrbKHNU.isSelected()) {
				gioiTinh = "F";
			} else {
				gioiTinh = "M";
			}

			String loaiThanhVien = "";
			if (jrbKHThuong.isSelected()) {
				loaiThanhVien = "Thường";
			} else if (jrbKHVip.isSelected()) {
				loaiThanhVien = "VIP";
			}
			themKhachHang(tenKH, ngaySinh, gioiTinh, loaiThanhVien);
			jtfTenKH.getText();
			jlTenKHHD.setText(jtfTenKH.getText());

		}
	}

	void xoaRong() {
		jtfTenKH.setText("");
		jtfTimMa.setText("");
		jtfTimTen.setText("");
		jbGRKH.clearSelection();
		jrbKHNU.setSelected(false);
		jlTenKH.setText("Tên KH");
		jcbHTTTHD.setSelectedIndex(0);
		jcboxDM.setSelectedIndex(0);
		HienThiSPBAN(dsSP, Color.red);
		jlTongTienHD.setText("Tổng Tiền: ");
		modelHD.setRowCount(0);
	}

	int soHD() {
		int soLuongHoaDon = 0;
		String storedProcedureCall = "{CALL GetInvoiceCount()}";
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			CallableStatement callableStatement = con.prepareCall(storedProcedureCall);

			ResultSet rs = callableStatement.executeQuery();

			if (rs.next()) {
				soLuongHoaDon = rs.getInt("SoLuongHoaDon");
			}

			rs.close();
			callableStatement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soLuongHoaDon;

	}

	void timKH(String tenKH, String ngaySinh, String gioiTinh, String loaiThanhVien) {
		String storedProcedureCall = "{CALL sp_TimKhachHang(?, ?, ?, ?)}";
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			CallableStatement callableStatement = con.prepareCall(storedProcedureCall);
			callableStatement.setString(1, tenKH);
			callableStatement.setString(2, ngaySinh);
			callableStatement.setString(3, gioiTinh);
			callableStatement.setString(4, loaiThanhVien);

			ResultSet rs = callableStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng!", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				while (rs.next()) {
					String maKH = rs.getString("maKH");
					String tenKHResult = rs.getString("tenKH");
					String ngaySinhResult = rs.getString("ngaySinh");
					String gioiTinhResult = rs.getString("gioiTinh");
					String loaiThanhVienResult = rs.getString("loaiThanhVien");

					JOptionPane.showMessageDialog(null,
							"Mã KH: " + maKH + "\n" + "Tên KH: " + tenKHResult + "\n" + "Ngày sinh: " + ngaySinhResult
									+ "\n" + "Giới tính: " + gioiTinhResult + "\n" + "Loại thành viên: "
									+ loaiThanhVienResult);

				}
			}

			rs.close();
			callableStatement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	int soKH() {
		int soLuongKH = 0;
		String storedProcedureCall = "{CALL GetKhcount()}";
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			CallableStatement callableStatement = con.prepareCall(storedProcedureCall);

			ResultSet rs = callableStatement.executeQuery();

			if (rs.next()) {
				soLuongKH = rs.getInt("SoLuongKH");
			}

			rs.close();
			callableStatement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soLuongKH;

	}

	public void themKhachHang(String tenKH, String ngaySinh, String gioiTinh, String loaiThanhVien) {
		String storedProcedureCall = "{CALL ThemKhachHang(?, ?, ?, ?, ?)}";
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			CallableStatement callableStatement = con.prepareCall(storedProcedureCall);

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date sqlDate = new java.sql.Date(formatter.parse(ngaySinh).getTime());

			String maKH = "KH" + String.format("%03d", soKH() + 1);

			callableStatement.setString(1, maKH);
			callableStatement.setString(2, tenKH);
			callableStatement.setDate(3, sqlDate);
			callableStatement.setString(4, gioiTinh);
			callableStatement.setString(5, loaiThanhVien);

			int rowsAffected = callableStatement.executeUpdate();

			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Khách hàng đã được thêm thành công.", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Thêm khách hàng thất bại. Vui lòng thử lại.", "Thông báo",
						JOptionPane.ERROR_MESSAGE);
			}

			callableStatement.close();
			con.close();
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi thêm khách hàng. Vui lòng thử lại.", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
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

	void locDM(String callStore, String loai) {
		String storedProcedureCall = callStore;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			CallableStatement callableStatement = con.prepareCall(storedProcedureCall);

			callableStatement.setString(1, loai);

			ResultSet rs = callableStatement.executeQuery();

			panelContainer.removeAll();
			panelContainer.revalidate();
			panelContainer.repaint();

			while (rs.next()) {

				String maSp = rs.getString(1);
				String tenSp = rs.getString(2);
				JPanel x = new JPanel();
				x.setPreferredSize(new Dimension(150, 200));
				x.setLayout(new BorderLayout());
				// mã
				jlMaSP = new JLabel(maSp, SwingConstants.CENTER);
				x.add(jlMaSP, BorderLayout.NORTH);

				// ảnh
				ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/imgSP/" + maSp + "" + ".png"));
				Image img = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_REPLICATE);

				imgksp = new JLabel();
				imgksp.setIcon(new ImageIcon(img));
				x.add(imgksp, BorderLayout.CENTER);

				// tên
				jlTenSP = new JLabel(tenSp);
				x.add(jlTenSP, BorderLayout.SOUTH);

				x.setName(maSp);
				x.setBorder(BorderFactory.createLineBorder(Color.red));
				x.addMouseListener(this);
				panelContainer.add(x);

			}

			rs.close();
			callableStatement.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	void luusql(String callStore, String maHD, Date ngayLap, double tongTien, String hinhThucThanhToan, String maKH, String maNV) {
		String storedProcedureCall = callStore;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			CallableStatement callableStatement = con.prepareCall(storedProcedureCall);
	     
	        callableStatement.setString(1, maHD);
	        callableStatement.setDate(2, (java.sql.Date) ngayLap);
	        callableStatement.setDouble(3, tongTien);
	        callableStatement.setString(4, hinhThucThanhToan);
	        callableStatement.setString(5, maKH);
	        callableStatement.setString(6, maNV);

	        callableStatement.executeUpdate();
	        
	    } catch (SQLException e) {
	        System.err.println("Error executing stored procedure: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


}
