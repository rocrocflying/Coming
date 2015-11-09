package com.yb.ybservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yb.entity.news_comment;
import com.yb.sql.news_commentSql;

public class news_commentt extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public news_commentt() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		
		news_comment newscom=new news_comment();
		news_commentSql newscomsql=new news_commentSql();
		String comment=request.getParameter("comment");
		String usrid=request.getParameter("usrid");
		String province_id=request.getParameter("province_id");
		String newsid=request.getParameter("newsid");
		newscom.setNewsid(Integer.parseInt(newsid));
		newscom.setPrivinceid(Integer.parseInt(province_id));
		newscom.setContent(comment);
		newscom.setUsrid(usrid);
		try
		{
			if(newscomsql.addnews_comment(newscom))
			{
				out.println("<script>alert('评论成功!');window.location.href='homenewsinfo.jsp?id="+newsid+"'</script>");
			}
		}catch(Exception e)
		{
			
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

		response.setContentType("text/html");
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
