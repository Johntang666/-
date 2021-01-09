package cn.edu.jsu.TZP.hospital.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.TZP.hospital.pojo.registerPerson;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class patientLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNumber;
	private JTextField txtCode;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			patientLogin dialog = new patientLogin();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setLocationRelativeTo(null);// 窗体居中
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public patientLogin() {
		setTitle("\u7528\u6237\u767B\u9646");
		setIconImage(Toolkit.getDefaultToolkit().getImage(patientLogin.class.getResource("/Source/6 (1).png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setBounds(166, 78, 54, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(166, 124, 54, 15);
		contentPanel.add(lblNewLabel_1);
		
		txtNumber = new JTextField();
		txtNumber.setBounds(231, 75, 154, 21);
		contentPanel.add(txtNumber);
		txtNumber.setColumns(10);
		
		txtCode = new JTextField();
		txtCode.setBounds(228, 124, 157, 21);
		contentPanel.add(txtCode);
		txtCode.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(patientLogin.class.getResource("/Source/\u767B\u9646\u56FE\u7247.jpg")));
		lblNewLabel_2.setBounds(0, 0, 434, 214);
		contentPanel.add(lblNewLabel_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u767B\u9646");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if((registerPerson.matchData(txtNumber.getText(),txtCode.getText()))&&code()&&number()) {
			    		    JOptionPane.showMessageDialog(null, "登陆成功!");
			    		    mainFrame frame = new mainFrame();
							frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
							setVisible(false);
			    		}else {JOptionPane.showMessageDialog(null, "请输入正确的账号和密码");
			    			txtNumber.setText("");
			    			txtCode.setText("");
			    		}
			    	 
					}
				});
				okButton.setFont(new Font("仿宋", Font.BOLD, 15));
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
				cancelButton.setFont(new Font("仿宋", Font.BOLD, 15));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public boolean  code() {
		if(txtCode.getText().length()==0||txtCode.getText().length()!=9)
		{
			JOptionPane.showMessageDialog(null, "请输入9位密码");
			txtCode.requestFocus();
			txtCode.selectAll();
			return false;
		}
		return  true;	
		}
		public boolean  number() {
		if(txtNumber.getText().length()==0||txtNumber.getText().length()!=11||!txtNumber.getText().matches("\\d+"))
		{
			JOptionPane.showMessageDialog(null, "请输入11位有效账号");
			txtCode.requestFocus();
			txtCode.selectAll();
			return false;
		}
		return  true;	
		}
}
