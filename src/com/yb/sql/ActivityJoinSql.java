package com.yb.sql;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yb.entity.ActivityJoin;
import com.yb.entity.ActivityPraise;
import com.yb.sql.DBConn;


public class ActivityJoinSql {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public boolean queryJoin(int id,int uid) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			ps = conn.prepareStatement("select * from Activity_Join where ACT_ID=? and USRID=? ");
			ps.setInt(1, id);
			ps.setInt(2, uid);
			
			rs = ps.executeQuery();
			if(rs.next()){
				flg= true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, ps, rs);
		}
		
		return flg;
	}


	
	public ActivityPraise queryPraise(int id,int uid) {
		ActivityPraise p = null;
		try {
			conn =DBConn.getCon();
			stmt = conn.createStatement();
			String sql = "select * from Activity_Praise where  USRID="+uid+" and ACT_ID="+id;
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				   p = new ActivityPraise();
				   p.setPrais_state(rs.getInt(4));
              
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, stmt, rs);
		}
		return p;
	}
	
	
	
	public boolean queryIsPraise(int id,int uid) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			ps = conn.prepareStatement("select * from Activity_Praise where ACT_ID=? and USRID=? ");
			ps.setInt(1, id);
			ps.setInt(2, uid);
			
			rs = ps.executeQuery();
			if(rs.next()){
				flg= true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConn.closeAll(conn, ps, rs);
		}
		
		return flg;
	}

	
	
}
