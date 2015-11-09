<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'auctionpublishsuccess.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="js/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="js/bootstrap/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>

  </head>
  
  <body>
    <div class="panel panel-info">
  	<div class="panel-heading">
  	<center><a href="#"><span class="glyphicon glyphicon-heart"></span></a>
  	恭喜您，商品发布成功！<a href="#"><span class="glyphicon glyphicon-heart"></span></a></center>
  	</div>
   	<div class="panel-body">
     <img class="media-object" src="img/auctionsuccess2.jpg" style="width:100%">
     <center> <a href="publishauction.jsp" class="btn btn-success btn-lg " style="width:100%;height:70px;" ><font size="30px">继续发布</font></a>			
  	 </center><br>
    <center> <a href="auction.jsp" class="btn btn-warning btn-lg " style="width:100%;height:70px;" ><font size="30px">返回首页</font></a>			
  	</center>
  	
   </div>  
   </div>
  </body>
</html>
