/*
 * 
 * 此servlet主要负责把商品信息准备好 
 */

package cn.edu.ynnu.laibar.taobar.servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ynnu.laibar.taobar.model.SaleGoodsBean;
import cn.edu.ynnu.laibar.taobar.service.SaleGoodsCl;


public class SaleGoodsClServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		String flag=request.getParameter("flag");
		 SaleGoodsCl sgc=new SaleGoodsCl();
		 ArrayList<SaleGoodsBean> al=new ArrayList<SaleGoodsBean>();
		 if(flag.equals("detail")){//。。。。。。。。如果用户点击图片查看详情  则此部分处理用户的请求
			 String sgoodsid=request.getParameter("goodsid");
			 int goodsid=Integer.parseInt(sgoodsid);
		 al=sgc.getGoodsDetail(goodsid);
		 request.setAttribute("goodsdetail", al);
		 request.getRequestDispatcher("saledetail.jsp").forward(request, response);
		 } else if(flag.equals("sort")){//。。。。。。。如果用户点击商品分类 则此部分 为处理用户的请求
			 ArrayList<SaleGoodsBean> al_1=sgc.getSportInfo();
			 if(al_1.size()==0){//判断商铺表中是否有商品  如果没有则展示没有商品图片
				 SaleGoodsBean sgb=new SaleGoodsBean();
				 sgb.setImgpath("noneimg.jpg");
				 sgb.setGoodsid(0);
				 sgb.setPrice(0);
				 al_1.add(sgb);
			 }
			 request.setAttribute("goodssport", al_1);
			 ArrayList<SaleGoodsBean> al_2=sgc.getStudyInfo();
			 if(al_2.size()==0){//判断商铺表中是否有商品  如果没有则展示没有商品图片
				 SaleGoodsBean sgb=new SaleGoodsBean();
				 sgb.setImgpath("noneimg.jpg");
				 sgb.setGoodsid(0);
				 sgb.setPrice(0);
				 al_2.add(sgb);
			 }
			 request.setAttribute("goodsstudy", al_2);
			 ArrayList<SaleGoodsBean> al_3=sgc.getTrafficInfo();
			 if(al_3.size()==0){//判断商铺表中是否有商品  如果没有则展示没有商品图片
				 SaleGoodsBean sgb=new SaleGoodsBean();
				 sgb.setImgpath("noneimg.jpg");
				 sgb.setGoodsid(0);
				 sgb.setPrice(0);
				 al_3.add(sgb);
			 }
			 request.setAttribute("goodsTraffic", al_3);
			 ArrayList<SaleGoodsBean> al_4=sgc.getOrthersInfo();
			 if(al_4.size()==0){//判断商铺表中是否有商品  如果没有则展示没有商品图片
				 SaleGoodsBean sgb=new SaleGoodsBean();
				 sgb.setImgpath("noneimg.jpg");
				 sgb.setGoodsid(0);
				 sgb.setPrice(0);
				 al_4.add(sgb);
			 }
			 request.setAttribute("others", al_4);
			 request.getRequestDispatcher("salegoodssort.jsp").forward(request, response);
		 }
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	

}
