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
String fn=request.getParameter("firstname");
String ln=request.getParameter("lastname");
String un=request.getParameter("username");
String pwd=request.getParameter("password");
String cntr=request.getParameter("country");
String addr=request.getParameter("address");
String gen=request.getParameter("gender");

String[] hobby=request.getParameterValues("hobby");
String hb="";
if(hobby!=null){
for(String y:hobby){
	hb=hb+y+",";
}}
else{
	hb=null;
}

Class.forName("com.mysql.jdbc.Driver") ;
Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav","root","root");
Statement s=c.createStatement();
s.executeUpdate("INSERT INTO bio (firstname,lastname,username,password,country,address,gender,hobby) VALUES('"+fn+"','"+ln+"','"+un+"','"+pwd+"','"+cntr+"','"+addr+"','"+gen+"','"+hb+"') ");
s.close();
c.close();
%>
</body>
</html>