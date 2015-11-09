package cn.edu.ynnu.laibar.taobar.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnDB {
	private Connection ct=null;
	public Connection getConn(){
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		try {
			Class.forName(driver);
			ct=DriverManager.getConnection("jdbc:sqlserver://10.10.16.166:1433;databaseName=Coming;user=sa;password=6972195gys");
			//ct=DriverManager.getConnection("jdbc:sqlserver://10.10.1.45:1433;databaseName=Coming;user=sa;password=123456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ct;
	}

}
