<%@ page language="java" import="java.util.* ,cn.edu.ynnu.laibar.taobar.model.SaleGoodsBean" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 ArrayList al=(ArrayList)request.getAttribute("goodsdetail");
 SaleGoodsBean sgb=(SaleGoodsBean)al.get(0);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的跳蚤订单详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" type="text/css" href="js/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="js/bootstrap/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/validate.js"></script>
    <script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
	<script type="text/javascript" src="js/payfor.js"></script>
  </head>
  
  <body style="background:#E0E0E0">
<jsp:include page="head.jsp"></jsp:include>
<br><br><br>
   <div class="container" >
			<div class="row clearfix">
				<div class="col-md-12 column">
				 <form action="BuyGoodsCLServlet" method="post" >
					<table class="table table-bordered" style="background:#fff">
						<tbody>
						<tr>
								<td colspan="2">
								<center>
								<img alt="" src="img/img_goods/<%=sgb.getImgpath() %>"  width="60%" height="200">
								</center>	
								</td>		
							</tr>
							
							<tr >
							<td >
									商品名称：
							</td>
								<td>	
									<div><strong id="price_item_1"><%=sgb.getCommodityName() %></strong></div>	
								</td>	
							</tr>
							
							<tr >
								<td >
									商品介绍：
								</td>	
								<td>
									<%=sgb.getGoodsdetail() %>
								</td>	
							</tr>
							<tr>
								<td >
									价格
								</td>
								<td>
								<div><strong id="price_item_1"><%=sgb.getPrice() %></strong></div>
								</td>
														</tr>		
							<tr >
							<td >
									数量：
							</td>
								<td>	
									<div><strong id="price_item_1"><%=sgb.getPraiseNum() %></strong></div>	
								</td>	
							</tr>	
							
							<tr >
							<td >
									发布时间：
							</td>
								<td>	
									<div><strong id="price_item_1"><%=sgb.getRelease_date() %></strong></div>	
								</td>	
							</tr>
							
							<tr >
							<td >
									类别：
							</td>
								<td>	
									<div><strong id="price_item_1"><%=sgb.getGoodssort() %></strong></div>	
								</td>	
							</tr>
							
						
							
							
							
							
							<tr>
								<td width="35%">
									<a href="editGoodsRelease.jsp" <button>编辑</button>></a>
									  
								</td>
								<td>
									<a href="DeleteTiaozaoReleaseServlet?flag=detail&goodsid=<%=sgb.getGoodsid()%>" <button>删除</button>></a>
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
