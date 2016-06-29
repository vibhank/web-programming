<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Intro to MySQL</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="container">
	<div class="page-header">
	  <h1>List of All Users <small>CS 320</small></h1>
	</div>
	
	<form action="IntroToMySQL" method="get" class="form-inline">
	  <div class="form-group">
	    <label>Search Term</label>
	    <input type="text" name="query" class="form-control" />
	  </div>	  
	  <button type="submit" class="btn btn-default">Search</button>
	</form>
	
	<hr />
	
	<table class="table table-striped table-bordered table-hover">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Username</th>
			<th>Password</th>
		</tr>
		
		<c:forEach items="${ Users }" var="user">
			<tr>
				<td>${ user.id }</td>
				<td>${ user.first }</td>
				<td>${ user.last }</td>
				<td>${ user.username }</td>
				<td>${ user.password }</td>
			</tr>		
		</c:forEach>
		
	</table>
</div>




</body>
</html>