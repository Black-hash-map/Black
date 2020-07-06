package cn.jsu.View;

import java.awt.EventQueue;




import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import cn.jsu.Dao.Impl.DatabaseOperateImpl;
import cn.jsu.Dao.Impl.StudentDaoImpl;

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

/**
 * 查看学生信息界面
 * @author Black
 *
 */

public class QueryStudentInformationInterface {

	private JFrame frame;
	private JTable table;
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
					QueryStudentInformationInterface window = new QueryStudentInformationInterface();
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
	public QueryStudentInformationInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5B66\u751F\u4FE1\u606F");
		frame.setBounds(100, 100, 648, 611);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u73ED\u7EA7", "\u6027\u522B", "\u5E74\u9F84"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(30);
		table.getTableHeader().setFont(new Font("黑体", Font.PLAIN, 20));
		table.setFont(new Font("黑体", Font.PLAIN, 20));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setFont(new Font("黑体", Font.PLAIN, 18));
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		
		JPanel panel = new JPanel();
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		
		JButton btnNewButton_1_1 = new JButton("\u5220\u9664");
		
		btnNewButton_1_1.setFont(new Font("黑体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(150)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(btnNewButton)
					.addContainerGap(186, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(73, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
					.addGap(77))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(194)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(79)
					.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(201, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u4FE1\u606F\u64CD\u4F5C");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(0, 0, 126, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(51, 37, 54, 24);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_1.setBounds(104, 37, 126, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(261, 37, 54, 24);
		panel.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(313, 37, 126, 24);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("\u73ED\u7EA7\uFF1A");
		lblNewLabel_2_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(51, 76, 54, 24);
		panel.add(lblNewLabel_2_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(104, 76, 126, 24);
		panel.add(textField_3);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_2_2_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2_2_1.setBounds(261, 76, 54, 24);
		panel.add(lblNewLabel_2_2_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(313, 76, 126, 24);
		panel.add(textField_4);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("\u5E74\u9F84\uFF1A");
		lblNewLabel_2_2_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2_2_2.setBounds(51, 115, 54, 24);
		panel.add(lblNewLabel_2_2_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(104, 115, 126, 24);
		panel.add(textField_5);
		frame.getContentPane().setLayout(groupLayout);
		new StudentDaoImpl().FillTable(table);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//查询
				String sno = textField.getText();
				if(sno == null || "".equals(sno.trim())) {
					JOptionPane.showMessageDialog(null, "查询的学号不能为空");
					new StudentDaoImpl().FillTable(table);
					return;
				}
				new StudentDaoImpl().Query(textField, table);
			}
		});
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 18));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//修改
				new StudentDaoImpl().Modify(textField_1, textField_2, textField_3, textField_4, textField_5, table);
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 18));
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//删除
				new StudentDaoImpl().Del(textField_1, table);
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				String sql = "select * from student";	//sql语句
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
					}
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
	}
	
}
