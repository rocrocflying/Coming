package com.yb.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.yb.entity.User;
import com.yb.entity.love_info;
import com.yb.entity.love_praise;
import com.yb.sql.DBConn;

public class praiseSql {
	

	private Connection conn = null;
	private PreparedStatement ps = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	
	public boolean addpraise(love_praise p) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			ps = conn.prepareStatement("insert into love_praise values (? ,? ,? )");
		
			ps.setInt(1,p.getLoveid());
			ps.setInt(2,p.getUserid());
			ps.setInt(3,p.getPrais_state());
			if(ps.executeUpdate()>0){
				flg = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flg;
		
	}
	public boolean addpraise2(int loveid) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			ps = conn.prepareStatement("update love_info set love_good=love_good+1 where id=?");
		
			ps.setInt(1,loveid);

			if(ps.executeUpdate()>0){
				flg = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flg;
		
	}
	
	
	
	public love_praise querypraise(int loveid,int userid) {
	    love_praise p=new love_praise();
		try {
			conn =DBConn.getCon();
           ps=conn.prepareStatement("select * from love_praise where love_id=? and usrid=?");
           ps.setInt(1,loveid);
  		    ps.setInt(2,userid);
			ResultSet rs2 = ps.executeQuery();
			while (rs2.next()){
				p.setLoveid(rs2.getInt("love_id"));
			    p.setUserid(rs2.getInt("usrid"));
			    p.setPrais_state(rs2.getInt("prais_state"));
	
              
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return p;
	}
	
	public love_info queryloveinfo(int loveid) {
	    love_info love=new love_info();
		try {
			conn =DBConn.getCon();
           ps=conn.prepareStatement("select * from love_info where id=?");
           ps.setInt(1,loveid);
			ResultSet rs2 = ps.executeQuery();
			while (rs2.next()){
				love.setCount(rs2.getInt("love_good"));
			  
	
              
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return love;
	}

}
