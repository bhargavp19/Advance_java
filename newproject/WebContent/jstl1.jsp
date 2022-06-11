<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="i" value="hellloo" scope="session"></c:set>
<c:out value="${i}"></c:out>
${i}<br>
<c:forEach begin="1" end="10" var="x">
${x}
</c:forEach><br>
<c:set var="y" value="15"></c:set>
<c:if test="${y lt 20}">${y}</c:if><br>
<c:choose>
<c:when test="${y eq 20}">${y}</c:when>
<c:when test="${y eq 15}">y is equal to 15</c:when>
<c:otherwise>nothing </c:otherwise>
</c:choose><br>
<a href="sescop.jsp"> session</a>
</body>
</html>