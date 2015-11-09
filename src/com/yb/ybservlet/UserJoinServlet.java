package com.yb.ybservlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yb.entity.Activity;
import com.yb.entity.ActivityJoin;
import com.yb.entity.UserInfo;
import com.yb.sql.ActivitySql;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;




public class UserJoinServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//Date myDat =new Date();
	////String nowtime=format.format(myDat);
  
	ActivitySql ab = new ActivitySql();
	String aid = request.getParameter("aid");
	int id = Integer.parseInt(aid);
	Integer uid=(Integer)request.getSession().getAttribute("userkey");
	Activity activity = ab.queryActivityById(id);
	ActivityJoin joinsate=ab.queryJoinBypId(id,uid);
	List<UserInfo> joinuserlist=ab.queryJoinUser(id);
	
	request.setAttribute("joinuserlist",joinuserlist);
	request.setAttribute("joinsate", joinsate);
	//request.setAttribute("nowtime", nowtime);
	request.setAttribute("activity", activity);
	request.getRequestDispatcher("userjion.jsp").forward(request, response);
	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
