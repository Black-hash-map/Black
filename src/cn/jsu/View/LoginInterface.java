package cn.jsu.View;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import cn.jsu.Dao.Impl.DatabaseOperateImpl;
import cn.jsu.Vo.User;

import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 登录界面
 * @author Black
 *
 */

public class LoginInterface {

	private JFrame frame;
	private static JTextField textField;
	private static JPasswordField passwordField;
	static JComboBox comboBox;
	File file = new File("D://登录日志.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInterface window = new LoginInterface();
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
	public LoginInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Java\u4EE3\u7801\\JavaWork\\\u8BFE\u8BBE\\Image\\Login.png"));
		frame.setTitle("\u7528\u6237\u767B\u5F55");
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);//窗体居中
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);  //不能改变窗口的大小
		frame.setVisible(true);	//显示窗口
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel.setBounds(97, 125, 100, 39);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("黑体", Font.PLAIN, 25));
		textField.setBounds(187, 125, 208, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(97, 205, 75, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 25));
		passwordField.setBounds(187, 205, 208, 39);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u5B66\u7C4D\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_2.setFont(new Font("华文行楷", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(66, 32, 400, 54);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		JLabel label = new JLabel("\u7C7B\u578B\uFF1A");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(209, 259, 60, 24);
		frame.getContentPane().add(label);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7BA1\u7406\u5458", "\u8001\u5E08", "\u5B66\u751F"}));
		comboBox.setBounds(283, 259, 73, 24);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //登录
				String username = textField.getText();	//得到账号
				String password = new String(passwordField.getPassword());	//得到密码
				String type = comboBox.getSelectedItem().toString();	//获取当前用户的类型
				if(username == null || "".equals(username.trim())) {	//账号不能为空
					JOptionPane.showMessageDialog(null, "账号不能为空！");
					return;
				}
				if(password == null || "".equals(password.trim())) {	//密码不能为空
					JOptionPane.showMessageDialog(null, "密码不能为空！");
					return;
				}
				String sql = "select *from user where username='" + username + "'";	//定义sql语句
				try {
					ResultSet rs = new DatabaseOperateImpl().Query(sql);
					if(rs.next()) {
						if(rs.getString(2).equals(password) && rs.getString(3).equals(type)) {
							AddDiary();
							JOptionPane.showMessageDialog(null, "登陆成功！");
							frame.dispose();
							if(type.equals("管理员")) {
								new AdminInterface();
							}else if(type.equals("老师")) {
								new TeacherInterface();
							}else {
								new StudentInterface();
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "密码错误或者类型错误");
						}
					}else {
						JOptionPane.showMessageDialog(null, "账号不存在！");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(97, 295, 90, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //重置
				Reset();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(305, 295, 90, 39);
		frame.getContentPane().add(btnNewButton_1);
		
	}
	
	/**
	  * 添加日志
	 *@param sdf	时间的格式
	 *@param time	当前系统时间
	 *@param flag	标志添加的日志中存不存在
	 *@exception Exception
	 */
	@SuppressWarnings("resource")
	public void AddDiary() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		BufferedWriter bw = null;
		BufferedReader br = null;
		ArrayList<String> arr = new ArrayList<String>();
		br = new BufferedReader(new FileReader(file));
		String s = null;
		boolean flag = false;	//用来标识用户日志存在不存在
		while((s = br.readLine()) != null) {
				String[] arrstr = s.split(" ");
				if((textField.getText().equals(arrstr[0]))) {
					arr.add(textField.getText().concat(" "+time));
					flag = true;
					continue;
				}
				arr.add(s);
			}
		if(flag) {
			bw = new BufferedWriter(new FileWriter(file));
			for(String str : arr) {
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		}else {
			bw = new BufferedWriter(new FileWriter(file,true));
			bw.write(textField.getText().concat(" "+time));
			bw.newLine();
			bw.flush();
			bw.close();
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public void Reset() {
		textField.setText("");	//账号重置
		passwordField.setText("");	//密码重置
	}
	
	/**
	  * 得到登录的用户信息
	 *@param username	得到账号
	 *@param password	得到密码
	 *@param type	得到类型
	 */
	public static User getUser() {
		String username = textField.getText();	//得到账号
		String password = new String(passwordField.getPassword());	//得到密码
		String type = comboBox.getSelectedItem().toString();	//获取当前用户的类型
		User u = new User(username,password,type);
		return u;
	}
}

