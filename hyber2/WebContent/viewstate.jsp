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
<tr><td> State Name </td><td> Country Name </td> <td> Country desc </td> <td colspan="2"> Actions </td></tr>
<c:forEach items="${sessionScope.lists}" var="i" >
<tr>
<td>${i.state_name} </td>
<td>${i.cid.cntry_name} </td>
<td>${i.cid.cntry_desc} </td>
<td><a href="CntryController?flag=deletestate&id=${i.id}">delete</a></td>
<td><a href="CntryController?flag=editstate&id=${i.id}">edit</a></td>

</tr>
</c:forEach>
</table>
</body>
</html>