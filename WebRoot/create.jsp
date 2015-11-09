<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link media="all" type="text/css" rel="stylesheet" href="11css/style.min.css">
           
    
<link media="all" type="text/css" rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">


    <!--[if lt IE9]>
    <script src="http://xtuers.com/js/html5.js"></script>

    <![endif]-->
</head>
<body style="background:#E0E0E0" >
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

  <%
request.setCharacterEncoding("utf-8");
if(session.getAttribute("userkey")==null)
{
session.setAttribute("create","create.jsp");
out.println("<script>alert('您还没登录，请先登录！');window.location.href='login.jsp';</script>");

}

%>
 
    

    <div class="navbar navbar-default navbar-fixed-top" style="background:#FFFFFF">
      <div class="container">
        <div class="navbar-header">
          <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand hidden-sm" style="color:#F65F6B"><b>约吧</b></a>
        </div>
        <div class="navbar-collapse collapse" role="navigation">
          <ul class="nav navbar-nav">
            <li   >
              <a href="javascript:void(0)" >表白墙</a>
            </li>
            <li><a href="hometown.jsp">老乡会</a></li>
            <li><a href="ShowAllActivityServlet">找活动</a></li>
         
          </ul>
           <% if(session.getAttribute("userkey")==null){ %>
          <ul class="nav navbar-nav  navbar-right">   <li class="nav navbar-nav navbar-right"><a href="login.jsp"><i class="glyphicon glyphicon-user"></i></a></li></ul>
          <%}else{ %>
             <ul class="nav navbar-nav  navbar-right"> 
             <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i></a>
          
              <ul class="dropdown-menu" role="menu" >
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
                  <a href="logout.jsp" >注销</a>
                </li>
             </ul>
          <%} %>
          
        </div>
      </div>
    </div>
    <br/>
<br/>
<br/>
<br/>
    
    
    
   
 
    <div class="container" id="main">
  
    <div class="row">
    <form method="POST" action="ActivityServlet" enctype="multipart/form-data"  class="form-horizontal" id="create-activity-form" onsubmit="return checkAll();">
 
    <div class="col-sm-6 col-md-6">
        <div class="panel panel-success">
            <div class="panel-heading"  style="background:white">
                <h3 class="text-primary">活动信息</h3>
            </div>
            <div class="panel-body">
                <div class="form-group">
                    <label for="title" class="col-sm-3 control-label">活动标题<span class="text-danger"> *</span> :</label>
                    <div class="col-sm-8">
                        <input id="title" type="text" value="" name="acttitle" class="form-control" placeholder="5-50字 ,如周末骑车去大理" >
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-3 control-label">活动描述<span class="text-danger"> *</span> :</label>
                    <div class="col-sm-9">
                        <textarea id="description" name="actdetail" class="form-control" rows="5" placeholder="" ></textarea>
                    </div>
                </div>
              
                <div class="form-group">
                    <label for="location" class="col-sm-3 control-label">地点<span class="text-danger"> *</span> :</label>
                    <div class="col-sm-6">
                        <input id="location" name="actplace" class="form-control" type="text" value="" placeholder="如云南师范大学活动中心" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="cover" class="col-sm-3 control-label">封面图片:</label>
                    <div class="col-sm-6">
                        <input type="file" id="photo" name="image"  />
                        
                    
                    </div>
                    

                </div>
                <div class="form-group">
                    <label for="start-time" class="col-sm-3 control-label">开始时间<span class="text-danger"> *</span> :</label>
                    <div id="start-time-picker" class="input-group date col-md-8 col-sm-8" data-date="<%=com.yb.sql.TimeFactory.getTime()%>" data-date-format="yyyy-mm-dd HH:mm:ss" data-link-field="start-time">
                        <input id="starttime" class="form-control" name="begindate" size="16" type="text" value="" readonly>
                      
                        <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
                    </div>
                    <input type="hidden" name="start_at" id="start-time" value="" /><br/>
                </div>
                <div class="form-group">
                    <label for="end-time" class="col-sm-3 control-label">结束时间<span class="text-danger"> *</span> :</label>
                    <div id="end-time-picker" class="input-group date col-md-8 col-sm-8" data-date="<%=com.yb.sql.TimeFactory.getTime()%>" data-date-format="yyyy-mm-dd HH:mm:ss" data-link-field="end-time">
                        <input id="endtime"  class="form-control" name="enddate" size="16" type="text" value="" readonly>
                     
                        <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
                    </div>
                    <input type="hidden" name="end_at" id="end-time" value=""  /><br/>
                </div>
            
                   
               </div>
        </div>
    </div>
    
    <div class="col-sm-6 col-md-6">
      
        <div class="well">
            <h3 class="text-primary">负责人信息</h3>
            <div class="form-group">
                <label for="name" class="col-sm-3 control-label">姓名<span class="text-danger"> *</span> :</label>
                <div class="col-sm-4">
                    <input id="name" type="text" value="" name="actcharger" class="form-control" placeholder=""  >
                </div>
                <p class="help-block">组织请填组织名称</p>
            </div>
            <div class="form-group">
                <label for="tel" class="col-sm-3 control-label">电话:</label>
                <div class="col-sm-5">
                    <input id="tel" type="tel" value=""  name="actphone" class="form-control" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-3 control-label">Email:</label>
                <div class="col-sm-5">
                    <input id="email" type="email" value="" name="actemail" class="form-control" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="qq" class="col-sm-3 control-label">QQ:</label>
                <div class="col-sm-5">
                    <input id="qq" type="text" value="" name="actqq" class="form-control" placeholder="" >
                </div>
            </div>
            <div class="form-group">
                <label for="wechat" class="col-sm-3 control-label">微信号:</label>
                <div class="col-sm-5">
                    <input id="wechat" type="text" value="" name="actweix" class="form-control" placeholder="">
                </div>
            </div>
        </div>
        <input class="btn-block btn-danger btn-lg btn" id="btn-submit-create"  data-loading-text="提交中..."  type="submit" value="创建活动"/>
    </div>

    </form>
   
   
        </div>
