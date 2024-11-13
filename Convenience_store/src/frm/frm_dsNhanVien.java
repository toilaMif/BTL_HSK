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
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ConnectDB;
import dao.NhanVien_Dao;
import entity.NhanVien;
import frm.login_page;

public class frm_dsNhanVien extends frm_default implements ActionListener, MouseListener{
	private static String maTK_login = login_page.getMaTK_login();
	private DefaultTableModel model_tableNV;
	
	private ButtonGroup group;
	private JPanel pCenter;
	private JButton btnTim, btnHuy;
	private JRadioButton sortByNameAsc, sortByNameDesc, sortByIDAsc, sortByIDDesc,searchByName,searchByID ;
	private JTable table_dsNhanVien;
	private NhanVien_Dao ds;
	private String ma_login;
	private JTextField nameTextField, idTextField;
	private ArrayList<NhanVien> list;
	
	public frm_dsNhanVien(String maLogin) {
		super(maTK_login);
		
		ConnectDB.getInstance().connect();
		ds = new NhanVien_Dao();
		list = ds.getAllNV();
		
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
        sortByNameAsc = new JRadioButton("Theo tên tăng dần");
        sortByNameDesc = new JRadioButton("Theo tên giảm dần");
        sortByIDAsc = new JRadioButton("Theo mã nhân viên tăng dần");
        sortByIDDesc = new JRadioButton("Theo mã nhân viên giảm dần");
		
        ButtonGroup sortGroup = new ButtonGroup();
        sortGroup.add(sortByNameAsc);
        sortGroup.add(sortByNameDesc);
        sortGroup.add(sortByIDAsc);
        sortGroup.add(sortByIDDesc);
        
        sortPanel.add(sortByNameAsc);
        sortPanel.add(sortByNameDesc);
        sortPanel.add(sortByIDAsc);
        sortPanel.add(sortByIDDesc);
        
        sortByNameAsc.addActionListener(e -> sortEmployees("name", true));
        sortByNameDesc.addActionListener(e -> sortEmployees("name", false));
        sortByIDAsc.addActionListener(e -> sortEmployees("id", true));
        sortByIDDesc.addActionListener(e -> sortEmployees("id", false));
        
        
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
        
        searchByName = new JRadioButton("Theo tên nhân viên:");
        searchByID = new JRadioButton("Theo mã nhân viên:");
        nameTextField = new JTextField(20);
        idTextField = new JTextField(20);
        btnTim = new JButton("Tìm");
        btnHuy = new JButton("Hủy");
        ButtonGroup sBT = new ButtonGroup();
        sBT.add(searchByID);
        sBT.add(searchByName);
        
        //Set kích thước cho nút
        btnTim.setPreferredSize(new Dimension(70, 20));
        btnHuy.setPreferredSize(new Dimension(70, 20));
        btnTim.setBackground(Color.BLUE); 
        btnTim.setForeground(Color.WHITE);

        btnHuy.setBackground(Color.RED); 
        btnHuy.setForeground(Color.WHITE); 
        
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
        s3.add(btnHuy);
        s3.add(btnTim);
        searchPanel.add(Box.createVerticalStrut(5));
        searchPanel.add(s3);
		
		
        btnTim.addActionListener(this);
        btnHuy.addActionListener(this);
		
		String[] cells = {"Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Địa chỉ","Giới tính","Lương",  "Ngày vào làm","Số điện thoại"};
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
        hienTable();
		//jpCen 
        menuDNTK.setText(maLogin);
        setTitle("Cửa hàng tiện lợi");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void hienTable() {
	    NhanVien_Dao nhanVienDao = new NhanVien_Dao();
	    ArrayList<NhanVien> employees = nhanVienDao.getAllNV();

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	    model_tableNV.setRowCount(0);

	    for (NhanVien nv : employees) {
	        model_tableNV.addRow(new Object[] {
	            nv.getMaNV(),
	            nv.getTenNV(),
	            nv.getNgaySinh().format(formatter),
	            nv.getDiaChi(),
	            nv.isPhai() ? "Nữ" : "Nam",
	            nv.getLuong(),
	            nv.getNgayVaoLam().format(formatter),
	            nv.getSdt()
	        });
	    }
	}

	
	
	
//	public static void main(String[] args) {
//		new frm_dsNhanVien("1");
//	}
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

	public void sortEmployees(String sortBy, boolean ascending) {
	    ArrayList<NhanVien> sortedEmployees = ds.getAllNVSorted(sortBy, ascending);
	    
	    model_tableNV.setRowCount(0); // Clear existing data
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	    for (NhanVien nv : sortedEmployees) {
	        model_tableNV.addRow(new Object[]{
	            nv.getMaNV(),
	            nv.getTenNV(),
	            nv.getNgaySinh() != null ? nv.getNgaySinh().format(formatter) : "",
	            nv.getDiaChi(),
	            nv.isPhai() ? "Nữ" : "Nam",
	            nv.getLuong(),
	            nv.getNgayVaoLam() != null ? nv.getNgayVaoLam().format(formatter) : "",
	            nv.getSdt()
	        });
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnTim)) {
		    if (searchByID.isSelected()) {
		        String maNV = idTextField.getText().trim();

		        if (maNV.isEmpty()) {
		            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên cần tìm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        ArrayList<NhanVien> foundEmployees = ds.getNVByID(maNV);

		        if (foundEmployees.isEmpty()) {
		            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên với mã " + maNV, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            model_tableNV.setRowCount(0); // Clear the table
		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		            for (NhanVien nv : foundEmployees) {
		                model_tableNV.addRow(new Object[]{
		                    nv.getMaNV(),
		                    nv.getTenNV(),
		                    nv.getNgaySinh() != null ? nv.getNgaySinh().format(formatter) : "",
		                    nv.getDiaChi(),
		                    nv.isPhai() ? "Nữ" : "Nam",
		                    nv.getLuong(),
		                    nv.getNgayVaoLam() != null ? nv.getNgayVaoLam().format(formatter) : "",
		                    nv.getSdt()
		                });
		            }
		        }
		    } else if (searchByName.isSelected()) { // Check if the search is by name
		        String name = nameTextField.getText().trim();

		        if (name.isEmpty()) {
		            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhân viên cần tìm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        ArrayList<NhanVien> foundEmployees = ds.getNVByName(name);

		        if (foundEmployees.isEmpty()) {
		            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên với tên " + name, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            model_tableNV.setRowCount(0); // Clear the table
		            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		            for (NhanVien nv : foundEmployees) {
		                model_tableNV.addRow(new Object[]{
		                    nv.getMaNV(),
		                    nv.getTenNV(),
		                    nv.getNgaySinh() != null ? nv.getNgaySinh().format(formatter) : "",
		                    nv.getDiaChi(),
		                    nv.isPhai() ? "Nữ" : "Nam",
		                    nv.getLuong(),
		                    nv.getNgayVaoLam() != null ? nv.getNgayVaoLam().format(formatter) : "",
		                    nv.getSdt()
		                });
		            }
		        }
		    }
		}

		else if(o.equals(btnHuy)) {
			hienTable();
		}
		else if (o.equals(menuSP)) {
	        new frm_SanPham();  
	        this.dispose();     
	    }else if (o.equals(mnuItemDNTK)) {
	    	new login_page();
	    	this.dispose(); 
	    }else if (o.equals(mnuItemDKTK)) {
	    	new login_page();
	    	this.dispose(); 
	    }else if (o.equals(mnuItemQLSP)) {
	    	new frm_SanPham();
	    	this.dispose(); 
	    }
	    else if (sortByNameAsc.isSelected()) {
	        sortEmployees("tenNV", true);
	    } else if (sortByNameDesc.isSelected()) {
	        sortEmployees("tenNV", false);
	    } else if (sortByIDAsc.isSelected()) {
	        sortEmployees("maNV", true);
	    } else if (sortByIDDesc.isSelected()) {
	        sortEmployees("maNV", false);
	    }
		
	}
	

}
