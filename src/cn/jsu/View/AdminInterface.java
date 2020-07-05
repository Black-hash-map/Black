package cn.jsu.View;

import java.awt.EventQueue;
import java.awt.Graphics;

import java.io.File;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
  * 管理员界面
 * @author Black
 *
 */

public class AdminInterface {

	private JFrame frame;
	private static boolean flag = false;
	
	public static boolean getFlag() {
		return flag;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminInterface window = new AdminInterface();
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
	public AdminInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Java\u4EE3\u7801\\JavaWork\\\u8BFE\u8BBE\\Image\\Admin.png"));
		frame.setTitle("\u7BA1\u7406\u5458\u7A97\u53E3");
		frame.setBounds(100, 100, 1071, 686);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);//窗体居中
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setVisible(true);   // 窗体显示
		
		JDesktopPane desktopPane = new JDesktopPane() {
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("Image"+File.separator+"背景.jpg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		desktopPane.setBackground(Color.WHITE);

		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JButton button = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifyPasswordInterface();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		button.setForeground(Color.BLACK);
		button.setBounds(46, 75, 139, 28);
		desktopPane.add(button);
		
		JButton button_1 = new JButton("\u6DFB\u52A0\u7528\u6237");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddUserInterface();
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1.setBounds(46, 134, 139, 28);
		desktopPane.add(button_1);
		
		JButton button_1_1 = new JButton("\u67E5\u770B\u7528\u6237\u4FE1\u606F");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QueryUserInfomtionInterface();
			}
		});
		button_1_1.setForeground(Color.BLACK);
		button_1_1.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1_1.setBounds(46, 258, 204, 28);
		desktopPane.add(button_1_1);
		
		JButton button_1_2 = new JButton("\u67E5\u770B\u5B66\u751F\u6210\u7EE9");
		button_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QueryStudentGradeInterface();
			}
		});
		button_1_2.setForeground(Color.BLACK);
		button_1_2.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1_2.setBounds(46, 324, 204, 28);
		desktopPane.add(button_1_2);
		
		JButton button_1_3 = new JButton("\u53D1\u5E03\u6210\u7EE9");
		button_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					isIssue(true);
					JOptionPane.showMessageDialog(null, "发布成功！");
			}
		});
		button_1_3.setForeground(Color.BLACK);
		button_1_3.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1_3.setBounds(46, 385, 139, 28);
		desktopPane.add(button_1_3);
		
		JButton button_1_4 = new JButton("\u53D1\u5E03\u8BFE\u7A0B\u4FE1\u606F");
		button_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isIssue(true);
				JOptionPane.showMessageDialog(null, "发布成功！");
			}
		});
		button_1_4.setForeground(Color.BLACK);
		button_1_4.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1_4.setBounds(46, 444, 204, 28);
		desktopPane.add(button_1_4);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u6765\u5230\u5B66\u7C4D\r\n");
		lblNewLabel.setFont(new Font("方正舒体", Font.PLAIN, 80));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(349, 50, 487, 123);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("方正舒体", Font.PLAIN, 80));
		lblNewLabel_1.setBounds(508, 179, 328, 123);
		desktopPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 35));
		btnNewButton.setBounds(818, 545, 124, 55);
		desktopPane.add(btnNewButton);
		
		JButton button_1_5 = new JButton("\u5207\u6362\u7528\u6237");
		button_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginInterface();
			}
		});
		button_1_5.setForeground(Color.BLACK);
		button_1_5.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1_5.setBounds(46, 196, 139, 28);
		desktopPane.add(button_1_5);
		
		JButton button_1_4_1 = new JButton("\u767B\u5F55\u65E5\u5FD7");
		button_1_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginDiaryInterface();
			}
		});
		button_1_4_1.setForeground(Color.BLACK);
		button_1_4_1.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1_4_1.setBounds(46, 505, 139, 28);
		desktopPane.add(button_1_4_1);
	}

	/**
	 * 是否发布课程和成绩
	 * @param b	代表是或者否
	 */
	private void isIssue(boolean b) {
		flag = b;
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
}