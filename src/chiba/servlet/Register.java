package chiba.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import chib.Sql_user;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import entity.user;

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
		 response.setContentType("text/html");
		  response.setCharacterEncoding("utf-8");
		  request.setCharacterEncoding("utf-8");
		Sql_user u = new Sql_user();
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
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
			
			try {
				//
				 filename=tempname+"."+smart.getFiles().getFile(0).getFileExt();
				 smart.getFiles().getFile(0).saveAs("C:\\java\\apache-tomcat-6.0.29\\apache-tomcat-6.0.29\\webapps\\dating\\uploadFile\\"+filename);
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
			
			Request req = smart .getRequest();
			SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
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
		//String province= req.getParameter("province").trim();
		String pnum= req.getParameter("pnum").trim();
		//String idcard=req.getParameter("idcard").trim();
		String brief =req.getParameter("brief").trim();
		String pic=filename;
		//String actimage ="mmmm";
		if(password.equals(password2))
		{
		user user=new user();
		user.setUSRNM(nickname);
		user.setRNAME(rname);
		user.setSTNUM(stuid);
		user.setPASSW(password);
		user.setSEX(sex);
		user.setAGE(Integer.parseInt(age));
		user.setNSTIO(nation);
		user.setADDRE(addr);
		user.setQQ(qq);
		user.setSCHOL(school);
		user.setMAJOR(major);
		
	    user.setPHNUM(pnum);
	    //user.setIDNUM(idcard);
	    
	    user.setBRIEF(brief);
	    user.setREG_DATE(tempdate1);
		user.setHEAD_PIC(pic);
        
        try {
			if(u.adduser(user)){
				
				out.print("<script>alert('注册成功!!!');window.location='login.jsp'</script>");
				}else{
					 //PrintWriter out = response.getWriter();
					//out.print(activity.getAct_charger()+activity.getAct_image()+activity.getEnd_date());
						out.print("<script>alert('注册失败?');window.location='register.jsp'</script>");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		}
		
		else
		{
			out.print("<script>alert('两次密码不一致!!!');window.location='register.jsp'</script>");
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
