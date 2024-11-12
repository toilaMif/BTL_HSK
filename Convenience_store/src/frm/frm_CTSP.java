package frm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;

import controller.ConnectDB;
import entity.SanPham;

public class frm_CTSP extends JFrame implements ActionListener{

	private JButton jbtXoaRong;
	private JButton jbtThoat;
	private JButton jbtLuu;
	private JPanel jpennut;
	private JPanel jpSP;
	private JPanel jpsp1;
	private JPanel jpsp3;
	private JPanel jpsp2;
	private JPanel jpIMGSP;
	private JTextField jtfDongia;
	private JTextField jtfMasp;
	private JTextField jtfTensp;
	private JTextField jtfsp;
	private JTextField jtfSoluongsp;
	private JTextField jtfXXsp;
	private JTextField jtfThuonghieusp;
	private JTextField jtfMota;
	private JTextField jtfNXX;
	private JPanel jpgia;
	private JTextField jtfgiaNhap;
	private JTextField jtfgiakm;
	private JTextField jtfNgayNhapsp;
	private JTextField jtfNgaySXsp;
	private JLabel jlngayconlai;
	private JLabel jlANH;
	private String maSPCHON;

	public frm_CTSP(String maSPCHON) {
        this.maSPCHON = maSPCHON;
        initialize();
    }
	private void initialize() {
		
		setTitle("Chi Tiết Sản Phẩm");
		setSize(500, 600);
		setLocationRelativeTo(null);
		setResizable(false);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jpSP = new JPanel(new BorderLayout());
		jpSP.setBorder(new EmptyBorder(20, 30, 20, 30));

		jpsp1 = new JPanel(new BorderLayout());

		jpIMGSP = new JPanel(new BorderLayout());
		jpIMGSP.setPreferredSize(new Dimension(150, 150));
		jpIMGSP.setBorder(BorderFactory.createTitledBorder("Ảnh Sản Phẩm"));
		jlANH = new JLabel();
		try {
			ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/imgSP/" + maSPCHON + ".png"));
			Image img = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);

			jlANH.setIcon(new ImageIcon(img));
		} catch (Exception e) {
			jlANH.setText("Không tìm thấy ảnh");
			jlANH.setHorizontalAlignment(JLabel.CENTER);
		}

		jpIMGSP.add(jlANH, BorderLayout.CENTER);
		jpIMGSP.revalidate();
		jpIMGSP.repaint();

		jtfDongia = new JTextField();
		jtfDongia.setHorizontalAlignment(SwingConstants.CENTER);
		jtfDongia.setBackground(null);
		jtfDongia.setBorder(new EmptyBorder(10, 5, 5, 5));

		jpsp1.add(jpIMGSP, BorderLayout.CENTER);
		jpsp1.add(jtfDongia, BorderLayout.SOUTH);

		jpsp2 = new JPanel(new GridLayout(9, 1));

		jtfMasp = new JTextField();
		jtfMasp.setPreferredSize(new Dimension(250, 5));
		jtfMasp.setBorder(new EmptyBorder(5, 5, 5, 5));
		jtfMasp.setBackground(null);

		jtfTensp = new JTextField();
		jtfTensp.setBorder(new EmptyBorder(5, 5, 5, 5));
		jtfTensp.setBackground(null);

		jtfsp = new JTextField();
		jtfsp.setBorder(new EmptyBorder(5, 5, 5, 5));
		jtfsp.setBackground(null);

		jtfSoluongsp = new JTextField();
		jtfSoluongsp.setBorder(new EmptyBorder(5, 5, 5, 5));
		jtfSoluongsp.setBackground(null);

		jtfXXsp = new JTextField();
		jtfXXsp.setBorder(new EmptyBorder(5, 5, 5, 5));
		jtfXXsp.setBackground(null);

		jtfThuonghieusp = new JTextField();
		jtfThuonghieusp.setBorder(new EmptyBorder(5, 5, 5, 5));
		jtfThuonghieusp.setBackground(null);

		jtfNgayNhapsp = new JTextField();
		jtfNgayNhapsp.setBorder(new EmptyBorder(5, 5, 5, 5));
		jtfNgayNhapsp.setBackground(null);

		jtfNgaySXsp = new JTextField();
		jtfNgaySXsp.setBorder(new EmptyBorder(5, 5, 5, 5));
		jtfNgaySXsp.setBackground(null);

