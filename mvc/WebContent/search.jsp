<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<table border=1>
<c:forEach items="${sessionScope.list}" var="i">
<tr><td>${i.id }</td>
<td>${i.fn }</td>
<td>${i.ln}</td>
<td><a href="reg?flag=delete&id=${i.id}">delete</a></td>
<td><a href="reg?flag=edit&id=${i.id}">edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>