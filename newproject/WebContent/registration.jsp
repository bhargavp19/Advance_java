<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="detail2.jsp">
		<center>
			<table style="border: 5px solid black; background-color: pink">
				<tr>
					<td>Firstname :</td>
					<td><input type="text" name="firstname"></td>
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
				<tr>
					<td>Country :</td>
					<td><select name="country">
							<option >select</option>
							<option value="india">india</option>
							<option value="england">england</option>
							<option value="australia">Australia</option>
							<option value="USA">USA</option>
					</select></td>
				</tr>
				<tr>
					<td>Address :</td>
					<td><textarea name="address"></textarea></td>
				</tr>
				<tr>
					<td>Gender :</td>
					<td><input type="radio" value="male" name="gender">Male
						<input type="radio" value="female" name="gender">Female</td>
				</tr>
				<tr><td>hobby :</td>
					<td> <input type="checkbox" value="cricket" name="hobby">cricket
						<input type="checkbox" value="music" name="hobby">music
						<input type="checkbox" value="gaming" name="hobby">gaming
						<input type="checkbox" value="coding" name="hobby">coding</td>
				</tr>
			</table><br>
			
			<button>submit</button>
		</center>
	</form>
</body>
</html>