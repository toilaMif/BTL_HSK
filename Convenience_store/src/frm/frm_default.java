package frm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class frm_default extends JFrame implements ActionListener{

	public JMenuBar menubar;
	public JMenu menuNV;
	public JPanel jpCen;
	public JMenu menuSP;
	public JMenu menuKH;
	public JMenu menuHD;
	public JMenu menuDM;
	public JMenu menuTK;
	public JMenu menuDNTK;
	public JPanel jpTitle;
	public JLabel jlTitle;
	public JMenuItem mnuItem1;
	public JMenuItem mnuItem3;
	public JMenuItem mnuItem4;
	public JMenuItem mnuItem6;
	public JMenuItem mnuItem8;
	 public JMenuItem mnuItem10;
	 public JMenuItem mnuItem9;
	 public JMenuItem mnuItem7;
	 public JMenuItem mnuItem5;
	 public JMenuItem mnuItem2;
	 public JMenuItem mnuItem11;
	 public JMenuItem mnuItem12;
	 public JMenuItem mnuItem13;
	 public JMenuItem mnuItemDKTK;
	 public JMenuItem mnuItemDNTK;
	 public JMenuItem mnuItemBanHang;
	 public JMenuItem mnuItemQLSP;
	 public JMenuItem mnuItemQLNX;
	 public JMenuItem mnuItemQLHTK;
	 public JMenuItem mnuItemQLHD;
	 public JMenuItem mnuItemQLNV;
	 public JMenuItem mnuItemQLTK;
	 public JMenuItem mnuItemQLKH;
	 public JMenuItem mnuItemQLKM;
	 public JMenuItem mnuItemQLBC;
	 public JMenuItem mnuItemTKSP;
	 public JMenuItem mnuItemTKKH;
	 public JMenuItem mnuItemTKDT;


	public frm_default() {
		super("Cửa Hàng Tiện Lợi");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		setSize(500, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Phần center
		jpCen = new JPanel();
		jpCen.add(Box.createHorizontalGlue());
		jpCen.setBackground(Color.gray);

		//Menu
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
		
			//Item menuNV
			mnuItemQLNV = new JMenuItem("Quản Lý Nhân Viên");
			mnuItemQLNV.setForeground(Color.WHITE);
			mnuItemQLNV.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
			mnuItemQLNV.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
			mnuItemQLNV.setPreferredSize(new Dimension(170, 30));
			menuNV.add(mnuItemQLNV);
			
			mnuItemQLTK = new JMenuItem("Quản Lý Tài Khoản");
			mnuItemQLTK.setForeground(Color.WHITE);
			mnuItemQLTK.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
			mnuItemQLTK.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
			mnuItemQLTK.setPreferredSize(new Dimension(170, 30));
			menuNV.add(mnuItemQLTK);
		
		menuKH = new JMenu("Khách Hàng");
		menuKH.setForeground(Color.WHITE);
		menuKH.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		menuKH.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		menuKH.setIcon(new ImageIcon(getClass().getResource("/image/KH.png")));
		menubar.add(menuKH);
		
			//Item menuKH
			mnuItemQLKH = new JMenuItem("Quản Lý Khách Hàng");
			mnuItemQLKH.setForeground(Color.WHITE);
			mnuItemQLKH.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
			mnuItemQLKH.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
			mnuItemQLKH.setPreferredSize(new Dimension(170, 30));
			menuKH.add(mnuItemQLKH);
			
			mnuItemQLKM = new JMenuItem("Quản Lý Khuyến Mãi");
			mnuItemQLKM.setForeground(Color.WHITE);
			mnuItemQLKM.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
			mnuItemQLKM.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
			mnuItemQLKM.setPreferredSize(new Dimension(170, 30));
			menuKH.add(mnuItemQLKM);
		
		menuSP = new JMenu("Sản Phẩm");
		menuSP.setLayout(null);
		menuSP.setForeground(Color.WHITE);
		menuSP.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		menuSP.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		menuSP.setIcon(new ImageIcon(getClass().getResource("/image/SP.png")));
		menubar.add(menuSP);
		
		// item menuSP
				mnuItemBanHang = new JMenuItem("Bán hàng");
				mnuItemBanHang.setForeground(Color.WHITE);
				mnuItemBanHang.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItemBanHang.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItemBanHang.setPreferredSize(new Dimension(150, 30));
				menuSP.add(mnuItemBanHang);
				
				mnuItemQLSP = new JMenuItem("Quản Lý Sản Phẩm");
				mnuItemQLSP.setForeground(Color.WHITE);
				mnuItemQLSP.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItemQLSP.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItemQLSP.setPreferredSize(new Dimension(170, 30));
				menuSP.add(mnuItemQLSP);
				
				mnuItemQLNX = new JMenuItem("Quản Lý Nhập Xuất");
				mnuItemQLNX.setForeground(Color.WHITE);
				mnuItemQLNX.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItemQLNX.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItemQLNX.setPreferredSize(new Dimension(170, 30));
				menuSP.add(mnuItemQLNX);
				
				mnuItemQLHTK = new JMenuItem("Quản Lý Hàng Tồn Kho");
				mnuItemQLHTK.setForeground(Color.WHITE);
				mnuItemQLHTK.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItemQLHTK.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItemQLHTK.setPreferredSize(new Dimension(190, 30));
				menuSP.add(mnuItemQLHTK);
		
		
		
		menuDM = new JMenu("Danh Mục");
		menuDM.setForeground(Color.WHITE);
		menuDM.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		menuDM.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		menuDM.setIcon(new ImageIcon(getClass().getResource("/image/DM.png")));
		menubar.add(menuDM);
		
		
				// item menuDM
				JMenuItem mnuItem1 = new JMenuItem("Đồ Ăn");
				mnuItem1.setForeground(Color.WHITE);
				mnuItem1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItem1.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItem1.setPreferredSize(new Dimension(170, 30));
				menuDM.add(mnuItem1);
				
				mnuItem2 = new JMenuItem("Đồ Uống");    
				mnuItem2.setForeground(Color.WHITE);
				mnuItem2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItem2.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItem2.setPreferredSize(new Dimension(100, 30));
				menuDM.add(mnuItem2);
				
				
		//		mnuItem3 = new JMenuItem("ĐỒ Ăn");    
		//		mnuItem3.setForeground(Color.WHITE);
		//		mnuItem3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		//		mnuItem3.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
		//		mnuItem3.setPreferredSize(new Dimension(100, 30));
		//		menuDM.add(mnuItem3);
				
				mnuItem4 = new JMenuItem("Đồ Uống Đóng");    
				mnuItem4.setForeground(Color.WHITE);
				mnuItem4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItem4.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItem4.setPreferredSize(new Dimension(100, 30));
				menuDM.add(mnuItem4);
				
				mnuItem5 = new JMenuItem("Thực Phẩm");    
				mnuItem5.setForeground(Color.WHITE);
				mnuItem5.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItem5.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItem5.setPreferredSize(new Dimension(100, 30));
				menuDM.add(mnuItem5);
				
				mnuItem6 = new JMenuItem("Đồ Hộp");    
				mnuItem6.setForeground(Color.WHITE);
				mnuItem6.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItem6.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItem6.setPreferredSize(new Dimension(100, 30));
				menuDM.add(mnuItem6);
				
				mnuItem7 = new JMenuItem("Gia Vị");    
				mnuItem7.setForeground(Color.WHITE);
				mnuItem7.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItem7.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItem7.setPreferredSize(new Dimension(100, 30));
				menuDM.add(mnuItem7);
				
				mnuItem8 = new JMenuItem("Dầu Gội");    
				mnuItem8.setForeground(Color.WHITE);
				mnuItem8.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItem8.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItem8.setPreferredSize(new Dimension(100, 30));
				menuDM.add(mnuItem8);
				
				
				mnuItem9 = new JMenuItem("Nước Giặt");    
				mnuItem9.setForeground(Color.WHITE);
				mnuItem9.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItem9.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItem9.setPreferredSize(new Dimension(100, 30));
				menuDM.add(mnuItem9);
				
				mnuItem10 = new JMenuItem("Đồ Uống Có Cồn");    
				mnuItem10.setForeground(Color.WHITE);
				mnuItem10.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItem10.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItem10.setPreferredSize(new Dimension(100, 30));
				menuDM.add(mnuItem10);
				
				mnuItem11 = new JMenuItem("Thực Phẩm Ăn Liền");    
				mnuItem11.setForeground(Color.WHITE);
				mnuItem11.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItem11.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItem11.setPreferredSize(new Dimension(100, 30));
				menuDM.add(mnuItem11);
				
				mnuItem12 = new JMenuItem("Văn Phòng Phẩm");    
				mnuItem12.setForeground(Color.WHITE);
				mnuItem12.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItem12.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItem12.setPreferredSize(new Dimension(100, 30));
				menuDM.add(mnuItem12);
				
				mnuItem13 = new JMenuItem("Thiết yếu");    
				mnuItem13.setForeground(Color.WHITE);
				mnuItem13.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItem13.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItem13.setPreferredSize(new Dimension(100, 30));
				menuDM.add(mnuItem13);
 		
 		

		
		
		menuHD = new JMenu("Hóa Đơn");
		menuHD.setForeground(Color.WHITE);
		menuHD.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		menuHD.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		menuHD.setIcon(new ImageIcon(getClass().getResource("/image/HD.png")));
		menubar.add(menuHD);
		
			//menu Item HoaDon
			mnuItemQLHD = new JMenuItem("Quản Lý Hóa Đơn");    
			mnuItemQLHD.setForeground(Color.WHITE);
			mnuItemQLHD.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
			mnuItemQLHD.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
			mnuItemQLHD.setPreferredSize(new Dimension(190, 30));
			menuHD.add(mnuItemQLHD);
			
		
		menuTK = new JMenu("Thống Kê");
		menuTK.setForeground(Color.WHITE);
		menuTK.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		menuTK.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		menuTK.setIcon(new ImageIcon(getClass().getResource("/image/TK.png")));
		menubar.add(menuTK);
			//menu Item HoaDon
			mnuItemQLBC = new JMenuItem("Quản Lý Báo Cáo");    
			mnuItemQLBC.setForeground(Color.WHITE);
			mnuItemQLBC.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
			mnuItemQLBC.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
			mnuItemQLBC.setPreferredSize(new Dimension(190, 30));
			menuTK.add(mnuItemQLBC);
			
			mnuItemTKDT = new JMenuItem("Thống Kê Doanh Thu");    
			mnuItemTKDT.setForeground(Color.WHITE);
			mnuItemTKDT.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
			mnuItemTKDT.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
			mnuItemTKDT.setPreferredSize(new Dimension(190, 30));
			menuTK.add(mnuItemTKDT);
			
			mnuItemTKKH = new JMenuItem("Thống Kê Khách Hàng");    
			mnuItemTKKH.setForeground(Color.WHITE);
			mnuItemTKKH.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
			mnuItemTKKH.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
			mnuItemTKKH.setPreferredSize(new Dimension(190, 30));
			menuTK.add(mnuItemTKKH);
			
			mnuItemTKSP = new JMenuItem("Thống Kê Sản Phẩm");    
			mnuItemTKSP.setForeground(Color.WHITE);
			mnuItemTKSP.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
			mnuItemTKSP.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
			mnuItemTKSP.setPreferredSize(new Dimension(190, 30));
			menuTK.add(mnuItemTKSP);
		
		
		
		menubar.add(Box.createHorizontalGlue());
		menuDNTK = new JMenu("Đăng Nhập");
		menuDNTK.setForeground(Color.WHITE);
		menuDNTK.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		menuDNTK.setIcon(new ImageIcon(getClass().getResource("/image/ICONTK.png")));
		menubar.add(menuDNTK);
		
		
				//Item Dang Nhap
				mnuItemDNTK = new JMenuItem("Đăng Nhập");    
				mnuItemDNTK.setForeground(Color.WHITE);
				mnuItemDNTK.setBackground(new Color(163, 184, 204));
				mnuItemDNTK.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItemDNTK.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItemDNTK.setPreferredSize(new Dimension(100, 30));
				menuDNTK.add(mnuItemDNTK);
				
				mnuItemDKTK = new JMenuItem("Đăng Ký");    
				mnuItemDKTK.setForeground(Color.WHITE);
				mnuItemDKTK.setBackground(new Color(163, 184, 204));
				mnuItemDKTK.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
				mnuItemDKTK.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
				mnuItemDKTK.setPreferredSize(new Dimension(140, 30));
				menuDNTK.add(mnuItemDKTK);

		
		jpTitle = new JPanel();
		jpTitle.setBackground(null);
//		jpTitle.setBorder(BorderFactory.createLineBorder(Color.white));
//		jpTitle.setPreferredSize(new Dimension(1000, 200));
		jlTitle = new JLabel("Cửa Hàng Tiện lợi");
		Font fn = new Font("Times New Roman", Font.BOLD + Font.ITALIC, 50);
		jlTitle.setFont(fn);
		jlTitle.setForeground(Color.WHITE);
		jpTitle.add(jlTitle);
		jpCen.add(jpTitle);
		
		
		
//		setContentPane(jpCen);
		add(jpCen, BorderLayout.CENTER);

//		setVisible(true);
		
		mnuItemBanHang.addActionListener(this);
		mnuItemQLSP.addActionListener(this);
		mnuItemDKTK.addActionListener(this);
		mnuItemDNTK.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
	    Object o = e.getSource();
	    if (o.equals(menuSP)) {
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
	    }else if (o.equals(mnuItemBanHang)) {
	    	new frm_BanHang();
	    	this.dispose(); 
	    }
	}





}
