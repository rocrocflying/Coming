package chiba.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Date;
//import java.io.PrintWriter;
//import java.util.regex.Pattern;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chib.ActivitySql;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;



import entity.Activity;

public class FoodActivityServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id ; 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html");
		  response.setCharacterEncoding("utf-8");
		  request.setCharacterEncoding("utf-8");
 		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");
		  Date myDate =new Date();
		String tempname=formatter.format(myDate);
		
		
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		  Date myDate2 =new Date();
		String tempname2=formatter2.format(myDate2);
		ActivitySql ab = new ActivitySql();
		
		 PrintWriter out = response.getWriter();
		 if(panduan(request, response,out))
		 {
			 
		 }else {
			
		}
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
				smart.getFiles().getFile(0).saveAs("\\food_uploadFile\\"+image);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Request req = smart .getRequest();
		  //String image = smart.getFiles().getFile(0).getFileName().toString();
		 //String photoname = image.substring(11);
		
			
		//String userid ="111";
		String acttitle = req.getParameter("acttitle").trim();
		//String actplace = req.getParameter("actplace").trim();
		String actdetail  = req.getParameter("actdetail").trim();
		/*String actcharger = req.getParameter("actcharger").trim();
		String actemail = req.getParameter("actemail").trim();
		String actphone = req.getParameter("actphone").trim();
		String actqq = req.getParameter("actqq").trim();
		String actweix = req.getParameter("actweix").trim();*/
		
			String begindate = req.getParameter("start_at").trim();
			String enddate =req.getParameter("end_at").trim();
		
		
		//String actimage ="mmmm";
		
		Activity activity =new Activity();
		
		
		activity.setWc_title(acttitle);
		//activity.setWc_address(actplace);
		activity.setWc_describe(actdetail);
		/*activity.setWc_name(actcharger);
		activity.setWc_email(actemail);
		activity.setWc_phone(actphone);
		activity.setWc_QQ(actqq);
		activity.setWc_weix(actweix);*/
		activity.setWc_begintime(begindate);
		activity.setWc_finsintime(enddate);
		 PrintWriter out2 = response.getWriter();
		activity.setWc_src(image);
		activity.setWc_date(tempname2);//此刻时间
		//activity.setEnd_date(enddate);
		
		
		
	 try {
		 if(!(id.isEmpty()))
		 {
		if(ab.addActivity(activity,id)){
			   
				out.print("<script>alert('添加活动成功，将会跳入主页!');window.location='FoodShowAllActivityServlet'</script>");
				}else{
					 //PrintWriter out = response.getWriter();
					//out.print(activity.getAct_charger()+activity.getAct_image()+activity.getEnd_date());
						out.print("<script>alert('添加失败!');window.location='food_create.jsp'</script>");
				}
		 }else {
			 out.print("<script>alert('还未登录，请您先登录!');window.location='food_activity.jsp'</script>");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		//request.setAttribute("info", info);
		//request.getRequestDispatcher("Activity.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	private boolean panduan(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
	{
		boolean flag=false;
		
		//此处不新建session，只是去取已经创建的session 
		HttpSession session = request.getSession(false); 
		//如果session能够取到，说明用户已经登录 
		if(session!=null) 
		{ 
		id = session.getAttribute("id").toString(); 
	    flag=true;
		} 
		//否则，说明用户没有登录，跳转到登录页面让用户登录 
		else 
		{ 
			out.print("<script>alert('还未登录，请登录！');window.location='activity.jsp'</script>");
		}
		return flag; 
	}

}
