package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.LivingMessageDao;
import model.LivingMessage;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeavingMessageView extends JInternalFrame {
	private JTextField usernameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeavingMessageView frame = new LeavingMessageView();
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
	public LeavingMessageView() {
		setIconifiable(true);
		setClosable(true);
		setTitle("我要留言");
		setBounds(100, 100, 571, 492);
		getContentPane().setLayout(null);
		
		JLabel livingMassageLabel = new JLabel("请写下您的留言");
		livingMassageLabel.setFont(new Font("新宋体", Font.BOLD, 30));
		livingMassageLabel.setBounds(170, 24, 230, 48);
		getContentPane().add(livingMassageLabel);
		
		JTextArea livingMassageTextArea = new JTextArea();
		livingMassageTextArea.setFont(new Font("新宋体", Font.PLAIN, 20));
		livingMassageTextArea.setBounds(47, 71, 457, 254);
		livingMassageTextArea.setLineWrap(true);        //激活自动换行功能 
		livingMassageTextArea.setWrapStyleWord(true);   // 激活断行不断字功能
		getContentPane().add(livingMassageTextArea);

		JButton submitButton = new JButton("提交");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivingMessage livingMessage=new LivingMessage();
				String livingMassageText=livingMassageTextArea.getText();
				String username=usernameField.getText();
				if(username.equals("")) {
					JOptionPane.showMessageDialog(null, "用户名不能为空！");
				}if(livingMassageText.equals("")){
					JOptionPane.showMessageDialog(null, "留言不能为空！");
				}else {
				LivingMessageDao livingMessageDao = new LivingMessageDao();
				livingMessage.setMessage(livingMassageText);
				livingMessage.setUsername(username);
				livingMessageDao.insertMessage(livingMessage);
				JOptionPane.showMessageDialog(null, "提交成功！");
				}
				
			}
		});
		submitButton.setFont(new Font("新宋体", Font.PLAIN, 16));
		submitButton.setBounds(225, 430, 97, 23);
		getContentPane().add(submitButton);
		
		JLabel lblNewLabel = new JLabel("用 户 名");
		lblNewLabel.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(163, 375, 77, 23);
		getContentPane().add(lblNewLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("新宋体", Font.BOLD, 16));
		usernameField.setBounds(280, 375, 120, 23);
		getContentPane().add(usernameField);
		usernameField.setColumns(10);

	}
}
