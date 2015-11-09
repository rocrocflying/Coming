<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="author" content="Linroid">
    <title> 美食墙   </title>
        <link media="all" type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">
        <link media="all" type="text/css" rel="stylesheet" href="css/style.min.css">
           
    
<link media="all" type="text/css" rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">


    <!--[if lt IE9]>
    <script src="http://xtuers.com/js/html5.js"></script>

    <![endif]-->
</head>
<script src="js/jquery.min.js"></script>

<script src="js/bootstrap.min.js"></script>
<body>
<div id="message" style="display: none;">
</div>
<!--[if lt IE9]>
<div class="container" style="margin-top: 60px">
    <div class="alert alert-danger">
        您的浏览器版本太低,无法正常使用,请升级或换用其他浏览器
        <br/>
        <ul class="list-inline">
            <li><a href="http://www.google.cn/chrome/intl/zh-CN/landing_chrome.html?hl=zh-CN">Google Chrome</a></li>
            <li><a href="http://firefox.com.cn/">火狐</a></li>
            <li><a href="http://cn.opera.com/">Opera</a></li>
            <li><a href="http://www.apple.com.cn/safari">Safari</a></li>
        </ul>
    </div>
</div>
<![endif]-->

   
       <div class="navbar navbar-default navbar-fixed-top" style="background:#FFFFFF">
      <div class="container">
        <div class="navbar-header">
          <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand hidden-sm" style="color:#5CB85C"><b>吃吧</b></a>
        </div>
         <div class="navbar-collapse collapse" role="navigation">
          <ul class="nav navbar-nav">
          <li><a href="Showfood" >美食墙</a></li>
            <li><a href="Lovefood" >猜你喜欢</a></li>
            <li><a href="FoodShowAllActivityServlet" >约吃</a></li>
          </ul>
           <ul class="nav navbar-nav navbar-right">  
           
              <li class="btn-group "> 
              <a href="#" data-toggle="dropdown" ><i class="glyphicon glyphicon-user"></i></a> 
               <ul class="dropdown-menu" role="menu"> <li><a href="Showprofile">我的资料</a></li> 
              <!--  <li><a href="http://xtuers.com/chat">我的私信</a></li> -->、            
              <li><a href="Showself_create">我发起的活动</a></li>
               <li><a href="Showjoin_act">我参与的活动</a></li>
                <li class="divider"></li> <li class="divider"></li> <li>
                  <a href="logout.jsp" >注销</a>
                </li>
                 </ul>  </li> </ul>
         </div>
      </div>
    </div>
  
 <div class="container" id="main"> 
 
       <div class="row">
        <div class="col-sm-12" style="padding-bottom: 10px">
            <a href="Showfood" class="btn btn-primary"><i class="glyphicon glyphicon-chevron-left"></i> 返回美食墙  </a>
           
        </div>
       
        <div class="col-xs-12 col-sm-6 col-md-6 activity-info">
            <div class="panel panel-default">
              <div class="panel-thumbnail" data-toggle="tooltip" data-placement="bottom" title="#">
                <img src="food_uploadFile/food/${food.act_image}" class="img-responsive center-block">
              </div>
            <hr/>
              <div class="panel-body">
                <p class="lead">${food.act_title} </p>
                <p class="text-muted">${food.act_detail} </p>
                <br/>
                <p>
                   
                    <span class="text-danger glyphicon glyphicon-star-empty"></span> ${food.act_count}人赞
                   <span class="text-danger glyphicon glyphicon-star-empty"></span> 地点 ${food.act_place}
                </p>
                <hr/>
                               <a href="Upstate?id=${food.act_id}" data-loading-text="执行中..."  id="btn-create-activity" class="btn-block btn-danger btn-lg btn">
                    <i class=" glyphicon glyphicon-plus"></i> 给个赞</a>
               
            </div>
        </div>
           
        </div><!--/col-->
       
         <div class="col-xs-12 col-sm-6 col-md-6" style="padding-bottom: 10px">

                
         </div>
        
     
        </div>
        
     

</div>

</body>
</html>