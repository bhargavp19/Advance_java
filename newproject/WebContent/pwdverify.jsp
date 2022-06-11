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
String oldpd=request.getParameter("oldpwd");
String newpd=request.getParameter("newpwd");
String cnfmpd=request.getParameter("cnfmpwd");
String dbpwd=(String)session.getAttribute("pw");
String un=(String)session.getAttribute("un");
int id=(Integer)session.getAttribute("id");

if(dbpwd.equals(oldpd) && newpd.equals(cnfmpd)){
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3307/bhargav","root","root");
	Statement s=c.createStatement();
	s.executeUpdate("update login set password='"+cnfmpd+"' WHERE id='"+id+"'");
	s.close();
	c.close();
	session.setAttribute("donepwd","password change successfully");
	response.sendRedirect("login4.jsp");
	
}
else{
	session.setAttribute("wrong","password doesn't match");
	response.sendRedirect("changepwd.jsp");
}



%>
</body>
</html>