package cn.jsu.Dbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
  * 数据库连接与关闭
 * @author Black
 *
 */

public class DatabaseConnetion {
	private static String driverName = "com.mysql.jdbc.Driver";//MySQL驱动程序
	private static String dburi = "jdbc:mysql://localhost:3306/java课设?&useSSL=true";
	private static String dbuser="root";
	private static String dbpassword="123456";
	
	/**
	 * 数据库连接
	 * @return con	返回连接对象
	 * @throws Exception
	 */
	//获取数据库连接
	public static Connection getCon() throws Exception {
		Class.forName(driverName);
		Connection con = DriverManager.getConnection(dburi,dbuser,dbpassword);
		return con;
	}
	
	/**
	 * 数据库关闭
	 * @param con	返回关闭对象
	 * @throws Exception
	 */
	//关闭数据库连接
	public static void closeCon(Connection con) throws Exception{
		if(con != null) {
			con.close();
		}
	}
}
