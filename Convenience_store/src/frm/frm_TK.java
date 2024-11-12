package frm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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
import javax.swing.text.html.StyleSheet.BoxPainter;

import com.toedter.calendar.JDateChooser;

import controller.ConnectDB;
import dao.quanLiHD;
import entity.HoaDon;

public class frm_TK extends frm_default implements ActionListener, MouseListener {

	private DefaultTableModel modeltb;
	private JTable table;
	private JDateChooser date1;
	private JLabel ttTKK;
	private JLabel dt1;
	private JLabel dt2;
	private JDateChooser date2;
	private JButton btk1;
	private JButton btk2;
	private JButton btk3;
	private JButton btk4;
	private JButton btk5;
	private JLabel tongDon;
	private JLabel tongThu;
	private JTextField txtTot1;
	private JTextField txtTot2;
	
	private quanLiHD dsHD;
	
	public frm_TK() {
		super();
//		jlTitle.setText("Quản lí khách hàng");
//		jpCen.setBackground(Color.LIGHT_GRAY);
		JPanel contain = new JPanel(new BorderLayout());
//		Box contain;
		Box bTTSP, tables ;
		
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
		JPanel ttTK = new JPanel();
		ttTK.setLayout(new BoxLayout(ttTK, BoxLayout.Y_AXIS));
		ttTK.setPreferredSize(new Dimension(750,150));
		ttTK.setMaximumSize(new Dimension(750,150));
		ttTK.add(ttTKK = new JLabel("THỐNG KÊ DOANH THU"));
		ttTK.setBorder(BorderFactory.createEmptyBorder(60,150,0,0));
		ttTKK.setFont(new Font("Arial",Font.BOLD,35));
		
       
        
        //Tìm kiếm
        JPanel tVUTK = new JPanel();
//        searchPanel.setBorder(BorderFactory.createTitledBorder("Tìm khách hàng"));
        tVUTK.setLayout(new BoxLayout(tVUTK, BoxLayout.Y_AXIS));
        tVUTK.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createLineBorder(new Color(163, 184, 204),2),"Tác vụ"));
        tVUTK.setPreferredSize(new Dimension(850,150));
        tVUTK.setMaximumSize(new Dimension(850,150));
       
        
        JPanel sBTK1 = new JPanel();
        sBTK1.setLayout(new BoxLayout(sBTK1, BoxLayout.X_AXIS));
        sBTK1.setPreferredSize(new Dimension(800,60));
        sBTK1.setMaximumSize(new Dimension(800,60));
        sBTK1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        sBTK1.add(Box.createHorizontalStrut(60));
        sBTK1.add(dt1 = new JLabel("Từ ngày: "));
        sBTK1.add(Box.createHorizontalStrut(15));
        sBTK1.add(date1 = new JDateChooser());
        sBTK1.add(Box.createHorizontalStrut(50));
        sBTK1.add(dt2 = new JLabel("Đến ngày: "));
        sBTK1.add(Box.createHorizontalStrut(15));
        sBTK1.add(date2 = new JDateChooser());
        sBTK1.add(Box.createHorizontalStrut(5));

        
        JPanel sBT = new JPanel();
        sBT.setLayout(new BoxLayout(sBT, BoxLayout.X_AXIS));
        sBT.setPreferredSize(new Dimension(800,30));
        sBT.setMaximumSize(new Dimension(800,40));
        sBT.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        sBT.add(Box.createHorizontalStrut(60));
        sBT.add(btk2= new JButton("Xem thống kê"));
        sBT.add(Box.createHorizontalStrut(5));
        sBT.add(btk3 = new JButton("Xem chi tiết"));
        sBT.add(Box.createHorizontalStrut(5));
        sBT.add(btk4= new JButton("In thống kê"));
        sBT.add(Box.createHorizontalStrut(5));
        sBT.add(btk1 = new JButton("Hủy"));
        sBT.add(Box.createHorizontalStrut(5));
        
        //Color for Button
        btk1.setBackground(new Color(255,0,0));
        btk1.setForeground(Color.white);
        btk1.setFont(new Font("Arial", Font.BOLD, 14));
        
        btk2.setBackground(new Color(3, 59, 90));
        btk2.setForeground(Color.white);
        btk2.setFont(new Font("Arial", Font.BOLD, 14));
        
        btk3.setBackground(new Color(3, 59, 90));
        btk3.setForeground(Color.white);
        btk3.setFont(new Font("Arial", Font.BOLD, 14));
        
        btk4.setBackground(new Color(3, 59, 90));
        btk4.setForeground(Color.white);
        btk4.setFont(new Font("Arial", Font.BOLD, 14));
        
        btk2.setBackground(new Color(3, 59, 90));
        btk2.setForeground(Color.white);
        btk2.setFont(new Font("Arial", Font.BOLD, 14));
        //Size Button
        btk1.setPreferredSize(new Dimension(160,30));
        btk1.setMaximumSize(new Dimension(160,30));
        btk2.setPreferredSize(new Dimension(160,30));
        btk2.setMaximumSize(new Dimension(160,30));
        btk3.setPreferredSize(new Dimension(155,30));
        btk3.setMaximumSize(new Dimension(155,30));
        btk4.setPreferredSize(new Dimension(155,30));
        btk4.setMaximumSize(new Dimension(155,30));
        
        //Size Text Field
        
        date1.setPreferredSize(new Dimension(200,25));
        date1.setMaximumSize(new Dimension(200,25));
        
        date2.setPreferredSize(new Dimension(200,25));
        date2.setMaximumSize(new Dimension(200,25));
        
        date1.setDateFormatString("yyyy/MM/dd");
        date2.setDateFormatString("yyyy/MM/dd");
        
        //Size label
        
        dt1.setFont(new Font("Time new roman", Font.PLAIN,18));
        dt2.setFont(new Font("Time new roman", Font.PLAIN,18));
        
        
        tVUTK.add(Box.createVerticalStrut(5));
        tVUTK.add(sBTK1);
        tVUTK.add(sBT);
        
        //Table
        tables = Box.createHorizontalBox();
		tables.setPreferredSize(new Dimension(1500,80));
		tables.setMaximumSize(new Dimension(1500,80));
		tables.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
		
        modeltb = new DefaultTableModel(new String[] {"Mã Hoá Đơn","Tên Khách Hàng","Tên Nhân Viên","Ngày Lập","Tổng tiền"},0);
		table = new JTable(modeltb);
		table.addMouseListener(this);
		JScrollPane jS = new JScrollPane(table);
		tables.add(jS);
		jS.setBorder(BorderFactory.createLineBorder(new Color(163, 184, 204), 2));
