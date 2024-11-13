package frm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class frm_controlKH extends frm_default implements MouseListener, ActionListener{
	private static String maTK_login = login_page.getMaTK_login();
	private DefaultTableModel modeltb;
	private JTable table;
	private JLabel tt1;
	private JTextField tf1;
	private JLabel tt11;
	private JTextField tf11;
	private JLabel tt2;
	private JComboBox cbo2;
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton bt4;
	private JButton bt5;
	private JComboBox cbo1;
	private JLabel tt12;
	private JTextField tf2;
	private JLabel tt21;
	private JTextField tf21;
	
	public frm_controlKH() {
		super(maTK_login);
//		jlTitle.setText("Quản lí khách hàng");
		jpCen.setBackground(Color.LIGHT_GRAY);
		JPanel contain = new JPanel(new BorderLayout());
//		Box contain;
		Box bTTSP, tables ,i1 ,i2, i3;
		
//		contain = Box.createVerticalBox();
//		contain.setBorder(BorderFactory.createLineBorder(Color.red, 3));
		contain.setPreferredSize(new Dimension(1533,730));
		contain.setMaximumSize(new Dimension(1533,730));
		contain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		bTTSP = Box.createHorizontalBox();
//		bTTSP.setBorder(BorderFactory.createLineBorder(Color.red, 3));
		bTTSP.setPreferredSize(new Dimension(1533,180));
		bTTSP.setMaximumSize(new Dimension(1533,180));
		
		//Săp xếp
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createLineBorder(new Color(163, 184, 204),2),"Thông tin khách hàng "));
		inputPanel.setPreferredSize(new Dimension(850,100));
		inputPanel.setMaximumSize(new Dimension(850,150));
        
		i1 = Box.createHorizontalBox();
		i1.setPreferredSize(new Dimension(850,30));
		i1.setMaximumSize(new Dimension(850,40));
		i1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		i1.add(tt1 = new JLabel("Mã Khách hàng: "));
		i1.add(Box.createHorizontalStrut(5));
		i1.add(tf1 = new JTextField());
		i1.add(Box.createHorizontalStrut(10));
		i1.add(tt11 = new JLabel("Họ tên: "));
		i1.add(Box.createHorizontalStrut(5));
		i1.add(tf11 = new JTextField());
		i1.add(Box.createHorizontalStrut(10));
		i1.add(tt12 = new JLabel("Giới tính: "));
		i1.add(Box.createHorizontalStrut(5));
		i1.add(cbo1 = new JComboBox<String>(new String[]{"Nam", "Nữ"}));
		
		i2 = Box.createHorizontalBox();
		i2.setPreferredSize(new Dimension(850,30));
		i2.setMaximumSize(new Dimension(850,40));
		i2.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		i2.add(tt2 = new JLabel("Số điện thoại: "));
		i2.add(Box.createHorizontalStrut(18));
		i2.add(tf2 = new JTextField());
		i2.add(Box.createHorizontalStrut(10));
		i2.add(tt21 = new JLabel("Ngày sinh: "));
		i2.add(Box.createHorizontalStrut(5));
		i2.add(tf21 = new JTextField());
		
		//Set size TextField
		tf1.setPreferredSize(new Dimension(200,25));
		tf1.setMaximumSize(new Dimension(200,25));
		tf11.setPreferredSize(new Dimension(200,25));
		tf11.setMaximumSize(new Dimension(200,25));
		tf2.setPreferredSize(new Dimension(200,25));
		tf2.setMaximumSize(new Dimension(200,25));
		cbo1.setPreferredSize(new Dimension(200,25));
		cbo1.setMaximumSize(new Dimension(200,25));
		tf21.setPreferredSize(new Dimension(182,25));
		tf21.setMaximumSize(new Dimension(182,25));
        
		inputPanel.add(Box.createVerticalStrut(20));
		inputPanel.add(i1);
		inputPanel.add(Box.createVerticalStrut(5));
		inputPanel.add(i2);
        


        //Table
        tables = Box.createHorizontalBox();
		tables.setPreferredSize(new Dimension(1500,500));
		tables.setMaximumSize(new Dimension(1500,500));
		tables.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        
		
        modeltb = new DefaultTableModel(new String[] {"Mã Khách Hàng","Họ Tên","Ngày sinh","Giới tính","Loại thành viên"},0);
		table = new JTable(modeltb);
		table.addMouseListener(this);
		JScrollPane jS = new JScrollPane(table);
		tables.add(jS);
		jS.setBorder(BorderFactory.createLineBorder(new Color(163, 184, 204),2));
//		Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
		
		//Các nút chức năng
		JPanel pS5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pS5.setPreferredSize(new Dimension(1500,50));
		pS5.setMaximumSize(new Dimension(1500,50));
		pS5.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
		pS5.add(bt1 = new JButton("Làm mới"));
		pS5.add(bt2 = new JButton("Thêm khách hàng"));
		pS5.add(bt3 = new JButton("Sửa khách hàng"));
		pS5.add(bt4 = new JButton("Xóa khách hàng"));
		pS5.add(bt5 = new JButton("Xuất danh sách"));
		
		//Size button
		
		Dimension bt = new Dimension(150,25);
		Color sky = new Color(163, 184, 204);
		
//		bt1.setBackground(Color.LIGHT_GRAY);
//		bt2.setBackground(Color.LIGHT_GRAY);
//		bt3.setBackground(Color.LIGHT_GRAY);
//		bt4.setBackground(Color.LIGHT_GRAY);
//		bt5.setBackground(Color.LIGHT_GRAY);
//		
		bt1.setBackground(sky);
		bt2.setBackground(sky);
		bt3.setBackground(sky);
		bt4.setBackground(sky);
		bt5.setBackground(sky);
		
		bt1.setForeground(Color.WHITE);
		bt2.setForeground(Color.WHITE);
		bt3.setForeground(Color.WHITE);
		bt4.setForeground(Color.WHITE);
		bt5.setForeground(Color.WHITE);
		
		bt1.setMaximumSize(bt);
		bt1.setPreferredSize(bt);
		bt2.setMaximumSize(bt);
		bt2.setPreferredSize(bt);
		bt3.setMaximumSize(bt);
		bt3.setPreferredSize(bt);
		bt4.setMaximumSize(bt);
		bt4.setPreferredSize(bt);
		bt5.setMaximumSize(bt);
		bt5.setPreferredSize(bt);
        
        
        bTTSP.add(inputPanel);
      
  
        contain.add(bTTSP,BorderLayout.NORTH);
        contain.add(tables,BorderLayout.CENTER);
        contain.add(pS5,BorderLayout.SOUTH);
		
		//jpCen 
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		jpCen.add(contain);
		setVisible(true);
	}
	public static void main(String[] args) {
		frm_controlKH frmkh = new frm_controlKH();
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
		super.actionPerformed(e);
	}
	
}