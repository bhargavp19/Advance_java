<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String firstname=request.getParameter("firstname");
	String lastname=request.getParameter("lastname");
	String username=request.getParameter("username");
	String pwd=request.getParameter("password");
	String cntr=request.getParameter("country");
	String address=request.getParameter("address");
	String gender=request.getParameter("gender");
	String[] hobby=request.getParameterValues("hobby");
	out.println("firstname :"+firstname);%><br><%
	out.println("lastname :"+lastname);%><br><%
	out.println("usernam:"+username);%><br><%
	out.println("pwd :"+pwd);%><br><%
	out.println("country :"+cntr);%><br><%
	out.println("address :"+address);%><br><%
	out.println("gender :"+gender);%><br><%
	out.println("hobby :");%><br><%
	
	if(hobby==null){
		out.println("empty");
	}
	else{
	for(String s:hobby){
	out.println(s);
	}
	}%><br>

</body>
</html>