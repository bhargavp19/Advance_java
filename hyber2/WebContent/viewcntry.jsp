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
<tr><td> cntry_name </td> <td>cntry_desh </td> </tr>
<c:forEach items="${sessionScope.lists}" var="i" >
<tr>
<td>${i.cntry_name} </td>
<td>${i.cntry_desc} </td>
<td><a href="CntryController?flag=delete&id=${i.id}">delete</a></td>
<td><a href="CntryController?flag=edit&id=${i.id}">edit</a></td>

</tr>
</c:forEach>
</table>
</body>
</html>