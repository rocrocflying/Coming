package com.yb.ybservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yb.entity.love_info;
import com.yb.entity.love_praise;
import com.yb.sql.praiseSql;



public class Praise extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Praise() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        praiseSql p=new praiseSql(); 
        love_praise love=new love_praise();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    String userid=request.getParameter("userid");
	    int userid1=Integer.parseInt(userid);
	    int loveid=Integer.parseInt(request.getParameter("loveid"));
	    int count=0;
	    count=count+1;
	    love.setLoveid(loveid);
	    love.setUserid(userid1);
	    love.setPrais_state(count);
	   
	   
	    	love_praise love2=p.querypraise(loveid, userid1);
	    	
	    	if(love2.getPrais_state()==1)
	    	{    love_info l2= p.queryloveinfo(loveid);
	    	 out.print("qwe");
	    	
	    	}else
	    	{   
	    		
	    		p.addpraise(love);
	    		p.addpraise2(loveid);
	    	 love_info l2= p.queryloveinfo(loveid);
	    	 out.print(l2.getCount());
	    	}
	 	    }
//	    	
//	    	else
//	    	{
	    	
	    	//}
	  

	

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
