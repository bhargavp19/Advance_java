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
String s1="bhargav";
String s2="bh1234";
String un=request.getParameter("username");
String pwd=request.getParameter("password");
if(un.equals(s1) && pwd.equals(s2)){
	response.sendRedirect("welcome.jsp");
}
else{
	response.sendRedirect("login.jsp");
}
%>