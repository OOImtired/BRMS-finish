package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.UpdateOrderDao;
import model.Rental;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

public class UpdateOrderView extends JInternalFrame {
	private JTextField OrderQueryTextField;
	private JTable table;
    private JTextField lpnField;
    private JTextField brandField;
    private JTextField typeField;
    private JTextField startdateField;
    private JTextField enddateField;
    private JTextField rentalNumberField;
    private JTextField usernameField;
    private JTextField teleNumberField;
    UpdateOrderDao updateOrderDao=new UpdateOrderDao();
    
	/**
	* 主程序入口
	 * @param args 调用参数
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyOrderView frame = new MyOrderView();
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
	public UpdateOrderView() {
		setTitle("修改用户订单");
		setClosable(true);
		setIconifiable(true);
		getContentPane().setFont(new Font("新宋体", Font.PLAIN, 12));
		setBounds(100, 100, 878, 546);
		getContentPane().setLayout(null);
		
		JLabel OrderQueryLabel = new JLabel("订单查询：");
		OrderQueryLabel.setFont(new Font("新宋体", Font.PLAIN, 16));
		OrderQueryLabel.setBounds(192, 43, 91, 31);
		getContentPane().add(OrderQueryLabel);
		
		OrderQueryTextField = new JTextField();
		OrderQueryTextField.setBounds(321, 46, 208, 27);
		getContentPane().add(OrderQueryTextField);
		OrderQueryTextField.setColumns(10);
		
		JButton OrderQueryButton = new JButton("搜索");
		OrderQueryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String orderQueryTextField=OrderQueryTextField.getText();
				fillTable(orderQueryTextField);
			}
		});
		OrderQueryButton.setFont(new Font("新宋体", Font.BOLD, 14));
		OrderQueryButton.setBounds(572, 45, 97, 28);
		getContentPane().add(OrderQueryButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 84, 799, 130);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				
				String lpn=table.getValueAt(row, 0).toString();
				String brand=table.getValueAt(row, 1).toString();
				String type=table.getValueAt(row, 2).toString();
				String startdate=table.getValueAt(row, 3).toString();
				String enddate=table.getValueAt(row, 4).toString();
				String rentalNumber=table.getValueAt(row, 5).toString();
				String name=table.getValueAt(row, 6).toString();
				String teleNunmber=table.getValueAt(row, 7).toString();
				
				lpnField.setText(lpn);
				brandField.setText(brand);
				typeField.setText(type);
				startdateField.setText(startdate);
				enddateField.setText(enddate);
				rentalNumberField.setText(rentalNumber);
				usernameField.setText(name);
				teleNumberField.setText(teleNunmber);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8F66\u53F7", "\u54C1\u724C", "\u7C7B\u578B", "\u5F00\u59CB\u65F6\u95F4", "\u7ED3\u675F\u65F6\u95F4", "\u79DF\u8F66\u6570\u91CF", "用户名", "\u8054\u7CFB\u65B9\u5F0F"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(41);
		table.getColumnModel().getColumn(1).setPreferredWidth(42);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setPreferredWidth(65);
		table.getColumnModel().getColumn(4).setPreferredWidth(65);
		table.getColumnModel().getColumn(5).setPreferredWidth(60);
		table.getColumnModel().getColumn(6).setPreferredWidth(45);
		table.getColumnModel().getColumn(7).setPreferredWidth(65);
		
		fillTable(null);
		table.setFont(new Font("新宋体", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4FEE\u6539\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(35, 247, 799, 249);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("车号");
		lblNewLabel.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(41, 35, 39, 18);
		panel.add(lblNewLabel);
		
		lpnField = new JTextField();
		lpnField.setFont(new Font("新宋体", Font.BOLD, 16));
		lpnField.setEditable(false);
		lpnField.setBounds(90, 33, 66, 21);
		panel.add(lpnField);
		lpnField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("品牌");
		lblNewLabel_1.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(333, 36, 39, 16);
		panel.add(lblNewLabel_1);
		
		brandField = new JTextField();
		brandField.setFont(new Font("新宋体", Font.BOLD, 16));
		brandField.setBounds(382, 34, 66, 21);
		panel.add(brandField);
		brandField.setColumns(10);
		
		typeField = new JTextField();
		typeField.setFont(new Font("新宋体", Font.BOLD, 16));
		typeField.setBounds(666, 34, 66, 21);
		panel.add(typeField);
		typeField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("类型");
		lblNewLabel_3.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel_3.setBounds(617, 35, 39, 18);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("开始时间");
		lblNewLabel_5.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel_5.setBounds(109, 105, 85, 18);
		panel.add(lblNewLabel_5);
		
		startdateField = new JTextField();
		startdateField.setFont(new Font("新宋体", Font.BOLD, 16));
		startdateField.setBounds(204, 104, 120, 21);
		panel.add(startdateField);
		startdateField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("结束时间");
		lblNewLabel_6.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel_6.setBounds(468, 105, 90, 18);
		panel.add(lblNewLabel_6);
		
		enddateField = new JTextField();
		enddateField.setFont(new Font("新宋体", Font.BOLD, 16));
		enddateField.setBounds(563, 104, 134, 21);
		panel.add(enddateField);
		enddateField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("租车数量");
		lblNewLabel_7.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel_7.setBounds(39, 169, 85, 18);
		panel.add(lblNewLabel_7);
		
		rentalNumberField = new JTextField();
		rentalNumberField.setFont(new Font("新宋体", Font.BOLD, 16));
		rentalNumberField.setBounds(134, 167, 66, 21);
		panel.add(rentalNumberField);
		rentalNumberField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("用户名");
		lblNewLabel_8.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel_8.setBounds(317, 169, 55, 18);
		panel.add(lblNewLabel_8);
		
		usernameField = new JTextField();
		usernameField.setEditable(false);
		usernameField.setFont(new Font("新宋体", Font.BOLD, 16));
		usernameField.setBounds(382, 167, 66, 21);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("联系方式");
		lblNewLabel_9.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel_9.setBounds(506, 169, 72, 18);
		panel.add(lblNewLabel_9);
		
		teleNumberField = new JTextField();
		teleNumberField.setFont(new Font("新宋体", Font.BOLD, 16));
		teleNumberField.setBounds(598, 167, 134, 21);
		panel.add(teleNumberField);
		teleNumberField.setColumns(10);
		
		JButton btnNewButton = new JButton("保存修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lpn=lpnField.getText();
				String brand=brandField.getText();
				String type=typeField.getText();
				Date startdate=java.sql.Date.valueOf(startdateField.getText());
				Date enddate=java.sql.Date.valueOf(enddateField.getText());
				int rentalNumber=Integer.parseInt(rentalNumberField.getText());
				String name=usernameField.getText();
				String teleNumber=teleNumberField.getText();
				
				try {
					updateOrderDao.updateUserOrder(lpn, brand, type, startdate, enddate, rentalNumber, name, teleNumber);
					JOptionPane.showMessageDialog(UpdateOrderView.this, "保存成功！");
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(UpdateOrderView.this, "保存失败，请检查！");
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton.setBounds(334, 211, 114, 28);
		panel.add(btnNewButton);
		
		fillTable(null);
	}
	
	public void fillTable(String tbrand) {
		DefaultTableModel defaultTable=(DefaultTableModel)table.getModel();
		  List<Rental> queryMyOrder=updateOrderDao.queryOrder(tbrand); 
		  defaultTable.setRowCount(0);
		  for(Rental qmo:queryMyOrder) {
			  defaultTable.addRow(new Object[] {qmo.getLpn(),qmo.getBrand(),qmo.getType(),
					  qmo.getStartdate(),qmo.getEnddate(),qmo.getRentalnumber(),qmo.getUsername(),qmo.getTelenumber()});
		  }
		  
	}
	
}
