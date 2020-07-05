package cn.jsu.View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import cn.jsu.Model.User;
import cn.jsu.Util.DatabaseQuery;
import cn.jsu.Util.DatabaseUpdate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
  * ����ѡ�ν���
 * @author Black
 *
 */

public class ChoiceCourseInterface {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoiceCourseInterface window = new ChoiceCourseInterface();
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
	public ChoiceCourseInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u7F51\u4E0A\u9009\u8BFE");
		frame.setBounds(100, 100, 707, 502);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u53F7\uFF1A");
		label.setFont(new Font("����", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setFont(new Font("����", Font.PLAIN, 18));
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cno = textField.getText();
				if(cno == null || "".equals(cno.trim())) {
					JOptionPane.showMessageDialog(null, "��ѯ�Ŀγ̺Ų���Ϊ��");
					FillCourseTable();
					return;
				}
				QueryCourse();
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("\u9009\u5B9A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectCourse();
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 20));
		
		JButton btnNewButton_1_1 = new JButton("\u9000\u51FA");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("����", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(199)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(104)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 496, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(91, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(334, Short.MAX_VALUE)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(264))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(33)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u53F7", "\u8BFE\u7A0B\u540D", "\u5B66\u5206", "\u8BFE\u65F6"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(30);
		table.getTableHeader().setFont(new Font("����", Font.PLAIN, 20));
		table.setFont(new Font("����", Font.PLAIN, 20));
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
		
		FillCourseTable();
		
	}
	
	/**
	  * ѡ��γ�
	 *@param User	��ȡ��¼��ѧ��
	 *@param row	��ȡѡ�б������
	 *@param sql1	sql���
	 *@exception printStackTrace
	 */
	private void SelectCourse() {
		User u = LoginInterface.getUser();
		int row = table.getSelectedRow();
		String sql1 = "select * from choices";
		try {
			ResultSet rs = DatabaseQuery.Query(sql1);
			while(rs.next()) {
				if(u.getUsername().equals(rs.getString(1))) {
					if(rs.getString(2).equals((String)table.getValueAt(row, 0))) {
					JOptionPane.showMessageDialog(null, "���ſ����Ѿ����ˣ�");
					return;
					}
				}
			}
			String sql2 = "insert choices values('"+u.getUsername()+
					"','"+(String)table.getValueAt(row, 0)+
					"','"+(String)table.getValueAt(row, 1)+"')";
			DatabaseUpdate.Update(sql2);
			JOptionPane.showMessageDialog(null, "��ӳɹ���");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	  * ��ѯ�γ�
	 *@param con	��ȡ����ѯ�Ŀγ�
	 *@param row	��ȡѡ�б������
	 *@param dtm	����һ����
	 *@exception printStackTrace
	 */
	public void QueryCourse() {
		String cno = textField.getText();
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		try {
			String sql = "select * from course where cno = '"+cno+"'";
			ResultSet rs = DatabaseQuery.Query(sql);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("cno"));
				v.add(rs.getString("cname"));
				v.add(rs.getString("credit"));
				v.add(rs.getString("ctime"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	  * ���γ̱�
	 *@param dtm	����һ�������ı�
	 *@param sql	sql���
	 *@param rs		����һ��ִ��sql���Ľ����
	 *@exception printStackTrace
	 */
	public void FillCourseTable() {
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		try {
			String sql = "select * from course";
			ResultSet rs = DatabaseQuery.Query(sql);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("cno"));
				v.add(rs.getString("cname"));
				v.add(rs.getString("credit"));
				v.add(rs.getString("ctime"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
