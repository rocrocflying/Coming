package cn.edu.ynnu.laibar.taobar.servlet;

/*
 * 
 *此servlet主要负责用户在跳骚市场点击购买商品后的处理
 *首先用户点击购买够 先判断用户是否登录 如果已经登录则把用户购买的商品信息 准备好 
 *如果没有登录则跳到登录页面
 */

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.ynnu.laibar.taobar.model.SaleGoodsBean;
import cn.edu.ynnu.laibar.taobar.model.UserBean;
import cn.edu.ynnu.laibar.taobar.model.UserOrderBean;
import cn.edu.ynnu.laibar.taobar.service.SaleGoodsCl;
import cn.edu.ynnu.laibar.taobar.service.SaleOrderCl;


public class BuyGoodsCLServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		HttpSession session =request.getSession();
		
		
		Object token=session.getAttribute("token");//此方法禁止用户 重复刷新成功订单页面
		String tokenValue=request.getParameter("token");
		if(token!=null&&token.equals(tokenValue)){
			session.removeAttribute("token");
		}else{
			response.sendRedirect("err.jsp");
		}
		
		
		String name =(String)session.getAttribute("userName");
		if(name!=null){//判断用户是否登录 如果没有登录  跳转到登录页面  是的话 就跳转到商品交易成功界面
			//得到用户购买的信息 并查如数据库
			//并查询出买家联系方式 为下个页面做准备
			String goodsid0=request.getParameter("goodsId");//得到货物ID
			int  commodityId=Integer.parseInt(goodsid0);
			String salerId0=request.getParameter("salerId");//得到卖家的用户ID
			int salerId=Integer.parseInt(salerId0);
		    String num0=request.getParameter("qty_item_1");//得到用户购买商品的数量
		    int goodsnum=Integer.parseInt(num0);
		    String totalprice0=request.getParameter("total_price");//得到用户购买商品的总价
		    String tp=totalprice0.substring(3);
		    float totalprice=Float.parseFloat(tp);
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");//得到用户购买时间
			Date myDate =new Date();
			String order_date=formatter.format(myDate);
			 
		    SaleGoodsCl sgc =new SaleGoodsCl();
		    SaleOrderCl soc=new SaleOrderCl();
		     int userId= sgc.getUserIdByUsername(name);   // 接下来需要做通过用户名得到买家Id
		     ArrayList<UserOrderBean> al = new ArrayList<UserOrderBean>();
		    
		   
		     if(soc.insertGoodsOrder(commodityId, userId, goodsnum, order_date, totalprice)){
		    	 
		    	 UserOrderBean uob=new UserOrderBean();
			     uob.setCommodityId(commodityId);
			     uob.setUserId(userId);
			     uob.setGoodsnum(goodsnum);
			     uob.setOrder_date(order_date);
			     uob.setTotalprice(totalprice);
			    
			     request.setAttribute("UserOrderBean", uob);//把订单表信息存储
			     
			     /*
			      * 通过商品id得到卖家的用户信息
			      * */
			     UserBean ub=soc.getUserInfoByCommodityId(commodityId);
			     request.setAttribute("UserBean", ub);
			    
			     request.getRequestDispatcher("salebuygoodssuccess.jsp").forward(request, response);
		    	 
		     }
		 
		}else{
			//跳转到登录界面
			String refererurl=request.getHeader("Referer");//记录前一url地址
			session.setAttribute("directiondetail", refererurl);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

	
}
