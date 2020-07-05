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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

/**
  * 录入成绩界面
 * @author Black
 *
 */

public class GradeEnterInterface {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeEnterInterface window = new GradeEnterInterface();
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
	public GradeEnterInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6210\u7EE9\u5F55\u5165");
		frame.setBounds(100, 100, 781, 395);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel.setBounds(45, 30, 76, 38);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(390, 30, 76, 38);
		desktopPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("黑体", Font.PLAIN, 22));
		textField.setBounds(122, 30, 221, 38);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("黑体", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(468, 31, 221, 38);
		desktopPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5927\u5B66\u82F1\u8BED4\uFF1A");
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(45, 120, 138, 43);
		desktopPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("黑体", Font.PLAIN, 22));
		textField_2.setBounds(181, 120, 58, 38);
		desktopPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u6570\u636E\u5E93\uFF1A");
		lblNewLabel_2_1.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_2_1.setBounds(390, 120, 100, 43);
		desktopPane.add(lblNewLabel_2_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("黑体", Font.PLAIN, 22));
		textField_3.setColumns(10);
		textField_3.setBounds(486, 120, 58, 38);
		desktopPane.add(textField_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("Java\uFF1A");
		lblNewLabel_2_2.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_2_2.setBounds(45, 210, 90, 43);
		desktopPane.add(lblNewLabel_2_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("黑体", Font.PLAIN, 22));
		textField_4.setColumns(10);
		textField_4.setBounds(122, 212, 58, 38);
		desktopPane.add(textField_4);
		
		JLabel lblNewLabel_2_3 = new JLabel("\u8BA1\u7B97\u673A\u7F51\u7EDC\uFF1A");
		lblNewLabel_2_3.setFont(new Font("黑体", Font.PLAIN, 25));
		lblNewLabel_2_3.setBounds(390, 210, 154, 43);
		desktopPane.add(lblNewLabel_2_3);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("黑体", Font.PLAIN, 22));
		textField_5.setColumns(10);
		textField_5.setBounds(540, 212, 58, 38);
		desktopPane.add(textField_5);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnterGrade();
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 25));
		btnNewButton.setBounds(180, 281, 100, 43);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 25));
		btnNewButton_1.setBounds(460, 281, 100, 43);
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reset();
			}
		});
		btnNewButton_2.setFont(new Font("黑体", Font.PLAIN, 25));
		btnNewButton_2.setBounds(320, 281, 100, 43);
		desktopPane.add(btnNewButton_2);
	}

	/**
	  * 录入成绩
	 *@param sno	待录入的学号
	 *@param sname	待录入的姓名
	 *@param english	英语成绩
	 *@param databank	数据库成绩
	 *@param java	Java成绩
	 *@param internet 网络成绩
	 *@exception printStackTrace
	 */
	public void EnterGrade() {
		String sno = textField.getText();
		String sname = textField_1.getText();
		String english = textField_2.getText();
		String databank = textField_3.getText();
		String java = textField_4.getText();
		String internet = textField_5.getText();
		if(sno == null || "".equals(sno.trim())) {
			JOptionPane.showMessageDialog(null, "学号不能为空！");
			return;
		}
		if(sname == null || "".equals(sname.trim())) {
			JOptionPane.showMessageDialog(null, "姓名不能为空！");
			return;
		}
		if(english == null || "".equals(english.trim()) 
				|| databank == null || "".equals(databank.trim())
				|| java == null || "".equals(java.trim()) 
				|| internet == null || "".equals(internet.trim())) {
			JOptionPane.showMessageDialog(null, "成绩不能为空！");
			return;
		}
		String sql1 = "select * from grade";
		try {
			ResultSet rs = DatabaseQuery.Query(sql1);
			while(rs.next()) {
				if(rs.getString(1).equals(sno)) {
					JOptionPane.showMessageDialog(null, "添加的成绩已经有了！");
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sql2 = "insert into grade values('"+sno+"','"+sname+"',"+english+","+databank+","+java+","+internet+")";	//定义sql语句
		try {
			DatabaseUpdate.Update(sql2);
			JOptionPane.showMessageDialog(null, "添加成功！");
			Reset();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

	public void Reset() {	//重置
		textField.setText("");		//学号重置
		textField_1.setText("");	//姓名重置
		textField_2.setText("");	//大学英语4重置
		textField_3.setText("");	//数据库重置
		textField_4.setText("");	//Java重置
		textField_5.setText("");	//计算机网络重置
	}
}
