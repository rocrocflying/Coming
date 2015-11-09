<%@page import="cn.edu.ynnu.laibar.taobar.model.UserOrderBean"%>
<%@ page language="java" import="java.util.* ,cn.edu.ynnu.laibar.taobar.model.SaleGoodsBean" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 ArrayList al=(ArrayList)request.getAttribute("goodsorderdetail");

 UserOrderBean sgb=(UserOrderBean)al.get(0);

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
									
								</td>		
							</tr>
							
							<tr >
								<td >
									下单时间介绍：
								</td>	
								<td>
									<%=sgb.getOrder_date() %>
								</td>	
							</tr>
							
							<tr>
							<td >
									数量：
							</td>
								<td>	
									<%=sgb.getGoodsnum() %>
								</td>	
							</tr>	
							
								
							<tr>	
								<td>
								总价：
								</td>	
								<td>	
										<%=sgb.getTotalprice() %>
								</td>
							</tr>
							
							<tr>
								
								<td>
									<a href="DeleteTiaozaoOrderServlet?flag=detail&purchaseOrderId=<%=sgb.getPurchaseOrderId() %>" <button>删除订单</button>></a>
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
