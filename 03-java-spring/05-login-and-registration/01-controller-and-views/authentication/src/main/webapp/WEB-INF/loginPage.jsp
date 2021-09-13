<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
	<h1>Login</h1>
	<hr>
	<p><c:out value="${error}"/></p>
	
    <form method="post" action="/login">
	    <div class="form-group">
	     	<label for="email">Email</label>
	        <input type="text" id="email" name="email"/>
	    </div>
	    <div class="form-group">
	    	<label for="password">Password</label>
	        <input type="password" id="password" name="password"/>
	    </div>
	    <input type="submit" value="Login!"/>
    </form>  
</div>
</body>
</html>