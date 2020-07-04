package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.FeedBackDao;
import dao.LivingMessageDao;
import model.FeedBackMessage;
import model.LivingMessage;
import model.Rental;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdataMessageView extends JInternalFrame {
	private JTable table;
	private JTextField usernameField;
	private JTextArea messageArea;
	private JTextArea feedBackArea;
	LivingMessageDao dao=new LivingMessageDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdataMessageView frame = new UpdataMessageView();
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
	public UpdataMessageView() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 632, 540);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 600, 132);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                int row=table.getSelectedRow();
				
				String username=table.getValueAt(row, 0).toString();
				String message=table.getValueAt(row, 1).toString();
				
				usernameField.setText(username);
				messageArea.setText(message);
		}
		});
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528     \u6237", "\u7559      \u8A00"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u5199\u53CD\u9988", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 152, 600, 349);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("反 馈");
		lblNewLabel.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 146, 82, 32);
		panel.add(lblNewLabel);
		
		feedBackArea = new JTextArea();
		feedBackArea.setBounds(20, 188, 559, 100);
		panel.add(feedBackArea);
		
		JButton okButton = new JButton("提交反馈");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=usernameField.getText();
				String feedback=feedBackArea.getText();
				FeedBackDao dao=new FeedBackDao();
				FeedBackMessage fbm=new FeedBackMessage();
				fbm.setUsername(username);
				fbm.setFeedback(feedback);
				dao.insertFeedBack(fbm);
				JOptionPane.showMessageDialog(UpdataMessageView.this, "反馈提交成功！");
			}
		});
		okButton.setFont(new Font("新宋体", Font.BOLD, 16));
		okButton.setBounds(238, 316, 109, 23);
		panel.add(okButton);
		
		JLabel lblNewLabel_1 = new JLabel("用 户 ");
		lblNewLabel_1.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel_1.setBounds(20, 31, 55, 19);
		panel.add(lblNewLabel_1);
		
		usernameField = new JTextField();
		usernameField.setForeground(Color.BLACK);
		usernameField.setEditable(false);
		usernameField.setFont(new Font("新宋体", Font.BOLD, 16));
		usernameField.setBounds(85, 29, 66, 21);
		panel.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("留言详情");
		lblNewLabel_2.setFont(new Font("新宋体", Font.BOLD, 16));
		lblNewLabel_2.setBounds(20, 60, 82, 23);
		panel.add(lblNewLabel_2);
		
		messageArea = new JTextArea();
		messageArea.setEditable(false);
		messageArea.setBounds(20, 89, 552, 47);
		panel.add(messageArea);
		
		fillTable(null);

	}
	public void fillTable(String username) {
		DefaultTableModel defaultTable=(DefaultTableModel)table.getModel();
		  List<LivingMessage> queryLivingMessage=dao.queryMessage(username);
		  defaultTable.setRowCount(0);
		  for(LivingMessage qlm:queryLivingMessage) {
			  defaultTable.addRow(new Object[] {qlm.getUsername(),qlm.getMessage()});
		  }
		  
	}
}
