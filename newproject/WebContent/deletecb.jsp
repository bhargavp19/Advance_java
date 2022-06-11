<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String[] s1=request.getParameterValues("chbox");

Class.forName("com.mysql.jdbc.Driver") ;
Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav","root","root");
Statement s=c.createStatement();
for(String y:s1){
s.executeUpdate("DELETE FROM student WHERE id='"+y+"'");
}
s.close();
c.close();
response.sendRedirect("dbsearch5.jsp");
%>
</body>
</html>