<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>

<h3>
	Escaping XML:
	 <c:out value="<em>EscapedXML</em>" />
</h3>

<c:if test="${ !empty param.logout }">
	Logging out
	<c:remove var="user" scope="session" />
</c:if>


<c:if test="${ !empty param.name and !empty param.password }">
	<c:set var="user" value="${ param.name }" scope="session" />
	<c:redirect url="ShoppingCart.jsp" />
</c:if>

<h1>session.user = ${ sessionScope.user }</h1>

<form action="Login.jsp" method="get">
  <div class="form-group">
    <label for="exampleInputEmail1">First Name</label>
    <input name="name" type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter your first name">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>

</body>
</html>