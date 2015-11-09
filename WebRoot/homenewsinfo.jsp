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
  
<!--[if lt IE 9]>
      <script src="html5shiv.js"></script>
     <![endif]-->


 

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
            <li  >
              <a href="javascript:void(0)" >表白墙</a>
            </li>
            <li  class="active"><a href="hometown.jsp">老乡会</a></li>
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
                  <li>
                  <a href="UserCenter" >个人中心</a>
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
        String id=request.getParameter("id");
   
        Integer userid=(Integer)session.getAttribute("userkey");
        int id2=Integer.parseInt(id);
        String sql4="select *from home_news where id="+id2+" order by id desc ";
        ResultSet rs4=conn.exequery(sql4); 
        while(rs4.next())
        {
        int userid2=rs4.getInt("usrid");
        String province_id=rs4.getString("province_id");
        String sql5="select * from user_info  where usrid="+userid2+"";
        ResultSet rs5=conn.exequery(sql5);
        while(rs5.next())
        {

         %>
        <div class="col-sm-6 col-md-4" >  <div class="panel panel-default" > <div class="panel-heading" style="background:white;">  <img src="img/user2/<%=rs5.getString("head_pic") %>" class="img-circle " width="52px" height="52px"> <span class="timeline-nickname"></span></div><div class="panel-body" style="height:180px;color:#29747D;font-size: 14px;font-family:arial;">&nbsp;&nbsp;<%=rs4.getString("content") %></div><div class="panel-footer"></div></div> 
          <div class="well" style="height:180px;"><form action="news_commentt"  method="post"><h4>发表评论</h4>
          <textarea name="comment" rows="3" placeholder="1-100字..." class="form-control"></textarea >
          <input type="hidden" name="newsid" value="<%=id%>"><input type="hidden" name="usrid" value="<%=userid%>"> <input type="hidden" name="province_id" value="<%=province_id%>"> <button type="submit" class="btn btn btn-primary" style="margin-top:5px;float:right;"><i class="glyphicon glyphicon-send"></i>发送</button></form></div>
        </div>    
     

        <%}} %>
        
       <div class="col-sm-6 col-md-4 col-lg-4" ><div class="panel panel-default"><div class="panel-heading" style="background:white;"><b>评论详情</b></div><div class="panel-body">
      <%
         boolean m=false;
         String sql6="select *from news_comment where newsid= "+id2+" ";
         ResultSet rs6=conn.exequery(sql6);
         while(rs6.next())
         {
         m=true;
         String usrid6=rs6.getString("usrid");
         String sql7="select *from user_info where usrid='"+usrid6+"'";
         ResultSet rs7=conn.exequery(sql7);
         while(rs7.next()){
          %>
<p><img src="img/user2/<%=rs7.getString("head_pic")%>" class="img-circle " width="32px" height="32px"><span style="color:blue;"><b><%=rs7.getString("usrnm") %></b></span><br><br><span><%=rs6.getString("content") %></span></p><hr>
         <%
        } }
        if(m==false){
        %>
        <div class="alert alert-danger">暂无评论</div>
        <%} %> 
        
        </div>    
                 
      
       
          </div></div></div>
      <a id="a" href="index.jsp" style="position: fixed; z-index: 2147483647; display: block;background-color: white;color: #777;font-size: 15px;
line-height: 1;
text-align: center;
text-decoration: none;
bottom: 20px;
right: 20px;
overflow: hidden;
width: 35px;
height: 35px;
border: none;"><i class="fa fa-refresh fa-2x"></i></a>
        </div>
        </div>


      

</body>
</html>