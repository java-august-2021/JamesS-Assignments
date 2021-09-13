<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
    <h1>Register!</h1>
    <hr>
    <p><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/registration" modelAttribute="user">
	    <div class="form-group">
	   		<form:label path="email">Email:</form:label>
	        <form:input type="email" path="email"/>
	   	</div>
	    <div class="form-group">
	    	<form:label path="password">Password:</form:label>
	        <form:password path="password"/>
	    </div>
	    <div class="form-group">
	    	<form:label path="passwordConfirmation">Password Confirmation:</form:label>
	        <form:password path="passwordConfirmation"/>
	    </div>
	    <input type="submit" value="Register!"/>
    </form:form>
</div>

    
</body>
</html>