package com.jishou.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class userFrmTable extends JFrame {
	private JPanel contentPane;// ���崰��������壬���ø����
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private TableRowSorter sorter;//����������
	private ArrayList<RowSorter.SortKey> sortKeys;//�����������
	
	private Vector<String> titles;
	public userFrmTable() {
		setTitle("����Ա");
		setIconImage(Toolkit.getDefaultToolkit().getImage(userFrmTable.class.getResource("/Source/0 (1).png")));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô���رհ�ť
		setBounds(100, 100, 586, 429);// ���ô���λ�����С
		contentPane = new JPanel();// ʵ�����������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		setContentPane(contentPane);// ������Ĭ�����
		JButton btnNewButton = new JButton("ҽ����Ϣ����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayDoctor frame = new displayDoctor();// ʵ��������
				frame.setLocationRelativeTo(null);// �������
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);// ����ɼ�
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("���Ŀ���", Font.BOLD, 15));
		btnNewButton.setBounds(202, 195, 162, 39);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�޸�����");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modify dialog = new modify();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("���Ŀ���", Font.BOLD, 15));
		btnNewButton_1.setBounds(202, 264, 162, 39);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(userFrmTable.class.getResource("/Source/19.png")));
		lblNewLabel.setBounds(235, 43, 129, 99);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(userFrmTable.class.getResource("/Source/\u533B\u96621.jpg")));
		lblNewLabel_1.setBounds(30, 10, 560, 357);
		contentPane.add(lblNewLabel_1);
	}
}
