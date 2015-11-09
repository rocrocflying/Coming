package cn.edu.ynnu.laibar.taobar.servlet;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ZhuxiaoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");//设置字符编码
	    HttpSession session =request.getSession();
	      String flag=request.getParameter("flag");
	      System.out.println("flag="+flag);
	      if(flag.equals("zhuxiao")){                //为当用户输入完编辑信息时 点击提交 则跳转到此
				try {
					session.removeAttribute("userName");
					request.getRequestDispatcher("salemainpage.jsp").forward(request, response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
