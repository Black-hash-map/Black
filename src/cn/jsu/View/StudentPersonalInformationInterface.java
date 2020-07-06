package cn.jsu.View;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import cn.jsu.Dao.Impl.DatabaseOperateImpl;
import cn.jsu.Vo.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

/**
 * 学生个人信息界面
 * @author 15159
 *
 */

public class StudentPersonalInformationInterface {

	private User u;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	
	public void getUser() {
		this.u = LoginInterface.getUser();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentPersonalInformationInterface window = new StudentPersonalInformationInterface();
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
	public StudentPersonalInformationInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u4E2A\u4EBA\u4FE1\u606F");
		frame.setBounds(100, 100, 599, 305);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		getUser();
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel.setBounds(45, 40, 60, 32);
		desktopPane.add(lblNewLabel);
		
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("黑体", Font.PLAIN, 22));
		textField.setBackground(Color.WHITE);
		textField.setBounds(106, 40, 156, 32);
		textField.setColumns(10);
		desktopPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(305, 40, 60, 32);
		desktopPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("黑体", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(363, 40, 156, 32);
		desktopPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u73ED\u7EA7\uFF1A");
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(45, 105, 60, 32);
		desktopPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("黑体", Font.PLAIN, 22));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(106, 105, 156, 32);
		desktopPane.add(textField_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_2_1.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(305, 105, 60, 32);
		desktopPane.add(lblNewLabel_2_1);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("黑体", Font.PLAIN, 22));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(363, 105, 156, 32);
		desktopPane.add(textField_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("\u5E74\u9F84\uFF1A");
		lblNewLabel_2_2.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(45, 165, 60, 32);
		desktopPane.add(lblNewLabel_2_2);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("黑体", Font.PLAIN, 22));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(106, 165, 156, 32);
		desktopPane.add(textField_4);
		
		FillTestField();
		
		JButton btnNewButton = new JButton("\u5173\u95ED");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 25));
		btnNewButton.setBounds(396, 180, 100, 45);
		desktopPane.add(btnNewButton);
	}

	/**
	  * 填写文本框
	 *@param sql	sql语句
	 *@param rs		执行sql语句得到的结果集
	 *@exception	printStackTrace
	 */
	private void FillTestField(){
		String sql = "select * from student where sno = '"+u.getUsername()+"'";
		try {
			ResultSet rs = new DatabaseOperateImpl().Query(sql);
			while(rs.next()) {
				textField.setText(rs.getString(1));
				textField_1.setText(rs.getString(2));
				textField_2.setText(rs.getString(3));
				textField_3.setText(rs.getString(4));
				textField_4.setText(rs.getString(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
