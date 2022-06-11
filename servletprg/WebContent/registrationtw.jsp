<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="twinsert">
		
			<table style="border: 5px solid black; background-color: pink">
				<tr>
					<td>Firstname :</td>
					<td><input type="text" name="firstname"
					></td>
				</tr>
				<tr>
					<td>Lastname :</td>
					<td><input type="text" name="lastname"></td>
				</tr>
				<tr>
					<td>Username :</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr><input type="hidden" name="flag" value="insert"></tr>
			</table>
			<button>submit</button>
	</form>
</body>
</html>