package com.jishou.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class doctorDataOperate {

	private static String firstName="��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	//����Ůҽ������
	private static String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	//������ҽ������
    private static String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��1.0֮�����  (int)(Math.random()*(end-start+1)+start)
        return (int)(Math.random()*(end-start+1)+start);
    }
    private static String project[]= {"�����ڿ�","�������","���ڿ�","������","���ڿ�","�ڷ��ڿ�","������","���ڿ�","Ƥ����"};
    private static String hospitalName[]= {"�żҽ���·ҽԺ","�żҽ�������ҽԺ","�żҽ���ҽԺ","�żҽ��еڶ�����ҽԺ","�żҽ�������ҽԺ","�żҽ����������ױ���Ժ"};
    
   
    
    public static  String getProject() {//�����ÿ���
    	Random pro = new Random();
    	return project[pro.nextInt(9)];
    }
    public static String getHospitalName() {//����������ҽԺ
    	Random hos=new Random();
    	return hospitalName[hos.nextInt(6)];
    }
    
//    System.err.println(r.nextInt(10));
    //�������ҽ�����
    public static StringBuilder getStuno() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	StringBuilder xh=new StringBuilder("2019");//��ź�ǰ4λ��ͬ
    	StringBuilder xh1=new StringBuilder(String.valueOf(getNum(1,10000)));//���ȡ��5λ
    	if(xh1.length()==1) {
    		xh1=xh1.insert(0, "0000");//�����1λ����ǰ������2��0
    		xh=xh.append(xh1);//ǰ4λ���5λƴ�ӳɱ��
    	}else if(xh1.length()==2) {
    		xh1=xh1.insert(0, "000");//�����2λ����ǰ������1��0
    		xh=xh.append(xh1);
    	}else if(xh1.length()==3) {
    		xh1=xh1.insert(0, "00");//�����3λ����ǰ������1��0
    		xh=xh.append(xh1);
    	}else if(xh1.length()==4) {
    		xh1=xh1.insert(0, "0");//�����4λ����ǰ������1��0
    		xh=xh.append(xh1);
    	}else {
    		xh=xh.append(xh1);
    	}
    	return xh;
    }
    //��������������� 
    public static String getChineseName() {
        int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
        int sex=getNum(0,1);//���ȡ�Ƿ�Ϊר�ң�����1Ϊר��ҽ����0Ϊ��ͨ��ҽ����
        String str=boy;//��������Ϊ��ҽ���ַ���
        int length=boy.length();//��ȡ��ҽ���ַ����ĳ���
        if(sex==0){//��������ȡΪ0�������ָ�ΪŮҽ��
            str=girl;
            length=girl.length();
        }
        index=getNum(0,length-1);//�����ȡ���ֵ�λ��
        String second=str.substring(index, index+1);//��ȡ��λ���е�����
        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
        String third="";//Ĭ��û�е�������
        if(hasThird==1){//��������ȡΪ1�����е�������
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//��������
    }
    //�������ҽ����� 
    public static String getSex() {
    	int sex1=getNum(0,1);
    	if(sex1==0){//��������ȡΪ0�������ָ�Ϊ��ͨ��ҽ����
            String sex = "ר��ҽ��";
            return sex;
        }else {
        	String sex = "��ͨҽ��";
            return sex;
        }
        
    }
    
    /**
     * ȡ��ָ��sql��ѯ���ļ�¼
     * @param sql ��ѯ���
     * @return ��ѯ���Ľ����������ΪVectorǶ�׼��ϣ��������DefaultTableModel����ģ��
     */
    public static Vector<Vector> getSelectAll(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//��ȡ��һ���ֶα��
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�����
    			row.add(rs.getString(3));//��ȡ�������ֶο���
    			row.add(rs.getString(4));//��ȡ�������ֶ�ҽԺ
    			row.add(rs.getString(5));//��ȡ�������ֶ�ҽԺ�Ƿ�Ϊר��
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��������������
    }
    
    public static void main(String[] args) {
    	addDoctor();
    }
    public static void addDoctor() {//����ҽ������
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	String sql="insert into doctor(id,username,section,hospital,expert) values(?,?,?,?,?)";//ʹ��ռλ������������
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
        	ArrayList<String> alist=new ArrayList<String>();//���弯��
    		for(int i=1;i<=10000;) {
    			String id=getStuno().toString();//�����ȡ���
    			if(!alist.contains(id)) {//�жϱ���Ƿ�Ψһ
    				alist.add(id);//��ѧ�ż��뼯��
    				String username=getChineseName();//�����ȡ����
    				String expert=getSex();//�����ȡ�Ƿ�Ϊר��
    				String section=getProject();
    				String hospital=getHospitalName();
    				int cj=getNum(50, 100);//�����ȡ�ɼ�
    				pstmt.setString(1, id);//�����1��ռλ��������
    	    		pstmt.setString(2, username);//�����2��ռλ��������
    	    		pstmt.setString(3, section);//�����3��ռλ��������
    	    		pstmt.setString(4,hospital);//�����4��ռλ��������
    	    		pstmt.setString(5,expert);
    	    		pstmt.addBatch();//����������ȴ�ִ��
    				i++;//���ΨһΨһ��ѭ����������ִ��
    			}
    		}
    		pstmt.executeBatch();//����ִ�в������
    		JOptionPane.showMessageDialog(null, "success");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public static void disDoctor1(DefaultTableModel model) {
	    String sql="select id,username,expert from doctor";
	    Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//��ȡҽ�����
    			row.add(rs.getString(2));//��ȡҽ������
    			row.add(rs.getString(3));//��ȡ�Ƿ�Ϊר��
    			model.addRow(row);//����������ӵ���¼������
    			//���������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
}
