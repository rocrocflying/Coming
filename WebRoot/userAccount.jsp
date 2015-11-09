<%@ page language="java" import="java.util.*,cn.edu.ynnu.laibar.taobar.servlet.*,cn.edu.ynnu.laibar.taobar.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 ArrayList al_1=(ArrayList)request.getAttribute("goodsdetail");
   ArrayList al_2=(ArrayList)request.getAttribute("goodsorderdetail");
   ArrayList al_3=(ArrayList)request.getAttribute("userdetail");
   ArrayList al_4=(ArrayList)request.getAttribute("auctiondetail");

    Iterator it1=al_1.iterator();
    Iterator it2=al_2.iterator();
    Iterator it3=al_3.iterator();
    Iterator it4=al_4.iterator();

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的淘吧</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<script type="text/javascript" src="js/bootstrap/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>

  </head>
  
  <body>
  
     <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
					  
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						 <li class="dropdown" class="active">
									 <a data-toggle="dropdown" class="dropdown-toggle" href="#">淘吧<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
									<li>
											<a href="salemainpage.jsp">跳蚤市场</a>
										</li>	
										<li>
											<a href="auction.jsp">限时拍卖</a>
										</li>	
									</ul>
								</li>

         			    <li class="active"><a href="UserCenter">个人中心</a></li>  
         			    <li class="active"><a href="ZhuxiaoServlet?flag=zhuxiao">注销</a></li>  			             			   
							</ul>						
				</div>	
			</nav>
		</div>
	</div>
</div>
<br></br><br></br>
<div class="panel-group" id="accordion">


<div class="panel panel-default">
      <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" 
          href="#collapseOne">
         <center>我的个人信息</center>
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse ">
     <div class="container">
	<div class="row clearfix">
	 <div class="col-md-12 column">
	<%while(it3.hasNext()){
  	UserBean saleGoodsBean1 =(UserBean)it3.next();
  	 %>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title" style="height:30">

						注册时间：<%=saleGoodsBean1.getRegist_date() %>
					</h3>
				</div>
				<div class="panel-body">
			<center>
					<a href="UserServlet?flag=detail&userId=<%=saleGoodsBean1.getUserId()%>">
					<img alt="" src="img/user2/<%=saleGoodsBean1.getHead_pic() %>"  width="60%"></a>
			</center>
				</div>
				<div class="panel-footer" style="height: 35">
					
				</div>
			</div><br>
		<% 
			}
		%>
		</div>
	</div>
</div>
    </div>
  </div>
     
  
  
   <div class="panel panel-default">
      <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" 
          href="#collapseTwo">
         <center>我的跳蚤商品</center>
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse ">
     <div class="container">
	<div class="row clearfix">
	 <div class="col-md-12 column">
	<%while(it1.hasNext()){
  	SaleGoodsBean saleGoodsBean1 =(SaleGoodsBean)it1.next();
  	 %>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title" style="height:30">
						<img src="img/logo/sale.png" width="35" height="32"></img>
						发布时间：<%=saleGoodsBean1.getRelease_date() %>
					</h3>
				</div>
				<div class="panel-body">
			<center>
					<a href="UserTiaozaoGoodsServlet?flag=detail&goodsid=<%=saleGoodsBean1.getGoodsid()%>">
					<img alt="" src="img/img_goods/<%=saleGoodsBean1.getImgpath()%>"  width="60%"></a>
			</center>
				</div>
				<div class="panel-footer" style="height: 35">
					发布商品名称：<%=saleGoodsBean1.getCommodityName() %>
					发布商品数量：<%=saleGoodsBean1.getQuantity() %>
					发布商品单价：<%=saleGoodsBean1.getPrice() %>
					<img alt="" src="img/logo/price.png" width="20" height="20"> 
				</div>
			</div><br>
		<% 
			}
		%>
		</div>
	</div>
</div>
    </div>
  </div>
  
  
  
  <div class="panel panel-default">
      <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" 
          href="#collapseThree">
         <center>我的跳蚤订单</center>
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse ">
     <div class="container">
	<div class="row clearfix">
	 <div class="col-md-12 column">

<%while(it2.hasNext()){
  	UserOrderBean auctionBean =(UserOrderBean)it2.next();
  	 %>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title" style="height:30">
						<img src="img/logo/sale.png" width="35" height="32"></img>
						下单时间：<%=auctionBean.getOrder_date() %>
					</h3>
				</div>
				<div class="panel-body">
			<center>
					 <a href="UserTiaozaoOrderServlet?flag=detail_1&purchaseOrderId=<%=auctionBean.getPurchaseOrderId()%>" >
      				<img alt="" src="img/img_goods/dingdan.jpg"  width="60%"></a>
			</center>
				</div>
				<div class="panel-footer" style="height: 35">
					订单号：<%=auctionBean.getPurchaseOrderId() %>
					总价：<%=auctionBean.getTotalprice() %>
					<img alt="" src="img/logo/price.png" width="20" height="20" > 
				</div>
			</div><br>
	   <%} %>
		</div>
	</div>
</div>
    </div>
  </div>
  
  
  
  <div class="panel panel-default">
      <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" 
          href="#collapseFour">
         <center>我的拍卖商品</center>
        </a>
      </h4>
    </div>
    <div id="collapseFour" class="panel-collapse collapse ">
     <div class="container">
	<div class="row clearfix">
	 <div class="col-md-12 column">

<%while(it4.hasNext()){
  	AuctionBean auctionBean =(AuctionBean)it4.next();
  	 %>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title" style="height:30">
						<img src="img/logo/sale.png" width="35" height="32"></img>
						拍卖结束时间：<%=auctionBean.getFinishtime() %>
					</h3>
				</div>
				<div class="panel-body">
			<center>
					 <a href="UserAuctionServlet?flag=detail_1&auctionId=<%=auctionBean.getAuctionId()%>" >
      				<img alt="" src="img/img_auction/<%=auctionBean.getPhotopath() %>"  width="60%"></a>
			</center>
				</div>
				<div class="panel-footer" style="height: 35">
					拍卖商品名称：<%=auctionBean.getName() %>
					拍卖成功价：<%=auctionBean.getCurrentprice() %>
					<img alt="" src="img/logo/price.png" width="20" height="20" > 

				</div>
			</div><br>
	   <%} %>
		</div>
	</div>
</div>
    </div>
  </div>

   
  
  
  
</div>
  </body>
</html>
