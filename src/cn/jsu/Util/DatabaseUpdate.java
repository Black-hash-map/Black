package cn.jsu.Util;

import java.sql.Connection;
import java.sql.Statement;
import cn.jsu.Dbc.DatabaseConnetion;

/**
 * 数据库修改语句操作类
 * @author Black
 *
 */

public class DatabaseUpdate {
	
	/**
	 * 
	 * @param sql	sql语句
	 * @throws Exception
	 */
	public static void Update(String sql) throws Exception{
		Connection con = DatabaseConnetion.getCon();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
	}

}
