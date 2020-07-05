package cn.jsu.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;

import cn.jsu.Model.User;
import cn.jsu.Service.ModifyPassword;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 修改密码界面
 * @author Black
 *
 */

public class ModifyPasswordInterface {

	private JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyPasswordInterface window = new ModifyPasswordInterface();
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
	public ModifyPasswordInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u4FEE\u6539\u5BC6\u7801");
		frame.setBounds(100, 100, 521, 346);
		frame.setResizable(false);  //不能改变窗口的大小
		frame.setLocationRelativeTo(null);//窗体居中
		frame.setVisible(true);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u5F53\u524D\u5BC6\u7801\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 24));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(45, 35, 133, 40);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 24));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(45, 100, 133, 40);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u91CD\u590D\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("黑体", Font.PLAIN, 24));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(45, 165, 153, 40);
		desktopPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 25));
		passwordField.setBounds(190, 35, 250, 40);
		desktopPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("宋体", Font.PLAIN, 25));
		passwordField_1.setBounds(190, 100, 250, 40);
		desktopPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("宋体", Font.PLAIN, 25));
		passwordField_2.setBounds(190, 165, 250, 40);
		desktopPane.add(passwordField_2);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u = LoginInterface.getUser();
				String op = new String(passwordField.getPassword());	//当前密码
				String np = new String(passwordField_1.getPassword());	//新密码
				String rnp = new String(passwordField_2.getPassword());	//重复新密码
				ModifyPassword mp = new ModifyPassword();
				try {
					mp.Modify(op,np,rnp,u,frame);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 25));
		btnNewButton.setBounds(270, 241, 92, 40);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 25));
		btnNewButton_1.setBounds(376, 241, 92, 40);
		desktopPane.add(btnNewButton_1);
	}
}
