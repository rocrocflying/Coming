package cn.edu.ynnu.laibar.taobar.servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ynnu.laibar.taobar.model.AuctionBean;
import cn.edu.ynnu.laibar.taobar.service.UserAccountCL;

public class UserAuctionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		String flag=request.getParameter("flag");
		 UserAccountCL sgc=new UserAccountCL();
		 ArrayList<AuctionBean> al=new ArrayList<AuctionBean>();
		 if(flag.equals("detail_1")){//。。。。。。。。如果用户点击图片查看详情  则此部分处理用户的请求
			 String sauctionid=request.getParameter("auctionId");
			 int auctionId=Integer.parseInt(sauctionid);
			 System.out.println("num="+auctionId);
		 al=sgc.getAuctionDetail2(auctionId);
		 System.out.println("al111="+al);
		 request.setAttribute("auctiondetail", al);
		 request.getRequestDispatcher("userAuctiondetail.jsp").forward(request, response);
		 } 
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
}
