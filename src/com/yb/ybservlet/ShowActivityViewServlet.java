package com.yb.ybservlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yb.entity.Activity;
import com.yb.entity.ActivityJoin;
import com.yb.entity.ActivityPraise;
import com.yb.entity.UserInfo;
import com.yb.sql.ActivityJoinSql;
import com.yb.sql.ActivitySql;
import com.yb.sql.TimeFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



public class ShowActivityViewServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date myDat =new Date();
	String nowtime=format.format(myDat);
  
	ActivitySql ab = new ActivitySql();
	ActivityJoinSql as=new ActivityJoinSql();
	String aid = request.getParameter("aid");
	int id = Integer.parseInt(aid);
	Activity activity = ab.queryActivityById(id);
	if( request.getSession().getAttribute("userkey")!=null)
	{
	Integer uid=(Integer)request.getSession().getAttribute("userkey");
	ActivityJoin joinsate=ab.queryJoinBypId(id,uid);
	ActivityPraise praise=as.queryPraise(id,uid);
	request.setAttribute("joinsate", joinsate);
	request.setAttribute("praise", praise);
	}
	List<UserInfo> joinuserlist=ab.queryJoinUser(id);
	try {
		long day =TimeFactory.getDaySub(nowtime, activity.getBegin_date());
		request.setAttribute("day", day);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	request.setAttribute("joinuserlist",joinuserlist);
	
	request.setAttribute("nowtime", nowtime);
	
	request.setAttribute("activity", activity);
	request.getRequestDispatcher("activitydetail.jsp").forward(request, response);
	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
