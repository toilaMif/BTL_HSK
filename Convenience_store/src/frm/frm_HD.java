package frm;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.util.Date;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.StyleSheet.BoxPainter;

import controller.ConnectDB;
import dao.quanLiHD;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class frm_HD extends frm_default implements ActionListener, MouseListener{

	private DefaultTableModel modeltb;
	private JTable table;
	private JRadioButton rd1;
	private JTextField tfB1;
	private JRadioButton rd11;
	private JTextField tfB11;
	private JRadioButton rd2;
	private JTextField tfB2;
	private JRadioButton rd21;
	private JTextField tfB21;
	private JButton huySB;
	private JButton timSB;
	private JTable tabletb;
	
	private ButtonGroup sortGroup;
	private ButtonGroup sBB;
	private JRadioButton sortByFuture, sortByPast, sortByIDAsc, sortByIDDesc,  sortByMoneyAsc, sortByMoneyDesc ;
	
	
	private quanLiHD dsHD ;
	private JButton xoaSB;
	private JButton cnSB;
	private JDialog updateDialog;
	private JTextField maHoaDonField;
	private JTextField maKHField;
	private JTextField tongTienField;
	private JTextField hinhThucThanhToanField;
	private JTextField maNVField;
	private static String maTK_login = login_page.getMaTK_login();
	public frm_HD() {
		
		super(maTK_login);
//		jlTitle.setText("Quản lí khách hàng");
//		jpCen.setBackground(Color.LIGHT_GRAY);
		JPanel contain = new JPanel(new BorderLayout());
//		Box contain;
		Box bTTSP, tables;
		
		
		
//		contain = Box.createVerticalBox();
//		contain.setBorder(BorderFactory.createLineBorder(Color.red, 3));
		contain.setPreferredSize(new Dimension(1533,730));
		contain.setMaximumSize(new Dimension(1533,730));
		contain.setBorder(BorderFactory.createEmptyBorder(5, 10, 20, 10));
		
		bTTSP = Box.createHorizontalBox();
//		bTTSP.setBorder(BorderFactory.createLineBorder(Color.red, 3));
		bTTSP.setPreferredSize(new Dimension(1533,180));
		bTTSP.setMaximumSize(new Dimension(1533,180));
		
		//Săp xếp
		JPanel sortPanel = new JPanel(new GridLayout(2,3,2,2 ));
//        sortPanel.setBorder(BorderFactory.createTitledBorder("Sắp xếp danh sách khách hàng"));
		sortPanel.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createLineBorder(new Color(163, 184, 204),2),"Sắp xếp danh sách hóa đơn"));
		sortPanel.setPreferredSize(new Dimension(750,150));
		sortPanel.setMaximumSize(new Dimension(750,150));
        sortByFuture = new JRadioButton("Theo ngày lập tăng dần");
        sortByPast = new JRadioButton("Theo ngày lập giảm dần");
        sortByIDAsc = new JRadioButton("Theo mã hóa đơn tăng dần");
        sortByIDDesc = new JRadioButton("Theo mã hóa đơn giảm dần");
        sortByMoneyAsc = new JRadioButton("Theo tổng tiền tăng dần");
        sortByMoneyDesc = new JRadioButton("Theo tổng tiền giảm dần");
		
        sortGroup = new ButtonGroup();
        sortGroup.add(sortByFuture);
        sortGroup.add(sortByPast);
        sortGroup.add(sortByIDAsc);
        sortGroup.add(sortByIDDesc);
        sortGroup.add(sortByMoneyAsc);
        sortGroup.add(sortByMoneyDesc);
        
        sortPanel.add(sortByFuture);
        sortPanel.add(sortByPast);
        sortPanel.add(sortByIDAsc);
        sortPanel.add(sortByIDDesc);
        sortPanel.add(sortByMoneyAsc);
        sortPanel.add(sortByMoneyDesc);
        
        
        //Tìm kiếm
        JPanel searchPanelB = new JPanel();
