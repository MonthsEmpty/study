<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL</title>
</head>
<body>
<c:if test="${aaa=='123'}">
aaa=123
</c:if>
<br/>
${aaa == '123'?"123111":"12321" }
<br/>
<c:forEach var="x" begin="1" end="5">
${x }
</c:forEach>
</body>
</html>