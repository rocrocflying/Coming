package com.yb.ybservlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yb.entity.User;
import com.yb.sql.*;
import javax.servlet.http.HttpSession;
import com.yb.entity.UserInfo;


public class UserCenter extends HttpServlet {



	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		  request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
	    	UserSql u=new UserSql();
	    	Integer uid=(Integer)request.getSession().getAttribute("userkey");
			User u2= u.queryPersonByid(uid);
			request.setAttribute("person",u2);
				
			request.getRequestDispatcher("userCenter.jsp").forward(request, response);  
			    
			   
				
			
				
		
		
		
			
		}
		



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		    this.doGet(request, response);
	}



}
