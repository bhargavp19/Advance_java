<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jstl/sql_rt"%>

<s:setDataSource driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3307/bhargav" password="root" user="root" var="i" scope="session"/>
<s:update dataSource="${i}">insert into testtbl (firstname,lastname) values("lebron","james")</s:update>
<s:query var="i1" dataSource="${i}" sql="select * from testtbl"></s:query>

<c:forEach items="${i1.rows}" var="i2">

${i2.firstname}
${i2.lastname}<br>
</c:forEach>
</body>
</html>