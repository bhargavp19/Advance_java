<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CntryController" method="post">
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
	
	<c:forEach items="${sessionScope.editstate }" var="i">
	State Name : <input type="text" name="state" value="${i.state_name }"><br>
	Country : 
	<select name="cntry">
		<c:forEach items="${sessionScope.cntry }" var="j">
			<option  value="${j.id }" <c:if test="${j.cntry_name == i.cid.cntry_name}"> selected </c:if> >
			 ${j.cntry_name }
			</option>
		</c:forEach>
	</select>
	
	
	<input type="hidden" name="flag" value="updatestate">
	<input type="hidden" name="id" value="${i.id }">
	</c:forEach>
	<button>submit</button>
</form>
</body>
</html>