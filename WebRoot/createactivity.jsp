<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>约吧-找活动</title>

    <!-- Bootstrap -->
   <!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body style="background:#E0E0E0">
  
     <div class="navbar navbar-default navbar-fixed-top" style="background:#FFFFFF">
      <div class="container">
        <div class="navbar-header">
          <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand hidden-sm" style="color:#5CB85C"><b>约吧</b></a>
        </div>
        <div class="navbar-collapse collapse" role="navigation">
          <ul class="nav navbar-nav">
            <li  class="active" >
              <a href="javascript:void(0)" >表白墙</a>
            </li>
            <li><a href="hometown.jsp">老乡会</a></li>
            <li><a >找活动</a></li>
          </ul>
        </div>
      </div>
    </div>
    <br>
    <br>
     <br>
    <br>
    
  
  
  <div class="container">
   

 <div class="row">
   
    <div class="col-sm-6 col-md-6">
        <div class="panel panel-default">
            <div class="panel-heading" style="background:white">
                <h3>活动信息</h3>
            </div>
            <div class="panel-body">
                <div class="form-group" >
                    <label for="title" class="col-sm-3 control-label">活动标题<span class="text-danger"> *</span> :</label>
                    <div class="col-sm-8">
                        <input id="title" type="text" value="" name="title" class="form-control" placeholder="" required>
                    </div>
                </div>
                <div class="form-group" style="margin-top:10px">
                    <label for="description" class="col-sm-3 control-label">活动描述<span class="text-danger"> *</span> :</label>
                    <div class="col-sm-9">
                        <textarea id="description" name="description" class="form-control" rows="5" placeholder="10-2000字" required></textarea>
                    </div>
                </div>
             
                <div class="form-group">
                    <label for="location" class="col-sm-3 control-label">地点<span class="text-danger"> *</span> :</label>
                    <div class="col-sm-9">
                        <input id="location" name="location" class="form-control" type="text" value="" placeholder="" required/>
                    </div>
                </div>
               
                <div class="form-group">
                    <label for="cover" class="col-sm-3 control-label">封面图片:</label>
                    <div class="col-sm-9">
                        <button type="button" onclick="upload_pic()" class="btn btn-default">上传图片</button>
                    
                    </div>
                  

                </div>
                <div class="form-group" >
                    <label for="start-time" class="col-sm-3 control-label">开始时间<span class="text-danger"> *</span> :</label>
                    <div  id="start-time-picker" class="input-group date col-md-8 col-sm-8" data-date="" data-date-format="yyyy MM dd日 - HH:ii p" data-link-field="start-time">
                        <input class="form-control" size="16" type="text" value="" readonly>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                    </div>
                    <input type="hidden" name="start_at" id="start-time" value=""  required/><br/>
                </div>
                <div class="form-group">
                    <label for="end-time" class="col-sm-3 control-label">结束时间<span class="text-danger"> *</span> :</label>
                    <div id="end-time-picker" class="input-group date col-md-8 col-sm-8" data-date="2015-04-09 19:55:06" data-date-format="yyyy MM dd日 - HH:ii p" data-link-field="end-time">
                        <input class="form-control" size="16" type="text" value="" readonly>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                    </div>
                    <input type="hidden" name="end_at" id="end-time" value=""  required/><br/>
                </div>
        
                          
        </div>
    </div>
    </div>
    <div class="col-sm-6 col-md-6" >
    
        <div class="well" style="height:500px;">
            <h3>负责人信息</h3>
            <div class="form-group">
                <label for="name" class="col-sm-3 control-label">姓名<span class="text-danger"> *</span> :</label>
                <div class="col-sm-8">
                    <input id="name" type="text" value="" name="name" class="form-control" placeholder=""  required>
                </div>
                
            </div>
            <div class="form-group">
                <label for="tel" class="col-sm-3 control-label">电话:</label>
                <div class="col-sm-8">
                    <input id="tel" type="tel" value=""  name="tel" class="form-control" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-3 control-label">Email:</label>
                <div class="col-sm-8">
                    <input id="email" type="email" value="" name="email" class="form-control" placeholder="">
                </div>
            </div>
            <div class="form-group">
                <label for="qq" class="col-sm-3 control-label">QQ:</label>
                <div class="col-sm-8">
                    <input id="qq" type="text" value="" name="qq" class="form-control" placeholder="">
                </div>
            </div>
            <div style="margin-top:20px;"></div>
            <div class="form-group">
                <label for="wechat" class="col-sm-3 control-label">微信号:</label>
                <div class="col-sm-8">
                    <input id="wechat" type="text" value="" name="wechat" class="form-control" placeholder="">
                </div>
            </div>
        </div>
        <input class="btn btn-lg btn-primary btn-block" id="btn-submit-create"  data-loading-text="提交中..." type="submit" value="创建活动"/>
    </div>
</div>

</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  </body>
</html>