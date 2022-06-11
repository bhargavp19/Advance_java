<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center>
<%
String s1=(String)session.getAttribute("fn");
String s2=(String)session.getAttribute("ln");

out.println("welcome "+s1+" "+s2);
session.removeAttribute("fn");
session.removeAttribute("ln");
%>

<a href="changepwd.jsp">change password</a>
</center>
</body>
</html>