package cn.jsu.View;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.jsu.Util.DatabaseQuery;
import cn.jsu.Util.DatabaseUpdate;

import java.awt.Font;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

/**
 * 查询用户信息界面
 * @author Black
 *
 */

public class QueryUserInfomtionInterface {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ButtonGroup group;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryUserInfomtionInterface window = new QueryUserInfomtionInterface();
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
	public QueryUserInfomtionInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7528\u6237\u4FE1\u606F");
		frame.setBounds(100, 100, 651, 584);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);	//窗口居中
		
		scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237\u540D", "\u5BC6\u7801", "\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(30);
		table.getTableHeader().setFont(new Font("黑体", Font.PLAIN, 20));
		table.setFont(new Font("黑体", Font.PLAIN, 20));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setFont(new Font("黑体", Font.PLAIN, 18));
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//查询
				String username = textField.getText();
				if(username == null || "".equals(username.trim())) {
					JOptionPane.showMessageDialog(null, "查询的用户名不能为空");
					FillUserTable();
					return;
				}
				QueryUser();
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyInformation();
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 18));
		
		JButton btnNewButton_1_1 = new JButton("\u5220\u9664");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelInformation();
			}
		});
		btnNewButton_1_1.setFont(new Font("黑体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(161)
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnNewButton))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(46)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(panel, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(216)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(56)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u4FE1\u606F\u64CD\u4F5C");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(0, 0, 137, 29);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(49, 36, 72, 29);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_1.setBounds(127, 36, 140, 27);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(295, 36, 54, 29);
		panel.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(346, 36, 140, 27);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("\u7C7B\u522B\uFF1A");
		lblNewLabel_2_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(49, 89, 54, 29);
		panel.add(lblNewLabel_2_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u7BA1\u7406\u5458");
		rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(127, 89, 83, 27);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u8001\u5E08");
		rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setBounds(216, 89, 72, 27);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("\u5B66\u751F");
		rdbtnNewRadioButton_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		rdbtnNewRadioButton_1_1.setBounds(295, 89, 72, 27);
		panel.add(rdbtnNewRadioButton_1_1);
		
		group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_1_1);
		
		frame.getContentPane().setLayout(groupLayout);
		FillUserTable();
		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String sql = "select * from user";	//sql语句
				int num = 0 ;
				try {
					ResultSet rs = DatabaseQuery.Query(sql);
					while(rs.next()) {
						num = table.getSelectedRow();
						textField_1.setText((String)(table.getValueAt(num, 0)));
						textField_2.setText((String)(table.getValueAt(num, 1)));
					}
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
	}
	
	/**
	  * 删除用户信息
	 *@param sno	删除的用户名
	 *@param sql	sql语句
	 *@exception	printStackTrace
	 */
	public void DelInformation() {
		String username = textField_1.getText();
		String sql = "delete from user where username = '"+username+"'";
		try {
			DatabaseUpdate.Update(sql);
			JOptionPane.showMessageDialog(null, "删除成功！");
			FillUserTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	  * 修改用户信息
	 *@param username	姓名
	 *@param password	待修改的密码
	 *@param type	待修改的类型
	 *@exception	printStackTrace
	 */
	public void ModifyInformation() {
		String username = textField_1.getText();
		String password = textField_2.getText();
		String type = null;	//得到类型
		Enumeration<AbstractButton> eab = group.getElements();
		while (eab.hasMoreElements()) {
			AbstractButton btn = eab.nextElement();
			if(btn.isSelected()){
				type=btn.getText();
				break;
			}
		}
		if( password == null || "".equals(password.trim())){
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		if(type == null ){
			JOptionPane.showMessageDialog(null, "类型不能为空！");
			return;
		}
		String sql = "update user set password = '"+password+"', type = '"+type+
				"' where username = '"+username+"'";
		try {
			DatabaseUpdate.Update(sql);
			JOptionPane.showMessageDialog(null, "修改成功！");
			FillUserTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	  * 查询用户信息
	 *@param username	查询的用户名
	 *@param dtm	创建一个表
	 *@param sql	sql语句
	 *@param rs		执行sql语句返回的结果集
	 *@exception	printStackTrace
	 */
	public void QueryUser() {
		String username = textField.getText();
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		try {
			String sql = "select * from user where username = '"+username+"'";
			ResultSet rs = DatabaseQuery.Query(sql);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("username"));
				v.add(rs.getString("password"));
				v.add(rs.getString("type"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	  * 填充用户表
	 *@param dtm	待填充的表
	 *@param sql	sql语句
	 *@param rs		执行sql语句返回的结果集
	 *@exception	printStackTrace
	 */
	public void FillUserTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		try {
			String sql = "select * from user";
			ResultSet rs = DatabaseQuery.Query(sql);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("username"));
				v.add(rs.getString("password"));
				v.add(rs.getString("type"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
