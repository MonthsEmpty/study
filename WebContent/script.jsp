<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 脚本元素</title>
</head>
<body>
<h1>一：Scriptlet</h1>
<%
	out.println("Buffer size: " + response.getBufferSize() + "<br/>");
	out.println("Session id: " + session.getId() + "<br/>");
	out.println("Servlet name: " + config.getServletName() + "<br/>");
	out.println("Server info: " + application.getServerInfo());
%>
<h1>二：表达式</h1>
Today is <%=Calendar.getInstance().getTime() %><br/>
上面这个表达式和下面这个是一样的<br/>
Today is 
<%
	out.print(Calendar.getInstance().getTime());
%><br/>
对于表达式，JSP容器会先运算Calendar.getInstance().getTime()然后将结果传给out.print()
<h1>三：声明</h1>
<%!
	public String getTodayDate(){
		return new Date().toString();
	}
%>
Today is <%=getTodayDate() %>>
<%!

	String a = "11";
	public void jspInit(){
		System.out.print("jspInit...");
	}
	public void jspDestroy(){
		System.out.print("jspDestory...");
	}
%>

<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- <a href="<%=path %>">sss</a> --%>
<%=path %>
<%=basePath %>
</body>
</html>