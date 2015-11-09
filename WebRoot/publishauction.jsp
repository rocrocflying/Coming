<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>拍卖商品发布</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<<link rel="stylesheet" type="text/css" href="js/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="js/bootstrap/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>
	  <script type="text/javascript" src="js/atuionpublishvalidate.js"></script>
	<script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
	<script type="text/javascript" src="js/payfor.js"></script>

  </head>
  
  <body style="background:#E0E0E0">
  <jsp:include page="head.jsp"></jsp:include>
  <br>  <br>  <br>
  <div class="container">
	<div class="row clearfix">
	 <div class="col-md-12 column">
	
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">
						拍卖商品发布
					</h3>
				</div>
				<div class="panel-body">
					 <form class="form-inline" action="PublishAuctionServlet?flag=published2" method="post" onsubmit="return validate_form(this);" enctype="multipart/form-data" >      
						 &nbsp;商品照片： <input type="file" name="auctionphoto" class="form-control"><br>
						 &nbsp;商品名称：<input type="text" name="auctionname" class="form-control"><br>
						 &nbsp;拍卖底价：<input type="text" class="form-control" name="startprice" id="price1" placeholder="拍卖底价(必填)" onKeyUp="setAmount.modify('#price1')"><br>
						 &nbsp;期望价格：<input type="text" class="form-control" name="expectprice" id="price2" placeholder="期望价格(必填)" onKeyUp="setAmount.modify('#price2')"><br>
						 &nbsp;商品类别：<select name="auctionsort" class="form-control" ><br>
						          <option value="交通">交通</option>
						          <option value="生活">生活</option>
						          <option value="学习">学习</option>
						          <option value="运动">运动</option>
						          <option value="通讯">通讯</option>
						           </select><br>
						 &nbsp;商品介绍：<textarea class="form-control" rows="3" name="auctionintro" placeholder="（商品简单介绍介绍）"></textarea><br>
						<input type="submit" class="btn btn-default btn-block  btn-success" value="发布">   
						<input type="reset" class="btn btn-default btn-block btn-warning">
					 </form> 
				</div>
			</div>
		</div>
	</div>
</div>
  </body>
</html>
