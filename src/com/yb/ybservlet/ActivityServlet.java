package com.yb.ybservlet;

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
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.yb.entity.Activity;
import com.yb.sql.ActivitySql;
import com.yb.sql.TimeFactory;





public class ActivityServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
          // request.getSession().setAttribute("create","ShowAllActivityServlet");
		   response.setContentType("text/html; charset=UTF-8");
		   request.setCharacterEncoding("UTF-8");
		   ActivitySql ab = new ActivitySql();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		  Date myDate =new Date();
		  String tempname=formatter.format(myDate);
		 PrintWriter out = response.getWriter();
		 String aid = request.getParameter("aid");
			Activity activity =new Activity();
		// String image="";
			String filename="";
			SmartUpload smart = new SmartUpload();
			smart.initialize(this.getServletConfig(), request, response);
			smart.setCharset("UTF-8");
			
			try {
				
				smart.upload();
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
			
			try {
				//
				 filename=tempname+"."+smart.getFiles().getFile(0).getFileExt();
				 // image = smart.getFiles().getFile(0).getFileName().toString();
				//smart.save("C:\\Cisco\\uploadFile");
				if(smart.getFiles().getFile(0).getFileExt().trim()!="")
				{
				smart.getFiles().getFile(0).saveAs("\\uploadFile\\"+filename);
				activity.setAct_image(filename);
				}
				else
			  activity.setAct_image("nopic");	
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
			
			Request req = smart .getRequest();
		 
		 //String photoname = image.substring(11);
		
			
		Integer uid=(Integer)request.getSession().getAttribute("userkey");
		String acttitle = req.getParameter("acttitle").trim();
		String actplace = req.getParameter("actplace").trim();
		String actdetail  = req.getParameter("actdetail").trim();
		String actcharger = req.getParameter("actcharger").trim();
		String actemail = req.getParameter("actemail").trim();
		String actphone = req.getParameter("actphone").trim();
		String actqq = req.getParameter("actqq").trim();
		String actweix = req.getParameter("actweix").trim();
		String begindate = req.getParameter("begindate").trim();
		String enddate =req.getParameter("enddate").trim();
		
		//String actimage ="mmmm";
		
	
	//	activity.setAct_id(id);
		activity.setUser_id(uid);
		activity.setAct_title(acttitle);
		activity.setAct_place(actplace);
		activity.setAct_detail(actdetail);
		activity.setAct_charge(actcharger);
		activity.setAct_email(actemail);
		activity.setAct_phone(actphone);
		activity.setAct_qq(actqq);
		activity.setAct_weix(actweix);
		activity.setAct_date(TimeFactory.getTime());
		activity.setBegin_date(begindate);
		// PrintWriter out = response.getWriter();
		
		activity.setEnd_date(enddate);
		//activity.setAct_image(filename);
if(aid==null)	{
		
	 if(ab.addActivity(activity)){
		
			out.print("<script>alert('创建成功!');window.location='ShowAllActivityServlet'</script>");
			
			}else{
				 //PrintWriter out = response.getWriter();
				
					out.print("<script>alert('创建失败!');window.location='create.jsp'</script>");
			}
      }

else{
	int id = Integer.parseInt(aid);
	activity.setAct_id(id);
	 if(ab.updateActivityInfo(activity)){
			
			out.print("<script>alert('修改成功!');window.location='ShowAllActivityServlet'</script>");
			
			}else{
				 //PrintWriter out = response.getWriter();
				
					out.print("<script>alert('修改失败');window.location='ModifyActivityServlet?aid="+aid+"'</script>");
			}
       }

	
	
}
		
		
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
