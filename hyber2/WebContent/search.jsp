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
<table border=1>
<tr><td> firstname </td> <td>lastname </td> <td>Username</td><td> Password</td></tr>
<c:forEach items="${sessionScope.list}" var="i" >
<tr>
<td>${i.firstname} </td>
<td>${i.lastname} </td>
<td>${i.loginVo.username}</td>
<td>${i.loginVo.password}</td>
<td><a href="RegController?flag=delete&regid=${i.id}&loginid=${i.loginVo.id}">delete</a></td>
<td><a href="RegController?flag=edit&regid=${i.id}">edit</a></td>

</tr>
</c:forEach>
</table>
</body>
</html>