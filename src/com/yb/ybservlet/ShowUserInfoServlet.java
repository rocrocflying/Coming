package com.yb.ybservlet;


import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yb.entity.UserInfo;
import com.yb.sql.UserSql;

import java.io.IOException;

public class ShowUserInfoServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
  
		UserSql ab = new UserSql();
	String uid = request.getParameter("uid");
	//String uid=request.getSession().getAttribute("userkey").toString();
	 int uid1=Integer.parseInt(uid);
	//int id = Integer.parseInt(uid);
	UserInfo userInfo = ab.queryUserInfoBypId(uid1);
	request.setAttribute("userInfo", userInfo);
	request.getRequestDispatcher("userinfo.jsp").forward(request, response); 
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}





