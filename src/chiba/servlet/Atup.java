package chiba.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chib.ActivitySql;
import chib.Sql_connec;


public class Atup extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Atup() {
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
			if(!(new Sql_connec().panduan_state(b,id).equals("2"))&&!(new Sql_connec().panduan_state(b,id).equals("1")))
			{
			
				if(new Sql_connec().userjoin_act(b,id))
				{
				//out.print("<script>alert('成功参加!'); window.location='ShowAllActivityServlet'</script>");
				out.print("<script>alert('成功参加!');window.location='ShowFoodServlet?fid="+id+"'</script>");
				}else {
					out.print("<script>alert('参加失败!');window.location='ShowFoodServlet?fid="+id+"'</script>");
				}
			}
			
			else {
				if((new Sql_connec().panduan_state(b,id).equals("2")))
				{
				out.print("<script>alert('你是本次活动的发起者不能参加');window.location='ShowFoodServlet?fid="+id+"'</script></script>");
				}
				else if((new Sql_connec().panduan_state(b,id).equals("1")))
				{
					out.print("<script>alert('你已参加，不能重复参加');window.location='ShowFoodServlet?fid="+id+"'</script></script>");
				}
				else {
					out.print("<script>alert('其他错误类型');;window.location='ShowFoodServlet?fid="+id+"'</script>");
				}
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
