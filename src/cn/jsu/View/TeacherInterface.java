package cn.jsu.View;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 老师界面
 * @author Black
 *
 */

public class TeacherInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherInterface window = new TeacherInterface();
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
	public TeacherInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Java\u4EE3\u7801\\JavaWork\\\u8BFE\u8BBE\\Image\\Teacher.png"));
		frame.setTitle("\u8001\u5E08\u7A97\u53E3");
		frame.setBounds(100, 100, 1063, 667);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);//窗体居中
		frame.setVisible(true);
		
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
		
		JButton button = new JButton("\u5207\u6362\u7528\u6237");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginInterface();
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("宋体", Font.PLAIN, 25));
		button.setBounds(46, 145, 139, 28);
		desktopPane.add(button);
		
		JButton button_1 = new JButton("\u4FEE\u6539\u5BC6\u7801");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ModifyPasswordInterface();
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1.setBounds(46, 75, 139, 28);
		desktopPane.add(button_1);
		
		JButton button_1_1 = new JButton("\u67E5\u770B\u5B66\u751F\u4FE1\u606F");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QueryStudentInformationInterface();
			}
		});
		button_1_1.setForeground(Color.BLACK);
		button_1_1.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1_1.setBounds(46, 285, 204, 28);
		desktopPane.add(button_1_1);
		
		JButton button_1_2 = new JButton("\u67E5\u770B\u5B66\u751F\u6210\u7EE9");
		button_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AdminInterface.getFlag()) {
					new QueryStudentGradeInterface();
				}else {
					JOptionPane.showMessageDialog(null, "成绩还未发布！");
				}
			}
		});
		button_1_2.setForeground(Color.BLACK);
		button_1_2.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1_2.setBounds(46, 215, 204, 28);
		desktopPane.add(button_1_2);
		
		JButton button_1_3 = new JButton("\u6210\u7EE9\u5F55\u5165");
		button_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GradeEnterInterface();
			}
		});
		button_1_3.setForeground(Color.BLACK);
		button_1_3.setFont(new Font("宋体", Font.PLAIN, 25));
		button_1_3.setBounds(46, 355, 139, 28);
		desktopPane.add(button_1_3);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u6765\u5230\u5B66\u7C4D\r\n");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("方正舒体", Font.PLAIN, 80));
		lblNewLabel.setBounds(349, 50, 487, 123);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("方正舒体", Font.PLAIN, 80));
		lblNewLabel_1.setBounds(508, 176, 328, 123);
		desktopPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 35));
		btnNewButton.setBounds(806, 493, 124, 55);
		desktopPane.add(btnNewButton);
	}

}
