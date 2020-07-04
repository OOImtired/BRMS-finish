package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.ExcelUtil;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UserMainView extends JFrame {

	private JPanel contentPane;
	JDesktopPane desktopPane = new JDesktopPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainView frame = new UserMainView();
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
	public UserMainView() {
		setTitle("自行车租赁系统");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 800);
		contentPane = new JPanel();
		
		this.setLocationRelativeTo(null);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar userMenuBar = new JMenuBar();
		userMenuBar.setBounds(0, 0, 900, 54);
		contentPane.add(userMenuBar);
		
		JMenu omMenu = new JMenu("订单管理");
		omMenu.setFont(new Font("新宋体", Font.BOLD, 20));
		userMenuBar.add(omMenu);
		
		JMenuItem myMenuMenuItem = new JMenuItem("我的订单");
		myMenuMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyOrderView myOrderView = new MyOrderView();
				desktopPane.add(myOrderView);
				myOrderView.setVisible(true);
			}
		});
		myMenuMenuItem.setFont(new Font("新宋体", Font.PLAIN, 14));
		omMenu.add(myMenuMenuItem);
		
		JMenuItem exportOrderMenuItem = new JMenuItem("导出订单");
		exportOrderMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcelUtil excelUtil = new ExcelUtil();
				excelUtil.exportExcel();
				JOptionPane.showMessageDialog(null, "导出订单成功！");
			}
		});
		exportOrderMenuItem.setFont(new Font("新宋体", Font.PLAIN, 14));
		omMenu.add(exportOrderMenuItem);
		
		JMenu rentalMenu =  new JMenu("租车");
		rentalMenu.setFont(new Font("新宋体", Font.BOLD, 20));
		userMenuBar.add(rentalMenu);
		
		JMenuItem rentalMenuItem = new JMenuItem("我要租车");
		rentalMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlaceOrderView placeOrderView=new PlaceOrderView();
				desktopPane.add(placeOrderView);
				placeOrderView.setVisible(true);
			}
		});
		rentalMenuItem.setFont(new Font("新宋体", Font.PLAIN, 14));
		rentalMenu.add(rentalMenuItem);
		
		JMenuItem queryBicycleMenuItem = new JMenuItem("查看自行车");
		queryBicycleMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryBicycleView queryBicycleView=new QueryBicycleView();
				desktopPane.add(queryBicycleView);
				queryBicycleView.setVisible(true);
			}
		});
		queryBicycleMenuItem.setFont(new Font("新宋体", Font.PLAIN, 16));
		rentalMenu.add(queryBicycleMenuItem);
		
		JMenu mnNewMenu = new JMenu("留言");
		mnNewMenu.setFont(new Font("新宋体", Font.BOLD, 20));
		userMenuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("我要留言");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeavingMessageView leavingMessageView = new LeavingMessageView();
				desktopPane.add(leavingMessageView);
				leavingMessageView.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("新宋体", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("留言反馈");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FeedBackView feedbackView = new FeedBackView();
				desktopPane.add(feedbackView);
				feedbackView.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("新宋体", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(0, 52, 996, 720);
		contentPane.add(desktopPane);
	}
}
