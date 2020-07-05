package cn.jsu.View;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 登录日志界面
 * @author Black
 *
 */

public class LoginDiaryInterface {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	File file = new File("D://登录日志.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDiaryInterface window = new LoginDiaryInterface();
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
	public LoginDiaryInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u767B\u5F55\u65E5\u5FD7");
		frame.setBounds(100, 100, 578, 495);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setFont(new Font("黑体", Font.PLAIN, 18));
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField.getText();
				if(user == null || "".equals(user.trim())) {
					JOptionPane.showMessageDialog(null, "用户名不能为空！");
					FillDiary();
					return;
				}
				QueryDiary();
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String time = textField_2.getText();
				if(time == null || "".equals(time.trim())) {
					JOptionPane.showMessageDialog(null, "登录时间不能为空！");
					return;
					
				}
				try {
					ModifyDiary();
					JOptionPane.showMessageDialog(null, "修改成功！");
					FillDiary();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JButton btnNewButton_1_1 = new JButton("\u5220\u9664");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DelDiary();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("黑体", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(108)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(scrollPane, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(167)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u767B\u5F55\u65E5\u5FD7\u64CD\u4F5C");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(0, 0, 122, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(36, 29, 80, 28);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_1.setBounds(136, 29, 178, 28);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u767B\u5F55\u65F6\u95F4\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(36, 67, 100, 28);
		panel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 18));
		textField_2.setBounds(136, 67, 178, 28);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				textField_1.setText((String)table.getValueAt(row, 0));
				textField_2.setText((String)table.getValueAt(row, 1));
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237\u540D", "\u767B\u5F55\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(25);
		table.getTableHeader().setFont(new Font("黑体", Font.PLAIN, 20));
		table.setFont(new Font("黑体", Font.PLAIN, 20));
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
		FillDiary();
	}

	/**
	  * 删除日志
	 *@param username	删除的用户名
	 *@param time	删除的时间
	 *@param arr	存放所有日志的集合
	 *@exception Exception
	 */
	@SuppressWarnings("resource")
	private void DelDiary() throws Exception {
		String username = textField_1.getText();
		String time = textField_2.getText();
		ArrayList<String> arr = new ArrayList<String>();
		BufferedWriter bw = null;
		BufferedReader br = null;
		String s = null;
		br = new BufferedReader(new FileReader(file));
		while((s = br.readLine()) != null) {
				if(s.equals(username+" "+time)) {
					continue;
				}
				arr.add(s);
			}
		bw = new BufferedWriter(new FileWriter(file));
		for(String str : arr) {
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		JOptionPane.showMessageDialog(null, "删除成功！");
		FillDiary();
	}

	/**
	  * 修改日志
	 *@param username	修改的用户名
	 *@param time	修改的时间
	 *@param arr	存放所有日志的集合
	 *@exception Exception
	 */
	@SuppressWarnings("resource")
	private void ModifyDiary() throws Exception {
		String username = textField_1.getText();
		String time = textField_2.getText();
		BufferedWriter bw = null;
		BufferedReader br = null;
		ArrayList<String> arr = new ArrayList<String>();
		br = new BufferedReader(new FileReader(file));
		String s = null;
		while((s = br.readLine()) != null) {
				String[] arrstr = s.split(" ");
				if((username.equals(arrstr[0]))) {
					arr.add(username.concat(" "+time));
					continue;
				}
				arr.add(s);
			}
			bw = new BufferedWriter(new FileWriter(file));
			for(String str : arr) {
				bw.newLine();
				bw.flush();
			}
	}

	/**
	  * 查询日志
	 *@param username	待查询的用户名 
	 *@param dtm	创建一个表
	 *@param arr	存放所有日志的集合
	 *@exception Exception
	 */
	private void QueryDiary() {
		String username = textField.getText();
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		ArrayList<String> arr = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;
			try {
				while((s = br.readLine()) != null) {
					arr.add(s);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		for(String str : arr) {
			Vector<String> v = new Vector<String>();
			String[] arrstr = str.split(" ");
			if(username.equals(arrstr[0])) {
				v.add(arrstr[0]);
				v.add(arrstr[1]+" "+arrstr[2]);
				dtm.addRow(v);
			}
		}
		
	}

	/**
	  * 填充日志表
	 *@param dtm	待填充的表
	 *@param arr	存放所有日志的集合
	 *@exception Exception
	 */
	private void FillDiary() {
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		ArrayList<String> arr = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;
			try {
				while((s = br.readLine()) != null) {
					arr.add(s);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		for(String str : arr) {
			Vector<String> v = new Vector<String>();
			String[] arrstr = str.split(" ");
			v.add(arrstr[0]);
			v.add(arrstr[1]+" "+arrstr[2]);
			dtm.addRow(v);
		}
	}
}
