<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>Results</title>
</head>
<body>
	<div class="container">
		<h2>Submitted Info</h2>
		<hr>
		<div class="view_result">
			<label>Name:</label>
			<p><c:out value="${name}"/></p>
		</div>
		<div class="view_result">
			<label>Dojo Location:</label>
			<p><c:out value="${location}"/></p>
		</div>
		<div class="view_result">
			<label>Favorite Language:</label>
			<p><c:out value="${favLanguage}"/></p>
		</div>
		<div class="view_result">
			<label>Comment:</label>
			<p>"<c:out value="${comment}"/>"</p>
		</div>
		<hr>
		<a href="/"><button>Go Back</button></a>	
	</div>
</body>
</html>