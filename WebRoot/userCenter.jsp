<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    
    <title>个人信息中心</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href=css/style.min.css">
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
 
    <br>
    <br>
    <br>
    <br>
  <div class="container">
  
  	<div class="col-sm-offset-3 col-sm-6">
		<div class="panel panel-default">
		<div class="panel panel-heading">个人信息中心</div>
		<div class="panel-body">

					<div style="float:left;"><img src="img/user2/${person.tx_pix} " class="img-circle"width="64px" height="64px" ></div>
                    <div style="float:right;">
					<h4>昵称：${person.name}</h4>
					<h4>性别：${person.sex}</h4>
					<h4>家乡：${person.home}</h4>
				   <h4><a href="editUser.jsp">编辑资料</a></h4>
					</div>
		
	
	</div>
	<div class="panel-footer" style="background:white;">

 

             <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><button class="btn btn-danger btn-block" ><i class="fa fa-weixin fa-3x"> 约吧</i></button></a>
          
              <ul class="dropdown-menu" role="menu"  style="width:510px;">
                <li>
                  <a href="mybb.jsp" >我的表白</a>
                </li>
                <li>
                  <a href="hometown.jsp" target="_blank">我的老乡会</a>
                </li>
                <li>
                  <a href="MyJoinActivityServlet" >我参与的活动</a>
                </li>
                  <li>
                  <a href="MyCreateServlet" >我创建的活动</a>
                </li>
                <hr>
                  <li>
                  <a href="index.jsp" >主页</a>
                </li>
                </ul>
                
                
                
           
                
                
             <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><button class="btn btn-primary btn-block" ><i class="fa fa-cutlery fa-3x"> 吃吧</i></button></a>
          
              <ul class="dropdown-menu" role="menu"  style="width:510px;">
              
                <li>
                  <a href="Showjoin_act" >我参与的活动</a>
                </li>
                  <li>
                  <a href="Showself_create" >我创建的活动</a>
                </li>
                <hr>
                  <li>
                  <a href="FoodShowAllActivityServlet" >主页</a>
                </li>
                </ul>
                
             
                   
             <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><button class="btn btn-success btn-block" ><i class="fa fa-jpy fa-3x"> 淘吧</i></button></a>
          
              <ul class="dropdown-menu" role="menu"  style="width:510px;">
              
                <li>
                  <a href="ShowTiaozaoGoods" >我的跳蚤商品</a>
                </li>
                <li>
                  <a href="ShowTiaozaoOrder" >我的跳蚤订单</a>
                </li>
                  <li>
                  <a href="ShowAuction" >我的拍卖商品</a>
                </li>
                <hr>
                  <li>
                  <a href="salemainpage.jsp" >主页</a>
                </li>
                </ul>   
         
 

  </div>
     </div>
     </div>
      </div>
  </body>
</html>
