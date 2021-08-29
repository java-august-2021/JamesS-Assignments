<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Page</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	
	
<body>
	
	<div class="container">
		<div class="header_row">
			<form action="/languages/<c:out value="${language.id}"></c:out>/delete" method="POST">
		    	<input type="hidden" name="destroy" value="delete">
		    	<input type="submit" value="Delete">
			</form>	
			
			<a href="/languages"><button>Dashboard</button></a>	
		</div>
<hr>
		<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
		    <input type="hidden" name="update" value="put">
		    <div class="mb-3">
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </div>
		    <div class="mb-3">
		        <form:label path="creator">Creator</form:label>
		        <form:errors path="creator"/>
		        <form:textarea path="creator"/>
		    </div>
		    <div class="mb-3">
		        <form:label path="version">Version</form:label>
		        <form:errors path="version"/>
		        <form:input path="version"/>
		    </div>
		     
		    <input type="submit" value="Update"/>
		</form:form>
	</div>
</body>
</html>


