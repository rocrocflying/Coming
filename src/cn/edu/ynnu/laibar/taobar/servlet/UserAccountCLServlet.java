package cn.edu.ynnu.laibar.taobar.servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.ynnu.laibar.taobar.model.AuctionBean;
import cn.edu.ynnu.laibar.taobar.model.SaleGoodsBean;
import cn.edu.ynnu.laibar.taobar.model.UserBean;
import cn.edu.ynnu.laibar.taobar.model.UserOrderBean;

import cn.edu.ynnu.laibar.taobar.service.UserAccountCL;

public class UserAccountCLServlet extends HttpServlet {
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
	      String flag=request.getParameter("flag");
	      System.out.println("flag="+flag);
	      if(flag.equals("isLogin")){//如果用户点击编辑  首先要判断用户是否登录 如果没有登录 则跳转到登录界面 如果登录 了 则跳转到发布界面
	    	  if(session.getAttribute("userName")==null){
	    		  try {
	    			  session.setAttribute("directionuser", "salemainpage.jsp");//把url地址放入到session 登陆后直接跳转到发布页面
					request.getRequestDispatcher("login.jsp").forward(request, response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	  }
	    	  else{//如果用户已经登录状态 则直接跳到 我要发布界面
	    		  try {
	    			 
	    			  String name=session.getAttribute("userName").toString();
	    				//int userId=lc.getUserIdByUserName(name);
	    				Integer userId=(Integer)request.getSession().getAttribute("userkey");
	    				 UserAccountCL sgc=new UserAccountCL();
	    				 
	    				 ArrayList<UserBean> al_0=new ArrayList<UserBean>();
	    				 al_0=sgc.getUser(userId);
	    				 request.setAttribute("userdetail", al_0);
	    				 System.out.println("al_1="+al_0);
	    				 
	    				 ArrayList<SaleGoodsBean> al=new ArrayList<SaleGoodsBean>();
	    				 al=sgc.getGoodsReleaseDetail(userId);
	    				 System.out.println("al="+al);
	    				 request.setAttribute("goodsdetail", al);
	    				 
	    				 ArrayList<UserOrderBean> al_1=new ArrayList<UserOrderBean>();
	    				 al_1=sgc.getGoodsOrderDetail(userId);
	    				 request.setAttribute("goodsorderdetail", al_1);
	    				 System.out.println("al_1="+al_1);
	    				 
	    				 ArrayList<AuctionBean> al_2=new ArrayList<AuctionBean>();
	    				 al_2=sgc.getAuctionDetail(userId);
	    				 request.setAttribute("auctiondetail", al_2);
	    				 System.out.println("al_2="+al_2);
	    				 
	    				 
	    				 request.getRequestDispatcher("userAccount.jsp").forward(request, response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	  }
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
}
