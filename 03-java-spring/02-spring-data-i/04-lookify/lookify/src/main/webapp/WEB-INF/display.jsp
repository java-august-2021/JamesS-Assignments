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
<a href="/dashboard">Dashboard</a>
</div>
<hr>

<div class="content">

	<h3>Title: <c:out value="${song.title}"/></h3>
	<h3>Artist: <c:out value="${song.artist}"/></h3>
	<h3>Rating (1-10): <c:out value="${song.rating}"/></h3>
	<hr>
	
	<form action="/<c:out value="${song.id}"/>/delete" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>
	
</div>
</div>
</body>
</html>