		JLabel jlngayconlai = new JLabel("ngày hết hạn", SwingConstants.CENTER);
		jlngayconlai.setForeground(Color.RED);

		jpsp2.add(jtfMasp);
		jpsp2.add(jtfTensp);
		jpsp2.add(jtfsp);
		jpsp2.add(jtfSoluongsp);
		jpsp2.add(jtfXXsp);
		jpsp2.add(jtfThuonghieusp);
		jpsp2.add(jtfNgayNhapsp);
		jpsp2.add(jtfNgaySXsp);
		jpsp2.add(jlngayconlai);

		jpsp3 = new JPanel(new BorderLayout());
		jpsp3.setBorder(new EmptyBorder(5, 0, 5, 0));

		jtfMota = new JTextField();
		jtfMota.setPreferredSize(new Dimension(0, 150));
		jtfMota.setBackground(null);

		jtfNXX = new JTextField();
		jtfNXX.setPreferredSize(new Dimension(150, 50));
		jtfNXX.setBackground(null);

		jpgia = new JPanel();

		jtfgiaNhap = new JTextField();
		jtfgiaNhap.setPreferredSize(new Dimension(150, 20));
		jtfgiaNhap.setBackground(null);

		jtfgiakm = new JTextField();
		jtfgiakm.setPreferredSize(new Dimension(150, 20));
		jtfgiakm.setBackground(null);
		jpgia.add(jtfgiaNhap);
		jpgia.add(jtfgiakm);

		jpsp3.add(jpgia, BorderLayout.SOUTH);
		jpsp3.add(jtfMota, BorderLayout.CENTER);
		jpsp3.add(jtfNXX, BorderLayout.NORTH);

		jpennut = new JPanel();
		jpennut.setBorder(BorderFactory.createTitledBorder("Thao tác"));

		jbtLuu = new JButton("Lưu");
		jbtLuu.setBackground(Color.GREEN);
		jbtXoaRong = new JButton("Xóa Rỗng");
		jbtThoat = new JButton("Thoát");
		jbtThoat.setBackground(Color.red);

		jpennut.add(jbtLuu);
		jpennut.add(jbtXoaRong);
		jpennut.add(jbtThoat);

		jpSP.add(jpsp1, BorderLayout.CENTER);
		jpSP.add(jpsp2, BorderLayout.EAST);
		jpSP.add(jpsp3, BorderLayout.SOUTH);

		add(jpSP, BorderLayout.CENTER);
		add(jpennut, BorderLayout.SOUTH);

		TimMA("{CALL TimKiemMA(?)}", maSPCHON);
		
		
		if(TinhNgayHetHan("{CALL TinhNgayHetHan(?)}", maSPCHON)>0) {
			jlngayconlai.setForeground(Color.GREEN);
			jlngayconlai.setText("Còn " + TinhNgayHetHan("{CALL TinhNgayHetHan(?)}", maSPCHON) + " ngày nữa hết hạn");
        	
        	
        }else {
        	jlngayconlai.setText("Sản phẩm đã hết hạn");
        }
		hienday(maSPCHON);
		hiengia(maSPCHON);
		
