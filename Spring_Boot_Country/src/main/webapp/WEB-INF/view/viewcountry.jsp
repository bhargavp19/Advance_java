<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="2">
<tr>
<td>Country name </td>
<td>Country Description </td>
<td colspan="2">Actions </td>
</tr>
<c:forEach items="${country}" var="i">
<tr>
<td>${i.cntry_name}</td>
<td>${i.cntry_desc}</td>
<td><a href="deletecountry?id=${i.id}" >Delete</a></td>
<td><a href="editcountry?id=${i.id}" >Edit</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>