<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Question</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">

	<div class="header">
	<h1>What is your question?</h1>
	</div>
	
	<div class="content">
		<form action="/questions/create" method="POST" style="width:500px">
			<div class="mb-3">
				<label for="question" class="form-label">Question:</label>
				<textarea rows="5" cols="10" name="question" class="form-control"></textarea>
			</div>
			<div class="mb-3">
				<label for="tag" class="form-label">Tags: </label>
				<input name="tag" class="form-control">
			</div>
			<button type="submit">Add</button>
		</form>
		<br>
		<c:forEach items="${error}" var = "err">
			<p style="color:red" >${err}</p>
		</c:forEach>
	</div>
	
	<div class="footer">
	</div>
</div>
</body>
</html>