<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>The Code Home</title>
	</head>
	<body>	
	<div class="container">
		<h3 id="error_message"><c:out value="${error}"/></h3>
		<h3>What is the code?</h3>
		
		<form action="/access" method="POST">
			<input type="text" name="input">
			<button>Try Code</button>
		</form>
	</div>	
	</body>
</html>