package com.yb.ybservlet;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import com.yb.entity.Activity;
import com.yb.entity.User;
import com.yb.sql.ActivitySql;
import com.yb.sql.UserSql;


public class Register extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Register() {
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
        response.setContentType("text/html;charset=utf-8");
		UserSql u = new UserSql();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");
		  Date myDate =new Date();
		  String tempname=formatter.format(myDate);
		 PrintWriter out = response.getWriter();
		// String image="";
			String filename="";
			SmartUpload smart = new SmartUpload();
			smart.initialize(this.getServletConfig(), request, response);
			smart.setCharset("UTF-8");
			
			try {
				
				smart.upload();
				//smart.setAllowedFilesList("jpg,gif,jpeg,png");
			} catch (SmartUploadException e) {
			    
				e.printStackTrace();
			}
			if(!(smart.getFiles().getFile(0).getFileExt().equals("jpg") ||smart.getFiles().getFile(0).getFileExt().equals("JPG")||smart.getFiles().getFile(0).getFileExt().equals("jpeg")||smart.getFiles().getFile(0).getFileExt().equals("png")))
			{
		out.print("<script>alert('请上传jpg、jpeg、png格式图片');window.location='register.jsp';</script>");  
			}
			else
			{
			try {
				//
			
				
				 filename=tempname+"."+smart.getFiles().getFile(0).getFileExt();
				smart.getFiles().getFile(0).saveAs("\\img\\user2\\"+filename);
				
             
             
        
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
			
			Request req = smart .getRequest();
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMddhhmmss");
			  Date myDate1 =new Date();
			  String tempdate1=formatter1.format(myDate);
		String userid ="111";
	
		String nickname = req.getParameter("nickname").trim();
		String rname= req.getParameter("rname").trim();
		String stuid = req.getParameter("stuid").trim();
		String password = req.getParameter("password").trim();
		String password2 = req.getParameter("password2").trim();
		String sex = req.getParameter("sex").trim();
		String age =req.getParameter("age").trim();
		String nation= req.getParameter("nation").trim();
		String addr = req.getParameter("addr").trim();
		String qq =req.getParameter("qq").trim();
		String school = req.getParameter("school").trim();
		String major = req.getParameter("major").trim();
		String province= req.getParameter("province").trim();
		String pnum= req.getParameter("pnum").trim();

		String brief =req.getParameter("brief").trim();
		
		//String actimage ="mmmm";
		if(password.equals(password2))
		{
		User user=new User();
		user.setBrief(brief);
		user.setAge(age);
		user.setMajor(major);
		user.setName(nickname);
		user.setPhnum(pnum);
		user.setNation(nation);
	
		user.setPoint(0);
		user.setPrivince(province);
		user.setTx_pix(filename);
		user.setRe_date(tempdate1);
		user.setQq(qq);
        user.setPwd(password);
        user.setSch(school);
        user.setHome(addr);
        user.setStuid(stuid);
        user.setSex(sex);
        user.setRname(rname);
        
        if(u.addUser(user)){
    		
			out.print("<script>alert('注册成功!!!');window.location='login.jsp'</script>");
			}else{
				 //PrintWriter out = response.getWriter();
				//out.print(activity.getAct_charger()+activity.getAct_image()+activity.getEnd_date());
					out.print("<script>alert('注册失败！');window.location='register.jsp'</script>");
			}
        
		}
		
		else
		{
			out.print("<script>alert('注册失败!!!');window.location='register.jsp'</script>");
		}
        
     
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
