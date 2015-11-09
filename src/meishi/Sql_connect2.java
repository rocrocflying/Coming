package meishi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import chib.DBConn;


public class Sql_connect2 {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private PreparedStatement ps2 = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	String temp="0";
	public String panduan_state(String userid,String activityid) throws Exception {
		boolean flag = false;
		try {
			conn = DBConn.getCon();  
			ps = conn.prepareStatement("select * from connect2 where USRID=? and ACT_ID=?");
			//ps2=conn.prepareStatement("SELECT  @@IDENTITY as ID");
			ps.setString(1, userid);
			ps.setString(2, activityid);
	
			//ps.setString(5, activity.getAct_image());
			
		   // String sql="insert into wechat (title, describe, address, src ,begintime,finsintime,time) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')";
			//String aa=ps.toString();
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				//ResultSet rs =ps.getGeneratedKeys();
				

				    temp =String.valueOf(rs.getInt(3));//aa为自增长的值
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, ps, rs);
		}
		
		return temp;
		
		}
	//普通用户参加活动,先加1， 然后增加关系表
		public boolean userjoin_act(String userid,String activityid) throws Exception {
			boolean flag = false;
			try {
				conn = DBConn.getCon();
				conn.setAutoCommit(false);// 更改JDBC事务的默认提交方式
				ps2 = conn.prepareStatement("update  food_Info set  ACT_COUNT=ACT_COUNT+1 where ACT_ID="+activityid
						);

	           if(ps2.executeUpdate()>0){
	              
	            }
				ps = conn.prepareStatement("insert into connect2(USRID, ACT_ID,state)"+
											"values (? ,? ,?)");
			
				
				ps.setInt(1, Integer.parseInt(userid));
				ps.setInt(2, Integer.parseInt(activityid));
				ps.setInt(3, 1);
			    //String sql="insert into wechat (title, describe, address, src ,begintime,finsintime,time) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')";
				//String aa=ps.toString();
				int aa= ps.executeUpdate();
				if(aa>0){
					flag=true;
		
				}
			  conn.commit();//提交JDBC事务
			  conn.setAutoCommit(true);// 恢复JDBC事务的默认提交方式
			} catch (SQLException e) {
				conn.rollback();//回滚JDBC事务
				e.printStackTrace();
			}finally{
				DBConn.closeAll(conn, ps, rs);
			}
			
			return flag;
			
		}
	
}
