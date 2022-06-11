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

Class.forName("com.mysql.jdbc.Driver") ;
Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav","root","root");
Statement s=c.createStatement();
ResultSet r =s.executeQuery("SELECT * FROM student");%>
<table><tr><td>id</td><td>firstname</td><td>lastname</td><td>action</td></tr><%
while(r.next()){
	int id=r.getInt("id");
	String fn=r.getString("firstName");
	String ln=r.getString("lastName");
	%>
	<tr><td><%out.println(id);%></td>
		<td><%out.println(fn);%></td>
		<td><%out.println(ln);%></td>
		<td><a href="delete.jsp?id=<%out.println(id);%>">delete</a></td></tr>
<% 
}
s.close();
c.close();
%>
</table>
</body>
</html>