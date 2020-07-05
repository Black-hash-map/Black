package cn.jsu.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import cn.jsu.Util.DatabaseQuery;
import cn.jsu.Util.DatabaseUpdate;

import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

/**
  * 添加用户界面
 * @author Black
 *
 */

public class AddUserInterface {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private ButtonGroup group;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUserInterface window = new AddUserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddUserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6DFB\u52A0\u65B0\u7528\u6237");
		frame.setBounds(100, 100, 485, 357);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel.setBounds(50, 27, 100, 40);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(50, 80, 100, 40);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u9009\u62E9\u7C7B\u578B\uFF1A");
		lblNewLabel_1_1.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(50, 186, 125, 40);
		desktopPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("黑体", Font.PLAIN, 25));
		textField.setBounds(173, 27, 226, 40);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u5B9A\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(50, 133, 125, 40);
		desktopPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u7BA1\u7406\u5458");
		rdbtnNewRadioButton.setFont(new Font("黑体", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(175, 193, 80, 29);
		desktopPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u8001\u5E08");
		rdbtnNewRadioButton_1.setFont(new Font("黑体", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.setBounds(271, 193, 80, 29);
		desktopPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("\u5B66\u751F");
		rdbtnNewRadioButton_1_1.setFont(new Font("黑体", Font.PLAIN, 16));
		rdbtnNewRadioButton_1_1.setBounds(367, 193, 80, 29);
		desktopPane.add(rdbtnNewRadioButton_1_1);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 25));
		btnNewButton.setBounds(205, 246, 91, 40);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 25));
		btnNewButton_1.setBounds(325, 246, 91, 40);
		desktopPane.add(btnNewButton_1);
		
		group = new ButtonGroup();	//把单选按钮放到一个组里面
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 25));
		passwordField.setBounds(173, 80, 226, 40);
		desktopPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("宋体", Font.PLAIN, 25));
		passwordField_1.setBounds(173, 133, 226, 40);
		desktopPane.add(passwordField_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser();
			}
		});
		
	}

	/**
	  * 添加用户
	 *@param username	得到输入的账号
	 *@param password	得到输入的密码
	 *@param type	得到输入的类型
	 *@exception printStackTrace
	 */
	public void AddUser() {
		String username = textField.getText();	//得到账号
		String password1 = new String(passwordField.getPassword());	//得到密码
		String passwrod2 = new String(passwordField_1.getPassword());	//得到确定密码
		String type = null;	//得到类型
		Enumeration<AbstractButton> eab = group.getElements();	//得到所有的单选按钮 
		while (eab.hasMoreElements()) {
			AbstractButton btn = eab.nextElement();
			if(btn.isSelected()){	//判断是否选中按钮
				type=btn.getText();	//有选中，把选中的按钮复制给type
				break;
			}
		}
		if(username == null || "".equals(username.trim())) {	//账号不能为空
			JOptionPane.showMessageDialog(null, "账号不能为空！");
			return;
		}
		if(password1 == null || "".equals(password1.trim())) {	//密码不能为空
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		if(!password1.equals(passwrod2)) {	//两个密码不一样
			JOptionPane.showMessageDialog(null, "密码不一致！");
			return;
		}
		if(type == null) {	//没选类型
			JOptionPane.showMessageDialog(null, "没选类型！");
			return;
		}
		String sql1 = "select * from user";	//定义sql语句
		try {
			ResultSet rs = DatabaseQuery.Query(sql1);
			while(rs.next()) {
				if(rs.getString(1).equals(username)) {
					JOptionPane.showMessageDialog(null, "该用户已经存在了！");
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//数据库添加
		String sql2 = "insert into user values('"+username+"','"+
				password1+"','"+type+"')";	//定义sql语句
		try {
			DatabaseUpdate.Update(sql2);
			JOptionPane.showMessageDialog(null, "添加成功");
			frame.dispose();
		} catch (Exception e1) {
				e1.printStackTrace();
		}
	}
}
