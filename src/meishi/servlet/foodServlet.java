package meishi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Date;
//import java.io.PrintWriter;
//import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chib.ActivitySql;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import meishi.*;


import entity.activity_info;


public class foodServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public foodServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		  Date myDate =new Date();
		String tempname=formatter.format(myDate);
		
		ActivitySql_food ab = new ActivitySql_food();
		
		 PrintWriter out = response.getWriter();
		 
			SmartUpload smart = new SmartUpload();
			smart.initialize(this.getServletConfig(), request, response);
			smart.setCharset("UTF-8");
			String image="";
			try {
				
				smart.upload();
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
			
			try {
				//
				 //image = smart.getFiles().getFile(0).getFileName().toString();
				//smart.save("C:\\uploadFile");
				image=tempname+"."+smart.getFiles().getFile(0).getFileExt();
				smart.getFiles().getFile(0).saveAs("\\food_uploadFile\\food\\"+image);
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
			
			Request req = smart.getRequest();
		  //String image = smart.getFiles().getFile(0).getFileName().toString();
		 //String photoname = image.substring(11);
		
			
		String userid ="111";
		String acttitle = req.getParameter("acttitle").trim();
		String actplace = req.getParameter("actplace").trim();
		String actdetail  = req.getParameter("actdetail").trim();
		//String actcharger = req.getParameter("actcharger").trim();
		//String actemail = req.getParameter("actemail").trim();
		//String actphone = req.getParameter("actphone").trim();
		//String actqq = req.getParameter("actqq").trim();
		//String actweix = req.getParameter("actweix").trim();
		//String begindate = req.getParameter("begindate").trim();
		//String enddate =req.getParameter("enddate").trim();
		
		//String actimage ="mmmm";
		
		activity_info activity =new activity_info();
		
		activity.setUser_id(userid);
		activity.setAct_title(acttitle);
		activity.setAct_place(actplace);
		activity.setAct_detail(actdetail);
		//activity.setAct_charger(actcharger);
		//activity.setAct_email(actemail);
		//activity.setAct_phone(actphone);
		//activity.setAct_qq(actqq);
		//activity.setAct_weix(actweix);
		//activity.setBegin_date(begindate);
		// PrintWriter out = response.getWriter();
		activity.setAct_image(image);
		//activity.setEnd_date(enddate);
		
		
		
	 if(ab.addActivity(activity)){
		
			out.print("<script>alert('sucess!!!');window.location='Showfood'</script>");
			}else{
				 //PrintWriter out = response.getWriter();
				//out.print(activity.getAct_charger()+activity.getAct_image()+activity.getEnd_date());
					out.print("<script>alert('fail');window.location='createfood.jsp'</script>");
			}
		
		//request.setAttribute("info", info);
		//request.getRequestDispatcher("Activity.jsp").forward(request, response);
		
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
