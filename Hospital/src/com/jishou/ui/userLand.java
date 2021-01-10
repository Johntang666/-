package com.jishou.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jishou.dao.DatabaseConnectionSql;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class userLand extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			userLand dialog = new userLand();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			displayDoctor frame = new displayDoctor();// 实例化窗体
//			dialog.setLocationRelativeTo(null);// 窗体居中
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public userLand() {
		setTitle("管理员登陆");
		setIconImage(Toolkit.getDefaultToolkit().getImage(userLand.class.getResource("/Source/8.png")));
		setBounds(100, 100, 585, 377);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("欢迎登陆管理员系统");
			lblNewLabel.setFont(new Font("楷体", Font.BOLD, 16));
			lblNewLabel.setBounds(201, 22, 169, 28);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("账号：");
			lblNewLabel_2.setFont(new Font("华文细黑", Font.BOLD, 15));
			lblNewLabel_2.setBounds(191, 93, 81, 24);
			contentPanel.add(lblNewLabel_2);
		}
		{
			textField = new JTextField();
			textField.setBounds(271, 94, 148, 28);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("密码：");
			lblNewLabel_1.setFont(new Font("华文细黑", Font.BOLD, 15));
			lblNewLabel_1.setBounds(191, 149, 81, 36);
			contentPanel.add(lblNewLabel_1);
		}
		
		passwordField = new JPasswordField();
		passwordField.setBounds(271, 149, 148, 28);
		contentPanel.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(userLand.class.getResource("/Source/\u7BA1\u7406\u5458\u767B\u9646\u56FE\u7247.jpg")));
		lblNewLabel_3.setBounds(33, 0, 559, 293);
		contentPanel.add(lblNewLabel_3);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("登录");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String Str1=textField.getText();
						String Str2=passwordField.getText();
						String sql="select * from administrator";
				    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
				    	try(Connection conn=dbcs.getConnection();//获取数据库接
				    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
				    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
				    		
				    		
				    		while(rs.next()) {//遍历数据集
				    			String s1=rs.getString("account");
					    		String s2=rs.getString("numCode");
				    			if(Str1.equals(s1)&&Str2.equals(s2))
								{
									userFrmTable frame = new userFrmTable();// 实例化窗体
									frame.setLocationRelativeTo(null);// 窗体居中
									frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
									frame.setVisible(true);// 窗体可见
									setVisible(false);
								}
				    			else
								{
									JOptionPane.showMessageDialog(null, "账号或密码错误");
								}
				    		}
							
				    	}catch(SQLException e1) {
				    		e1.printStackTrace();
				    	}	
					}
				});
				okButton.setFont(new Font("华文行楷", Font.BOLD, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("退出");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				cancelButton.setFont(new Font("华文行楷", Font.BOLD, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
