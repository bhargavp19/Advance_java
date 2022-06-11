<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<body>

<table border="1px solid black">
<tr>
	<td>Id</td>
	<td>State_Name</td>
	<td>Country_Name</td>
	<td>Country_Desc</td>
	<td>Delete</td>
	<td>Edit</td>
</tr>

<c:forEach items="${state}" var="i">
<tr>
	<td> ${i.id}</td>
	<td>${i.state_name }</td>
	<td>${i.countryVO.cntry_name }</td>
	<td>${i.countryVO.cntry_desc }</td>
	<td><a href="deletestate.html?id=${i.id}">Delete</a></td>
	<td><a href="editstate.html?id=${i.id}">Edit</a></td>
</tr>
</c:forEach>

</table>

</body>
</html>