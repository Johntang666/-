package com.jishou.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jishou.dao.DatabaseConnectionSql;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class modify extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCode;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			modify dialog = new modify();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setLocationRelativeTo(null);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public modify() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setIconImage(Toolkit.getDefaultToolkit().getImage(modify.class.getResource("/Source/\u5361\u901A\u533B\u9662.jpg")));
		setBounds(100, 100, 587, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u60A8\u60F3\u4FEE\u6539\u7684\u5BC6\u7801");
		lblNewLabel.setFont(new Font("仿宋", Font.BOLD, 20));
		lblNewLabel.setBounds(155, 34, 261, 77);
		contentPanel.add(lblNewLabel);
		
		textCode = new JTextField();
		textCode.setBounds(183, 121, 216, 26);
		contentPanel.add(textCode);
		textCode.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(modify.class.getResource("/Source/\u98CE\u666F\u56FE\u4E00.jpg")));
		lblNewLabel_1.setBounds(10, 10, 561, 316);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("确定");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String Str1=textCode.getText();
						String s="tzp";
						String sql="Update administrator Set numCode=? where account=?";
				    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
				    	try(Connection conn=dbcs.getConnection();//获取数据库链接
				    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
				    		//ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
				    		//rs.next();
				    		pstmt.setString(1,Str1);//定义第1个占位符的内容				    		
				            pstmt.setString(2,s);//定义第2个占位符的内容
//				            pstmt.executeUpdate();//执行插入操作
				            pstmt.addBatch();
				        	pstmt.executeBatch();
					        JOptionPane.showMessageDialog(null, "修改成功！");
					        
//					        
				    		setVisible(false);
					        
				    		}catch(SQLException e1) {
					    		e1.printStackTrace();
					    	}
							
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("退出");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
