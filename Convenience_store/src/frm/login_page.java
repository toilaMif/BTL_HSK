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
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ConnectDB;
import dao.Account_Dao;
import entity.Account;

public class login_page extends JFrame implements ActionListener, MouseListener{
	
	protected JLabel lDangNhap, l_ten_dang_nhap, l_password, imgLabel;
	protected JTextField txtTenDangNhap, txtPassword;
	protected JButton btnDangNhap;
	protected JPanel pWest, pEast;
	protected Account_Dao listTK;
	protected ArrayList<Account> listAccount;
	public login_page(){
		
		ConnectDB.getInstance().connect();
		listTK = new Account_Dao();
		listAccount = listTK.getAllAccount();
		
		listTK.setListAccount(listTK.getListAccount());
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
		txtPassword.setBorder(null);
		
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
		
		btnDangNhap.addActionListener(this);
		
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
		Object o = e.getSource();
		if(o.equals(btnDangNhap)) {
			login();
		}
	}
	
	public void login() {
		String userName = txtTenDangNhap.getText();
		String pass = txtPassword.getText();
		try {
			Account user = new Account(userName, pass);
			if(listTK.isUserNameExists(userName)) {
				new frm_default().setVisible(true);
				this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(btnDangNhap, "Tài khoản không tồn tại");
			}
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(btnDangNhap, "Lỗi");
		}
		
	}
	public void loadUser() {
		listTK.setListAccount(listTK.getAllAccount());
	}
	
}
