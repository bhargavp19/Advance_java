<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
<% 
String s1=request.getParameter("firstname");
String s2=request.getParameter("lastname");
String s3=request.getParameter("username");
String s4=request.getParameter("password");


session.setAttribute("firstname",s1);
session.setAttribute("lastname",s2);
session.setAttribute("username",s3);
session.setAttribute("password",s4);
response.sendRedirect("login2.jsp");
%>