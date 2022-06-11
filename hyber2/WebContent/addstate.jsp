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
<form method="post" action="CntryController">
<table>
<tr><td>Country Name : </td><td>
<select name="cntry_name">
<c:forEach items="${sessionScope.lists }" var="i">
<option value="${i.id }" > ${i.cntry_name } </option>
</c:forEach>
</select></td>
</tr>
<tr><td>State Name : </td>
<td><input type="text" name="statename" ></td></tr>
</table>
<input type="hidden" name="flag" value="insert_state"> 
<button>submit</button>
</form>
</body>
</html>