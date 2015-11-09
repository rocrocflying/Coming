package cn.edu.ynnu.laibar.taobar.servlet;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.ynnu.laibar.taobar.model.SaleGoodsBean;

import cn.edu.ynnu.laibar.taobar.service.PublishGoodsCl;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;





public class PublishGoodsClServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");//设置字符编码
	    HttpSession session =request.getSession();
	      String flag=request.getParameter("flag");
	      if(flag.equals("publishing")){//如果用户点击我要发布  首先要判断用户是否登录 如果没有登录 则跳转到登录界面 如果登录 了 则跳转到发布界面
	    	  if(session.getAttribute("userName")==null){
	    		  try {
	    			  session.setAttribute("directionpublish", "publishedgoods.jsp");//把url地址放入到session 登陆后直接跳转到发布页面
					request.getRequestDispatcher("login.jsp").forward(request, response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	  }
	    	  else{//如果用户已经登录状态 则直接跳到 我要发布界面
	    		  try {
					request.getRequestDispatcher("publishedgoods.jsp").forward(request, response);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	  }
	      }
	      else if(flag.equals("published")){                //次功能为当用户输入完发布信息时 点击发布  则跳转到此
		    String path=this.getServletContext().getRealPath("/img/img_goods");//得到上传路径
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
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				 Date myDat =new Date();
				 String uptime=format.format(myDat);//得到上传的时间
				Request req = smart .getRequest();
				//得到表单信息
				String goodsname=req.getParameter("goodsname");
				String goodsprice0=req.getParameter("price");
				float goodsprice=Float.parseFloat(goodsprice0);
				String goodssort=req.getParameter("goodssort");
				String goodsnum0=req.getParameter("num");
				int goodsnum=Integer.parseInt(goodsnum0);
				String goodsintro=req.getParameter("goodsintro");
				
				//得到用户id
				String name=session.getAttribute("userName").toString();
			
				//int userid=lc.getUserIdByUserName(name);
				Integer userid=(Integer)request.getSession().getAttribute("userkey");
				//准备SaleGoodsBean 数据
				SaleGoodsBean sgb=new SaleGoodsBean();
				sgb.setCommodityName(goodsname);
				sgb.setBrand("");
				sgb.setPrice(goodsprice);
				sgb.setQuantity(0);
				sgb.setGoodsdetail(goodsintro);
				sgb.setGoodssort(goodssort);
				sgb.setRelease_date(uptime);
				sgb.setPraiseNum(goodsnum);
				sgb.setUserId(userid);
				sgb.setReleaseState("");	
				sgb.setImgpath(filename);//图片路径
				sgb.setCommodityClass("");
			
				//调用方法 把数据插入数据库
				PublishGoodsCl pgc=new PublishGoodsCl();
				if(pgc.insertPublishGoods(filename, goodsintro, goodsprice, goodsname, goodssort, 0, uptime, goodsnum, "", "", "", userid)){
							try {
								request.getRequestDispatcher("publishgoodssuccess.jsp").forward(request, response);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				}
		}else if(flag.equals("continuepublish")){//当用户点击继续发布时跳转到此
			
				try {
					request.getRequestDispatcher("publishedgoods.jsp").forward(request, response);
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





