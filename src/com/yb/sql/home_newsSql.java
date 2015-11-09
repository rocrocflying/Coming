package com.yb.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yb.entity.home_news;
import com.yb.sql.DBConn;

public class home_newsSql {
	
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;

	
	public boolean insertnews(home_news news)
	{   boolean k=false;
		try
		{
		conn=DBConn.getCon();
		ps=conn.prepareStatement("insert into home_news values(?,?,?,?)");
		ps.setInt(1, news.getProvince_id());
		ps.setString(2,news.getUserid());
		ps.setString(3,news.getContent());
		ps.setInt(4,0);
		if(ps.executeUpdate()>0)
		{
			k=true;
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}finally{
		
         DBConn.closeAll(conn, ps, rs);
		}
		return k;
		
	}
	

}
