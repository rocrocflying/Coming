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



//import entity.ActivityJoin;
public class ActivityJoinServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
  response.setContentType("text/html; charset=UTF-8");
  request.setCharacterEncoding("UTF-8");
     PrintWriter out = response.getWriter();
	ActivitySql ab = new ActivitySql();
	ActivityJoinSql aj=new ActivityJoinSql();
	String aid = request.getParameter("aid");
	int id = Integer.parseInt(aid);
	//Activity activity = ab.queryActivityById(id);
	//String uid="111";
	Integer uid=(Integer)request.getSession().getAttribute("userkey");
	// int uid1=Integer.parseInt(uid);
	boolean k=aj.queryJoin(id, uid);
	
	//out.print("<script>alert('"+k+id+"')</script>");
	if(k)
	{
		Activity activity = ab.queryActivityById(id);
		out.print(activity.getAct_count());
		//out.print(" <input class='btn btn-lg btn-danger btn-block' id='btn-cancel'  type='button' value='已经报名'/>");
	}
	else
	{
	    if(ab.addActivityJoin(id,uid)){
	    	ab.addActCount(id);
	    	Activity activity = ab.queryActivityById(id);
			out.print(activity.getAct_count());
			}else{
				 //PrintWriter out = response.getWriter();
				
					out.print("<script>alert('报名失败');window.location='ShowActivityViewServlet?aid="+aid+"'</script>");
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