<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="author" content="Linroid">
    <title> 创建活动   </title>
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
          <a class="navbar-brand hidden-sm" style="color:#5CB85C"><b>约吧</b></a>
        </div>
        <div class="navbar-collapse collapse" role="navigation">
          <ul class="nav navbar-nav">
            <li  class="active" >
              <a href="javascript:void(0)" >表白墙</a>
            </li>
            <li><a href="hometown.jsp">老乡会</a></li>
            <li><a >找活动</a></li>
          </ul>
        </div>
      </div>
    </div>
  
   <div class="container" id="main"> 
      <div class="row">
      <div class="col-sm-3"></div>
       <div class="col-sm-6"> 
       <div class="panel">
        <div class="panel-heading"> 
         <h3><img src="images/lp.jpg" class="img-circle"/> yidao8808 <small></small> </h3> 
        </div>
         <div class="panel-body"> <div class="description">还没有写介绍</div>
         <div class="form-horizontal">  
          
         <div class="form-group">
          <label for="department" class="control-label col-sm-3">大学: </label>
          <div class="col-sm-7"> <p id="major" class="form-control-static">云南师范大学</p> </div>
        </div> 
           
        <div class="form-group">
          <label for="department" class="control-label col-sm-3">院系: </label>
          <div class="col-sm-7"> <p id="major" class="form-control-static">商学院</p> </div>
        </div>
         <div class="form-group">
            <label for="major" class="control-label col-sm-3">专业: </label> 
            <div class="col-sm-7"> <p id="major" class="form-control-static">会计学 </p> </div>
          </div>
        <div class="form-group"> 
           <label for="gender" class="control-label col-sm-3">性别: </label> 
           <div class="col-sm-7"> <p id="gender" class="form-control-static">妹子 </p> </div> 
         </div>
        
       <div class="form-group"> 
            <label for="province" class="control-label col-sm-3">省份: </label> 
           <div class="col-sm-7"> <p id="province" class="form-control-static">湖南</p> </div> 
           
         </div>
        <div class="form-group"> 
        <label for="created_at" class="control-label col-sm-3">加入时间: </label>
            <div class="col-sm-7"> <p id="created_at" class="form-control-static">2015-04-16 17:43:30</p> </div>
         </div>
         
         
           </div> 
           
           
        </div> 
        
        
        </div>
         </div>
       </div> 
   </div>

</body>
</html>