<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>约吧-表白墙</title>
     <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
     <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">
     <link rel="stylesheet" type="text/css" href=css/style.min.css">
     <script src="bootstrap/jquery.min.js"></script>
     <script src="bootstrap/js/bootstrap.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</script>
<script>
function post()
{
    // 如果参数值来自文本框（ID为linkId），采用以下方式取值
    var linkId=$('#linkId').val();
    $.ajax({
        url:"test2.jsp",
        type:"post",
        dataType:"text", // 假设获取到的响应是json格式的字符串。
        data:"LinkId="+linkId,
        success:function(data) {
            // data 就是响应返回的数据。你可以对它进行处理。
           alert('dvgdg'+data);
        },
        error:function(xhr,msg,e) {
            // ajax发送请求出错，在这个回调函数里进行处理，如显示提示信息，弹出警告框等
        }
    })
}
</script>
  </head>
  
  <body>
<a href="#" onclick="post(); ">发送请求</a>
LinkId:<input type="text" id="linkId" value="" />
<p>dgsdgdsgdsg</p>

  </body>
</html>
