package cn.jsu.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.jsu.Dbc.DatabaseConnetion;

/**
  * 数据库查询语句操作类
 * @author Black
 *
 */

public class DatabaseQuery{
	/**
	 * 
	 * @param sql	sql语句
	 * @return	rs	返回语句操作的结果
	 * @throws Exception
	 */
	
	public static ResultSet Query(String sql) throws Exception{
		ResultSet rs = null;
		Connection con = DatabaseConnetion.getCon();
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(sql); //执行给定的 SQL 语句，该语句返回单个 ResultSet 对象。
		return rs;
	}

}
