package cn.jsu.View;

import java.awt.EventQueue;

import java.awt.Font;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import cn.jsu.Dao.Impl.DatabaseOperateImpl;
import cn.jsu.Dao.Impl.StudentGradeDaoImpl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 查看学生成绩界面
 * @author Black
 *
 */

public class QueryStudentGradeInterface {

	private JFrame frame;
	private JTable table;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_3;
	private JLabel lblNewLabel_5;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JLabel lblNewLabel_6;
	private JTextField textField_5;
	private JLabel lblNewLabel_7;
	private JTextField textField_6;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryStudentGradeInterface window = new QueryStudentGradeInterface();
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
	public QueryStudentGradeInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5B66\u751F\u6210\u7EE9\u4FE1\u606F");
		frame.setBounds(100, 100, 785, 680);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u5927\u5B66\u82F1\u8BED4", "\u6570\u636E\u5E93", "Java", "\u8BA1\u7B97\u673A\u7F51\u7EDC"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(30);
		table.getTableHeader().setFont(new Font("黑体", Font.PLAIN, 20));
		table.setFont(new Font("黑体", Font.PLAIN, 20));
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setFont(new Font("黑体", Font.PLAIN, 18));
		textField.setColumns(10);
		
		btnNewButton = new JButton("\u67E5\u8BE2");
		panel = new JPanel();
		
		btnNewButton_1 = new JButton("\u4FEE\u6539");
		
		btnNewButton_2 = new JButton("\u5220\u9664");
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(181)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(226)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(102)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnNewButton))
					.addGap(33)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("\u5B66\u751F\u6210\u7EE9\u4FE1\u606F\u64CD\u4F5C");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(0, 0, 166, 31);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(32, 44, 54, 21);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(131, 44, 135, 24);
		panel.add(textField_1);
		
		lblNewLabel_3 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(301, 44, 54, 21);
		panel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(422, 43, 135, 24);
		panel.add(textField_2);
		
		lblNewLabel_4 = new JLabel("\u5927\u5B66\u82F1\u8BED4\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(32, 90, 99, 21);
		panel.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(131, 90, 135, 24);
		panel.add(textField_3);
		
		lblNewLabel_5 = new JLabel("\u6570\u636E\u5E93\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(301, 90, 72, 21);
		panel.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(422, 90, 135, 24);
		panel.add(textField_4);
		
		lblNewLabel_6 = new JLabel("Java\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(32, 136, 54, 23);
		panel.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(131, 136, 135, 24);
		panel.add(textField_5);
		
		lblNewLabel_7 = new JLabel("\u8BA1\u7B97\u673A\u7F51\u7EDC\uFF1A");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(301, 136, 118, 21);
		panel.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(422, 136, 135, 24);
		panel.add(textField_6);
		frame.getContentPane().setLayout(groupLayout);
		new StudentGradeDaoImpl().FillTable(table);	//填充
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//查询
				String sno = textField.getText();
				if(sno == null || "".equals(sno.trim())) {
					JOptionPane.showMessageDialog(null, "查询的学号不能为空");
					new StudentGradeDaoImpl().FillTable(table);
					return;
				}
				new StudentGradeDaoImpl().Query(textField,table);
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 18));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//修改
				new StudentGradeDaoImpl().Modify(textField_1, textField_2, textField_3, textField_4, textField_5, textField_6, table);
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 18));
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentGradeDaoImpl().Del(textField_1, table);
			}
		});
		btnNewButton_2.setFont(new Font("黑体", Font.PLAIN, 18));
		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String sql = "select * from Grade";	//sql语句
				int num = 0 ;
				try {
					ResultSet rs = new DatabaseOperateImpl().Query(sql);
					while(rs.next()) {
						num = table.getSelectedRow();
						textField_1.setText((String)(table.getValueAt(num, 0)));
						textField_2.setText((String)(table.getValueAt(num, 1)));
						textField_3.setText((String)(table.getValueAt(num, 2)));
						textField_4.setText((String)(table.getValueAt(num, 3)));
						textField_5.setText((String)(table.getValueAt(num, 4)));
						textField_6.setText((String)(table.getValueAt(num, 5)));
					}
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
	}

}
