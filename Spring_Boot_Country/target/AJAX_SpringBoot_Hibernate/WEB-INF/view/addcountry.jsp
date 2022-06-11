<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<body>
<f:form action="insertcountry" method="post" modelAttribute="countryVO">

Country Name : <f:input path="cntry_name"/><br>

Country Description : <f:input path="cntry_desc"/><br>

<f:hidden path="id"/>
<button>submit</button>
</f:form>
</body>
</html>