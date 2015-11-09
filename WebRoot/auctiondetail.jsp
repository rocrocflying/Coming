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
    <script type="text/javascript" src="js/autionpayfor.js"></script>
  </head>
  
  <body>
   <body style="background:#E6E6E6"><jsp:include page="head.jsp"></jsp:include>
  <br>  <br>  <br>
   
		<div class="panel ">
   			<div class="panel-body">
     			 <img class="media-object" src="img/img_auction/<%=ab.getPhotopath() %>"  style="width:100%">
   			</div>
   			<div class="panel-footer" style="background-color:#70cc33">
 <form action="AuctionServletCL?flag=detail_2&auctionId=<%=ab.getAuctionId()%>" method="post">
  <center>	
  <strong>	<font color="red" size="40px" ><div id="showTimes"></div></font></strong></center>
<%
  long current_time=System.currentTimeMillis();
  long end_time=ab.getFinishtime().getTime(); 
  long time=end_time-current_time;
 %>
<script>
var second = <%= time / 1000%>; // 剩余秒数
// 写一个方法，将秒数专为天数
var toDays = function(){
 var s = second % 60; // 秒
 var mi = (second - s) / 60 % 60; // 分钟
 var h =  ((second - s) / 60 - mi ) / 60 % 24; // 小时
 var d =  (((second - s) / 60 - mi ) / 60 - h ) / 24 // 天
return "剩余时间：" + d + "天" + h + "小时" + mi + "分钟" + s + "秒";
}
//然后写一个定时器
window.setInterval(function(){
 second --;
 document.getElementById("showTimes").innerHTML = toDays ();
}, 1000);
</script>  	 	
</form>
   		
   		</div>
		</div>
		<form action="AuctionServletCL?flag=detail_2&auctionId=<%=ab.getAuctionId()%>" method="post">
			<table class="table table-striped">																							
			<tr><td><font color="blue" size="40px">商品介绍</font></td><td><font color="#000000" size="40px"><%=ab.getDetail()%></font></td> <td></td></tr>
			<tr><td><font color="blue"size="40px">开拍时间</font></td><td><font color="#000000" size="40px"><%=ab.getStarttime() %></font></td><td></td></tr>
			<tr><td><font color="blue" size="40px">结束时间</font></td><td><font color="#000000" size="40px"><%=ab.getFinishtime() %></font></td><td></td></tr>
			<tr><td><font color="blue" size="40px">起拍价</font></td><td><font color="#000000" size="40px"><%=ab.getStartprice()+"元"%></font></td><td></td></tr>
			<tr><td><font color="blue" size="40px">当前价钱</font></td><td><font color="#000000" size="40px"><%=ab.getCurrentprice()+"元"%></font></td><td></td></tr>
			<tr><td><font color="blue" size="40px">竞价幅度</font></td><td><font color="#000000" size="40px"><%=ab.getIncreaseprice()+"元"%></font></td><td></td></tr>
			<tr><td><font color="blue" size="40px">竞价次数</font></td><td><strong><font color="#000000" size="40px"><%=ab.getBidtimes() +"次"%></font></strong></td><td></td></tr>   	
		</table>
		
		<div><font  size="40px">每次加价最低金额：<strong id="price_item_1">￥1.0</strong></font></div>  
		 	<div class="f_l add_chose">
										<a  onClick="setAmount.reduce('#qty_item_1')" href="javascript:void(0)" style="margin-left: 60px">
										<strong><font size="100px">&nbsp;-&nbsp;</font></strong> </a>										
										<font size="65px"><input type="text" name="qty_item_1" value="1" id="qty_item_1" onKeyUp="setAmount.modify('#qty_item_1')" style="width:180px;height:70px;margin-left: 20px"/>
										</font>
										<a  onClick="setAmount.add('#qty_item_1')" href="javascript:void(0)" style="margin-left: 20px">
										<font size="100px">+</font></a>										
			</div>										
			<div class="f_l buy">
							<font color="red" size="40px">您要在原来的价钱基础上加价：<span  id="total_item_1">￥89.00</span>
								<input type="hidden" name="total_price" id="total_price" value="" /></font>
			</div>	
				
				<input type="submit" class="btn btn-lg btn-danger" style="margin-left:50px;width:150px;height:70px;size:70px;font-size:40px" value="加价"></input>
				<br></br>
			
				<a href="auction.jsp" class="btn btn-success btn-lg " style="margin-left:50px;width:150px;height:70px;" ><font size="40px">返&nbsp;回</font></a>			
	
	</form>
	
  </body>
</html>
