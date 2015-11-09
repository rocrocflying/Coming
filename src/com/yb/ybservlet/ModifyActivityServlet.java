package com.yb.ybservlet;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yb.entity.Activity;
import com.yb.sql.ActivitySql;



public class ModifyActivityServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 ActivitySql as=new ActivitySql();
		String aid = request.getParameter("aid");
		int id = Integer.parseInt(aid);
		Activity activity = as.queryActivityById(id);
		 
       request.setAttribute("activity", activity);
	   request.getRequestDispatcher("modifyactivity.jsp").forward(request, response);
	 
		//request.setAttribute("info", info);
		//request.getRequestDispatcher("Activity.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
