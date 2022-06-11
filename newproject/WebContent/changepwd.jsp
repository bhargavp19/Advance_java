<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center>
<form action="pwdverify.jsp">
<table>

	<tr>
			<td>old password :</td>
			<td><input type="password" name="oldpwd"></td>
	</tr>
	<tr>
			<td>new password :</td>
			<td><input type="password" name="newpwd"></td>
	</tr>
	<tr>
			<td>confirm password :</td>
			<td><input type="password" name="cnfmpwd"></td>
	</tr>
	<tr><td><button>submit</button></td></tr>
</table></form>
<%

String s=(String)session.getAttribute("wrong");
if(s!=null){
	
	out.println((String)session.getAttribute("wrong"));
	session.removeAttribute("wrong");
}
%></center>
</body>
</html>