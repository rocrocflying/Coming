package yb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class conn {
 
	 private final static String JDBCURL="jdbc:sqlserver://10.10.16.166:1433;databasename=Coming";
	 private final static String USER="sa";
	 private final static String PWD="6972195gys";
//	 private final static String JDBCURL="jdbc:sqlserver://10.10.1.45:1433;databasename=Coming";
//	 private final static String USER="sa";
//	 private final static String PWD="123456";
	// private  Connection con =null;
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
	
	 
	 public  ResultSet exequery(String sql) throws Exception 
	    {   ResultSet rs=null;
	    Connection con=conn.getCon();
	        try{
	       // conn=DriverManager.getConnection(db,user,psw);//������ݿ�
	    	Statement st=con.createStatement();
	    	rs=st.executeQuery(sql);
	    	System.out.println("成功");
	        }catch(SQLException e)
	        {
	        	System.out.println("失败");
	        }
	    	
	    	return rs;
	    		
	    }
	 
	   public boolean executeupdate(String sql) throws Exception
	    {      Connection con=conn.getCon();
	    	boolean k=false;
	    	try{
	    	   // conn=DriverManager.getConnection(db, user, psw);//������ݿ�
	    		Statement st2=con.createStatement();
		        st2.execute(sql);
		    	k=true;
	    	}catch(SQLException e)
	    	{
	    		System.out.println("�����쳣");
	    	}
	    	return k;
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
