<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display Users</title>
</head>
<body>

<h2>Users</h2>

<c:if test="${ empty sessionScope.JspUser }">
	<c:redirect url="RegisterController" />
</c:if>

<c:forEach items="${users}" var="user">
	<div class="well">
		<h3>${user.firstName}</h3>
		<p>${user.email}</p>
	</div>
</c:forEach>


</body>
</html>