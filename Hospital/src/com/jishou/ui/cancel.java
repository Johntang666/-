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
		setTitle("ȡ��ԤԼ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(cancel.class.getResource("/Source/8.png")));
		setBounds(100, 100, 414, 206);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("����");
			lblNewLabel.setFont(new Font("����", Font.BOLD, 15));
			lblNewLabel.setBounds(116, 25, 66, 27);
			contentPanel.add(lblNewLabel);
		}
		
		tName = new JTextField();
		tName.setBounds(176, 24, 109, 30);
		contentPanel.add(tName);
		tName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("����");
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 15));
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
				JButton okButton = new JButton("ȡ��ԤԼ");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
				          String sql="DELETE from patient where patientName=? and number=?";//ʹ��sql������ɾ��
				          try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
				        		  PreparedStatement pstmt=conn.prepareStatement(sql);){
				        	  pstmt.setString(1, tName.getText());
				        	  pstmt.setString(2, tNumber.getText());
				        	  pstmt.addBatch();
				        	pstmt.executeBatch();//��������
				        	JOptionPane.showMessageDialog(null, "ȡ��ԤԼ�ɹ���");
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
				JButton cancelButton = new JButton("�˳�");
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
