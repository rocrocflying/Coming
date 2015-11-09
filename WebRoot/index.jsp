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


 <script>
function checkfrom(){
	var from = document.getElementById("from").value.trim();
	if(from == null || from == ""){
	alert("请输入本人名字 !");
	return false;
	}
	return true;
}

function checkto(){
	var to = document.getElementById("to").value.trim();
	if(to == null || to ==""){
	alert("请输入表白对象 ！");
	return false;
	}
	return true;
}



function checkcontent(){
	var content= document.getElementById("content").value.trim();
	if(content == null || content ==""){
	alert("请填写表白内容 ！");
	return false;
	}
	if(content.length>99){
	alert("表白内容不能超过99字 ！");
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


function checkAll(){

	if(checkfrom() && checkto()&&checkcontent()){
		return true;
	}
	return false;
}
</script>
 

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
    <div class="container">

        <div class="row">
        
         <div class="col-sm-6 col-md-4 " >
            <div class="well" style="height:330px;">
                                <form method="post" action="check_content.jsp" onsubmit="return checkAll();" >
                                
                    <img src="img/bb.png" class="img-responsive">
               
                    <div class="input-group">
                     <span class="input-group-addon" ><i class="fa fa-user"></i></span>
                     <input type="text"  class="form-control" name="from"   id="from" placeholder="From:(你本人名字或昵称)" >
                     </div>
                      <div class="input-group" style="margin-top:5px;">
                    <span class="input-group-addon" ><i class="fa fa-male"></i></span>
                    <input type="text" class="form-control"  name="to" id="to" placeholder="To:(被表白的对象名字或昵称)"  required>
                    </div>
                    <textarea name="content"  id="content" style="margin-top:5px;" class="form-control" rows="6" placeholder="爱意一吐为尽(不超过99字)" required></textarea>
        
              
                <button class="btn btn-danger btn-block" style="margin-top:5px;background:#E6302B" >
<i class="glyphicon glyphicon-send"></i>大胆表白
                </button>
                
              
                </form>

              </div>
        </div>
 
        <% 
        Integer usrid=(Integer)session.getAttribute("userkey");
        String sql="select *from love_info  order by id desc ";
        ResultSet rs=conn.exequery(sql); 
        while(rs.next())
        {
        String id=rs.getString("usrid");
        String sql2="select *from user_info  where usrid="+id+"";
        ResultSet rs2=conn.exequery(sql2);
        while(rs2.next())
        {
         int id3=rs.getInt("id");
    
         %>
         <script>
 $(document).ready(function(){
$("#a<%=id3%>").click(function()
{
    // 如果参数值来自文本框（ID为linkId），采用以下方式取值
 

    $.ajax({
        url:"Praise",
        type:"post",
        dataType:"html", // 假设获取到的响应是json格式的字符串。
        data:{
        loveid:<%=rs.getString("id")%>,
        userid:<%=usrid %>
 
        },
        success:function(data) {
            // data 就是响应返回的数据。你可以对它进行处理。
           if(data=='qwe')
           {
           alert("已点过赞,请勿重复点赞");
        $("#a<%=rs.getString("id")%>").html("<font color='red'><i class='fa fa-thumbs-o-up '></i></font>");
      
          }
          else
          {
            alert("点赞成功");
          $("#a<%=rs.getString("id")%>").html("<font color='red'><i class='fa fa-thumbs-o-up '></i></font>");
          $("#b<%=rs.getString("id")%>").text(data);
          }
       
        },
        error:function(xhr,msg,e) {
            // ajax发送请求出错，在这个回调函数里进行处理，如显示提示信息，弹出警告框等
             alert('已点过赞，请勿重复点赞!');
        }
    })
});

});

</script>
       <% 
        boolean praise=false;
        String sql3="select *from love_praise where  love_id="+id3+" and usrid="+usrid+"";
        ResultSet rs3=conn.exequery(sql3); 
        while(rs3.next())
        {
         praise=true;
        }%>
        
        
        <div class="col-sm-6 col-md-4 col-lg-4" >  <div class="panel panel-default" > <div class="panel-heading" style="background:white;">  <img src="img/user2/<%=rs2.getString("head_pic") %>" class="img-circle " width="32px" height="36px"> <span class="timeline-nickname"><b><%=rs2.getString("usrnm") %></b></span><span class="text-muted" style="float:right;font-size:13px;"><%=rs.getString("love_date").substring(0,16) %> <i class="fa fa-clock-o"></i></span></div> <a href="ybinfo.jsp?id=<%=rs.getString("id")%>">
        <div class="panel-body" style="height:180px;background-image:url(img/bg31.png);color:#29747D;font-size: 14px;font-family:arial;"><span style="float:left" class="label label-danger"><b>To:</b><%=rs.getString("bbb_user") %></span><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=rs.getString("love_text") %><br><br><div></div></div> </a><div class="panel-footer "  style="height:40px;background:white;"><span style="float:right;" class="label label-success"><b>From:</b><%=rs.getString("bb_user") %></span><%if(session.getAttribute("userkey")!=null) { if(praise==false){%><a  id="a<%=rs.getString("id")%>"><i class="fa fa-thumbs-o-up "></i></a> <%}else{%><a  id="a<%=rs.getString("id")%>" disabled="disabled" style="color:red;"><i class="fa fa-thumbs-o-up "></i></a> <%} %> <span id="b<%=rs.getString("id")%>"><%=rs.getInt("love_good") %></span><a href="ybinfo.jsp?id=<%=rs.getString("id") %>" ><i style="margin-left:35px"class="glyphicon glyphicon-comment"></i></a><%}else{ %><a  onclick="javascript:alert('亲，登录后才能点赞哦');"><i class="fa fa-thumbs-o-up "></i></a> <span><%=rs.getInt("love_good") %></span><a  style="margin-left:45px;"onclick="javascript:alert('亲，登录后才能评论哦');"><i class="glyphicon glyphicon-comment"></i></a><%} %></div></div> </div>    
        
        <%}} %>
       
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