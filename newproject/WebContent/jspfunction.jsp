<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="n" value="bhargav panchani"></c:set>
<c:set var="p" value="panchani"></c:set>
<c:set var="s1" value="${fn:length(n)}"></c:set>
${s1}<br>
<c:set var="s2" value="${fn:split(n,' ')}"></c:set>
<c:forEach items="${s2}" var="x" >${x}</c:forEach><br>

<c:set var="s3" value="${fn:join(s2,p)}"></c:set>
${s3}


</body>
</html>