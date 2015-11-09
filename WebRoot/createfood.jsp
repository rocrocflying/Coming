<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="author" content="Linroid">
    <title> 添加图片   </title>
        <link media="all" type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">
        <link media="all" type="text/css" rel="stylesheet" href="css/style.min.css">
           
    
<link media="all" type="text/css" rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">


    <!--[if lt IE9]>
    <script src="http://xtuers.com/js/html5.js"></script>

    <![endif]-->
</head>
<body>
<div id="message" style="display: none;">
</div>
<!--[if lt IE9]>
<div class="container" style="margin-top: 60px">
    <div class="alert alert-danger">
        您的浏览器版本太低,无法正常使用,请升级或换用其他浏览器
        <br/>
        <ul class="list-inline">
            <li><a href="http://www.google.cn/chrome/intl/zh-CN/landing_chrome.html?hl=zh-CN">Google Chrome</a></li>
            <li><a href="http://firefox.com.cn/">火狐</a></li>
            <li><a href="http://cn.opera.com/">Opera</a></li>
            <li><a href="http://www.apple.com.cn/safari">Safari</a></li>
        </ul>
    </div>
</div>
<![endif]-->

   
       <div class="navbar navbar-default navbar-fixed-top" style="background:#FFFFFF">
      <div class="container">
        <div class="navbar-header">
          <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand hidden-sm" style="color:#5CB85C"><b>吃吧</b></a>
        </div>
         <div class="navbar-collapse collapse" role="navigation">
          <ul class="nav navbar-nav">
          <li><a href="Showfood" >美食墙</a></li>
            <li><a href="Lovefood" >猜你喜欢</a></li>
            <li><a href="FoodShowAllActivityServlet" >约吃</a></li>
          </ul>
           <ul class="nav navbar-nav navbar-right">  
           
              <li class="btn-group "> 
              <a href="#" data-toggle="dropdown" ><i class="glyphicon glyphicon-user"></i></a> 
               <ul class="dropdown-menu" role="menu"> <li><a href="Showprofile">我的资料</a></li> 
              <!--  <li><a href="http://xtuers.com/chat">我的私信</a></li> -->、            
              <li><a href="Showself_create">我发起的活动</a></li>
               <li><a href="Showjoin_act">我参与的活动</a></li>
                <li class="divider"></li> <li class="divider"></li> <li>
                  <a href="logout.jsp" >注销</a>
                </li>
                 </ul>  </li> </ul>
         </div>
      </div>
    </div>
   
 
    <div class="container" id="main">
  
    <div class="row">
    <form method="POST" action="foodServlet" enctype="multipart/form-data"  class="form-horizontal" id="create-activity-form">
 
    <div class="col-sm-6 col-md-6">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3>美食信息</h3>
            </div>
            <div class="panel-body">
                <div class="form-group">
                    <label for="title" class="col-sm-3 control-label">美食名称<span class="text-danger"> *</span> :</label>
                    <div class="col-sm-8">
                        <input id="title" type="text" value="" name="acttitle" class="form-control" placeholder="1-20字 ,如全聚德烤鸭" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-3 control-label">美食描述<span class="text-danger"> *</span> :</label>
                    <div class="col-sm-8">
                        <textarea id="description" name="actdetail" class="form-control" rows="5" placeholder="10-200字" required></textarea>
                    </div>
                </div>
                 <div class="form-group">
                    <label for="title" class="col-sm-3 control-label">地点<span class="text-danger"> *</span> :</label>
                    <div class="col-sm-8">
                        <input id="title" type="text" value="" name="actplace" class="form-control" placeholder="" required>
                    </div>
                </div>
               
                <div class="form-group">
                    <label for="cover" class="col-sm-3 control-label">选择图片<span class="text-danger"> *</span> :</label>
                    <div class="col-sm-6">
                        <input type="file" id="photo" class="text" name="image" />
                        <div id="add-pic-show" class="hidden">
                            <div class="progress" id="upload-progress">
                                <div class="progress-bar progress-bar-info" style="width: 0%"></div>
                                <span class="text-muted">0%</span>
                            </div>
                            <div id="uploaded-pic">
                                <img src="" class="img-responsive img-thumbnail center-block">
                                <a href="javascript:cancel_pic()" class="btn btn-href center-block" style="margin-top: 10px">取消图片</a>
                            </div>
                        </div>
                    </div>
                    <input name="cover" type="hidden"/>

                </div>
              
                           <input class="btn btn-lg btn-primary btn-block" id="btn-submit-create"  data-loading-text="提交中..."  type="submit" value="上传美食"/>
            
                   
               </div>
        </div>
    </div>
    <div class="col-sm-6 col-md-6">
      
       
        </div>
    </div>

    </form>
   
   
        </div>
