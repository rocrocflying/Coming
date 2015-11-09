package com.yb.ybservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yb.entity.love_comment;
import com.yb.sql.love_commentSql;

public class love_commentt extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public love_commentt() {
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
        love_comment love_comment=new love_comment();
        love_commentSql commentsql=new love_commentSql();
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String usrid=request.getParameter("usrid");
		String loveid=request.getParameter("loveid");
		String content=request.getParameter("comment");
	    love_comment.setLove_id(Integer.parseInt(loveid));
	    love_comment.setUsrid(usrid);
	    love_comment.setContent(content);
	 
		 if(commentsql.addlove_comment(love_comment))	
		 {
			 out.println("<script>alert('评论成功!');window.location.href='ybinfo.jsp?id="+loveid+"'</script>");
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
		request.setCharacterEncoding("utf-8");
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
