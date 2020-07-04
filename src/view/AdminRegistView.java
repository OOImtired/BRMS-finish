package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.AdminRegistDao;
import model.Register;
import util.IOAdminLoginUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AdminRegistView extends JFrame {

	private JPanel contentPane;
	private JTextField aRUserNameField;
	private JTextField aRPasswordField;
	private JLabel verificationCodeLabel;
	private JTextField verificationCodeTextField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegistView frame = new AdminRegistView();
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
	public AdminRegistView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 320);
		
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel adminPRLabel = new JLabel("请注册");
		adminPRLabel.setFont(new Font("新宋体", Font.BOLD, 30));
		adminPRLabel.setBounds(192, 10, 100, 51);
		contentPane.add(adminPRLabel);
		
		JLabel aRUserNameLabel = new JLabel("用户名：");
		aRUserNameLabel.setFont(new Font("新宋体", Font.PLAIN, 16));
		aRUserNameLabel.setBounds(110, 97, 68, 19);
		contentPane.add(aRUserNameLabel);
		
		JLabel aRPasswordLabel = new JLabel("密  码：");
		aRPasswordLabel.setFont(new Font("新宋体", Font.PLAIN, 16));
		aRPasswordLabel.setBounds(110, 149, 68, 19);
		contentPane.add(aRPasswordLabel);
		
		aRUserNameField = new JTextField();
		aRUserNameField.setBounds(223, 97, 147, 21);
		contentPane.add(aRUserNameField);
		aRUserNameField.setColumns(10);
		
		aRPasswordField = new JTextField();
		aRPasswordField.setBounds(223, 149, 147, 21);
		contentPane.add(aRPasswordField);
		aRPasswordField.setColumns(10);
		
		verificationCodeLabel = new JLabel("验证码：");
		verificationCodeLabel.setFont(new Font("新宋体", Font.PLAIN, 16));
		verificationCodeLabel.setBounds(110, 205, 68, 19);
		contentPane.add(verificationCodeLabel);
		
		verificationCodeTextField = new JTextField();
		verificationCodeTextField.setBounds(223, 205, 147, 21);
		contentPane.add(verificationCodeTextField);
		verificationCodeTextField.setColumns(10);
		
		btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register = new Register();
				String aRUserName=aRUserNameField.getText();
				String aRPassword=aRPasswordField.getText();
				String verificationCode=verificationCodeTextField.getText();
				IOAdminLoginUtil util = new IOAdminLoginUtil();
				if(aRUserName.isEmpty()) {
					JOptionPane.showMessageDialog(null, "用户名不能为空！");
				}else if(aRPassword.isEmpty()) {
					JOptionPane.showMessageDialog(null, "密码不能为空！");
				}else if(verificationCode.isEmpty()){
					JOptionPane.showMessageDialog(null, "请输入验证码！");
				}else {
					if(!verificationCode.equals("admin")) {
						JOptionPane.showMessageDialog(null, "验证码错误，请重新输入！");
						verificationCodeTextField.setText(null);
					}else {
						register.setUsername(aRUserName);
						register.setPassword(aRPassword);
						try {
							util.regist(register);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "注册成功！");
						AdminRegistView.this.setVisible(false);
						new AdminLoginView().setVisible(true);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("新宋体", Font.PLAIN, 12));
		btnNewButton.setBounds(81, 250, 97, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminRegistView.this.setVisible(false);
				new AdminLoginView().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("新宋体", Font.PLAIN, 12));
		btnNewButton_1.setBounds(327, 250, 97, 23);
		contentPane.add(btnNewButton_1);
	}

}
