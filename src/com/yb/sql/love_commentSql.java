package com.yb.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.yb.entity.User;
import com.yb.entity.love_comment;
import com.yb.entity.love_info;
import com.yb.entity.love_praise;
import com.yb.sql.DBConn;

public class love_commentSql {
	

	private Connection conn = null;
	private PreparedStatement ps = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	
	public boolean addlove_comment(love_comment love_comment ) {
		boolean flg = false;
		try {
			conn =DBConn.getCon();
			ps = conn.prepareStatement("insert into love_comment values (? ,? ,? ,?)");
		
			ps.setInt(1,love_comment.getLove_id());
			ps.setString(2,love_comment.getUsrid());
			ps.setString(3,love_comment.getContent());
			ps.setString(4, love_comment.getState());
			if(ps.executeUpdate()>0){
				flg = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flg;
		
	}
	
}
