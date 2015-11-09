package com.yb.sql;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yb.entity.Activity;
import com.yb.entity.ActivityAll;
import com.yb.entity.ActivityJoin;
import com.yb.entity.UserInfo;
import com.yb.sql.DBConn;








public class ActivitySql {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public boolean addActivity(Activity activity) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			ps = conn.prepareStatement("insert into Activity_Info (USRID, ACT_TITLE, ACT_PLACE, ACT_DETAIL, ACT_CHARGE, ACT_EMAIL, ACT_PHONE, ACT_QQ,ACT_WEIX,ACT_DATE,START_DATE,END_DATE ,ACT_IMAGE)"+
										"values (? ,? ,? ,? ,? ,? ,? ,? ,?,? ,?,?,?)");
			ps.setInt(1, activity.getUser_id());
			ps.setString(2, activity.getAct_title());
			ps.setString(3, activity.getAct_place());
			ps.setString(4, activity.getAct_detail());
		
			ps.setString(5, activity.getAct_charge());
			ps.setString(6, activity.getAct_email());
			ps.setString(7, activity.getAct_phone());
			ps.setString(8, activity.getAct_qq());
			ps.setString(9, activity.getAct_weix());
		    ps.setString(10, activity.getAct_date()) ;
			ps.setString(11, activity.getBegin_date());
			ps.setString(12, activity.getEnd_date());
	
			ps.setString(13, activity.getAct_image());
			
		
			
