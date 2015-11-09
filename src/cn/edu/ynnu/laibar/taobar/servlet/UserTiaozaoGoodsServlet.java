package cn.edu.ynnu.laibar.taobar.servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ynnu.laibar.taobar.model.SaleGoodsBean;
import cn.edu.ynnu.laibar.taobar.service.SaleGoodsCl;

public class UserTiaozaoGoodsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		String flag=request.getParameter("flag");
		System.out.println("flag="+flag);
		 SaleGoodsCl sgc=new SaleGoodsCl();
		 ArrayList<SaleGoodsBean> al=new ArrayList<SaleGoodsBean>();
		 if(flag.equals("detail")){//。。。。。。。。如果用户点击图片查看详情  则此部分处理用户的请求
			 String sgoodsid=request.getParameter("goodsid");
			 int goodsid=Integer.parseInt(sgoodsid);
		 al=sgc.getGoodsDetail(goodsid);
		 System.out.println("al="+al);
		 request.setAttribute("goodsdetail", al);
		 request.getRequestDispatcher("userTiaozaoGoodsdetail.jsp").forward(request, response);
		 }
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
}
