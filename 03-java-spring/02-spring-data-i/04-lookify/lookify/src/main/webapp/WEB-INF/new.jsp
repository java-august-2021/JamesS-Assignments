<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Song</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
	<div class="header">
	<a href="/dashboard">Dashboard</a>
	</div>
	
	<hr>
	<div class="content">
		<form:form method = "POST" action="/create" modelAttribute="song">
		<div class="form">
			<div class="mb-3">
				<form:label path="title">Title</form:label>
				<form:errors path="title"></form:errors>
				<form:input path="title" type="text"/>
			</div>
			<div class="mb-3">
				<form:label path="artist">Artist</form:label>
				<form:errors path="artist"></form:errors>
				<form:input path="artist" type="text"/>
			</div>
			<div class="mb-3">
				<form:label path="rating">Rating (1-10)</form:label>
				<form:errors path="rating"></form:errors>
				<form:select path="rating" type="number">
					<form:option value="1">1</form:option>
					<form:option value="2">2</form:option>
					<form:option value="3">3</form:option>
					<form:option value="4">4</form:option>
					<form:option value="5">5</form:option>
					<form:option value="6">6</form:option>
					<form:option value="7">7</form:option>
					<form:option value="8">8</form:option>
					<form:option value="9">9</form:option>
					<form:option value="10">10</form:option>
				</form:select>	
			</div>
		</div>
		<button type="submit">Submit</button>
		</form:form>	
	</div>
</div>

</body>
</html>