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

<c:forEach items="${sessionScope.listed}" var="i">
<form action="CntryController" method="post">
Country_name : <input type="text" name="firstname" value="${i.cntry_name}"><br>
Country_Desc :<input type="text" name="lastname" value="${i.cntry_desc}"><br>

<input type="hidden" name="flag" value="update">
<input type="hidden" name="id" value="${i.id}">

<button>submit</button>
</form>
</c:forEach>
</body>
</html>