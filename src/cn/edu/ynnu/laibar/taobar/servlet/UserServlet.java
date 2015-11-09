package cn.edu.ynnu.laibar.taobar.servlet;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.ynnu.laibar.taobar.model.UserBean;
import cn.edu.ynnu.laibar.taobar.service.UserAccountCL;

public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		String flag=request.getParameter("flag");
		 UserAccountCL sgc=new UserAccountCL();
		 ArrayList<UserBean> al=new ArrayList<UserBean>();
		 if(flag.equals("detail")){//。。。。。。。。如果用户点击图片查看详情  则此部分处理用户的请求
			 String suserid=request.getParameter("userId");
			 int userId=Integer.parseInt(suserid);
			 System.out.println("num="+userId);
		 al=sgc.getUser(userId);
		 System.out.println("al111="+al);
		 request.setAttribute("userdetail", al);
		 request.getRequestDispatcher("userdetail.jsp").forward(request, response);
		 } 
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
}
