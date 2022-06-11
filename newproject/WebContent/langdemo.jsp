<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><center>
<%@taglib prefix="f" uri="http://java.sun.com/jstl/fmt_rt"%>

<br><br><br>

<f:setLocale value="${param.flag}"/>
<f:setBundle basename="m" var="i"></f:setBundle>

<f:message bundle="${i}" key="fn"></f:message>:<input type="text"><br>
<f:message bundle="${i}" key="ln"></f:message>:<input type="text"><br><br><br>
select here
<a href="langdemo.jsp">English</a>
<a href="langdemo.jsp?flag=guj">Gujarati</a>
<a href="langdemo.jsp?flag=hin">hindi</a></center>
</body>
</html>