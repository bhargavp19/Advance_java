<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
    String firstname=request.getParameter("firstname");
	String lastname=request.getParameter("lastname");
	String username=request.getParameter("username");
	String pwd=request.getParameter("password");
	out.println("firstname :"+firstname);%>
	<br>
	<%
	out.println("lastname :"+lastname);%><br><%
	out.println("usernam:"+username);%><br><%
	out.println("pwd :"+pwd);%><br>
</body>
</html>