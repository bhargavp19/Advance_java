<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hiii
<h1>1st prg</h1>
<%
System.out.println("hii");
out.println("in browser");%><br><%
out.println("for loop");%><br><%
		for(int i=1;i<=50;i++){
			if(i%2==0){
			%><div style=" width:50px ; height:40px; border:1px solid; background-color:blue" ></div>
			<br><%}
			else{%>
			<div style=" width:50px ; height:40px; border:10px solid; background-color:red" ></div>
			<br><%}
		}
%>
</body>
</html>
