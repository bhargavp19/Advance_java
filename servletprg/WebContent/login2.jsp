<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><form action="verify">
<center>
<table>
				<tr>
					<td>Username :</td>
					<td><input type="text" name="username2"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password2"></td>
				</tr>
		</table>
		<button>submit</button></center></form>
</body>
</html>
<%
	String x=(String)session.getAttribute("f");
	if(x!=null){
		out.println("wrong");
		session.removeAttribute("f");
	}
%>