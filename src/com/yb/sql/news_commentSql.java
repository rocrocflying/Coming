package com.yb.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yb.entity.User;
import com.yb.entity.love_comment;
import com.yb.entity.love_info;
import com.yb.entity.love_praise;
import com.yb.entity.news_comment;
import com.yb.sql.DBConn;

public class news_commentSql {
	

	private Connection conn = null;
	private PreparedStatement ps = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	
	public boolean addnews_comment(news_comment news_comment ) {
		boolean flg = false;
		try {
			conn = DBConn.getCon();
			ps = conn.prepareStatement("insert into news_comment values (? ,? ,? ,?,?)");
		
			ps.setInt(1,news_comment.getNewsid());
			ps.setInt(2,news_comment.getPrivinceid());
			ps.setString(3,news_comment.getUsrid());
			ps.setString(4, news_comment.getContent());
			ps.setString(5,news_comment.getState());
			if(ps.executeUpdate()>0){
				flg = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flg;
		
	}
	
	public List<news_comment> querynews_comment(String newsid)
	{
		List<news_comment>  news_comment=new ArrayList();
		String sql="select *from news_comment where newsid="+newsid+"";
		
		try {
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				news_comment news=new news_comment();
				news.setNewsid(rs.getInt("newsid"));
				news.setPrivinceid(rs.getInt("province_id"));
				news.setUsrid(rs.getString("usrid"));
				news.setContent(rs.getString("content"));
				news.setState(rs.getString("state"));
			    news_comment.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news_comment;
	}
	
}
