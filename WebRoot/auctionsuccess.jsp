<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'auctionsuccess.jsp' starting page</title>
    
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
  <div class="panel panel-default">
  <div class="panel-heading">
  	<center><a href="#"><span class="glyphicon glyphicon-heart"></span></a>
  	加价成功！<a href="#"><span class="glyphicon glyphicon-heart"></span></a></center>
  </div>
  	<div class="panel-body">
   
    <img class="media-object" src="img/auctionsuccess1.gif" style="width:100%">
  
  <form action="AuctionBackDetailServlet">
    <center>
   	<a href="auction.jsp"> <input type="submit" class="btn btn-lg btn-success" style="margin-left:50px;width:150px;height:70px;size:70px;font-size:40px" value="返回"></input>  	
  	</a>
  	</center>
  </form>
  	
   </div>  
   </div>
  </body>
</html>
