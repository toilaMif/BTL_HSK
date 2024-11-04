package frm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.NhanVien_Dao;

public class frm_dsNhanVien extends frm_default implements ActionListener, MouseListener{

	private DefaultTableModel model_tableNV;
	private JTextField txtMa, txtTen, txtDiaChi, txtSdt,txtMaTim, txtNgaySinh, txtNgayVaoLam, txtLuong;
	private JRadioButton nam,nu;
	private ButtonGroup group;
	private JPanel pCenter;
	private JButton btnTim, btnXoa, btnXoarong, btnThem, btnLuu, btnSua;
	private JTable table_dsNhanVien;
	public frm_dsNhanVien() {
		super();
		jlTitle.setText("Danh sách Nhân Viên");
		pCenter = new JPanel();
		pCenter.add(Box.createHorizontalGlue());
		pCenter.add(jlTitle);
		pCenter.setBackground(Color.gray);
//		Box contain;
		Box bTTNV;
		
		bTTNV = Box.createHorizontalBox();
//		bTTSP.setBorder(BorderFactory.createLineBorder(Color.red, 3));
		bTTNV.setPreferredSize(new Dimension(1533,180));
		bTTNV.setMaximumSize(new Dimension(1333,180));
		
		//Săp xếp
		JPanel sortPanel = new JPanel(new GridLayout(2,2,5,5 ));
//        sortPanel.setBorder(BorderFactory.createTitledBorder("Sắp xếp danh sách khách hàng"));
		sortPanel.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createLineBorder(Color.RED),"Sắp xếp danh sách nhân viên"));
		sortPanel.setPreferredSize(new Dimension(450,150));
		sortPanel.setMaximumSize(new Dimension(500,180));
        JRadioButton sortByNameAsc = new JRadioButton("Theo tên tăng dần");
        JRadioButton sortByNameDesc = new JRadioButton("Theo tên giảm dần");
        JRadioButton sortByIDAsc = new JRadioButton("Theo mã nhân viên tăng dần");
        JRadioButton sortByIDDesc = new JRadioButton("Theo mã nhân viên giảm dần");
		
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
	            BorderFactory.createLineBorder(Color.RED),"Tìm nhân viên"));
        searchPanel.setPreferredSize(new Dimension(300,180));
        searchPanel.setMaximumSize(new Dimension(400,180));
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));
       
        
        Box s1 = new Box(BoxLayout.X_AXIS);
        Box s2 = new Box(BoxLayout.X_AXIS);
        JPanel s3 = new JPanel();
//        s3.setLayout(new BoxLayout(s3, BoxLayout.X_AXIS));
        s3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        s3.setBorder(new EmptyBorder(5, 20, 5, 35));
        
        JRadioButton searchByName = new JRadioButton("Theo tên nhân viên:");
        JRadioButton searchByID = new JRadioButton("Theo mã nhân viên:");
        JTextField nameTextField = new JTextField(20);
        JTextField idTextField = new JTextField(20);
        JButton searchButton = new JButton("Tìm");
        JButton cancelButton = new JButton("Hủy");
        ButtonGroup sBT = new ButtonGroup();
        sBT.add(searchByID);
        sBT.add(searchByName);
        
        //Set kích thước cho nút
        searchButton.setPreferredSize(new Dimension(70, 20));
        cancelButton.setPreferredSize(new Dimension(70, 20));
        searchButton.setBackground(Color.BLUE); 
        searchButton.setForeground(Color.WHITE);

        cancelButton.setBackground(Color.RED); 
        cancelButton.setForeground(Color.WHITE); 
        
        s1.add(searchByName);
        s1.add(Box.createHorizontalStrut(3));
        s1.add(nameTextField);
        searchPanel.add(Box.createVerticalStrut(5));
        searchPanel.add(s1);
        searchPanel.add(Box.createVerticalStrut(30));
        
        s2.add(searchByID);
        s2.add(Box.createHorizontalStrut(5));
        s2.add(idTextField);
        searchPanel.add(Box.createVerticalStrut(10));
        searchPanel.add(s2);
        searchPanel.add(Box.createVerticalStrut(10));
//        s3.add(Box.createHorizontalStrut(200));
        s3.add(cancelButton);
        s3.add(searchButton);
        searchPanel.add(Box.createVerticalStrut(5));
        searchPanel.add(s3);
		
		
		
		String[] cells = {"Mã nhân viên", "Tên nhân viên", "Phái", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Ngày vào làm", "Lương"};
		model_tableNV = new DefaultTableModel(cells,0);
		table_dsNhanVien = new JTable(model_tableNV);
		JScrollPane scroll = new JScrollPane(table_dsNhanVien);
		scroll.setPreferredSize(new Dimension(1000,500));
		
		bTTNV.add(sortPanel);
        bTTNV.add(Box.createRigidArea(new Dimension(600,0)));
        bTTNV.add(searchPanel);
        pCenter.add(bTTNV);
        pCenter.add(scroll);
        add(pCenter, BorderLayout.CENTER);
		//jpCen 
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new frm_dsNhanVien();
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
