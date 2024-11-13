package frm;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class frm_dsTaiKhoan extends frm_default{
	private static String maTK_login = login_page.getMaTK_login();
	public frm_dsTaiKhoan() {
		super(maTK_login);
		jlTitle.setText("Quản Lý Tài Khoản");
		setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		new frm_dsTaiKhoan();
	}
}
