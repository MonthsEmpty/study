<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello</title>
</head>
<script type="text/javascript">
alert("123")
</script>
<body>
We operate in these countries
<ul>
<c:out value="${11 }"></c:out>
 <%-- <c:forEach></c:forEach> --%>
	<%-- <c:forEach item="${countries }" var="country">
		<li></li>
	</c:forEach> --%>
</ul>

<form action="" enctype="">
	<input type="file">
</form>
</body>
</html>