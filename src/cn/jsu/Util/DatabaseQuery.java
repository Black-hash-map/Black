package cn.jsu.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.jsu.Dbc.DatabaseConnetion;

/**
  * ���ݿ��ѯ��������
 * @author Black
 *
 */

public class DatabaseQuery{
	/**
	 * 
	 * @param sql	sql���
	 * @return	rs	�����������Ľ��
	 * @throws Exception
	 */
	
	public static ResultSet Query(String sql) throws Exception{
		ResultSet rs = null;
		Connection con = DatabaseConnetion.getCon();
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(sql); //ִ�и����� SQL ��䣬����䷵�ص��� ResultSet ����
		return rs;
	}

}
