<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发布跳蚤商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<<link rel="stylesheet" type="text/css" href="js/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="js/bootstrap/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/validate.js"></script>
	<script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
	<script type="text/javascript" src="js/payfor.js"></script>

  </head>
  
  <body style="background:#E0E0E0">
  <jsp:include page="head.jsp"></jsp:include>
  <br>  <br>  <br>
  <div class="container">
	<div class="row clearfix">
	 <div class="col-md-12 column">
	
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						商品发布
					</h3>
				</div>
				<div class="panel-body">
					 <form class="form-inline" action="PublishGoodsClServlet?flag=published" method="post" onsubmit="return validate_form(this);" enctype="multipart/form-data" >      
						 &nbsp商品照片： <input type="file" name="photo" id="photo" class="form-control"><br>
						 &nbsp商品名称：<input type="text" name="goodsname" id="goodsname" class="form-control"><br>
						 &nbsp商品价格：<input type="text" class="form-control" name="price" id="price" placeholder="出售价格(必填)" onKeyUp="setAmount.modify('#price')"><br>
						 &nbsp商品类别：<select name="goodssort" class="form-control" ><br>
						          <option value="交通">交通</option>
						          <option value="学习">学习</option>
						          <option value="运动">运动</option>
						          <option value="其它">其它</option>
						           </select><br>
						 &nbsp商品数量：<input type="text" name="num" class="form-control" id="num" onKeyUp="setAmount.modify('#num')"><br>
						 &nbsp商品介绍：<textarea class="form-control" rows="3" name="goodsintro" id="goodsintro" placeholder="（商品简单介绍介绍主要说明有商品几成新）"></textarea><br>
						
						<input type="submit" class="btn btn-default btn-block  btn-success" value="提交">   
						<input type="reset" class="btn btn-default btn-block btn-warning">
					 </form> 
				</div>
			</div>
		</div>
	</div>
</div>
  </body>
</html>
