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
String id=request.getParameter("id");
out.println(id);
session.setAttribute("id",id);
Class.forName("com.mysql.jdbc.Driver");

Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav","root","root");
Statement s = c.createStatement();
ResultSet r= s.executeQuery("select * from login Where id='"+id+"'");
while(r.next()){
	int i=r.getInt("id");
	String fn=r.getString("firstname");
	String ln=r.getString("lastname");
	
%>
<form action="update?id=<%out.println(id);%>&">
<table>
<tr>
					<td>Firstname :</td>
					<td><input type="text" name="firstname" value="<%out.println(fn); %>"></td>
				</tr>
				<tr>
					<td>Lastname :</td>
					<td><input type="text" name="lastname" value="<%out.println(ln);%>"></td>
				</tr>
				<tr>
				<td><button>submit</button></td>
				</tr>
				</table></form><%} %>
</body>
</html>