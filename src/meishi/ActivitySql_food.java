package meishi;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import chib.DBConn;


//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;


import entity.activity_info;


public class ActivitySql_food {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public boolean addActivity(activity_info activity) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			ps = conn.prepareStatement("insert into food_Info (USER_ID, ACT_TITLE, ACT_PLACE, ACT_DETAIL ,ACT_IMAGE)"+
										"values (? ,? ,? ,? ,? )");
			ps.setString(1, activity.getUser_id());
			ps.setString(2, activity.getAct_title());
			ps.setString(3, activity.getAct_place());
			ps.setString(4, activity.getAct_detail());
		
			//ps.setString(5, activity.getAct_charger());
			//ps.setString(6, activity.getAct_email());
			//ps.setString(7, activity.getAct_phone());
			//ps.setString(8, activity.getAct_qq());
			//ps.setString(9, activity.getAct_weix());
		
			//ps.setString(10, activity.getBegin_date());
			//ps.setString(11, activity.getEnd_date());
	
			ps.setString(5, activity.getAct_image());
			
		
			
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
	
	
	public List<activity_info> queryAllProduct() {
		List<activity_info> list = new ArrayList<activity_info>();
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from food_Info where ACT_STATE= 0  ";
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				activity_info p = new activity_info();
                p.setAct_id(rs.getInt(1));
				p.setAct_image(rs.getString(16));
				p.setAct_title(rs.getString(3));
			    p.setAct_state(rs.getInt(17));
				p.setAct_count(rs.getInt(6));
				p.setAct_place(rs.getString(4));
				
				
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return list;
	}
	//按照点赞的数目选择
	public List<activity_info> querymaxProduct() {
		List<activity_info> list = new ArrayList<activity_info>();
		try {
			conn = DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from food_Info where ACT_STATE= 0  order by ACT_COUNT desc";
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				activity_info p = new activity_info();
                p.setAct_id(rs.getInt(1));
				p.setAct_image(rs.getString(16));
				p.setAct_title(rs.getString(3));
			    p.setAct_state(rs.getInt(17));
				p.setAct_count(rs.getInt(6));
				p.setAct_place(rs.getString(4));
				
				
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return list;
	}
	
	
	public activity_info queryActivityBypId(int id) {
		activity_info p = null;
		try {
			conn =DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from food_Info where ACT_ID="+id;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				 p = new activity_info();

				 
                    p.setAct_id(rs.getInt(1));
					p.setAct_image(rs.getString(16));
					p.setAct_title(rs.getString(3));
				    p.setAct_state(rs.getInt(17));
					p.setAct_count(rs.getInt(6));
					p.setAct_place(rs.getString(4));
					p.setAct_detail(rs.getString(5));
					p.setAct_charger(rs.getString(7));
					p.setAct_email(rs.getString(8));
					p.setAct_phone(rs.getString(9));
					p.setAct_qq(rs.getString(10));
					p.setAct_weix(rs.getString(11));
					p.setAct_date(rs.getString(12));
					p.setBegin_date(rs.getString(13));
                    p.setEnd_date(rs.getString(14));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return p;
	}


	
	
}
