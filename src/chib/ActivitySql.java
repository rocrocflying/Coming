package chib;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chib.DBConn;


//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;


import entity.Activity;
import entity.Connect;
import entity.total;
public class ActivitySql {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private PreparedStatement ps2 = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public boolean addActivity(Activity activity,String id) throws Exception {
		boolean flag = false;
		try {
			
			conn = DBConn.getCon();
			conn.setAutoCommit(false);// 更改JDBC事务的默认提交方式
			ps = conn.prepareStatement("insert into wechat (title, describe, address, src ,begintime,finsintime,time)"+
										"values (? ,? ,? ,? ,?,? ,?)");
			//ps2=conn.prepareStatement("SELECT  @@IDENTITY as ID");
			ps.setString(1, activity.getWc_title());
			ps.setString(2, activity.getWc_describe());
			ps.setString(3, activity.getWc_address());
			ps.setString(4, activity.getWc_src());
			ps.setString(5, activity.getWc_begintime());
			ps.setString(6, activity.getWc_finsintime());
			/*ps.setString(7, activity.getWc_name());
			ps.setString(8, activity.getWc_phone());
			ps.setString(9, activity.getWc_email());
			ps.setString(10, activity.getWc_QQ());
			ps.setString(11, activity.getWc_weix());*/
			ps.setString(7, activity.getWc_date());
			//ps.setString(5, activity.getAct_charger());
			//ps.setString(6, activity.getAct_email());
			//ps.setString(7, activity.getAct_phone());
			//ps.setString(8, activity.getAct_qq());
			//ps.setString(9, activity.getAct_weix());
		
			//ps.setString(10, activity.getBegin_date());
			//ps.setString(11, activity.getEnd_date());
	
			//ps.setString(5, activity.getAct_image());
			String a=activity.getWc_title();
			String b=activity.getWc_describe();
			String c=activity.getWc_address();
			String d=activity.getWc_src();
			String e=activity.getWc_begintime();
			String f=activity.getWc_finsintime();
			String g=activity.getWc_date();
		    String sql="insert into wechat (title, describe, address, src ,begintime,finsintime,time) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')";
			//String aa=ps.toString();
			int aa= ps.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			if(aa>0){
				ResultSet rs =ps.getGeneratedKeys();
				if (rs.next()) {

				    aa = rs.getInt(1);//aa为自增长的值
				    if(aa>1)
				    {
				    	ps2 =conn.prepareCall("insert into connect(USRID,id,up_state) values(?,?,?)");
				    	ps2.setString(1, String.valueOf(id));
						ps2.setString(2, String.valueOf(aa));
						ps2.setInt(3, 2);//发起者的标识为2
						String sql2="insert into connect(USRID,id) values('"+id+"','"+aa+"')";
				    	if(ps2.executeUpdate()>0)
				    	{
				    		flag = true;
				    	}
				    }

				}
				
			}
			 conn.commit();//提交JDBC事务
			 conn.setAutoCommit(true);// 恢复JDBC事务的默认提交方式
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, ps, rs);
		}
		
