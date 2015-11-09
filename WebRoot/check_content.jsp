<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,java.text.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="conn" scope="page" class="yb.conn"/>
<%
request.setCharacterEncoding("utf-8");
if(session.getAttribute("userkey")!=null)
{
int id=(Integer)session.getAttribute("userkey");
Connection c=null;
Statement p=null;
String date=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime());
String content=request.getParameter("content");
String to=request.getParameter("to");
String from=request.getParameter("from");
c=conn.getCon();
String sql="insert into love_info values('"+id+"','"+from+"','"+to+"','"+content+"',0,'"+date+"')";
boolean k=conn.executeupdate(sql);


if(k)
{
	out.println("<script>alert('发布成功！');window.location.href='index.jsp';</script>");
}
else
{
	out.println("<script>alert('发布失败！');window.location.href='index.jsp';</script>");
}
}
else
{
out.println("<script>alert('您还没登录，请先登录！');window.location.href='login.jsp';</script>");
}
%>
</body>
</html>