//        searchPanel.setBorder(BorderFactory.createTitledBorder("Tìm khách hàng"));
        searchPanelB.setLayout(new BoxLayout(searchPanelB, BoxLayout.Y_AXIS));
        searchPanelB.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createLineBorder(new Color(163, 184, 204),2),"Tìm khách hàng"));
        searchPanelB.setPreferredSize(new Dimension(800,150));
        searchPanelB.setMaximumSize(new Dimension(800,150));
        searchPanelB.setLayout(new BoxLayout(searchPanelB, BoxLayout.Y_AXIS));
        
        JPanel sB1 = new JPanel();
        sB1.setLayout(new BoxLayout(sB1, BoxLayout.X_AXIS));
        sB1.setPreferredSize(new Dimension(800,30));
        sB1.setMaximumSize(new Dimension(800,40));
        sB1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        sB1.add(Box.createHorizontalStrut(15));
        sB1.add(rd1 = new JRadioButton("Theo mã hóa đơn: "));
        sB1.add(Box.createHorizontalStrut(15));
        sB1.add(tfB1 = new JTextField());
        sB1.add(Box.createHorizontalStrut(10));
        sB1.add(rd11 = new JRadioButton("Theo ngày lập: "));
        sB1.add(Box.createHorizontalStrut(50));
        sB1.add(tfB11 = new JTextField());
        sB1.add(Box.createHorizontalStrut(5));
        
        JPanel sB2 = new JPanel();
        sB2.setLayout(new BoxLayout(sB2, BoxLayout.X_AXIS));
        sB2.setPreferredSize(new Dimension(800,30));
        sB2.setMaximumSize(new Dimension(800,40));
        sB2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        sB2.add(Box.createHorizontalStrut(15));
        sB2.add(rd2 = new JRadioButton("Theo tên nhân viên: "));
        sB2.add(Box.createHorizontalStrut(5));
        sB2.add(tfB2 = new JTextField());
        sB2.add(Box.createHorizontalStrut(10));
        sB2.add(rd21 = new JRadioButton("Theo tên khách hàng: "));
        sB2.add(Box.createHorizontalStrut(10));
        sB2.add(tfB21 = new JTextField());
        sB2.add(Box.createHorizontalStrut(5));
        
        JPanel sB3 = new JPanel();
        sB3.setLayout(new BoxLayout(sB3, BoxLayout.X_AXIS));
        sB3.setPreferredSize(new Dimension(800,30));
        sB3.setMaximumSize(new Dimension(800,40));
        sB3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        sB3.add(Box.createHorizontalStrut(420));
        sB3.add(cnSB= new JButton("Update"));
        sB3.add(Box.createHorizontalStrut(5));
        sB3.add(xoaSB= new JButton("Xóa"));
        sB3.add(Box.createHorizontalStrut(5));
        sB3.add(huySB = new JButton("Hủy"));
        sB3.add(Box.createHorizontalStrut(5));
        sB3.add(timSB= new JButton("Tìm"));
        sB3.add(Box.createHorizontalStrut(5));
       
        //Color for Button
        huySB.setBackground(new Color(255,0,0));
        huySB.setForeground(Color.white);
        huySB.setFont(new Font("Arial", Font.BOLD, 14));
        
        xoaSB.setBackground(new Color(255,0,0));
        xoaSB.setForeground(Color.white);
        xoaSB.setFont(new Font("Arial", Font.BOLD, 14));
        
        timSB.setBackground(new Color(3, 59, 90));
        timSB.setForeground(Color.white);
        timSB.setFont(new Font("Arial", Font.BOLD, 14));
        
        cnSB.setBackground(new Color(3, 59, 90));
        cnSB.setForeground(Color.white);
        cnSB.setFont(new Font("Arial", Font.BOLD, 14));
        
        //Size Button
        huySB.setPreferredSize(new Dimension(70,30));
        huySB.setMaximumSize(new Dimension(70,30));
        timSB.setPreferredSize(new Dimension(70,30));
        timSB.setMaximumSize(new Dimension(70,30));
        xoaSB.setPreferredSize(new Dimension(70,30));
        xoaSB.setMaximumSize(new Dimension(70,30));
        cnSB.setPreferredSize(new Dimension(88,30));
        cnSB.setMaximumSize(new Dimension(88,30));
        
        //Size Text Field
        
        tfB1.setPreferredSize(new Dimension(200,25));
        tfB1.setMaximumSize(new Dimension(200,25));
        tfB11.setPreferredSize(new Dimension(200,25));
        tfB11.setMaximumSize(new Dimension(200,25));
        tfB2.setPreferredSize(new Dimension(200,25));
        tfB2.setMaximumSize(new Dimension(200,25));
        tfB21.setPreferredSize(new Dimension(200,25));
        tfB21.setMaximumSize(new Dimension(200,25));
        
        sBB = new ButtonGroup();
        sBB.add(rd1);
        sBB.add(rd11);
        sBB.add(rd2);
        sBB.add(rd21);
        
