<%@ page language="java" import="java.util.*,cn.edu.ynnu.laibar.taobar.*,cn.edu.ynnu.laibar.taobar.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
AuctionBeanBO ab=new AuctionBeanBO();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品拍卖</title>
    
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
  <body style="background:#E6E6E6">
  <jsp:include page="head.jsp"></jsp:include>
  <br>  <br>  <br>
   

<div class="panel-group" id="accordion" >

    <div class="panel panel-default" style="background:#E6E6E6" >
    <div class="panel-heading" style="background-color:#5091F3" >
      <h4 class="panel-title" style="color:#ffffff">
        <a data-toggle="collapse" data-parent="#accordion" 
          href="#collapseOne">
       	<center>交通  &nbsp;<img  src="img/logo/traffic.png" width="25" height="25">   </center>
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in">
      <div class="panel-body">   
       
      <%
      ArrayList al1=ab.gettransportinfo();
      Iterator it1=al1.iterator();
      while(it1.hasNext()){
      AuctionBean auctionBean =(AuctionBean)it1.next();
 	  %>  
      
      <div class="panel panel-success">
       <div class="panel-heading">
    	<span class="label label-danger">H O T</span>
      </div>
      
   <div class="panel-body">
      <a class="pull-left" href="AuctionServletCL?flag=detail_1&auctionId=<%=auctionBean.getAuctionId()%>" >
      <img class="media-object" src="img/img_auction/<%=auctionBean.getPhotopath()%>" style="width:100%">
      </a>
   </div>
   <div class="panel-footer">
   <table>
       <tr><td><span class="glyphicon glyphicon-time">起拍时间</span></td>
       <td>&nbsp;&nbsp;<%=auctionBean.getStarttime()%></td></tr>
      
       <tr><td><span class="glyphicon glyphicon-time">结束时间</span></td>
       <td>&nbsp;&nbsp;<%=auctionBean.getFinishtime()%></td></tr>
      <tr style="color: red">
      <td><span class="glyphicon glyphicon-heart">当前价钱</span></td>
      <td>&nbsp;&nbsp;<%=auctionBean.getCurrentprice()+"元"%></td>
      </tr>
       <tr><td>
          <span class="glyphicon glyphicon-star-empty"></span> 竞价次数</td>
       		<td>&nbsp;&nbsp;
          <span class="glyphicon"><font color="blue" ><%=auctionBean.getBidtimes()+"次"%></font></span> </a></td>
       </tr>
  </table>
   </div>
</div>
    <br></br>  	
      <%} %>
      
      
     <%
      ArrayList al11=ab.gettransportinfo2();
      Iterator it11=al11.iterator();
      while(it11.hasNext()){
      AuctionBean auctionBean =(AuctionBean)it11.next();
 	  %>  
      
      <div class="panel panel-success">
       <div class="panel-heading">
    	<span class="label label-danger">已结束</span>
      </div>
      
   <div class="panel-body">
      
      <img class="media-object" src="img/img_auction/<%=auctionBean.getPhotopath()%>" style="width:100%">
      
   </div>
   <div class="panel-footer">
   <table>    
      <tr style="color: red">
      <td><span class="glyphicon glyphicon-heart">成交金额</span></td>
      <td>&nbsp;&nbsp;<%=auctionBean.getCurrentprice()+"元"%></td>
      </tr>
       <tr><td>
          <span class="glyphicon glyphicon-star-empty"></span> 竞价次数</td>
       		<td>&nbsp;&nbsp;
          <span class="glyphicon"><font color="blue" ><%=auctionBean.getBidtimes()+"次"%></font></span> </td>
       </tr>
       <tr>
       <td> <span class="glyphicon glyphicon-user"></span>拍卖胜出者ID</td>
       <td>&nbsp;&nbsp;     
          <span class="glyphicon"><font color="blue" ><%=auctionBean.getUSRID()%></font></span> </td>       
       </tr>
  </table>
   </div>
</div>
    <br></br>  	
      <%} %> 
      
      
		</div>
		
   		</div>	
	</div>	
			
     
  <div class="panel panel-default" style="background:#E6E6E6" >
    <div class="panel-heading" style="background-color:#5091F3" >
      <h4 class="panel-title" style="color:#ffffff">
        <a data-toggle="collapse" data-parent="#accordion" 
          href="#collapseTwo">
       			<center>生活 &nbsp;<img  src="img/logo/buy1.png" width="25" height="25">   </center>
       		
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse ">
      <div class="panel-body">    
      <%
      ArrayList al2=ab.getlifeinfo();
      Iterator it2=al2.iterator();
      while(it2.hasNext()){
     AuctionBean auctionBean =(AuctionBean)it2.next();
 %>  
      
      <div class="panel panel-success">
       <div class="panel-heading">
    	<span class="label label-danger">H O T</span>
      </div>
      
   <div class="panel-body">
      <a class="pull-left" href="AuctionServletCL?flag=detail_1&auctionId=<%=auctionBean.getAuctionId()%>" >
      <img class="media-object" src="img/img_auction/<%=auctionBean.getPhotopath()%>" style="width:100%">
      </a>
   </div>
   <div class="panel-footer">
   <table>
       <tr><td><span class="glyphicon glyphicon-time">起拍时间</span></td>
       <td>&nbsp;&nbsp;<%=auctionBean.getStarttime()%></td></tr>
      
       <tr><td><span class="glyphicon glyphicon-time">结束时间</span></td>
       <td>&nbsp;&nbsp;<%=auctionBean.getFinishtime()%></td></tr>
      <tr style="color: red"><td><span class="glyphicon glyphicon-heart">当前价钱</span></td>
      <td>&nbsp;&nbsp;<%=auctionBean.getCurrentprice()+"元"%></td></tr>
       <tr><td>
          <span class="glyphicon glyphicon-star-empty"></span> 竞价次数</td>
       		<td>&nbsp;&nbsp;
          <span class="glyphicon "><font color="blue" ><%=auctionBean.getBidtimes()+"次"%></font></span> </a></td>
       </tr>
  </table>
   </div>
</div>
    <br></br>  	
      <%} %>
      
      
     <%
      ArrayList al22=ab.getlifeinfo2();
      Iterator it22=al22.iterator();
      while(it22.hasNext()){
      AuctionBean auctionBean =(AuctionBean)it22.next();
 	  %>  
      
      <div class="panel panel-success">
       <div class="panel-heading">
    	<span class="label label-danger">已结束</span>
      </div>
      
   <div class="panel-body">
     
      <img class="media-object" src="img/img_auction/<%=auctionBean.getPhotopath()%>" style="width:100%">
  
   </div>
   <div class="panel-footer">
   <table>    
      <tr style="color: red">
      <td><span class="glyphicon glyphicon-heart">成交金额</span></td>
      <td>&nbsp;&nbsp;<%=auctionBean.getCurrentprice()+"元"%></td>
      </tr>
       <tr><td>
          <span class="glyphicon glyphicon-star-empty"></span> 竞价次数</td>
       		<td>&nbsp;&nbsp;
          <span class="glyphicon"><font color="blue" ><%=auctionBean.getBidtimes()+"次"%></font></span> </td>
       </tr>
       <tr>
       <td> <span class="glyphicon glyphicon-user"></span>拍卖胜出者ID</td>
       <td>&nbsp;&nbsp;
          <span class="glyphicon"><font color="blue" ><%=auctionBean.getUSRID()%></font></span> </td>       
       </tr>
  </table>
   </div>
</div>
    <br></br>  	
      <%} %>  
      
      
		</div>
   		</div>	
	</div>	
  

