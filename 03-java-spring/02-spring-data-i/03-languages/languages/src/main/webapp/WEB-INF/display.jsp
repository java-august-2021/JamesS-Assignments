<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dispaly Page</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
<body>


<div class="container">
<div class="header" dir="rtl">
	<a href="/languages"><button>Dashboard</button></a>
</div>

<fieldset>
<h4>Name: <c:out value="${language.name}"/></h4>
<h4>Creator: <c:out value="${language.creator}"/></h4>	
<h4>Version: <c:out value="${language.version}"/></h4>	
</fieldset>

<hr>
<form action="/languages/<c:out value="${language.id}"></c:out>/delete" method="POST">
   	<input type="hidden" name="destroy" value="delete">
   	<input type="submit" value="Delete">
</form>	
<a href="/languages/<c:out value="${language.id}"></c:out>/edit">Edit</a>

</div>

</body>
</html>