//		Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
		
		JPanel total = new JPanel();
		total.setLayout(new BoxLayout(total, BoxLayout.X_AXIS));
        total.setPreferredSize(new Dimension(1530,150));
        total.setMaximumSize(new Dimension(1530,150));
        total.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        
		
		
        JPanel tongKet = new JPanel();
        tongKet.setLayout(new BoxLayout(tongKet, BoxLayout.X_AXIS));
        tongKet.setPreferredSize(new Dimension(1530,150));
        tongKet.setMaximumSize(new Dimension(1530,150));
        tongKet.setBorder(BorderFactory.createLineBorder(new Color(163, 184, 204),2));
        
        tongKet.add(Box.createHorizontalStrut(750));
        tongKet.add(tongDon = new JLabel("Tổng đơn hàng: "));
        tongKet.add(Box.createHorizontalStrut(10));
        tongKet.add(txtTot1 = new JTextField());
        tongKet.add(Box.createHorizontalStrut(10));
        tongKet.add(tongThu = new JLabel("Tổng doanh thu:"));
        tongKet.add(Box.createHorizontalStrut(10));
        tongKet.add(txtTot2 = new JTextField());
        
        
        //set TextField
        txtTot1.setPreferredSize(new Dimension(200,25));
        txtTot1.setMaximumSize(new Dimension(200,25));
        txtTot2.setPreferredSize(new Dimension(200,25));
        txtTot2.setMaximumSize(new Dimension(200,25));;
        txtTot1.setEditable(false);
        txtTot1.setFont(new Font("Time New Roman", Font.BOLD,22));
        txtTot1.setForeground(Color.RED);
        txtTot1.setBorder(null);
        txtTot2.setEditable(false);
        txtTot2.setFont(new Font("Time New Roman", Font.BOLD,22));
        txtTot2.setForeground(Color.RED);
        txtTot2.setBorder(null);
        
        //set Label
        tongDon.setFont(new Font("Time New Roman",Font.BOLD,22));
        tongThu.setFont(new Font("Time New Roman",Font.BOLD,22));
