<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="save4.jsp">
firstname:
<input type="text" name="firstname"><br>
lastname:
<input type="text" name="lastname"><br>
permanent address:
<jsp:include page="add.jsp">
<jsp:param value="p" name="a"/>
</jsp:include><br>
residential address:
<jsp:include page="add.jsp">
<jsp:param value="r" name="a"/>
</jsp:include><br>
<button>submit</button>
</form>
</body>
</html>