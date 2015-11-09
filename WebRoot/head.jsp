<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>头页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
       <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">下拉列表</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
						<a href="salemainpage.jsp">首页</a>
						</li>
						 <li class="dropdown" class="active">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="#">跳蚤市场<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
									<li>
											<a href="salemainpage.jsp">跳蚤市场首页</a>
										</li>	
										<li>
											<a href="SaleGoodsCl?flag=sort">查看详细分类</a>
										</li>
										<li>
											<a href="PublishGoodsClServlet?flag=publishing">我要发布</a>
										</li>
									</ul>
								</li>
						<li class="dropdown" class="active">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="#">限时拍卖<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
									<li>
											<a href="auction.jsp">拍卖首页</a>
										</li>	
										
										<li>
											<a href="PublishAuctionServlet?flag=publishing2">我要发布</a>
										</li>
									</ul>
								</li>
         			    <li><a href="UserAccountCLServlet?flag=isLogin">我的淘吧</a></li>
         			    <li><a href="UserCenter">个人中心</a></li>
         			    <li><a href="ZhuxiaoServlet?flag=zhuxiao">注销</a></li>
					</ul>
				</div>	
			</nav>
		</div>
	</div>
</div>
  </body>
</html>
