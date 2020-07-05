package cn.jsu.View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import cn.jsu.Model.User;
import cn.jsu.Util.DatabaseQuery;

/**
 * 查看课程界面
 * @author Black
 *
 */

public class QueryCourseInterface {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryCourseInterface window = new QueryCourseInterface();
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
	public QueryCourseInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u8BFE\u7A0B\u8868");
		frame.setBounds(100, 100, 446, 320);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u8BFE\u7A0B\u53F7", "\u8BFE\u7A0B\u540D"
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
		FillCourse();
	}

	/**
	  * 填充课程
	 *@param dtm	待填充的表
	 *@param u	获取的用户信息
	 *@param sql	sql语句
	 *@exception	printStackTrace
	 */
	public void FillCourse() {
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		User u = LoginInterface.getUser();
		String sql = "select * from choices";
		try {
			ResultSet rs = DatabaseQuery.Query(sql);
			while(rs.next()) {
				Vector v = new Vector();
				if(rs.getString("sno").equals(u.getUsername())) {
					v.add(rs.getString("sno"));
					v.add(rs.getString("cno"));
					v.add(rs.getString("cname"));
					dtm.addRow(v);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
