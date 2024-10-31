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
import javax.swing.text.html.StyleSheet.BoxPainter;

public class frm_HoaDon extends frm_default {

	private DefaultTableModel modeltb;
	private JTable table;
	private JRadioButton rd1;
	private JTextField tfB1;
	
	public frm_HoaDon() {
		super();
//		jlTitle.setText("Quản lí khách hàng");
//		jpCen.setBackground(Color.LIGHT_GRAY);
		JPanel contain = new JPanel(new BorderLayout());
//		Box contain;
		Box bTTSP, tables , space;
		
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
		JPanel sortPanel = new JPanel(new GridLayout(2,3,5,5 ));
//        sortPanel.setBorder(BorderFactory.createTitledBorder("Sắp xếp danh sách khách hàng"));
		sortPanel.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createLineBorder(Color.RED),"Sắp xếp danh sách hóa đơn"));
		sortPanel.setPreferredSize(new Dimension(700,150));
		sortPanel.setMaximumSize(new Dimension(700,150));
        JRadioButton sortByFuture = new JRadioButton("Theo ngày lập tăng dần");
        JRadioButton sortByPast = new JRadioButton("Theo ngày lập giảm dần");
        JRadioButton sortByIDAsc = new JRadioButton("Theo mã hóa đơn tăng dần");
        JRadioButton sortByIDDesc = new JRadioButton("Theo mã hóa đơn giảm dần");
        JRadioButton sortByMoneyAsc = new JRadioButton("Theo tổng tiền tăng dần");
        JRadioButton sortByMoneyDesc = new JRadioButton("Theo tổng tiền giảm dần");
		
        ButtonGroup sortGroup = new ButtonGroup();
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
	            BorderFactory.createLineBorder(Color.RED),"Tìm khách hàng"));
        searchPanelB.setPreferredSize(new Dimension(850,150));
        searchPanelB.setMaximumSize(new Dimension(850,150));
        searchPanelB.setLayout(new BoxLayout(searchPanelB, BoxLayout.Y_AXIS));
        
        JPanel sB1 = new JPanel();
        sB1.setLayout(new BoxLayout(sB1, BoxLayout.X_AXIS));
        sB1.add(rd1 = new JRadioButton("Tìm mã theo hóa đơn: "));
        sB1.add(Box.createHorizontalStrut(10));
        sB1.add(tfB1 = new JTextField());
        
        
        
        


        
        //Table
        tables = Box.createHorizontalBox();
		tables.setPreferredSize(new Dimension(1500,100));
		tables.setMaximumSize(new Dimension(1500,100));
		tables.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        
		
        modeltb = new DefaultTableModel(new String[] {"Mã Khách Hàng","Họ Tên","Ngày sinh","Giới tính","Loại thành viên"},0);
		table = new JTable(modeltb);
		table.addMouseListener(this);
		JScrollPane jS = new JScrollPane(table);
		tables.add(jS);
		jS.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
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
	}
	public static void main(String[] args) {
		frm_HoaDon frmkh = new frm_HoaDon();
	}
	
}
