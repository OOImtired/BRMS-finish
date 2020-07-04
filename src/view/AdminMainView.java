package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AdminMainView extends JFrame {

	private JPanel contentPane;
	JDesktopPane desktopPane = new JDesktopPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainView frame = new AdminMainView();
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
	public AdminMainView() {
		setTitle("自行车租赁管理系统");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		
		this.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu managingBicyclesMenu = new JMenu("管理自行车");
		managingBicyclesMenu.setFont(new Font("新宋体", Font.BOLD, 20));
		menuBar.add(managingBicyclesMenu);
		
		JMenuItem queryBicyclesMenuItem = new JMenuItem("查询自行车");
		queryBicyclesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryBicycleView queryBicycleView=new QueryBicycleView();
				desktopPane.add(queryBicycleView);
				queryBicycleView.setVisible(true);
			}
		});
		queryBicyclesMenuItem.setFont(new Font("新宋体", Font.PLAIN, 16));
		managingBicyclesMenu.add(queryBicyclesMenuItem);
		
		JMenuItem updateBicyclesMenuItem = new JMenuItem("修改自行车信息");
		updateBicyclesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminUpdataBicycleView adminUpdataBicycleView=new AdminUpdataBicycleView();
				desktopPane.add(adminUpdataBicycleView);
				adminUpdataBicycleView.setVisible(true);
			}
		});
		updateBicyclesMenuItem.setFont(new Font("新宋体", Font.PLAIN, 16));
		managingBicyclesMenu.add(updateBicyclesMenuItem);
		
		JMenu managingOrderMenu = new JMenu("管理订单");
		managingOrderMenu.setFont(new Font("新宋体", Font.BOLD, 20));
		menuBar.add(managingOrderMenu);
		
		JMenuItem queryOrderMenuItem = new JMenuItem("查询订单");
		queryOrderMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyOrderView myOrderView = new MyOrderView();
				desktopPane.add(myOrderView);
				myOrderView.setVisible(true);
			}
		});
		queryOrderMenuItem.setFont(new Font("新宋体", Font.PLAIN, 16));
		managingOrderMenu.add(queryOrderMenuItem);
		
		JMenuItem updateOrderMenuItem = new JMenuItem("修改订单");
		updateOrderMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateOrderView updataOrderView = new UpdateOrderView();
				desktopPane.add(updataOrderView);
				updataOrderView.setVisible(true);
			}
		});
		updateOrderMenuItem.setFont(new Font("新宋体", Font.PLAIN, 16));
		managingOrderMenu.add(updateOrderMenuItem);
		
		JMenu mnNewMenu = new JMenu("管理留言");
		mnNewMenu.setFont(new Font("新宋体", Font.BOLD, 20));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("查看反馈留言");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdataMessageView updataMessageView = new UpdataMessageView();
				desktopPane.add(updataMessageView);
				updataMessageView.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("新宋体", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(0, 0, 996, 996);
		contentPane.add(desktopPane);
	}
}
