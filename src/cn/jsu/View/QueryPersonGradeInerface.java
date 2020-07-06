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

public class QueryPersonGradeInerface {

	private User u;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	
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
					QueryPersonGradeInerface window = new QueryPersonGradeInerface();
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
	public QueryPersonGradeInerface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6210\u7EE9\u5355");
		frame.setBounds(100, 100, 726, 359);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		getUser();
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel.setBounds(35, 35, 60, 32);
		desktopPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("黑体", Font.PLAIN, 18));
		textField.setBounds(151, 33, 156, 32);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(359, 35, 60, 32);
		desktopPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("黑体", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(483, 35, 156, 32);
		desktopPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5927\u5B66\u82F1\u8BED4\uFF1A");
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(35, 100, 110, 32);
		desktopPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("黑体", Font.PLAIN, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(151, 100, 156, 32);
		desktopPane.add(textField_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u6570\u636E\u5E93\uFF1A");
		lblNewLabel_2_1.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(359, 100, 80, 30);
		desktopPane.add(lblNewLabel_2_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("黑体", Font.PLAIN, 18));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(483, 100, 156, 32);
		desktopPane.add(textField_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("Java\uFF1A");
		lblNewLabel_2_2.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(35, 165, 60, 32);
		desktopPane.add(lblNewLabel_2_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("黑体", Font.PLAIN, 18));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(151, 165, 156, 32);
		desktopPane.add(textField_4);
		
		JLabel lblNewLabel_2_3 = new JLabel("\u8BA1\u7B97\u673A\u7F51\u7EDC\uFF1A");
		lblNewLabel_2_3.setFont(new Font("黑体", Font.PLAIN, 20));
		lblNewLabel_2_3.setBounds(359, 165, 127, 32);
		desktopPane.add(lblNewLabel_2_3);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("黑体", Font.PLAIN, 18));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(483, 165, 156, 32);
		desktopPane.add(textField_5);
		
		FillTestField();
		
		JButton btnNewButton = new JButton("\u5173\u95ED");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 25));
		btnNewButton.setBounds(517, 237, 100, 45);
		desktopPane.add(btnNewButton);
	}

	/**
	  * 填充文本框
	 *@param sql	sql语句
	 *@param rs		执行sql语句返回的结果集
	 *@exception	printStackTrace
	 */
	private void FillTestField() {
		String sql = "select * from grade where sno = '"+u.getUsername()+"'";
		try {
			ResultSet rs = new DatabaseOperateImpl().Query(sql);
			while(rs.next()) {
				textField.setText(rs.getString(1));
				textField_1.setText(rs.getString(2));
				textField_2.setText(rs.getString(3));
				textField_3.setText(rs.getString(4));
				textField_4.setText(rs.getString(5));
				textField_5.setText(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
