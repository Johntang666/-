package com.jishou.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
public class frmTable{
	static int mouseAtX;
	static int mouseAtY;
	public static void main(String[] args) throws Exception {
        JFrame jf=new JFrame();
        jf.setSize(500,500);
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension sc=kit.getScreenSize();
        jf.setLocation((int)(sc.width/2.5f),sc.height/3);
        jf.setUndecorated(true);		//����ȥ�߿�
        ImageIcon background=new ImageIcon("img/΢��ͼƬ_20210105083115.jpg");          // ����һ����Ϊbackground��ͼƬ���󣬰ѱ���ͼƬ�ӽ�ȥ		  
        JLabel bl=new JLabel(background);          // �������ͼƬ����ӵ�һ����Ϊbl�ı�ǩ��  
        bl.setBounds(0,0,jf.getWidth(),jf.getHeight());        //���ñ�ǩ��С
        JPanel imagePanel=(JPanel)jf.getContentPane();  		// �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸�� ��ʹ���ݴ���͸���������ʾ����ͼƬ 
        imagePanel.setOpaque(false);          // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����  
        jf.getLayeredPane().add(bl,new Integer(Integer.MIN_VALUE));  
        jf.addMouseListener(new MouseAdapter() {        //���ô��ڿ��϶�
            public void mousePressed(MouseEvent e) {        //��ȡ������ʱ������
               mouseAtX = e.getPoint().x;
               mouseAtY= e.getPoint().y;
            }
        });      
        jf.addMouseMotionListener(new MouseMotionAdapter() {        //������ק�󣬴��ڵ�λ��
            public void mouseDragged(MouseEvent e) {
                jf.setLocation(e.getXOnScreen()-mouseAtX,e.getYOnScreen()-mouseAtY);		
            }
        });
        ImageIcon buttonc=new ImageIcon("");		// ����һ����Ϊbuttonc��ͼƬ���󣬰Ѱ�ť��ͼ�ӽ�ȥ
        JButton close=new JButton(buttonc);		//ʵ������ť���󲢼�����ͼ		
        close.setBounds(353, 2, 28, 28);
        close.setContentAreaFilled(false);		//���ð�ť����͸��
        close.setBorderPainted(false);		//ȥ����ť�߿�
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JLabel frtitle=new JLabel("����ҽԺԶ�̹Һ�ϵͳ");
        frtitle.setBounds(132, 63, 235, 56);
        frtitle.setFont(new Font("���Ŀ���", Font.BOLD, 20));
		JPanel p=new JPanel();		//ʵ����JPanel����
        p.setOpaque(false);
		p.setLayout(null);
		p.add(frtitle);
		p.add(close);
		jf.getContentPane().add(p);
		
		JButton btnNewButton = new JButton("����Աģʽ");
		btnNewButton.setBounds(182, 201, 149, 45);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userLand dialog = new userLand();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				displayDoctor frame = new displayDoctor();// ʵ��������
				dialog.setLocationRelativeTo(null);// �������
				dialog.setVisible(true);
				jf.setVisible(false);//Ȼ��ǰ���ڲ��ɼ�
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD, 15));
		p.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�û�ģʽ");
		btnNewButton_1.setBounds(182, 354, 149, 45);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTable01 frame = new frmTable01();// ʵ��������
				frame.setLocationRelativeTo(null);// �������
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);// ����ɼ�
				jf.setVisible(false);//Ȼ��ǰ���ڲ��ɼ�
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 15));
		p.add(btnNewButton_1);
		jf.show();
	}
}