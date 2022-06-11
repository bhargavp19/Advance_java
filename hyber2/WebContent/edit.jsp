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

<c:forEach items="${sessionScope.list}" var="i">
<form action="RegController" method="post">
FirstName : <input type="text" name="firstname" value="${i.firstname}"><br>
Lastname :<input type="text" name="lastname" value="${i.lastname}"><br>
UserName : <input type="text" name="username" value="${i.loginVo.username}"><br>
Password :<input type="text" name="password" value="${i.loginVo.password}"><br>
<input type="hidden" name="flag" value="update">
<input type="hidden" name="regid" value="${i.id}">
<input type="hidden" name="loginid" value="${i.loginVo.id}">
<button>submit</button>
</form>
</c:forEach>
</body>
</html>