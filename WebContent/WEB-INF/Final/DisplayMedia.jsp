<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">
	<div class="page-header">
	  <h1>List of All Media <small>CS 320</small></h1>
	</div>
	
	<form action="DisplayMedia" method="get" class="form-inline">
	  <div class="form-group">
	    <label>Search Term</label>
	    <input type="text" name="title" class="form-control" />
	  </div>	  
	  <button type="submit" class="btn btn-default">Search</button>
	</form>
	
	<hr />
	
	<table class="table table-striped table-bordered table-hover">
		<tr>
			<th>Name</th>
			<th>Date Added</th>
			<th>Borrower</th>
			<th>Date Borrowed</th>
		</tr>
		<h1>Compact Discs</h1>
		<c:forEach items="${ MediaBeans }" var="user">
		<c:if test="${ user.type == 'CD' }">
			<tr>
			
				<td>${ user.title }</td>
				<td>${ user.date }</td>
				
		     <td>${ user.borrower }</td>
		     
				<td>${ user.lent }</td>
				
			</tr>	
		</c:if>
		
		
		</c:forEach>
	
	</table>
	
	<table class="table table-striped table-bordered table-hover">
		<tr>
			<th>Name</th>
			<th>Date Added</th>
			<th>Borrower</th>
			<th>Date Borrowed</th>
		</tr>
		<h1>DVD</h1>
		<c:forEach items="${ MediaBeans }" var="user">
		<c:if test="${ user.type == 'DVD' }">
			<tr>
			
				<td>${ user.title }</td>
				<td>${ user.date }</td>
				<td>${ user.borrower }</td>
				<td>${ user.lent }</td>
				
			</tr>	
		</c:if>
		
		</c:forEach>
	
	</table>
	<table class="table table-striped table-bordered table-hover">
		<tr>
			<th>Name</th>
			<th>Date Added</th>
			<th>Borrower</th>
			<th>Date Borrowed</th>
		</tr>
		<h1>BluRay</h1>
		<c:forEach items="${ MediaBeans }" var="user">
		<c:if test="${ user.type == 'BluRay' }">
			<tr>
			
				<td>${ user.title }</td>
				<td>${ user.date }</td>
				<td>${ user.borrower }</td>
				<td>${ user.lent }</td>
				
			</tr>	
		</c:if>
		
		
		
		</c:forEach>
	
	</table>
</div>




</body>
</html>