<div class="panel panel-default" style="background:#E6E6E6" >
    <div class="panel-heading" style="background-color:#5091F3" >
      <h4 class="panel-title" style="color:#ffffff">
        <a data-toggle="collapse" data-parent="#accordion" 
          href="#collapseThree">
       		<center>学习  &nbsp;<img  src="img/logo/study.png" width="25" height="25">   </center>
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse ">
      <div class="panel-body">    
      <%
      ArrayList al3=ab.getstudyinfo();
      Iterator it3=al3.iterator();
      while(it3.hasNext()){
     AuctionBean auctionBean =(AuctionBean)it3.next();
 %>  
      
      <div class="panel panel-success">
       <div class="panel-heading">
    	<span class="label label-danger">H O T</span>
      </div>
      
   <div class="panel-body">
      <a class="pull-left" href="AuctionServletCL?flag=detail_1&auctionId=<%=auctionBean.getAuctionId()%>" >
      <img class="media-object" src="img/img_auction/<%=auctionBean.getPhotopath()%>" style="width:100%">
      </a>
   </div>
   <div class="panel-footer">
   <table>
       <tr><td><span class="glyphicon glyphicon-time">起拍时间</span></td>
       <td>&nbsp;&nbsp;<%=auctionBean.getStarttime()%></td></tr>
      
       <tr><td><span class="glyphicon glyphicon-time">结束时间</span></td>
       <td>&nbsp;&nbsp;<%=auctionBean.getFinishtime()%></td></tr>
      <tr style="color: red"><td><span class="glyphicon glyphicon-heart">当前价钱</span></td>
      <td>&nbsp;&nbsp;<%=auctionBean.getCurrentprice()+"元"%></td></tr>
       <tr><td>
          <span class="glyphicon glyphicon-star-empty"></span> 竞价次数</td>
       		<td>&nbsp;&nbsp;
          <span class="glyphicon "><font color="blue" ><%=auctionBean.getBidtimes()+"次"%></font></span> </a></td>
       </tr>
  </table>
   </div>
</div>
    <br></br>  	
      <%} %>
      
  <%
      ArrayList al33=ab.getstudyinfo2();
      Iterator it33=al33.iterator();
      while(it33.hasNext()){
      AuctionBean auctionBean =(AuctionBean)it33.next();
 	  %>  
      
      <div class="panel panel-success">
       <div class="panel-heading">
    	<span class="label label-danger">已结束</span>
      </div>
      
   <div class="panel-body">
     
      <img class="media-object" src="img/img_auction/<%=auctionBean.getPhotopath()%>" style="width:100%">
     
   </div>
   <div class="panel-footer">
   <table>    
      <tr style="color: red">
      <td><span class="glyphicon glyphicon-heart">成交金额</span></td>
      <td>&nbsp;&nbsp;<%=auctionBean.getCurrentprice()+"元"%></td>
      </tr>
       <tr><td>
          <span class="glyphicon glyphicon-star-empty"></span> 竞价次数</td>
       		<td>&nbsp;&nbsp;
          <span class="glyphicon"><font color="blue" ><%=auctionBean.getBidtimes()+"次"%></font></span> </td>
       </tr>
       <tr>
       <td> <span class="glyphicon glyphicon-user"></span>拍卖胜出者ID</td>
       <td>&nbsp;&nbsp;
          <span class="glyphicon"><font color="blue" ><%=auctionBean.getUSRID()%></font></span> </td>       
       </tr>
  </table>
   </div>
</div>
    <br></br>  	
      <%} %>      
      
      
		</div>
   		</div>	
	</div>	
  