			if(ps.executeUpdate()>0){
				flg = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, ps, rs);
		}
		
		return flg;
		
	}
	
	
	public boolean updateActivityInfo(Activity p) {
		
		boolean flg = false;
		
		try {
		
			conn = DBConn.getCon();
			stmt = conn.createStatement();
                                                                                                                                                                                                                                                                                                                                                        
			String sql = "update Activity_Info set USRID = "+p.getUser_id()+", ACT_TITLE='"+p.getAct_title()+"',ACT_PLACE ='"+p.getAct_place()+"',ACT_DETAIL='"+p.getAct_detail()+"' ,ACT_CHARGE='"+p.getAct_charge()+"',ACT_EMAIL='"+p.getAct_email()+"',ACT_PHONE='"+p.getAct_phone()+"',ACT_QQ='"+p.getAct_qq()+"',ACT_WEIX='"+p.getAct_weix()+"', ACT_DATE='"+p.getAct_date()+"',START_DATE='"+p.getBegin_date()+"',END_DATE='"+p.getEnd_date()+"',ACT_IMAGE='"+p.getAct_image()+"' where ACT_ID="+p.getAct_id()+"";
			System.out.println(sql);
			if(stmt.executeUpdate(sql)>0){
				flg = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		
		return flg;
	}
	
	
	
	public List<Activity> queryAllActivity() {
		List<Activity> list = new ArrayList<Activity>();
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from Activity_Info  order by ACT_DATE desc";
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				Activity p = new Activity();
                p.setAct_id(rs.getInt(1));
                p.setUser_id(rs.getInt(2));
				p.setAct_image(rs.getString(16));
				p.setAct_title(rs.getString(3));
				p.setAct_charge(rs.getString(10));
				p.setAct_count(rs.getInt(6));
				p.setAct_place(rs.getString(4));
				p.setAct_date(rs.getString(12));
				p.setBegin_date(rs.getString(13));
				p.setEnd_date(rs.getString(15));
				p.setAct_good(rs.getInt(14));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return list;
	}
	
	
	
	
	public List<ActivityAll> queryrAll() {
		List<ActivityAll> list = new ArrayList<ActivityAll>();
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select af.*, ai.USRNM,ai.HEAD_PIC  from Activity_Info as af ,User_Info as ai where af.USRID=ai.USRID order by af.ACT_DATE desc";
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				ActivityAll p = new ActivityAll();
                p.setAct_id(rs.getInt(1));
                p.setUser_id(rs.getInt(2));
				p.setAct_image(rs.getString(16));
				p.setAct_title(rs.getString(3));
				p.setAct_charge(rs.getString(10));
				p.setAct_count(rs.getInt(6));
				p.setAct_place(rs.getString(4));
				p.setAct_date(rs.getString(12));
				p.setBegin_date(rs.getString(13));
				p.setEnd_date(rs.getString(15));
				p.setAct_good(rs.getInt(14));
			   p.setUsrnm(rs.getString(17));
			   p.setHead_pic(rs.getString(18));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return list;
	}
	
	
	public List<ActivityAll> queryMyJoinActivity(int uid) {
		List<ActivityAll> list = new ArrayList<ActivityAll>();
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select ai.ACT_ID,ai.ACT_TITLE,ai.ACT_IMAGE,ai.act_charge,ai.act_count,ai.act_place,ai.act_date,ai.start_date,ai.end_date,ai.act_good,ui.USRNM,ui.HEAD_PIC from Activity_Info as ai,Activity_Join as aj,User_Info as ui " +
					" where ai.ACT_ID=aj.ACT_ID and ai.USRID=ui.USRID and aj.USRID="+uid;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				ActivityAll p = new ActivityAll();
                p.setAct_id(rs.getInt(1));
                p.setAct_title(rs.getString(2));
				p.setAct_image(rs.getString(3));
				
				p.setAct_charge(rs.getString(4));
				p.setAct_count(rs.getInt(5));
				p.setAct_place(rs.getString(6));
				p.setAct_date(rs.getString(7));
				p.setBegin_date(rs.getString(8));
				p.setEnd_date(rs.getString(9));
				p.setAct_good(rs.getInt(10));
				p.setUsrnm(rs.getString(11));
				p.setHead_pic(rs.getString(12));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return list;
	}
	
	
	public List<Activity> queryMyCreateActivity(int uid) {
		List<Activity> list = new ArrayList<Activity>();
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from Activity_Info  where USRID="+uid;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				Activity p = new Activity();
                p.setAct_id(rs.getInt(1));
				p.setAct_image(rs.getString(16));
				p.setAct_title(rs.getString(3));
			    p.setAct_charge(rs.getString(10));
				p.setAct_count(rs.getInt(6));
				p.setAct_place(rs.getString(4));
				p.setAct_date(rs.getString(12));
				p.setBegin_date(rs.getString(13));
				p.setEnd_date(rs.getString(15));
				p.setAct_good(rs.getInt(14));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return list;
	}
	
	
	
	public boolean deleteMyCreate(int id) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "delete from Activity_Info where  ACT_ID="+id;
			if(stmt.executeUpdate(sql)>0){
				flg  = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return flg;
	}
	
	
	public boolean deleteJoinById(int id) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "delete from Activity_Join where  ACT_ID="+id;
			if(stmt.executeUpdate(sql)>0){
				flg  = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return flg;
	}
	
	
	public boolean deletePraiseById(int id) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "delete from Activity_Praise where  ACT_ID="+id;
			if(stmt.executeUpdate(sql)>0){
				flg  = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return flg;
	}
	
	
	
	public List<UserInfo> queryJoinUser(int actid) {
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select USRNM,HEAD_PIC,ui.USRID from User_Info as ui,Activity_Join as aj where ui.USRID=aj.USRID and aj.ACT_ID="+actid;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				UserInfo p = new UserInfo();
				p.setUsrnm(rs.getString(1));
				p.setHead_pic(rs.getString(2));
				p.setUsrid(rs.getInt(3));
             
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return list;
	}
	
	
	
	
	public Activity queryActivityById(int id) {
		Activity p = null;
		try {
			conn =DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from Activity_Info where ACT_ID="+id;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				   p = new Activity();
                    p.setAct_id(rs.getInt(1));
					p.setAct_image(rs.getString(16));
					p.setAct_title(rs.getString(3));
				 
					p.setAct_count(rs.getInt(6));
					p.setAct_place(rs.getString(4));
					p.setAct_detail(rs.getString(5));
					p.setAct_charge(rs.getString(10));
					p.setAct_email(rs.getString(8));
					p.setAct_phone(rs.getString(7));
					p.setAct_qq(rs.getString(9));
					p.setAct_weix(rs.getString(11));
					p.setAct_date(rs.getString(12));
					p.setBegin_date(rs.getString(13));
                    p.setEnd_date(rs.getString(15));
                	p.setAct_good(rs.getInt(14));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return p;
	}
	
	
	public ActivityJoin queryJoinBypId(int id,int uid) {
		ActivityJoin p = null;
		try {
			conn =DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from Activity_Join where  USRID="+uid+" and ACT_ID="+id;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				   p = new ActivityJoin();
				   p.setJoin_state(rs.getInt(5));
              
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return p;
	}
	
	
	
	public boolean findActivityJoin( int id,int uid) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from Activity_Join where  USRID="+uid+" and ACT_ID="+id;
			if(stmt.executeUpdate(sql)>0){
				flg  = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return flg;
	}
	
	public boolean addActivityJoin( int actid, int userid) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "insert into Activity_Join(ACT_ID,USRID,JOIN_DATE)values('"+actid+"','"+userid+"','"+TimeFactory.getTime()+"');";
			if(stmt.executeUpdate(sql)>0){
				flg  = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return flg;
	}

	
	public boolean addActivityPraise( int actid, int userid) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "insert into Activity_Praise(ACT_ID,USRID)values('"+actid+"','"+userid+"');";
			if(stmt.executeUpdate(sql)>0){
				flg  = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return flg;
	}

	
	
	public boolean deleteActivityJoin(int id, int uid) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "delete from Activity_Join where  USRID="+uid+" and ACT_ID="+id;
			if(stmt.executeUpdate(sql)>0){
				flg  = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return flg;
	}
	
	
	
	public boolean addActCount(int actid) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "update Activity_Info set ACT_COUNT =ACT_COUNT+1  where ACT_ID="+actid;
			if(stmt.executeUpdate(sql)>0){
				flg  = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return flg;
	}
	
	public boolean addPraiseCount(int actid) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "update Activity_Info set ACT_GOOD =ACT_GOOD+1  where ACT_ID="+actid;
			if(stmt.executeUpdate(sql)>0){
				flg  = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return flg;
	}
	
	public boolean subActCount(int actid) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "update Activity_Info set ACT_COUNT =ACT_COUNT-1  where ACT_ID="+actid;
			if(stmt.executeUpdate(sql)>0){
				flg  = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return flg;
	}


}
