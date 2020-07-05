package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.LoginDao;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.*;
import javax.swing.*;

public class LoginView extends JFrame {

	private JPanel contentPane;
    private JTextField userNameTextField;
	private JPasswordField passwordTextField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setTitle("用户端");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 331);
		
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("欢迎租车");
		welcomeLabel.setFont(new Font("新宋体", Font.BOLD, 30));
		welcomeLabel.setBounds(233, 22, 130, 35);
		contentPane.add(welcomeLabel);
		
		JLabel userNameLabel = new JLabel("用户名：");
		userNameLabel.setFont(new Font("新宋体", Font.PLAIN, 24));
		userNameLabel.setBounds(135, 111, 96, 28);
		contentPane.add(userNameLabel);
		
		JLabel passwordLabel = new JLabel("密  码：");
		passwordLabel.setFont(new Font("新宋体", Font.PLAIN, 24));
		passwordLabel.setBounds(135, 165, 96, 28);
		contentPane.add(passwordLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(241, 111, 195, 28);
		contentPane.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(241, 165, 195, 28);
		passwordTextField.setEchoChar('●');
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		
		JButton registerButton = new JButton("注册");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegistView().setVisible(true);
				LoginView.this.setVisible(false);
			}
		});
		registerButton.setFont(new Font("新宋体", Font.PLAIN, 16));
		registerButton.setBounds(149, 236, 97, 23);
		contentPane.add(registerButton);
		
		JButton loginButton = new JButton("登录");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = userNameTextField.getText();
				String word = passwordTextField.getText();
				LoginDao dao = new LoginDao();
				User user = dao.login(name, word);
				if(user!=null) {
					JOptionPane.showMessageDialog(null, "登录成功！");
					new UserMainView().setVisible(true);
					LoginView.this.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null, "用户名或密码错误！");
				}
			}
		});
		loginButton.setFont(new Font("新宋体", Font.PLAIN, 16));
		loginButton.setBounds(360, 236, 97, 23);
		contentPane.add(loginButton);
	}
}
