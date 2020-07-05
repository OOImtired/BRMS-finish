package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.MyOrderDao;
import model.Rental;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyOrderView extends JInternalFrame {
	private JTextField OrderQueryTextField;
	private JTable table;
    MyOrderDao myOrderDao=new MyOrderDao();

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
	public MyOrderView() {
		setTitle("查询订单");
		setClosable(true);
		setIconifiable(true);
		getContentPane().setFont(new Font("新宋体", Font.PLAIN, 12));
		setBounds(100, 100, 879, 546);
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
		scrollPane.setBounds(68, 84, 767, 371);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8F66\u53F7", "\u54C1\u724C", "\u7C7B\u578B", "\u4EF7\u683C", "\u5B58\u8F66\u70B9", "\u5F00\u59CB\u65F6\u95F4", "\u7ED3\u675F\u65F6\u95F4", "\u79DF\u8F66\u6570\u91CF", "用户名", "\u8054\u7CFB\u65B9\u5F0F"
			}
		));
		
		fillTable(null);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(41);
		table.getColumnModel().getColumn(1).setPreferredWidth(42);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setPreferredWidth(45);
		table.getColumnModel().getColumn(4).setPreferredWidth(55);
		table.getColumnModel().getColumn(5).setPreferredWidth(65);
		table.getColumnModel().getColumn(6).setPreferredWidth(65);
		table.getColumnModel().getColumn(7).setPreferredWidth(65);
		table.getColumnModel().getColumn(8).setPreferredWidth(45);
		table.getColumnModel().getColumn(9).setPreferredWidth(65);
		table.setFont(new Font("新宋体", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
	}
	
	public void fillTable(String tbrand) {
		DefaultTableModel defaultTable=(DefaultTableModel)table.getModel();
		  List<Rental> queryMyOrder=myOrderDao.queryMyOrder(tbrand); 
		  defaultTable.setRowCount(0);
		  for(Rental qmo:queryMyOrder) {
			  defaultTable.addRow(new Object[] {qmo.getLpn(),qmo.getBrand(),qmo.getType(),qmo.getPrice(),
					  qmo.getAddress(),qmo.getStartdate(),qmo.getEnddate(),qmo.getRentalnumber(),
					  qmo.getUsername(),qmo.getTelenumber()});
		  }
		
	}
}
