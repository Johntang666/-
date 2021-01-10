package com.jishou.pojo;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.jishou.dao.DatabaseConnectionSql;
import com.jishou.ui.register;

public class RegisterPerson {
	private String name;
	private int age;
	private String personId;
	private String code;
	private String personNumber;
	public RegisterPerson(String name, int age, String personId, String code, String personNumber) {
		super();
		this.name = name;
		this.age = age;
		this.personId = personId;
		this.code = code;
		this.personNumber = personNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPersonNumber() {
		return personNumber;
	}
	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}
	final static File file=new File("D:/JAVA/hospital/用户注册.txt");
	public static boolean addData(String stu,String uid) {
		  try(FileReader fr=new FileReader(file);
		      FileWriter fw=new FileWriter(file,true);){
		    char[] tmp=new char[1024];
		    int len=0;
		    while((len=fr.read(tmp))!=-1) {
		       if(new String(tmp,0,len).contains(uid)) {//读取的数据中包含账号
		         return false;
		    }}
		    fw.write(stu);
		  }catch(Exception e1) {e1.printStackTrace();}
		  return true;
		}
	public static boolean matchData(String code,String number) {
		  try(FileReader fr=new FileReader(file);
		      FileWriter fw=new FileWriter(file,true);){
		    char[] tmp=new char[1024];
		    int len=0;
		    while((len=fr.read(tmp))!=-1) {
		       if(new String(tmp,0,len).contains(code)&&new String(tmp,0,len).contains(number)) {//读取的数据中包含账号
		         return true;
		    }}
		  }catch(Exception e1) {e1.printStackTrace();}
		  return false;
		}
}
	
