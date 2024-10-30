package frm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.border.Border;

public class frm_SanPham extends frm_default {

	public frm_SanPham() {
		super();
		jlTitle.setText("Quản Lý Sản Phẩm");

		Font fnTitle = new Font("Times New Roman", Font.BOLD + Font.ITALIC, 15);
		Box bTTSP;
		bTTSP = Box.createVerticalBox();
		bTTSP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white),
				"Thông Tin Sản Phẩm", 0, 0, fnTitle, Color.white));
		bTTSP.setPreferredSize(new Dimension(1300, 200));

		jpCen.add(bTTSP);
		setVisible(true);
	}

	public static void main(String[] args) {
		frm_SanPham frmsp = new frm_SanPham();
	}

}
