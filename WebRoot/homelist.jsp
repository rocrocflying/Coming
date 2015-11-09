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
	if(form.to.value=='')
	{
	alert("亲，还没输入表白对象额!");form.content.focus();
	return false;
	} 
 if(form.to.value.length>8)
{
	 alert("内容超出8个字!");form.content.focus();
		return false;
}
 if(form.from.value=='')
	{
	alert("亲，还没输入你名称额!");form.content.focus();
	return false;
	} 
if(form.from.value.length>8)
{
	 alert("内容超出8个字!");form.content.focus();
		return false;
}
if(form.content.value=='')
	{
	alert("亲，还没输入内容额!");form.content.focus();
	return false;
	} 
 if(form.content.value.length>140)
{
	 alert("亲，有的时候爱意太浓反而不能足够表达爱意，字数超过140字!");form.content.focus();
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
            <li><a href="findactivity.jsp">找活动</a></li>
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
        String sql="select *from province  where id="+id2+"";
        ResultSet rs=conn.exequery(sql); 
      
        while(rs.next())
        {
       
       
    
     %>
    <div class="container">

        <div class="row">
        
         <div class=" col-sm-6 col-md-4 ">
            <div class="panel panel-default" >
              
                   <div class="panel-heading">
                <h4 style="color:#5CB85C"><b><i class="glyphicon glyphicon-map-marker"></i><font color="red"><%=rs.getString("name") %></font> 老乡会</b></h4>
                    </div>  
                      <div class="panel-body">
                      <%if(rs.getString("name").contains("云南"))
                      {
                      %>
                     <img src="img/yn/<%=rs.getString("pic") %>" style="margin-top:5px;" class="img-responsive">
                     <%}else{ %>
                       <img src="img/<%=rs.getString("pic") %>" style="margin-top:5px;" class="img-responsive">
                     <%} %>
                      </div>
                      <div class="panel-footer" style="height:50px;"><button style="float:left;" onclick="javascript:window.location.href='hometown.jsp';"class="btn btn-success">< 返回老乡会主页</button><button style="float:right;" class="btn btn-primary">查看老乡信息列表</button></div>
              </div>
              
                                         
           
        </div>
       <%} %>
         <% 
         boolean k=false;
         request.setCharacterEncoding("utf-8");
         int id=Integer.parseInt(request.getParameter("id").toString());
     
        String sql3="select *from province  where id="+id+"";
        ResultSet rs3=conn.exequery(sql3); 
        String province=null;
        while(rs3.next())
        {
         province=rs3.getString("name");
        }
       
        String sql2="select *from user_info  where homet='"+province+"'";
        ResultSet rs2=conn.exequery(sql2); 
        while(rs2.next())
        {
            k=true;
        %>
     
         <div class="col-sm-6 col-md-4 col-lg-4" >  <div class="panel panel-default" > <div class="panel-heading" style="background:white">  <img src="img/user2/<%=rs2.getString("head_pic") %>" class="img-circle " width="42px" height="42px"> <span  class="label label-danger"><%=rs2.getString("usrnm") %>&nbsp;&nbsp; <%if(rs2.getString("sex").equals("男生")){ %> <span><i class="fa fa-mars fa-1x"></i></span><%}else{ %><span ><i class="fa fa-venus"></i></span><%} %></div> <div class="panel-body" ><div class="input-group"></div></div></div> </div>    
 
       <%} 
         if(k==false)
       {
       %>
       <div class="col-sm-6 col-md-4 col-lg-4" >  <div class="alert alert-warning"><p><b>该老乡会暂时没有用户，赶紧去邀请认识的<font color="red"><%=province %></font>小伙伴加入吧！</b></p></div></div>
       <% 
       }
       %>
     
        </div>
        </div>

     
      

</body>
</html>