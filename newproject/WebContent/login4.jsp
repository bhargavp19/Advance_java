<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><form action="verify4.jsp">
<center><table>

	<tr>
			<td>Username :</td>
			<td><input type="text" name="uname"></td>
	</tr>
	<tr>
			<td>password :</td>
			<td><input type="password" name="pword"></td>
	</tr>
	<tr><td><button>login</button></td></tr>

<tr><td><a href="registration4.jsp">Sign Up</a></td></tr></table></center></form>
<%

String s=(String)session.getAttribute("invalid");

if(s!=null){
	out.println((String)session.getAttribute("invalid"));
	session.removeAttribute("invalid");
}

String s2=(String)session.getAttribute("donepwd");

if(s2!=null){
	session.removeAttribute("pw");
	session.removeAttribute("un");
	session.removeAttribute("id");
	out.println((String)session.getAttribute("donepwd"));
	session.removeAttribute("donepwd");
}

%>
</body>
</html>