package com.jishou.ui;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;

public class frmTable01 extends JFrame {
	private JPanel contentPane;// ���崰��������壬���ø����
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private TableRowSorter sorter;//����������
	private ArrayList<RowSorter.SortKey> sortKeys;//�����������
	
	private Vector<String> titles;

//	public static void main(String[] args) {
//		frmTable01 frame = new frmTable01();// ʵ��������
//		frame.setLocationRelativeTo(null);// �������
//		frame.setVisible(true);// ����ɼ�
//	}

	/**
	 * ���幹�췽���������弰���.
	 */
	public frmTable01() {
		setTitle("�û�ģʽ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(frmTable01.class.getResource("/Source/1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô���رհ�ť
		setBounds(100, 100, 520, 487);// ���ô���λ�����С
		contentPane = new JPanel();// ʵ�����������
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		setContentPane(contentPane);// ������Ĭ�����

		

		
		
		JLabel lblNewLabel = new JLabel("����ҽԺԶ�̹Һ�ϵͳ");
		lblNewLabel.setFont(new Font("���Ŀ���", Font.PLAIN, 30));
		lblNewLabel.setBounds(95, 25, 346, 45);
		contentPane.add(lblNewLabel);
		
		JButton displayButton = new JButton("��ʾҽԺ��ר��");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayDoctor frame = new displayDoctor();// ʵ��������
				frame.setLocationRelativeTo(null);// �������
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);// ����ɼ�
			}
		});
		displayButton.setFont(new Font("�����п�", Font.BOLD, 15));
		displayButton.setBounds(95, 206, 346, 33);
		contentPane.add(displayButton);
		
		JButton registerButton = new JButton("ע��");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register dialog = new register();
				dialog.setLocationRelativeTo(null);// �������
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				setVisible(false);
			}
		});
		registerButton.setFont(new Font("�����п�", Font.BOLD, 15));
		registerButton.setBounds(95, 278, 346, 33);
		contentPane.add(registerButton);
		
		JButton landingButton = new JButton("��½��ѯ���Һż�ȡ���Һ�");
		landingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				patientLogin dialog = new patientLogin();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);// �������
				dialog.setVisible(true);
			}
		});
		landingButton.setFont(new Font("�����п�", Font.BOLD, 15));
		landingButton.setBounds(95, 348, 346, 33);
		contentPane.add(landingButton);
		
		JButton exitButton = new JButton("\u9000\u51FA");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(390, 404, 93, 23);
		contentPane.add(exitButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(frmTable01.class.getResource("/Source/\u56FE\u72473.jpg")));
		lblNewLabel_1.setBounds(10, 10, 722, 473);
		contentPane.add(lblNewLabel_1);
	}
}
