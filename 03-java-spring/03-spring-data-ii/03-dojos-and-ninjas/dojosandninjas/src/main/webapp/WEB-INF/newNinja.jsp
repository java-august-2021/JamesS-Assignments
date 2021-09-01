<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Ninja</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
<h1>New Ninja</h1>
	<form:form method="POST" action="/ninjas/new" modelAttribute="ninja">
	<div class="form-group">
		<form:label path="dojo">Dojo</form:label>
		<form:select path="dojo">
			<c:forEach items="${allDojos}" var="dojo">
				<form:option value="${dojo.id}">${dojo.name}</form:option>
			</c:forEach>
		</form:select>
	</div>
	<div class="form-group">
	
		<form:label path="firstName">First Name</form:label>
		<form:input path="firstName"/>
		
	</div>
	<div class="form-group">
	
		<form:label path="lastName">Last Name</form:label>
		<form:input path="lastName"/>
		
	</div>
	<div class="form-group">
	
		<form:label path="age">Age</form:label>
		<form:input path="age"/>
		
	</div>
	<button type="submit">Create</button>
	</form:form>
</div>
</body>
</html>