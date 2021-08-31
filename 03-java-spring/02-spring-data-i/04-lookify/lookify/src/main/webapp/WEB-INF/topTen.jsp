<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
	<div class="header">
		<a>Top Ten Songs:</a>
		<a href="/dashboard">Dashboard</a>
	</div>
	<hr>
	
	<div id="topTenBox">
		<c:forEach items="${topSongs}" var="song">
		<h5>${song.rating} - ${song.title} - ${song.artist}</h5>
		</c:forEach>	
	</div>
</div>
</body>
</html>