</div>
<footer id="footer" role="contentinfo">
    <div class="container">
        <p>©2015 ynnu.com <a href="#" rel="nofollow" target="_blank">云南师范大学</a></p>
        <p>使用 <a href="http://laravel.com/" title="v4.2" rel="nofollow" target="_blank">Laravel</a>、
            <a href="http://getbootstrap.com/" title="v3.2" rel="nofollow" target="_blank">Bootstrap</a>、
            <a href="http://jquery.com/" title="1.10.2" rel="nofollow" target="_blank">JQuery</a> 快速开发
        </p>
        <p>Code by<a href="#" target="_blank">吃吧</a> 
        </p>
    </div>
    </footer>
</body>
<script src="js/jquery.min.js"></script>

<script src="js/bootstrap.min.js"></script>





<script type="application/javascript">
      $("#main").ajaxError(function(event,request, settings){ console.log(event); console.log(request); if(request.responseJSON.error != 'undefined'){ showError(request.responseJSON.error); }else if(request.responseJSON.msg != 'undefined'){ showError(request.responseJSON.msg); } }); $('#navigation').autoHidingNavbar(); </script> 
<script src="js/jquery.ui.widget.js"></script>

<script src="js/jquery.iframe-transport.js"></script>

<script src="js/jquery.fileupload.js"></script>

<script src="js/bootstrap-datetimepicker.min.js"></script>

<script src="js/bootstrap-datetimepicker.zh-CN.js"></script>

<script type="application/javascript">
//    $('#btn-submit-create').click(function(){
//        var btn = $(this);
//        btn.button('loading');
//        setTimeout(function(){
//            btn.button('reset');
//        },3000);
//    });
    function addField(){
        var field =
            '<div class="form-group"> ' +
                '<label class="col-sm-3 control-label">字段说明:</label>' +
                '<div class="col-sm-6">' +
                '   <input type="text" value="" name="fields[]" class="form-control" placeholder="如手机号码,寝室等"/>' +
                '</div>' +
                '<button type="button" class="btn btn-link" onclick="removeField(this)"><span aria-hidden="true">&times;</span><span class="sr-only">删除字段</span></button>' +
            '</div>';
        $('#fields').append(field);
    }
    function removeField(obj){
        var field = $(obj).parent();
        field.remove();
    }
    $('#start-time-picker').datetimepicker({
        'language':'zh-CN'
    });
    $('#end-time-picker').datetimepicker({
        'language':'zh-CN'
    });
    function upload_pic(){
        $('#fileupload').click();
    }
    function cancel_pic(){
        jqXHR.cancel();
        $('input[name=pic]', '#add-question-form').val('');
        $('#uploaded-pic img').src = '';
        $('#add-pic-show').addClass('hidden');
    }
    var jqXHR;
    $('#fileupload').fileupload({
        dataType: 'json',
        maxChunkSize: 10240000,//10M
        add: function (e, data) {
            jqXHR = data.submit();
            $('#add-pic-show').removeClass('hidden');
            $('#upload-progress').removeClass('hidden');
            $('#uploaded-pic').addClass('hidden');
//            compat_refresh();
        },
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            update_progress(progress);
        },
        done: function (e, data) {
            update_progress(0);
            $('input[name=cover]', '#create-activity-form').val(data.result.key);
            $('#upload-progress').addClass('hidden');
            $('#uploaded-pic').removeClass('hidden');
            $('#uploaded-pic img').attr('src', 'http://xtuer.qiniudn.com/' + data.result.key+'/cover');
//            compat_refresh();
//            compat_image_loaded();
        }
    });
    function update_progress(progress){
        $('#upload-progress span').text(progress + '%');
        $('#upload-progress .progress-bar').css(
            'width',
            progress + '%'
        );
    }
//    $('#create-activity-form').submit(function(){
//        var postData = $('#create-activity-form').serialize();
//            $.ajax({
//                url:  $('#create-activity-form').attr('action'),
//                method: 'POST',
//                data : postData,
//                success: function(data){
//                    handle_success(data);
//                },
//                error:function(request){
//                    showError(request.responseJSON.msg);
//                }
//        });
//        return false;
//    })
    $('#create-activity-form').ajaxForm();
</script>
  </html>