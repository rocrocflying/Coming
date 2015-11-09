package cn.edu.ynnu.laibar.taobar.servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ynnu.laibar.taobar.model.UserOrderBean;
import cn.edu.ynnu.laibar.taobar.service.UserAccountCL;

public class UserTiaozaoOrderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		String flag=request.getParameter("flag");
		 UserAccountCL sgc=new UserAccountCL();
		 ArrayList<UserOrderBean> al=new ArrayList<UserOrderBean>();
		 if(flag.equals("detail_1")){//。。。。。。。。如果用户点击图片查看详情  则此部分处理用户的请求
			 String sauctionid=request.getParameter("purchaseOrderId");
			 int purchaseOrderId=Integer.parseInt(sauctionid);
			 System.out.println("num="+purchaseOrderId);
		 al=sgc.getGoodsOrderDetail2(purchaseOrderId);
		 System.out.println("al111="+al);
		 request.setAttribute("goodsorderdetail", al);
		 request.getRequestDispatcher("goodsOrderdetail.jsp").forward(request, response);
		 } 
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
}
