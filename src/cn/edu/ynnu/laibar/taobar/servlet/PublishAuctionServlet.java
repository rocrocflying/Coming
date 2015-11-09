package cn.edu.ynnu.laibar.taobar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.ynnu.laibar.taobar.model.AuctionBean;
import cn.edu.ynnu.laibar.taobar.model.SaleGoodsBean;

import cn.edu.ynnu.laibar.taobar.service.PublishAuction;
import cn.edu.ynnu.laibar.taobar.service.PublishGoodsCl;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

public class PublishAuctionServlet extends HttpServlet {

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
		
		response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");//设置字符编码
	    HttpSession session =request.getSession();
	    
	    String flag=request.getParameter("flag");
	    if(flag.equals("publishing2")){//如果用户点击我要发布  首先要判断用户是否登录 如果没有登录 则跳转到登录界面 如果登录 了 则跳转到发布界面
	    if(session.getAttribute("userName")==null){
  		  try {
  			  	session.setAttribute("directionpublishauction", "publishauction.jsp");//把url地址放入到session 登陆后直接跳转到拍卖商品发布页面
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	   }
	   else{//如果用户已经登录状态 则直接跳到 我要发布界面
  		  try {
				request.getRequestDispatcher("publishauction.jsp").forward(request, response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	   }
    }
    else if(flag.equals("published2")){                //此功能为当用户输入完发布信息时 点击发布  则跳转到此
	    String path=this.getServletContext().getRealPath("/img/img_auction");//得到上传路径
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
				 filename=tempname+"."+smart.getFiles().getFile(0).getFileExt();
				 smart.getFiles().getFile(0).saveAs(path+"/"+filename);
			} catch (Exception e) {
				e.printStackTrace();//以上为完成图片上传
			}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date myDat =new Date();
			String uptime=format.format(myDat);//得到上传的时间
			
			Request req = smart .getRequest();
			//得到表单信息
			String auctionname=req.getParameter("auctionname");
			String startprice0=req.getParameter("startprice");
			float startprice=Float.parseFloat(startprice0);
			String expectprice0=req.getParameter("expectprice");
			float expectprice=Float.parseFloat(expectprice0);
			String auctionsort=req.getParameter("auctionsort");
			String auctionintro=req.getParameter("auctionintro");
			
			//定义一个测试userid
			String name=session.getAttribute("userName").toString();
			
			//int =lc.getUserIdByUserName(name);
			
			Integer userid=(Integer)request.getSession().getAttribute("userkey");
			
			//准备AuctionBean数据
			AuctionBean ab=new AuctionBean();
//			ab.setUserId(userid);//????????????????????//session 中得到用户Id
			ab.setDetail(auctionintro);
			ab.setExpectprice(expectprice);
			ab.setName(auctionname);
			ab.setPhotopath(filename);
			ab.setStartprice(startprice);
			ab.setType(auctionsort);
			ab.setBidtimes(0);
			ab.setCurrentprice(startprice);
			//ab.setFinishtime(null);
			//ab.setStarttime(null);
			ab.setUSRID(userid);
			ab.setIncreaseprice(0);
			
			//调用方法 把数据插入数据库
		    PublishAuction pa=new PublishAuction();
		    if(pa.insertPublishAuction(auctionname, auctionsort, filename, auctionintro, startprice, startprice, 0,expectprice, 0, userid)){
		    	//如果为真则跳转到 发布成功页面
		    	request.getRequestDispatcher("/auctionpublishsuccess.jsp").forward(request, response);
		    }
  	  }
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

}
