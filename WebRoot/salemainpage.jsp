<%@ page language="java" import="java.util.* ,cn.edu.ynnu.laibar.taobar.model.SaleGoodsBean,cn.edu.ynnu.laibar.taobar.service.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SaleGoodsCl agc=new SaleGoodsCl();
ArrayList al=new ArrayList();
 al=agc.getSaleMainInfo();
 if(al.size()==0){
 SaleGoodsBean sgc=new SaleGoodsBean();
 sgc.setImgpath("noneimg.jpg");
 sgc.setGoodsid(0);
 sgc.setPrice(0.0f);
 al.add(sgc);
 System.out.println("al="+al);
 }
Iterator it=al.iterator();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>跳蚤主页</title>
    
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
  
  <body style="background:#E0E0E0"> 
  <jsp:include page="head.jsp"></jsp:include>
  <br>  <br>  <br>
   <div class="container">
	<div class="row clearfix">
	 <div class="col-md-12 column">
	<%while(it.hasNext()){
  	SaleGoodsBean sgc=(SaleGoodsBean)it.next();
  	 %>
			<div class="panel panel-default">
				<div class="panel-heading" style="height: 43">
					<h3 class="panel-title">
						<img alt="" src="img/logo/sale.png" width="35" height="32" >
					</h3>
				</div>
				<div class="panel-body">
			<center>
					<a href="SaleGoodsCl?flag=detail&goodsid=<%=sgc.getGoodsid()%>"><img alt="" src="img/img_goods/<%=sgc.getImgpath()%>"  width="100%"></a>
			</center>
				</div>
				<div class="panel-footer" style="height: 35">
				<img alt="" src="img/logo/price.png" width="20" height="20" align="right"> <p align="right"><%=sgc.getPrice() %></p>
				</div>
			</div>
		<% 
			}
		%>
		</div>
	</div>
</div>
  </body>
</html>
