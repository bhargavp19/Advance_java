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
<f:form action="insertstate" method="post" modelAttribute="stateVO">

State Name : <f:input path="state_name"/><br>

Country  : <f:select path="countryVO.id">
<f:options items="${country}" itemValue="id" itemLabel="cntry_name"/>
</f:select>

<f:hidden path="id"/>
<button>submit</button>
</f:form>

</body>
</html>