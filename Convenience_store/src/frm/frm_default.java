package frm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class frm_default extends JFrame implements ActionListener, MouseListener {

	private JPanel jpCen;
	private JPanel jpMenu;
	private JMenuBar jMenu;
	private Object jmnNV;
	private JMenuBar mnubar;
	private JMenu mnuFile;
	private JMenu mnuEdit;
	private JMenu mnuHelp;
	

	 

	public frm_default() {
		super("Cửa Hàng Tiện Lợi");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jpCen = new JPanel();
		jpCen.setLayout(new BorderLayout());
		jpCen.setBackground(Color.black);

		jpMenu = new JPanel();
		jpMenu.setBackground(Color.WHITE);
		
		mnubar = new JMenuBar();
		

		mnuFile = new JMenu("File");     mnubar.add(mnuFile);		
		mnuEdit = new JMenu("Edit");    mnubar.add(mnuEdit);
		mnuHelp = new JMenu("Help");  mnubar.add(mnuHelp);

		jpMenu.add(mnubar);
		jpCen.add(jpMenu, BorderLayout.NORTH);
		
		setContentPane(jpCen);
		
		setVisible(true);

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
