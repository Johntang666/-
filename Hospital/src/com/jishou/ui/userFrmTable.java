package com.jishou.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class userFrmTable extends JFrame {
	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;//定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则
	
	private Vector<String> titles;
	public userFrmTable() {
		setTitle("管理员");
		setIconImage(Toolkit.getDefaultToolkit().getImage(userFrmTable.class.getResource("/Source/0 (1).png")));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体关闭按钮
		setBounds(100, 100, 586, 429);// 设置窗体位置与大小
		contentPane = new JPanel();// 实例化内容面板
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		setContentPane(contentPane);// 将窗体默认面板
		JButton btnNewButton = new JButton("医生信息管理");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayDoctor frame = new displayDoctor();// 实例化窗体
				frame.setLocationRelativeTo(null);// 窗体居中
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);// 窗体可见
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("华文楷体", Font.BOLD, 15));
		btnNewButton.setBounds(202, 195, 162, 39);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改密码");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modify dialog = new modify();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("华文楷体", Font.BOLD, 15));
		btnNewButton_1.setBounds(202, 264, 162, 39);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(userFrmTable.class.getResource("/Source/19.png")));
		lblNewLabel.setBounds(235, 43, 129, 99);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(userFrmTable.class.getResource("/Source/\u533B\u96621.jpg")));
		lblNewLabel_1.setBounds(30, 10, 560, 357);
		contentPane.add(lblNewLabel_1);
	}
}
