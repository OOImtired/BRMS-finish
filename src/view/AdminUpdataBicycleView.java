package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.BicycleDao;
import model.Bicycle;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class AdminUpdataBicycleView extends JInternalFrame {
	private JTextField searchTextField;
	private JTable table;
	BicycleDao bicycleDao=new BicycleDao(); 
	private JTextField lpnField;
	private JTextField brandField;
	private JTextField typeField;
	private JTextField priceField;
	private JTextField addressField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUpdataBicycleView frame = new AdminUpdataBicycleView();
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
	public AdminUpdataBicycleView() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 833, 534);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("自行车品牌");
		lblNewLabel.setFont(new Font("新宋体", Font.BOLD, 18));
		lblNewLabel.setBounds(196, 32, 109, 23);
		getContentPane().add(lblNewLabel);
		
		searchTextField = new JTextField();
		searchTextField.setFont(new Font("新宋体", Font.PLAIN, 16));
		searchTextField.setBounds(308, 30, 176, 23);
		getContentPane().add(searchTextField);
		searchTextField.setColumns(10);
		
		JButton searchButton = new JButton("搜索");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search=searchTextField.getText();
				fillTable(search);
			}
		});
		searchButton.setFont(new Font("新宋体", Font.BOLD, 16));
		searchButton.setBounds(511, 29, 97, 27);
		getContentPane().add(searchButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 66, 700, 129);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				String lpn=table.getValueAt(row, 0).toString();
				String brand=table.getValueAt(row, 1).toString();
				String type=table.getValueAt(row, 2).toString();
				String price=table.getValueAt(row, 3).toString();
				String address=table.getValueAt(row, 4).toString();
				
				lpnField.setText(lpn);
				brandField.setText(brand);
				typeField.setText(type);
				priceField.setText(price);
				addressField.setText(address);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u54C1\u724C", "\u7C7B\u578B", "\u4EF7\u683C", "\u5B58\u8F66\u70B9"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(45);
		table.getColumnModel().getColumn(2).setPreferredWidth(45);
		table.getColumnModel().getColumn(3).setPreferredWidth(45);
		table.getColumnModel().getColumn(4).setPreferredWidth(65);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4FEE\u6539\u754C\u9762", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		panel.setBounds(65, 218, 700, 259);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("编 号");
		lblNewLabel_1.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(264, 36, 66, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("品 牌");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_2.setBounds(108, 95, 66, 26);
		panel.add(lblNewLabel_2);
		
		lpnField = new JTextField();
		lpnField.setEditable(false);
		lpnField.setFont(new Font("新宋体", Font.BOLD, 16));
		lpnField.setBounds(329, 36, 73, 25);
		panel.add(lpnField);
		lpnField.setColumns(10);
		
		brandField = new JTextField();
		brandField.setFont(new Font("新宋体", Font.BOLD, 16));
		brandField.setBounds(175, 94, 73, 25);
		panel.add(brandField);
		brandField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("类 型");
		lblNewLabel_3.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel_3.setBounds(264, 94, 66, 26);
		panel.add(lblNewLabel_3);
		
		typeField = new JTextField();
		typeField.setFont(new Font("新宋体", Font.BOLD, 16));
		typeField.setBounds(329, 94, 73, 26);
		panel.add(typeField);
		typeField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("价 格");
		lblNewLabel_4.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel_4.setBounds(426, 95, 66, 26);
		panel.add(lblNewLabel_4);
		
		priceField = new JTextField();
		priceField.setFont(new Font("新宋体", Font.BOLD, 16));
		priceField.setBounds(495, 94, 73, 27);
		panel.add(priceField);
		priceField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("存 车 点");
		lblNewLabel_5.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel_5.setBounds(216, 147, 81, 37);
		panel.add(lblNewLabel_5);
		
		addressField = new JTextField();
		addressField.setFont(new Font("新宋体", Font.BOLD, 16));
		addressField.setBounds(307, 150, 201, 26);
		panel.add(addressField);
		addressField.setColumns(10);
		
		JButton OKButton = new JButton("保存修改");
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lpn=lpnField.getText();
				String brand=brandField.getText();
				String type=typeField.getText();
				double price=Double.parseDouble(priceField.getText());
				String address=addressField.getText();
				
				try {
					bicycleDao.updateBicycle(lpn, brand, type, price, address);
					JOptionPane.showMessageDialog(AdminUpdataBicycleView.this, "保存成功！");
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(AdminUpdataBicycleView.this, "保存失败！请检查");
				}
			}
		});
		OKButton.setFont(new Font("新宋体", Font.BOLD, 16));
		OKButton.setBounds(307, 210, 103, 26);
		panel.add(OKButton);

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
