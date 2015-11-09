package cn.edu.ynnu.laibar.taobar.servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.ynnu.laibar.taobar.model.SaleGoodsBean;
import cn.edu.ynnu.laibar.taobar.model.UserOrderBean;
import cn.edu.ynnu.laibar.taobar.service.LoginCl;
import cn.edu.ynnu.laibar.taobar.service.UserAccountCL;

public class ShowTiaozaoOrder extends HttpServlet {
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

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		HttpSession session =request.getSession();

	    String name=session.getAttribute("userName").toString();
	    LoginCl lc = new LoginCl();
	    int userId=lc.getUserIdByUserName(name);

	    UserAccountCL sgc=new UserAccountCL();
	    				 	    				 
	    ArrayList<UserOrderBean> al=new ArrayList<UserOrderBean>();
		 al=sgc.getGoodsOrderDetail(userId);
		 request.setAttribute("goodsorderdetail", al);
	    				  
	    request.getRequestDispatcher("TiaozaoOrder.jsp").forward(request, response);

		
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
}
