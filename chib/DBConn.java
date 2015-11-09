package chib;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class DBConn {

	 private final static String JDBCURL="jdbc:sqlserver://10.10.16.166:1433;databasename=Coming";
	 private final static String USER="sa";
	 private final static String PWD="6972195gys";
//	private final static String JDBCURL="jdbc:sqlserver://10.10.1.45:1433;databasename=Coming";
//	private final static String USER="sa";
//	private final static String PWD="123456";
	 
	 static{
	  try {
	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	  } catch (ClassNotFoundException e) {
	   e.printStackTrace();
	  }
	 }
	 
	 public static Connection getCon()throws Exception{
	  Connection con=DriverManager.getConnection(JDBCURL,USER,PWD);
	  return con;
	 }
	
	public static void closeAll(Connection conn , Statement stmt , ResultSet rs ){
		try {
			
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
