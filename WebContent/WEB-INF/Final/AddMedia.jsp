<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<div class="container">

	<div class="page-header">
	<tr><td><a href=DisplayMedia>Display</a></td><tr>
	  <h1>Add Media's <small>CS 320</small></h1>
	</div>
	
	
	<form action="AddMedia" method="get" class="form-inline">
	  <div class="form-group">
	  <label>Name/Title: </label>
	  <input type="text" name="title" class="form-control" placeholder = "Name/Title"/>
	    <label>Type: </label>
	    <select id="mySelect" name ="type">
	    <option selected="selected" name="SelectOne">--SelectOne--</option>
        <option>CD</option>
        <option>DVD</option>
        <option>BluRay</option>
</select>
	    
	  </div>	  
	  <button type="submit" name = "add" class="btn btn-default">Add</button>
	  
	  <c:if test="${param.add }">
		<tr><td>Media Added Successfully</td></tr>
	</c:if>
	</form>
	
	<hr />
	
	
</div>

</body>
</html>