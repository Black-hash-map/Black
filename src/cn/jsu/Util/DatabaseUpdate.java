package cn.jsu.Util;

import java.sql.Connection;
import java.sql.Statement;
import cn.jsu.Dbc.DatabaseConnetion;

/**
 * ���ݿ��޸���������
 * @author Black
 *
 */

public class DatabaseUpdate {
	
	/**
	 * 
	 * @param sql	sql���
	 * @throws Exception
	 */
	public static void Update(String sql) throws Exception{
		Connection con = DatabaseConnetion.getCon();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(sql);
	}

}
