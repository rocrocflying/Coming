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


public class ActivityPraiseAServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html; charset=UTF-8");
		  request.setCharacterEncoding("UTF-8");
		     PrintWriter out = response.getWriter();

		
 
	ActivitySql ab = new ActivitySql();
	ActivityJoinSql aj=new ActivityJoinSql();

	String aid = request.getParameter("aid");
	int id = Integer.parseInt(aid);
  // String userid=request.getSession().getAttribute("userkey").toString();
	if( request.getSession().getAttribute("userkey")!=null)
	{
	Integer uid=(Integer)request.getSession().getAttribute("userkey");
	boolean k=aj.queryIsPraise(id, uid);
	
	//out.print("<script>alert('"+k+id+"')</script>");
	if(k)
	{
		Activity activity=ab.queryActivityById(id);
    	out.print(activity.getAct_good());
		//out.print(" <span class='text-primary glyphicon glyphicon-thumbs-up'  style='magrin-left:150px'></span>已经赞过了！");
	}
	else
	{
	    if(ab.addActivityPraise(id,uid)){
	    	ab.addPraiseCount(id);
	    	Activity activity=ab.queryActivityById(id);
	    	out.print(activity.getAct_good());
		 
			//out.print("<span class='text-primary glyphicon glyphicon-thumbs-up'  style='magrin-left:150px'></span>已经赞过了！");
			}else{
				 //PrintWriter out = response.getWriter();
				
					out.print("<script>alert('点赞失败');window.location='ShowActivityViewServlet?aid="+aid+"'</script>");
			}
	}
	}
	
	//request.setAttribute("info", info);
	
	}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}