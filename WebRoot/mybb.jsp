 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>约吧-表白墙</title>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href=css/style.min.css">
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
 
</head>
<body style="background:#E0E0E0"> 
<jsp:useBean id="conn" scope="page" class="yb.conn"/>


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
            <li  class="active" >
              <a href="javascript:void(0)" >表白墙</a>
            </li>
            <li><a href="hometown.jsp">老乡会</a></li>
            <li><a href="activity.jsp">找活动</a></li>
         
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
    <br>
    <br>
    <br>
    <div class="container">

        <div class="row">
        
      
 
        <% 
        Integer usrid=(Integer)session.getAttribute("userkey");
        String sql="select *from love_info  where usrid="+usrid+" order by id desc ";
        ResultSet rs=conn.exequery(sql); 
        while(rs.next())
        {
         %>
         <script>
$(document).ready(function(){
$("#d<%=rs.getInt("id")%>").click(function(){

$.ajax({

   url:"lovedel",
   type:"post",
   dataType:"html",
   data:{
   id:<%=rs.getInt("id")%>
   },
   
   success:function(data)
   {
      $("#div<%=rs.getInt("id")%>").hide();
  
     
    
   },
   error:function()
   {
   
   
   }
   
})
});
});
</script>
          <div class="col-sm-6 col-md-4 col-lg-4" id="div<%=rs.getString("id")%>">  <div class="panel panel-default" > <div class="panel-heading" style="background:white;"><span class="text-muted" style="float:right;font-size:13px;"><%=rs.getString("love_date").substring(0,16) %> <i class="fa fa-clock-o"></i></span></div> <a href="ybinfo.jsp?id=<%=rs.getString("id")%>"><div class="panel-body" style="height:180px;background-image:url(img/bg31.png);color:#29747D;font-size: 14px;font-family:arial;"><span style="float:left" class="label label-danger"><b>To:</b><%=rs.getString("bbb_user") %></span><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=rs.getString("love_text") %><br><br><div></div></div> </a><div class="panel-footer "  style="height:40px;background:white;"><a id="d<%=rs.getInt("id")%>"><i class="fa fa-trash">删除</i></a><span style="float:right;" class="label label-success"><b>From:</b><%=rs.getString("bb_user") %></span></div></div> </div>    
         <%} %>
        
     
       
      <a id="a" href="index.jsp" style="position: fixed; z-index: 2147483647; display: block;background-color: white;color: #777;font-size: 10px;
line-height: 1;
text-align: center;
text-decoration: none;
bottom: 20px;
right: 20px;
overflow: hidden;
width: 35px;
height: 25px;
border: none;"><i class="fa fa-refresh fa-2x"></i></a>
        </div>
        </div>


      

</body>
</html>