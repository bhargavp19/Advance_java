<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>

<table>
<tr>
<td>Firstname</td>
<td>Lastname</td>
<td>Username</td>
<td>password</td>
<td colspan="2">Actions</td>
</tr>

<c:forEach items="${data }" var="i">
<tr>
	<td>${i.firstname }</td>
	<td>${i.lastname }</td>
	<td>${i.loginVo.username }</td>
	<td>${i.loginVo.password }</td>
	<td><a href="delete2?id=${i.id}&loginid=${i.loginVo.id}">delete</a></td>
	<td><a href="edit?id=${i.id}">edit</a></td>
	
</tr>
</c:forEach>

</table>

</body>
</html>