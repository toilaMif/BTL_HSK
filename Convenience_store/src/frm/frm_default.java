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


public class frm_default extends JFrame{

	private JMenuBar menubar;
	private JMenu menuNV;
	public JPanel jpCen;
	private JMenu menuSP;
	private JMenu menuKH;
	private JMenu menuHD;
	private JMenu menuDM;
	private JMenu menuTK;
	private JMenu menuDNTK;
	private JPanel jpTitle;
	public JLabel jlTitle;
	private JMenuItem mnuItem1;
	private JMenuItem mnuItem3;
	private JMenuItem mnuItem4;
	private JMenuItem mnuItem6;
	private JMenuItem mnuItem8;
	private JMenuItem mnuItem10;
	private JMenuItem mnuItem9;
	private JMenuItem mnuItem7;
	private JMenuItem mnuItem5;
	private JMenuItem mnuItem2;
	private JMenuItem mnuItem11;
	private JMenuItem mnuItem12;
	private JMenuItem mnuItem13;


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
		
		
		// item menuDM
		JMenuItem mnuItem1 = new JMenuItem("Đồ Ăn");
		mnuItem1.setForeground(Color.WHITE);
		mnuItem1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		mnuItem1.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
		mnuItem1.setPreferredSize(new Dimension(100, 30));
		menuDM.add(mnuItem1);
		
		mnuItem2 = new JMenuItem("Đồ Uống");    
		mnuItem2.setForeground(Color.WHITE);
		mnuItem2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		mnuItem2.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
		mnuItem2.setPreferredSize(new Dimension(100, 30));
		menuDM.add(mnuItem2);
		
		
		mnuItem3 = new JMenuItem("ĐỒ Ăn");    
		mnuItem3.setForeground(Color.WHITE);
		mnuItem3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		mnuItem3.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 16));
		mnuItem3.setPreferredSize(new Dimension(100, 30));
		menuDM.add(mnuItem3);
		
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
		
		menuTK = new JMenu("Thống Kê");
		menuTK.setForeground(Color.WHITE);
		menuTK.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));
		menuTK.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		menuTK.setIcon(new ImageIcon(getClass().getResource("/image/TK.png")));
		menubar.add(menuTK);
		
		
		
		menubar.add(Box.createHorizontalGlue());
		menuDNTK = new JMenu("Đăng Nhập");
		menuDNTK.setForeground(Color.WHITE);
		menuDNTK.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
		menuDNTK.setIcon(new ImageIcon(getClass().getResource("/image/ICONTK.png")));
		menubar.add(menuDNTK);

		
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

	}


}
