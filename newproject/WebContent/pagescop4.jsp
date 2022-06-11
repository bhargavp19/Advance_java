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
String s1=(String)request.getAttribute("abc");
String s2=(String)session.getAttribute("xyz");
int i=(Integer)application.getAttribute("pqr");
Integer i2=(Integer)session.getAttribute("des");

out.println(s1+" "+s2+" "+i+" "+i2);%><br><br><%


%>
</body>
</html>
