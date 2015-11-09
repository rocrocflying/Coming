package chiba.servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chib.ActivitySql;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entity.Activity;
import entity.Connect;
import entity.total;

public class ShowFoodServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
  
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date myDat =new Date();
		String nowtime=format.format(myDat);
	ActivitySql ab = new ActivitySql();
	String fid = request.getParameter("fid");
	String uid=request.getSession().getAttribute("id").toString();
	if(!uid.isEmpty())
	{
	List<total> activity = ab.queryActivityBypId(fid);
	Connect joinsate=ab.queryJoinBypId(uid,fid);
	
	List<total> joinuserlist=ab.queryJoinUser(fid);
	
	request.setAttribute("joinuserlist",joinuserlist); 
	request.setAttribute("joinsate", joinsate);
	
	request.setAttribute("nowtime", nowtime);
	request.setAttribute("detail", activity);
	request.getRequestDispatcher("food_activitydetail.jsp").forward(request, response);
	}else{request.getRequestDispatcher("login.jsp").forward(request, response);}
	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
