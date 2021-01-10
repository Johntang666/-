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
	    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
	    		while(rs.next()) {//遍历数据集
	    			Vector row=new Vector();//定义行数据
	    			row.add(rs.getString(1));//获取第一个字段医院
	    			row.add(rs.getString(2));//获取第二个字段编号
	    			row.add(rs.getString(3));//获取第三个字段科室
	    			row.add(rs.getString(4));//获取第四个字段姓名
	    			row.add(rs.getString(5));//获取第五个字段手机号码
	    			rows.add(row);//将行数据添加到记录集合中
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//返回所有行数据
	    }
	    public static void main(String[] args) {
	    }
}