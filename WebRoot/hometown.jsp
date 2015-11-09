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
<!--[if lt IE 9]>
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
   <![endif]-->
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
    <div class="container">

        <div class="row">
        
         <div class=" col-sm-6 col-md-4 ">
            <div class="panel panel-default" style="height:360px;">
              
                   <div class="panel-heading">
                <h4 style="color:#5CB85C"><b><i class="glyphicon glyphicon-bullhorn"></i> 童鞋们，还再等什么，快来加入老乡会,一起乡聚吧！ </b></h4>
                    </div>  
                      <div class="panel-body">
                
                    <button class="btn btn-default btn-block">
                     <select  class="form-control" name="from" onchange="MM_jumpMenu('parent',this,0)">
                           <option selected >选择查看老乡会</option>
                          <% 
                          request.setCharacterEncoding("utf-8");
                         String sql="select *from province order by id desc ";
                         ResultSet rs=conn.exequery(sql); 
                         while(rs.next())
                          {
                          %>
                    
                   <option value="hometown.jsp#<%=rs.getString("id")%>"><%=rs.getString("name") %></option>
                 
                      <%} %>
                       </select>
                       </button>
               
                    <% if(session.getAttribute("userkey")!=null){
                 
                        int usrid=(Integer)session.getAttribute("userkey");
                  
                     
                         String sql6="select *from user_info where usrid="+usrid+"";
                         ResultSet rs6=conn.exequery(sql6);
                          String home=null;
                         while(rs6.next())
                          {
                            home=rs6.getString("homet");
                          }
              
                         String sql5="select * from province where name='"+home+"'";
                         ResultSet rs5=conn.exequery(sql5);
                         
                         while(rs5.next())
                          {
                          %>
                
                 
                   
                    
          
                     <button class="btn btn-danger btn-block" style="margin-top:5px;" onclick="javascript:window.location.href='homeinfo.jsp?id=<%=rs5.getInt("id")%>'"><i class="glyphicon glyphicon-log-in"></i> 直接进入我的老乡会</button>
                    <%}}else{ %>
                      <button class="btn btn-danger btn-block" style="margin-top:5px;"  onclick="javascript:alert('您还没登录噢o')"><i class="glyphicon glyphicon-log-in"></i> 直接进入我的老乡会</button>
                    <%} %>
                       
                     <img src="img/home.png" style="margin-top:5px;" class="img-responsive">
                      </div>
                     <div class="panel-footer" style="color:#ECAF24;text-align:center;font-family: Microsoft YaHei"><b>在这里，相聚不再是一件难事！</center></b>
   

              </div>
              </div>
              
                               
           
        </div>
       
         <% 
        String sql2="select *from province ";
        ResultSet rs2=conn.exequery(sql); 
        while(rs2.next())
        {
        %>
        <%if(rs2.getString("name").contains("云南")){ %> 
         <div class="col-sm-6 col-md-4 col-lg-4" ">  <a id="<%=rs2.getString("id")%>"> <div class="panel panel-default" > <div class="panel-heading" style="background:white;" >  <span class="label label-danger" style="width:140px;margin-top:5px;"><i class="glyphicon glyphicon-map-marker"></i><%=rs2.getString("name") %></span>
                     </div> <div class="panel-body" ><img src="img/yn/<%=rs2.getString("pic") %>" class="img-responsive"></div><div class="panel-footer" style="height:50px"><a href="homeinfo.jsp?id=<%=rs2.getString("id") %>"><button class="btn btn-default" style="float:right;" >查看详情</button></a></div></div></a></div>  
                     <%}else{ %>
       <div class="col-sm-6 col-md-4 col-lg-4" ">  <a id="<%=rs2.getString("id")%>"> <div class="panel panel-default" > <div class="panel-heading" style="background:white;" >  <span class="label label-danger" style="width:140px;margin-top:5px;"><i class="glyphicon glyphicon-map-marker"></i><%=rs2.getString("name") %></span>
                     </div> <div class="panel-body" ><img src="img/<%=rs2.getString("pic") %>" class="img-responsive"></div><div class="panel-footer" style="height:50px"><a href="homeinfo.jsp?id=<%=rs2.getString("id") %>"><span class="btn btn-default" style="float:right;">查看详情</span></a></div></div></a></div>  
         
        <%}} %>
 
        
      <a id="scrollUp" href="#top" style="position: fixed; z-index: 2147483647; display: block;background-color: white;color: #777;font-size: 10px;
line-height: 1;
text-align: center;
text-decoration: none;
bottom: 20px;
right: 20px;
overflow: hidden;
width: 35px;
height: 35px;
border: none;"><i class="fa fa-chevron-up fa-2x"></i></a>
<br><br>
<br>
        </div>
        </div>

     
      

</body>
</html>