//        searchPanelB.add(Box.createVerticalStrut(5));
        searchPanelB.add(sB1);
        searchPanelB.add(sB2);
        searchPanelB.add(sB3);
        
        //Table
        tables = Box.createHorizontalBox();
		tables.setPreferredSize(new Dimension(1500,100));
		tables.setMaximumSize(new Dimension(1500,100));
		tables.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        
		
        modeltb = new DefaultTableModel(new String[] {"Mã Hoá Đơn","Ngày lập","Tổng tiền","Hình thức thanh toán","Mã Khách hàng"},0);
		tabletb = new JTable(modeltb);
		JScrollPane jS = new JScrollPane(tabletb);
		tables.add(jS);
		jS.setBorder(BorderFactory.createLineBorder(new Color(163, 184, 204), 2));
//		Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
        
        
        bTTSP.add(sortPanel);
        bTTSP.add(Box.createRigidArea(new Dimension(10,0)));
        bTTSP.add(searchPanelB);
        contain.add(bTTSP,BorderLayout.NORTH);
        contain.add(tables,BorderLayout.CENTER);
        
        
		//jpCen 
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		jpCen.add(contain);
		setVisible(true);
		
		//Add ActionListener
		sortByFuture.addActionListener(this);
		sortByPast.addActionListener(this);
		sortByIDAsc.addActionListener(this);
		sortByIDDesc.addActionListener(this);
		sortByMoneyAsc.addActionListener(this);
		sortByMoneyDesc.addActionListener(this);
		rd1.addActionListener(this);
		rd11.addActionListener(this);
		rd2.addActionListener(this);
		rd21.addActionListener(this);
		huySB.addActionListener(this);
		timSB.addActionListener(this);
		xoaSB.addActionListener(this);
		cnSB.addActionListener(this);
		tabletb.addMouseListener(this);
		//Connect
        ConnectDB.getInstance().connect();
        dsHD= new quanLiHD();
		loadDataTable();
	}
	
	
	public static void main(String[] args) {
		frm_HD frmkh = new frm_HD();
	}
	
	//Đưa dữ liệu lên bảng
//	public void loadDataTable() {
//		modeltb.getDataVector().removeAllElements();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
//		DecimalFormat decimalFormat = new DecimalFormat("#,##0"+" VNĐ");
//		for (HoaDon h: dsHD.getallHoaDon() ) {
//			Object [] row = new Object[] {
//					h.getMaHoaDon(), dateFormat.format(h.getNgayLap()), decimalFormat.format(h.getTongTien()), h.getHinhthucThanhToan(), h.getKhachhang().getMaKH()
//			};
//			modeltb.addRow(row);
//		}
//	}
	
	public void loadDataTable() {
	    System.out.println("Loading...");
	    modeltb.setRowCount(0);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
	    DecimalFormat decimalFormat = new DecimalFormat("#,##0" + " VNĐ");

	    for (HoaDon h : dsHD.getallHoaDon()) {
	        String formattedDate = "";
	        if (h.getNgayLap() != null) {
	            Date date = java.sql.Date.valueOf(h.getNgayLap());
	            formattedDate = dateFormat.format(date);
	        }

	        Object[] row = new Object[] {
	            h.getMaHoaDon(),
	            formattedDate,
	            decimalFormat.format(h.getTongTien()),
	            h.getHinhthucThanhToan(),
	            h.getKhachhang().getMaKH()
	        };
	        modeltb.addRow(row);
	    }
	    modeltb.fireTableDataChanged();
	}

	
	//Gán danh sách từ sql
	public void loadData() {
//		dsHD = new quanLiHD();
		dsHD.setListHoaDon(dsHD.getallHoaDon());
	}
