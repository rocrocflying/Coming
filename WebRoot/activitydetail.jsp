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
    <title> 创建活动   </title>
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
          <a class="navbar-brand hidden-sm" style="color:#5CB85C"><b>约吧</b></a>
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
 
       <div class="row">
        <div class="col-sm-12" style="padding-bottom: 10px">
            <a href="ShowAllActivityServlet" class="btn btn-primary"><i class="glyphicon glyphicon-chevron-left"></i>  返回活动列表</a>
           
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6 activity-info">
            <div class="panel panel-default">
              
              
               
              <c:if  test="${activity.act_image=='nopic'}">
             <span class="text-danger">   <h4> 请上传属于自己的活动图片！</h4> </span>
                
                 </c:if>
                 <c:if  test="${activity.act_image!='nopic'}">
                  <div class="panel-thumbnail" data-toggle="tooltip" data-placement="bottom" title="#">
                <img src="uploadFile/${activity.act_image}" class="img-responsive center-block">
              </div>
              
                 </c:if>
            <hr/>
              <div class="panel-body">
                <p class="lead">${activity.act_title} </p>
                <p class="text-muted">${activity.act_detail} </p>
                <br/>
                <p>
                    <span class="text-info glyphicon glyphicon-user"></span> ${activity.user_id}dddd
                    <span class="text-primary glyphicon glyphicon-time"></span> 
               <c:choose>
                 <c:when test="${nowtime<=activity.begin_date}">
                  活动<font color="red">${day}</font>天后开始
                 </c:when>
                  <c:otherwise>
                                                                     已开始                                                   
                  </c:otherwise> 
               </c:choose>
               
                    <span class="text-danger glyphicon glyphicon-heart-empty"></span><span id="count">${activity.act_count}</span>人参加
                    <span class="text-success glyphicon glyphicon-map-marker"></span> ${activity.act_place}
                </p>
                <hr/>
                <p >
                     
                     <span class="text-danger">${activity.act_charge}</span>
                    • <span class="text-success">${activity.act_date}</span>创建&nbsp&nbsp&nbsp&nbsp
                  <span id="showpraise">
                    <c:if  test="${praise.prais_state==1}">
                    <span class="text-danger text-danger fa fa-thumbs-o-up"  style="magrin-left:150px"></span>您已经赞过了！
                    </c:if>
                      <c:if  test="${praise.prais_state!=1}">
                      
                           <%if(session.getAttribute("userkey")!=null)
                      { %>
                           <button class="btn btn-primary btn-right" id="praise"><span class="text-primary text-danger fa fa-thumbs-o-up"  style="magrin-left:150px" ></span>&nbsp点个赞吧！</button>
                        <%}else{ %>
                        
                          <button class="btn btn-primary btn-right" id="praise" onclick="javascript:alert('请先登录！')"><span class="text-primary text-danger fa fa-thumbs-o-up"  style="magrin-left:150px" ></span>&nbsp点个赞吧！</button>
                        <%} %>
                         
                      
                       </c:if>
                 </span>
                    </p>
            </div>
        </div>
            <div class="well">
                <h3>其他信息</h3>
                <ul class="list-group">
                   
                    <li class="list-group-item">
                        <strong>开始时间</strong>:  ${activity.begin_date}
                    </li>

                    <li class="list-group-item">
                        <strong>结束时间</strong>: ${activity.end_date}
                    </li>
                    <h3>负责人信息</h3>
                    <li class="list-group-item">
                        <strong>姓名</strong>: ${activity.act_charge}
                    </li>
                                        <li class="list-group-item">
                        <strong>电话</strong>: ${activity.act_phone}
                    </li>
                                                            <li class="list-group-item">
                        <strong>QQ</strong>: ${activity.act_qq}
                    </li>
                                                            <li class="list-group-item">
                        <strong>微信号</strong>: ${activity.act_weix}
                    </li>
                                                        </ul>
            </div>
        </div><!--/col-->
          <div id="user">
        
         <div class="col-xs-12 col-sm-6 col-md-6" style="padding-bottom: 10px" id="join">
            <c:choose>
            <c:when test="${nowtime<=activity.end_date}">
             <c:choose>
               <c:when test="${joinsate.join_state==1}">
                      <div class="panel panel-default" >
                       <div class="panel-heading" style="background:white"><h3><span class="text-primary">您已参加了这个活动！</span></h3></div>
                         <div class="panel-body">
                          <input class='btn btn-lg btn-danger btn-block' id='btn-cancel'  type='submit' value='取消报名'/>
                          </div>
                        </div>
                </c:when>
                <c:otherwise>
                      <div class="panel panel-default" >
                       <div class="panel-heading" style="background:white"><h3><span class="text-primary">赶快来参加吧！</span></h3></div>
                          <div class="panel-body">
                         <%if(session.getAttribute("userkey")!=null)
                      { %>
                           <input class='btn btn-lg btn-primary btn-block' id='btn-bm'  type='submit' value='报名参加'/>
                        <%}else{ %>
                         <input class='btn btn-lg btn-primary btn-block' id='btn-bm'  type='submit' value='报名参加' onclick="javascript:alert('请先登录！')" />
                        <%} %>
                         
                      
                           </div>
                        </div>
               </c:otherwise> 
               </c:choose>
              </c:when>
           <c:otherwise>
           <div class="alert alert-danger">活动已结束,无法报名</div>
           </c:otherwise>  
           </c:choose>
  


         
       </div>
        
        <div class="col-xs-12 col-sm-6 col-md-6">
            <div class="well">
                <h4> ${activity.act_count}人 已参加 </h4>
                <div class="row">
                  <c:forEach var="j" items="${joinuserlist}">
                       <a style="margin-top: 6px" class="col-sm-2 col-xs-3" href="ShowUserInfoServlet?uid=${j.usrid}">
                        <img title="${j.usrnm}" class="img-rounded img-circle img-responsive" src="img/user2/${j.head_pic}" /></a>
                   </c:forEach>
                </div>
                
            </div>
        </div>
       
      </div>

</div>
<script>
$("#btn-bm").click(function(){
  $.post("ActivityJoinServlet",
  {
    
    aid:${activity.act_id}

  },
  function(data,status){
    //alert("Data: " + data + "\nStatus: " + status);
 // ${joinsate.join_state}=1;
   // $("#join").html("<input class='btn btn-lg btn-danger btn-block' id='btn-cancel'  type='submit' value='取消报名'/>");
      LoadData();

  });
});

$("#btn-cancel").click(function(){
  $.post("ActivityCancelServlet",
  {
    bid:${activity.act_id}

  },
  function(data,status){
  //alert("Data: " + data + "\nStatus: " + status);

 // $("#join").html("<input class='btn btn-lg btn-danger btn-block' id='btn-bm'  type='submit' value='报名参加'/>");
     LoadData();
   
 
    
  });
});

$("#praise").click(function(){
  $.post("ActivityPraiseServlet",
  {
    
    aid:${activity.act_id}

  },
  function(data,status){
     $("#showpraise").html(data);
     // LoadData();
    //alert("Data: " + data + "\nStatus: " + status);
  // $("#a").removeClass('hidden');
  // $("#b").addClass('hidden');
    
  });
});


</script>


<script type="text/javascript">
    function LoadData() {
        var aid = ${activity.act_id};
        $("#user").load("UserJoinServlet", { "aid": aid }, function() {
            $("#user").fadeIn("slow");
        }
        );
    } 
</script>
</body>
</html>