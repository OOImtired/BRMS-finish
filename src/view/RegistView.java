package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.RegistDao;
import model.Register;
import util.IOAdminLoginUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistView extends JFrame {

	private JPanel contentPane;
	private JTextField RUserNameField;
	private JTextField RPasswordField;
	

	/**
	 * 主程序入口
	 * @param args 调用参数
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistView frame = new RegistView();
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
	public RegistView() {
		setTitle("用户注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 291);
		
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel PRLabel = new JLabel("请注册");
		PRLabel.setFont(new Font("新宋体", Font.BOLD, 30));
		PRLabel.setBounds(164, 10, 100, 51);
		contentPane.add(PRLabel);
		
		JLabel RUserNameLabel = new JLabel("用户名：");
		RUserNameLabel.setFont(new Font("新宋体", Font.PLAIN, 16));
		RUserNameLabel.setBounds(110, 84, 68, 19);
		contentPane.add(RUserNameLabel);
		
		JLabel RPasswordLabel = new JLabel("密  码：");
		RPasswordLabel.setFont(new Font("新宋体", Font.PLAIN, 16));
		RPasswordLabel.setBounds(110, 137, 68, 19);
		contentPane.add(RPasswordLabel);
		
		RUserNameField = new JTextField();
		RUserNameField.setBounds(223, 84, 147, 21);
		contentPane.add(RUserNameField);
		RUserNameField.setColumns(10);
		
		RPasswordField = new JTextField();
		RPasswordField.setBounds(223, 137, 147, 21);
		contentPane.add(RPasswordField);
		RPasswordField.setColumns(10);
		
		JButton btnNewButton = new JButton("确认 ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register=new Register();
				String RUserName=RUserNameField.getText();
				String RPassword=RPasswordField.getText();
				RegistDao dao=new RegistDao();
				if(RUserName.isEmpty()) {
					JOptionPane.showMessageDialog(null, "用户名不能为空！");
				}else if(RPassword.isEmpty()) {
					JOptionPane.showMessageDialog(null, "密码不能为空！");
				}else {
				register.setUsername(RUserName);
				register.setPassword(RPassword);
				dao.insertRegister(register);
				JOptionPane.showMessageDialog(null, "注册成功！");
				RegistView.this.setVisible(false);
				new LoginView().setVisible(true);
			}
			}		
		});
		btnNewButton.setFont(new Font("新宋体", Font.BOLD, 12));
		btnNewButton.setBounds(110, 205, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistView.this.setVisible(false);
				new LoginView().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("新宋体", Font.BOLD, 12));
		btnNewButton_1.setBounds(273, 205, 97, 23);
		contentPane.add(btnNewButton_1);
	}
}
