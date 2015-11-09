package chiba.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chib.Sql_user;


import entity.user;

public class Login extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Login() {
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

		 response.setContentType("text/html");
		  response.setCharacterEncoding("utf-8");
		  request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Sql_user u=new Sql_user();
		String username=request.getParameter("username").trim();
		String  psw=request.getParameter("psw").trim();
		try{
			if(u.queryuser(username, psw))
			{
			    String userid= u.queryid(username, psw);
				request.setAttribute("username",username);
		        request.getSession().setAttribute("id",userid);
			    request.getRequestDispatcher("ShowAllActivityServlet").forward(request, response);
			}
			
			else
			{
				out.println("<script>alert('用户名或密码错误!');window.location='login.jsp'</script>");	
			}}catch(Exception e)
			{
				e.printStackTrace();
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
