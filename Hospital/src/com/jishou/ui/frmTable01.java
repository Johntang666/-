package com.jishou.ui;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;

public class frmTable01 extends JFrame {
	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;//定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则
	
	private Vector<String> titles;

//	public static void main(String[] args) {
//		frmTable01 frame = new frmTable01();// 实例化窗体
//		frame.setLocationRelativeTo(null);// 窗体居中
//		frame.setVisible(true);// 窗体可见
//	}

	/**
	 * 定义构造方法创建窗体及组件.
	 */
	public frmTable01() {
		setTitle("用户模式");
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmTable01.class.getResource("/Source/1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体关闭按钮
		setBounds(100, 100, 520, 487);// 设置窗体位置与大小
		contentPane = new JPanel();// 实例化内容面板
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		setContentPane(contentPane);// 将窗体默认面板

		

		
		
		JLabel lblNewLabel = new JLabel("社区医院远程挂号系统");
		lblNewLabel.setFont(new Font("华文楷体", Font.PLAIN, 30));
		lblNewLabel.setBounds(95, 25, 346, 45);
		contentPane.add(lblNewLabel);
		
		JButton displayButton = new JButton("显示医院及专家");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayDoctor frame = new displayDoctor();// 实例化窗体
				frame.setLocationRelativeTo(null);// 窗体居中
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);// 窗体可见
			}
		});
		displayButton.setFont(new Font("华文行楷", Font.BOLD, 15));
		displayButton.setBounds(95, 206, 346, 33);
		contentPane.add(displayButton);
		
		JButton registerButton = new JButton("注册");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register dialog = new register();
				dialog.setLocationRelativeTo(null);// 窗体居中
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				setVisible(false);
			}
		});
		registerButton.setFont(new Font("华文行楷", Font.BOLD, 15));
		registerButton.setBounds(95, 278, 346, 33);
		contentPane.add(registerButton);
		
		JButton landingButton = new JButton("登陆查询，挂号及取消挂号");
		landingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				patientLogin dialog = new patientLogin();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);// 窗体居中
				dialog.setVisible(true);
			}
		});
		landingButton.setFont(new Font("华文行楷", Font.BOLD, 15));
		landingButton.setBounds(95, 348, 346, 33);
		contentPane.add(landingButton);
		
		JButton exitButton = new JButton("\u9000\u51FA");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(390, 404, 93, 23);
		contentPane.add(exitButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(frmTable01.class.getResource("/Source/\u56FE\u72473.jpg")));
		lblNewLabel_1.setBounds(10, 10, 722, 473);
		contentPane.add(lblNewLabel_1);
	}
}
