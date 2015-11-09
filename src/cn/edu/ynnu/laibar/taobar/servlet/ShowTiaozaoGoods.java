package cn.edu.ynnu.laibar.taobar.servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cn.edu.ynnu.laibar.taobar.model.SaleGoodsBean;

import cn.edu.ynnu.laibar.taobar.service.LoginCl;
import cn.edu.ynnu.laibar.taobar.service.UserAccountCL;

public class ShowTiaozaoGoods extends HttpServlet {
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
	    				 	    				 
	    ArrayList<SaleGoodsBean> al=new ArrayList<SaleGoodsBean>();
	    al=sgc.getGoodsReleaseDetail(userId);
	    System.out.println("al="+al);
	    request.setAttribute("goodsdetail", al);
	    				  
	    request.getRequestDispatcher("TiaozaoGoods.jsp").forward(request, response);

		
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
