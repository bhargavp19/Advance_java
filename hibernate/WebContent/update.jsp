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
<c:forEach  items="${sessionScope.update}" var="i">
<form action="RegController" method="post">
<input type="text" name="firstname" value="${i.firstname}">
<input type="text" name="lastname" value="${i.lastname}">
<input type="hidden" name="flag" value="update">
<input type="hidden" name="id" value="${i.id}">
<button>submit</button>
</form>
</c:forEach>
</body>
</html>