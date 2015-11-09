package chiba.servlet;
import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chib.ActivitySql;



import entity.Activity;
import entity.total;
public class FoodShowAllActivityServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    ActivitySql as=new ActivitySql();
		    
		    
			//Activity activity =new Activity();
		    if(!(String.valueOf(request.getSession().getAttribute("id")).isEmpty()))
		    {
		    	String session=String.valueOf(request.getSession().getAttribute("id"));
		    	
			List<total> activityList= as.queryAll();
		     
			request.setAttribute("allActivity", activityList);
			
			request.getRequestDispatcher("food_activity.jsp").forward(request, response);
		    	
		
		    }else {
		    	request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		//request.setAttribute("info", info);
		//request.getRequestDispatcher("Activity.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