		jbtLuu.addActionListener(this);
		jbtThoat.addActionListener(this);
		jbtXoaRong.addActionListener(this);
		setVisible(true);
	}

	Integer TinhNgayHetHan(String callStore, String ma) {
	    String storedProcedureCall = callStore;
	    
	    int ngay=0;

	    try {
	        ConnectDB.getInstance().connect();
	        Connection con = ConnectDB.getConnection();

	        CallableStatement callableStatement = con.prepareCall(storedProcedureCall);
	        callableStatement.setString(1, ma);  

	        callableStatement.execute();

	        ResultSet rs = callableStatement.getResultSet();
	        if (rs.next()) {
	            ngay = rs.getInt("SoNgayConLai");  
	        }
	        
	        

	        rs.close();
	        callableStatement.close();
	        con.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return ngay;  
	}

	void hienday(String ma) {
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DaySanPham where maSP = '" +ma +"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        
	        
			while (rs.next()) {
	            java.sql.Date ngayNhap = rs.getDate("ngayNhap");
	            String formattedNgayNhap = sdf.format(ngayNhap);
	            jtfNgayNhapsp.setText(formattedNgayNhap);

	            java.sql.Date ngaySX = rs.getDate("ngaySanXuat");
	            String formattedNgaySX = sdf.format(ngaySX);
	            
	            java.sql.Date ngayHH = rs.getDate("ngayHetHan");
	            String formattedNgayHH = sdf.format(ngayHH);
	            jtfNgaySXsp.setText(formattedNgaySX+" - "+formattedNgayHH);
	            jtfNgaySXsp.setRequestFocusEnabled(false);
			}
			rs.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	void hiengia(String ma) {
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DonGia where maSP = '" +ma +"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
	        
	        
			while (rs.next()) {
	            jtfgiaNhap.setText("Giá Nhập: " + rs.getDouble("donGiaNhap")+"");
	            jtfgiaNhap.setRequestFocusEnabled(false);
			}
			rs.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	void TimMA(String callStore, String ma) {
//		String storedProcedureCall = "{CALL GetSanPhamSorted(?)}";
		String storedProcedureCall = callStore;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			CallableStatement callableStatement = con.prepareCall(storedProcedureCall);

			callableStatement.setString(1, ma);

			ResultSet rs = callableStatement.executeQuery();
			while (rs.next()) {
				jtfMasp.setText(rs.getString(1));
				jtfTensp.setText(rs.getString(2));
				jtfsp.setText(rs.getString(3));
				jtfSoluongsp.setText(rs.getString(4));
				jtfXXsp.setText(rs.getString(5));
				jtfThuonghieusp.setText(rs.getString(6));
				jtfDongia.setText(rs.getString(9));
				jtfNXX.setText(rs.getString(8));
				jtfMota.setText(rs.getString(7));

			}

			rs.close();
			callableStatement.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		frm_CTSP tr = new frm_CTSP("SP0001");
		
			
		

	}
	void xoaRong() {
		jtfMasp.setText("");
		jtfTensp.setText("");
		jtfsp.setText("");
		jtfSoluongsp.setText("");
		jtfXXsp.setText("");
		jtfThuonghieusp.setText("");
		jtfDongia.setText("");
		jtfNXX.setText("");
		jtfMota.setText("");
		jlANH.setIcon(new ImageIcon());
		jtfgiaNhap.setText("");
		jtfgiakm.setText("");
		jtfNgayNhapsp.setText("");
		jtfNgaySXsp.setText("");
	}
	void luu (String callStore, String ma) {
		String storedProcedureCall = callStore;
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection();

			CallableStatement callableStatement = con.prepareCall(storedProcedureCall);
			
			

			String tenSP = jtfTensp.getText();
			String loaiSP = jtfsp.getText();
			int soLuong = Integer.parseInt(jtfSoluongsp.getText());
			String xuatXu = jtfXXsp.getText();
			String thuongHieu = jtfThuonghieusp.getText();
			float donGia = Float.parseFloat(jtfDongia.getText());
			String nhaSanXuat = jtfNXX.getText();
			String moTa = jtfMota.getText();
			float giaKM = Float.parseFloat(jtfgiakm.getText());
			try {
			    String dayNhap = jtfNgayNhapsp.getText();  
			    
			    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			    java.util.Date utilNgayNhap = sdf.parse(dayNhap);

			    callableStatement.setDate(10, new java.sql.Date(utilNgayNhap.getTime()));

			} catch (ParseException e) {
			    e.printStackTrace();  
			} catch (SQLException e) {
			    e.printStackTrace();  
			}
	        
			
			
			callableStatement.setString(1, ma);
			callableStatement.setString(2, tenSP);
	        callableStatement.setString(3, loaiSP);
	        callableStatement.setInt(4, soLuong);
	        callableStatement.setString(5, xuatXu);
	        callableStatement.setString(6, thuongHieu);
	        callableStatement.setString(7, moTa);
	        callableStatement.setString(8, nhaSanXuat);
	        callableStatement.setFloat(9, donGia);
	        callableStatement.setFloat(11, donGia);
	        callableStatement.setFloat(12, giaKM);
			

	        callableStatement.execute();
	        
			callableStatement.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(jbtLuu)) {
			luu("{CALL SuaSanPham(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}", maSPCHON);
		}else if(e.getSource().equals(jbtThoat)) {
			this.dispose();
			
		}else if(e.getSource().equals(jbtXoaRong)){
			xoaRong();
		}
		
	}

}
