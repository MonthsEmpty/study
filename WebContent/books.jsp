<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book List</title>
<style>
table, tr,td{
	border: 1px solid brown;
}
</style>
</head>
<body>
Books in Simple Table
<table>
	<tr>
		<td>ISBN</td>
		<td>Title</td>
	</tr>
	<c:forEach var = "book" items="${books }">
		<tr>
			<td>${book.isbn }</td>
			<td>${book.title }</td>
		</tr>
	</c:forEach>
</table>
<br>
Books in Styled Table
<table>
	<tr style="background: #ababff">
		<td>ISBN</td>
		<td>Title</td>
	</tr>
	<c:forEach var = "book" items="${books }" varStatus="status">
		<c:if test="${status.count%2 == 0 }">
			<tr style="background: #eeeeff">
		</c:if>
		<c:if test="${status.count%2 != 0 }">
			<tr style="background: #dedeff"> 
		</c:if>
		<td>ISBN</td>
		<td>Title</td>
	<tr>
	</c:forEach>
</table>
<br>
ISBNs only:
	<c:forEach items="${ }">
		
	</c:forEach>
</body>
</html>