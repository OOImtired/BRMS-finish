package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import dao.UserOrderDao;
import model.Rental;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class PlaceOrderView extends JInternalFrame {
	private JTextField brandTextField;
	private JTextField typeTextField;
	private JTextField numberTextField;
	private JTextField usernameTextField;
	private JTextField teleTextField;
	private JTextField startTimeTextField;
	private JTextField endTimeTextField;
	private JTextField carLpnTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlaceOrderView frame = new PlaceOrderView();
					frame.setVisible(true);
				} catch (Exception e) { e.printStackTrace(); }
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlaceOrderView() {
		getContentPane().setFont(new Font("新宋体", Font.PLAIN, 14));
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 737, 485);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请  填  写  信  息");
		lblNewLabel.setFont(new Font("新宋体", Font.BOLD, 24));
		lblNewLabel.setBounds(236, 19, 244, 54);
		getContentPane().add(lblNewLabel);
		
		JLabel brandLabel = new JLabel("品牌");
		brandLabel.setFont(new Font("新宋体", Font.PLAIN, 20));
		brandLabel.setBounds(187, 86, 49, 42);
		getContentPane().add(brandLabel);
		
		brandTextField = new JTextField();
		brandTextField.setBounds(246, 91, 96, 31);
		getContentPane().add(brandTextField);
		brandTextField.setColumns(10);
		
		JLabel typeLabel = new JLabel("车型");
		typeLabel.setFont(new Font("新宋体", Font.PLAIN, 20));
		typeLabel.setBounds(189, 138, 49, 42);
		getContentPane().add(typeLabel);
		
		typeTextField = new JTextField();
		typeTextField.setColumns(10);
		typeTextField.setBounds(248, 143, 96, 31);
		getContentPane().add(typeTextField);
		
		JLabel numberLabel = new JLabel("数量");
		numberLabel.setFont(new Font("新宋体", Font.PLAIN, 20));
		numberLabel.setBounds(391, 138, 49, 42);
		getContentPane().add(numberLabel);
		
		JLabel nameLabel = new JLabel("用 户 名");
		nameLabel.setFont(new Font("新宋体", Font.PLAIN, 20));
		nameLabel.setBounds(226, 294, 88, 42);
		getContentPane().add(nameLabel);
		
		JLabel teleLabel = new JLabel("联系方式");
		teleLabel.setFont(new Font("新宋体", Font.PLAIN, 20));
		teleLabel.setBounds(226, 346, 88, 42);
		getContentPane().add(teleLabel);
		
		numberTextField = new JTextField();
		numberTextField.setColumns(10);
		numberTextField.setBounds(450, 140, 96, 31);
		getContentPane().add(numberTextField);
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(333, 299, 96, 31);
		getContentPane().add(usernameTextField);
		
		teleTextField = new JTextField();
		teleTextField.setColumns(10);
		teleTextField.setBounds(333, 351, 210, 31);
		getContentPane().add(teleTextField);
		
		JButton btnNewButton = new JButton("确认下单");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rental rental=new Rental();
				String lpn=carLpnTextField.getText();
				String brand=brandTextField.getText();
				String type=typeTextField.getText();
				Date starttime=java.sql.Date.valueOf(startTimeTextField.getText());
				Date endtime=java.sql.Date.valueOf(endTimeTextField.getText());
				int rentalNumber=Integer.valueOf(numberTextField.getText()).intValue();
				String username=usernameTextField.getText();
				String teleNumber=teleTextField.getText();
				UserOrderDao dao=new UserOrderDao();
				rental.setLpn(lpn);
				rental.setBrand(brand);
				rental.setType(type);
				rental.setStartdate(starttime);
				rental.setEnddate(endtime);
				rental.setRentalnumber(rentalNumber);
				rental.setUsername(username);
				rental.setTelenumber(teleNumber);
				dao.insertUserOrder(rental);
				JOptionPane.showMessageDialog(null, "下单成功！");
				carLpnTextField.setText(null);
				brandTextField.setText(null);
				typeTextField.setText(null);
				startTimeTextField.setText(null);
				endTimeTextField.setText(null);
				numberTextField.setText(null);
				usernameTextField.setText(null);
				teleTextField.setText(null);
			}
		});
		btnNewButton.setFont(new Font("新宋体", Font.BOLD, 16));
		btnNewButton.setBounds(318, 409, 122, 37);
		getContentPane().add(btnNewButton);
		
		JLabel startTimeLabel = new JLabel("开始时间");
		startTimeLabel.setFont(new Font("新宋体", Font.PLAIN, 20));
		startTimeLabel.setBounds(226, 190, 88, 42);
		getContentPane().add(startTimeLabel);
		
		JLabel endTimeLabel = new JLabel("结束时间");
		endTimeLabel.setFont(new Font("新宋体", Font.PLAIN, 20));
		endTimeLabel.setBounds(226, 242, 88, 42);
		getContentPane().add(endTimeLabel);
		
		startTimeTextField = new JTextField();
		startTimeTextField.setColumns(10);
		startTimeTextField.setBounds(333, 195, 165, 31);
		getContentPane().add(startTimeTextField);
		
		endTimeTextField = new JTextField();
		endTimeTextField.setColumns(10);
		endTimeTextField.setBounds(333, 247, 165, 31);
		getContentPane().add(endTimeTextField);
		
		JLabel carLpnLabel = new JLabel("车号");
		carLpnLabel.setFont(new Font("新宋体", Font.PLAIN, 20));
		carLpnLabel.setBounds(391, 86, 49, 42);
		getContentPane().add(carLpnLabel);
		
		carLpnTextField = new JTextField();
		carLpnTextField.setColumns(10);
		carLpnTextField.setBounds(450, 91, 96, 31);
		getContentPane().add(carLpnTextField);

	}
}
