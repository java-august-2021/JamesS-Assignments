<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Dojo</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
<h1>New Dojo</h1>
	<div class="form-group">
		<form:form method="POST" action="/dojos/new" modelAttribute="dojo">
		<form:label path="name">Name</form:label>
		<form:input path="name"/>
		<button type="submit">Create</button>
		</form:form>
	</div>
	
</div>
</body>
</html>