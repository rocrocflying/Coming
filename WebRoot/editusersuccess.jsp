<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户信息编辑成功页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" type="text/css" href="js/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="js/bootstrap/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>

  </head>
  
  <body>
    <div class="container">
	<div class="row clearfix">
	 <div class="col-md-12 column">
	
			<div class="panel panel-default">
				<div class="panel-heading" style="height: 43">
					<h3 class="panel-title">
						<img alt="" src="img/logo/sale.png" width="35" height="32" ><span>恭喜你编辑成功！</span>
					</h3>
				</div>
				<div class="panel-body">
			<a href="EditUserServlet?flag=continueedit" class="btn btn-default btn-block  btn-success">继续编辑</a>
			<a href="userCenter.jsp" class="btn btn-default btn-block   btn-warning">返回个人中心</a>
				</div>
				<div class="panel-footer" style="height: 35">
				</div>
			</div>
		
		</div>
	</div>
</div>
  </body>
</html>
