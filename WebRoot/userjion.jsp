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
  
  <body>
          <div class="col-xs-12 col-sm-6 col-md-6" style="padding-bottom: 10px" id="join">
            <c:if test="${joinsate.join_state==1}">
            <div class="panel panel-default" >
             <div class="panel-heading" style="background:white"><h3><span class="text-primary">您已参加了这个活动！</span></h3></div>
                <div class="panel-body">
                <input class='btn btn-lg btn-danger btn-block' id='btn-cancel'  type='submit' value='取消报名'/>
                </div>
                               
            </div>
          
            </c:if>
            <c:if test="${joinsate.join_state!=1}">
              <div class="panel panel-default" >
             <div class="panel-heading" style="background:white"><h3><span class="text-primary">赶快来参加吧！</span></h3></div>
                <div class="panel-body">
             <input class='btn btn-lg btn-primary btn-block' id='btn-bm'  type='submit' value='报名参加'/>
               </div>
               </div>
          </c:if>
  

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
        
        
  <script>
$("#btn-bm").click(function(){
  $.post("ActivityJoinServlet",
  {
    
    aid:${activity.act_id}

  },
  function(data,status){
    // $("#join").html(data);
     // alert("Data: " + data + "\nStatus: " + status);
      LoadData();
  
  // $("#a").removeClass('hidden');
  // $("#b").addClass('hidden');
    
  });
});

$("#btn-cancel").click(function(){
  $.post("ActivityCancelServlet",
  {
    bid:${activity.act_id}

  },
  function(data,status){
   //  $("#join").html(data);
      LoadData();
    //alert("Data: " + data + "\nStatus: " + status);
 
    
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
