package cn.edu.jsu.TZP.hospital.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.TZP.hospital.pojo.*;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
public class register extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textName;
	private JTextField textAge;
	private JTextField textId;
	private JTextField textCode;
	private JTextField textNumber;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			register dialog = new register();
//			dialog.setLocationRelativeTo(null);// 窗体居中
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public register() {
		setTitle("\u6CE8\u518C");
		setIconImage(Toolkit.getDefaultToolkit().getImage(register.class.getResource("/Source/19.png")));
		setBounds(100, 100, 641, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel labelName = new JLabel("\u59D3\u540D");
			labelName.setFont(new Font("仿宋", Font.BOLD, 13));
			labelName.setBounds(138, 25, 54, 15);
			contentPanel.add(labelName);
		}
		{
			setTextName(new JTextField());
			getTextName().setBounds(231, 22, 125, 21);
			contentPanel.add(getTextName());
			getTextName().setColumns(10);
		}
		{
			JLabel labelAge = new JLabel("\u5E74\u9F84");
			labelAge.setFont(new Font("仿宋", Font.BOLD, 13));
			labelAge.setBounds(138, 68, 54, 15);
			contentPanel.add(labelAge);
		}
		{
			textAge = new JTextField();
			textAge.setText("");
			textAge.setBounds(231, 65, 125, 21);
			contentPanel.add(textAge);
			textAge.setColumns(10);
		}
		{
			JLabel labelId = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\u7801");
			labelId.setFont(new Font("仿宋", Font.BOLD, 13));
			labelId.setBounds(139, 108, 66, 18);
			contentPanel.add(labelId);
		}
		{
			textId = new JTextField();
			textId.setBounds(231, 107, 209, 21);
			contentPanel.add(textId);
			textId.setColumns(10);
		}
		{
			JLabel labelCode = new JLabel("\u5BC6\u7801");
			labelCode.setFont(new Font("仿宋", Font.BOLD, 13));
			labelCode.setBounds(138, 149, 54, 15);
			contentPanel.add(labelCode);
		}
		{
			textCode = new JTextField();
			textCode.setBounds(231, 146, 168, 21);
			contentPanel.add(textCode);
			textCode.setColumns(10);
		}
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u662F\u5426\u540C\u610F\u6CE8\u518C\u6761\u6B3E");
		rdbtnNewRadioButton.setBounds(416, 295, 121, 23);
		contentPanel.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7\uFF08\u624B\u673A\u53F7\u7801\uFF09");
		lblNewLabel_1.setFont(new Font("仿宋", Font.BOLD, 13));
		lblNewLabel_1.setBounds(73, 197, 104, 19);
		contentPanel.add(lblNewLabel_1);
		
		textNumber = new JTextField();
		textNumber.setBounds(188, 197, 115, 19);
		contentPanel.add(textNumber);
		textNumber.setColumns(10);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(register.class.getResource("/Source/1.png")));
			lblNewLabel.setBounds(10, -16, 356, 255);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u6CE8\u518C");
				okButton.setFont(new Font("华文行楷", Font.BOLD, 15));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(addName()&&addAge()&addId()&&addCode()&&addNumber())//进行输入数据检验
					    {
					    	 String stu=textName.getText()+"\t"+textAge.getText()+"\t"+textId.getText()+"\t"+textCode.getText()+"\t"+textNumber.getText()+"\r\n";
					    	 if(registerPerson.addData(stu,textNumber.getText())) {
					    		    JOptionPane.showMessageDialog(null, "注册成功!");
					    		}else {JOptionPane.showMessageDialog(null, "此号码已注册！");
					    		}
					    	 flush();
					    	 }
						
					}
				});
				
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
				cancelButton.setFont(new Font("华文行楷", Font.BOLD, 15));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		textName.addFocusListener(new FocusAdapter() {//给文本框增加焦点监听事件
			  public void focusLost(FocusEvent e) {//监听文本框失去焦点
			   addName();
			  }
			});
		textAge.addFocusListener(new FocusAdapter() {//给文本框增加焦点监听事件
				  public void focusLost(FocusEvent e) {//监听文本框失去焦点
				   addAge();
				  }
				});
		textId.addFocusListener(new FocusAdapter() {//给文本框增加焦点监听事件
				  public void focusLost(FocusEvent e) {//监听文本框失去焦点
				   addId();
				  }
				});
		textCode.addFocusListener(new FocusAdapter() {//给文本框增加焦点监听事件
			  public void focusLost(FocusEvent e) {//监听文本框失去焦点
			   addCode();
			  }
			});
		textNumber.addFocusListener(new FocusAdapter() {//给文本框增加焦点监听事件
			  public void focusLost(FocusEvent e) {//监听文本框失去焦点
			   addNumber();
			  }
			});
	}
	public void flush()
	{
		textName.setText("");
		textAge.setText("");
		textId.setText("");
		textCode.setText("");
		textNumber.setText("");
	}
	public boolean  addName() {
		if(textName.getText().length()==0)
		  {
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			textName.requestFocus();//成绩输入框获取焦点
		    return false;
		  }
		  return true;
		}
		public boolean  addAge() {
		if(textAge.getText().length()==0||!textAge.getText().matches("\\d+"))
		{
			JOptionPane.showMessageDialog(null, "年龄不能为空且必须为整数");
			textAge.requestFocus();
			textAge.selectAll();
			return false;
		}
		return  true;	
		}
		public boolean  addId() {
		if(textId.getText().length()==0||!textId.getText().matches("\\d+")||textId.getText().length()!=18)
		{
			JOptionPane.showMessageDialog(null, "请输入规范的身份证号码");
			textId.requestFocus();
			textId.selectAll();
			return false;
		}
		return true;
		}
		public boolean  addCode() {
		if(textCode.getText().length()==0||textCode.getText().length()!=9)
		{
			JOptionPane.showMessageDialog(null, "请输入9位密码");
			textCode.requestFocus();
			textCode.selectAll();
			return false;
		}
		return  true;	
		}
		public boolean  addNumber() {
		if(textNumber.getText().length()==0||textNumber.getText().length()!=11||!textNumber.getText().matches("\\d+"))
		{
			JOptionPane.showMessageDialog(null, "请输入11位有效手机号码");
			textCode.requestFocus();
			textCode.selectAll();
			return false;
		}
		return  true;	
		}
	public JTextField getTextName() {
		return textName;
	}


	public void setTextName(JTextField textName) {
		this.textName = textName;
	}


	public JTextField getTextAge() {
		return textAge;
	}


	public void setTextAge(JTextField textAge) {
		this.textAge = textAge;
	}


	public JTextField getTextId() {
		return textId;
	}


	public void setTextId(JTextField textId) {
		this.textId = textId;
	}


	public JTextField getTextCode() {
		return textCode;
	}


	public void setTextCode(JTextField textCode) {
		this.textCode = textCode;
	}


	public JTextField getTextNumber() {
		return textNumber;
	}


	public void setTextNumber(JTextField textNumber) {
		this.textNumber = textNumber;
	}


	public JPanel getContentPanel() {
		return contentPanel;
	}
	
}
