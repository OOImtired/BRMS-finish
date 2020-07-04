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

import dao.BicycleDao;
import model.Bicycle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QueryBicycleView extends JInternalFrame {
	private JTextField searchtField;
	private JTable table;
	BicycleDao bicycleDao=new BicycleDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryBicycleView frame = new QueryBicycleView();
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
	public QueryBicycleView() {
		setIconifiable(true);
		setClosable(true);
		setTitle("查看自行车");
		setBounds(100, 100, 637, 522);
		getContentPane().setLayout(null);
		
		JLabel bicycleBrandLabel = new JLabel("自行车品牌");
		bicycleBrandLabel.setFont(new Font("新宋体", Font.BOLD, 20));
		bicycleBrandLabel.setBounds(90, 54, 116, 43);
		getContentPane().add(bicycleBrandLabel);
		
		searchtField = new JTextField();
		searchtField.setFont(new Font("新宋体", Font.PLAIN, 20));
		searchtField.setBounds(216, 54, 191, 43);
		getContentPane().add(searchtField);
		searchtField.setColumns(10);
		
		JButton searchButton = new JButton("搜索");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search=searchtField.getText();
				fillTable(search);
			}
		});
		searchButton.setFont(new Font("新宋体", Font.BOLD, 16));
		searchButton.setBounds(445, 54, 91, 43);
		getContentPane().add(searchButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 107, 434, 355);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("新宋体", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u54C1\u724C", "\u7C7B\u578B", "\u4EF7\u683C", "\u5B58\u8F66\u70B9"
			}
		));
		
		fillTable(null);
		 
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(45);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setPreferredWidth(45);
		table.getColumnModel().getColumn(4).setPreferredWidth(55);
		scrollPane.setViewportView(table);

	}
	public void fillTable(String tbrand) {
		List<Bicycle> by=bicycleDao.queryBicycle(tbrand); 
		DefaultTableModel defaultTable=(DefaultTableModel)table.getModel();  
		defaultTable.setRowCount(0);//清空表中数据
	    for(Bicycle bicycles:by) {
	    	defaultTable.addRow(new Object[] {bicycles.getLpn(),bicycles.getBrand(),bicycles.getType(),
				bicycles.getPrice(),bicycles.getAddress()});
		  }
	}
}
