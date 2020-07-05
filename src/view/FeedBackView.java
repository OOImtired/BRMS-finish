package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.FeedBackDao;
import model.FeedBackMessage;
import model.LivingMessage;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class FeedBackView extends JInternalFrame {
	private JTable table;
	private JTextField usernameField;
	private JTextArea messageArea;
	private JTextArea feedbackArea;
	FeedBackDao dao=new FeedBackDao();

	/**
	* 主程序入口
	 * @param args 调用参数
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedBackView frame = new FeedBackView();
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
	public FeedBackView() {
		setTitle("查看留言反馈");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 704, 504);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 672, 137);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                int row=table.getSelectedRow();
				
				String username=table.getValueAt(row, 0).toString();
				String message=table.getValueAt(row, 1).toString();
				String feedback=table.getValueAt(row, 2).toString();
				
				usernameField.setText(username);
				messageArea.setText(message);
				feedbackArea.setText(feedback);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528 \u6237 \u540D", " \u7559 \u8A00 ", "\u7559 \u8A00 \u53CD \u9988"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 157, 672, 308);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用 户 名");
		lblNewLabel.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 10, 75, 26);
		panel.add(lblNewLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("新宋体", Font.PLAIN, 16));
		usernameField.setEditable(false);
		usernameField.setBounds(95, 10, 75, 25);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(" 留 言");
		lblNewLabel_1.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 66, 75, 25);
		panel.add(lblNewLabel_1);
		
		messageArea = new JTextArea();
		messageArea.setFont(new Font("新宋体", Font.PLAIN, 16));
		messageArea.setEditable(false);
		messageArea.setBounds(46, 99, 581, 76);
		panel.add(messageArea);
		
		JLabel lblNewLabel_2 = new JLabel("留 言 反 馈");
		lblNewLabel_2.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 185, 100, 26);
		panel.add(lblNewLabel_2);
		
		feedbackArea = new JTextArea();
		feedbackArea.setFont(new Font("新宋体", Font.PLAIN, 16));
		feedbackArea.setEditable(false);
		feedbackArea.setBounds(46, 212, 581, 76);
		panel.add(feedbackArea);
		
		fillTable(null);

	}
	
	public void fillTable(String username) {
		DefaultTableModel defaultTable=(DefaultTableModel)table.getModel();
		  List<FeedBackMessage> queryFeedBackMessage=dao.queryFeedBack(username);
		  defaultTable.setRowCount(0);
		  for(FeedBackMessage qfbm:queryFeedBackMessage) {
			  defaultTable.addRow(new Object[] {qfbm.getUsername(),qfbm.getMessage(),qfbm.getFeedback()});
		  }
		  
	}
}
