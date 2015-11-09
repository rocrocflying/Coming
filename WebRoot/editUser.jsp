<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>编辑用户信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<<link rel="stylesheet" type="text/css" href="js/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="js/bootstrap/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/validate.js"></script>
	<script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
	<script type="text/javascript" src="js/payfor.js"></script>

  </head>
  
  <body style="background:#E0E0E0">
  <jsp:include page="head.jsp"></jsp:include>
  <br>  <br>  <br>
  <div class="container">
	<div class="row clearfix">
	 <div class="col-md-12 column">
	
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						个人信息编辑
					</h3>
				</div>
				<div class="panel-body">
					 <form class="form-inline" action="EditUserServlet?flag=edit" method="post" onsubmit="return validate_form(this);" enctype="multipart/form-data" >      
						 &nbsp头像： <input type="file" name="photo" id="photo" class="form-control"><br>
						 &nbsp用户名：<input type="text" name="username" id="username" class="form-control"><br>
						 &nbsp密码：<input type="text" class="form-control" name="password" id="password"  ><br>
						 &nbsp学号：<input type="text" class="form-control" name="studentId" id="studentId"  ><br>
						 &nbsp年龄：<input type="text" class="form-control" name="age" id="age"  ><br>
						 &nbsp专业：<input type="text" class="form-control" name="major" id="major"  ><br>
						 &nbsp学校：<input type="text" class="form-control" name="school" id="school"  ><br>
						 &nbsp民族：<input type="text" class="form-control" name="nation" id="nation"  ><br>
						 &nbsp真实姓名：<input type="text" class="form-control" name="realname" id="realname"  ><br>
						 &nbsp性别：<input type="text" class="form-control" name="sex" id="sex"  ><br>
						 &nbsp住址：<input type="text" class="form-control" name="address" id="address"  ><br>
						 &nbsp电话：<input type="text" class="form-control" name="phone" id="phone"  ><br>
						 &nbsp QQ：<input type="text" class="form-control" name="qq" id="qq"  ><br>
						 &nbsp籍贯：<input type="text" class="form-control" name="nativePlace" id="nativePlace"  ><br>
						 &nbsp简介：<input type="text" class="form-control" name="brief" id="brief"  ><br>
						
						<input type="submit" class="btn btn-default btn-block  btn-success">   
						<input type="reset" class="btn btn-default btn-block btn-warning">
					 </form> 
				</div>
			</div>
		</div>
	</div>
</div>
  </body>
</html>