		return flag;
		
	}
	//每人发起的活动
	public List<total> querycreateact(String id) {
		List<total> list = new ArrayList<total>();
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from (wechat join connect on wechat.id=connect.id )join User_Info on connect.USRID=User_Info.USRID where up_state=2 and User_Info.USRID='"+id+"'";
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				total p = new total();
                p.setId(rs.getInt(1));
				p.setWc_src(rs.getString(5));
				p.setWc_begintime(rs.getString(6).substring(0, 10));
				p.setWc_title(rs.getString(2));
			    //p.setAct_state(rs.getInt(17));
				//p.setAct_count(rs.getInt(6));
				p.setWc_address(rs.getString(3));
				p.setWc_name(rs.getString(7));
				p.setUp(rs.getInt(14));
				p.setUp_state(rs.getInt(17));

				p.setUSRNM(rs.getString(19));
				p.setRNAME(rs.getString(20));
				p.setHEAD_PIC(rs.getString(28));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return list;
		
	}
	
	//每人参与的活动
		public List<total> queryjoinact(String id) {
			List<total> list = new ArrayList<total>();
			try {
				conn = DBConn.getCon();
				stmt = conn.createStatement();
				String sql = "select * from (wechat join connect on wechat.id=connect.id )join User_Info on connect.USRID=User_Info.USRID where up_state=2 and wechat.id in"
						+"(select id from connect where up_state=1 and USRID='"+id+"')";
				rs = stmt.executeQuery(sql);
				while (rs.next()){
					total p = new total();
	                p.setId(rs.getInt(1));
					p.setWc_src(rs.getString(5));
					p.setWc_begintime(rs.getString(6).substring(0, 10));
					p.setWc_title(rs.getString(2));
				    //p.setAct_state(rs.getInt(17));
					//p.setAct_count(rs.getInt(6));
					p.setWc_address(rs.getString(4));
					p.setWc_name(rs.getString(8));
					p.setUp(rs.getInt(14));
					p.setUp_state(rs.getInt(17));
					p.setUSRNM(rs.getString(19));
					p.setRNAME(rs.getString(20));
					p.setHEAD_PIC(rs.getString(28));
					list.add(p);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DBConn.closeAll(conn, stmt, rs);
			}
			return list;
			
		}
		
	
	public List<total> queryAll() {
		List<total> list = new ArrayList<total>();
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from (wechat join connect on wechat.id=connect.id )join User_Info on connect.USRID=User_Info.USRID where up_state=2";
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				total p = new total();
                p.setId(rs.getInt(1));
				p.setWc_src(rs.getString(5));
				p.setWc_begintime(rs.getString(6).substring(0, 10));
				p.setWc_title(rs.getString(2));
			    //p.setAct_state(rs.getInt(17));
				//p.setAct_count(rs.getInt(6));
				p.setWc_address(rs.getString(4));
				p.setWc_name(rs.getString(8));
				p.setUp(rs.getInt(14));
				p.setUp_state(rs.getInt(17));
				p.setUSRNM(rs.getString(19));
				p.setRNAME(rs.getString(20));
				p.setHEAD_PIC(rs.getString(28));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return list;
		
	}
	
	
	public List<Activity> queryAllProduct() {
		List<Activity> list = new ArrayList<Activity>();
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from wechat ";
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				Activity p = new Activity();
                p.setId(rs.getInt(1));
				p.setWc_src(rs.getString(5));
				p.setWc_title(rs.getString(2));
			    //p.setAct_state(rs.getInt(17));
				//p.setAct_count(rs.getInt(6));
				p.setWc_address(rs.getString(3));
				p.setWc_name(rs.getString(7));
				p.setUp(rs.getInt(14));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return list;
		
	}
	
	
	public List<total> queryActivityBypId(String id) {
		List<total> list = new ArrayList<total>();
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from (wechat join connect on wechat.id=connect.id )join User_Info on connect.USRID=User_Info.USRID where up_state=2 and wechat.id="+id;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				total p = new total();
                p.setId(rs.getInt(1));
				p.setWc_src(rs.getString(5));
				p.setWc_begintime(rs.getString(6).substring(0, 10));
				p.setWc_title(rs.getString(2));
			    //p.setAct_state(rs.getInt(17));
				//p.setAct_count(rs.getInt(6));
				p.setWc_describe(rs.getString(3));
				p.setWc_name(rs.getString(8));
				p.setUp(rs.getInt(14));
				p.setUp_state(rs.getInt(17));
				p.setUSRNM(rs.getString(19));
				p.setRNAME(rs.getString(20));
				p.setHEAD_PIC(rs.getString(28));
				p.setWc_date(rs.getString(13));
				p.setPHNUM(rs.getString(32));
				p.setWc_finsintime(rs.getString(7));
				
				
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return list;
		
		
      }
	
	public List<total> queryJoinUser(String id) {
		List<total> list = new ArrayList<total>();
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from (wechat join connect on wechat.id=connect.id )join User_Info on connect.USRID=User_Info.USRID where up_state=1 and wechat.id="+id;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				total p = new total();
                p.setId(rs.getInt(1));
				p.setWc_src(rs.getString(5));
				p.setWc_begintime(rs.getString(6).substring(0, 10));
				p.setWc_title(rs.getString(2));
			    //p.setAct_state(rs.getInt(17));
				//p.setAct_count(rs.getInt(6));
				p.setWc_describe(rs.getString(3));
				p.setWc_name(rs.getString(8));
				p.setUp(rs.getInt(14));
				p.setUp_state(rs.getInt(17));
				p.setUSRNM(rs.getString(19));
				p.setRNAME(rs.getString(20));
				p.setHEAD_PIC(rs.getString(28));
				p.setWc_date(rs.getString(13));
				p.setPHNUM(rs.getString(32));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return list;
		
		
      }
	
	public Connect queryJoinBypId(String id,String actid) {
		  Connect p = new Connect();
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from connect where USRID='"+id+"' and id='"+actid+"'";
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				
                p.setUp_state(rs.getInt(3));
			
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return p;
		
		
      }
	
	
	public boolean updateActivity(String id) throws Exception {
		
		
		boolean flag = false;
		try {
			conn = DBConn.getCon();
			conn.setAutoCommit(false);// 更改JDBC事务的默认提交方式
			ps = conn.prepareStatement("update wechat set up=up+1 where id="+id
										);
		
			if(ps.executeUpdate()>0){
				flag = true;
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
