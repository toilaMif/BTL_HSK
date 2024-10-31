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
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;


public class frm_default extends JFrame implements ActionListener, MouseListener {

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


	public frm_default() {
		super("Cửa Hàng Tiện Lợi");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
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
