<%@ page language="java" import="java.util.*,cn.edu.ynnu.laibar.taobar.model.*,cn.edu.ynnu.laibar.taobar.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

ArrayList al=new ArrayList();
AuctionBean ab=new AuctionBean();
al=(ArrayList)request.getAttribute("auctiondetail");
ab=(AuctionBean)al.get(0);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>拍卖商品详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="js/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="js/bootstrap/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>
	 <script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
    <script type="text/javascript" src="js/payfor.js"></script>
  </head>
  
  <body>
   <body style="background:#E0E0E0"><jsp:include page="head.jsp"></jsp:include>
  <br>  <br>  <br>
   <div class="container" >
	<div class="row clearfix">
		<div class="col-md-12 column">
		<form action="" method="post">
			<table class="table table-bordered" style="background:#fff">		
			<tbody>
							<tr>
								<td colspan="2">
								<center>
									<img alt="" src="img/img_auction/<%=ab.getPhotopath() %>"  width="60%" height="200">	
								</center>

								</td>		
							</tr>
							<tr >
								<td >
									商品介绍:
								</td>	
								<td>
									<%=ab.getDetail() %>
								</td>	
							</tr>
							
							<tr>
								<td >
									开拍时间:
								</td>
								<td>
								<div><strong id=""><%=ab.getStarttime() %></strong></div>
								</td>
							</tr>	
								
							<tr >
							<td >
									结束时间:
							</td>
								<td>	
									<div><strong id=""><%=ab.getFinishtime() %></strong></div>	
								</td>	
							</tr>		
							
							<tr >
							<td >
									起拍价:
							</td>
								<td>	
									<div><strong id=""><%=ab.getStartprice() %></strong></div>	
								</td>	
							</tr>	
							
							<tr >
							<td >
									当前价钱:
							</td>
								<td>	
									<div><strong id=""><%=ab.getCurrentprice() %></strong></div>	
								</td>	
							</tr>	
							<tr >
							<td >
									竞价次数:
							</td>
								<td>	
									<div><strong id=""><%=ab.getBidtimes() %></strong></div>	
								</td>	
							</tr>	
							<tr>
								<td width="35%">
									<a href="DeleteAuctionServlet?flag=detail&auctionId=<%=ab.getAuctionId() %>" <button>删除</button>></a>
									  
								</td>
							</tr>
					</tbody>																					
			

					</table>
				   </form>	
				</div>
			</div>
		</div>

	
  </body>
</html>
