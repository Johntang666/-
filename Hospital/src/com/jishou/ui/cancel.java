package com.jishou.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jishou.dao.DatabaseConnectionSql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class cancel extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tName;
	private JTextField tNumber;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			cancel dialog = new cancel();
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
	public cancel() {
		setTitle("取消预约");
		setIconImage(Toolkit.getDefaultToolkit().getImage(cancel.class.getResource("/Source/8.png")));
		setBounds(100, 100, 414, 206);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("姓名");
			lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
			lblNewLabel.setBounds(116, 25, 66, 27);
			contentPanel.add(lblNewLabel);
		}
		
		tName = new JTextField();
		tName.setBounds(176, 24, 109, 30);
		contentPanel.add(tName);
		tName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("号码");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_2.setBounds(116, 80, 54, 27);
		contentPanel.add(lblNewLabel_2);
		
		tNumber = new JTextField();
		tNumber.setBounds(176, 83, 109, 27);
		contentPanel.add(tNumber);
		tNumber.setColumns(10);
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(cancel.class.getResource("/Source/\u9884\u7EA6\u56FE\u7247.jpg")));
			lblNewLabel_1.setBounds(10, 0, 388, 134);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("取消预约");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
				          String sql="DELETE from patient where patientName=? and number=?";//使用sql语句进行删除
				          try(Connection conn=dbcs.getConnection();//获取数据库接
				        		  PreparedStatement pstmt=conn.prepareStatement(sql);){
				        	  pstmt.setString(1, tName.getText());
				        	  pstmt.setString(2, tNumber.getText());
				        	  pstmt.addBatch();
				        	pstmt.executeBatch();//更新数据
				        	JOptionPane.showMessageDialog(null, "取消预约成功！");
				          }catch(SQLException e1) {
				  			// TODO Auto-generated catch block
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
