package cn.edu.ynnu.laibar.taobar.servlet;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.ynnu.laibar.taobar.model.UserBean;
import cn.edu.ynnu.laibar.taobar.service.LoginCl;
import cn.edu.ynnu.laibar.taobar.service.UserAccountCL;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

public class EditUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");//设置字符编码
	    HttpSession session =request.getSession();
	      String flag=request.getParameter("flag");
	      System.out.println("flag="+flag);
	      if(flag.equals("edit")){                //为当用户输入完编辑信息时 点击提交 则跳转到此
		    String path=this.getServletContext().getRealPath("/img/img_users");//得到上传路径
		    System.out.println("path"+path);
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");//
			  Date myDate =new Date();
			  String tempname=formatter.format(myDate);
			  String filename="";
				SmartUpload smart = new SmartUpload();
				smart.initialize(this.getServletConfig(), request, response);
				smart.setCharset("UTF-8");
				try {
					
					smart.upload();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try {
					//
					 filename=tempname+"."+smart.getFiles().getFile(0).getFileExt();
					 // image = smart.getFiles().getFile(0).getFileName().toString();
					//smart.save("C:\\Cisco\\uploadFile");
					smart.getFiles().getFile(0).saveAs(path+"/"+filename);
				} catch (Exception e) {
					e.printStackTrace();//以上为完成图片上传
				}
//				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//				 Date myDat =new Date();
//				 String uptime=format.format(myDat);//得到上传的时间
				Request req = smart .getRequest();
				//得到表单信息
				String username=req.getParameter("username");
				String password=req.getParameter("password");	
				String studentId=req.getParameter("studentId");		
				String age0 = req.getParameter("age");
				int age = Integer.parseInt(age0);		
				String major = req.getParameter("major");	
				String school = req.getParameter("school");	
				String nation = req.getParameter("nation");	
				String realname = req.getParameter("realname");	
				String sex = req.getParameter("sex");	
				String address =req.getParameter("address");
				String phone = req.getParameter("phone");
				String qq = req.getParameter("qq");	
				String nativePlace = req.getParameter("nativePlace");	
				String brief = req.getParameter("brief");
				
				//得到用户id
				
				String name=session.getAttribute("userName").toString();
				LoginCl lc=new LoginCl();
				int userid=lc.getUserIdByUserName(name);
				
				//准备SaleGoodsBean 数据
				UserBean ab=new UserBean();
				ab.setUserId(userid);
				ab.setUserName(username);
				ab.setStudentId(studentId);
				ab.setPassword(password);
				ab.setAge(age);
				ab.setMajor(major);
				ab.setSchool(school);
				ab.setNation(nation);
				ab.setRealname(realname);
				ab.setSex(sex);
				ab.setAddress(address);
				ab.setPhone(phone);
				ab.setQq(qq);
				ab.setNativePlace(nativePlace);
				ab.setBrief(brief);

			
				//调用方法 把数据插入数据库
				UserAccountCL pgc=new UserAccountCL();
				if(pgc.updateUser(username, studentId, password,age,major,school,nation,realname,sex,
						address,phone,qq,nativePlace,brief,filename,userid)){
					try {
						request.getRequestDispatcher("editusersuccess.jsp").forward(request, response);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
		}else if(flag.equals("continueedit")){//当用户点击继续发布时跳转到此
			
				try {
					request.getRequestDispatcher("editUser.jsp").forward(request, response);
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
