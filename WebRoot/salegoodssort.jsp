<%@ page language="java" import="java.util.*,cn.edu.ynnu.laibar.taobar.servlet.*,cn.edu.ynnu.laibar.taobar.model.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  ArrayList al_1=(ArrayList)request.getAttribute("goodssport");
   ArrayList al_2=(ArrayList)request.getAttribute("goodsstudy");
    ArrayList al_3=(ArrayList)request.getAttribute("goodsTraffic");
     ArrayList al_4=(ArrayList)request.getAttribute("others");
    Iterator it1=al_1.iterator();
    Iterator it2=al_2.iterator();
    Iterator it3=al_3.iterator();
    Iterator it4=al_4.iterator();
%>
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>跳搔分类</title>
    
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
  <br><br><br>
     <div class="panel-group" id="accordion">
     
     <div class="panel panel-default">
      <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" 
          href="#collapseOne">
         <center>运动<img src="img/logo/sport.png" width="25" height="25"></img></center>
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse ">
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
					</h3>
				</div>
				<div class="panel-body">
			<center>
					<a href="SaleGoodsCl?flag=detail&goodsid=<%=saleGoodsBean1.getGoodsid()%>">
					<img alt="" src="img/img_goods/<%=saleGoodsBean1.getImgpath()%>"  width="100%"></a>
			</center>
				</div>
				<div class="panel-footer" style="height: 35">
					<img alt="" src="img/logo/price.png" width="20" height="20" align="right"> <p align="right"><%=saleGoodsBean1.getPrice()%> </p>
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
          <center>学习<img src="img/logo/study.png" width="25" height="25"></img></center>
      </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse ">
     <div class="container">
	<div class="row clearfix">
	 <div class="col-md-12 column">
   <%      
    while(it2.hasNext()){
     SaleGoodsBean saleGoodsBean2 =(SaleGoodsBean)it2.next();
 %>
    <div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<img src="img/logo/sale.png" width="35" height="32"></img>
					</h3>
				</div>
				<div class="panel-body"> 
            <center>
					<a  href="SaleGoodsCl?flag=detail&goodsid=<%=saleGoodsBean2.getGoodsid()%>">
					<img alt="" src="img/img_goods/<%=saleGoodsBean2.getImgpath()%>" width="100%"></a>
			</center>
				</div>
				<div class="panel-footer" style="height: 35">
			
					 <img alt="" src="img/logo/price.png" width="20" height="20" align="right"> <p align="right"><%=saleGoodsBean2.getPrice()%></p>
				   
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
          href="#collapseThree">
        <center>交通<img src="img/logo/traffic.png" width="25" height="25"></img></center>
     </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse ">
     <div class="container">
	<div class="row clearfix">
	 <div class="col-md-12 column">
   <%  
    while(it3.hasNext()){
     	SaleGoodsBean 	saleGoodsBean3 =(SaleGoodsBean)it3.next();
 %> 
    <div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<img src="img/logo/sale.png" width="35" height="32"></img>
					</h3>
				</div>
				<div class="panel-body">   
            <center>
					<a  href="SaleGoodsCl?flag=detail&goodsid=<%=saleGoodsBean3.getGoodsid()%>" >
					<img alt="" src="img/img_goods/<%=saleGoodsBean3.getImgpath()%>"  width="100%"></a>
			</center>
				</div>
				<div class="panel-footer" style="height: 35">	
				 <img alt="" src="img/logo/price.png" width="20" height="20" align="right"> <p align="right"><%=saleGoodsBean3.getPrice()%></p>
				</div>
			</div><br>
      <%}%>
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
        <center>其它<img src="img/logo/more.png" width="25" height="25"></img></center>
     </a>
      </h4>
    </div>
    <div id="collapseFour" class="panel-collapse collapse ">
     <div class="container">
	<div class="row clearfix">
	 <div class="col-md-12 column">
   <%  
    while(it4.hasNext()){
     	SaleGoodsBean 	saleGoodsBean4 =(SaleGoodsBean)it4.next();
 %> 
    <div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<img src="img/logo/sale.png" width="35" height="32"></img>
					</h3>
				</div>
				<div class="panel-body">   
            <center>
					<a  href="SaleGoodsCl?flag=detail&goodsid=<%=saleGoodsBean4.getGoodsid()%>" >
					<img alt="" src="img/img_goods/<%=saleGoodsBean4.getImgpath()%>"  width="100%"></a>
			</center>
				</div>
				<div class="panel-footer" style="height: 35">	
				 <img alt="" src="img/logo/price.png" width="20" height="20" align="right"> <p align="right"><%=saleGoodsBean4.getPrice()%></p>
				</div>
			</div><br>
      <%}%>
</div>
	</div>
</div>
    </div>
  </div>
        
      </div>
    </div>
  </div>
        </div>
    </div>
  </div>
  		
  </div>
  </body>
</html>
