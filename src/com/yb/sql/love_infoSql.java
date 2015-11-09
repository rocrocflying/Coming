package com.yb.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.yb.entity.*;
import com.yb.sql.DBConn;

public class love_infoSql {
	

	private Connection conn = null;
	private PreparedStatement ps = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	
	public boolean deletelove_info(int id) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			ps = conn.prepareStatement("delete from love_info where id=?");
			ps.setInt(1, id);
		
		
			if(ps.executeUpdate()>0){
				flg = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flg;
		
	}
	
	
	
	public boolean deletepraise_info(int id) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			ps = conn.prepareStatement("delete from love_praise where LOVE_ID=?");
			ps.setInt(1, id);
		
		
			if(ps.executeUpdate()>0){
				flg = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flg;
		
	}
	
	
	
	public boolean deletecomment_info(int id) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			ps = conn.prepareStatement("delete from love_comment where love_id=?");
			ps.setInt(1, id);
		
		
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
