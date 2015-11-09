<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>约吧-老乡会</title>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
      <script src="html5shiv.js"></script>
     <![endif]-->
<SCRIPT language=JavaScript>function MM_jumpMenu(targ,selObj,restore){  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");  if (restore) selObj.selectedIndex=0;}
</SCRIPT>
<script>

function check(form)
{
	if(form.home_content.value.length>100)
	{
	alert("不能超过100字");form.home_content.focus();
	return false;
	} 
	
  if(form.home_content.value==""||form.home_content.value==null)
	{
	alert("不能为空");form.home_content.focus();
	return false;
	} 

 form.submit();
}
</script>
<style>
a:link {
text-decoration:none;
}
a:visited {

text-decoration:none;
}
a:hover {

 text-decoration:none;
}
a:active {

 text-decoration:none;
}
</style>
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
          <ul class="nav navbar-nav" >
            <li   >
              <a href="index.jsp" >表白墙</a>
            </li>
            <li class="active"><a href="hometown.jsp">老乡会</a></li>
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
    <br>
    <br>
     <br>
    <br>
    <% 
        int id2=Integer.parseInt(request.getParameter("id").toString());
        String sql3="select *from province  where id="+id2+"";
        ResultSet rs3=conn.exequery(sql3); 
      
        while(rs3.next())
        {
       
       
    
     %>
    <div class="container">

        <div class="row">
        
         <div class=" col-sm-6 col-md-4 ">
            <div class="panel panel-default" >
              
                   <div class="panel-heading" style="height:90px;">
                <h4 style="color:#5CB85C"><b><i class="glyphicon glyphicon-map-marker"></i><font color="red"><%=rs3.getString("name") %></font> 老乡会</b></h4>
                <button style="float:left;" onclick="javascript:window.location.href='hometown.jsp';"class="btn btn-success">< 返回老乡会主页</button><button style="float:right;" onclick="javasvript:window.location.href='homelist.jsp?id=<%=id2 %>'" class="btn btn-primary">查看老乡信息列表</button>
                    </div>  
                      <div class="panel-body">
                    <%
                   String homet2=rs3.getString("name");
                    boolean m=false;
                    Integer usrid=(Integer)session.getAttribute("userkey");
                    String sql2="select *from user_info where usrid="+usrid+" and homet='"+homet2+"'";
                    ResultSet rs=conn.exequery(sql2);
                    while(rs.next())
                    {
                    m=true;
                    }
                    
                    
                     %>
                       <form method="post" action="homenews" >
                                
                    <input type="hidden" name="province_id" value="<%=id2 %>">
                     <input type="hidden" name="usrid" value="<%=usrid %>">
                    <textarea name="home_content" style="margin-top:5px;" class="form-control" rows="6" placeholder="在老乡会吱个声吧！(不超过100字)" required></textarea>
        
                <% if(m==true){ %>
                <button class="btn btn-warning btn-block"  onclick="javascript:return check(form);" style="margin-top:5px;" >
<i class="glyphicon glyphicon-send"></i>分享动态
                </button><%}else{ %>
                  <button class="btn btn-warning btn-block" disabled="disabled" style="margin-top:5px;" onclick="javascript:return check(form);">
<i class="glyphicon glyphicon-send"></i>分享动态
                </button><%} %>
                
              
                </form>
                     
                      </div>
                      <div class="panel-footer" style="height:50px;"></div>
            
              
                                         
                 
                  
     
       <%} %>
        
          </div>
          </div>
          <% 
        Integer usrid5=(Integer)session.getAttribute("userkey");
        String sql4="select *from home_news where province_id="+id2+" order by id desc ";
        ResultSet rs4=conn.exequery(sql4); 
        while(rs4.next())
        {
        int userid2=rs4.getInt("usrid");
        String sql5="select * from user_info  where usrid="+userid2+"";
        ResultSet rs5=conn.exequery(sql5);
        while(rs5.next())
        {

         %>
        <div class="col-sm-6 col-md-4" >  <div class="panel panel-default" > <div class="panel-heading" style="background:white;">  <img src="img/user2/<%=rs5.getString("head_pic") %>" class="img-circle " width="52px" height="52px"> <span class="timeline-nickname"></span></div> <a href="homenewsinfo.jsp?id=<%=rs4.getString("id")%>"><div class="panel-body" style="height:180px;color:#29747D;font-size: 14px;font-family:arial;">&nbsp;&nbsp;<%=rs4.getString("content") %></div></a><div class="panel-footer">
        <form method="post" action="news_commentt"><div class="input-group"><input class="form-control" placeholder="快速评论" name="comment" required><input type="hidden" name="newsid" value="<%=rs4.getString("id")%>"><input type="hidden" name="usrid" value="<%=usrid5%>"> <input type="hidden" name="province_id" value="<%=id2%>"><span  class="input-group-addon" style="background:white;"> <button type="submit" style="background:white;border:0"><i class="glyphicon glyphicon-comment"></i></button></span></div></form></div></div> </div>    
      

        <%}} %>
       
     
        
    
        </div>
        </div>

     
      

</body>
</html>