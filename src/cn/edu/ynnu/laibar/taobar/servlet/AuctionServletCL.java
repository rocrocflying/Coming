package cn.edu.ynnu.laibar.taobar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.ynnu.laibar.taobar.model.AuctionBeanBO;
import cn.edu.ynnu.laibar.taobar.service.AuctionAddPrice;


public class AuctionServletCL extends HttpServlet {

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

		 HttpSession session =request.getSession();
		 response.setCharacterEncoding("utf-8");
	     String flag=request.getParameter("flag");
	     String id=request.getParameter("auctionId");
	     int AuctionId=Integer.parseInt(id);
	     AuctionBeanBO ab=new AuctionBeanBO();
	     ArrayList al=new ArrayList();
	     
	     String name =(String)session.getAttribute("userName");
				
	     if(flag.equals("detail_1")){
	    	 al=ab.getAuctionDetail(AuctionId);
	    	 request.setAttribute("auctiondetail", al);
	    	 request.getRequestDispatcher("auctiondetail.jsp").forward(request, response);
		 }
	     else if(flag.equals("detail_2")&& name!=null){
	    	 String qty=request.getParameter("qty_item_1");
	    	 String total=request.getParameter("total_price");
	    	 float qty2=Float.parseFloat(qty);
	    	 AuctionAddPrice aap=new AuctionAddPrice();
	    	 if(aap.updateAuctiondetail(AuctionId, qty2)){
	    		String refererurl=request.getHeader("Referer");//记录前一url地址
	 			session.setAttribute("directionauctiondetail", refererurl);
	    		request.getRequestDispatcher("/auctionsuccess.jsp").forward(request, response);
	    	 }
	     }
		else{
			//跳转到登录界面
			String refererurl=request.getHeader("Referer");//记录前一url地址
			session.setAttribute("directionauctiondetail", refererurl);
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
