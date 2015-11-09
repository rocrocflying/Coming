<%@ 
page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css">
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script>

function check_form(form)
{
//判断昵称
if(form.nickname.value.trim()==null || form.nickname.value.trim()=='')
{
alert("昵称不能为空");
  form.nickname.focus();
  return false;
}
//判断真实姓名
if(/^[\u4e00-\u9fa5]+$/i.test(form.rname.value)){

}
else
{
if(form.rname.value=='')
{
}
else
{
alert("真实姓名必须为中文");
form.rname.focus();
  return false;
}
}
//判断学号
if(isNaN(form.stuid.value.trim()) ||form.stuid.value.trim()==null || form.stuid.value.trim()=='')
{
  alert("学号必须为数字且不能为空");
  form.stuid.focus();
  return false;
 
}
//判断密码
if(form.password.value.trim()==null || form.password.value.trim()=='')
{
alert("密码不能为空");
  form.password.focus();
  return false;
}
else
{
 if(form.password.value.length>16)
{
alert('密码长度为大于16位');
form.password.focus();
  return false;
}
 if(form.password.value.length<6)
{
alert('密码长度不能少于6位');
form.password.focus();
  return false;
}
if(form.password.value!=form.password2.value)
{
alert('两次密码不一致');
form.password2.focus();
  return false;
}
}
//判断是否选择性别
var sex=document.getElementById("sex");
if(!sex.value){
alert("请选择性别！");
return false;

}
//判断年龄
if(form.age.value.trim()==null || form.age.value.trim()=='')
{
  
}
else
{
if(isNaN(form.age.value.trim()))
{
  alert("年龄必须为数字且不能为空");
  form.age.focus();
  return false;
 
}
if(form.age.value<1 || form.age.value>100)
{
alert('年龄输入不合法');
form.age.focus();
  return false;
}
}

//判断民族
if(/^[\u4e00-\u9fa5]+$/i.test(form.nation.value)){

}
else
{
if(form.nation.value=='')
{
}
else
{
alert("民族必须为中文");
form.nation.focus();
  return false;
}
}

//判断住址
if(/^[\u4e00-\u9fa5]+$/i.test(form.addr.value)){

}
else
{
if(form.addr.value=='')
{
}
else
{
alert("住址必须为中文");
form.addr.focus();
  return false;
}
}
//判断qq

if(isNaN(form.qq.value))
{
  alert("qq必须为数字");
  form.qq.focus();
  return false;
 
}
if(form.tx.value=="")
{
 alert("请上传头像");
  form.tx.focus();
  return false;
}
if(form.school.value=="")
{
 alert("请选择学校!");
  form.school.focus();
  return false;
}
if(form.major.value=="")
{
 alert("请选择专业!");
  form.major.focus();
  return false;
}
if(form.province.value=="")
{
 alert("请选择籍贯!");
  form.province.focus();
  return false;
}
if(form.pnum.value.trim()==null || form.pnum.value.trim()=='')
{
  
}
else
{
if(isNaN(form.pnum.value))
{
  alert("手机号码必须为数字");
  form.pnum.focus();
  return false;
 
}
if(form.pnum.value.length!=11)
{
  alert("手机号码输入不规范");
  form.pnum.focus();
  return false;
 
}
}
form.submit();
}
</script>

  </head>
  <jsp:useBean id="conn" scope="page" class="yb.conn"/>
  <body style="background:#E0E0E0">

    <br><br><br>
    <div class="container" >
    <div class="col-sm-offset-3  panel col-sm-6">
    <div class="panel panel-default">
    <div class="panel-heading" style="background:white;">
            <h4 style="color:#F65F6B"><b>用户注册</b></h4> 
    </div>
     <div class="panel-body">
     <div class="alert alert-success">
         
                <p>填入以下信息立即加入<strong>吃、约、淘</strong>吧！</p><p style="color:#F65F6B"><b>注：带*的为必填选项</b></p></div>
            <form method="POST" action="Register" accept-charset="UTF-8" class="form-horizontal" enctype="multipart/form-data" ><input name="_token" type="hidden" value="SkSs8PprowKjAlIckdkKP7AkociT1KU5TF5YHL45">
            <div class="form-group">
                <label for="nickname" class="col-sm-3 control-label"><span style="color:#F65F6B;">*</span> 昵称:</label>
                <div class="col-sm-5">
                    <input type="text" value="" name="nickname" class="form-control" id="nickname" placeholder="输入昵称" >
                </div>
            </div>
            <div class="form-group">
                <label for="rname" class="col-sm-3 control-label">真实姓名:</label>
                <div class="col-sm-5">
                    <input type="text" name="rname" class="form-control" id="rname" placeholder="输入真实姓名">
                </div>
            </div>
            <div class="form-group">
                <label for="stuid" class="control-label col-sm-3"><span style="color:#F65F6B;">*</span> 学号:</label>
                 <div class="col-sm-5">
                    <input type="text" name="stuid" class="form-control" id="stuid" placeholder="输入学号，将作为登陆账号" >
                </div>
                </div>
           
            <div class="form-group">
                <label for="password" class="col-sm-3 control-label"><span style="color:#F65F6B;">*</span> 登陆密码:</label>
                <div class="col-sm-5">
                    <input type="password" name="password" class="form-control" id="password" placeholder="6-16位" >
                </div>
            </div>
            <div class="form-group">
                <label for="password2" class="col-sm-3 control-label"><span style="color:#F65F6B;">*</span> 确认密码:</label>
                <div class="col-sm-5">
                    <input type="password" name="password2"  class="form-control" id="password_confirmation" placeholder="确认密码" >
                </div>
            </div>
              <div class="form-group">
            <label for="sex" class="control-label col-sm-3"><span style="color:#F65F6B;">*</span>性别: </label>
                <div class="col-sm-5">
                    <select  name="sex" class="form-control gender" id="sex">
                        <option value="" selected>请选择</option>
                        <option value="男生">男生</option>
                        <option value="女生">女生</option>
                    </select>
                </div>
            </div>
             <div class="form-group">
                <label for="age" class="control-label col-sm-3">年龄: </label>
                 <div class="col-sm-5">
                    <input type="text" name="age" class="form-control"  placeholder="输入年龄" >
                </div>
                </div>
                  <div class="form-group">
                <label for="nation" class="control-label col-sm-3">民族: </label>
                 <div class="col-sm-5">
                    <input type="text" name="nation" class="form-control" placeholder="输入民族">
                </div>
                </div>
                  <div class="form-group">
                <label for="addr" class="control-label col-sm-3">住址: </label>
                 <div class="col-sm-5">
                    <input type="text" name="addr" class="form-control"  placeholder="输入住址">
                </div>
                </div>
                  <div class="form-group">
                <label for="qq" class="control-label col-sm-3">QQ: </label>
                 <div class="col-sm-5">
                    <input type="text" name="qq" class="form-control"  placeholder="输入qq">
                </div>
                </div>
                  <div class="form-group">
                <label for="tx" class="control-label col-sm-3"><span style="color:#F65F6B;">*</span> 头像: </label>
                 <div class="col-sm-5">
                    <input type="file" name="tx" class="form-control" >
                </div>
                </div>
                  <div class="form-group">
                <label for="school" class="control-label col-sm-3"><span style="color:#F65F6B;">*</span>学校: </label>
                 <div class="col-sm-5">
                     <select id=""  name="school" class="form-control prov" >
                     <option value="">请选择学校</option>
                      <% 
                         String sql1="select *from school";
                         ResultSet rs2=conn.exequery(sql1); 
                         while(rs2.next())
                          {
                          %>
                    
                   <option value="<%=rs2.getString("name") %>"><%=rs2.getString("name") %></option>
                 
                      <%} %>
                    </select>
                </div>
                </div>
            <div class="form-group">
                <label for="major" class="control-label col-sm-3"><span style="color:#F65F6B;">*</span> 专业: </label>
                <div class="col-sm-5">
                    <select id="major" name="major" class="form-control major">
                        <option value="">请选择专业</option>
                                                <option value="高分子材料与工程">高分子材料与工程</option>
                                                <option value="高分子材料">高分子材料</option>
                                                <option value="食品科学与工程">食品科学与工程</option>
                                                <option value="金融学（国际）">金融学（国际）</option>
                                                <option value="金融学">金融学</option>
                                                <option value="金属材料工程">金属材料工程</option>
                                                <option value="采矿工程（本）">采矿工程（本）</option>
                                                <option value="采矿工程">采矿工程</option>
                                                <option value="酒店管理">酒店管理</option>
                                                <option value="通信工程">通信工程</option>
                                                <option value="过程装备与控制工程">过程装备与控制工程</option>
                                                <option value="软件工程">软件工程</option>
                                                <option value="财务管理">财务管理</option>
                                                <option value="计算机网络技术">计算机网络技术</option>
                                                <option value="计算机科学与技术">计算机科学与技术</option>
                                                <option value="计算机应用技术">计算机应用技术</option>
                                                <option value="计算机信息管理">计算机信息管理</option>
                                                <option value="视觉传达设计">视觉传达设计</option>
                                                <option value="西班牙语">西班牙语</option>
                                                <option value="行政管理">行政管理</option>
                                                <option value="药学">药学</option>
                                                <option value="英语">英语</option>
                                                <option value="艺术设计学">艺术设计学</option>
                                                <option value="艺术设计">艺术设计</option>
                                                <option value="自动化">自动化</option>
                                                <option value="能源与动力工程">能源与动力工程</option>
                                                <option value="翻译">翻译</option>
                                                <option value="网络工程">网络工程</option>
                                                <option value="编辑出版学">编辑出版学</option>
                                                <option value="统计学">统计学</option>
                                                <option value="经济学">经济学</option>
                                                <option value="社会学">社会学</option>
                                                <option value="矿山机电">矿山机电</option>
                                                <option value="矿井通风与安全技术">矿井通风与安全技术</option>
                                                <option value="知识产权">知识产权</option>
                                                <option value="电子商务">电子商务</option>
                                                <option value="电子信息科学与技术（">电子信息科学与技术（</option>
                                                <option value="电子信息科学与技术">电子信息科学与技术</option>
                                                <option value="电子信息工程">电子信息工程</option>
                                                <option value="生物工程">生物工程</option>
                                                <option value="环境科学">环境科学</option>
                                                <option value="环境工程">环境工程</option>
                                                <option value="环保设备工程">环保设备工程</option>
                                                <option value="物理学">物理学</option>
                                                <option value="煤矿开采技术">煤矿开采技术</option>
                                                <option value="焊接技术与工程">焊接技术与工程</option>
                                                <option value="热能与动力工程">热能与动力工程</option>
                                                <option value="测绘工程(本）">测绘工程(本）</option>
                                                <option value="测绘工程">测绘工程</option>
                                                <option value="测控技术与仪器">测控技术与仪器</option>
                                                <option value="法语">法语</option>
                                                <option value="法学">法学</option>
                                                <option value="汉语言文学">汉语言文学</option>
                                                <option value="汉语国际教育">汉语国际教育</option>
                                                <option value="检测技术与应用">检测技术与应用</option>
                                                <option value="档案学">档案学</option>
                                                <option value="材料科学与工程">材料科学与工程</option>
                                                <option value="材料物理">材料物理</option>
                                                <option value="材料成型及控制工程">材料成型及控制工程</option>
                                                <option value="材料化学">材料化学</option>
                                                <option value="机电一体化技术">机电一体化技术</option>
                                                <option value="机械设计制造及其自动">机械设计制造及其自动</option>
                                                <option value="日语">日语</option>
                                                <option value="旅游管理">旅游管理</option>
                                                <option value="新闻学">新闻学</option>
                                                <option value="新能源材料与器件">新能源材料与器件</option>
                                                <option value="文秘">文秘</option>
                                                <option value="文化产业管理">文化产业管理</option>
                                                <option value="数学类（韶峰班）">数学类（韶峰班）</option>
                                                <option value="数学与应用数学">数学与应用数学</option>
                                                <option value="数字出版">数字出版</option>
                                                <option value="政治学与行政学">政治学与行政学</option>
                                                <option value="思想政治教育">思想政治教育</option>
                                                <option value="德语">德语</option>
                                                <option value="微电子科学与工程">微电子科学与工程</option>
                                                <option value="微电子学">微电子学</option>
                                                <option value="建筑设施智能技术">建筑设施智能技术</option>
                                                <option value="建筑电气与智能化">建筑电气与智能化</option>
                                                <option value="建筑环境与设备工程">建筑环境与设备工程</option>
                                                <option value="建筑环境与能源应用工">建筑环境与能源应用工</option>
                                                <option value="建筑工程技术">建筑工程技术</option>
                                                <option value="应用电子技术">应用电子技术</option>
                                                <option value="应用化学">应用化学</option>
                                                <option value="广播电视新闻学">广播电视新闻学</option>
                                                <option value="广播电视学">广播电视学</option>
                                                <option value="广告学">广告学</option>
                                                <option value="市场营销">市场营销</option>
                                                <option value="工程测量技术">工程测量技术</option>
                                                <option value="工程测量（煤矿测量与">工程测量（煤矿测量与</option>
                                                <option value="工程力学">工程力学</option>
                                                <option value="工商管理(国际)">工商管理(国际)</option>
                                                <option value="工商管理">工商管理</option>
                                                <option value="工业设计">工业设计</option>
                                                <option value="导游">导游</option>
                                                <option value="对外汉语(文)">对外汉语(文)</option>
                                                <option value="对外汉语(外)">对外汉语(外)</option>
                                                <option value="对外汉语">对外汉语</option>
                                                <option value="审计学">审计学</option>
                                                <option value="安全工程(本）">安全工程(本）</option>
                                                <option value="安全工程">安全工程</option>
                                                <option value="土木工程(道路与桥梁">土木工程(道路与桥梁</option>
                                                <option value="土木工程(建筑工程方">土木工程(建筑工程方</option>
                                                <option value="土木工程(岩土与地下">土木工程(岩土与地下</option>
                                                <option value="土木工程">土木工程</option>
                                                <option value="图书馆学">图书馆学</option>
                                                <option value="国际经济与贸易(国际">国际经济与贸易(国际</option>
                                                <option value="国际经济与贸易">国际经济与贸易</option>
                                                <option value="国际政治">国际政治</option>
                                                <option value="国际事务与国际关系">国际事务与国际关系</option>
                                                <option value="商务英语">商务英语</option>
                                                <option value="哲学">哲学</option>
                                                <option value="历史学">历史学</option>
                                                <option value="化学工程与工艺">化学工程与工艺</option>
                                                <option value="化学">化学</option>
                                                <option value="动画">动画</option>
                                                <option value="制药工程">制药工程</option>
                                                <option value="公共事业管理">公共事业管理</option>
                                                <option value="信息管理与信息系统">信息管理与信息系统</option>
                                                <option value="信息与计算科学">信息与计算科学</option>
                                                <option value="供热通风与空调工程">供热通风与空调工程</option>
                                                <option value="会计电算化(国际)">会计电算化(国际)</option>
                                                <option value="会计电算化">会计电算化</option>
                                                <option value="会计学">会计学</option>
                                                <option value="人力资源管理">人力资源管理</option>
                                                <option value="中国革命史与中国共产">中国革命史与中国共产</option>
                                                <option value="中国共产党历史">中国共产党历史</option>
                                            </select>
                </div>
            </div>
            <div class="form-group">
                <label for="province" class="control-label col-sm-3"><span style="color:#F65F6B;">*</span> 籍贯: </label>
                <div class="col-sm-3">
                    <select id="province"  name="province" class="form-control prov" >
                     <option value="">选择您的籍贯</option>
                      <% 
                         String sql="select *from province";
                         ResultSet rs=conn.exequery(sql); 
                         while(rs.next())
                          {
                          %>
                    
                   <option value="<%=rs.getString("name") %>"><%=rs.getString("name") %></option>
                 
                      <%} %>
                    </select>
                </div>
            </div>
           
               <div class="form-group">
                <label for="num" class="control-label col-sm-3">手机号码: </label>
                 <div class="col-sm-5">
                    <input type="text" name="pnum" class="form-control"  placeholder="填写手机号">
                </div>
                </div>
               
                   <div class="form-group">
                <label for="brief" class="control-label col-sm-3">个人简介: </label>
                 <div class="col-sm-5">
                    <textarea  name="brief" rows="5" class="form-control" placeholder="一句话介绍自己吧!"></textarea>
                </div>
                </div>
                
            </div>
 
    <div class="panel-footer">
    <button onclick="return check_form(form)" class="btn btn-danger btn-block">注册</button>
     </form>
    </div>

    
       
    </div>
    </div>
    
    </div>
  </body>
</html>
