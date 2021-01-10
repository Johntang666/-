package com.jishou.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.jishou.dao.DatabaseConnectionSql;
import com.jishou.dao.doctorDataOperate;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class order extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JTextField number;
	private JTextField id;
	private JTable table;
	private JPanel contentPane;// ���崰��������壬���ø����
	
	private Vector<String> titles;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			order dialog = new order();
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
	public order() {
		setTitle("\u9884\u7EA6");
		setIconImage(Toolkit.getDefaultToolkit().getImage(order.class.getResource("/Source/5.png")));
		setBounds(100, 100, 673, 441);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ҽԺ");
			lblNewLabel.setBounds(44, 24, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("����");
			lblNewLabel_1.setFont(new Font("����", Font.BOLD, 16));
			lblNewLabel_1.setBounds(153, 89, 69, 24);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("����");
			lblNewLabel_2.setBounds(274, 24, 54, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("�绰����");
			lblNewLabel_3.setFont(new Font("����", Font.BOLD, 16));
			lblNewLabel_3.setBounds(153, 153, 93, 33);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("ҽ����");
			lblNewLabel_4.setFont(new Font("����", Font.BOLD, 16));
			lblNewLabel_4.setBounds(153, 233, 69, 33);
			contentPanel.add(lblNewLabel_4);
		}
		String project[]= {"�����ڿ�","�������","���ڿ�","������","���ڿ�","�ڷ��ڿ�","������","���ڿ�","Ƥ����"};
		JComboBox boxSection = new JComboBox(project);
		
		boxSection.setBounds(311, 18, 174, 27);
		contentPanel.add(boxSection);
			
		    String hospitalName[]= {"�żҽ���·ҽԺ","�żҽ�������ҽԺ","�żҽ���ҽԺ","�żҽ��еڶ�����ҽԺ","�żҽ�������ҽԺ","�żҽ����������ױ���Ժ"};
			JComboBox boxHospital = new JComboBox(hospitalName);
			boxHospital.setBounds(85, 18, 171, 27);
			contentPanel.add(boxHospital);
		{
			name = new JTextField();
			name.setBounds(253, 82, 160, 31);
			contentPanel.add(name);
			name.setColumns(10);
		}
		{
			number = new JTextField();
			number.setBounds(253, 157, 160, 27);
			contentPanel.add(number);
			number.setColumns(10);
		}
		{
			id = new JTextField();
			id.setBounds(253, 237, 120, 27);
			contentPanel.add(id);
			id.setColumns(10);
		}
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(order.class.getResource("/Source/\u9884\u7EA6.jpg")));
		lblNewLabel_5.setBounds(10, 18, 637, 363);
		contentPanel.add(lblNewLabel_5);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				JButton okButton = new JButton("ԤԼ");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
				          String sql="insert into patient(patientId,expert,section,patientName,number) values(?,?,?,?,?)";//ʹ��ռλ������������
				          try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
				           PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
				              ArrayList<String> alist=new ArrayList<String>();//���弯��
				              String patientName=getTxtName();
				             if(!alist.contains(patientName)&&addName()&&addId()&&addNumber()) {//�ж������Ƿ�Ψһ
				             String patientId=getBoxHospital(boxHospital);//��ȡJComBox�е����ݣ�����ҽԺ
				             String expert=getTxtId();//���ר�ұ��
				             String section=getBoxSection(boxSection);//��ȡJComBox�е����ݣ����ڿ���
				             String number=getTxtNumber();
				             pstmt.setString(1,patientId);//�����1��ռλ��������
				             pstmt.setString(2,expert);//�����2��ռλ��������
				             pstmt.setString(3,section);//�����3��ռλ��������
				             pstmt.setString(4,patientName);//�����4��ռλ��������
				             pstmt.setString(5,number);
				             pstmt.executeUpdate();//ִ�в������
					         JOptionPane.showMessageDialog(null, "ԤԼ�ɹ���");
				             }
//				                pstmt.addBatch();//����������ȴ�ִ��
//				             pstmt.executeBatch();//����ִ�в������
//				           JOptionPane.showMessageDialog(null, "ԤԼ�ɹ���");
				          }catch(SQLException e1) {
				           e1.printStackTrace();
				          }						
					}
				});
				okButton.setFont(new Font("���Ŀ���", Font.PLAIN, 15));
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
				cancelButton.setFont(new Font("���Ŀ���", Font.PLAIN, 15));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}
	public  String getTxtName() {
		return name.getText();
	}
	public String getTxtNumber() {
		return number.getText();
	}
	public String getTxtId() {
		return id.getText();
	}
	
	public String getBoxHospital(JComboBox boxHospital) {
		return boxHospital.getSelectedItem().toString();
	}
	public String getBoxSection(JComboBox boxSection) {
		return boxSection.getSelectedItem().toString();
	}
	public boolean  addName() {
		if(name.getText().length()==0)
		  {
			JOptionPane.showMessageDialog(null, "��������Ϊ��");
			name.requestFocus();//�ɼ�������ȡ����
		    return false;
		  }
		  return true;
		}
		public boolean  addNumber() {
		if(number.getText().length()==0||!number.getText().matches("\\d+"))
		{
			JOptionPane.showMessageDialog(null, "���벻��Ϊ���ұ���Ϊ9λ��");
			number.requestFocus();
			number.selectAll();
			return false;
		}
		return  true;	
		}
		public boolean  addId() {
		if(id.getText().length()==0||!id.getText().matches("\\d+"))
		{
			JOptionPane.showMessageDialog(null, "��������Ч��ҽ�����");
			id.requestFocus();
			id.selectAll();
			return false;
		}
		return true;	
}
}
