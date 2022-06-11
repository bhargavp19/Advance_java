<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="pagescop2.jsp">next</a>
</body>
</html>
<%
String q1=request.getParameter("username");
String q2=request.getParameter("lastname");
request.setAttribute("abc",q1);
session.setAttribute("xyz",q2);
application.setAttribute("pqr",123);
session.setAttribute("des",567);
out.println((String)request.getAttribute("abc"));
out.println((String)session.getAttribute("xyz"));
%>