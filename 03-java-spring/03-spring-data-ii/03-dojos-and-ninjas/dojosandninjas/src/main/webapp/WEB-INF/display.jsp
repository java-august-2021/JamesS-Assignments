<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos and Ninjas</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
<h1><c:out value="${dojoToDisplay.name}"/> Ninjas</h1>
	<table class="table table-striped">
		<thead>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</thead>
		<tbody>
		<c:forEach items="${allNinjas}" var="ninja">
		<tr>
			<td>${ninja.firstName}</td>
			<td>${ninja.lastName}</td>
			<td>${ninja.age}</td>
		</tr>
		</c:forEach>
		</tbody>
		
	</table>
</div>
</body>
</html>