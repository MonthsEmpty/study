<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Implicit Objects</title>
</head>
<body>
<b>Http headers:</b><br/>
<%
	for(Enumeration<String> e = request.getHeaderNames();
			e.hasMoreElements();){
		String header = e.nextElement();
		out.println(header + ": " + request.getHeader(header) + "<br/>");
	}
%>
<hr/>
<%
	out.println("Buffer size: " + response.getBufferSize() + "<br/>");
	out.println("Session id: " + session.getId() + "<br/>");
	out.println("Servlet name: " + config.getServletName() + "<br/>");
	out.println("Server info: " + application.getServerInfo());
%>

</body>
</html>