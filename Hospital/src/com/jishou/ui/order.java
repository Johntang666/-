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
	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	
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
			JLabel lblNewLabel = new JLabel("医院");
			lblNewLabel.setBounds(44, 24, 54, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("姓名");
			lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
			lblNewLabel_1.setBounds(153, 89, 69, 24);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("科室");
			lblNewLabel_2.setBounds(274, 24, 54, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("电话号码");
			lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 16));
			lblNewLabel_3.setBounds(153, 153, 93, 33);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("医生号");
			lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 16));
			lblNewLabel_4.setBounds(153, 233, 69, 33);
			contentPanel.add(lblNewLabel_4);
		}
		String project[]= {"急诊内科","急诊外科","心内科","呼吸科","神经内科","内分泌科","肿瘤科","肾内科","皮肤科"};
		JComboBox boxSection = new JComboBox(project);
		
		boxSection.setBounds(311, 18, 174, 27);
		contentPanel.add(boxSection);
			
		    String hospitalName[]= {"张家界铁路医院","张家界市永定医院","张家界中医院","张家界市第二人民医院","张家界市人民医院","张家界永定区妇幼保健院"};
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
				
				JButton okButton = new JButton("预约");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
				          String sql="insert into patient(patientId,expert,section,patientName,number) values(?,?,?,?,?)";//使用占位符定义插入语句
				          try(Connection conn=dbcs.getConnection();//获取数据库接
				           PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
				              ArrayList<String> alist=new ArrayList<String>();//定义集合
				              String patientName=getTxtName();
				             if(!alist.contains(patientName)&&addName()&&addId()&&addNumber()) {//判断姓名是否唯一
				             String patientId=getBoxHospital(boxHospital);//获取JComBox中的数据，所在医院
				             String expert=getTxtId();//获得专家编号
				             String section=getBoxSection(boxSection);//获取JComBox中的数据，所在科室
				             String number=getTxtNumber();
				             pstmt.setString(1,patientId);//定义第1个占位符的内容
				             pstmt.setString(2,expert);//定义第2个占位符的内容
				             pstmt.setString(3,section);//定义第3个占位符的内容
				             pstmt.setString(4,patientName);//定义第4个占位符的内容
				             pstmt.setString(5,number);
				             pstmt.executeUpdate();//执行插入操作
					         JOptionPane.showMessageDialog(null, "预约成功！");
				             }
//				                pstmt.addBatch();//加入批处理等待执行
//				             pstmt.executeBatch();//批量执行插入操作
//				           JOptionPane.showMessageDialog(null, "预约成功！");
				          }catch(SQLException e1) {
				           e1.printStackTrace();
				          }						
					}
				});
				okButton.setFont(new Font("华文楷体", Font.PLAIN, 15));
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
				cancelButton.setFont(new Font("华文楷体", Font.PLAIN, 15));
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
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			name.requestFocus();//成绩输入框获取焦点
		    return false;
		  }
		  return true;
		}
		public boolean  addNumber() {
		if(number.getText().length()==0||!number.getText().matches("\\d+"))
		{
			JOptionPane.showMessageDialog(null, "号码不能为空且必须为9位数");
			number.requestFocus();
			number.selectAll();
			return false;
		}
		return  true;	
		}
		public boolean  addId() {
		if(id.getText().length()==0||!id.getText().matches("\\d+"))
		{
			JOptionPane.showMessageDialog(null, "请输入有效的医生编号");
			id.requestFocus();
			id.selectAll();
			return false;
		}
		return true;	
}
}
