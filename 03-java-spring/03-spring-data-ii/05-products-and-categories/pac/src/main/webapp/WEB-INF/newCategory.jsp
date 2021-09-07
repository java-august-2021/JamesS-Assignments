<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Category</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
	<h1>Create New Category</h1>
	<hr>
	<div class="form-group">
		<form:form action="/categories/new" method="POST" modelAttribute="category">
		<form:label path="name">Name</form:label>
		<form:errors path="name"/>
		<form:input path="name"/>
		<button type="submit">Create Category</button>
		</form:form>
	</div>
</div>
</body>
</html>