<div class="panel panel-default" style="background:#E6E6E6" >
    <div class="panel-heading" style="background-color:#5091F3" >
      <h4 class="panel-title" style="color:#ffffff">
        <a data-toggle="collapse" data-parent="#accordion" 
          href="#collapseFour">
       			<center>运动 &nbsp;<img  src="img/logo/sport.png" width="25" height="25">   </center>
        </a>
      </h4>
    </div>
    <div id="collapseFour" class="panel-collapse collapse ">
      <div class="panel-body">    
      <%
      ArrayList al4=ab.getsportinfo();
      Iterator it4=al4.iterator();
      while(it4.hasNext()){
     AuctionBean auctionBean =(AuctionBean)it4.next();
 %>  
      
      <div class="panel panel-success">
       <div class="panel-heading">
    	<span class="label label-danger">H O T</span>
      </div>
      
   <div class="panel-body">
      <a class="pull-left" href="AuctionServletCL?flag=detail_1&auctionId=<%=auctionBean.getAuctionId()%>" >
      <img class="media-object" src="img/img_auction/<%=auctionBean.getPhotopath()%>" style="width:100%">
      </a>
   </div>
   <div class="panel-footer">
   <table>
       <tr><td><span class="glyphicon glyphicon-time">起拍时间</span></td>
       <td>&nbsp;&nbsp;<%=auctionBean.getStarttime()%></td></tr>
      
       <tr><td><span class="glyphicon glyphicon-time">结束时间</span></td>
       <td>&nbsp;&nbsp;<%=auctionBean.getFinishtime()%></td></tr>
      <tr style="color: red">
      <td><span class="glyphicon glyphicon-heart" >当前价钱</span></td>
      <td>&nbsp;&nbsp;<%=auctionBean.getCurrentprice()+"元"%></td>
      </tr>
       <tr><td>
          <span class="glyphicon glyphicon-star-empty"></span> 竞价次数</td>
       		<td>&nbsp;&nbsp;
          <span class="glyphicon "><font color="blue" ><%=auctionBean.getBidtimes()+"次"%></font></span> </a></td>
       </tr>
  </table>
   </div>
</div>
    <br></br>  	
      <%} %>
      
      
 <%
      ArrayList al44=ab.getsportinfo2();
      Iterator it44=al44.iterator();
      while(it44.hasNext()){
      AuctionBean auctionBean =(AuctionBean)it44.next();
 	  %>  
      
      <div class="panel panel-success">
       <div class="panel-heading">
    	<span class="label label-danger">已结束</span>
      </div>
      
   <div class="panel-body">
   
      <img class="media-object" src="img/img_auction/<%=auctionBean.getPhotopath()%>" style="width:100%">
    
   </div>
   <div class="panel-footer">
   <table>    
      <tr style="color: red">
      <td><span class="glyphicon glyphicon-heart">成交金额</span></td>
      <td>&nbsp;&nbsp;<%=auctionBean.getCurrentprice()+"元"%></td>
      </tr>
       <tr><td>
          <span class="glyphicon glyphicon-star-empty"></span> 竞价次数</td>
       		<td>&nbsp;&nbsp;
          <span class="glyphicon"><font color="blue" ><%=auctionBean.getBidtimes()+"次"%></font></span> </td>
       </tr>
       <tr>
       <td> <span class="glyphicon glyphicon-user"></span>拍卖胜出者ID</td>
       <td>&nbsp;&nbsp;
          <span class="glyphicon"><font color="blue" ><%=auctionBean.getUSRID()%></font></span> </td>       
       </tr>
  </table>
   </div>
</div>
    <br></br>  	
      <%} %>      
          
      
      
		</div>
   		</div>	
	</div>	
	
	
