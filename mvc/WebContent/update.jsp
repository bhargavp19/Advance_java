<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<form action="reg" method="post">
<c:forEach items="${sessionScope.list}" var="i">
<input type="text" value="${i.fn }" name="firstname">
<input type="text" value="${i.ln }" name="lastname">
<input type="hidden" value="update" name="flag">
<input type="hidden" value="${i.id }" name="id">
<button>submit</button>
</c:forEach>
</form>
</body>
</html>