//        tongDon.setPreferredSize(new Dimension(160,25));
//        tongDon.setMaximumSize(new Dimension(160,25));;
//        tongThu.setPreferredSize(new Dimension(200,25));
//        tongThu.setMaximumSize(new Dimension(200,25));;
        
        total.add(tongKet);
        
        bTTSP.add(ttTK);
        bTTSP.add(Box.createRigidArea(new Dimension(10,0)));
        bTTSP.add(tVUTK);
        contain.add(bTTSP,BorderLayout.NORTH);
        contain.add(tables,BorderLayout.CENTER);
        contain.add(total,BorderLayout.SOUTH);		
		//jpCen 
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		jpCen.add(contain);
		setVisible(true);
		
		//add actionlistener
		btk1.addActionListener(this);
		btk2.addActionListener(this);
		btk3.addActionListener(this);
		btk4.addActionListener(this);
		
		
		
		//Connect 
		ConnectDB.getInstance().connect();
        dsHD= new quanLiHD();
		loadDataTable();
	}
	public static void main(String[] args) {
		frm_TK frmkh = new frm_TK();
	}
	
	public void loadDataTable() {
	    System.out.println("Loading...");
	    modeltb.setRowCount(0);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
	    DecimalFormat decimalFormat = new DecimalFormat("#,###");
	    int soHD = 0;
	    double tong = 0.0;
	    for (HoaDon h : dsHD.getallHoaDon()) {
	        String formattedDate = "";
	        if (h.getNgayLap() != null) {
	            Date date = java.sql.Date.valueOf(h.getNgayLap());
	            formattedDate = dateFormat.format(date);
	        }

	        Object[] row = new Object[] {
	            h.getMaHoaDon(),
	            h.getKhachhang().getTenKH(),
	            h.getNhanvien().getTenNV(),
	            formattedDate,
	            decimalFormat.format(h.getTongTien()) + " VNĐ"
	        };
	        modeltb.addRow(row);
	        tong += h.getTongTien();
	        soHD++;
	    }
	    txtTot1.setText(decimalFormat.format(soHD));
	    txtTot2.setText(decimalFormat.format(tong) + " VNĐ");
	    modeltb.fireTableDataChanged();
	}

	
	//Gán danh sách từ sql
	public void loadData() {
//		dsHD = new quanLiHD();
		dsHD.setListHoaDon(dsHD.getallHoaDon());
	}
	
	private void updateTableData(ArrayList<HoaDon> dsHoaDon) {
	    modeltb.setRowCount(0);  // Xóa dữ liệu hiện tại trong bảng
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    DecimalFormat decimalFormat = new DecimalFormat("#,###");
	    int soHD = 0;
	    double thuNhap = 0;

	    for (HoaDon h : dsHoaDon) {
	        String formattedDate = (h.getNgayLap() != null) ? dateFormat.format(java.sql.Date.valueOf(h.getNgayLap())) : "";
	        Object[] row = new Object[] {
	        		h.getMaHoaDon(),
	 	            h.getKhachhang().getTenKH(),
	 	            h.getNhanvien().getTenNV(),
	 	            formattedDate,
	 	            decimalFormat.format(h.getTongTien()) + " VNĐ"
	        };
	        modeltb.addRow(row);
	        thuNhap += h.getTongTien();
	        soHD ++;
	    }
	    txtTot1.setText(decimalFormat.format(soHD));
	    txtTot2.setText(decimalFormat.format(thuNhap) + " VNĐ");
	    modeltb.fireTableDataChanged();  // Cập nhật bảng sau khi thêm dữ liệu mới
	}
	
	
	
	public void actionPerformed (ActionEvent e) {
		super.actionPerformed(e);
		var obj = e.getSource();
		if(obj.equals(btk1)) {
			date1.setDate(null);
			date2.setDate(null);
			loadData();
			loadDataTable();
		}
		else if (obj.equals(btk2)) {
		    // Kiểm tra xem người dùng có chọn ngày chưa
		    if (date1.getDate() == null || date2.getDate() == null) {
		        JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày để xem thống kê");
		        return;
		    }

		    // Chuyển đổi từ Date (JCalendar) sang String (định dạng yyyy-MM-dd)
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    String from = format.format(date1.getDate());
		    String to = format.format(date2.getDate());

		    // Chuyển đổi sang LocalDate để kiểm tra thứ tự ngày
		    LocalDate localFrom = LocalDate.parse(from);
		    LocalDate localTo = LocalDate.parse(to);

		    // Kiểm tra nếu ngày "from" sau ngày "to"
		    if (localFrom.isAfter(localTo)) {
		        JOptionPane.showMessageDialog(this, "Chọn ngày không hợp lệ");
		        return;
		    }

		    // Lấy danh sách hóa đơn trong khoảng thời gian từ ngày "from" đến "to"
		    ArrayList<HoaDon> hoaDons = dsHD.getAllHoaDonFromDateToDate(from, to);
		    
		    // Kiểm tra nếu không có hóa đơn nào trong khoảng thời gian này
		    if (hoaDons.isEmpty()) {
		        JOptionPane.showMessageDialog(this, "Không có hóa đơn trong khoảng thời gian này");
		        return;
		    }

		    // Cập nhật danh sách hóa đơn
		    dsHD.setListHoaDon(hoaDons);
		    
		    // Cập nhật dữ liệu bảng
		    updateTableData(dsHD.getDSHoaDon());

		    // Làm mới bảng dữ liệu
		    modeltb.fireTableDataChanged();
		}
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
