<%@ page language="java" import="java.util.* ,cn.edu.ynnu.laibar.taobar.model.UserBean,cn.edu.ynnu.laibar.taobar.model.UserOrderBean" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
UserOrderBean uob=(UserOrderBean)request.getAttribute("UserOrderBean");
UserBean ub=(UserBean)request.getAttribute("UserBean");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购买成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" type="text/css" href="js/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="js/bootstrap/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
	<script type="text/javascript" src="js/autionpayfor.js"></script>
	<script type="text/javascript">
	function phone(date){
		window.location.href = 'tel://' + date;
}
	</script>
  </head>
  
  <body style="background:#E0E0E0">
<jsp:include page="head.jsp"></jsp:include>
<br><br><br>
  <div class="container" >
			<div class="row clearfix">
				<div class="col-md-12 column">
				 <form action="BuyGoodsCLServlet" method="post" >
				 <center><font color="#356635"><h3>恭喜您购买成功！请自行联系卖家</h3></font></center>
					<table class="table table-bordered" style="background:#fff">
						<tbody>
						
							<tr>
								<td width="90">
									数量
								</td>
								<td>
								<div><strong><%=uob.getGoodsnum() %></strong></div>
								</td>
							</tr>	
							<tr>
								<td width="90">
									总价
								</td>
								<td>
								<div><strong id="price_item_1">￥<%=uob.getTotalprice() %></strong></div>
								</td>
							</tr>	
							<tr>
								<td>
									下单时间
								</td>
								<td>
								<div><strong><%=uob.getOrder_date() %></strong></div>
								</td>
							</tr>	
							<tr>
								<td>
									卖家地址
								</td>
								<td>
								<div><strong><%=ub.getAddress() %></strong></div>
								</td>
							</tr>	
							<tr>
								<td colspan="2">
									<a href="javascript:phone('<%=ub.getPhone() %>')" class="btn btn-default btn-warning btn-block">点击联系卖家</a>
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

