<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<table border="1">
<tr>
<td>FirstName </td>
<td>LastName</td>
<td>UserName</td>
<td>password</td>
<td>Delete</td>
<td>Edit</td>
</tr>
<c:forEach items="${data }" var="i">
<tr>
<td>${i.firstname }</td>
<td>${i.lastname }</td>
<td>${i.loginVO.username}</td>
<td>${i.loginVO.password }</td>
<td><a href="deleteforeign.html?regid=${i.id}&loginid=${i.loginVO.id}">Delete</a>
<td><a href="editforeign.html?id=${i.id}">Edit</a>
</tr>
</c:forEach>

</table>
</body>
</html>