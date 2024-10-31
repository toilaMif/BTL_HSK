package frm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class login_page extends JFrame implements ActionListener, MouseListener{
	
	private JLabel lDangNhap, l_ten_dang_nhap, l_password, imgLabel;
	private JTextField txtTenDangNhap, txtPassword;
	private JButton btnDangNhap;
	private JPanel pWest, pEast;
	
	
	public login_page(){
		setResizable(false);
		pWest = new JPanel();
		pWest.setPreferredSize(new Dimension(600,500));
		pWest.setLayout(new GridBagLayout());
		GridBagConstraints gbcL = new GridBagConstraints();
		gbcL.anchor = GridBagConstraints.CENTER;
		imgLabel = new JLabel();
		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/Logo.jpg"));
		Image img = imageIcon.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH);
		imgLabel.setIcon(new ImageIcon(img));
		pWest.add(imgLabel,gbcL);
		add(pWest, BorderLayout.WEST);
		
		
		
		
		
		
		pEast = new JPanel();
		pEast.setPreferredSize(new Dimension(400,500));
		pEast.setLayout(new GridBagLayout());
		GridBagConstraints gbcR = new GridBagConstraints();
		gbcR.anchor = GridBagConstraints.CENTER;
		gbcR.insets = new Insets(0, 5, 20, 5);
		gbcR.gridwidth = GridBagConstraints.REMAINDER;
		
		lDangNhap = new JLabel("ĐĂNG NHẬP");
		
		lDangNhap.setForeground(new Color(123,142,218));
		Font f = new Font(Font.SERIF, Font.BOLD, 50);
		lDangNhap.setFont(f);
		pEast.add(lDangNhap, gbcR);
		
		
		l_ten_dang_nhap = new JLabel("Tên đăng nhập");
		gbcR.anchor = GridBagConstraints.WEST;
		gbcR.gridy = 1;
		gbcR.insets = new Insets(5, 5, 5, 5);
		pEast.add(l_ten_dang_nhap, gbcR);
		
		txtTenDangNhap = new JTextField(30);
		txtTenDangNhap.setBorder(null);
		gbcR.gridy = 2;
		pEast.add(txtTenDangNhap, gbcR);
		
		
		l_password = new JLabel("Mật khẩu");
		gbcR.gridy = 3;
		pEast.add(l_password, gbcR);

		txtPassword = new JTextField(30);
		gbcR.gridy = 4;
		pEast.add(txtPassword, gbcR);
		pEast.setBackground(new Color(222, 227, 247));
		
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setFont(new Font("Segoe UI", 1, 20));
		btnDangNhap.setForeground(new Color(255,255,255));
		btnDangNhap.setBackground(new Color(123,142,218));
		gbcR.gridy = 5;
		pEast.add(btnDangNhap, gbcR);
		add(pEast, BorderLayout.EAST);
		
		
		setSize(1000,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new login_page();
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
