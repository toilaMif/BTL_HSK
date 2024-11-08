package frm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class frm_BanHang extends frm_default{
	private JPanel bTT;
	private JPanel jbTT1;
	private JPanel jbTT2;
	private JPanel bCen;
	private JPanel bBHD;
	private JPanel bDSSP;


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
				"Thông Tin Sản Phẩm", 0, 0, fnTitle, Color.white));

		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		//San Phap
		jbTT1 = new JPanel();
		jbTT1.setBackground(Color.gray);
		
		
		//Khach Hang
		jbTT2 = new JPanel();
		jbTT2.setBackground(Color.gray);
		jbTT2.setLayout(new BorderLayout());
		
		split.add(jbTT1);
		split.add(jbTT2);
		
		
		//Hoa Don
		bBHD = new JPanel();
		bBHD.setLayout(new BorderLayout());
		bBHD.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Hóa Đơn", 0,
				0, fnTitle, Color.white));
		bBHD.setBackground(Color.gray);
		
		bDSSP = new JPanel();
		bDSSP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white),
				"Danh sách sản phẩm", 0, 0, fnTitle, Color.white));
		bDSSP.setBackground(Color.gray);
		
		
		
		bCen.add(bTT, BorderLayout.NORTH);
		bCen.add(bBHD, BorderLayout.EAST);
		bCen.add(bDSSP, BorderLayout.CENTER);
		
		jpCen.add(bCen, BorderLayout.CENTER);
	}
	
	
	public static void main(String[] args) {
		new frm_BanHang();
	}
}
