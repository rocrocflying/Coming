<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
    <script type="text/javascript" src="js/payfor.js"></script>
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
						<a href="main.jsp">首页</a>
						</li>
						 <li class="dropdown" class="active">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="#">跳蚤市场<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
									<li>
											<a href="main.jsp">跳蚤市场首页</a>
										</li>	
										<li>
											<a href="fenlei.jsp">查看详细分类</a>
										</li>	
									</ul>
								</li>
        				<li class="active"><a href="auction.jsp">限时拍卖</a></li>
         			    <li><a href="#">商品代购</a></li>
         			    <li><a href="userAccount.jsp">个人中心</a></li>
					</ul>
				</div>	
			</nav>
		</div>
	</div>
</div>
<br>
<br>
<br>
  <div class="container">
	<div class="row clearfix ">
		<div class="col-md-12 column">
			<div class="carousel slide" id="carousel-25182">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-25182">
					</li>
					<li data-slide-to="1" data-target="#carousel-25182">
					</li>
					<li data-slide-to="2" data-target="#carousel-25182">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="img/pai1.png" />
						<div class="carousel-caption">
							<h4>
								<!-- 添加图注 -->
							</h4>
						</div>
					</div>
					<div class="item">
						<img alt="" src="img/pai2.png" />
						<div class="carousel-caption">
							<h4>
								<!-- 添加图注 -->
							</h4>
						</div>
					</div>
					<div class="item">
						<img alt="" src="img/pai3.png" />
						<div class="carousel-caption">
							<h4>
								<!-- 添加图注 -->
							</h4>
							
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-25182" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-25182" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<table class="table table-bordered">
						<tbody>
							<tr class="success">
								<td width="35%">
									商品介绍：
								</td>	
								<td>
									保时捷-凯宴（已行驶路程：2万公里，未发生过车祸）
								</td>	
							</tr>
							<tr class="error">
								<td width="35%">
									开拍时间：4月14日14：00
								</td>
								<td>
									结束时间：4月14日22:00
								</td>	
							</tr>
							<tr class="warning">
								<td width="35%">
									数量：
								</td>
								<td>
									1
								</td>	
							</tr>
							<tr class="danger">
								<td width="35%">
									拍卖底价：79.00万元
								</td>
								<td>
									当前价钱：93.30万元
								</td>	
							</tr>
							<tr class="info">
								<td width="35%">
									<button type="button" class="btn btn-default btn-block btn-warning" style="margin-top:5px">围观</button>
								</td>
								<td>
									<button type="button" class="btn btn-default btn-block btn-warning" style="margin-top:5px">+加价</button>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
  </body>
</html>
