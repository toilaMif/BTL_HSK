package frm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import controller.ConnectDB;
import dao.Account_Dao;
import entity.Account;

public class dangKy_page extends JFrame implements ActionListener, MouseListener {
    protected JLabel lDangNhap, l_ten_dang_ky, l_password, imgLabel, l_password2;
    protected JTextField txtTenDangKy;
    protected JPasswordField txtPassword, txtPassword2; // Changed to JPasswordField
    protected JButton btnDangKy;
    protected JPanel pWest, pEast;
    protected Account_Dao listTK;
    protected ArrayList<Account> listAccount;

    public dangKy_page() {
        ConnectDB.getInstance().connect();
        
        setTitle("Cửa hàng tiện lợi");
        listTK = new Account_Dao();
        listAccount = listTK.getAllAccount();

        // Left panel with image
        pWest = new JPanel();
        pWest.setPreferredSize(new Dimension(600, 500));
        pWest.setLayout(new GridBagLayout());
        GridBagConstraints gbcL = new GridBagConstraints();
        gbcL.anchor = GridBagConstraints.CENTER;
        imgLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/image/Logo.jpg"));
        Image img = imageIcon.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        imgLabel.setIcon(new ImageIcon(img));
        pWest.add(imgLabel, gbcL);
        add(pWest, BorderLayout.WEST);

        // Right panel with registration form
        pEast = new JPanel();
        pEast.setPreferredSize(new Dimension(400, 500));
        pEast.setLayout(new GridBagLayout());
        GridBagConstraints gbcR = new GridBagConstraints();
        gbcR.anchor = GridBagConstraints.CENTER;
        gbcR.insets = new Insets(7, 7, 7, 7);
        gbcR.gridwidth = GridBagConstraints.REMAINDER;

        lDangNhap = new JLabel("ĐĂNG KÝ");
        lDangNhap.setForeground(new Color(123, 142, 218));
        lDangNhap.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        pEast.add(lDangNhap, gbcR);

        l_ten_dang_ky = new JLabel("Tên đăng ký");
        gbcR.anchor = GridBagConstraints.WEST;
        gbcR.gridy = 1;
        pEast.add(l_ten_dang_ky, gbcR);

        txtTenDangKy = new JTextField(30);
        txtTenDangKy.setBorder(null);
        gbcR.gridy = 2;
        pEast.add(txtTenDangKy, gbcR);

        l_password = new JLabel("Mật khẩu");
        gbcR.gridy = 3;
        pEast.add(l_password, gbcR);

        txtPassword = new JPasswordField(30); // Changed to JPasswordField
        txtPassword.setBorder(null);
        gbcR.gridy = 4;
        pEast.add(txtPassword, gbcR);

        l_password2 = new JLabel("Nhập lại mật khẩu");
        gbcR.gridy = 5;
        pEast.add(l_password2, gbcR);

        txtPassword2 = new JPasswordField(30); // Changed to JPasswordField
        txtPassword2.setBorder(null);
        gbcR.gridy = 6;
        pEast.add(txtPassword2, gbcR);

        pEast.setBackground(new Color(222, 227, 247));

        btnDangKy = new JButton("Đăng Ký");
        btnDangKy.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnDangKy.setForeground(Color.WHITE);
        btnDangKy.setBackground(new Color(123, 142, 218));
        gbcR.gridy = 7;
        pEast.add(btnDangKy, gbcR);
        add(pEast, BorderLayout.EAST);

        btnDangKy.addActionListener(this);

        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new dangKy_page();
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {}
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {}
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {}
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {}
    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDangKy) {
            String tenDangKy = txtTenDangKy.getText();
            String matKhau = new String(txtPassword.getPassword()); // Use getPassword() for JPasswordField
            String matKhau2 = new String(txtPassword2.getPassword()); // Use getPassword() for JPasswordField

            // Validate input fields
            if (tenDangKy.isEmpty() || matKhau.isEmpty() || matKhau2.isEmpty()) {
                System.out.println("Vui lòng điền vào tất cả các trường.");
                return;
            }
            if (!matKhau.equals(matKhau2)) {
                System.out.println("Mật khẩu không khớp.");
                return;
            }
            Account newAccount = new Account(generateMaTK(), tenDangKy, matKhau);
            if (listTK.createAccount(newAccount) && listAccount.add(newAccount)) {
                System.out.println("Đăng ký thành công!");
                setVisible(false);
                new login_page().setVisible(true);
            } else {
                System.out.println("Đăng ký thất bại. Vui lòng thử lại.");
            }
        }
    }

    private String generateMaTK() {
        return listAccount.size() + 1 + "";  
    }
}