</div>
<footer id="footer" role="contentinfo" style="margin-left:480px">
    <div class="container">
        <p>©2015 ynnu.com <a href="#" rel="nofollow" target="_blank">云南师范大学</a></p>
        <p>使用 
            <a href="http://getbootstrap.com/" title="v3.2" rel="nofollow" target="_blank">Bootstrap</a>、
            <a href="http://jquery.com/" title="1.10.2" rel="nofollow" target="_blank">JQuery</a> 快速开发
        </p>
        <p>Code by<a href="#" target="_blank">约吧</a> 
        </p>
    </div>
    </footer>
</body>
<script src="js/jquery.min.js"></script>

<script src="js/bootstrap.min.js"></script>





<script type="application/javascript">
      $("#main").ajaxError(function(event,request, settings){ console.log(event); console.log(request); if(request.responseJSON.error != 'undefined'){ showError(request.responseJSON.error); }else if(request.responseJSON.msg != 'undefined'){ showError(request.responseJSON.msg); } }); $('#navigation').autoHidingNavbar(); </script> 


<script src="js/bootstrap-datetimepicker.min.js"></script>

<script src="js/bootstrap-datetimepicker.zh-CN.js"></script>

<script type="application/javascript">

    

    $('#start-time-picker').datetimepicker({
        'language':'zh-CN'
    });
    $('#end-time-picker').datetimepicker({
        'language':'zh-CN'
    });
   
    

  
</script>
<script>
function checkTitle(){
	var title = document.getElementById("title").value.trim();
	if(title == null || title == ""){
	alert("请输入活动标题！");
	return false;
	}
	return true;
}

function checkDescription(){
	var description = document.getElementById("description").value.trim();
	if(description == null || description ==""){
	alert("请输入活动描述！");
	return false;
	}
	return true;
}

function checkLocation(){
	var location = document.getElementById("location").value.trim();
	if(location == null || location ==""){
	alert("请天填写活动地点！");
	return false;
	}
	return true;
}

function checkLocation(){
	var location = document.getElementById("location").value.trim();
	if(location == null || location ==""){
	alert("请填写活动地点！");
	return false;
	}
	return true;
}

function checkStarttime(){
	var starttime = document.getElementById("starttime").value;
	if(starttime == null || starttime ==""){
	alert("请输入活动开始时间！");
	return false;
	}
	return true;
}

function checkEndtime(){
	var endtime = document.getElementById("endtime").value;
	if(endtime== null || endtime ==""){
	alert("请输入活动结束时间！");
	return false;
	}
	return true;
}

function checkTime(){
	var starttime = document.getElementById("starttime").value;
	var endtime = document.getElementById("endtime").value;
	if(starttime>endtime){
	alert("活动开始时间不能早于活动结束时间！");
	return false;
	}
	return true;
}

function checkName(){
	var name = document.getElementById("name").value.trim();
	
	if( name== null ||  name ==""){
	alert("请输入负责人姓名！");
	return false;
	}
	return true;
}

function checkTel(){
	var tel = document.getElementById("tel").value.trim();
	
 if(/^1\d{10}$/g.test(tel) || tel=="" || tel==null)              /*1开头后面10位，test返回值是true或false*/
   {      
      return true;
    }
 else
   {
      alert("手机号错误");
       return false;
    }
}

function checkQq(){
	var qq = document.getElementById("qq").value.trim();
	 var bValidate = RegExp(/^[1-9][0-9]{4,9}$/).test(qq);  
	
 if(bValidate||qq==null|| qq=="")              /*1开头后面10位，test返回值是true或false*/
   {      
      return true;
    }
 else
   {
      alert("请输入正确的QQ！");
       return false;
    }
}

function checkAll(){

	if(checkTitle() && checkDescription()&&checkLocation()&&checkStarttime()&&checkEndtime()&&checkTime()&&checkName()&&checkTel()&&checkQq()){
		return true;
	}
	return false;
}
</script>

  </html>