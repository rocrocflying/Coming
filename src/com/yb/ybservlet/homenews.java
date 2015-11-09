package com.yb.ybservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yb.entity.home_news;
import com.yb.sql.home_newsSql;



public class homenews extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public homenews() {
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

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		home_news news=new home_news();
		home_newsSql newsSql=new home_newsSql();
		String province_id1=request.getParameter("province_id");
		int province_id2=Integer.parseInt(province_id1);
		String userid1=request.getParameter("usrid");
		String  content1=request.getParameter("home_content");
		news.setUserid(userid1);
		news.setProvince_id(province_id2);
		news.setContent(content1); 
		if(newsSql.insertnews(news)); 
		{
			out.println("<script>alert('发布动态成功!');history.back();window.location='homeinfo.jsp?id="+province_id1+"'</script>");
		}
		
		
		
		
	}

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