<div class="panel panel-default" style="background:#E6E6E6" >
    <div class="panel-heading" style="background-color:#5091F3" >
      <h4 class="panel-title" style="color:#ffffff">
        <a data-toggle="collapse" data-parent="#accordion" 
          href="#collapseFive">
       			<center>通讯 &nbsp;<img  src="img/logo/posal1.png" width="25" height="25">   </center>
        </a>
      </h4>
    </div>
    <div id="collapseFive" class="panel-collapse collapse ">
      <div class="panel-body">    
      <%
      ArrayList al5=ab.getpostalinfo();
      Iterator it5=al5.iterator();
      while(it5.hasNext()){
     AuctionBean auctionBean =(AuctionBean)it5.next();
 %>  
      
      <div class="panel panel-success">
       <div class="panel-heading">
    	<span class="label label-danger">H O T</span>
      </div>
      
   <div class="panel-body">
      <a class="pull-left" href="AuctionServletCL?flag=detail_1&auctionId=<%=auctionBean.getAuctionId()%>" >
      <img class="media-object" src="img/img_auction/<%=auctionBean.getPhotopath()%>" style="width:100%">
      </a>
   </div>
   <div class="panel-footer">
   <table>
       <tr><td><span class="glyphicon glyphicon-time">起拍时间</span></td>
       <td>&nbsp;&nbsp;<%=auctionBean.getStarttime()%></td></tr>
      
       <tr><td><span class="glyphicon glyphicon-time">结束时间</span></td>
       <td>&nbsp;&nbsp;<%=auctionBean.getFinishtime()%></td></tr>
      <tr style="color: red"><td><span class="glyphicon glyphicon-heart">当前价钱</span></td>
      <td>&nbsp;&nbsp;<%=auctionBean.getCurrentprice()+"元"%></td></tr>
       <tr><td>
          <span class="glyphicon glyphicon-star-empty"></span> 竞价次数</td>
       		<td>&nbsp;&nbsp;
          <span class="glyphicon "><font color="blue" ><%=auctionBean.getBidtimes()+"次"%></font></span> </a></td>
       </tr>
  </table>
   </div>
</div>
    <br></br>  	
      <%} %>
      
     <%
      ArrayList al55=ab.getpostalinfo2();
      Iterator it55=al55.iterator();
      while(it55.hasNext()){
      AuctionBean auctionBean =(AuctionBean)it55.next();
 	  %>  
      
      <div class="panel panel-success">
       <div class="panel-heading">
    	<span class="label label-danger">已结束</span>
      </div>
      
   <div class="panel-body">
     
      <img class="media-object" src="img/img_auction/<%=auctionBean.getPhotopath()%>" style="width:100%">
     
   </div>
   <div class="panel-footer">
   <table>    
      <tr style="color: red">
      <td><span class="glyphicon glyphicon-heart">成交金额</span></td>
      <td>&nbsp;&nbsp;<%=auctionBean.getCurrentprice()+"元"%></td>
      </tr>
       <tr><td>
          <span class="glyphicon glyphicon-star-empty"></span> 竞价次数</td>
       		<td>&nbsp;&nbsp;
          <span class="glyphicon"><font color="blue" ><%=auctionBean.getBidtimes()+"次"%></font></span> </td>
       </tr>
       <tr>
       <td> <span class="glyphicon glyphicon-user"></span>拍卖胜出者ID</td>
       <td>&nbsp;&nbsp;
          <span class="glyphicon"><font color="blue" ><%=auctionBean.getUSRID()%></font></span> </td>       
       </tr>
  </table>
   </div>
</div>
    <br></br>  	
      <%} %>       
      
      
		</div>
   		</div>	
	</div>		
	
	
   </div>
  </body>
</html>
