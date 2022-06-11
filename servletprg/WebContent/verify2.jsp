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
String un=request.getParameter("username2");
String pw=request.getParameter("password2");


String us2 = (String)session.getAttribute("username");
String ps2 = (String)session.getAttribute("password");

if(us2.equals(un) && ps2.equals(pw)){
	response.sendRedirect("welcome2.jsp");
}
else
{	
	session.setAttribute("f","flag");
	response.sendRedirect("login2.jsp");
}

%>