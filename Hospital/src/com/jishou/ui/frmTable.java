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
        jf.setUndecorated(true);		//窗口去边框
        ImageIcon background=new ImageIcon("img/微信图片_20210105083115.jpg");          // 创建一个名为background的图片对象，把背景图片加进去		  
        JLabel bl=new JLabel(background);          // 把上面的图片对象加到一个名为bl的标签里  
        bl.setBounds(0,0,jf.getWidth(),jf.getHeight());        //设置标签大小
        JPanel imagePanel=(JPanel)jf.getContentPane();  		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明 ，使内容窗格透明后才能显示背景图片 
        imagePanel.setOpaque(false);          // 把背景图片添加到分层窗格的最底层作为背景  
        jf.getLayeredPane().add(bl,new Integer(Integer.MIN_VALUE));  
        jf.addMouseListener(new MouseAdapter() {        //设置窗口可拖动
            public void mousePressed(MouseEvent e) {        //获取点击鼠标时的坐标
               mouseAtX = e.getPoint().x;
               mouseAtY= e.getPoint().y;
            }
        });      
        jf.addMouseMotionListener(new MouseMotionAdapter() {        //设置拖拽后，窗口的位置
            public void mouseDragged(MouseEvent e) {
                jf.setLocation(e.getXOnScreen()-mouseAtX,e.getYOnScreen()-mouseAtY);		
            }
        });
        ImageIcon buttonc=new ImageIcon("");		// 创建一个名为buttonc的图片对象，把按钮贴图加进去
        JButton close=new JButton(buttonc);		//实例化按钮对象并加入贴图		
        close.setBounds(353, 2, 28, 28);
        close.setContentAreaFilled(false);		//设置按钮背景透明
        close.setBorderPainted(false);		//去掉按钮边框
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JLabel frtitle=new JLabel("社区医院远程挂号系统");
        frtitle.setBounds(132, 63, 235, 56);
        frtitle.setFont(new Font("华文楷体", Font.BOLD, 20));
		JPanel p=new JPanel();		//实例化JPanel对象
        p.setOpaque(false);
		p.setLayout(null);
		p.add(frtitle);
		p.add(close);
		jf.getContentPane().add(p);
		
		JButton btnNewButton = new JButton("管理员模式");
		btnNewButton.setBounds(182, 201, 149, 45);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userLand dialog = new userLand();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				displayDoctor frame = new displayDoctor();// 实例化窗体
				dialog.setLocationRelativeTo(null);// 窗体居中
				dialog.setVisible(true);
				jf.setVisible(false);//然后当前窗口不可见
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 15));
		p.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("用户模式");
		btnNewButton_1.setBounds(182, 354, 149, 45);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTable01 frame = new frmTable01();// 实例化窗体
				frame.setLocationRelativeTo(null);// 窗体居中
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);// 窗体可见
				jf.setVisible(false);//然后当前窗口不可见
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 15));
		p.add(btnNewButton_1);
		jf.show();
	}
}