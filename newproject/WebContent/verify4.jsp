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
String s3=request.getParameter("uname");
String s4=request.getParameter("pword");
int flag=0;
Class.forName("com.mysql.jdbc.Driver") ;
Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav","root","root");
Statement s=c.createStatement();
ResultSet r=s.executeQuery("select * from login where username='"+s3+"' and password='"+s4+"'");
while(r.next()){
	String s1=r.getString("username");
	String s2=r.getString("password");
	String fn=r.getString("firstname");
	String ln=r.getString("lastname");
	int id=r.getInt("id");
	if(s1.equals(s3) && s2.equals(s4)){
		response.sendRedirect("welcome4.jsp");
		session.setAttribute("pw",s2);
		session.setAttribute("id",id);
		session.setAttribute("fn",fn);
		session.setAttribute("ln",ln);
		flag=1;
	}
}
if(flag!=1){
	session.setAttribute("invalid","invalid username and password");
	response.sendRedirect("login4.jsp");
}
s.close();
c.close(); %>
</body>
</html>