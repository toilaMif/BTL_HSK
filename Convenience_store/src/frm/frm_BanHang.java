package frm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import java.awt.*;

import javax.swing.table.DefaultTableModel;

import controller.readDataSP;
import dao.dsSanPham;
import entity.SanPham;

public class frm_BanHang extends frm_default implements ActionListener, MouseListener{
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


	public frm_BanHang() {
		super();
		jlTitle.setText("Bán Hàng");
		jpCen.setLayout(new BorderLayout());
		jpCen.add(jlTitle, BorderLayout.NORTH);
		
		Font fnTitle = new Font("Times New Roman", Font.BOLD + Font.ITALIC + Font.CENTER_BASELINE, 15);
		setVisible(true);
		
		bCen = new JPanel();

		bCen.setLayout(new BorderLayout());
		
		//NUT XU LY
		bTT = new JPanel();
		bTT.setLayout(new BorderLayout());
		bTT.setBackground(Color.gray);
		bTT.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white),
				"Thông Tin", 0, 0, fnTitle, Color.white));

		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		//San Phap
		jbTT1 = new JPanel( new GridLayout(3,1,15,15));
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
		jlGiamGia = new JLabel("Giảm Giá: ");
		jlGiamGia.setForeground(Color.white);
		
		groupGG = new ButtonGroup();
		jpGG = new JPanel(new GridLayout(1,3,5,5));
		jpGG.setBackground(Color.gray);
		jrbGG25 = new JRadioButton("25%");
		jrbGG25.setForeground(Color.white);
		jrbGG25.setBackground(Color.gray);
		jrbGG50 = new JRadioButton("50%");
		jrbGG50.setForeground(Color.white);
		jrbGG50.setBackground(Color.gray);
		jrbGG75 = new JRadioButton("75%");
		jrbGG75.setForeground(Color.white);
		jrbGG75.setBackground(Color.gray);
		
		
		groupGG.add(jrbGG25);
		groupGG.add(jrbGG50);
		groupGG.add(jrbGG75);
		
		jpGG.add(jrbGG25);
		jpGG.add(jrbGG50);
		jpGG.add(jrbGG75);
		
		bTKSPGG.add(jlGiamGia);
		bTKSPGG.add(Box.createHorizontalStrut(50));
		bTKSPGG.add(jpGG);
		
		jbTT1.add(bTKSPTen);
		jbTT1.add(bTKSPMa);
		jbTT1.add(bTKSPGG);
		
		//Khach Hang
		Box bKHTen = Box.createHorizontalBox();
		Box bKHDate = Box.createHorizontalBox();
		Box bKHLoai	 = Box.createHorizontalBox();
		jbTT2 = new JPanel(new GridLayout(3,1,5,5));
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
		
		
		
		
		//ngày sinh khách hàng
		SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner dateSpinner = new JSpinner(dateModel);
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
		
		//Hoa Don
		boxHD1 = new JPanel(new GridLayout(3,1));
		boxHD2 = new JPanel(new BorderLayout());
		boxHD3 = new JPanel(new GridLayout(3,1,5,5));
		
		boxHD21 = new JPanel(new BorderLayout());
		boxHD211 = new JPanel(new BorderLayout());
		
		bBHD = new JPanel();
		bBHD.setLayout(new BorderLayout());
		bBHD.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Hóa Đơn", 0,
				0, fnTitle, Color.white));
		bBHD.setBackground(Color.gray);
		
		jpHoaDon =  new JPanel();
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
		
		boxHD1.add(jlTitleHD);
		boxHD1.add(jlTNgayGio);
		boxHD1.add(jlTmaHD);
		
		String[] Row = {"Tên Hàng","SL", "Đơn Giá", "Thành Tiền"};
		
		modelHD = new DefaultTableModel(Row,0);
		tableHD = new JTable(modelHD);
		tableHD.setShowGrid(false);
		
		JScrollPane jsc = new JScrollPane(tableHD);
		tableHD.addMouseListener(this);
		
		boxHD2.add(jsc,BorderLayout.CENTER);
		
		jlTongTienHD = new JLabel("Tổng Tiền: ");
		jlHTTTHD = new JLabel("HTTT: ");
		
		String[] HTTTHD = {"Tiền Mặt","Ngân Hàng", "MOMO"};
		
		
		jcbHTTTHD = new JComboBox<String>(HTTTHD);
		jcbHTTTHD.addActionListener(this);
		jcbHTTTHD.setPreferredSize(new Dimension(150,20));
		
		
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
		
		boxbtn = new JPanel(new GridLayout(1,2,5,5));
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
		panelContainer.setPreferredSize(new Dimension(150, 200*dsSP.soLuongSP()/5 )); 
		
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
	void ThemVaoHD (String masp) {
		if(dsSP.TimSP(masp)!= null) {
			
			
			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
			String[] row = {dsSP.TimSP(masp).getTenSp(),1 +""
					,currencyFormatter.format(dsSP.TimSP(masp).getDonGia())
					, currencyFormatter.format(dsSP.TimSP(masp).getDonGia())};
			modelHD.addRow(row);
			tableHD.show();
		}
	}
	void HienThiSPBAN(dsSanPham dsSP, Color c){
		panelContainer.removeAll();
		panelContainer.revalidate();
		panelContainer.repaint();
		for (int i = 0; i <= dsSP.soLuongSP() -1; i++) {
			String maSp = dsSP.returnSP(i).getMaSP().toString();
			String tenSp = dsSP.returnSP(i).getTenSp().toString();
			JPanel x = new JPanel();
		    x.setPreferredSize(new Dimension(150, 200));
		    x.setLayout(new BorderLayout());
		    //mã
		    jlMaSP = new JLabel(maSp, SwingConstants.CENTER);
		    x.add(jlMaSP, BorderLayout.NORTH);
		    
		    
		    //ảnh
		    ImageIcon imageIcon = new ImageIcon(
					getClass().getResource("/image/imgSP/" + maSp + "" + ".png"));
			Image img = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_REPLICATE);
			
			imgksp = new JLabel();
			imgksp.setIcon(new ImageIcon(img));
			x.add(imgksp, BorderLayout.CENTER);
			
		    
			//tên
		    jlTenSP = new JLabel(tenSp);
		    x.add(jlTenSP, BorderLayout.SOUTH);
		    
		    x.setName(maSp);
		    x.setBorder(BorderFactory.createLineBorder(c));
		    x.addMouseListener(this);
		    panelContainer.add(x); 
			
		}
		
	}
	void TimSPTheoMa(String maSP) {
		
		if(dsSP.TimSP(maSP)!= null) {
			panelContainer.removeAll();
			panelContainer.revalidate();
			panelContainer.repaint();
			
			String maSp = dsSP.TimSP(maSP).getMaSP().toString();
			String tenSp = dsSP.TimSP(maSP).getTenSp().toString();
			JPanel x = new JPanel();
		    x.setPreferredSize(new Dimension(150, 200));
		    x.setLayout(new BorderLayout());
		    //mã
		    jlMaSP = new JLabel(maSp, SwingConstants.CENTER);
		    x.add(jlMaSP, BorderLayout.NORTH);
		    
		    
		    //ảnh
		    ImageIcon imageIcon = new ImageIcon(
					getClass().getResource("/image/imgSP/" + maSp + "" + ".png"));
			Image img = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_REPLICATE);
			
			imgksp = new JLabel();
			imgksp.setIcon(new ImageIcon(img));
			x.add(imgksp, BorderLayout.CENTER);
			
		    
			//tên
		    jlTenSP = new JLabel(tenSp);
		    x.add(jlTenSP, BorderLayout.SOUTH);
		    
		    x.setName(maSp);
		    x.setBorder(BorderFactory.createLineBorder(Color.green));
		    x.addMouseListener(this);
		    panelContainer.add(x); 
			
			
		}else {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm có mã: " +maSP);
			
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
	    
	    //THông tin SP
	    if(e.getSource().equals(jbtTimMa)) {
	    	TimSPTheoMa(jtfTimMa.getText());
	    	
	    }else if (e.getSource().equals(jbtTimTen)){
	    	TimSPTheoTen(jtfTimTen.getText());
	    }
	    
	    //Tên KH HD
	    if(e.getSource().equals(jbKHThem)) {
	    	jtfTenKH.getText();
	    	jlTenKHHD.setText(jtfTenKH.getText());
	    	
	    }else if (e.getSource().equals(jbKHTIM)){
	    	jtfTenKH.getText();
	    	jlTenKHHD.setText(jtfTenKH.getText());
	    }
	    
	    
	    //Hình Thức Thanh Toán
	    if (e.getSource().equals(jcbHTTTHD)) {
	        String selectedMethod = (String) jcbHTTTHD.getSelectedItem();
	        ImageIcon imageIcon = null;
	        if (selectedMethod.equals("Ngân Hàng")) {
	            imageIcon = new ImageIcon(getClass().getResource("/image/NganHang.jpg"));
	        } else if (selectedMethod.equals("MOMO")) {
	            imageIcon = new ImageIcon(getClass().getResource("/image/MOMO.jpg"));
	        }else {
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
	}

}
