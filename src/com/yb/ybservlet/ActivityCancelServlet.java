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
public class ActivityCancelServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 response.setContentType("text/html; charset=UTF-8");
		 request.setCharacterEncoding("UTF-8");
		 PrintWriter out = response.getWriter();
	   ActivitySql as = new ActivitySql();
	   ActivityJoinSql aj=new ActivityJoinSql();
	   String bid =request.getParameter("bid");
	   int id = Integer.parseInt(bid);
	   Activity activity = as.queryActivityById(id);
	   //String uid="111";
	Integer uid=(Integer)request.getSession().getAttribute("userkey");
	 //int uid1=Integer.parseInt(uid);
	  boolean k=aj.queryJoin(id, uid);
	  if(k){
		  as.deleteActivityJoin(id, uid);
		  as.subActCount(id);
		  //int i=activity.getAct_count()-1;
		  //out.print(i);
		 // out.print("<input  id='btn-bm'  class='btn btn-lg btn-primary btn-block'   type='submit' value='报名参加'/>");
	  }
	  else
	  {
		  out.print("<input  id='btn-bm'  class='btn btn-lg btn-primary btn-block'   type='submit' value='报名参加'/>");
	  }
		  
	

	}
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}