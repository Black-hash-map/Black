package cn.jsu.Dbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
  * ���ݿ�������ر�
 * @author Black
 *
 */

public class DatabaseConnetion {
	private static String driverName = "com.mysql.jdbc.Driver";//MySQL��������
	private static String dburi = "jdbc:mysql://localhost:3306/java����?&useSSL=true";
	private static String dbuser="root";
	private static String dbpassword="123456";
	
	/**
	 * ���ݿ�����
	 * @return con	�������Ӷ���
	 * @throws Exception
	 */
	//��ȡ���ݿ�����
	public static Connection getCon() throws Exception {
		Class.forName(driverName);
		Connection con = DriverManager.getConnection(dburi,dbuser,dbpassword);
		return con;
	}
	
	/**
	 * ���ݿ�ر�
	 * @param con	���عرն���
	 * @throws Exception
	 */
	//�ر����ݿ�����
	public static void closeCon(Connection con) throws Exception{
		if(con != null) {
			con.close();
		}
	}
}
