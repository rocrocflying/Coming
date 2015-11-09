package com.yb.ybservlet;


import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yb.entity.Activity;
import com.yb.sql.ActivityJoinSql;
import com.yb.sql.ActivitySql;

import java.io.IOException;
import java.io.PrintWriter;


public class ActivityPraiseServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
  response.setContentType("text/html; charset=UTF-8");
  request.setCharacterEncoding("UTF-8");
     PrintWriter out = response.getWriter();
 
	ActivitySql ab = new ActivitySql();
	ActivityJoinSql aj=new ActivityJoinSql();

	String aid = request.getParameter("aid");
	int id = Integer.parseInt(aid);
	
	String uid=request.getSession().getAttribute("userkey").toString();
	 int uid1=Integer.parseInt(uid);
	boolean k=aj.queryIsPraise(id, uid1);
	
	//out.print("<script>alert('"+k+id+"')</script>");
	if(k)
	{
	
		out.print(" <span class='text-danger text-danger fa fa-thumbs-o-up'  style='magrin-left:150px'></span>您已经赞过了！");
	}
	else
	{
	    if(ab.addActivityPraise(id,uid1)){
	    	
	    	ab.addPraiseCount(id);
			out.print("<span class='text-danger text-danger fa fa-thumbs-o-up'  style='magrin-left:150px'></span>您已经赞过了！");
			}else{
				 //PrintWriter out = response.getWriter();
				
					out.print("<script>alert('点赞失败');window.location='ShowActivityViewServlet?aid="+aid+"'</script>");
			}
	}
		//request.setAttribute("info", info);
		//request.getRequestDispatcher("Activity.jsp").forward(request, response);
		
	}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}