//	
	//Cho btn Huy
	public void resetPage() {
		sortGroup.clearSelection();
		sBB.clearSelection();
		tfB1.setText(""); tfB1.setEditable(false);
		tfB11.setText(""); tfB11.setEditable(false);
		tfB2.setText(""); tfB2.setEditable(false);
		tfB21.setText(""); tfB21.setEditable(false);
		dsHD.setListHoaDon(dsHD.getallHoaDon());
		loadDataTable();
		
	}
	
	//Tìm kiếm hóa đơn
	public void searchHoaDon() {
	    if (rd1.isSelected()) {
	        String ma = tfB1.getText().trim();
	        if (ma.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hóa đơn để tìm");
	            return;
	        }
	        dsHD.getDSHoaDon().clear();
	        dsHD.setListHoaDon(dsHD.getAllHoaDonByMa(ma));
//	        loadDataTable();
	        updateTableData(dsHD.getDSHoaDon());
	        JOptionPane.showMessageDialog(this, "Tìm thấy " + dsHD.getDSHoaDon().size() + " kết quả");
	    } else if (rd21.isSelected()) {
	        String tkh = tfB21.getText().trim();
	        if (tkh.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên khách hàng để tìm");
	            return;
	        }
	        dsHD.getDSHoaDon().clear();
	        dsHD.setListHoaDon(dsHD.getAllHoaDonByKH(tkh));
//	        loadDataTable();
	        updateTableData(dsHD.getDSHoaDon());
	        JOptionPane.showMessageDialog(this, "Tìm thấy " + dsHD.getDSHoaDon().size() + " kết quả");
	    } else if (rd2.isSelected()) {
	        String tnv = tfB2.getText().trim();
	        if (tnv.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên nhân viên để tìm");
	            return;
	        }
	        dsHD.getDSHoaDon().clear();
	        dsHD.setListHoaDon(dsHD.getAllHoaDonByNV(tnv));
//	        loadDataTable();
	        updateTableData(dsHD.getDSHoaDon());
	        JOptionPane.showMessageDialog(this, "Tìm thấy " + dsHD.getDSHoaDon().size() + " kết quả");
	    } else if (rd11.isSelected()) {
	        String date = tfB11.getText().trim();
	        if (date.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Vui lòng nhập vào ngày (dd/MM/yyyy) để tìm");
	            return;
	        }
	        try {
	            // Chuyển chuỗi ngày từ định dạng dd/MM/yyyy thành yyyy-MM-dd
	            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	            DateTimeFormatter sqlFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	            // Chuyển đổi sang LocalDate với định dạng yyyy-MM-dd
	            LocalDate localDate = LocalDate.parse(date, inputFormatter);
	            String formattedDate = localDate.format(sqlFormatter);  // Ngày ở định dạng chuẩn yyyy-MM-dd

	            // Xóa dữ liệu cũ và gọi phương thức tìm hóa đơn theo ngày
	            dsHD.getDSHoaDon().clear();
	            dsHD.setListHoaDon(dsHD.getAllHoaDonByDate(formattedDate));

	            // Cập nhật bảng và hiển thị số kết quả
	            updateTableData(dsHD.getDSHoaDon());
	            JOptionPane.showMessageDialog(this, "Tìm thấy " + dsHD.getDSHoaDon().size() + " kết quả");
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(this, "Ngày không hợp lệ, vui lòng nhập lại đúng định dạng dd/MM/yyyy");
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn tiêu chí để tìm kiếm");
	    }
	    
	    // Clear selections and reset text fields
	    sortGroup.clearSelection();
	    sBB.clearSelection();
	    tfB1.setText(""); tfB1.setEditable(false);
	    tfB11.setText(""); tfB11.setEditable(false);
	    tfB2.setText(""); tfB2.setEditable(false);
	    tfB21.setText(""); tfB21.setEditable(false);
	}

	private void updateTableData(ArrayList<HoaDon> dsHoaDon) {
	    modeltb.setRowCount(0);  // Xóa dữ liệu hiện tại trong bảng
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    DecimalFormat decimalFormat = new DecimalFormat("#,##0" + " VNĐ");

	    for (HoaDon h : dsHoaDon) {
	        String formattedDate = (h.getNgayLap() != null) ? dateFormat.format(java.sql.Date.valueOf(h.getNgayLap())) : "";
	        Object[] row = new Object[] {
	            h.getMaHoaDon(),
	            formattedDate,
	            decimalFormat.format(h.getTongTien()),
	            h.getHinhthucThanhToan(),
	            h.getKhachhang().getMaKH()
	        };
	        modeltb.addRow(row);
	    }
	    modeltb.fireTableDataChanged();  // Cập nhật bảng sau khi thêm dữ liệu mới
	}
	
	public void actionPerformed(ActionEvent e) {
		var obj = e.getSource();
		if(obj.equals(rd1)) {
			if(!rd2.isSelected() && !rd21.isSelected() && !rd11.isSelected()) {
				tfB11.setText(""); tfB11.setEditable(false);
				tfB2.setText(""); tfB2.setEditable(false);
				tfB21.setText(""); tfB21.setEditable(false);
			}
			tfB1.setEditable(true);
		}
		else if(obj.equals(rd2)) {
			if(!rd1.isSelected() && !rd21.isSelected() && !rd11.isSelected() ) {
				tfB11.setText(""); tfB11.setEditable(false);
				tfB1.setText(""); tfB1.setEditable(false);
				tfB21.setText(""); tfB21.setEditable(false);
			}
			tfB2.setEditable(true);
		}
		else if(obj.equals(rd11)) {
			if(!rd2.isSelected() && !rd21.isSelected() && !rd1.isSelected()) {
				tfB2.setText(""); tfB2.setEditable(false);
				tfB1.setText(""); tfB1.setEditable(false);
				tfB21.setText(""); tfB21.setEditable(false);
			}
			tfB11.setEditable(true);
		}
		else if(obj.equals(rd21)) {
			if(!rd2.isSelected() && !rd11.isSelected() && !rd1.isSelected()) {
				tfB2.setText(""); tfB2.setEditable(false);
				tfB1.setText(""); tfB1.setEditable(false);
				tfB11.setText(""); tfB11.setEditable(false);
			}
			tfB21.setEditable(true);
		}
		else if(obj.equals(timSB)) {
			searchHoaDon();
			updateTableData(dsHD.getDSHoaDon());
		}
		else if(obj.equals(huySB)) {
			resetPage();
			updateTableData(dsHD.getDSHoaDon());
		}
		else if (obj.equals(sortByFuture)) {
		    dsHD.sortByDateASC();
		    updateTableData(dsHD.getDSHoaDon());
		}
		else if (obj.equals(sortByPast)) {
		    dsHD.sortByDateDESC();
		    updateTableData(dsHD.getDSHoaDon());
		}
		else if (obj.equals(sortByIDAsc)) {
		    dsHD.sortByIdBillASC();
		    updateTableData(dsHD.getDSHoaDon());
		}
		else if (obj.equals(sortByIDDesc)) {
		    dsHD.sortByIdBillDESC();
		    updateTableData(dsHD.getDSHoaDon());
		}
		else if (obj.equals(sortByMoneyAsc)) {
		    dsHD.sortByTotalPriceASC();
		    updateTableData(dsHD.getDSHoaDon());
		}
		else if (obj.equals(sortByMoneyDesc)) {
		    dsHD.sortByTotalPriceDESC();
		    updateTableData(dsHD.getDSHoaDon());
		}
		else if(obj.equals(xoaSB)) {
			deleteHD();
		}
		else if(obj.equals(cnSB)) {
			updateHD();
		}

	}
	
    public void deleteHD(){
        // Kiểm tra xem người dùng đã chọn hàng nào trong bảng chưa
        int selectedRow = tabletb.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn cần xóa từ bảng.");
            return;
        }

        // Lấy mã hóa đơn từ hàng được chọn
        String maHoaDon = tabletb.getValueAt(selectedRow, 0).toString(); // Giả sử mã hóa đơn nằm ở cột đầu tiên (cột 0)
        
        // Hiển thị hộp thoại xác nhận
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa hóa đơn này không?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Gọi hàm delete để xóa hóa đơn
            quanLiHD dsHD = new quanLiHD(); // Giả sử bạn có lớp DAO tên là InvoiceDAO
            boolean isDeleted = dsHD.delete(maHoaDon);
            
            if (isDeleted) {
                JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công!");
                // Xóa hàng khỏi bảng
                ((DefaultTableModel) tabletb.getModel()).removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(null, "Xóa hóa đơn thất bại!");
            }
        }
    }
    
    public void updateHD() {
        int selectedRow = tabletb.getSelectedRow();
        if (selectedRow != -1) {
            // Lấy thông tin hóa đơn đã chọn từ bảng
            String maHoaDon = (String) tabletb.getValueAt(selectedRow, 0);
            String ngayLap = (String) tabletb.getValueAt(selectedRow, 1);
            double tongTien = (Double) tabletb.getValueAt(selectedRow, 2);
            String hinhThucThanhToan = (String) tabletb.getValueAt(selectedRow, 3);
            String maKH = (String) tabletb.getValueAt(selectedRow, 4);
            String maNV = (String) tabletb.getValueAt(selectedRow, 5);

            // Mở Dialog để người dùng có thể chỉnh sửa hóa đơn
            openUpdateDialog(maHoaDon, ngayLap, tongTien, hinhThucThanhToan, maKH, maNV);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một hóa đơn để cập nhật.");
        }
    }
    
    private void openUpdateDialog(String maHoaDon, String ngayLap, double tongTien, String hinhThucThanhToan, String maKH, String maNV) {
        // Tạo một dialog mới để sửa thông tin hóa đơn
        updateDialog = new JDialog(this, "Cập Nhật Hóa Đơn", true);
        updateDialog.setSize(400, 300);
        updateDialog.setLayout(new BoxLayout(updateDialog.getContentPane(), BoxLayout.Y_AXIS));

        maHoaDonField = new JTextField(maHoaDon, 20);
        maHoaDonField.setEditable(false);  // Mã hóa đơn không cho sửa
        tongTienField = new JTextField(String.valueOf(tongTien), 20);
        hinhThucThanhToanField = new JTextField(hinhThucThanhToan, 20);
        maKHField = new JTextField(maKH, 20);
        maNVField = new JTextField(maNV, 20);

        updateDialog.add(new JLabel("Mã Hóa Đơn:"));
        updateDialog.add(maHoaDonField);
        updateDialog.add(new JLabel("Tổng Tiền:"));
        updateDialog.add(tongTienField);
        updateDialog.add(new JLabel("Hình Thức Thanh Toán:"));
        updateDialog.add(hinhThucThanhToanField);
        updateDialog.add(new JLabel("Mã Khách Hàng:"));
        updateDialog.add(maKHField);
        updateDialog.add(new JLabel("Mã Nhân Viên:"));
        updateDialog.add(maNVField);

        // Nút "Xác Nhận"
        JButton confirmButton = new JButton("Xác Nhận");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	KhachHang khachhang = new KhachHang(maKHField.getText());  // Tạo đối tượng KhachHang từ mã KH
                NhanVien nhanvien = new NhanVien(maNVField.getText());
                // Cập nhật thông tin hóa đơn
                HoaDon updatedHoaDon = new HoaDon(
                        maHoaDonField.getText(),
                        LocalDate.parse(ngayLap),
                        Double.parseDouble(tongTienField.getText()),
                        hinhThucThanhToanField.getText(),
                        khachhang, nhanvien
                );

                quanLiHD dsHD = new quanLiHD();
                boolean isUpdated = dsHD.update(updatedHoaDon);

                if (isUpdated) {
                    JOptionPane.showMessageDialog(null, "Cập nhật hóa đơn thành công!");
                    updateDialog.dispose();
                    loadDataTable();  // Tải lại danh sách hóa đơn
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật hóa đơn thất bại!");
                }
            }
        });
        updateDialog.add(confirmButton);

        // Nút "Thoát"
        JButton exitButton = new JButton("Thoát");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateDialog.dispose();  // Đóng dialog mà không lưu thay đổi
            }
        });
        updateDialog.add(exitButton);

        updateDialog.setVisible(true);  // Hiển thị dialog
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

}
