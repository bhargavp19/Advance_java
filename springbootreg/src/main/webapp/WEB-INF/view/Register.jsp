<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<body>

<f:form action="insert" method="post" modelAttribute="regVo">
FirstName : <f:input path="firstname"/><br>
LastName : <f:input path="lastname"/><br>
UserName : <f:input path="loginVo.username"/><br>
Password : <f:password path="loginVo.password"/><br>
<f:hidden path="id"/>
<button>Submit</button>

</f:form><br>
<a href="search">SEARCH</a>

</body>
</html>