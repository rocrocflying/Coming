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
    <title> 找活动   </title>
        <link media="all" type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">
        <link media="all" type="text/css" rel="stylesheet" href="11css/style.min.css">
           
    
<link media="all" type="text/css" rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">


    <!--[if lt IE9]>
    <script src="http://xtuers.com/js/html5.js"></script>

    <![endif]-->
</head>
<script src="js/jquery.min.js"></script>

<script src="js/bootstrap.min.js"></script>



<body style="background:#E0E0E0">
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
          <a class="navbar-brand hidden-sm" style="color:#F65F6B"><b>约吧</b></a>
        </div>
        <div class="navbar-collapse collapse" role="navigation">
          <ul class="nav navbar-nav">
            <li  >
              <a href="index.jsp" >表白墙</a>
            </li>
            <li><a href="hometown.jsp">老乡会</a></li>
            <li  class="active"><a href="ShowAllActivityServlet">找活动</a></li>
         
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
                  <li>
                  <a href="UserCenter" >个人中心</a>
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
     <div class="row" id="activity-container">
        <div class="col-xs-12 col-sm-6 col-md-4 activity-item">
                <a href="create.jsp" data-loading-text="打开中..."  id="btn-create-activity" class="btn-block btn-danger btn-lg btn">
                    <i class=" glyphicon glyphicon-plus"></i> 创建活动</a>
                <div class="row" style="margin-top: 10px">
                    <div class="col-sm-6 col-xs-6">
                        <a href="MyJoinActivityServlet"  id="btn-participater-activity" class="btn-block btn-default btn">
                            <i class="glyphicon glyphicon-user"></i>
                            我参加的</a>
                    </div>
                    <div class="col-sm-6 col-xs-6">
                        <a  href="MyCreateServlet"  id="btn-manage-activity" class="btn-block btn-success btn">
                            <i class="glyphicon glyphicon-bullhorn"></i> 我创建的</a>
                    </div>
                </div>
            <hr/>
        </div>
        
        <c:forEach var="p" items="${allActivity}">
         <div class="col-xs-12 col-sm-6 col-md-4 activity-item wrap" > 
            <div class="panel panel-success" style="height:420px;">  
               
                <div class="panel-body" > 
               
                <c:if  test="${p.act_image=='nopic'}">
                  <div class="panel-thumbnail" data-toggle="tooltip" data-placement="bottom" title="#" style="height:230px;" > 
                 <img src="img/act.jpg" class="img-responsive center-block" style="height:230px;" > 
                   </div>
                 </c:if>
                 <c:if  test="${p.act_image!='nopic'}">
                  <div class="panel-thumbnail" data-toggle="tooltip" data-placement="bottom" title="#" style="height:230px;" > 
                 <img src="uploadFile/${p.act_image}" class="img-responsive center-block" style="height:230px;" > 
                   </div>
                 </c:if>
              
                <p class="lead">${p.act_title}</p>  <p>
                       <span class="text-info fa fa-user"></span> ${p.act_charge}  
                       <span class="text-primary fa fa-bell-o"></span> ${nowtime<=p.end_date?"未结束":"已结束"} 
                        <span class="text-danger fa fa-heart-o"></span> ${p.act_count}人参加
                         <span class="text-primary fa fa-flag-o"></span> ${p.act_place} 
                         <%if(session.getAttribute("userkey")!=null)
                      { %>
                         <span id="b${p.act_id}"><a id="a${p.act_id}"  class="btn text-primary fa fa-thumbs-o-up"></a>${p.act_good} </span> 
                        <%}else{ %>
                        <span ><a  class="btn text-primary fa fa-thumbs-o-up" onclick="javascript:alert('请先登录！')"></a>${p.act_good} </span> 
                        <%} %>
                         </p> <hr/> <p >
                         <a class="text-muted pull-left" href="ShowUserInfoServlet?uid=${p.user_id}">${p.usrnm}
                         <img title="${p.usrnm}" src="img/user2/${p.head_pic}" width="28px" height="28px"/> 
                         </a> 
                         <a class="pull-right btn btn-default"  href="ShowActivityViewServlet?aid=${p.act_id}" target="_blank">  查看详情  </a> </p> 
                         </div> 
                      </div> 
            </div>
            
            <script>

$("#a${p.act_id}").click(function(){
  $.post("ActivityPraiseAServlet",
  {
    
    aid:${p.act_id}

  },
  function(data,status){
   // alert("Data: " + data + "\nStatus: " + status);
    // $("#count").html(data);
     $("#b${p.act_id}").html("<font color='red'><i class='fa fa-thumbs-o-up'></i></font>&nbsp&nbsp"+data+"");
    // $("#b${p.act_id}").html();
  
  // $("#a").removeClass('hidden');
  // $("#b").addClass('hidden');
    
  });  
});
</script>
        </c:forEach>
      </div>

</div>

</body>
</html>