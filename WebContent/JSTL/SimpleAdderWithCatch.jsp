<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple Adder with Catch</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>

<h2>
	${ param.num1 } / ${ param.num2 } = 
	<c:catch var="e">
		${ param.num1 / param.num2 }
	</c:catch>
</h2>

<c:if test="${e != null}">
	<p class="bg-danger">
		Invalid parameter values
	</p>
</c:if>

</body>
</html>