package com.yb.ybservlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yb.entity.Activity;
import com.yb.sql.ActivitySql;

import java.io.IOException;
import java.io.PrintWriter;


//import entity.ActivityJoin;
public class DeleteActivityServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
  response.setContentType("text/html; charset=UTF-8");
  request.setCharacterEncoding("UTF-8");
     PrintWriter out = response.getWriter();
	ActivitySql ab = new ActivitySql();
	String aid = request.getParameter("aid");
	int id = Integer.parseInt(aid);



	//out.print("<script>alert('"+k+id+"')</script>");
	if(ab.deleteMyCreate(id))
	{  ab.deleteJoinById(id);
	   ab.deletePraiseById(id);
		out.print(" <script>window.location='MyCreateServlet'</script>");
	}
	else
	{
	    
		out.print("<script>alert('删除失败');window.location='MyCreateServlet'</script>");
	 }

		
	}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}