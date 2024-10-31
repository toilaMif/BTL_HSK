package frm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class frm_KhachHang extends frm_default {

	private DefaultTableModel modeltb;
	private JTable table;
	
	public frm_KhachHang() {
		super();
//		jlTitle.setText("Quản lí khách hàng");
		jpCen.setBackground(Color.LIGHT_GRAY);
		JPanel contain = new JPanel(new BorderLayout());
//		Box contain;
		Box bTTSP, tables , space;
		
//		contain = Box.createVerticalBox();
//		contain.setBorder(BorderFactory.createLineBorder(Color.red, 3));
		contain.setPreferredSize(new Dimension(1550,800));
		contain.setMaximumSize(new Dimension(1550,800));
		contain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
		
		bTTSP = Box.createHorizontalBox();
//		bTTSP.setBorder(BorderFactory.createLineBorder(Color.red, 3));
		bTTSP.setPreferredSize(new Dimension(1510,180));
		bTTSP.setMaximumSize(new Dimension(1510,180));
		
		//Săp xếp
		JPanel sortPanel = new JPanel(new GridLayout(2,2,5,5 ));
//        sortPanel.setBorder(BorderFactory.createTitledBorder("Sắp xếp danh sách khách hàng"));
		sortPanel.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createLineBorder(Color.RED),"Sắp xếp danh sách khách hàng"));
		sortPanel.setPreferredSize(new Dimension(450,150));
		sortPanel.setMaximumSize(new Dimension(500,180));
        JRadioButton sortByNameAsc = new JRadioButton("Theo tên tăng dần");
        JRadioButton sortByNameDesc = new JRadioButton("Theo tên giảm dần");
        JRadioButton sortByIDAsc = new JRadioButton("Theo mã khách hàng tăng dần");
        JRadioButton sortByIDDesc = new JRadioButton("Theo mã khách hàng giảm dần");
		
        ButtonGroup sortGroup = new ButtonGroup();
        sortGroup.add(sortByNameAsc);
        sortGroup.add(sortByNameDesc);
        sortGroup.add(sortByIDAsc);
        sortGroup.add(sortByIDDesc);
        
        sortPanel.add(sortByNameAsc);
        sortPanel.add(sortByNameDesc);
        sortPanel.add(sortByIDAsc);
        sortPanel.add(sortByIDDesc);
        
        
        //Tìm kiếm
        JPanel searchPanel = new JPanel();
//        searchPanel.setBorder(BorderFactory.createTitledBorder("Tìm khách hàng"));
        searchPanel.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createLineBorder(Color.RED),"Tìm khách hàng"));
        searchPanel.setPreferredSize(new Dimension(300,180));
        searchPanel.setMaximumSize(new Dimension(400,180));
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));
       
        
        JPanel s1 = new JPanel(new FlowLayout(FlowLayout.CENTER,25, 5));
        JPanel s2 = new JPanel(new FlowLayout(FlowLayout.CENTER,25, 5));
        JPanel s3 = new JPanel();
//        s3.setLayout(new BoxLayout(s3, BoxLayout.X_AXIS));
        s3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        s3.setBorder(new EmptyBorder(5, 20, 5, 35));
        
        JRadioButton searchByName = new JRadioButton("Theo tên:");
        JRadioButton searchByID = new JRadioButton("Theo mã:");
        JTextField nameTextField = new JTextField(20);
        JTextField idTextField = new JTextField(20);
        JButton searchButton = new JButton("Tìm");
        JButton cancelButton = new JButton("Hủy");
        
        //Set kích thước cho nút
        searchButton.setPreferredSize(new Dimension(70, 20));
        cancelButton.setPreferredSize(new Dimension(70, 20));
        searchButton.setBackground(Color.BLUE); 
        searchButton.setForeground(Color.WHITE);

        cancelButton.setBackground(Color.RED); 
        cancelButton.setForeground(Color.WHITE); 
        
        s1.add(searchByName);
        s1.add(nameTextField);
        searchPanel.add(Box.createVerticalStrut(30));
        searchPanel.add(s1);
        
        s2.add(searchByID);
        s2.add(idTextField);
        searchPanel.add(Box.createVerticalStrut(5));
        searchPanel.add(s2);
        
//        s3.add(Box.createHorizontalStrut(200));
        s3.add(cancelButton);
        s3.add(searchButton);
        searchPanel.add(Box.createVerticalStrut(5));
        searchPanel.add(s3);
        
        

//        ButtonGroup searchGroup = new ButtonGroup();
//        searchGroup.add(searchByName);
//        searchGroup.add(searchByID);
//
//        searchPanel.add(searchByName);
//        searchPanel.add(searchTextField);
//        searchPanel.add(searchByID);
//        searchPanel.add(searchTextField);
//        searchPanel.add(cancelButton);
//        searchPanel.add(searchButton);
        
        //Table
        tables = Box.createHorizontalBox();
		tables.setPreferredSize(new Dimension(1500,100));
		tables.setMaximumSize(new Dimension(1500,100));
		tables.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
		
        modeltb = new DefaultTableModel(new String[] {"Mã Khách Hàng","Họ Tên","Ngày sinh","Giới tính","Loại thành viên"},0);
		table = new JTable(modeltb);
		table.addMouseListener(this);
		JScrollPane jS = new JScrollPane(table);
		tables.add(jS);
		jS.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
//		Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
        
        
        bTTSP.add(sortPanel);
        bTTSP.add(Box.createRigidArea(new Dimension(630,0)));
        bTTSP.add(searchPanel);
        contain.add(bTTSP,BorderLayout.NORTH);
        contain.add(tables,BorderLayout.CENTER);
		
		//jpCen 
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		jpCen.add(contain);
		setVisible(true);
	}
	public static void main(String[] args) {
		frm_KhachHang frmkh = new frm_KhachHang();
	}
	
}