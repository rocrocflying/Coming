package com.yb.ybservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yb.entity.User;
import com.yb.sql.*;
import javax.servlet.http.HttpSession;


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

		response.setContentType("text/html;charset=utf-8");
		  request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		UserSql u=new UserSql();
		String stnum=request.getParameter("stnum").trim();
		String  psw=request.getParameter("psw").trim();
		try{
			if(u.queryUser(stnum, psw))
			{
				
				
				
			  User u2= u.queryPerson(stnum, psw);
				request.setAttribute("person",u2);
				
		        request.getSession().setAttribute("userkey",u2.getUsrid());
		        request.getSession().setAttribute("id",u2.getUsrid());
//		  	 String create=request.getSession().getAttribute("create").toString();
//		  	out.println("<script>alert("+create+")</script>");
//		  	  if(create==null)
			   // request.getRequestDispatcher("userCenter.jsp").forward(request, response);
////		  	  else
//		  		 response.sendRedirect(create);
			    
			    
			    request.getSession().setAttribute("userName",u2.getName() );//如果验证为真则把用户名放入session
				
				//接下来判断是哪发送来的的登录请求
				if( request.getSession().getAttribute("directiondetail")!=null){              //这个判断用户如果是从点击购买商品页时  则登录后跳转到用户所选商品的详情页面
					response.sendRedirect( request.getSession().getAttribute("directiondetail").toString());
					 request.getSession().removeAttribute("directiondetail");//清空此session
					return;
				}
				else if(request.getSession().getAttribute("directionpublish")!=null){       //这个判断的是如果用户点击我要发时 后 登录后跳转对的页面 
					response.sendRedirect( request.getSession().getAttribute("directionpublish").toString());
					 request.getSession().removeAttribute("directionpublish");
					return;
				}else if( request.getSession().getAttribute("directionrelease")!=null){              //这个判断用户如果是从点击购买商品页时  则登录后跳转到用户所选商品的详情页面
					response.sendRedirect( request.getSession().getAttribute("directionrelease").toString());
					 request.getSession().removeAttribute("directionrelease");//清空此session
					return;
				}else if( request.getSession().getAttribute("directionauctiondetail")!=null){              //这个判断用户如果是从拍卖加价页面跳转过来的  则登录后跳转到对应拍卖加价页面
					response.sendRedirect(request.getSession().getAttribute("directionauctiondetail").toString());
					 request.getSession().removeAttribute("directionauctiondetail");//清空此session
					return;
				}else if(request.getSession().getAttribute("directionpublishauction")!=null){              //这个判断用户如果是从拍卖商品发布页面跳转过来的  则登录后跳转到对应拍卖商品发布页面
					response.sendRedirect( request.getSession().getAttribute("directionpublishauction").toString());
					 request.getSession().removeAttribute("directionpublishauction");//清空此session
					return;
				}
				else if(request.getSession().getAttribute("directionuser")!=null){              //这个判断用户如果是从拍卖商品发布页面跳转过来的  则登录后跳转到对应拍卖商品发布页面
					response.sendRedirect(request.getSession().getAttribute("directionuser").toString());
					 request.getSession().removeAttribute("directionuser");//清空此session
					return;
				}
				else if(request.getSession().getAttribute("create")!=null){              //这个判断用户如果是从拍卖商品发布页面跳转过来的  则登录后跳转到对应拍卖商品发布页面
					response.sendRedirect(request.getSession().getAttribute("create").toString());
					 request.getSession().removeAttribute("create");//清空此session
					return;
				}
				else if(request.getSession().getAttribute("mycreate")!=null){              //这个判断用户如果是从拍卖商品发布页面跳转过来的  则登录后跳转到对应拍卖商品发布页面
					response.sendRedirect(request.getSession().getAttribute("mycreate").toString());
					 request.getSession().removeAttribute("mycreate");//清空此session
					return;
				}
				else if(request.getSession().getAttribute("myjoin")!=null){              //这个判断用户如果是从拍卖商品发布页面跳转过来的  则登录后跳转到对应拍卖商品发布页面
					response.sendRedirect(request.getSession().getAttribute("myjoin").toString());
					 request.getSession().removeAttribute("myjoin");//清空此session
					return;
				}
				else if(request.getSession().getAttribute("mypraise")!=null){              //这个判断用户如果是从拍卖商品发布页面跳转过来的  则登录后跳转到对应拍卖商品发布页面
					response.sendRedirect(request.getSession().getAttribute("mypraise").toString());
					 request.getSession().removeAttribute("mypraise");//清空此session
					return;
				}
				else if(request.getSession().getAttribute("mypraisea")!=null){              //这个判断用户如果是从拍卖商品发布页面跳转过来的  则登录后跳转到对应拍卖商品发布页面
					response.sendRedirect(request.getSession().getAttribute("mypraisea").toString());
					 request.getSession().removeAttribute("mypraisea");//清空此session
					return;
				}
				
				else
				{
					request.getRequestDispatcher("userCenter.jsp").forward(request, response);
				}
		
			}
			
			else
			{
				out.println("<script>alert('login fail!')</script>");	
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
