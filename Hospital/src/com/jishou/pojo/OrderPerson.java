package com.jishou.pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.jishou.dao.DatabaseConnectionSql;
import com.jishou.ui.order;

public class OrderPerson {
	private String patientId;
	private String expert;
	private String section;
	private String patientName;
	private String number;
	public OrderPerson(String patientId, String expert, String section, String patientName, String number) {
		super();
		this.patientId = patientId;
		this.expert = expert;
		this.section = section;
		this.patientName = patientName;
		this.number = number;
	}
	   public static Vector<Vector> getSelectAll(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
	    		while(rs.next()) {//�������ݼ�
	    			Vector row=new Vector();//����������
	    			row.add(rs.getString(1));//��ȡ��һ���ֶ�ҽԺ
	    			row.add(rs.getString(2));//��ȡ�ڶ����ֶα��
	    			row.add(rs.getString(3));//��ȡ�������ֶο���
	    			row.add(rs.getString(4));//��ȡ���ĸ��ֶ�����
	    			row.add(rs.getString(5));//��ȡ������ֶ��ֻ�����
	    			rows.add(row);//����������ӵ���¼������
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//��������������
	    }
	    public static void main(String[] args) {
	    }
}