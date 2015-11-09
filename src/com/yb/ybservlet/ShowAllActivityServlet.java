package com.yb.ybservlet;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yb.entity.Activity;
import com.yb.entity.ActivityAll;
import com.yb.sql.ActivityJoinSql;
import com.yb.sql.ActivitySql;

import java.text.SimpleDateFormat;
import java.util.Date;



public class ShowAllActivityServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   Date myDat =new Date();
		  String nowtime=format.format(myDat);
		  // PrintWriter out = response.getWriter();
		   //out.print(nowtime);
		    
		  // ActivitySql ab = new ActivitySql();
		 
		    ActivitySql as=new ActivitySql();
		  
		   
			List<ActivityAll> activityList= as.queryrAll();
			
			request.setAttribute("nowtime", nowtime);
			request.setAttribute("allActivity", activityList);
			
			request.getRequestDispatcher("activity.jsp").forward(request, response);
		
	 
		//request.setAttribute("info", info);
		//request.getRequestDispatcher("Activity.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
