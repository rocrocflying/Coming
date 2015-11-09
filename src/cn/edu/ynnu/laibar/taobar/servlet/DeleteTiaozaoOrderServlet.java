package cn.edu.ynnu.laibar.taobar.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ynnu.laibar.taobar.service.UserAccountCL;

public class DeleteTiaozaoOrderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		String flag=request.getParameter("flag");
	    response.setContentType("text/html;charset=utf-8");//设置字符编码
	    
	    if(flag.equals("detail")){//。。。。。。。。如果用户点击图片查看详情  则此部分处理用户的请求{
	    	 String sgoodsid = request.getParameter("purchaseOrderId");
	         int purchaseOrderId=Integer.parseInt(sgoodsid);
	   
		
			//调用方法 把数据插入数据库
			UserAccountCL pgc=new UserAccountCL();
			boolean b = true;
			b=pgc.deleteGoodsOrder(purchaseOrderId);
			if(b==true){
				//如果为真则跳转到 发布成功页面
				try {
					request.getRequestDispatcher("TiaozaoOrderSuccess.jsp").forward(request, response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    }
	        
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException{
		// TODO Auto-generated method stub
		this.doGet(request, response);
		
	}
}
