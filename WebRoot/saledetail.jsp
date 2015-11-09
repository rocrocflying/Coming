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
    
    <title>商品详情</title>
    
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
								<img alt="" src="img/img_goods/<%=sgb.getImgpath() %>"  width="100%" height="200">	
								</td>		
							</tr>
							<tr >
								<td>
									商品介绍：
								</td>	
								<td>
									<%=sgb.getGoodsdetail() %>
								</td>	
							</tr>
							<tr >
								<td >
									价格
								</td>
								<td>
								<div><strong id="price_item_1">￥<%=sgb.getPrice() %></strong></div>
								</td>
														</tr>		
							<tr >
							<td >
									数量：
							</td>
								<td>	<div class="f_l add_chose">
											<a onClick="setAmount.reduce('#qty_item_1')" href="javascript:void(0)">
											<font size="6">-</font></a>
											<input type="text" name="qty_item_1" value="1" id="qty_item_1" onKeyUp="setAmount.modify('#qty_item_1')" size="3" readonly="readonly"/>
											<a onClick="setAmount.add('#qty_item_1')" href="javascript:void(0)">
											<font size="6">+</font></a>&nbsp&nbsp<span ><font color="red">库存量</font><input type="text" id="storage" value="<%=sgb.getPraiseNum() %>" size="3" readonly="readonly"></span>
										</div>	
								</td>	
							</tr>		
							<tr >	
								<td>
								总价：
								</td>	
								<td>	
										<div class="f_l buy">
											<span  id="total_item_1">￥89.00</span>
											<input type="hidden" name="total_price" id="total_price" value="" />
										</div>
								</td>
							</tr>
							<input type="hidden" name="salerId" value="<%=sgb.getUserId()%>"></input>
							<input type="hidden" name="goodsId" value="<%=sgb.getGoodsid()%>"></input>
							<%String tokenValue=new Date().getTime()+"";%>
							<input type="hidden" name="token" value="<%=tokenValue%>">
							<%session.setAttribute("token", tokenValue); %>
							<tr>
								<td width="35%">
									<input type="submit" class="btn btn-default btn-block btn-warning" value="立即购买" >
									  
								</td>
								<td>
									<input type="button" class="btn btn-default btn-block btn-warning" value="取消 " onclick="location.href='javascript:history.go(-1);'">
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
