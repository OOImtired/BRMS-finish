package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import dao.AdminLoginDao;
import model.Admin;
import util.IOAdminLoginUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLoginView extends JFrame {

	private JPanel contentPane;
	private JTextField adminNameTextField;
	private JPasswordField adminPasswordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginView frame = new AdminLoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLoginView() {
		setTitle("管理员端");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 331);
		
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel adminLoginLabel = new JLabel("管理端登录");
		adminLoginLabel.setFont(new Font("新宋体", Font.BOLD, 26));
		adminLoginLabel.setBounds(225, 24, 138, 41);
		contentPane.add(adminLoginLabel);
		
		JLabel adminNameLabel = new JLabel("用户名：");
		adminNameLabel.setFont(new Font("新宋体", Font.PLAIN, 24));
		adminNameLabel.setBounds(135, 111, 96, 28);
		contentPane.add(adminNameLabel);
		
		JLabel adminPasswordLabel = new JLabel("密  码：");
		adminPasswordLabel.setFont(new Font("新宋体", Font.PLAIN, 24));
		adminPasswordLabel.setBounds(135, 165, 96, 28);
		contentPane.add(adminPasswordLabel);
		
		adminNameTextField = new JTextField();
		adminNameTextField.setBounds(241, 111, 195, 28);
		contentPane.add(adminNameTextField);
		adminNameTextField.setColumns(10);
		
		adminPasswordTextField = new JPasswordField();
		adminPasswordTextField.setBounds(241, 165, 195, 28);
		adminPasswordTextField.setEchoChar('●');
		contentPane.add(adminPasswordTextField);
		adminPasswordTextField.setColumns(10);
		
		JButton adminRegistButton = new JButton("注册");
		adminRegistButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLoginView.this.setVisible(false);
				new AdminRegistView().setVisible(true);
			}
		});
		adminRegistButton.setFont(new Font("新宋体", Font.PLAIN, 12));
		adminRegistButton.setBounds(149, 236, 97, 23);
		contentPane.add(adminRegistButton);
		
		JButton adminLoginButton = new JButton("登录");
		adminLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String adminName=adminNameTextField.getText();
				String adminPassword=adminPasswordTextField.getText();
				Admin admin=new Admin();
				IOAdminLoginUtil util = new IOAdminLoginUtil();
				if(util.login(adminName, adminPassword)==true) {
					JOptionPane.showMessageDialog(null, "登录成功！");
					AdminLoginView.this.setVisible(false);
					new AdminMainView().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误！");
				}
			}
		});
		adminLoginButton.setFont(new Font("新宋体", Font.PLAIN, 12));
		adminLoginButton.setBounds(360, 236, 97, 23);
		contentPane.add(adminLoginButton);
	}
}
