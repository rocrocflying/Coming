package chiba.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chib.Sql_connec;


public class Cancel_join extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Cancel_join() {
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
		 HttpSession session = request.getSession(false);
		String b= session.getAttribute("id").toString();
		String id=request.getParameter("id");
		try {
			
				if(new Sql_connec().cancel_join(b, id))
				{
				//out.print("<script>alert('成功参加!'); window.location='ShowAllActivityServlet'</script>");
				out.print("<script>alert('取消成功!');window.location='ShowFoodServlet?fid="+id+"'</script>");
				}else {
					out.print("<script>alert('取消失败!');window.location='ShowFoodServlet?fid="+id+"'</script>");
				}			

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
