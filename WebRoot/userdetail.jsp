<%@ page language="java" import="java.util.*,cn.edu.ynnu.laibar.taobar.model.*,cn.edu.ynnu.laibar.taobar.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

ArrayList al=new ArrayList();
UserBean ab=new UserBean();
al=(ArrayList)request.getAttribute("userdetail");
ab=(UserBean)al.get(0);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="js/bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="js/bootstrap/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap/js/bootstrap.min.js"></script>
	 <script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>
    <script type="text/javascript" src="js/payfor.js"></script>
  </head>
  
  <body>
   <body style="background:#E0E0E0">
   <jsp:include page="head.jsp"></jsp:include>
  <br>  <br>  <br>
  <div class="container" >
	<div class="row clearfix">
		<div class="col-md-12 column">
		<form action="" method="post">
			<table class="table table-bordered" style="background:#fff">		
			<tbody>
							<tr>
								<td colspan="2">
								<center>
								<img alt="" src="img/img_users/<%=ab.getHead_pic() %>"  width="60%" height="200">	
								</center>
								
								</td>		
							</tr>
							<tr >
								<td >
									用户名:
								</td>	
								<td>
									<%=ab.getUserName() %>
								</td>	
							</tr>
							
							<tr>
								<td >
									密码:
								</td>
								<td>
								<div><strong id=""><%=ab.getPassword() %></strong></div>
								</td>
							</tr>	
								
							<tr >
							<td >
									学号:
							</td>
								<td>	
									<div><strong id=""><%=ab.getStudentId() %></strong></div>	
								</td>	
							</tr>		
							
							<tr >
							<td >
									年龄:
							</td>
								<td>	
									<div><strong id=""><%=ab.getAge() %></strong></div>	
								</td>	
							</tr>	
							
							<tr >
							<td >
									专业:
							</td>
								<td>	
									<div><strong id=""><%=ab.getMajor() %></strong></div>	
								</td>	
							</tr>	
							
							<tr >
							<td >
									学校:
							</td>
								<td>	
									<div><strong id=""><%=ab.getSchool() %></strong></div>	
								</td>	
							</tr>	
							
							<tr >
							<td >
									民族:
							</td>
								<td>	
									<div><strong id=""><%=ab.getNation() %></strong></div>	
								</td>	
							</tr>	
							
							<tr >
							<td >
									真实姓名:
							</td>
								<td>	
									<div><strong id=""><%=ab.getRealname() %></strong></div>	
								</td>	
							</tr>	
							
							<tr >
							<td >
									性别:
							</td>
								<td>	
									<div><strong id=""><%=ab.getSex() %></strong></div>	
								</td>	
							</tr>	
							
							
							
							<tr >
							<td >
									住址:
							</td>
								<td>	
									<div><strong id=""><%=ab.getAddress() %></strong></div>	
								</td>	
							</tr>	
							
							<tr >
							<td >
									电话:
							</td>
								<td>	
									<div><strong id=""><%=ab.getPhone() %></strong></div>	
								</td>	
							</tr>	
							
							<tr >
							<td >
									qq:
							</td>
								<td>	
									<div><strong id=""><%=ab.getQq() %></strong></div>	
								</td>	
							</tr>	
							
							<tr >
							<td >
									简介:
							</td>
								<td>	
									<div><strong id=""><%=ab.getBrief() %></strong></div>	
								</td>	
							</tr>	
							
							<tr >
								<td >
									注册日期:
								</td>
								<td>	
									<div><strong id=""><%=ab.getRegist_date() %></strong></div>	
								</td>	
								
							</tr>	
							
							<tr>
								<td width="35%">
									<a href="editUser.jsp" <button>编辑</button>></a>  
								</td>
								<td>
								
								</td>
							</tr>
						</tbody>																					
			

					</table>
				   </form>	
				</div>
			</div>
		</div>
	
  </body>
</html>
