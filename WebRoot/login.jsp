<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请登录</title>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
      <script src="html5shiv.js"></script>
     <![endif]-->

</head>
<body style="background:#E0E0E0">
<jsp:useBean id="conn" scope="page" class="yb.conn"/>



    <br>
    <br>
     <br>
    <br>
    <div class="container">
 
     <div class="col-md-offset-3 panel col-sm-6 col-md-6">
         <div class="panel panel-default">
         <div class="panel-heading" style="background:white;" >
         <form method="post" action="Login">
               
              
                <h4 style="color:#5CB85C"><b>用户登录</b></h4><hr>
   
         
                    <div class="input-group">
                     <span class="input-group-addon" ><i class="fa fa-user"></i></span>
                     <input type="text"  class="form-control" name="stnum" placeholder="输入用户昵称登录" required autofocus>
                     </div>
                      <div class="input-group" >
                    <span class="input-group-addon" ><i class="fa fa-key"></i></span>
                    <input type="password" class="form-control"  name="psw" placeholder="密码" required>
                    </div>
                
                   <button class="btn btn-primary btn-block" style="margin-top:12px;"  type="submit"  >
                                                          登录
                </button>
                
  
                  <input class="btn btn-success btn-block" onclick="javascript:window.location.href='register.jsp'"  style="margin-top:2px;" value="注册"   >
                                                    
             
                
          </div>
               
            </div>
               
     </div>
      </form>
       </div>
        </div>


      

</body>
</html>